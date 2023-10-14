# kafkaproducer

STEP 1: DOWNLOAD KAFKA IN WINDOWS AND INSTALL IT

STEP 2: Inside the config directory of kafka make sure the server.properties & zookeeper.properties are configured. For example in
server.properties - 
listeners=PLAINTEXT://localhost:9092 
zookeeper.properties-
dataDir=C:/kafka/zookeeper-data

STEP 3: START KAFKA
#start zookeeper service
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
#start kafka broker service
.\bin\windows\kafka-server-start.bat .\config\server.properties

STEP 4: CREATE TOPIC TO STORE YOUR EVENTS
.\bin\windows\kafka-topics.bat --create --topic topic-example --bootstrap-server localhost:9092

STEP 5: WRITE SOME EVENTS INTO THE TOPIC
.\bin\windows\kafka-console-producer.bat --topic topic-example --bootstrap-server localhost:9092

STEP 6: TO READ THE EVENTS
.\bin\windows\kafka-console-consumer.bat --topic topic-example --from-beginning --bootstrap-server localhost:9092

STEP 8: READ EVENTS FROM THE APPLICATION

.\bin\windows\kafka-console-consumer.bat --topic samplemsg --from-beginning --bootstrap-server localhost:9092
 
