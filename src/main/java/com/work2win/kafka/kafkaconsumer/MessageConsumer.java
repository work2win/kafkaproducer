package com.work2win.kafka.kafkaconsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringSerializer;

import com.work2win.kafka.kafkaproducer.MessageProducer;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;

public class MessageConsumer {
	
	static Logger logger = Logger.getLogger(MessageProducer.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties properties = new Properties();
	     
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "messageConsumerGroup"+UUID.randomUUID());
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");       
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        
        
			try {
				
		        consumer.subscribe(Arrays.asList("sampleTopicName"));
				logger.log(Level.INFO, "message received");
			}catch(Exception e) {
				e.printStackTrace();
				e.getStackTrace();
			}
		        
        
			
			 while (true) {
				 
				ConsumerRecords<String, String> records = consumer.poll(100);				 
			 
			    for (ConsumerRecord<String, String> record : records){
				 	logger.info("Key: " + record.key() + ", Value: " + record.value());
				 	logger.info("Partition: " + record.partition() + ", Offset:" + record.offset());
	            }
	         }

	}

}
