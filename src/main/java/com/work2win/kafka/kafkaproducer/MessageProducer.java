package com.work2win.kafka.kafkaproducer;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;


public class MessageProducer {
	
	public static void main( String[] args )
    {
        System.out.println( "MessageProducer!" );
        Properties properties = new Properties();
     
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer(properties);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("samplemsg","messageproducer1");
        
        
        kafkaProducer.send(producerRecord);
       
        kafkaProducer.flush();
        kafkaProducer.close();
        
        
    }

}
