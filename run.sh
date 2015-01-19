#!/bin/sh
java  -Dfile.encoding=UTF-8 -cp "lib/*:lib/jetty/*:WebContent/WEB-INF/classes" app.ApplicationServer 8080 /B14 WebContent 
