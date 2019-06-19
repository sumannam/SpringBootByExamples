package com.kim.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kim.springboot.MyDataMongo;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, Long> 
{
	public List<MyDataMongo> findById(String k);
	public void deleteById(String param);
}
