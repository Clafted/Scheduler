package main.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.JPanel;

public abstract class Page extends JPanel implements KeyListener {
	
	protected class Key {
		static final int BACKSPACE = 8, ENTER = 10;
	}
	
	public static final long serialVersionUID = 3543653;
	public static Color[] colorPalette = {new Color(140, 100, 190), new Color(170, 130, 220), new Color(200, 160, 250), new Color(120, 80, 70)};	
	public static Font titleFont = new Font("SansSerif", Font.PLAIN, 40);
	public static Font mainFont;
	
	public Page nextPage = null;
	
	public abstract void loadPage();
	
	public static void loadFonts() {
		try {
			mainFont = Font.createFont(Font.TRUETYPE_FONT,new File("./Miology.otf")).deriveFont(40f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
