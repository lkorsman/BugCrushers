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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import tdl.model.Model;
import tdl.model.todoelements.ToDoElementStruct;
import tdl.view.Taps;
import tdl.view.todo.addToDoElement;
import tdl.view.todo.initToDo;

public class PopupMenuExample  
{  
     public PopupMenuExample(JFrame f, MouseEvent e, addToDoElement p1){  
         final JPopupMenu popupmenu = new JPopupMenu("options");  
 
         JMenuItem done = new JMenuItem("complete", new ImageIcon("src/tdl/icon/popup_complete.png"));
         JMenuItem edit = new JMenuItem("edit", new ImageIcon("src/tdl/icon/popup_edit.png"));  
         JMenuItem delete = new JMenuItem("delete", new ImageIcon("src/tdl/icon/popup_delete.png"));  
         JMenuItem multi = new JMenuItem("multi-complete", new ImageIcon("src/tdl/icon/check-box.png"));
         /*done*/
         class doneEventHandler implements ActionListener{
 			@Override
 			public void actionPerformed(ActionEvent ae){
 				Model.logTextContents = p1.cinputstructure.getToDoText() + "    ["+LocalDate.now()+"]" 
 										+"\n"+ Model.logTextContents;
 				Model.priorityQueue.remove(p1.cinputstructure);
 				initToDo.inittoDoElements.UpdateToDoView();
 				Taps.logtab.UpdateLogView();
 			}}	
         done.addActionListener(new doneEventHandler());
         /*edit*/
         class editEventHandler implements ActionListener{
 			@Override
 			public void actionPerformed(ActionEvent ae){
 				p1.txtfld1.setEditable(true);
 			}}	
         edit.addActionListener(new editEventHandler());
         /*delete*/
         class deleteEventHandler implements ActionListener{
 			@Override
 			public void actionPerformed(ActionEvent ae){
 				Model.priorityQueue.remove(p1.cinputstructure);
 				initToDo.inittoDoElements.UpdateToDoView();
 		}}	
         delete.addActionListener(new deleteEventHandler());
         /*multi*/
         class multiEventHandler implements ActionListener{
 			@Override
 			public void actionPerformed(ActionEvent ae){
 				//iterate model
 				todoController ctr = new todoController();
 				while (!ctr.PQCopy.isEmpty()) {
 					ToDoElementStruct structi = ctr.PQCopy.poll();
 					if(structi.getCheckValue() == true){
 						Model.priorityQueue.remove(structi);
 						Model.logTextContents = structi.getToDoText() + "    ["+LocalDate.now()+"]" 
									+"\n"+ Model.logTextContents;
 					}
 				}
 				//update
 				initToDo.inittoDoElements.UpdateToDoView();
 				Taps.logtab.UpdateLogView();
 		}}	
         multi.addActionListener(new multiEventHandler());
         

		 popupmenu.add(done);
	     popupmenu.add(edit); 
		 popupmenu.add(delete);
		 popupmenu.addSeparator();
		 popupmenu.add(multi);
		 
         popupmenu.show(e.getComponent(), e.getX(), e.getY());  
     } 
} 