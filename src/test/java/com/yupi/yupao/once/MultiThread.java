package com.yupi.yupao.once;

import com.yupi.yupao.mapper.UserMapper;
import com.yupi.yupao.model.domain.User;
import com.yupi.yupao.service.UserService;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 导入用户任务
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@Component
public class MultiThread {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    /**
     * 批量插入用户
     */
//    @Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        System.out.println("goodgoodgood");
        stopWatch.start();
        final int INSERT_NUM = 1000;
        int batchSize =5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList= new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<User> userList = new ArrayList<>();
//            while (true){
//                j++;
//                User user = new User();
//                user.setUsername("假鱼皮");
//                user.setUserAccount("fakeyupi");
//                user.setAvatarUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
//                user.setGender(0);
//                user.setUserPassword("12345678");
//                user.setPhone("123");
//                user.setEmail("123@qq.com");
//                user.setTags("[]");
//                user.setUserStatus(0);
//                user.setUserRole(0);
//                user.setPlanetCode("11111111");
////            userMapper.insert(user);
//                userList.add(user);
//                if (j%10000==0) break;
//            }
            //一步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
                System.out.println("threadName:"+Thread.currentThread().getName());
                userService.saveBatch(userList,10000);
            });
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());

        //测试lamda表达式、函数式编程
//        String[] strings = {"Apple", "Banana", "Lemon"};
//        Arrays.sort(strings,MultiThread::cmp);

    }
    static int cmp(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
