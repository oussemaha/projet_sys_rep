# ToDo List Using RMI 

U can create  your own ToDo List and have access to it as long as your connected to the same network as the server.

The server creates an object of the class `Impl_List` and bind it in the RMI Registry so  the user, who already made connection with the server, can have access to the object and modify the List

### How to run it

Simply clone the repository and access to the `bin` directory then on your CLI write these commands (Java already installed) 

- start the server
```bash
  java server
```
- start the client
```bash
  java client
```
