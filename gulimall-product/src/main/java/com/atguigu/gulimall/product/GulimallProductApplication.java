package com.atguigu.gulimall.product;

import com.atguigu.gulimall.product.service.BrandService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 1.整合MyBatis plus
 *      1），导入依赖
 *         <dependency>
 *             <groupId>com.baomidou</groupId>
 *             <artifactId>mybatis-plus-boot-starter</artifactId>
 *             <version>3.2.0</version>
 *         </dependency>
 *      2），配置
 *          1.配置数据源
 *              1.导入数据库的驱动
 *              2.配置数据源yml相关信息
 *          2.配置Mybatis-Plus：
 *              1.使用@MapperScan
 *              2.告诉mybatis-plus，sql映射文件位置
 *
 *  2.逻辑删除
 *      1）.配置全局的逻辑删除规则（省略）3.0版本以上
 *      2）.配置逻辑删除的组件Bean（省略） 3.0版本以上
 *      3）.加上逻辑删除注解@TableLogic
 *
 *  3.JSR303
 *      1),给bean添加校验注解:java.validation.constraints，并定义自己的message提示
 *      2),开启校验功能：@Validated
 *          效果：校验错误以后会有默认的响应
 *      3），给校验的bean后紧跟一个BindingResult，就可以获取检验的结果
 *      4), 分组校验（多场景的复杂校验）
 *         1）.给校验注解标注什么情况需要进行校验
 *         @NotBlank(message = "品牌名必须提交",groups = {UpdateGroup.class,AddGroup.class})
 *          2）.@Validated({AddGroup.class})
 *          3).默认没有指定分组的校验注解，在分组校验情况@Validated({AddGroup.class})下不生效，只会在@Validated生效
 *      5）.自定义校验
 *          1）编写一个自定义的校验注解
 *          2）编写一个自定义的校验器 ConstraintValidator
 *          3）.关联自定义的校验器和自定义的校验注解
 *              @Documented
 *              @Constraint(validatedBy = {ListValueConstraintValidator.class })
 *              @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
 *              @Retention(RUNTIME)
 *  4.统一的异常处理
 *  @ControllerAdvice
 *      1).编写异常处理类，使用@ControllerAdvice
 *      2）使用@ExceptionHandler标注方法可以处理的异常
 *
 *  5.模板引擎
 *      1）thymeleaf-starter：关闭缓存
 *      2）静态资源都放在static文件下就可以按照路径直接访问
 *      3）页面放在templates下，直接访问
 *          springboot 访问项目的时候默认会找index
 *      4)页面修改不重启服务器实时更新
 *          1）引入dev-tools
 *          2)修改完页面 使用 controller shift f9重新自动编译下页面，代码配置。推荐重启服务
 *
 *    6.整合reis
 *    1）引入data-redis-starter
 *    2）简单配置redis的host等信息
 *    3）使用SpringBoot自动配置好的StringRedisTemplate来操作redis
 *    7.整合redisson作为分布式锁等功能框架
 *          1）引入依赖
 *         <dependency>
 *             <groupId>redis.clients</groupId>
 *             <artifactId>jedis</artifactId>
 *         </dependency>
 *     8.整合SpringCache简化缓存开发
 *          1）引入依赖
 *          spring-boot-starter-cache,spring-boot-starter-data-redis
 *          2)写配置
 *              (1)自动配置了哪些
 *                     CacheAutoConfiguration会导入RedisCacheConfiguration
 *                     自动卑职好了缓存管理器RedisCacheManager
 *             (2)配置使用redis作为缓存
 *               spring.cache.type=redis
 *          3）测试使用缓存
 *          @Cacheable: Triggers cache population.：触发将数据保存到缓存的操作
 *          @CacheEvict: Triggers cache eviction.：触发将数据从缓存删除的操作
 *          @CachePut: Updates the cache without interfering with the method execution.：不影响方法执行更新缓存
 *          @Caching: Regroups multiple cache operations to be applied on a method.：组合以上对个操作
 *          @CacheConfig: Shares some common cache-related settings at class-level.：在类级别共享缓存的相同配置
 *               1）开启缓存功能 @EnableCaching
 *              2),只需使用注解就能完成缓存操作  @Cacheable({"category"})
 *          4)原理；
 *              CacheAutoConfiguration->RedisCacheConfiguration->
 *              自动配置了RedisCacheManager->初始化所有的缓存->每个缓存决定使用说明配置
 *              ->如果redisCacheConfiguration有就用已有的，没有就用默认配置
 *              ->想改缓存的配置，只需要给容器中放一个RedisCcheConfiguration即可
 *              ->就会应用到当前RedisCacheManager管理的所有缓存分区中

 */
@EnableRedisHttpSession
@MapperScan("com.atguigu.gulimall.product.dao")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atguigu.gulimall.product.feign")
public class GulimallProductApplication {



    public static void main(String[] args) {
        SpringApplication.run(GulimallProductApplication.class, args);
    }

}
