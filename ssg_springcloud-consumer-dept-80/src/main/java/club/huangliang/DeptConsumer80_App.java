package club.huangliang;

import club.MyRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
//@EnableEurekaClient
@RibbonClient(name="SSG-SPRINGCLOUD-DEPT",configuration = MySelfRule.class) /*自定义ribbon 负载均衡算法规则（除内置方法以外的算法）*/
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
