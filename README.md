<h1>GitHub resume application</h1>

<h3>Usage:</h3>
1) Run mvnspring-boot:run command
2) Call endpoint http://localhost:8080/v1/accounts/{accountName} to retrieve info about account
3) If you want to change Media Type of response user request param ?mediaType= (Available types are application/xml, application/json)

<h3>Possible improvements (not implemented due to lack of time)</h3>
1) Add unit tests for each service in the app
2) To make application faster it's possible to fetch repositories info in parallel using multithreading after account endpoint has been called. Note: with this implementation we would need to use join() method to make sure that info calculation for each thread has completed before calculating account aggregation
