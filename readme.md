#

This is an maven project for O4S - Api Assignment.

Please read this readme through and follow instruction after you read it all.
Also, please setup you eclipse/intellij to make auto formatting on save.

Follow instruction/instruction.pdf for detail on setting up eclipse/intellij.

## How to install:

**Preparation**

- Install eclipse/intellij java and jdk latest version (recommended to use >8) 
- Set JAVA_HOME env variable to jdk11 installation folder


**Building**
1. Build the project using maven.

```
mvn install - DskipTests
```

2. Open eclipse/intellij, and import the project
   - Right Click in Project Explorer -> Import
   - Existing Projects into Workspace, or Existing Maven Projects
   - Select the `desired project location` directory 

3. Configure your intellij to use the defined code style

**Environment Setting**

Before running test, we have to specify what is our target (system under test).

This environment info is defined in this resource file:

```
resources/config.properties

```

Please change the contents of above file accordingly.


**Test Class and XML**

The API automation xml files are located in the following resource folder:

```
../suite-files/*
```

Select one of the `***.xml` and run with TestNG. 
Recommended to use "AllSuite.xml" for running the suite


Develop your .xml test to combine unit test classes and put it here. Please select one of the following type of test:

- feature
  - feature focused tests, such as all processes-related test, menu-related test, etc.
- smoke
  - to be run for every build of process discovery master build
- sanity
  - to be run when a build is selected to be used for daily/weekly update, or before release
- regression
  - to be run when we want to check all kind of bug fix related test


**Running Test**
You can run TestNG from eclipse/intellij using your own laptop. But it is better to create a dedicated machine to run the test, to not interfere with your work.


## Design Principle
Please create the test following these principles as possible
- Test should be independence from each other, even tests within a class
- Be aware of scope and role of each class, just like normal programming. Separate utility class into other class.


# Convention

### Package Name

Every sub path of a package should be very simple and if possible one word. And a package should also more general (possible to contain more than one class).


If a package is too general, only then we can create a sub package. For example, when we have so many class in a process that can be categorized into `sample1` package and `sample2`. 


### Class Name

Class name should follow java convention on class name. 

The following keyword will be used for the shared convention.

`In Activities Package`
- This class should represent the specific page in the API, as granular as possible. 
- All actions that can be done in should be represented as method in the class. 
  DO NOT SEPARATE THE METHODS INTO DIFFERENT CLASS.

Reports:
For reports am using extent report which is generated inside TestReport folder

`Flow`
- When we run the AllSuite.xml file, then it is calling the respective class file.
- Inside each class file we have APIBase has all the API reutility methods.
- Inside Request Handler Class I have generating the Request and passing through the API body.
- For Query parameter and Path I have using data-provider.   

