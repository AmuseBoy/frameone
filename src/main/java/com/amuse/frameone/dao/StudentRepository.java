package com.amuse.frameone.dao;

import com.amuse.frameone.common.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName StudentRepository
 * @Description Mongo的底层接口
 * @Author 刘培振
 * @Date 2018/10/12 17:03
 * @Version 1.0
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {


}
