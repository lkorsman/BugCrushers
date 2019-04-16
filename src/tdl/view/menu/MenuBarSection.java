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

package tdl.view.menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import org.json.simple.parser.ParseException;

import tdl.model.theme.Theme;




public class MenuBarSection{
	public MenuBarSection(JFrame f){

		/*Menu_bar*/
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu setting = new JMenu("Setting");
		JMenu help = new JMenu("Help");
		/*File Menu*/
		JMenuItem newfile = new JMenuItem("New");
		newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem open = new JMenuItem("Open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		JMenuItem save = new JMenuItem("Save");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenuItem saveAs = new JMenuItem("Save As..");		
		JMenuItem exit = new JMenuItem("Close");
		JMenuItem theme = new JMenuItem("Theme");
		JMenuItem helpwords = new JMenuItem("Help");
		JMenuItem about = new JMenuItem("About");
		JMenuItem Testing = new JMenuItem("Testing");
		file.add(newfile);
		file.add(open);
		file.add(save);
		file.add(saveAs);
		file.addSeparator();
		file.add(exit);
		//edit.add();
		setting.add(theme);
		help.add(helpwords);
		help.add(about);
		help.add(Testing);
		/*<Menu_SetUp>*/
		menubar.add(file);
		menubar.add(edit);
		menubar.add(setting);
		menubar.add(help);
		/*setting color*/
		menubar.setBackground(Theme.menuBarColor);
		
		/*<MenuItem_Action>*/
		/*new*/
		class newfileEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new newfileDialog(f);
			}}	
		newfile.addActionListener(new newfileEventHandler());
		/*open*/
		class openEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				try {
					new openDialog(f);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}	
		open.addActionListener(new openEventHandler());
		/*save*/
		class saveEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				try {
					new saveDialog(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}	
		save.addActionListener(new saveEventHandler());
		/*save*/
		class saveAsEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				try {
					new saveAsDialog(f);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}}	
		saveAs.addActionListener(new saveAsEventHandler());
		/*Exit*/
		class exitEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}}	
		exit.addActionListener(new exitEventHandler());
		/*theme menu item*/
		class themeEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new ThemeDialog(f);
			}}
		theme.addActionListener(new themeEventHandler());
		/*Help*/
		class helpEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new HelpDialog(f);
			}}
		helpwords.addActionListener(new helpEventHandler());
		/*About*/
		class aboutEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new AboutDialog(f);
			}}	
		about.addActionListener(new aboutEventHandler());
		
		/*Testing*/
		class TestingEventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				/*something want to test*/
				//new todoCreationDialog(f);
			}}	
		Testing.addActionListener(new TestingEventHandler());
		
		/*menubar.setOpaque(true);*/
		f.setJMenuBar(menubar);
		f.setVisible(true);
		
	}

	private static void setBackground(Color menuBarColor) {
		// TODO Auto-generated method stub
		
	}	
}
