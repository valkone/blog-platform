D:
cd D:\Programming\workspace\Java\blog
call mvn clean install
RD /S /Q "D:\ProgramFiles\apache-tomcat-8.0.30\webapps\blog"
del "D:\ProgramFiles\apache-tomcat-8.0.30\webapps\blog.war"
cd D:\Programming\workspace\Java\blog\target
xcopy /s /y "D:\Programming\workspace\Java\blog\target\blog.war" "D:\ProgramFiles\apache-tomcat-8.0.30\webapps"