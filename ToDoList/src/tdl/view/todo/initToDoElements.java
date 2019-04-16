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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tdl.controller.todo.todoController;
import tdl.model.Model;
import tdl.model.theme.Theme;

public class initToDoElements extends JScrollPane{
	JPanel toDoElementsP1;
	JFrame f1;
	initToDoElements(JFrame f){
		f1 = f;
		toDoElementsP1 = new JPanel();
		toDoElementsP1.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.CENTER));
		this.setViewportView(toDoElementsP1);
		this.setVisible(true);
	}	
	
	public void UpdateToDoView(){
		if(Model.priorityQueue.peek()==null){//nothing to do
			toDoElementsP1.removeAll();
			//�ʱ��̹���
			/*Setting color*/
			toDoElementsP1.setBackground(Color.white);
			BufferedImage myPicture;
			try {
				myPicture = ImageIO.read(new File("src/tdl/icon/toDoInitImage.png"));
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				toDoElementsP1.add(picLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}

			toDoElementsP1.revalidate();
		}else{
			todoController ctr = new todoController();
			toDoElementsP1.removeAll();
			while (!ctr.PQCopy.isEmpty()) {
				new addToDoElement(toDoElementsP1,ctr.PQCopy.poll(),f1);
			}
			toDoElementsP1.revalidate();
			toDoElementsP1.repaint();
			new addToDoElement(toDoElementsP1);
		}				
	}

	
	@Override
    public Dimension getMinimumSize(){
        return new Dimension(150, 30);
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(230, 30);
    }

    @Override
    public Dimension getMaximumSize(){
        return new Dimension(1000, 99990);
    }

}
