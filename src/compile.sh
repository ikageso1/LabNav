javac -J-Dfile.encoding=UTF-8 -cp "../lib/jetty/*:./mail/javax.mail.jar:sqlite-jdbc-3.8.7.jar:./" $1.java
java -Dfile.encoding=UTF-8 -cp "../lib/jetty/*:./mail/javax.mail.jar:sqlite-jdbc-3.8.7.jar:./" $1
