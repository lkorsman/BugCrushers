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

package tdl.controller.todo;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;

import tdl.model.Model;
import tdl.model.theme.Theme;
import tdl.model.todoelements.ToDoElementStruct;
import tdl.view.AdjustDialog;
import tdl.view.todo.initToDo;



public class todoCreationDialog{
	Dialog Dia;
	String todoelement;
	int priority;
	LocalDate duedate;

	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	
	CreateToDoTextPanel toDoTextPanel;
	CreatePriorityPanel priorityPanel;
	CreateDueDatePanel dueDatePanel;
	CreateOKPanel okPanel;
	
	public todoCreationDialog(JFrame f){
		Dia = new Dialog(f,"New To Do",true);
		Image iPrintManager = Toolkit.getDefaultToolkit().getImage("src/tdl/icon/checked.png");
	 	Dia.setIconImage(iPrintManager);
	 	Dia.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				Dia.dispose();
			}
		});
	 	Dia.setSize(390, 180);
	 	new AdjustDialog(f,Dia);
		Dia.setLayout(new GridBagLayout());
		
		l1 = new JLabel("TO DO");
		l2 = new JLabel("Priority");
		l3 = new JLabel("Due Date");
		toDoTextPanel = new CreateToDoTextPanel();
		priorityPanel = new CreatePriorityPanel();
		dueDatePanel = new CreateDueDatePanel();
		okPanel = new CreateOKPanel(this);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 0;
	    Dia.add(l1,c);
	    c.gridx = 1;
	    c.gridy = 0;
	    c.gridwidth = 3;
	    Dia.add(toDoTextPanel,c);
	    c.gridx = 0;
	    c.gridy = 1;
	    c.gridwidth = 1;
	    Dia.add(l2,c);
	    c.gridx = 1;
	    c.gridy = 1;
	    c.gridwidth = 3;
		Dia.add(priorityPanel,c);
	    c.gridx = 0;
	    c.gridy = 2;
	    c.gridwidth = 1;
	    Dia.add(l3,c);
	    c.gridx = 1;
	    c.gridy = 2;
	    c.gridwidth = 3;
		Dia.add(dueDatePanel,c);		
	    c.gridx = 3;
	    c.gridy = 3;
	    c.gridwidth = 1;
		Dia.add(okPanel,c);
		Dia.setVisible(true);
		Dia.pack();
	}

	private void setBackground(Color themeColor5) {
		// TODO Auto-generated method stub
		
	}
}

class CreateToDoTextPanel extends JPanel{
	JTextField t1;

	CreateToDoTextPanel(){
		t1 = new JTextField("what to do?");
		//t1.setHorizontalAlignment(JTextField.CENTER);
		this.setLayout(new GridLayout(1,1));
		this.add(t1);
	}
}

class CreatePriorityPanel extends JPanel{
	private int selectedPriority = 3;
	private JButton [] PriorityBtn = new JButton[6];
	
	CreatePriorityPanel(){
		ImageIcon [] a = new ImageIcon[7];
		
		a[0] = new ImageIcon("src/tdl/icon/number_0.png");
		a[1] = new ImageIcon("src/tdl/icon/number_1.png");
		a[2] = new ImageIcon("src/tdl/icon/number_2.png");
		a[3] = new ImageIcon("src/tdl/icon/number_3.png");
		a[4] = new ImageIcon("src/tdl/icon/number_4.png");
		a[5] = new ImageIcon("src/tdl/icon/number_5.png");
		a[6] = new ImageIcon("src/tdl/icon/checkedblue.png");

		this.setLayout(new GridLayout(1,6));
		for(int i = 0; i < 6;i++){
			PriorityBtn[i] = new JButton(a[i]);
			
			class pbtnEventHandler implements ActionListener{
				int j;
				public pbtnEventHandler(int prio) {
					j=prio;
				}
				@Override
				public void actionPerformed(ActionEvent ae){
					//1. reset all the button
					for(int k = 0; k < 6;k++){
						PriorityBtn[k].setIcon(a[k]);
					}
					//2. change the pressed button
					PriorityBtn[j].setIcon(a[6]);
					selectedPriority = j;
				}}
			PriorityBtn[i].addActionListener(new pbtnEventHandler(i));
			PriorityBtn[i].setOpaque(false);
			PriorityBtn[i].setContentAreaFilled(false);
			PriorityBtn[i].setBorderPainted(false);
			this.add(PriorityBtn[i]);
		}
		PriorityBtn[3].setIcon(a[6]);

	}
	int getSelectedPriority(){
		return selectedPriority;
	}
}

class CreateDueDatePanel extends JPanel{	
	DatePicker dp1;
	
	CreateDueDatePanel(){
		dp1 = new DatePicker();
		dp1.setDate(LocalDate.now().plusDays(7));
		this.add(dp1);
		
	}
}

class CreateOKPanel extends JPanel{
 	JButton b1 = new JButton("  OK  ",new ImageIcon("src/tdl/icon/checkbox.png"));
	JButton b2 = new JButton("  Undo  ", new ImageIcon("src/tdl/icon/undo.png"));
	ToDoElementStruct todoData;
	CreateOKPanel(todoCreationDialog dia){
		
		/*setting color*/ 
		b1.setBackground(Theme.themeColor1);
		b2.setBackground(Theme.themeColor8);
		class b1EventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				dia.todoelement = dia.toDoTextPanel.t1.getText();
				dia.duedate = dia.dueDatePanel.dp1.getDate();
				dia.priority = dia.priorityPanel.getSelectedPriority();

			    if(dia.todoelement == null){ //error of to do format
			    	JOptionPane.showMessageDialog(null, "please write something to do!");
			    }else{
			    	todoData = new ToDoElementStruct(dia.todoelement, dia.priority, dia.duedate,false);
			    	Model.priorityQueue.offer(todoData);
			    	initToDo.inittoDoElements.UpdateToDoView();
			    	//JOptionPane.showMessageDialog(null, "successfully added!");
					dia.Dia.dispose();
				}
			}
		}
		
		b1.addActionListener(new b1EventHandler());
		
		class b2EventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				dia.Dia.dispose();
			}}
		b2.addActionListener(new b2EventHandler());
		b1.setOpaque(true);
		b1.setContentAreaFilled(true);
		b1.setBorderPainted(true);
		b2.setOpaque(true);
		b2.setContentAreaFilled(true);
		b2.setBorderPainted(true);
		this.setLayout(new GridLayout(1,2,3,3));
		this.add(b1);
		this.add(b2);
	}
}


