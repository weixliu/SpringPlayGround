#Tips
- spring-boot jmx remotely
```
-Dcom.sun.management.jmxremote 
-Dcom.sun.management.jmxremote.port=8888 
-Dcom.sun.management.jmxremote.authenticate=false 
-Dcom.sun.management.jmxremote.ssl=false
```
Then you can use jconsole connect the remote jmx server.

[spring-boot features: Admin feature](https://docs.spring.io/spring-boot/docs/2.0.0.M5/reference/htmlsingle/#boot-features-application-admin)

- Check port used condition in Mac OSX
```
lsof -i :8080 | grep LISTEN
ps -ef 42975
kill -9 42975
```

- 
