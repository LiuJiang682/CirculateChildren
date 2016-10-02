# CirculateChildren

To run the application, please performs the following:

1. Download the zip file.
2. Unzip the zip file to a directory
3. Open a command prompt
4. In the command prompt, type: 
	
	cd path-to-your-directory
	
5. To build the app, in the command prompt, type:
	
	mvn clean install
	mvn package assembly:single
	
6. To run the app, in the command prompt, type:

	java -jar target/CirculateChildren-0.0.1-SNAPSHOT-jar-with-dependencies.jar

Or 

	java -jar target/CirculateChildren-0.0.1-SNAPSHOT-jar-with-dependencies.jar <numberOfChildren> <k>

for any number of children and k you like to provide.