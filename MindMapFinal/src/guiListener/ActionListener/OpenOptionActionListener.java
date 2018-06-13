package guiListener.ActionListener;

import java.awt.event.ActionEvent;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException; 

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.simple.parser.JSONParser;

import dataStructure.JsonNode;
import gui.*;

public class OpenOptionActionListener extends OptionActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		JSONParser parser = new JSONParser();
		
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("json", "json", "json");
		chooser.setFileFilter(filter);
		int ret = chooser.showOpenDialog(null);
		if(ret == JFileChooser.APPROVE_OPTION) {
			
			try {
			//System.out.println("�� open select ��");
			String pathName = chooser.getSelectedFile().getPath();
			
			//System.out.print(pathName);
			//��θ� �� ����
			
			//JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(pathName));
			JSONObject jsonObject = (JSONObject) obj;
			//"c:\\Users\\User\\test.json"
			//pathName + ".json"
			
			Frame.obj = jsonObject;
			
			//�� ��������� ����غ��ϱ� ����!
			//System.out.println(jsonObject.toJSONString());
			
			
			/*
				FileReader reader;
				try {
					reader = new FileReader(pathName + ".json");
					writer.write(object.toJSONString());
				}
		  	*/
			}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}catch (ParseException e) {
					e.printStackTrace();
			}
		}
		
		//json ������ �о�ͼ� Frame.obj�� ��ü�ؾ��Ѵ�
		//public static void readJsonNode(JSONObject object)
		
	
			JsonNode.readJsonNode(Frame.obj);
			super.getTextEditor().setJsonText(); //�����۵� Ȯ��
			super.getMindMapEditor().getMindMapEditor().drawJson(Frame.obj);
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
