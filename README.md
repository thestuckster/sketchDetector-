# Sketch Detector

## Dependencies
**The code for the backend requires Java 1.8 or JDK8 to be installed.** Please install it like you would any other JDK.

The backend code is built (compiled) with Maven. Maven can be installed [here](https://maven.apache.org/download.cgi). Or by

    sudo apt-get install maven

on Ubuntu/Debian/Mint Or

    sudo pacman -S maven

on Arch Linux.

## Compiling and Building
Maven will compile and package all the code needed into a .jar file that can be ran with Java.

Navigate to the top of the file structure where **pom.xml** is located and run

    mvn clean
    mvn package

This will result in a new folder named **target** being generated. Navigate to **target** and run the jar file located there.

    java -jar filename.jar

If there are no errors you may then open up a browser and navigate to **localhost:8080/greeting** to see the default hello world JSON.
