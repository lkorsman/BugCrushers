package tdl.view;

import tdl.view.todo.initToDo;

public class UpdateAllView {
	public UpdateAllView(){
		initToDo.inittoDoElements.UpdateToDoView();
		Taps.logtab.UpdateLogView();
		Taps.memotab.updatememoView();
		//maybe calendar update
	}
}
