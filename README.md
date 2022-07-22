# YuriiHudl
In this project I setup automation framework using Selenium and Cucumber. Project is written in Java v 16.0.1 and can be used on any machine using it.

Project structure:
1. Directory "Drivers" contains drivers to run tests in Chrome (version 103.0.5060.134) browser on Mac OS and Windows OS. If you currently have another version of Google Chrome, please visit https://chromedriver.chromium.org/downloads to download compatible driver. 
2. test -> java -> Features package contain "LoginPage.feature" file where you can find all automated test cases.
3. test -> java -> Pages package contains "LoginPage.java" file which contains all locators used to automate Log In functionality. Methods related to this page may be added in this class.
4. test -> java -> StepDifinitions contains "Base.java" which is used in order to allow all other step definitions to inherit connections to other classes. And "loginStepDef.java" which contains before and after methods as well as driver initialization.
5. test -> java -> TestRunner contains Runner.java which is necessary to connect .feature files with glue (step definitions package).
6. test -> java -> Utilities contains General.java file with all universal methods which can be reused for any future test on any future page.

In order to run tests you may need to upload Maven dependencies, Cucumber plugin. Project is set to run on Mac OS. So, if you are trying to run it on Windows open "test -> java -> StepDifinitions -> loginStepDef" and in "setup()" method comment line 19 and uncomment line 21.
