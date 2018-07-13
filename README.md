项目做了哪些工作：

1.项目架构设计，三层设计，frameone下分为5个文件夹（common\dao\integration\service\web）

2.spring boot集成myBatis

3.logback日志记录三种形式，控制台、file、logstash

4.springboot和redis的集成使用，和使用分布式锁的实现

5.使用springboot-dev-tools热加载工具，提升开发效率

6.定制自己的banner

7.springMVC实用的一些用法，FeatureController

8.spring-session使用redis存储session, 开启配置store-type: redis,开启注解 @EnableRedisHttpSession

9.获取配置文件的几种方式，env、使用@ConfigurationProperties+@Component注入或@ConfigurationProperties+@Bean注入

10.过滤器的简单实现、拦截器的简单实现、aop的简单实现，并使用@Bean注入IOC

11.使用jwt的token验证方式，登陆接口密码传输是明文，生产环境请使用https加密；

12.spring boot定时任务,包含多线程并发定时任务执行