package com.jun.springboot.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jun.springboot.MyDataMongo;

public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, Long> 
{
	public List<MyDataMongo> findById(String A);
}
