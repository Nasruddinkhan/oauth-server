# First Step
Generate the jks from java keytool.

C:\Program Files\Java\jdk-17.0.1\bin>keytool -genkey -keystore C://oauth.jks -keyalg RSA -alias oauth

# Convert to the certificate

keytool -export -alias oauth -file "C://oauth_cert.cer" -keystore "C://oauth.jks"

# generate the public key

keytool -export -alias oauth -keystore  D:\Projects\oauth-server\src\main\resources\oauth.jks -rfc -file "D:\Projects\oauth-server\src\main\resources\public.cert

import the postman collection under the resource folder & execute one by one later will create the resource server and share the link please find the below link for new authorization server
https://github.com/Nasruddinkhan/spring-new-authorization-server

If you add any new role please update the socpe as well.
