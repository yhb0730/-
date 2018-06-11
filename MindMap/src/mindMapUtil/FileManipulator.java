package mindMapUtil;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileManipulator{
	private static String savedPathName;
	
	public static void open() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("");
		fileChooser.setFileFilter(filter);
		int ret = fileChooser.showOpenDialog(null);
		if(ret == JFileChooser.APPROVE_OPTION) {
			String selectedFile = fileChooser.getSelectedFile().getPath();
		}
	}
	
	public static void save() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("json", "json", "java");
		fileChooser.setFileFilter(filter);
		int ret = fileChooser.showSaveDialog(null);
		if(ret == JFileChooser.APPROVE_OPTION) {
			//TODO json 객체를 파일에 넣거나 그대로 저장하는 코드 필요
			String pathName = fileChooser.getSelectedFile().getPath();
			savedPathName = pathName;
		}
	}
	
	public static boolean ImageSave(BufferedImage img) throws IOException, NullPointerException{
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter jpgFilter = new FileNameExtensionFilter("jpg", "jpg");
		FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("png", "png");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fileChooser.setFileFilter(jpgFilter);
		fileChooser.setFileFilter(pngFilter);
		int ret = fileChooser.showSaveDialog(null);
		if(ret == JFileChooser.APPROVE_OPTION) {
			String pathName = fileChooser.getSelectedFile().getPath();
			if(fileChooser.getFileFilter() == jpgFilter) {
				//fileChooser.getF
				ImageIO.write(img, "JPG", new File(pathName + ".jpg"));
				savedPathName = pathName;
			}
			else if(fileChooser.getFileFilter() == pngFilter) {
				ImageIO.write(img, "PNG", new File(pathName + ".png"));
				savedPathName = pathName;
			}
			return true;	
		}
		return false;
	}
}