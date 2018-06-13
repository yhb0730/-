package guiListener.ActionListener;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.simple.JSONObject;

import dataStructure.JsonNode;
import gui.*;
import mindMapUtil.FileManipulator;

public class SaveOptionActionListener extends OptionActionListener{
	
	int flag = 0;;
	String pathName;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		if(flag == 0) {
		Constants.IS_CHANGED = false;
		++flag;
		}
		
		FileManipulator file = new FileManipulator();
		
		JSONObject object = JsonNode.makeJsonNode();
		Frame.obj = object;
		//System.out.println(object.toString());
		//System.out.println(object.toJSONString());
		
	
		//FileWriter writer;
		
		if(!Constants.IS_CHANGED) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("json", "json", "json");
		chooser.setFileFilter(filter);
		int ret = chooser.showSaveDialog(null);
		if(ret == JFileChooser.APPROVE_OPTION) {
			pathName = chooser.getSelectedFile().getPath();
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
		Constants.IS_CHANGED = true;
		}
		else {
	
				try {
					FileWriter writer2 = new FileWriter(pathName + ".json");
					writer2.write(object.toJSONString());
					writer2.flush();
					writer2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("최근 저장");		
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
