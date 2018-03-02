package vietung.it.dev.vudoanv7.controllers;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public String addNews(){
        MongoCredential credential = MongoCredential.createCredential("vietungit","dbmg_doan", "1234567890".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("ds151508.mlab.com",51508), Arrays.asList(credential));
        MongoDatabase db = mongoClient.getDatabase("dbmg_doan");

        MongoCollection<Document> col = db.getCollection("news");
        Document doc = new Document();
        doc.append("name","VietUngIT_02");
        doc.append("age",24);
        col.insertOne(doc);
        return "1";
    }
}
