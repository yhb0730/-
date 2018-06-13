package guiListener.ActionListener;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.simple.JSONObject;

import dataStructure.JsonNode;
import gui.*;
import mindMapUtil.FileManipulator;

public class SaveAnotherOptionActionListener extends OptionActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FileManipulator file = new FileManipulator();
		
		JSONObject object = JsonNode.makeJsonNode();
		Frame.obj = object;
		//System.out.println(object.toString());
		//System.out.println(object.toJSONString());
		
		
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("json", "json", "json");
		chooser.setFileFilter(filter);
		int ret = chooser.showSaveDialog(null);
		if(ret == JFileChooser.APPROVE_OPTION) {
			String pathName = chooser.getSelectedFile().getPath();
			//System.out.println("pathName : " + pathName);
			
				FileWriter writer;
				try {
					writer = new FileWriter(pathName + ".json");
					writer.write(object.toJSONString());
					writer.flush();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		
		
		
		
		
		
		
	}
	
	@Override
	public TextEditorPane getTextEditor() {
		return super.getTextEditor();
	}

	@Override
	public void setTextEditor(TextEditorPane textEditor) {
		super.setTextEditor(textEditor);
	}

	@Override
	public MindMapEditorPane getMindMapEditor() {
		return super.getMindMapEditor();
	}

	@Override
	public void setMindMapEditor(MindMapEditorPane mindMapEditor) {
		super.setMindMapEditor(mindMapEditor);
	}

	@Override
	public AttributeEditorPane getAttrEditor() {
		return super.getAttrEditor();
	}

	@Override
	public void setAttrEditor(AttributeEditorPane attrEditor) {
		super.setAttrEditor(attrEditor);
	}

}
