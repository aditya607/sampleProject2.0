Hi there , we are goiing to create a project of dropwizard.

### **Step1:** (creating a project)
- create a project (in gradle using java)

### **step2:** (adding dropwizard dependency)
- add Drowizard dependency in gradle build  (implementation group: 'io.dropwizard', name: 'dropwizard-core', version: '2.0.21')
- then you create a AppConfig class (that extends Configuration class of dropwizard)
- then You create a MainApplication class (that extends Application<AppConfig> of dropwizard)
   - you need to add a main method (psvm) and a run method (that is called from main method)
   
_**you basic dropwizard project is ready (you can run MainApplication class and build , it will work fine)**_

### **step3:** (making your project as Application, so that it runs as an application)
- adding a config.yml or config.yaml file ( for ports on which our application runs)
    - here you mention server applicationConnector and adminConnector type and port.
- then app application plugin in gradle build (id 'application')
- define main class in gradle build (setMainClassName("MainApplication") in application task) - (or will give error main class not defined)
- then you need to add run args (args = ['server', 'config.yaml'] in run task)- (or application will not start completely as you have not provided the port)

_**your project is ready and you can run it as application on the port you configured in config.yml file**_ 

### **step4:** (we will add a resource class in our application and a get method)
- adding lombok dependency in project (for getter and setter method) - (ignore if you want , create getter and setter manually)
- then you create an object(eg- person) class and a resource class (eg -PersonResource) with endPoint provided.
- register that resource class in environment jersery (in run method of MainApplication class).
- run the application and test the endpoint , it should be working.

_**Now your project is an application running with a endpoint on particular port , which you can hit**_

### step5: (optional (if you want you can create a shadow jar of your application))
- add shadow jar plugin (id 'com.github.johnrengelman.shadow' version '6.0.0') 
- override task shadowJar  with 
    archiveBaseName = 'raja'
    mergeServiceFiles()
    exclude 'META-INF/*.DSA'
    exclude 'META-INF/*.RSA'
  then build your application , in build/libs you will find your shadow jar (raja-1.0-SNAPSHOT-all.jar)
- for running that jar file (java -jar build/libs/raja-1.0-SNAPSHOT-all.jar server config.yaml)

_**Now you have application jar , which you can run anywhere (with basic system setup)**_

== required docker on your system
### step6: (we need to create a image of your application , so it can run at any place)
- first of all create a File name "Dockerfile" , then copy jar , config and provide a run CMD 
- expose the port you want to access from your localhost.
- docker build -t imageName:version . (run this command , where your Dockerfile is present), after this you can see a new image in docke(do docker images)
- for running docker run -p localport:containerPort imageID

_**Now you have image of your running application , which you can run any where**_
