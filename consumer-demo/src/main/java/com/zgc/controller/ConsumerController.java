package com.zgc.controller;

import com.zgc.client.UserClient;
import com.zgc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "defaultfallback")
public class ConsumerController {
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//    @Autowired
//    private RibbonLoadBalancerClient client;
//    private LoadBalancerClient client;//这个就不会报错，暂时不知为何

    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") long id ){
        return userClient.queryById(id);
    }


//    @RequestMapping("{id}")
//    @ResponseBody
////    @HystrixCommand//(fallbackMethod = "queryByIdfallbackMethod")两个方法的返回值要一致
////    @HystrixCommand(commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//自定义超时时长
////    })
//    @HystrixCommand(
//        commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//触发熔断的最小请求次数，默认20
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//触发熔断的失败请求最小占比，默认50%
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//休眠时长，默认是5000毫秒
//        })
//    public String queryById(@PathVariable("id") Integer id) {
//        if(id % 2 == 0){
//           throw  new RuntimeException("");
//        }
//
//        String url = "http://user-service/user/" + id;
//        String user = restTemplate.getForObject(url, String.class);
//        return user;
//    }

    //    public String queryByIdfallbackMethod(Integer id){
//
//        return "不好意思，服务器太拥挤！";
//    }
//    public String defaultfallback() {
//
//        return "不好意思，服务器太拥挤！";
//    }
//    @RequestMapping("{id}")
//    @ResponseBody
//    public User queryById(@PathVariable("id") Integer id){
////        根据服务ID获取实例
////        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
////       因为只有一个userseevice，所以获取第一个实例
////        ServiceInstance instance = instances.get(0);
////        ServiceInstance instance = client.choose("user-service");
////       从实例中取出IP和端口，拼接成服务地址
////        String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+id;
////        System.out.println("url"+url);
////        ServiceInstance instance = client.choose("user-service");
//        String url = "http://user-service/user/"+id;
////        System.out.println("url:"+instance.getPort());
//        User user = restTemplate.getForObject(url,User.class);
//        return user;
//    }
}
