# Mastercard Developer API - Sector Insights - Reference Implementation - Angular/Spring 3.x #
Spring 3.x/Maven/Angular based reference implementation of Mastercard Developer API - Sector Insights 

## [Demo](https://perusworld.github.io/mcdevapi-sector-insights-web/) ##

## Requirements ##
1. JDK 1.7+
1. Maven
1. Bower
   

## Setup Client App (optional if you want to host the sample client app) ##
This setups up the same client app that is being used in [Mastercard Developer API - Sector Insights - Reference Implementation - Angular/Express](https://github.com/perusworld/mcdevapi-sector-insights-web)

```bash
git submodule init
git submodule update
cd  src/main/webapp/WEB-INF/ref-html
bower install
```

## Run with Remote Debug ##
```bash
set MAVEN_OPTS=-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000
mvn -Djetty.http.port=3000 -Dmastercard.api.p12.path="file:///C:/path-to-p12-file" -Dmastercard.api.consumer.key="api-key" jetty:run
```

## Package War ##
```bash
mvn clean package
```

## Test App ## 
Open browser and goto [http://localhost:3000](http://localhost:3000)

## Test REST APIs -cURL ##
### Query insights using sector/period/country sent as part of JSON post ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
	"country": "US",
	"sector": "U.S. Natural and Organic Grocery Stores",
	"period": "Monthly"
}' "http://localhost:3000/insights"
```

### Query available reports ###
```bash
curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '' "http://localhost:3000/parameters"
```
