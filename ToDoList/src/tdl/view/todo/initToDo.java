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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tdl.controller.todo.todoCreationDialog;
import tdl.model.theme.Theme;

public class initToDo extends JScrollPane{
	JPanel ToDoPanel;
	private initCreationButton creationButtonPanel;
	public static initToDoElements inittoDoElements;
	public initToDo(JFrame f){
		ToDoPanel = new JPanel();
		ToDoPanel.setLayout(new BoxLayout(ToDoPanel, BoxLayout.Y_AXIS));
		creationButtonPanel = new initCreationButton(f);
		inittoDoElements = new initToDoElements(f);
		ToDoPanel.add(inittoDoElements);
		ToDoPanel.add(creationButtonPanel,BorderLayout.PAGE_END);
		inittoDoElements.UpdateToDoView();
		this.setViewportView(ToDoPanel);
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
}

class initCreationButton extends JPanel implements MouseListener{
	JButton b1;
	initCreationButton(JFrame f){
		b1 = new JButton("Add New",new ImageIcon("src/tdl/icon/add_Circle.png"));

		class b1EventHandler implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent ae){
				new todoCreationDialog(f);
			}}
		b1.addActionListener(new b1EventHandler());
		b1.addMouseListener(this);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		b1.setOpaque(false);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		this.setLayout(new BorderLayout());
		this.add(b1);
		this.setVisible(true);
		/*Setting Color*/
		this.setBackground(Theme.themeColor1);
	}
	@Override
    public Dimension getMinimumSize() {
        return new Dimension(150, 35);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(230, 35);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(1000, 35);
    }
    @Override
	public void mouseClicked(MouseEvent e) {
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
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}




