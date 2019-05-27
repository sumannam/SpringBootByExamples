package com.mongodb.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongodb.demo.MyDataMongo;
import java.util.List;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, Long> 
{
	public List<MyDataMongo> findByName(String s);
}