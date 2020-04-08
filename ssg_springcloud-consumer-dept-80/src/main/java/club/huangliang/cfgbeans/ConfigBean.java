package club.huangliang.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {//配置类
    @Bean
    @LoadBalanced  //开启负载均衡
    public RestTemplate geRestTemplate(){

            return new RestTemplate();//提供了多种便捷访问远程Http服务的方法，是一种简单便捷的访问restful服务模板，是Spring提供的用与访问Rest服务的客户端模板工具级
        }

//        ribbon改用随机算法
//    @Bean
//    public IRule MyRule(){
//        return  new RoundRobinRule();
//    }
}
