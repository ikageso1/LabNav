#!/bin/sh
java -cp "lib/*:lib/jetty/*:WebContent/WEB-INF/classes" app.ApplicationServer 8080 /LabNav WebContent
