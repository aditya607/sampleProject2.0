Hi there , we are goiing to create a project of dropwizard.

**Step1:** (creating a project)
- create a project (in gradle using java)

**step2:** (adding dropwizard dependency)
- add Drowizard dependency in gradle build  (implementation group: 'io.dropwizard', name: 'dropwizard-core', version: '2.0.21')
- then you create a AppConfig class (that extends Configuration class of dropwizard)
- then You create a MainApplication class (that extends Application<AppConfig> of dropwizard)
   - you need to add a main method (psvm) and a run method (that is called from main method)
_you basic dropwizard project is ready (you can run MainApplication class and build , it will work fine)_

**step3:** (making your project as Application, so that it runs as an application)
- adding a config.yml or config.yaml file ( for ports on which our application runs)
    - here you mention server applicationConnector and adminConnector type and port.
- then app application plugin in gradle build (id 'application')
- define main class in gradle build (setMainClassName("MainApplication") in application task) - (or will give error main class not defined)
- then you need to add run args (args = ['server', 'config.yaml'] in run task)- (or application will not start completely as you have not provided the port)
your project is ready and you can run it as application on the port you configured in config.yml file 