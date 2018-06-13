package guiListener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;

import gui.Constants;
import mindMapUtil.FileManipulator;

public class SaveImageOptionActionListener extends OptionActionListener{
	
	//https://stackoverflow.com/questions/14551646/convert-a-jpanel-to-an-image-in-a-jscrollpane ÂüÁ¶
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Component component = super.getMindMapEditor().getMindMapEditor().getPanel();
		BufferedImage img = new BufferedImage(Constants.SCROLL_X_SIZE, Constants.SCROLL_Y_SIZE, BufferedImage.TYPE_3BYTE_BGR);
		Graphics g = img.createGraphics();
		component.paintAll(g);
		try {
			if(FileManipulator.ImageSave(img)) {
				Constants.IS_CHANGED = false;
			}
		}catch(IOException ioEx) {
			;
		}catch(NullPointerException nullEx) {
			;
		}
	}
}


