package main.gui;


import java.awt.Color;

import javax.swing.JFrame;

import main.backend.Schedule;

public class SchedulerApp {
	
	JFrame window;
	Page currentPage;
	
	public SchedulerApp() {
		Page.loadFonts();
		window = new JFrame("Scheduler");
		window.setBounds(0, 0, 800, 600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void run() {
		currentPage = new EditPage(new Schedule());
		currentPage.loadPage();
		window.setContentPane(currentPage);
		window.addKeyListener(currentPage);
		window.setVisible(true);
		
		while (window.isShowing()) {
			if (currentPage.nextPage != null) {
				Page newPage = currentPage.nextPage;
				newPage.setBounds(window.getBounds());
				newPage.loadPage();
				window.setContentPane(newPage);
				window.revalidate();
				currentPage = newPage;
			}
		}
	}
}
