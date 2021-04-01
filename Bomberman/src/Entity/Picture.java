package Entity;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Picture {
	static final int SIZE=64;
	int[] picPixels;
	
	public static Picture bomber=new Picture ( "/images/bomber.png");
	public static Picture bomb=new Picture ("/images/bomb.png");
	public static Picture hardBlock=new Picture("/images/hardBlock.png");
	public static Picture softBlock=new Picture("/images/softBlock.png");
	public static Picture emptyBlock=new Picture("/images/emptyBlock.png");
	public static Picture enemy=new Picture("/image/enemy.png");
	
	public BufferedImage image;
	public Picture(String path){
		load(path);
		picPixels=new int[SIZE*SIZE];
	}
	
	private void load(String path) {
		
		try {
			image = ImageIO.read(Picture.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, picPixels, 0, w);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
