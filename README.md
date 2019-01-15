# CucumberCourse
Project  Course "Aprenda BDD com cucumber em JAVA - Udemy"

Teacher [Francisco Wagner Costa Aquino](https://www.udemy.com/user/francisco-wagner-costa-aquino/)

![alt text](https://tse4.mm.bing.net/th?id=OIP.HuQyl7_WMMzOfs8RIlQ-XAHaD4&pid=15.1&P=0&w=316&h=167)

## Course Objective:
Introduce BDD through Cucumber and JAVA

## Lessons:
1. Introduction
	1. BDD e Cucumber
	
2. Fundamentals
	1. Gherkin
	2. Integrating with JUnit
	3. CucumberOptions
	4. Asserts
	5. REGEX
	6. Transform
	7. Improving flow of scenarios
	8. Tags
	
3. BDD with Unitary Tests
	1. Data-Driven
	2. DataTable
	3. Reports
	4. Command Line Execution
	
4. Cucumber With Selenium
	1. Hooks
	2. Data Management for Testing
	3. Context
	4. Generalizing tests
	5. Screenshots
	6. Imperative scenarios x Declarative scenarios  

## Technologies used:
1. Eclipse;
2. Java;
3. Selenium;
4. Maven;
5. Cucumber;
6. OO.

## How run?
1. Download my [project](https://github.com/GustavoBrasil/CucumberCourse/archive/master.zip);
2. Open eclipse;
3. Import the project how "Maven project";
4. Open "pom.xml" and copy the code below:
```
<dependencies>
		<!-- https://mvnrepository.com/artifact/info.cukes/cucumber-java -->
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-java</artifactId>
			<version>1.2.5</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/info.cukes/cucumber-junit -->
		<dependency>
			<groupId>info.cukes</groupId>
			<artifactId>cucumber-junit</artifactId>
			<version>1.2.5</version>
			<scope>compile</scope>
		</dependency>

	</dependencies>
  ```
5. Right click about the project in eclipse;
6. Go on "Run as" > "JUnit Test"

