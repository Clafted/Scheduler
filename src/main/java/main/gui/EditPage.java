package main.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import main.backend.Activity;
import main.backend.Schedule;

public class EditPage extends Page {

	public static final long serialVersionUID = 3298472;

	private String input = "";
	private int newLines = 0;
	private Schedule schedule;
	private Activity currentActivity = null;
	int currentIndex = 0;

	public EditPage(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public void loadPage() {
		setBackground(colorPalette[0]);
		input = "";
		newLines = 0;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Activity a;
		int x, y;
		g.setColor(colorPalette[1]);
		g.setFont(mainFont);
		x = 50;
		for (int i = 0; i < schedule.numActivities(); i++) {
			a = schedule.getActivity(i);
			y = 50 + (i * 120);
			// Draw the background
			g.setColor((i == currentIndex) ? colorPalette[3] : colorPalette[2]);
			g.fillRoundRect(x, y, getWidth() - 100, 100, 50, 50);
			g.setColor(colorPalette[1]);
			g.fillRoundRect(x, y + getFont().getSize() + 30, getWidth() - 100, 100 - getFont().getSize() - 30, 50, 50);
			g.fillRect(x, y + getFont().getSize() + 25, getWidth() - 100, 25);
			
			// Draw the text
			g.setColor(Color.white);
			g.drawString(a.getName(), x + 20, y + 35);
		}
	}

	public void keyTyped(KeyEvent e) {
		if((int) e.getKeyChar() >= 32 && (int) e.getKeyChar() <= 167) {
				input += e.getKeyChar();
		}
		if (currentActivity == null) return;
		currentActivity.setName(input);
		
		repaint();
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_BACK_SPACE:
			if (input.length() <= 0) break;
			input = input.substring(0, input.length() - 1);
			
			break;
		case KeyEvent.VK_ENTER:
			newLines++;
			if (newLines <= 1) break;
			newLines = 0;
			schedule.addActivity();
			currentIndex = schedule.getIndexOfLastActivity();
			currentActivity = schedule.getActivity(currentIndex);
			input = "";
			
			break;
		case KeyEvent.VK_UP:
			if (currentIndex <= 0) break;
			currentActivity = schedule.getActivity(--currentIndex);
			input = currentActivity.getName();
			
			break;
		case KeyEvent.VK_DOWN:
			if (currentIndex >= schedule.numActivities() - 1) break;
			currentActivity = schedule.getActivity(++currentIndex);
			input = currentActivity.getName();
			
			break;
		}
		
		repaint();
	}
	public void keyReleased(KeyEvent e) {}
}