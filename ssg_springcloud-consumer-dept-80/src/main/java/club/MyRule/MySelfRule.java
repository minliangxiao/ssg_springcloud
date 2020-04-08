package club.MyRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
* 自定义的ribbon算法
* */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){

        return  new RandomRule();
    }

}
