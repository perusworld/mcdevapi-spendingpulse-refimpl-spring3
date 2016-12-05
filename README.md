# Mastercard Developer API - ATM Locations - Reference Implementation - Spring 3.x #
Spring 3.x/Maven based reference implementation of Mastercard Developer API - ATM Locations 

## Requirements ##
1. JDK 1.7+
1. Maven

## Run with Remote Debug ##
```bash
set MAVEN_OPTS=-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000
mvn -Djetty.http.port=3000 -Dmastercard.api.p12.path="file:///C:/path-to-p12-file" -Dmastercard.api.consumer.key="api-key" jetty:run
```
## Package War ##
	mvn clean package

## Test REST APIs -cURL ##
### ATMs nearby ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
	"latitude": 40.737920,
	"longitude": -73.992781
}' "http://localhost:3000/atmsNearby"
```
