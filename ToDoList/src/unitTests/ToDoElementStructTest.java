package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
	
	/**
	 * -----------------------------------------------------------
	 * UNIT TESTS ADDED FOR MILESTONE 2 - GOAL: 100% CODE COVERAGE
	 * -----------------------------------------------------------
	 */
	
	/**
	 * Test 10
	 * 
	 * Test no argument constructor 
	 * Given: No arguments 
	 * Expect: Object to be not null
	 */
	
	@Test
	void ToDoElementStruct_noArgCtor_notNull() {
		
		ToDoElementStruct td = new ToDoElementStruct();
		assertNotNull(td);	
	}
	
	/**
	 * Test 11
	 * 
	 * Test getToDoText()
	 * Given: No arguments 
	 * Expect: String to match no arg ctor String
	 */
	
	@Test
	void ToDoElementStruct_getToDoText_MatchString() {
		
		String todoText = "studying philosophy...!";
		
		ToDoElementStruct td = new ToDoElementStruct();
		assertEquals(todoText, td.getToDoText());
	}
	
	/**
	 * Test 12
	 * 
	 * Test getDDay()
	 * Given: No arguments 
	 * Expect: LocalDate Dday to match no arg ctor's LocalDate
	 */
	
	@Test
	void ToDoElementStruct_getDDay_matchDDay() {
		
		LocalDate Dday = LocalDate.now().plusDays(7);
		
		ToDoElementStruct td = new ToDoElementStruct();
		assertEquals(Dday, td.getDDay());
	}
	
	/**
	 * Test 13
	 * 
	 * Test getCheckValue()
	 * Given: No arguments 
	 * Expect: checkValue to equal false 
	 */
	
	@Test
	void ToDoElementStruct_getCheckValue_isFalse() {
				
		ToDoElementStruct td = new ToDoElementStruct();
		assertEquals(false, td.getCheckValue());
	}
	
	/**
	 * Test 14
	 * 
	 * Test setToDoText(String s)
	 * Given: String = "test"
	 * Expect: getCheckValue to return a String = "test"
	 */
	
	@Test
	void ToDoElementStruct_setToDoText_StringEqualsTest() {
		
		String s = "test";
				
		ToDoElementStruct td = new ToDoElementStruct();
		td.setToDoText(s);
		assertEquals(s, td.getToDoText());
	}
	
	/**
	 * Test 15
	 * 
	 * Test setPriority(int i)
	 * Given: int = 1
	 * Expect: priority = 1
	 */
	
	@Test
	void ToDoElementStruct_setPriority_IntEquals1() {
		
		int i = 1; 
				
		ToDoElementStruct td = new ToDoElementStruct();
		td.setPriority(i);
		assertEquals(i, td.getPriority());
	}
	
	/**
	 * Test 16
	 * 
	 * Test setDday(LocalDate iDday)
	 * Given: LocalDate a 8 days from today
	 * Expect: Dday to equal given LocalDate
	 */
	
	@Test
	void ToDoElementStruct_setDday_DdayEquals8DaysFromToday() {
		
		LocalDate Dday = LocalDate.now().plusDays(8);
				
		ToDoElementStruct td = new ToDoElementStruct();
		td.setDday(Dday);
		assertEquals(Dday, td.getDDay());
	}
	
	/**
	 * Test 17
	 * 
	 * Test setCheckValue(boolean bool)
	 * Given: CheckValue = True
	 * Expect: CheckValue to be set to True
	 */
	
	@Test
	void ToDoElementStruct_setCheckValue_CheckValueEqualsTrue() {
		
		boolean b = true; 
				
		ToDoElementStruct td = new ToDoElementStruct();
		td.setCheckValue(b);
		assertEquals(b, td.getCheckValue());
	}
	
	/**
	 * Test 18
	 * 
	 * Test setCheckValue(boolean bool)
	 * Given: CheckValue = True
	 * Expect: CheckValue to be set to True
	 */
	
	/**
	 * Test 18
	 * 
	 * Test printThis()
	 * Given: No arguments
	 * Expect: void 
	 */

	@Test
	void ToDoElementStruct_printThis_StringsAreEqual() {
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		PrintStream originalOut = System.out;
		
		String s = "to do : studying philosophy...!/ priority : 5/ Dday : " + LocalDate.now().plusDays(7) + "\n";

		// set up
		System.setOut(new PrintStream(outContent));
				
		// test
		ToDoElementStruct td = new ToDoElementStruct();
		td.printThis(); 
		
		assertTrue(s.equals(outContent.toString()));
		
		// reset 
	    System.setOut(originalOut);

	}

	/**
	 * Test 19
	 * 
	 * Test compareTo(ToDoElementStruct target) - test if
	 * Given: ToDoElementStruct object with test priority greater than target priority
	 * Expect: returns 1
	 */
	
	@Test
	void ToDoElementStruct_compareTo_hitIf_returnOne() {

		ToDoElementStruct td_target = new ToDoElementStruct();
		td_target.setPriority(1);
		ToDoElementStruct td_test = new ToDoElementStruct();

		assertEquals(1, td_test.compareTo(td_target));
	}
	
	/**
	 * Test 20
	 * 
	 * Test compareTo(ToDoElementStruct target) - else if
	 * Given: ToDoElementStruct object with test priority less than target priority
	 * Expect: returns 1
	 */
	
	@Test
	void ToDoElementStruct_compareTo_hitElseIf_returnNegOne() {

		ToDoElementStruct td_target = new ToDoElementStruct();
		ToDoElementStruct td_test = new ToDoElementStruct();
		td_test.setPriority(1);

		assertEquals(-1, td_test.compareTo(td_target));
	}
	
	/**
	 * Test 21
	 * 
	 * Test compareTo(ToDoElementStruct target) - hidden else 
	 * Given: ToDoElementStruct object with test priority = target priority
	 * Expect: returns 0
	 */
	
	@Test
	void ToDoElementStruct_compareTo_hitHiddenElse_returnZero() {

		ToDoElementStruct td_target = new ToDoElementStruct();
		ToDoElementStruct td_test = new ToDoElementStruct();

		assertEquals(0, td_test.compareTo(td_target));
	}	
	
}
