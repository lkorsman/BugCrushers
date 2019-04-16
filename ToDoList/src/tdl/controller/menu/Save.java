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

package tdl.controller.menu;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import tdl.controller.todo.todoController;
import tdl.model.Model;
import tdl.model.todoelements.ToDoElementStruct;
import tdl.view.Taps;

public class Save {
	public Save(String path){			 	
		try { 
			Taps.memotab.getmemo(); //get memo from memo view
			JSONObject personInfo = new JSONObject();
			personInfo.put("Logtxt", Model.logTextContents); 
			personInfo.put("memo", Model.memo);
			
			JSONArray PQList = new JSONArray();
			todoController ctr = new todoController();
			while (!ctr.PQCopy.isEmpty()) {
				ToDoElementStruct temps= ctr.PQCopy.poll();
				JSONObject StructInfo = new JSONObject();
				StructInfo.put("todoTxt", temps.getToDoText());
				StructInfo.put("Priority", temps.getPriority());
				StructInfo.put("Dday", temps.getDDay().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
				StructInfo.put("checkValue", temps.getCheckValue());
				PQList.add(StructInfo); 
			}
			personInfo.put("PQ", PQList);
			
			/*write file*/
			Writer file = new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8);
			file.write(personInfo.toJSONString()); 
			file.flush(); 
			file.close();
			JOptionPane.showMessageDialog(null, "Saved!");
			Model.FilePath = path;
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
}
