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

package tdl.view.todo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tdl.controller.todo.PopupMenuExample;
import tdl.model.theme.Theme;
import tdl.model.todoelements.ToDoElementStruct;

public class addToDoElement extends JPanel implements MouseListener{
	JFrame f1;
	JCheckBox cb1;
	public JTextField txtfld1;
	JLabel Ddayl;
	public ToDoElementStruct cinputstructure;
	addToDoElement(JPanel p){
		p.add(this);
	}

	addToDoElement(JPanel p, ToDoElementStruct inputstructure, JFrame f){
		cinputstructure = inputstructure;
		f1 = f;
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		/*CheckBox*/
		cb1 = new JCheckBox();
		class cb1EventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				JCheckBox cb = (JCheckBox) ae.getSource();
				if (cb.isSelected()) {
					inputstructure.setCheckValue(true);
					System.out.println("checked");
					//update addbutton;
				} else {
					inputstructure.setCheckValue(false);	
					System.out.println("unchecked");
					//update addbutton;
				}
			}
		}
		cb1.addActionListener(new cb1EventHandler());
		cb1.setSelected(inputstructure.getCheckValue());	
		//when checked set check boolean get boolean on another area
		/*Text Field*/
		txtfld1 = new JTextField("init text"){
			@Override
		    public Dimension getMinimumSize() {
		        return new Dimension(150, 30);
		    }

		    @Override
		    public Dimension getPreferredSize() {
		        return new Dimension(200, 30);
		    }

		    @Override
		    public Dimension getMaximumSize() {
		        return new Dimension(1000, 30);
		    }
		};
		txtfld1.setBorder(null);
		txtfld1.setEditable(false);
		txtfld1.setText(inputstructure.getToDoText());
		/*D-day*/
		long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), inputstructure.getDDay());
		if(LocalDate.now().isBefore(inputstructure.getDDay())){
				Ddayl = new JLabel("D-"+daysBetween);//D-day 
			}else{
				Ddayl = new JLabel("D+"+ (daysBetween*-1));//D-day 
			}
		//setting color
		if(cinputstructure.getPriority()==0){
			//txtfld1.setBackground(Theme.themeColor5);
			//this.setBackground(Theme.themeColor5);
			cb1.setBackground(Theme.themeColor5);
		}else if(cinputstructure.getPriority()==1){
			//txtfld1.setBackground(Theme.themeColor6);
			//this.setBackground(Theme.themeColor6);
			cb1.setBackground(Theme.themeColor6);
		}else if(cinputstructure.getPriority()==2){
			//txtfld1.setBackground(Theme.themeColor7);
			//this.setBackground(Theme.themeColor7);
			cb1.setBackground(Theme.themeColor7);
		}else if(cinputstructure.getPriority()==3){
			//txtfld1.setBackground(Theme.themeColor8);
			//this.setBackground(Theme.themeColor8);
			cb1.setBackground(Theme.themeColor8);
		}else if(cinputstructure.getPriority()==4){
			//txtfld1.setBackground(Theme.themeColor9);
			//this.setBackground(Theme.themeColor9);
			cb1.setBackground(Theme.themeColor9);
		}else if(cinputstructure.getPriority()==5){
			//txtfld1.setBackground(Theme.themeColor10);
			//this.setBackground(Theme.themeColor10);
			cb1.setBackground(Theme.themeColor10);
		}else {
			//txtfld1.setBackground(Theme.themeColor10);
			//this.setBackground(Theme.themeColor10);
			cb1.setBackground(Theme.themeColor10);
		}
		
	
		this.setVisible(true);
		this.add(Ddayl);
		this.add(txtfld1);
		this.add(cb1);
		txtfld1.addMouseListener(this);
		Ddayl.addMouseListener(this);
		this.addMouseListener(this);
		p.add(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		txtfld1.setEditable(false);
	    this.cinputstructure.setToDoText(txtfld1.getText());
		if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
		    txtfld1.setEditable(true);
		  }
		if (e.getButton() == MouseEvent.BUTTON3){
			new PopupMenuExample(f1,e,this);
		}		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.setBorder(BorderFactory.createLoweredBevelBorder());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.setBorder(BorderFactory.createRaisedBevelBorder());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setBorder(BorderFactory.createRaisedBevelBorder());
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBorder(BorderFactory.createEmptyBorder());

	}	
}