#!/bin/sh
java -cp "lib/*:lib/jetty/*:WebContent/WEB-INF/classes" app.WarFileServer 8080 /B14 B14.war
