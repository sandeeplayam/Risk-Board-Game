# Sysc-3110-4
3rd year design project


## Group Infomation
ReadMe File
Group Name: 4
Author: Yasin Jaamac and Sudarsana Sandeep

Group Members: Danish Butt,  Yusuf Jaamac,  Yasin Jaamac,  Sudarsana Sandeep

This is the foruth milestone of the project for the game Risk and includes a gui based version with additonal features such as save/load and custom maps.. The authors are Sudaransa Sandeep, Yasin Jaamac, Danish Butt and Yusuf Jaamac. 

Some of the changes from last time include fixing the bonus armies in the first turn, overriding all the map information, and changing input comparision so now the user can enter any combination of lower/upper case letters when entering counries and the program will convert them to uppercase in the code to do the comparision. One thing is that instead of adding a drop down list during bonus armies what we did is every time you enter a country name it will pop up the map state so you can see what countries you own before you enter in the next country. Another thing is for the ownContinent code smell we changed it and instead iterated thorugh the continents lists.

When creating the custom maps feature we assumed 2 things: 
1) It is assumed that the player places the countries in each continent separately (from each other and doesn't mix countries that are in different continents)
2) It is assumed that the player enters the correct adjacent countries when prompted

The custom maps feature does check if each map is valid by taking in the adjacent countries and checking that there is a path from each country to every other country.

There are 3 known issues for custom maps. The first one is that if you are using windows to run the program when you press add a country it will add it to the top left corner, but it will not be visible until you hover of the top left corner of the screen. This only happens when using windows. If you use a mac it shows up right away. The second issue is that we were not able to add any lines to connect the different continents on the custom map. The last issue is when running the jar when you click on custom maps and go through the process when you get to the part of the adjacent countries and you enter them in, after this it does not do anything. But when you run the actual code (in intellij) at this point it will let you know if the map is valid or not. Everything else works in the jar except at this one step.

The deliverables included is the source code, jar file, UML class diagram, two UML sequence diagrams, design choices document, user manual, and readMe. We fixed all the known issues from milestone 1, have addressed the TA's feedback and implemented accordingly.
