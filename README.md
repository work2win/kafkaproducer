Kafka is a distributed event store and stream-processing platform. Kafka is used to build real-time streaming data pipelines and real-time streaming applications. 

# kafkaproducer

STEP 1: DOWNLOAD KAFKA IN WINDOWS AND INSTALL IT

STEP 2: Inside the config directory of kafka make sure the server.properties & zookeeper.properties are configured. For example in
server.properties - 
listeners=PLAINTEXT://localhost:9092 
zookeeper.properties-
dataDir=C:/kafka/zookeeper-data

STEP 3: START KAFKA
#start the zookeeper service
.\bin\zookeeper-server-start.sh .\config\zookeeper.properties
#start kafka broker service
.\bin\kafka-server-start.sh .\config\server.properties

STEP 4: CREATE TOPIC IN YOU JAVA CLASS

STEP 5: CREATE CONSUMER IN YOU JAVA CLASS
(refer the project)

For java class execute the producer & then the consumer class.

OFFSET EXPLORER
---------------

Offset Explorer (formerly Kafka Tool) is a GUI application for managing and using Apache Kafka clusters.

https://medium.com/@beheradebananda000/the-ultimate-guide-to-using-offset-explorer-a-gui-for-kafka-on-windows-e1a6b538a7b8

To clear kafka logs, you can delete it from C:\tmp\kafka-logs


 
