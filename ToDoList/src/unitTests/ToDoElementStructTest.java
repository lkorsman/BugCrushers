package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tdl.model.todoelements.ToDoElementStruct;

class ToDoElementStructTest {

	// Testing Constructor String parameter 
	
	/**
	 * Test 1
	 * 
	 * Test String parameter in ctor 
	 * Given: null String
	 * Expect: not null object
	 */
	@Test
	void ToDoElementStruct_ctorStringNull_notNull() {
		
		String txt = null; 
		int prio = 0; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);
		assertNotNull(td);	
	}
	
	/**
	 * Test 2
	 * 
	 * Test String parameter in ctor 
	 * Given: empty String
	 * Expect: not null object
	 */
	@Test
	void ToDoElementStruct_ctorStringEmpty_notNull() {
		
		String txt = ""; 
		int prio = 0; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);
		assertNotNull(td);	
	}
	
	/**
	 * Test 3
	 * 
	 * Test String parameter in ctor 
	 * Given: String with non-alphabetical characters
	 * Expect: not null object
	 */
	@Test
	void ToDoElementStruct_ctorStringNonAlpha_notNull() {
		
		String txt = "!@#$%^&*()"; 
		int prio = 0; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);
		assertNotNull(td);	
	}
	
	/**
	 * Test 4
	 * 
	 * Test String parameter in ctor 
	 * Given: String with non-English characters
	 * Expect: not null object
	 */
	@Test
	void ToDoElementStruct_ctorStringNonEnglish_notNull() {
		
		String txt = "\u0400\u9986\u9994\u10084"; 		// Non-English characters in Unicode
		int prio = 0; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);
		assertNotNull(td);	
	}
	
	/**
	 * Test 5
	 * 
	 * Test String parameter in ctor 
	 * Given: String with non-English characters
	 * Expect: not null object
	 */
	@Test
	void ToDoElementStruct_ctorStringCompareNonEnglishTxt_notNull() {
		
		String txt = "\u0400\u9986\u9994\u10084"; 		// Non-English characters in Unicode
		int prio = 0; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);
		assertEquals(txt, td.getToDoText());	
	}
	


}
