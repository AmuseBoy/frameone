package com.amuse.frameone.web;

import com.amuse.frameone.common.model.Student;
import com.amuse.frameone.common.util.ResultUtil;
import com.amuse.frameone.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName MongoController
 * @Description TODO
 * @Author 刘培振
 * @Date 2018/10/12 15:29
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/mongo")
public class MongoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 保存到mongo中
     * @param student
     * http://localhost:8002/mongo/save
     * {
     * "id":1,
     * "name":"王八"
     * }
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void saveUser(@RequestBody Student student){
        //1.使用mongoTemplate方式
        //mongoTemplate.save(user);

        //2.使用接口方式
        studentRepository.save(student);
    }

    /**
     * http://localhost:8002/mongo/findByName?name=王八
     * @param name
     * @return
     */
    @RequestMapping(value = "/findByName",method = RequestMethod.GET)
    public Map<String,Object> findByName(@RequestParam String name){
        Query query = new Query(Criteria.where("name").is(name));
        Student student = mongoTemplate.findOne(query,Student.class);
        return new ResultUtil().success(student);
    }

    /**
     * http://localhost:8002/mongo/update
     * {
     * "id":1,
     * "name":"王八蛋"
     * }
     * @param student
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(@RequestBody Student student){
        Query query = new Query(Criteria.where("id").is(student.getId()));
        Update update = new Update().set("name",student.getName());
        mongoTemplate.updateFirst(query,update,Student.class);
    }

    /**
     * http://localhost:8002/mongo/delete?id=1
     * @param id
     */
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public void delete(@RequestParam String id){
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Student.class);
    }
}
