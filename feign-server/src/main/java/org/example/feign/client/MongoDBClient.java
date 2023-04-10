package org.example.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.List;

@FeignClient(value = "MongoDBService")
public interface MongoDBClient {


    @GetMapping("/get/id")
    public String getJson4Id(@RequestParam("id")int id);

    @PostMapping("/post/json")
    public List<String> postJson4Result(@RequestBody HashMap map );

}
