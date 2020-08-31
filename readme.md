This project is a springboot web project to implement a webhook
 to countpeople using RESTAPI.

####Implemented endpoints :
1. An endpoint to be called by People Counters and where they may send the results of the observations, as described in the “​Context​” section above. Requests produced by People Counters may be emulated with the following command:
curl --header "Content-Type: application/json" \
--request POST --data \ '{"sensor":"abc","ts":"2018-11-14T13:34:49Z","in":3,"out":2}' \ http://my-web-server/webhook
where http://localhost:8080/webhook is this endpoint URL and is assumed to be configured within the sensor.

2. An endpoint that provides an aggregated result of the number of people currently present in the building (a “stock”, based on the number of people who entered and left the building). Following is the command to emulate a request to this endpoint: curl --request GET http://my-web-server/peoplestock
and its sample output:
{ "inside": 42 }

3. peoplestock endpoint may take an optional query parameter: atInstant. When this parameter is defined the API is expected to provide the number of people that were present in the building at a given moment in time:
curl --request GET http://localhost:8080/peoplestock?atInstant=2018-11-14T14:00:00Z example output:
{ "inside": 9 }


####How to run the Project
The project is mavenized, to run it, you should :
- Build the project using command **mvn clean install** at root directory (countpeople)
- Go to directory **countpeople-app**
- Then enter command : **mvn spring-boot:run**


####Project architecture
The project is desegined according to hexagonal architecture with three layers
**countpeople-domain**
The hexagon. The upper module. Javax.transaction for transactions declaration. See pom.xml.

**countpeople-infra**
Infrastructure layer to handle data persistence

**countpeople-app**
the runnable artifact
- contains java main Class : entry point to launch the project
- the controller to handle requests
- link to infrastructure layer
