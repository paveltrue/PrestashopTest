Hi, I'm Pavel and this is my test task

<h3>How to run tests on local machine?</h3>
I'm using GitBash and Maven

1. Use the following command:
<br> git clone https://github.com/paveltrue/PrestashopTest.git
2. Move to project root directory: 
<br> cd PrestashopTest/
3. Run command: mvn clean test
    Tests will run.
<br>
After tests finished you can see the test results.
<br> Test result image example: https://ibb.co/WyBpfrx

If you opened this project you can run tests by run 
suite that located in path: test/resources/suites/order-tests.xml

<h3>How to generate allure report?</h3>
1. Run the following command:
<br> mvn allure:serve
<br> Allure report image example https://ibb.co/HzSN7HY
   
<h3>Afterwords</h3>
<b> Some tests are failed because of bug related 
to price generating for several the same items</b>


