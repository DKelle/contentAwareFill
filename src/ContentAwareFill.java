import java.util.*;
import java.awt.image.BufferedImage;

public class ContentAwareFill{

//int
	private final int NORTH = 0;
	private final int WEST = 1;
	private final int NORTHWEST = 2;

//HashMap
	//Remember these three surrounding pixels for any given pixel
	private HashMap<Integer, Integer> north;
	private HashMap<Integer, Integer> west;
	private HashMap<Integer, Integer> north_west;

//Array
	private HashMap[] surroundings = new HashMap[] {north, west, north_west};


	public ContentAwareFill(){

	}

	public BufferedImage processImage(BufferedImage img){
		return img;
	}
}