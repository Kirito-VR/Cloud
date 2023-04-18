package org.example.feign.client;

import org.example.feign.pojo.vo.DemoUserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "mysql-server")
public interface MysqlClient {
    @GetMapping("/demo-user/user-info")
    public DemoUserVO getUserVO(@RequestParam("id") int id);
}
