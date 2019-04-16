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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import tdl.model.Model;
import tdl.model.todoelements.ToDoElementStruct;
import tdl.view.UpdateAllView;

public class Load {
	public Load(String path) throws org.json.simple.parser.ParseException, ParseException{
		JSONParser parser = new JSONParser();
		try { 
			Reader reader = new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8);
			JSONObject jsonObject = (JSONObject)parser.parse(reader);

			String Logtxt = (String) jsonObject.get("Logtxt");
			String memo = (String) jsonObject.get("memo");
			
			PriorityQueue<ToDoElementStruct> PQ = new PriorityQueue<>();
			
			//Array
			JSONArray arry = (JSONArray)jsonObject.get("PQ"); 
			Iterator<JSONObject> iterator = arry.iterator(); 
			while (iterator.hasNext()) { 
				JSONObject result = (JSONObject)iterator.next();
				PQ.offer(new ToDoElementStruct((
							String)result.get("todoTxt"), 
							(int)(long)result.get("Priority"), 
							LocalDate.parse((String)result.get("Dday"),DateTimeFormatter.ofPattern("yyyyMMdd")), 
							(Boolean)result.get("checkValue")
						));
			} 
			
			Model.priorityQueue = PQ;
			Model.logTextContents = Logtxt;
			Model.memo = memo;
			Model.FilePath = path;
			
			//update
			new UpdateAllView();
		}catch (FileNotFoundException e){ 
			e.printStackTrace(); 
		}catch (IOException e){ 
			e.printStackTrace(); 
		}
	}
}
