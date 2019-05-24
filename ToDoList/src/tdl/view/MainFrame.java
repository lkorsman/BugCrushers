/*
 * This file is part of Java To-Do-List Planer(Planet)
 *
 * Copyright (C) 2019  H.M. YOON, D.U. OH, S.H. CHAE.
 *
 * Java To-Do-List Planer(Planet) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 1 of the License, or
 * any later version.
 *
 *  Java To-Do-List Planer(Planet) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, See the
 * GNU General Public License for more details.
 * it would be glad to be notified any further modification to copyrighters .
 *
 * You should have received a copy of the GNU General Public License
 * along with Java To-Do-List Planer(Planet) If not, see <http://www.gnu.org/licenses/>.
 */

package tdl.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import tdl.view.menu.MenuBarSection;

public class MainFrame extends JFrame{
	MenuBarSection MenuBar; 
	Taps taps;
    MainFrame() {
    	//set Title 
    	this.setTitle("To Do List 1.0 v");
		Image iPrintManager = Toolkit.getDefaultToolkit().getImage("src/tdl/icon/MainFrameicon"
				+ ".png");
	 	this.setIconImage(iPrintManager);
    	addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
    	setSize(300, 500);
		MenuBar = new MenuBarSection(this);
		taps = new Taps(this);
		//set position of the main frame in the middle of screen.			
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xpos = 20;
		int ypos = (int) (screen.getHeight() / 4);
		setLocation(xpos, ypos);
		
		setVisible(true);				
	}
}