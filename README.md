# MobiquityAutomationFramework
Using this framework we can automate the web application.

Why Mobiquity Automation Framework?
==================================================================================

- Solution for Web automation
- Can run automation on chrome,safari browsers
- Automation report with embedded screenshots for success and failure scenarios.
- Console logs
- Retry mechanism for Failed testcases
- Integrated with Maven
- Easy to maintain

Tools & libraries
==================================================================================

The test automation framework is comprised of following tools and libraries  

- Selenium WebDriver [3.141.59]: - Browser automation
- JAVA  [1.8]: - Programming language  
- TestNg [6.14.3]: - TestNg Java testing framework  
- Maven : - Build tool       
- Git: - Version Control  
- Intellij Or Eclipse: - Integrated Development Environment  
- Loggers [1.2.17]: - Log4J
- Reporting tool [2.41.2]:- Extent Manger
- Jenkins : CI tool

Framework Setup steps
==================================================================================

Download folder backbase from https://drive.google.com/drive/folders/1xhR_YOryMDfkmlavBJJF0vguZYknRhcE?usp=sharing


4.  Create your folder, navigate to folder in terminal

Run automation for Web
==================================================================================

Open terminal  and  navigate to downloaded  folder and  execute command “mvn clean install -Dplatform=web -Dbrowser=Chrome -Dgroups=sanity” 

This will add your local backBase into the local maven repository. You can see the build log for a message that mentions about this addition.

After this, Run below command from project folder

mvn test
-Dplatform=web
-Dbrowser=Chrome  [Chrome,safari]
-Dgroups=sanity [sanity,regression] 

| Parameter        | Required/Optional |Comments  |
| ------------- |:-------------:| -----:|
| browser      | Required | e.g chrome,safari|
| platform      | Required | e.g. web|
| groops        |Required   | e.g.  sanity,regression|



# Advance help

   *Reach out to Bhagatsinh Kher for  further help
   




