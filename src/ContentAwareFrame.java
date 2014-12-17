import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class ContentAwareFrame extends JComponent{

//int
	private int x = 0;

//Image
	private BufferedImage img = null;


	public static void main(String[] args){
		for(int i = 0; i < args.length; i ++){
			System.out.println("args[i] = " + args[i]);
		}

		new ContentAwareFrame(args[0]);

	}

	/**
	 *	Initialzies the ContentAwareFrame object
	 *
	 *	@Param imageDirectory - The directory at which out desired image is located
	 */
	public ContentAwareFrame(String imageDirectory){

		initJFrame();

		//The image directory should be passed in as a command line arg
		LoadImage(imageDirectory);

	}

	/**
	 *	Initializes the JFrame 
	 *	Includes setting up the mouseMotionListener, and a timer that will run repaint on a 60 millisecond interval
	 *
	 */
	public void initJFrame(){
		//Set up the JFrame
		JFrame j = new JFrame();
		j.setSize(500, 100);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Make sure we recognize mouse movements
		this.addMouseMotionListener(new MouseMotionListener(){
			public void mouseMoved(MouseEvent e){
				
			}
			public void mouseDragged(MouseEvent e){
				
			}
		});

		//Repaint happens every 60 milliseconds. This may not be neccessary
		//We maybe want repaint to run only after new pixel colors have been determined
		Timer t = new Timer(60, new ActionListener(){
			public void actionPerformed(ActionEvent e){
				repaint();
			}
		});

		t.start();


		j.add(this);

		j.setVisible(true);


	}

	/**
	 *	This will grab the image, and make calls to the methods that will read the pixel colors
	 *
	 *	@Param imageDirectory - The directory at which out desired image is located
	 */
	public void LoadImage(String imageDirectory){
		System.out.println("Looking in directory: " + imageDirectory); 
		try {
			img = ImageIO.read(new File(imageDirectory));
		} catch (Exception e) {
			System.out.println("Coudln't find: " + imageDirectory);
		}
	}

	public Image getImageResource(String name) {

		String url = ""+getClass().getResource(name);
		if (url.equals("null")||url==null) {
			System.out.println("DEBUG: image resource name: " + name);
			System.out.println("DEBUG: image resource url: " + url);
		}

		Image tbr = null;

		try {

			tbr = Toolkit.getDefaultToolkit().getImage(getClass().getResource(name));

			long startTime = System.currentTimeMillis();
			while (tbr.getWidth(this)<1 && System.currentTimeMillis() < startTime + 5000) {}

		} catch (Exception e) {
			System.out.println("Exception thrown for image " + name + ": ");
			e.printStackTrace();
		}

		return tbr;
	}

	public void paintComponent(Graphics g){
		x+=1;
		super.paintComponent(g);
		g.setColor(Color.black);

		if(img != null){
			g.drawImage(img, 0, 0, this);
		}else{
			System.out.println("image is null");
		}

		g.drawRect(0,0,x,10);
	}
}