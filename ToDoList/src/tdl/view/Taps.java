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

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import tdl.model.theme.Theme;
import tdl.view.calendar.initCalendar;
import tdl.view.log.initLog;
import tdl.view.memo.initMemo;
import tdl.view.todo.initToDo;

public class Taps{
	JTabbedPane tabPane;
	JScrollPane todotab;
	public static initMemo memotab;
	public static initLog logtab;
	JPanel calendartab;
	
	Taps(JFrame f){
		tabPane = new JTabbedPane();		
		
		todotab = new initToDo(f);
		memotab = new initMemo();
		logtab = new initLog();
		calendartab = new initCalendar();

		tabPane.addTab("ToDo", todotab);
		tabPane.addTab("Memo", memotab);
		tabPane.addTab("log", logtab);
		tabPane.addTab("", calendartab);
		tabPane.setIconAt(0, new ImageIcon("src/tdl/icon/checkbox.png"));
		tabPane.setIconAt(1, new ImageIcon("src/tdl/icon/notebook.png"));
		tabPane.setIconAt(2, new ImageIcon("src/tdl/icon/log.png"));
		tabPane.setIconAt(3, new ImageIcon("src/tdl/icon/calendar-icon.png"));
		f.add(tabPane, BorderLayout.CENTER);
		f.setVisible(true);
		
		/*Setting Color*/		
		tabPane.setBackgroundAt(0, Theme.themeColor1);
		tabPane.setBackgroundAt(1, Theme.themeColor2);
		tabPane.setBackgroundAt(2, Theme.themeColor3);
		tabPane.setBackgroundAt(3, Theme.themeColor4);
		f.getContentPane().setBackground(Theme.tapsColor);
	}
}
