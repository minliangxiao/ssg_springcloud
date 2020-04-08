package club.huangliang.controller;

import club.huangliang.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RequestMapping("consumer/dept")
@RestController
public class DeptController_Consumer {
//    private static  final String REST_URL_PREFIX="http://localhost:8001";
    private static  final String REST_URL_PREFIX="http://SSG-SPRINGCLOUD-DEPT";
    /*使用restTemplate
    * */
    @Autowired
    private RestTemplate restTemplate;// use to get Restfull service
    @RequestMapping(value = "/add")
    public boolean add(Dept dept){
        System.out.println(dept);
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);//(url,requestMap,ResponseBean.class) 地址 请求参数，响应类
    }
    @RequestMapping(value = "/get/{id}")
    public Dept get(@PathVariable("id") Long id){

        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);//(url,requestMap,ResponseBean.class) 地址 请求参数，响应类
    }

    @RequestMapping(value = "/list")
    public List<Dept> list(){

        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);//(url,requestMap,ResponseBean.class) 地址 请求参数，响应类
    }
//  测试@EnableDiscoveryClinet 消费端的服务调用
    @RequestMapping(value = "/discovery")
    public Object discovery(){

        return restTemplate.getForObject(REST_URL_PREFIX+"dept/discovery",Object.class);
    }



}
