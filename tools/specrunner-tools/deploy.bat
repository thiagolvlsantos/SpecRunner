mvn -U -Pdeploy clean source:jar javadoc:jar deploy & copy /Y target\*clean.zip ..\downloads