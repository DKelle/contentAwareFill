import java.awt.image.BufferedImage;

public class ContentAwareManager{

//Frame
	private ContentAwareFrame frame;

//Fill
	private ContentAwareFill fill;

	public static void main(String[] args){
		new ContentAwareManager(args[0]);

	}

	public ContentAwareManager(String imageDirectory){
		frame = new ContentAwareFrame(imageDirectory);
		BufferedImage img = frame.getImage();

		img = fill.processImage(img);

		frame.setImage(img);
	}
}