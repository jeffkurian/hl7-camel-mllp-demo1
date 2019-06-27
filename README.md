# hl7-camel-mllp-demo1
Demo processing HL7 using Camel mllp component on Spring Boot

Uses the camel-mllp component 
https://github.com/apache/camel/tree/master/components/camel-mllp

Running camel on Spring Boot.
https://github.com/apache/camel/tree/master/examples/camel-example-spring-boot
https://github.com/eugenp/tutorials/blob/master/spring-boot-camel/pom.xml


To Run:
mvn spring-boot:run 


Sample messages
ADT_A01

MSH|^~\&|system1|W|system2|UHN|200105231927||ADT^A01^ADT_A01|22139243|P|2.4
EVN|A01|200105231927|
PID||9999999999^^|2216506^||Duck^Donald^^^MR.^MR.||19720227|M|||123 Foo ST.^^TORONTO^ON^M6G 3E6^CA^H^~123 Foo ST.^^TORONTO^ON^M6G 3E6^CA^M^|1811|(416)111-1111||E^ ENGLISH|S| PATIENT DID NOT INDICATE|211004554^||||||||||||
PV1|||ZFAST TRACK^WAITING^13|E^EMERGENCY||369^6^13^U EM EMERGENCY DEPARTMENT^ZFAST TRACK WAITING^FT WAIT 13^FTWAIT13^FT WAITING^FTWAIT13|^MOUSE^MICKEY^M^^DR.^MD|||SUR||||||||I|211004554^||||||||||||||||||||W|||||200105231927|||||
PV2||F|^R/O APPENDICIAL ABSCESS|||||||||||||||||||||||||
IN1|1||001001|  OHIP||||||||||||^^^^^|||^^^^^^M^|||||||||||||||||||||||||^^^^^^M^|||||
ACC|


Visual studio hl7 plugin can be used to post the HL7 message
https://marketplace.visualstudio.com/items?itemName=RobHolme.hl7tools

Send the HL7 message to the server running,   in this case the camel-mllp component is listening on 127.0.0.1:8088

