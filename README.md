# BUG CRUSHERS TESTING DETAILS

## Application Build instructions in Eclipse
* To load into Eclipse: File > Import > Existing Project into Workspace > next > browse > Select root directory named “ToDoList” > next > Finish
* To find main.java and run app: ToDoList > src > tdl (package) > main.java > right click on main.java > Run As > Java Application

## JUnit Build instructions in Eclipse
* To find main, see section above.
* To run JUNIT tests: right click on main.java > Run as > Run configurations > In the “test” tab, click “browse” for the “Project” row > select “ToDoList”> In the “test” tab, click “search” for the “Test class” row > select “unitTests.ToDoElementStructTest” > click “Apply” > click “Run”

## Dependancies
* json_simple.1.1.jar
* LGoodCalendarAPI.jar

## Requirements/assumptions
* An ToDoListElementStruct object is only created when a valid todoText String is passed to the constructor. A valid todoTest String is not null and is at least 1 character in length. 
* An ToDoListElementStruct object is only created when a valid priority int is passed to the constructor. A valid priority int is between 1-5, inclusive.


# ORIGINAL README FILE

## ToDoList
Java ToDoList program. \
Easy to use, Good looking, Highly utilized, and Light.\
Used Java lang.
## Excution environment
JavaSE-1.8

## News
ToDoList 1.0 was released on Github in January 14, 2019.

## General Features
* To Do list with priority, memo, log, calendar.
* Create, edit, delete To Do.
* Priority can be assigned.
* Log view with complete date.
* To Do can be viewed in the calendar.(Not implemented yet)
* Three types of color theme available.(Not implemented yet)


## Screenshots
![picture](https://github.com/ohdaum/To-Do-List-Planer/blob/master/ToDoList%20Screenshots/Screenshots1.PNG)![picture](https://github.com/ohdaum/To-Do-List-Planer/blob/master/ToDoList%20Screenshots/Screenshots2.PNG)
![picture](https://github.com/ohdaum/To-Do-List-Planer/blob/master/ToDoList%20Screenshots/Screenshots3.PNG)![picture](https://github.com/ohdaum/To-Do-List-Planer/blob/master/ToDoList%20Screenshots/Screenshots4.PNG)
![picture](https://github.com/ohdaum/To-Do-List-Planer/blob/master/ToDoList%20Screenshots/Screenshots5.PNG)![picture](https://github.com/ohdaum/To-Do-List-Planer/blob/master/ToDoList%20Screenshots/Screenshots6.PNG)

## Thanks and acknowledgment to
* MIT LGoodDatePicker
The basic Calendar function of this program was originally inspired by MIT LGoodDatePicker.\
https://github.com/LGoodDatePicker/LGoodDatePicker

* ModifiedFlowLayout 
The main layout of ToDoList was inspired by this.\
Author Babu Kalakrishnan, Modifications by greearb and jzd\
https://stackoverflow.com/users/513838/jzd
