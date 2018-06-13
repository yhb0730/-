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
			//System.out.println("잘 open select 됨");
			String pathName = chooser.getSelectedFile().getPath();
			
			//System.out.print(pathName);
			//경로명 잘 찍힘
			
			//JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(pathName));
			JSONObject jsonObject = (JSONObject) obj;
			//"c:\\Users\\User\\test.json"
			//pathName + ".json"
			
			Frame.obj = jsonObject;
			
			//잘 저장돼있음 출력해보니까 정상!
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
		
		//json 파일을 읽어와서 Frame.obj를 대체해야한다
		//public static void readJsonNode(JSONObject object)
		
	
			JsonNode.readJsonNode(Frame.obj);
			super.getTextEditor().setJsonText(); //정상작동 확인
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
