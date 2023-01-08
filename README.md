# Snake
### Team: Purple Pain
<hr>

### About
The classic Snake game, now available on your computer screen!

Relieve hundreds of hours of fun with this new take on one of the most popular games in history.


### Prerequisites
Java SDK 17 and JavaFX 17

### Starting the app
Clone the project and wait for the gradle build to finish. 
If there are errors when building, see the `Troubleshooting` section

Open the `at.ac.fhcampuswien.snake.SnakeApp` class and start it via the main method. 

If using IntelliJ, a green arrow will appear in the gutter, next to the class name or next to the main method. 
Clicking the arrow will start the app and create a run config in IntelliJ


### Troubleshooting

If you're seeing an error message saying `JavaFXPlugin has been compiled by a more recent version of the Java Runtime`, 
you might have a wrong JVM set for Gradle and you must change it to SDK17

If you're using IntelliJ IDEA and having this error, try this:

* Open IntelliJ settings (Ctrl + Alt + S on Windows or Command + , on Mac)
* Build, Execution, Deployment > Build Tools > Gradle
* Gradle JVM > Change it to SDK 17
