#!/bin/sh
java -cp "lib/*:lib/jetty/*:bin/classes" app.ApplicationServer 8080 /LabNav WebContent
