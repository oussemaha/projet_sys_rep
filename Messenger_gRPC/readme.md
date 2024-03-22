# Messenger_Chat Using gRPC 

This applications is an exemple of a chat service. Your messages have only one recipient that you specify and aren't broadcasted.

you'll find two Maven projects, one for the server and one for the client

### How to run it

please note that these commands won't  probably work on **Windows powershell** so i advise that you execute them on **CMD**.
For **Linux** everything works fine.

You shoud be sure that you have `maven` installed with java.

It was built and tested using **JAVA 20** and **Maven 3.9.6**

- Clone the repository
- Make you sure that you're inside the project folder either `server` or `client`
- Start the server
```bash
  mvn exec:java -Dexec.mainClass=messenger.server
```
- Start the client
```bash
  mvn exec:java -Dexec.mainClass=messenger.client
```
- If you face any problem with one of the maven projects try to rebuild the project by simply running 
```bash
mvn
```
