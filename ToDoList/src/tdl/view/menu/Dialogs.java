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

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.json.simple.parser.ParseException;

import tdl.view.AdjustDialog;
import tdl.view.UpdateAllView;
import tdl.controller.menu.Load;
import tdl.controller.menu.Save;
import tdl.model.Model;
import tdl.model.theme.Theme;

public class Dialogs {
	
}

class newfileDialog{
	public newfileDialog(JFrame f){
			/*create open dialog*/
		 	Dialog Dia = new Dialog(f,"New File",true);
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	/*set size of dialog*/
		 	Dia.setSize(250, 100);
		 	
		 	/*set location*/
		 	new AdjustDialog(f,Dia);
		 	
		 	/*set layout*/
		 	Dia.setLayout(new BorderLayout());
		 	
		 	/*announcement */
		 	JLabel l1 = new JLabel("Will you save this before new?",JLabel.CENTER);
		 	
			/*set button1*/
			JButton b1 = new JButton("OK");
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					try {
						new saveDialog(f);
						//new
						Model.resetModel();
				    	new UpdateAllView();
					} catch (IOException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Save fail!");
					}
					Dia.dispose();
				}}
			b1.addActionListener(new b1EventHandler());
		 	
			/*set button2*/
			JButton b2 = new JButton("No");
			class b2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					//new
					Model.resetModel();
					new UpdateAllView();
					Dia.dispose();
				}}
			b2.addActionListener(new b2EventHandler());
			
			/*set button3*/
			JButton b3 = new JButton("cancel");
			class b3EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Dia.dispose();
				}}
			b3.addActionListener(new b3EventHandler());
			
			/*add components*/
			JPanel buttonPane = new JPanel(new GridLayout(1,3));
			buttonPane.add(b1);
			buttonPane.add(b2);
			buttonPane.add(b3);	
			Dia.add(l1, BorderLayout.CENTER);
			Dia.add(buttonPane, BorderLayout.SOUTH);
			Dia.setVisible(true);
	}
}

class openDialog{
	public openDialog(JFrame f) throws IOException, ParseException, java.text.ParseException{
			/*create open dialog*/
		 	FileDialog Dia = new FileDialog(f,"Open File",FileDialog.LOAD);
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	/*set initial file*/
		 	Dia.setFile("*.json");
		 	Dia.setVisible(true);
		 	
		 	/*get path(directory and file name)*/
		 	String DirName = Dia.getDirectory();
		 	String FileName = Dia.getFile();
		 	String pathName = null;
		 	if(DirName == null){
		 		return;
		 	}else{
		 		pathName = DirName + FileName;
		 		//make new save file on the pathName
			 	new Load(pathName);
				//set static path of this file
			 	Model.FilePath = pathName;
		 	}
		 	System.out.println("Load :" + pathName);
	
		}
}

class saveDialog{
	public saveDialog(JFrame f) throws IOException{
			//if save for the first time{
			if(Model.FilePath == null){
				/*create save dialog*/
			 	FileDialog Dia = new FileDialog(f,"Save",FileDialog.SAVE);
			 	Dia.addWindowListener(new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						Dia.dispose();
					}
				});
			 	
			 	/*set initial file*/
			 	Dia.setFile("*.json");
			 	Dia.setVisible(true);
			 	
			 	/*get path(directory and file name)*/
			 	String DirName = Dia.getDirectory();
			 	String FileName = Dia.getFile();
			 	String pathName = null;
			 	if(DirName == null){
			 		return;
			 	}else{
			 		pathName = DirName + FileName;
			 		//make new save file on the pathName
				 	new Save(pathName);
					//set static path of this file
				 	Model.FilePath = pathName;
			 	}

		 	//if once saved already
			}else{
				//save at Model.FilePath
			 	System.out.println("hSave :" + Model.FilePath);
				new Save(Model.FilePath);
			}
	}
}

class saveAsDialog{
	public saveAsDialog(JFrame f) throws IOException{
			/*create save dialog*/
		 	FileDialog Dia = new FileDialog(f,"Save As...",FileDialog.SAVE);
		 	Dia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					Dia.dispose();
				}
			});
		 	
		 	/*set initial file*/
		 	Dia.setFile("*.json");
		 	Dia.setVisible(true);
		 	
		 	/*get path(directory and file name)*/
		 	String DirName = Dia.getDirectory();
		 	String FileName = Dia.getFile();
		 	String pathName = null;
		 	if(DirName == null){
		 		return;
		 	}else{
		 		pathName = DirName + FileName;
		 		//make new save file on the pathName
			 	new Save(pathName);
				//set static path of this file
			 	Model.FilePath = pathName;
		 	}	 	
	}
}

class exitDialog{
	public exitDialog(JFrame f){
		/*create new dialog*/
	 	Dialog Dia = new Dialog(f,"exit",true);
	 	Dia.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				Dia.dispose();
			}
		});
	 	/*set size of dialog*/
	 	Dia.setSize(440, 200);
	 	
	 	/*set location*/
	 	new AdjustDialog(f,Dia);
	 	
	 	/*set layout*/
	 	Dia.setLayout(new BorderLayout());
	 	
	 	/*announcement */
	 	JLabel l1 = new JLabel("Will you exit this program?");
	 	
		/*set button1*/
		JButton b1 = new JButton("OK");
		class b1EventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				System.exit(0);
			}}
		b1.addActionListener(new b1EventHandler());
	 	
		/*set button1*/
		JButton b2 = new JButton("cancel");
		class b2EventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				Dia.dispose();
			}}
		b2.addActionListener(new b2EventHandler());
		
		/*add components*/
		JPanel buttonPane = new JPanel(new GridLayout(1,2));
		buttonPane.add(b1);
		buttonPane.add(b2);
		Dia.add(l1, BorderLayout.CENTER);
		Dia.add(buttonPane, BorderLayout.SOUTH);
		Dia.setVisible(true);
	}
	
}

class HelpDialog{
	public  HelpDialog(JFrame f){
			/*create new dialog*/
		 	Dialog HelpDia = new Dialog(f,"Help Dialog",true);
		 	HelpDia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					HelpDia.dispose();
				}
			});
		 	/*set size of dialog*/
		 	HelpDia.setSize(440, 200);
		 	
		 	/*set location*/
		 	new AdjustDialog(f,HelpDia);
		 	
		 	/*set layout*/
		 	HelpDia.setLayout(new BorderLayout());
		 	
			/*add help statements here :) */
		 	String detailstring = 
		 		"To Do list for everyone"
		 	+ "\nJava ToDoList program. "
		 	+ "\nEasy to use, Good looking, Highly utilized, and Light."
		 	+ "\nUsed Java lang."
		 	+ "\n"
		 	+ "\nGeneral Features"
		 	+ "\n* To Do list with priority, memo, log, calendar."
		 	+ "\n* Create, edit, delete To Do."
		 	+ "\n* Priority can be assigned."
		 	+ "\n* Log view with complete date."
		 	+ "\n* To Do can be viewed in the calendar."
		 	+ "\n* Three types of color theme available."
		 	+ "\n";
		 	
		 	/*set text area*/
		 	JEditorPane txt1 = new JEditorPane();
		 	txt1.setText(detailstring);
		 	txt1.setEditable(false);
		 	JScrollPane t1 = new JScrollPane(txt1);
			
			/*set button*/
			JButton b1 = new JButton("OK");
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					HelpDia.dispose();
				}}
			b1.addActionListener(new b1EventHandler());
			
			/*add components*/
			HelpDia.add(t1, BorderLayout.CENTER);
			HelpDia.add(b1, BorderLayout.SOUTH);
			HelpDia.setVisible(true);
	 }
	
}

class AboutDialog{
	public AboutDialog(JFrame f){
		 	Dialog AboutDia = new Dialog(f,"About",true);
		 	
		 	AboutDia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					AboutDia.dispose();
				}
			});
		 	
		 	AboutDia.setSize(440, 200);
		 	new AdjustDialog(f,AboutDia);
		 	AboutDia.setLayout(new BorderLayout());
			
		 	String detailstring = 
		 	"To Do list for everyone"
		 	+ "\n(c) Copyright HM Yoon, DU Oh and SH Chae 2019. All rights reserved."
		 	+ "\nall the properties of this program follow GNU lisence."
		 	+ "\ncontact details"
		 	+ "\nHM Yoon jcjc7890@gmail.com"
			+ "\nDU Oh odu.wave@gmail.com"
		 	+ "\nSH Chae tjdghco1@gmail.com"
		 	+ "\n";
		 	JEditorPane txt1 = new JEditorPane();
		 	txt1.setEditable(false);
		 	txt1.setText(detailstring);
			JScrollPane t1 = new JScrollPane(txt1);
			JButton b1 = new JButton("OK");
			
			class b1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					AboutDia.dispose();
				}}
			b1.addActionListener(new b1EventHandler());
			
			AboutDia.add(t1, BorderLayout.CENTER);
			AboutDia.add(b1, BorderLayout.SOUTH);
			AboutDia.setVisible(true);
	 }
}

class ThemeDialog{
	public ThemeDialog(JFrame f){
		 	Dialog ThemeDia = new Dialog(f,"set Theme",true);
		 	
		 	ThemeDia.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					ThemeDia.dispose();
				}
			});
		 	
		 	ThemeDia.setSize(170, 240);
		 	new AdjustDialog(f,ThemeDia);

		 	ThemeDia.setLayout(new FlowLayout());
			
		 	JLabel Hl1 = new JLabel("***Select Theme***");
			
			JButton Hb1 = new JButton("Peach");
			JButton Hb2 = new JButton("Sky Blue");
			JButton Hb3 = new JButton("Dawn");
			JButton Hb4 = new JButton("none");
			
			JButton Hb6 = new JButton("cancel");
			class Hb1EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Model.theme.setTheme(1);
					ThemeDia.dispose();
				}}
			Hb1.addActionListener(new Hb1EventHandler());
			class Hb2EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Model.theme.setTheme(2);
					ThemeDia.dispose();
				}}
			Hb2.addActionListener(new Hb2EventHandler());
			class Hb3EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Model.theme.setTheme(3);
					ThemeDia.dispose();
				}}
			Hb3.addActionListener(new Hb3EventHandler());
			class Hb4EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					Model.theme.setTheme(4);
					ThemeDia.dispose();
				}}
			Hb4.addActionListener(new Hb4EventHandler());
			
			class Hb6EventHandler implements ActionListener{
				@Override
				public void actionPerformed(ActionEvent ae){
					ThemeDia.dispose();
				}}
			Hb6.addActionListener(new Hb6EventHandler());

			Panel ThemeP0 = new Panel();
			ThemeP0.add(Hl1);
			
			Panel ThemeP1 = new Panel();
			ThemeP1.setLayout(new GridLayout(4,1,0,3));
			ThemeP1.add(Hb1);
			ThemeP1.add(Hb2);
			ThemeP1.add(Hb3);
			ThemeP1.add(Hb4);
			
			Panel ThemeP2 = new Panel();
			ThemeP2.setLayout(new GridLayout(1,1));
			ThemeP2.add(Hb6);

			ThemeDia.add(ThemeP0, BorderLayout.NORTH);
			ThemeDia.add(ThemeP1, BorderLayout.CENTER);
			ThemeDia.add(ThemeP2, BorderLayout.SOUTH);
			ThemeDia.setVisible(true);
		 
	 }
	
}