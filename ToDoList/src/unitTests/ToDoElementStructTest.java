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
	 * Expect: Throws Illegal Argument Exception because an object is only created 
	 * with valid String parameters. A valid String is not null and at least 1 
	 * character in length. 
	 */
	@Test
	void ToDoElementStruct_ctorStringNull_Exception() {
		
		String txt = null; 
		int prio = 0; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		assertThrows(IllegalArgumentException.class, () -> {
			ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);	 
		});
	}
	
	/**
	 * Test 2
	 * 
	 * Test String parameter in ctor 
	 * Given: empty String
	 * Expect: Throws Illegal Argument Exception because an object is only created 
	 * with valid String parameters. A valid String is not null and at least 1 
	 * character in length. 
	 */
	@Test
	void ToDoElementStruct_ctorStringEmpty_Exception() {
		
		String txt = ""; 
		int prio = 0; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		assertThrows(IllegalArgumentException.class, () -> {
			ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);	 
		});
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
	
	// Testing Constructor int parameter 
	
	/**
	 * Test 5
	 * 
	 * Test int parameter in ctor 
	 * Given: negative int (-1)
	 * Expect: Throws Illegal Argument Exception because an object is only created 
	 * with valid int parameters. A valid int between 1-5, inclusive.
	 */
	@Test
	void ToDoElementStruct_ctorIntNegative_Exception() {
		
		String txt = "to do item"; 		
		int prio = -1; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		assertThrows(IllegalArgumentException.class, () -> {
			ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);	 
		});	
	}
	
	/**
	 * Test 6
	 * 
	 * Test int parameter in ctor 
	 * Given: priority of zero
	 * Expect: Throws Illegal Argument Exception because an object is only created 
	 * with valid int parameters. A valid int between 1-5, inclusive.
	 */
	@Test
	void ToDoElementStruct_ctorIntZero_Exception() {
		
		String txt = "to do item"; 		
		int prio = 0; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		assertThrows(IllegalArgumentException.class, () -> {
			ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);	 
		});		
	}
	
	/**
	 * Test 7
	 * 
	 * Test int parameter in ctor 
	 * Given: Priority equal to min value (1)
	 * Expect: Priority equals 1
	 */
	@Test
	void ToDoElementStruct_ctorIntLMinVal_Equals1() {
		
		String txt = "to do item"; 		
		int prio = 1; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);
		assertEquals(prio, td.getPriority());	
	}
	
	/**
	 * Test 8
	 * 
	 * Test int parameter in ctor 
	 * Given: Priority equal to max value (5)
	 * Expect: Priority equals 5
	 */
	@Test
	void ToDoElementStruct_ctorIntLMaxVal_Equals5() {
		
		String txt = "to do item"; 		
		int prio = 5; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);
		assertEquals(prio, td.getPriority());	
	}
	
	/**
	 * Test 9
	 * 
	 * Test int parameter in ctor 
	 * Given: Priority equal to max GUI value + 1 (6)
	 * Expect: Throws Illegal Argument Exception because an object is only created 
	 * with valid int parameters. A valid int between 1-5, inclusive.
	 */
	@Test
	void ToDoElementStruct_ctorIntLMaxGuiVal_Exception() {
		
		String txt = "to do item"; 		
		int prio = 6; 
		LocalDate da = LocalDate.now(); 
		boolean bool = false; 
		
		assertThrows(IllegalArgumentException.class, () -> {
			ToDoElementStruct td = new ToDoElementStruct(txt, prio, da, bool);	 
		});	
	}
	
}
