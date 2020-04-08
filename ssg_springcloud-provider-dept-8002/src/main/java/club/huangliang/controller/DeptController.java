package club.huangliang.controller;

import club.huangliang.entities.Dept;
import club.huangliang.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;//用于服务发现的变量

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public boolean add(@RequestBody Dept dept){
        System.out.println(dept);
        return deptService.add(dept);
    }
    @RequestMapping(value = "/get/{id}" ,method = RequestMethod.GET)
    public Dept getById(@PathVariable("id") Long id){
        return deptService.getDept(id);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Dept> getAll(){
        return deptService.getAll();
    }

    /*eureka 的服务发现 */
    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public Object disconvery(){
        List<String > list=client.getServices();
        System.out.println("*******"+list);

        List<ServiceInstance> serviceInstanceList=client.getInstances("ssg_springcloud-dept");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+
                    "\t"+serviceInstance.getUri());
        }
        return this.client;
    }


}
