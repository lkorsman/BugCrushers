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

package tdl.view.calendar;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;

import tdl.view.AdjustDialog;

public class CalendarDialog{
	initCalendar Cal;
	private LocalDate selectedDate;
	public CalendarDialog(JFrame f){
		Dialog CalendarDia = new Dialog(f,"Calendar",true);		
		CalendarDia.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				CalendarDia.dispose();
			}
		});	 	
		CalendarDia.setSize(350, 350);
		new AdjustDialog(f, CalendarDia);
		CalendarDia.setLayout(new FlowLayout());
		
	 	JButton b1 = new JButton("ok");
		JButton b2 = new JButton("undo");
		Cal = new initCalendar();
		
		class b1EventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				selectedDate = Cal.calendar1.getSelectedDate();
				CalendarDia.dispose();
				System.out.println(selectedDate);
			}}
		b1.addActionListener(new b1EventHandler());
		class b2EventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				CalendarDia.dispose();
			}}
		b2.addActionListener(new b2EventHandler());
		

		CalendarDia.add(Cal,BorderLayout.CENTER);
		
		Panel restartP2 = new Panel();
		restartP2.setLayout(new GridLayout(1,2,2,2));
		restartP2.add(b1);
		restartP2.add(b2);
		CalendarDia.add(restartP2,BorderLayout.SOUTH);		
		CalendarDia.setVisible(true);
	}
	
	public LocalDate getselectedDate(){
		return this.selectedDate;
	}
}
