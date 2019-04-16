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

import java.awt.Dialog;

import javax.swing.JFrame;

public class AdjustDialog{
	public AdjustDialog( JFrame f, Dialog dia){
		int xpos = (int) (f.getX() + f.getWidth()/2 - dia.getWidth()/2);
		int ypos = (int) (f.getY() + f.getHeight()/2 - dia.getHeight()/2);
		dia.setLocation(xpos,ypos);
	}
}
