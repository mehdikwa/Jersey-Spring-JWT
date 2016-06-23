# Jersey-Spring-JWT
Spring security for rest API with JWT Token

> Authentication mechanism with a rest API capable of authenticating a user against an LDAP and/or DB depending on the available system. 
> The solution is based on Jersey for REST implementation, Spring for the wiring and security and JWT for the token generation.

### Build and Run
* mvn clean install
* On module AuthenticationRestAPI do an **mvn clean install  jetty:run -Djetty.port=8888**
