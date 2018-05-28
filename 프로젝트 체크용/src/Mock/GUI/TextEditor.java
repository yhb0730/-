package Mock.GUI;

import java.awt.*;
import javax.swing.*;

import org.w3c.dom.css.RGBColor;

public class TextEditor extends JScrollPane{
	TextArea textArea;
	
	TextEditor(){
		textArea = new TextArea(20, 8);
		this.getViewport().add(textArea, null);
	}
}
