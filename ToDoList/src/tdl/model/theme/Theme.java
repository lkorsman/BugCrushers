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

package tdl.model.theme;

import java.awt.Color;

public class Theme {
	public static Color themeColor1 = Color.decode("#C8DEC9");
	public static Color themeColor2 = Color.decode("#FFF983");
	public static Color themeColor3 = Color.decode("#939FEA");
	public static Color themeColor4 = Color.decode("#F2F2F2");
	public static Color themeColor5 = Color.decode("#EE462F");
	public static Color themeColor6 = Color.decode("#EE607E");
	public static Color themeColor7 = Color.decode("#F3977F");
	public static Color themeColor8 = Color.decode("#FAD6CC");
	public static Color themeColor9 = Color.decode("#A3A3A3");
	public static Color themeColor10 = Color.decode("#474747");
	public static Color menuBarColor = Color.decode("#F2F2F2");
	public static Color tapsColor = Color.decode("#D9D9D9");

	public Theme(){
	}
	public void setTheme(int themeNumb){
		if(themeNumb==1){
			//Peach theme
			themeColor1 = Color.decode("#F66565");
			themeColor2 = Color.decode("#EE8B8B");
			themeColor3 = Color.decode("#E5E2D7");
			themeColor4 = Color.decode("#FFE1FF");
			//Highlight color
			themeColor5 = Color.decode("#E74C3C");
			themeColor6 = Color.decode("#EC7063");
			themeColor7 = Color.decode("#F1948A");
			themeColor8 = Color.decode("#F5B7B1");
			themeColor9 = Color.decode("#FADBD8");
			themeColor10 = Color.decode("#FDEDEC");
			menuBarColor = Color.decode("#F66565");
			tapsColor = Color.decode("#F66565");
		}else if(themeNumb==2){
			//Skyblue theme
			themeColor1 = Color.decode("#0269A6");
			themeColor2 = Color.decode("#30ABF3");
			themeColor3 = Color.decode("#0179A7");
			themeColor4 = Color.decode("#C6F3F4");
			//Highlight color
			themeColor5 = Color.decode("#3498DB");
			themeColor6 = Color.decode("#5DADE2");
			themeColor7 = Color.decode("#85C1E9");
			themeColor8 = Color.decode("#AED6F1");
			themeColor9 = Color.decode("#D6EAF8");
			themeColor10 = Color.decode("#EBF5FB");
			menuBarColor = Color.decode("#F66565");
			tapsColor = Color.decode("#F66565");
		}else if(themeNumb==3){
			//Dawn Theme
			themeColor1 = Color.decode("#C8DEC9");
			themeColor2 = Color.decode("#FFF983");
			themeColor3 = Color.decode("#939FEA");
			themeColor4 = Color.decode("#F2F2F2");
			//Highlight color
			themeColor5 = Color.decode("#EE462F");
			themeColor6 = Color.decode("#EE607E");
			themeColor7 = Color.decode("#F3977F");
			themeColor8 = Color.decode("#FAD6CC");
			themeColor9 = Color.decode("#A3A3A3");
			themeColor10 = Color.decode("#474747");
			menuBarColor = Color.decode("#F2F2F2");
			tapsColor = Color.decode("#D9D9D9");
		}else{
			//default Theme
			themeColor1 = Color.decode("#F66565");
			themeColor2 = Color.decode("#F66565");
			themeColor3 = Color.decode("#F66565");
			themeColor4 = Color.decode("#F66565");
			//Highlight color
			themeColor5 = Color.decode("#F66565");
			themeColor6 = Color.decode("#F66565");
			themeColor7 = Color.decode("#F66565");
			themeColor8 = Color.decode("#F66565");
			themeColor9 = Color.decode("#F66565");
			themeColor10 = Color.decode("#F66565");
			menuBarColor = Color.decode("#F66565");
			tapsColor = Color.decode("#F66565");
		}
	}
}
