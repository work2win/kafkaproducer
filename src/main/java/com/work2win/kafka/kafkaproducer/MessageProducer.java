package com.work2win.kafka.kafkaproducer;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;


public class MessageProducer {
	
	static Logger logger = Logger.getLogger(MessageProducer.class.getName());
	
	public static void main( String[] args )
    {
        
        Properties properties = new Properties();
     
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer(properties);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("sampleTopicName","messageproducer1");
        
        
        try {
			kafkaProducer.send(producerRecord).get();
			logger.log(Level.INFO, "message sent");
		} catch (Exception e) {
			
			e.printStackTrace();
			e.getStackTrace();
		}
       
        kafkaProducer.flush();
        kafkaProducer.close();
        
        
    }

}
