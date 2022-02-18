# circuit-breaker-resilience4j

This project is to implement circuit breaker design pattern.

We are using hystrix as circuit breaker to break circuit in following cases :

* When underlying service is not available.
* When underlying service is available but not responding in expected time.
* When underlying service is available and responding in correct timeframe but not returning expected results.

Kindly consider demo-api project to run sample demo api.