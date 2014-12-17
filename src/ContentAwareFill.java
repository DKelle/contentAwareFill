import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ContentAwareFill extends JComponent{

//int
	private int x = 0;


	public static void main(String[] args){

		new ContentAwareFill();
	}


	public ContentAwareFill(){

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

	public void paintComponent(Graphics g){
		x+=1;
		super.paintComponent(g);
		g.setColor(Color.black);

		g.drawRect(0,0,x,10);
	}
}