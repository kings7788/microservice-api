package com.bryant.springcloud.controller;

import com.bryant.springcloud.entity.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RestController
public class DeptController_Consumer
{
    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_HAIFENG = "http://156.236.72.229:3020/api/pay/create_order";
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept){
        log.warn("dept:{}",dept);
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }
    @RequestMapping(value = "/test/xxx")
    public String test(){
        return restTemplate.getForObject(REST_URL_HAIFENG+"?params="+"%7B%22amount%22%3A%2210000%22%2C%22mchId%22%3A%222066693%22%2C%22productId%22%3A%228007%22%2C%22mchOrderNo%22%3A%2220200813142240635979%22%2C%22subject%22%3A%2220200813142240635979%22%2C%22clientIp%22%3A%22121.76.159.174%22%2C%22sign%22%3A%2235830F1CBA183DFDD7BF8C4935757B6D%22%2C%22notifyUrl%22%3A%22http%3A%2F%2F66p.badej8888.com%3A30000%2FrespPayWeb%2FHAIFENGZHIFU_BANK_WAP_ZFB_SM%2F%22%2C%22currency%22%3A%22cny%22%2C%22body%22%3A%2220200813142240635979%22%7D", String.class);
    }
}
