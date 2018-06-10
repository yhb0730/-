package guiListener.ActionListener;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;
import javax.imageio.ImageIO;

import gui.Constants;

public class SaveJpgOptionActionListener extends OptionActionListener{
	
	
	//https://stackoverflow.com/questions/14551646/convert-a-jpanel-to-an-image-in-a-jscrollpane ÂüÁ¶
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Component component = super.getMindMapEditor().getMindMapEditor().getPanel();
		BufferedImage img = new BufferedImage(Constants.SCROLL_X_SIZE, Constants.SCROLL_Y_SIZE, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = img.createGraphics();
		component.paintAll(g);
		try {
			ImageIO.write(img, "PNG", new File("my.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("?");
		}
	}
}


