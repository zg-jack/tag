package com.dongnao.jack.tag;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class Test {
    
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext(
                "mytest.xml");
        System.out.println(app);
        MongoClient client = (MongoClient)app.getBean("mongo");
        System.out.println(client);
        
        DB db = client.getDB("zg_order");
        DBCollection con = db.getCollection("jack");
        DBObject o = new BasicDBObject();
        o.put("name", "Sam");
        o.put("age", 30);
        WriteResult wr = con.insert(o);
        System.out.println(wr.toString());
        
        Jedis client1 = (Jedis)app.getBean("redis");
        System.out.println(client1);
        
        System.out.println(client1.set("keyname1", "valuejack1"));
    }
}
