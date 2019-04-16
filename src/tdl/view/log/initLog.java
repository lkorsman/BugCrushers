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

package tdl.view.log;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

import tdl.model.Model;

public class initLog extends JScrollPane{
	JEditorPane logTexttab;
	public initLog(){
		logTexttab = new JEditorPane();
		logTexttab.setEditable(false);
		logTexttab.setText(Model.logTextContents);
		logTexttab.setVisible(true);
		this.setViewportView(logTexttab);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	public void UpdateLogView(){
		logTexttab.setText(Model.logTextContents);
		this.revalidate();
		this.repaint();
	}
	
}
