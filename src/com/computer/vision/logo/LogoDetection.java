package com.computer.vision.logo;

import java.awt.MouseInfo;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.sikuli.script.App;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class LogoDetection {
	
	public static void main(String args[]){
		
//		App.open("https://www.paypal.com/in/home", 5000);
		
		
		App.open("https://www.paypal.com/in/home");
		
		Screen scr = new Screen();
		
		Pattern p = new Pattern("C:\\SikuliImages\\paypalbutton.png");
		
		String filename = p.getFilename();
		
		System.out.println(" The filename is : " + filename);
		
	    Pattern similarptr = p.similar(0.8);
		
		Pattern exact = p.exact();
		
		
		if(similarptr.isValid() || exact.isValid() || exact.isImagePattern() ){
			System.out.println(" Bingo there exists paypal button in this image");
		}
       
	}
	
	public static void screenClipUser() throws IOException{
		
	    org.sikuli.script.Screen screen = Screen.getPrimaryScreen();
	    org.sikuli.script.Region region = screen.selectRegion("Select Area to capture as Image");
	    ScreenImage clip = region.getLastScreenImage(); // screen.userCapture();
	    ScreenImage printScreen = region.getScreen().capture();
	    javax.imageio.ImageIO.write(clip.getImage(), "PNG", new File("C:\\SikuliImages\\Clip.png"));
	    ImageIO.write(printScreen.getImage(), "PNG", new File("C:\\SikuliImages\\PrintScreen.png"));
	    screenCaptureRegion(screen);
	}
	
	public static void screenCaptureRegion(Screen screen) throws IOException{
		
	    java.awt.Point point = MouseInfo.getPointerInfo().getLocation();
	    System.out.println("Mouse Location Co-Ordinates Previous Selected : " + point);
	    
	    
	    /*
	     * Mouse movement of point x and point y -> Listener class
	     */
	    
	    ScreenImage capturedRegion = screen.capture(point.x, point.y, 200, 300);
	    ImageIO.write(capturedRegion.getImage(), "PNG", new File("C:\\SikuliImages\\CapturedRegion.png"));
	}

}
