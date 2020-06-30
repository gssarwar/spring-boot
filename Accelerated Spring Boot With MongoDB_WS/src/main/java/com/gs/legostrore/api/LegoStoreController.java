package com.gs.legostrore.api;

import com.gs.legostrore.model.LegoSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("legostore/api")
@Slf4j
public class LegoStoreController {

    private MongoTemplate mongoTemplate;

    @Autowired
    public LegoStoreController(MongoTemplate mongoTemplate){
        this.mongoTemplate=mongoTemplate;
    }
    @PostMapping
    public void insert(@RequestBody LegoSet legoSet){
        mongoTemplate.insert(legoSet);
    }

    @GetMapping("/all")
    public Collection<LegoSet> getAll(){
        List<LegoSet> all = this.mongoTemplate.findAll(LegoSet.class);
        System.out.println(all);
        return all;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  String id){
        System.out.println("id value is "+id);
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,LegoSet.class);
    }

    @PutMapping
    public void update(@RequestBody LegoSet legoSet){
        mongoTemplate.save(legoSet);
    }


}
