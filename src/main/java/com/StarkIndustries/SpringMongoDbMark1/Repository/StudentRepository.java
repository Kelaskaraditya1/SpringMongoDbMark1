package com.StarkIndustries.SpringMongoDbMark1.Repository;

import com.StarkIndustries.SpringMongoDbMark1.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {
}
