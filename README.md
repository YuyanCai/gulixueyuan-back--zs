# 一、项目简介

在线教育平台

在线教育顾名思义，是以网络为介质的教学方式，通过网络，学员与教师即使相隔万里也可以开展教学活动；此外，借助网络课件，学员还可以随时随地进行学习，真正打破了时间和空间的限制，对于工作繁忙，学习时间不固定的职场人而言网络远程教育是最方便不过的学习方式。



## 项目功能模块介绍

![image-20220407195624722](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220407195624722.png)





## 项目技术点介绍

![image-20220407200052911](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220407200052911.png)





### 前后端分离

> 开发接口就是开发Controller，service，mapper的过程

![image-20220408221513260](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220408221513260.png)



# 二、项目开发

> 说明：
>
> 为了整体的阅读体验，不在粘贴代码
>
> 有需要的地方会粘贴关键代码，其余则图片形式展示

## 前端相关知识点

为了更好的阅读见博客：

[快速入门Vue_小蜗牛耶的博客-CSDN博客](https://blog.csdn.net/qq_45714272/article/details/124319750?spm=1001.2014.3001.5502)

[前端常见知识点汇总(ES6，Vue，axios，Node.js，npm，webpack)_小蜗牛耶的博客-CSDN博客](https://blog.csdn.net/qq_45714272/article/details/124319805?spm=1001.2014.3001.5502)





## 开发CRUD接口

[SpringBoot+MybatisPlus+Swagger快速开发套路和总结_小蜗牛耶的博客-CSDN博客](https://blog.csdn.net/qq_45714272/article/details/124201534?spm=1001.2014.3001.5502)



## 改造登录到本地接口

我们用vue的模板，快速构建一个后台管理系统的模板

默认启动的时候使用的地址是

![image-20220421221508516](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220421221508516.png)

这样的话会出现跨域问题！！！



### 跨域

简单说下跨域问题

> 跨域：指的是浏览器不能执行其他网站的脚本。它是由浏览器的同源策略造成的，是浏览器对javascript施加的安全限制。
>
> 例如：a页面想获取b页面资源，如果a、b页面的协议、域名、端口、子域名不同，所进行的访问行动都是跨域的，而浏览器为了安全问题一般都限制了跨域访问，也就是不允许跨域请求资源。注意：跨域限制访问，其实是**浏览器的限制**。理解这一点很重要！！！
>
> 同源策略：是指协议，域名，端口都要相同，其中有一个不同都会产生跨域；

![img](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/9487719-d9eb2035e204d817.png)



#### 如何解决跨域问题？

由之前的介绍我们已经知道错误的原因，既然跨域会产生问题，那么我们就不跨域不就完了嘛！！！

==注解@CrossOrigin==

在后端接口加上@CrossOrigin即可解决跨域问题



==使用网关解决==

后面在写



### 登录功能完善

> **avatar	**头像的意思



根据vue模板，对登录的需求我们需要写两个接口

login登录操作方法，和info登录之后获取用户信息的方法。

1. login返回token值
2. info返回roles name avatar



> url里写的为后端的接口地址，最后访问的时候实际是dev.env.js中定义的BASE_API和这个里url拼接的地址
>
> **trim方法能够移除字符串右侧的空白字符或其他预定义字符。**

**1、定义登录API**

> 主要是和后端写的接口路径一致，这样才能请求成功

![image-20220422110733503](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422110733503.png)



**账号密码是直接写死的，login现在只是用来获取用户信息**

![image-20220422110139164](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422110139164.png)





**2、与后端接口整合**

> 这里说的接口不是interface，而是开发功能的时候就叫开发接口

![image-20220422110323122](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422110323122.png)



**3、测试**

![image-20220423150556447](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423150556447.png)

![image-20220422111445160](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422111445160.png)





### 常见的跨域错误

> 没有写@CrossOrign注解
>
> URL路径不对
>
> 访问请求错误（get，post）前后端是否一致



## 前端框架开发

### 架结构说明

图里没有截取完整，在 main.js中还有

>  **render: h => h(App)	它的作用就是将App汇总组件放入容器中**

```vue
new Vue({

 el: '#app',

 // 使用组件

 router,

 store,

 // 将App组件放入容器中

 render: h => h(App)

})
```



![image-20220422144804071](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422144804071.png)





# 三、前后端整合



## 整合CRUD

### 前后端对接流程

> 我们这里拿查询所有user做实例

全栈开发流程

![image-20220507095959632](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220507095959632.png)

![image-20220422114748269](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422114748269.png)

![image-20220422114444458](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422114444458.png)



#### 添加路由

> 模板中给的其实也有目录，我们看着复制粘贴根据自己的需求改改即可

![image-20220422152026688](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422152026688.png)



#### 点击路由显示页面

> redirect:'/teacher/table'作用是当访问/teacher时会自动跳到/teacher/table
>
> component是做布局的，就是页面做固定不动的部分

![image-20220422152340394](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422152340394.png)



#### 在api文件夹创建js文件，定义接口地址和参数

![image-20220422152930751](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422152930751.png)



#### 创建vue页面引入js文件，调用方法实现功能

> 我们先来了解一下response对象

以下是response对象的属性和方法

所以说，response就是代表接口返回的数据

![image-20220422223516849](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422223516849.png)

​	



![image-20220422225856659](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422225856659.png)





在看我们后端定义的接口

![image-20220422224305331](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422224305331.png)





> 这里的scope.row是获取行数据是固定写法

![image-20220422230224393](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422230224393.png)



这样功能就实现了



![image-20220422230800965](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422230800965.png)



==补充下分页条实现方式==

分页条

> 直接拿element-ui里面的来用就可以

因为我分页条和表单在同一页面，所以写在同一组件下

![image-20220422231913492](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422231913492.png)





### 多条件查询

> 直接拿element-ui里面的来用就可以

因为我分页条和表单在同一页面，所以写在同一组件下



**主要是js对象和java对象的问题，注意区分即可**

**其余的也是直接用element-ui组件直接拿过来改改数据**

![image-20220423090900436](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423090900436.png)



有了查询对象之后把查询对象传入我们写的获取讲师列表即可

我们在查询按钮绑定方法

![image-20220423091140995](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423091140995.png)



测试

![image-20220423091221673](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423091221673.png)





### 删除功能

![image-20220423092331661](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423092331661.png)



### 增加功能

![image-20220423095057832](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423095057832.png)



3、定义增加API

![image-20220423095142609](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423095142609.png)





4、引入js，写vue页面

![image-20220423094948248](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423094948248.png)



5、测试

![image-20220423100159283](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423100159283.png)



6、补充

![image-20220423101307100](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423101307100.png)





### 修改功能

> 我们想让增加和修改在同一页面下进行

增加和修改不同点在于，修改要做数据回显



那么如何区分这两个请求呢？

答案是修改的时候地址栏会有id，而保存没有



**定义Api、定义路由、定义跳转路径**

![image-20220423105407052](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423105407052.png)



==修改功能逻辑==

![image-20220423110736418](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423110736418.png)





测试

![image-20220423110820022](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423110820022.png)



修改成功

![image-20220423110833691](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423110833691.png)



#### 修改是用put请求还是post请求？

> idempotent 幂等的

**这两个方法看起来都是讲一个资源附加到服务器端的请求，但其实是不一样的。一些狭窄的意见认为，POST方法用来创建资源，而PUT方法则用来更新资源。**



幂等（idempotent、idempotence）是一个抽象代数的概念。在计算机中，可以这么理解，一个幂等操作的特点就是其任意多次执行所产生的影响均与依次一次执行的影响相同。

POST在请求的时候，服务器会每次都创建一个文件，但是在PUT方法的时候只是简单地更新，而不是去重新创建。因此PUT是幂等的。



举一个简单的例子，假如有一个博客系统提供一个Web API，模式是这样http://superblogging/blogs/post/{blog-name}，很简单，将{blog-name}替换为我们的blog名字，往这个URI发送一个HTTP PUT或者POST请求，HTTP的body部分就是博文，这是一个很简单的REST API例子。我们应该用PUT方法还是POST方法？取决于这个REST服务的行为是否是idempotent的，假如我们发送两个http://superblogging/blogs/post/Sample请求，服务器端是什么样的行为？如果产生了两个博客帖子，那就说明这个服务不是idempotent的，因为多次使用产生了副作用了嘛；如果后一个请求把第一个请求覆盖掉了，那这个服务就是idempotent的。前一种情况，应该使用POST方法，后一种情况，应该使用PUT方法。



## 整合阿里云OSS

> 我们想实现在添加讲师信息的时候加上头像上传功能，怎么办呢？
>
> 用阿里云的OSS对象存储即可

### 环境部署

**首先我们打开阿里云注册个OSS对象存储**

![image-20220423140743003](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423140743003.png)





### Java操作OSS

详细操作可查官方文档，下面只写关键代码

[[SDK示例 (aliyun.com)](https://help.aliyun.com/document_detail/32006.html)](https://help.aliyun.com/document_detail/32008.html)



**1、定义工具类读取配置文件**

> 通过继承InitializingBean
>
> 当项目已启动，spring加载之后，执行接口一个方法。就是afterPropertiesSet
>
> 读取配置文件内容后，在通过执行接口里的一个方法，从而让外面能使用

![image-20220423141537765](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423141537765.png)



**2、编写上传文件接口**

> MultipartFile类是org.springframework.web.multipart包下面的一个类，如果想使用MultipartFile类来进行文件操作，那么一定要引入Spring框架。MultipartFile主要是用表单的形式进行文件上传，在接收到文件时，可以获取文件的相关属性，比如文件名、文件大小、文件类型等等。



我们对着官网实例进行修改

![image-20220413151840052](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220413151840052.png)





![image-20220423143711082](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423143711082.png)



![image-20220423143946687](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423143946687.png)



**3、controller调用接口**

![image-20220423145150551](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423145150551.png)



**4、前端部分**

引入上传图片框也在save页面，所以

![image-20220423151338689](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423151338689.png)



![image-20220423151602576](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423151602576.png)



**5、测试**

![image-20220413153714195](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220413153714195.png)



上传成功

![image-20220416173228178](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220416173228178.png)



![image-20220416173356445](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220416173356445.png)







### nginx反向代理

> [Nginx快速入门_小蜗牛耶的博客-CSDN博客_nginx 快速入门](https://blog.csdn.net/qq_45714272/article/details/123564368?spm=1001.2014.3001.5502)
>
> 首先知道nginx的配置文件是nginx.config
>
> 其次是nginx的配置文件是可以看成一个http请求处理的
>
> 然后是nginx的server服务。可以理解为每个服务监听不同的端口，分发不同的连接服务。如果是自己的可以直接删掉初始server ，直接新建自己的server。

![image-20220507103254309](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220507103254309.png)



配置文件如下：

```shell
worker_processes  1;
events {
    worker_connections  1024;
}

http {
    include       mime.types;
    default_type  application/octet-stream;
	client_max_body_size 1024m;

    sendfile        on;
    keepalive_timeout  65;
	
    server {
        listen       81;
        server_name  localhost;

        location / {
            root   html;
            index  index.html index.htm;
        }

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
    
	server {
        listen       9001;    #监听端口号
        server_name  localhost;  #主机名称
        location ~ /eduService/ {  #匹配路径        
            proxy_pass http://localhost:8001;
        }
		location ~ /eduService1/ {  #匹配路径        
            proxy_pass http://localhost:6001;
        }
        location ~ /eduUser/ {
            proxy_pass http://localhost:8001;
        }
        location ~ /eduOss/ {
            proxy_pass http://localhost:8002;
        }
        location ~ /eduVod/ {
            proxy_pass http://localhost:8003;
        }
        location ~ /eduCms/ {
            proxy_pass http://localhost:8004;
        }
        location ~ /ucenterService/ {
            proxy_pass http://localhost:8006;
        }
        location ~ /eduMsm/ {
            proxy_pass http://localhost:8005;
        }
        location ~ /orderService/ {
            proxy_pass http://localhost:8007;
        }
        location ~ /staService/ {
            proxy_pass http://localhost:8008;
        }
        location ~ /admin/ {
            proxy_pass http://localhost:8009;
        }
    }

}

```

![image-20220422104023424](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422104023424.png)



**启动nginx**

![image-20220422104029132](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422104029132.png)



**修改项目访问路径为nginx的ip**

![image-20220422104300215](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422104300215.png)



![image-20220422104207226](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220422104207226.png)







## EasyExcel

### 简介

> [alibaba/easyexcel: 快速、简洁、解决大文件内存溢出的java处理Excel工具 (github.com)](https://github.com/alibaba/easyexcel)

1.Java领域解析、生成Excel比较有名的框架有Apache  poi、jxl等。但他们都存在一个严重的问题就是非常的耗内存。如果你的系统并发量不大的话可能还行，但是一旦并发上来后一定会OOM或者JVM频繁的full gc。

2.EasyExcel是阿里巴巴开源的一个excel处理框架，以使用简单、节省内存著称。EasyExcel能大大减 少占用内存的主要原因是在解析Excel时没有将文件数据一次性全部加载到内存中，而是从磁盘上一行行读取数据，逐个解析

3.EasyExcel采用一行一行的解析模式，并将一行的解析结果以观察者的模式通知处理

（AnalysisEventListener）



### 写入测试

![image-20220423161146730](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423161146730.png)

> 引入依赖
>
> <dependency>
>  <groupId>com.alibaba</groupId>
>  <artifactId>easyexcel</artifactId>
>  <version>2.1.1</version>
> </dependency>



![image-20220417104720208](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220417104720208.png)



### 读取测试

![image-20220423160946627](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423160946627.png)



**1、创建实体类和excel对应**

![image-20220423160823600](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423160823600.png)



**2、创建回调监听器**

![image-20220423161031862](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423161031862.png)



**3、直接读**

![image-20220423161100532](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423161100532.png)

![image-20220423161304098](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423161304098.png)



## 整合课程分类

### 实现思路

**1、图解**

树形控件考到前端页面，按需求更改

![image-20220423222349967](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220423222349967.png)



**2、实现Excel表格数据导入数据库功能**

前端找一个上传的组件

后端使用前面学的easyexcel功能来实现



**3、树状图显示数据功能**

前端找一个树状图组件

**后端返回上传的表格数据课程分类集合给前端，传递给组件自动遍历**



### 表格数据导入数据库

> 这个功能用前面学的easyExcel来实现



**1、添加依赖**

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>easyexcel</artifactId>
    <version>2.1.6</version>
</dependency>
```



**2、创建excel对应实体类对象**

![image-20220424131826095](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424131826095.png)



**3、通过代码生成器生成课程表代码**

![image-20220424132117470](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424132117470.png)



==**4、创建回调监听器**==

![image-20220424133652715](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424133652715.png)



![image-20220424134204593](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424134204593.png)





**5、自定义接口方法**

![image-20220424132617821](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424132617821.png)



==**实现类完成读取功能**==

![image-20220424132654493](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424132654493.png)



**6、控制类完成调用**

![image-20220424134327972](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424134327972.png)



**7、swagger完成测试**

![image-20220418162110054](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220418162110054.png)

![image-20220418162124144](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220418162124144.png)













### 树状图显示数据

> 树状图由element-ui获取

**1、树状图前端代码结构说明**

![image-20220424142534091](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424142534091.png)



==**2、设计思路**==

给el-tree返回一个集合对象就可以实现遍历

这个集合对象格式是，`{一级分类对象，二级分类对象数组[],一级分类对象，二级分类对象数组[].......}`



**对应到实体类中就是这个形式**

![image-20220424144444120](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424144444120.png)



==**3、返回集合对象**==

> 在数据库中查询通过表格上传的数据，返回为集合对象

![image-20220424150242288](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424150242288.png)



**源码也放下来，供大家理解**

```java
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    //添加课程分类
    @Override
    public void saveSubject(MultipartFile file, EduSubjectService subjectService) {

        try {
            //文件输入流
            InputStream in = file.getInputStream();

            //调用方法进行读取
            EasyExcel.read(in, SubjectData.class, new SubjectExcelListener(subjectService)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OneSubject> getAllOneTwoSubject() {
        //查询所有一级分类 parentid=0
        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id", "0");
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapperOne);
//        this.list()也可以通过这种方式调用查询。


        //查询所有二级分类 parentid!=0
        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperOne.ne("parent_id", "0");
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);


        //创建list集合，用于存放最终封装的数据
        List<OneSubject> finalSubjectList = new ArrayList<>();
        //封装一级分类
        //查询出来所有的一级分类list集合遍历，得到每一级分类对象，获得每个一级分类对象值
        //封装到要求的list集合里面
        for (int i = 0; i < oneSubjectList.size(); i++) {
            EduSubject eduSubject = oneSubjectList.get(i);
            OneSubject oneSubject = new OneSubject();
//            oneSubject.setId(eduSubject.getId());
//            oneSubject.setTitle(eduSubject.getTitle());
            //把eduSubject值复制到对应的oneSubject对象里面，两个对象里面的属性相同对应的的自动赋值
            BeanUtils.copyProperties(eduSubject, oneSubject);

            //在一级分类循环遍历查询所有的二级分类
            //创建list集合封装每个一级分类的二级分类
            List<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            //遍历二级分类list集合
            for (int j = 0; j < twoSubjectList.size(); j++) {
                EduSubject tSubject = twoSubjectList.get(j);
                //如果二级分类的parentid和一级分类的id一样，就把它加入到一级分类
                if (tSubject.getParentId().equals(eduSubject.getId())) {
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tSubject, twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            //把一级下面所有的二级分类放到一级分类里面
            oneSubject.setChildren(twoFinalSubjectList);
            finalSubjectList.add(oneSubject);
        }
        return finalSubjectList;
    }
}
```



**4、控制类调用接口返回集合**

![image-20220424150518771](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424150518771.png)



**5、Swagger测试**

![image-20220424151956364](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424151956364.png)





> ==加黑的小标题就是前后端整合的过程==

**1、定义路由、跳转页面**

![image-20220424134831992](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424134831992.png)





**2、定义API**

> ==定义的API就是后端写好的接口==

![image-20220424151041047](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424151041047.png)





**3、添加上传组件**

> element-ui找

![image-20220424135411929](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424135411929.png)



**组件参数说明**

template部分

![image-20220424140408463](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424140408463.png)



![image-20220424140713207](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424140713207.png)





数据部分

![image-20220424151144520](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424151144520.png)





**4、测试**

![image-20220424151351016](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424151351016.png)



![image-20220424151432184](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424151432184.png)





### 树形数据与懒加载

![image-20220507194709416](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220507194709416.png)



## 整合课程发布

### 实现思路

**1、图解**

![04-课程发布流程的说明](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/04-%E8%AF%BE%E7%A8%8B%E5%8F%91%E5%B8%83%E6%B5%81%E7%A8%8B%E7%9A%84%E8%AF%B4%E6%98%8E.png)

**2、获取步骤条**

![image-20220424155553991](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424155553991.png)





**3、代码思路**

写三个vue组件，每个组件根据需要自定义内容





### 课程基本信息

#### 实现效果

![image-20220425224223717](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425224223717.png)



#### 后端编码

**提前生成课程相关表**

> 通过代码生成器生成一键生成

![image-20220424155426823](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424155426823.png)



**1、创建vo封装每个步骤提交的数据**

![image-20220424161815851](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424161815851.png)



课程描述类id和课程类id是一样的，所以我们提前设置好

![image-20220424162316730](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424162316730.png)



**2、service**

定义添加课程方法

![image-20220424163900392](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424163900392.png)



**3、controller**

调用添加课程方法

![image-20220424164903170](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424164903170.png)



#### 前端编码

**1、添加路由，做页面跳转**

> 隐藏路由的目的是用来跳转步骤条

![image-20220424164135055](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424164135055.png)



**2、定义API**

![image-20220424164345506](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424164345506.png)



**3、编写Vue页面**

引入步骤条和表单

![image-20220424164445694](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424164445694.png)





==显示所有讲师列表==

> ：label表示的是下拉列表的名字的名字
>
> ：value是此表单提交时名字对应的teacherid也会被提交

![image-20220424201955347](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424201955347.png)



![image-20220424202931383](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424202931383.png)







==二级联动==

> 这是重点！！！

![image-20220424205837357](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424205837357.png)

bug提示：

==其中this.courseInfo.subjectId要在每次一级分类的时候进行清空==







==整合文本编辑器==

![image-20220424194815407](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424194815407.png)



==封面上传==

![image-20220424213838425](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220424213838425.png)



#### 数据回显

![image-20220425171037081](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425171037081.png)



![image-20220425172447908](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425172447908.png)





### 课程大纲

#### 实现效果

![image-20220425224307554](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425224307554.png)



#### 后端编码

写后端接口处理数据

分别是章节相关的，小节相关的

![image-20220425222906250](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425222906250.png)



![image-20220425223022818](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425223022818.png)



==查询所有章节和小节方法==

> 再次理解

![image-20220425225239707](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425225239707.png)



#### 前端编码

添加，修改之前我们使用的是跳到一个具体的页面

这次我们使用弹框，在弹框内进行操作

**这里我们使用element-ui中的Dialog**

![image-20220425191650837](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425191650837.png)



前端定义API

![image-20220425223058501](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425223058501.png)



==增加章节==

编码思路：

1. 点击添加，出现弹框
2. 填写内容，提交表单
3. 刷新页面，展示数据

![image-20220425223602232](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425223602232.png)





==修改章节==

1. 点击修改，出现弹框
2. 回显数据，修改提交
3. 刷新页面，展示数据

![image-20220425223841747](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425223841747.png)







==章节删除==

获取id，按id删除

![image-20220425224638149](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425224638149.png)





==小节增加删除修改==

同上，不在一一截取

![image-20220425230650453](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425230650453.png)





![image-20220425230926964](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220425230926964.png)





### 课程最终发布

#### 实现效果

![image-20220510161305923](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510161305923.png)





#### 后端编码

后端主要是做数据回显了，如下：

> 1. 根据id查询课程发布信息
> 2. 根据id发布课程



**1、根据id查询课程发布信息**

方式一：业务层组装多个表多次的查询结果

方式二：数据访问层进行关联查询

我们使用第二种方式实现



定义VO

![image-20220510161824144](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510161824144.png)



dao

![image-20220510162149394](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510162149394.png)



![image-20220510162325062](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510162325062.png)



业务层

![image-20220510163427642](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510163427642.png)





**2、根据id发布课程**

```
@PostMapping("publishCourse/{id}")
public R publishCourse(@PathVariable String id) {
    EduCourse eduCourse = new EduCourse();
    eduCourse.setId(id);
    eduCourse.setStatus("Normal");//设置课程发布状态
    courseService.updateById(eduCourse);
    return R.ok();
}
```





#### 前端编码

1、定义API

![image-20220510163629570](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510163629570.png)





2、写页面

![image-20220510163754020](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510163754020.png)



![image-20220510164015109](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510164015109.png)



![image-20220510164121852](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510164121852.png)







3、显示课程发布的信息

> 和前面显示讲师类似，不详细说明

![image-20220510164417238](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510164417238.png)



Ending.......



## 整合视频点播

### 简介

https://blog.csdn.net/qq_33857573/article/details/79564255

视频点播（ApsaraVideo for VoD）是集音视频采集、编辑、上传、自动化转码处理、媒体资源管理、分发加速于一体的一站式音视频点播解决方案。

![img](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/030a7226-1f25-4c7d-9d52-91160bf35c89.png)



应用场景

- 音视频网站：无论是初创视频服务企业，还是已拥有海量视频资源，可定制化的点播服务帮助客户快速搭建拥有极致观看体验、安全可靠的视频点播应用。
- 短视频：集音视频拍摄、特效编辑、本地转码、高速上传、自动化云端转码、媒体资源管理、分发加速、播放于一体的完整短视频解决方案。目前已帮助1000+APP快速实现手机短视频功能。
- 直播转点播：将直播流同步录制为点播视频，用于回看。并支持媒资管理、媒体处理（转码及内容审核/智能首图等AI处理）、内容制作（云剪辑）、CDN分发加速等一系列操作。
- 在线教育：为在线教育客户提供简单易用、安全可靠的视频点播服务。可通过控制台/API等多种方式上传教学视频，强大的转码能力保证视频可以快速发布，覆盖全网的加速节点保证学生观看的流畅度。防盗链、视频加密等版权保护方案保护教学内容不被窃取。
- 视频生产制作：提供在线可视化剪辑平台及丰富的OpenAPI，帮助客户高效处理、制作视频内容。除基础的剪切拼接、混音、遮标、特效、合成等一系列功能外，依托云剪辑及点播一体化服务还可实现标准化、智能化剪辑生产，大大降低视频制作的槛，缩短制作时间，提升内容生产效率。
- 内容审核：应用于短视频平台、传媒行业审核等场景，帮助客户从从语音、文字、视觉等多维度精准识别视频、封面、标题或评论的违禁内容进行AI智能审核与人工审核。



#### 功能介绍

> 我们把视频点播服务加到我们的课程发布中
>
> 更详细说明可看官方文档
>
> [视频点播 (aliyun.com)](https://help.aliyun.com/product/29932.html?spm=a2c4g.11186623.6.540.3c356a58OEmVZJ)



[![产品功能](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/0.8804617085856941.png)](http://docs-aliyun.cn-hangzhou.oss.aliyun-inc.com/assets/pic/85506/cn_zh/1542030629145/产品功能.png)





#### 基本使用

![image-20220510170254006](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510170254006.png)



#### 上传视频

**1、简介**

sdk的方式将api进行了进一步的封装，不用自己创建工具类。

我们可以基于服务端SDK编写代码来调用点播API，实现对点播产品和服务的快速操作



**2、功能介绍**

- SDK封装了对API的调用请求和响应，避免自行计算较为繁琐的 API签名。
- 支持所有点播服务的API，并提供了相应的示例代码。
- 支持7种开发语言，包括：Java、Python、PHP、.NET、Node.js、Go、C/C++。
- 通常在发布新的API后，我们会及时同步更新SDK，所以即便您没有找到对应API的示例代码，也可以参考旧的示例自行实现调用。



**3、安装**

![image-20220510170451321](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510170451321.png)



![image-20220510170710250](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510170710250.png)



**4、调用上传视频API**

![image-20220510192228809](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510192228809.png)





#### 获取视频播放地址

> 同样是获取API

![image-20220510192424493](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510192424493.png)



### 整合

#### 后端编码

> 建module，改pom，yml，启动类，业务类

这里用的是properties，也可以改成yml形式

![image-20220510192701738](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510192701738.png)





**启动类**

![image-20220510192736965](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510192736965.png)





**常量类**

![image-20220510192857284](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510192857284.png)



**service**

![image-20220510195108714](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510195108714.png)



**控制类**

![image-20220510193435686](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510193435686.png)



启动微服务，先用swagger测试一下在整合前端即可



#### 前端编码

> 因为所有微服务前面我们用了nginx做反向代理，
>
> 所以第一件事就是加上vod微服务请求路径，
>
> 第二是要改变nginx允许上传最大body大小改成1G，
>
> 第三重启

![image-20220510193602204](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510193602204.png)



**二、上传视频组件**

![image-20220510193822641](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510193822641.png)





![image-20220510194110379](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510194110379.png)





## 整合SpringCloud

> 简介
>
> [Spring全家桶--SpringCloud（初级）_小蜗牛耶的博客-CSDN博客_springcloud开源项目](https://blog.csdn.net/qq_45714272/article/details/123699797?spm=1001.2014.3001.5502)
>
> [Spring全家桶--SpringCloud（中级）_小蜗牛耶的博客-CSDN博客_springcloud](https://blog.csdn.net/qq_45714272/article/details/123797260?spm=1001.2014.3001.5502)
>
> [Spring全家桶--SpringCloud（高级）_小蜗牛耶的博客-CSDN博客](https://blog.csdn.net/qq_45714272/article/details/123915679?spm=1001.2014.3001.5502)



下面我们就简单的接受下

### 微服务简介

**1、微服务的由来**

微服务最早由Martin Fowler与James Lewis于2014年共同提出，微服务架构风格是一种使用一套小服务来开发单个应用的方式途径，每个服务运行在自己的进程中，并使用轻量级机制通信，通常是HTTP API，这些服务基于业务能力构建，并能够通过自动化部署机制来独立部署，这些服务使用不同的编程语言实现，以及不同数据存储技术，并保持最低限度的集中式管理。 



**2、为什么需要微服务**

在传统的IT行业软件大多都是各种独立系统的堆砌，这些系统的问题总结来说就是扩展性差，可靠性不高，维护成本高。到后面引入了SOA服务化，但是，由于 SOA 早期均使用了总线模式，这种总线模式是与某种技术栈强绑定的，比如：J2EE。这导致很多企业的遗留系统很难对接，切换时间太长，成本太高，新系统稳定性的收敛也需要一些时间。 



**3、微服务与单体架构区别**

（1）单体架构所有的模块全都耦合在一块，代码量大，维护困难。

​     微服务每个模块就相当于一个单独的项目，代码量明显减少，遇到问题也相对来说比较好解决。

（2）单体架构所有的模块都共用一个数据库，存储方式比较单一。

​     微服务每个模块都可以使用不同的存储方式（比如有的用redis，有的用mysql等），数据库也是单个模块对应自己的数据库。

（3）单体架构所有的模块开发所使用的技术一样。

​     微服务每个模块都可以使用不同的开发技术，开发模式更灵活。 



**4、微服务本质**

（1）微服务，关键其实不仅仅是微服务本身，而是系统要提供一套基础的架构，这种架构使得微服务可以独立的部署、运行、升级，不仅如此，这个系统架构还让微服务与微服务之间在结构上“松耦合”，而在功能上则表现为一个统一的整体。这种所谓的“统一的整体”表现出来的是统一风格的界面，统一的权限管理，统一的安全策略，统一的上线过程，统一的日志和审计方法，统一的调度方式，统一的访问入口等等。
（2）微服务的目的是有效的拆分应用，实现敏捷开发和部署 。
（3）微服务提倡的理念团队间应该是 inter-operate, not integrate 。inter-operate是定义好系统的边界和接口，在一个团队内全栈，让团队自治，原因就是因为如果团队按照这样的方式组建，将沟通的成本维持在系统内部，每个子系统就会更加内聚，彼此的依赖耦合能变弱，跨系统的沟通成本也就能降低。


**5、什么样的项目适合微服务**

微服务可以按照业务功能本身的独立性来划分，如果系统提供的业务是非常底层的，如：操作系统内核、存储系统、网络系统、数据库系统等等，这类系统都偏底层，功能和功能之间有着紧密的配合关系，如果强制拆分为较小的服务单元，会让集成工作量急剧上升，并且这种人为的切割无法带来业务上的真正的隔离，所以无法做到独立部署和运行，也就不适合做成微服务了。



**6、微服务开发框架**

目前微服务的开发框架，最常用的有以下四个：

Spring Cloud：http://projects.spring.io/spring-cloud（现在非常流行的微服务架构）

Dubbo：http：//dubbo.io

Dropwizard：http://www.dropwizard.io （关注单个微服务的开发）

Consul、etcd&etc.（微服务的模块）



**7、什么是Spring Cloud**

Spring Cloud是一系列框架的集合。它利用Spring Boot的开发便利性简化了分布式系统基础设施的开发，如服务发现、服务注册、配置中心、消息总线、负载均衡、 熔断器、数据监控等，都可以用Spring Boot的开发风格做到一键启动和部署。Spring并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包



**8、Spring Cloud和Spring Boot是什么关系**

Spring Boot 是 Spring 的一套快速配置脚手架，可以基于Spring Boot 快速开发单个微服务，Spring Cloud是一个基于Spring Boot实现的开发工具；Spring Boot专注于快速、方便集成的单个微服务个体，Spring Cloud关注全局的服务治理框架； Spring Boot使用了默认大于配置的理念，很多集成方案已经帮你选择好了，能不配置就不配置，Spring Cloud很大的一部分是基于Spring Boot来实现，必须基于Spring Boot开发。可以单独使用Spring Boot开发项目，但是Spring Cloud离不开 Spring Boot。



**9、Spring Cloud相关基础服务组件**

服务发现——Netflix Eureka （Nacos）

服务调用——Netflix Feign 

熔断器——Netflix Hystrix 

服务网关——Spring Cloud GateWay 

分布式配置——Spring Cloud Config  （Nacos）

消息总线 —— Spring Cloud Bus （Nacos）



**10、Spring Cloud的版本**

Spring Cloud并没有熟悉的数字版本号，而是对应一个开发代号。

| Cloud代号 | Boot版本(train) | Boot版本(tested)      | lifecycle        |
| --------- | --------------- | --------------------- | ---------------- |
| Angle     | 1.2.x           | incompatible with 1.3 | EOL in July 2017 |
| Brixton   | 1.3.x           | 1.4.x                 | 2017-07卒        |
| Camden    | 1.4.x           | 1.5.x                 | -                |
| Dalston   | 1.5.x           | not expected 2.x      | -                |
| Edgware   | 1.5.x           | not expected 2.x      | -                |
| Finchley  | 2.0.x           | not expected 1.5.x    | -                |
| Greenwich | **2.1.x**       |                       |                  |
| Hoxton    | 2.2.x           |                       |                  |

开发代号看似没有什么规律，但实际上首字母是有顺序的，比如：Dalston版本，我们可以简称 D 版本，对应的 Edgware 版本我们可以简称 E 版本。



**小版本**

Spring Cloud 小版本分为:

SNAPSHOT： 快照版本，随时可能修改

M： MileStone，M1表示第1个里程碑版本，一般同时标注PRE，表示预览版版。

SR： Service Release，SR1表示第1个正式版本，一般同时标注GA：(GenerallyAvailable),表示稳定版本。



### Nacos

**（1）Nacos是什么**

Nacos 是阿里巴巴推出来的一个新开源项目，是一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。



**（2）常见的注册中心：**

1. Eureka（原生，2.0遇到性能瓶颈，停止维护）

2. Zookeeper（支持，专业的独立产品。例如：dubbo）

3. Consul（原生，GO语言开发）

4. Nacos

相对于 Spring Cloud Eureka 来说，Nacos 更强大。**Nacos = Spring Cloud Eureka + Spring Cloud Config**

 Nacos 可以与 Spring, Spring Boot, Spring Cloud 集成，并能代替 Spring Cloud Eureka, Spring Cloud Config

\- 通过 Nacos Server 和 spring-cloud-starter-alibaba-nacos-discovery 实现服务的注册与发现。



**（3）Nacos功能**

Nacos是以服务为主要服务对象的中间件，Nacos支持所有主流的服务发现、配置和管理。

Nacos主要提供以下四大功能：

1. 服务发现和服务健康监测

2. 动态配置服务

3. 动态DNS服务

4. 服务及其元数据管理



**（4）Nacos结构图**

![img](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/6e5b55f7-3252-4dea-81e9-e0ffd86987b4.jpg)

**安装**

解压安装包，进入cmd运行nacos即可

![image-20220510223828607](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510223828607.png)



![image-20220510223910128](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510223910128.png)



### 服务注册

我们把后面要用的service-edu、service-oss、service-vod都加入到nacos中

怎么加呢？



**1、配置依赖**

```
<!--服务注册-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```



**2、添加服务配置信息**

![image-20220510224731899](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510224731899.png)



**3、添加Nacos客户端注解**

在客户端微服务启动类中添加注解

![image-20220510224819651](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510224819651.png)



**4、启动客户端微服务**

启动注册中心

启动已注册的微服务，可以在Nacos服务列表中看到被注册的微服务

![image-20220510224855455](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510224855455.png)



### 服务调用-Feign

> feign
> 英 [feɪn] 美 [feɪn]
> v. 假装，装作，佯装(有某种感觉或生病、疲倦等)

Feign是一个声明式WebService客户端。使用Feign能让编写Web Service客户端更加简单。它的使用方法是定义一个服务接口然后在上面添加注解。Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。



#### Web Service

分布式的调用服务，多个客户端可以通过web配置来调用发布的服务。

例如：微服务A想调用微服务B，要想实现这个功能就要使用WebService

 WebServic 很重要，但不被经常使用，它更多的是一种分布服务的方式，所以对它了解就好了。



Web 服务端提供的是服务或功能，继面向对象后，面向服务形成了新的特色。例如请求天气预报服务，如今很多手机、小网站等小成本的经营者都可以进行天气的预报，这是因为气象站将天气的预报的服务发布了出去，只要符合一定条件就都可以调用这个服务。简单说就是web服务就是一个URL资源，客户端可以调用这个服务。





#### 后端编码

删除课时的同时删除云端视频

> 哎，这不就出现了微服务之间互相调用的情况了吗

**1、pom文件**

> 引用feign实现远程调用

![image-20220510232341831](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510232341831.png)



**2、调用端的启动类添加注解**

> feign 是通过接口+注解实现微服务调用

消费者添加@EnableFeignClients开启feign

![image-20220510232544149](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510232544149.png)



**3、创建包和接口**

> 业务逻辑接口+@FeignClient配置调用provider服务

创建client包

@FeignClient注解用于指定从哪个服务中调用功能 ，名称与被调用的服务名保持一致。

@GetMapping注解用于对被调用的微服务进行地址映射。

@PathVariable注解一定要指定参数名称，否则出错

@Component注解防止，在其他位置注入CodClient时idea报错

![image-20220510233110255](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510233110255.png)



前提是我们vod微服务中批量删除是可以用的

![image-20220511091241884](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511091241884.png)





**4、调用微服务**

> 课程微服务调用视频微服务
>
> 目的是删除课程同时删除视频

**1、注入vod微服务中删除视频接口vodClient**



![image-20220510233845586](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220510233845586.png)



**2、具体流程**

![image-20220511103602090](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511103602090.png)



#### 前端编码

还是和前面一样，我们每次点击添加小节弹框要清空

```vue
//添加小节弹框的方法
openVideo(chapterId) {
//弹框
this.dialogVideoFormVisible = true;
//清空
this.video = {};
this.fileList = [];
//设置章节id
this.video.chapterId = chapterId;
},
```



这次我们多添加几个小节来测试能不能同时删除

![image-20220511104724517](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511104724517.png)

![image-20220511104714683](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511104714683.png)



发布课程后删除课程，看视频点播还有没有视频

![image-20220511104736929](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511104736929.png)







![image-20220511105602352](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511105602352.png)



### 服务熔断-Hystrix

Spring Cloud 在接口调用上，大致会经过如下几个组件配合：

> 接口调用的流程很重要，我们一定要理解
>
> 自己用过这些组件的话还是很好理解的

**`Feign` ----->`Hystrix` —>`Ribbon` —>`Http Client`（apache http components 或者 Okhttp）`** 具体交互流程上，如下图所示：

![img](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/d5be6f27-caff-45b6-8f27-837ea6b11134.jpg)



**（1）接口化请求调用**当调用被`@FeignClient`注解修饰的接口时，在框架内部，将请求转换成Feign的请求实例`feign.Request`，交由Feign框架处理。

**（2）Feign** ：转化请求Feign是一个http请求调用的轻量级框架，可以以Java接口注解的方式调用Http请求，封装了Http调用流程。

**（3）Hystrix**：熔断处理机制 Feign的调用关系，会被Hystrix代理拦截，对每一个Feign调用请求，Hystrix都会将其包装成`HystrixCommand`,参与Hystrix的流控和熔断规则。如果请求判断需要熔断，则Hystrix直接熔断，抛出异常或者使用`FallbackFactory`返回熔断`Fallback`结果；如果通过，则将调用请求传递给`Ribbon`组件。

**（4）Ribbon**：服务地址选择 当请求传递到`Ribbon`之后,`Ribbon`会根据自身维护的服务列表，根据服务的服务质量，如平均响应时间，Load等，结合特定的规则，从列表中挑选合适的服务实例，选择好机器之后，然后将机器实例的信息请求传递给`Http Client`客户端，`HttpClient`客户端来执行真正的Http接口调用；

**（5）HttpClient** ：Http客户端，真正执行Http调用根据上层`Ribbon`传递过来的请求，已经指定了服务地址，则HttpClient开始执行真正的Http请求



#### Hystrix（豪猪哥）

Hystrix 是一个供分布式系统使用，提供延迟和容错功能，保证复杂的分布系统在面临不可避免的失败时，仍能有其弹性。

比如系统中有很多服务，当某些服务不稳定的时候，使用这些服务的用户线程将会阻塞，如果没有隔离机制，系统随时就有可能会挂掉，从而带来很大的风险。SpringCloud使用Hystrix组件提供断路器、资源隔离与自我修复功能。下图表示服务B触发了断路器，==阻止了级联失败==

![img](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/59809c07-0923-4546-aa83-ed920f53a3a5.jpg)





#### feign结合Hystrix使用

**1、添加依赖**

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-ribbon</artifactId>
</dependency>

<!--hystrix依赖，主要是用  @HystrixCommand -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
</dependency>

<!--服务注册-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
<!--服务调用-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```



**2、配置文件中添加hystrix配置**

![image-20220511110835088](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511110835088.png)



**3、在service-edu的client包里面创建熔断器的实现类**

![image-20220511111356527](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511111356527.png)



**4、测试熔断器效果**

我们模拟视频点播微服务宕机了，我们再去调用它，看看会不会触发hystrix

![image-20220511111642364](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511111642364.png)



debug启动edu服务，关闭vod服务，会触发熔断器

![image-20220428112639643](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220428112639643.png)







## 整合NUXT

### 什么是NUXT？

> 一种服务端渲染技术

**1、什么是服务端渲染**

服务端渲染又称SSR (Server Side Render)是在服务端完成页面的内容，而不是在客户端通过AJAX获取数据。

服务器端渲染(SSR)的优势主要在于：**更好的 SEO**，由于搜索引擎爬虫抓取工具可以直接查看完全渲染的页面。

如果你的应用程序初始展示 loading 菊花图，然后通过 Ajax 获取内容，抓取工具并不会等待异步完成后再进行页面内容的抓取。也就是说，如果 SEO 对你的站点至关重要，而你的页面又是异步获取内容，则你可能需要服务器端渲染(SSR)解决此问题。

另外，使用服务器端渲染，我们可以获得更快的内容到达时间(time-to-content)，无需等待所有的 JavaScript 都完成下载并执行，产生更好的用户体验，对于那些「内容到达时间(time-to-content)与转化率直接相关」的应用程序而言，服务器端渲染(SSR)至关重要。



**2、什么是NUXT**

Nuxt.js 是一个基于 Vue.js 的轻量级应用框架,可用来创建服务端渲染 (SSR) 应用,也可充当静态站点引擎生成静态站点应用,具有优雅的代码结构分层和热加载等特性。

官网网站：

https://zh.nuxtjs.org/



### 安装NUXT

**1、下载压缩包**

https://github.com/nuxt-community/starter-template/archive/master.zip

**2、解压**

将template中的内容复制到 guli

**3、安装ESLint**

将guli-admin项目下的.eslintrc.js配置文件复制到当前项目下

**4、修改package.json**

name、description、author（必须修改这里，否则项目无法安装）

```json
"name": "guli",
"version": "1.0.0",
"description": "谷粒学院前台网站",
"author": "pyy <55317332@qq.com>",
```

**5、修改nuxt.config.js**

修改title: '{{ name }}'、content: '{{escape description }}'

这里的设置最后会显示在页面标题栏和meta数据中

```json
head: {
    title: '谷粒学院 - Java视频|HTML5视频|前端视频|Python视频|大数据视频-自学拿1万+月薪的IT在线视频课程，谷粉力挺，老学员为你推荐',
    meta: [
        { charset: 'utf-8' },
        { name: 'viewport', content: 'width=device-width, initial-scale=1' },
        { hid: 'keywords', name: 'keywords', content: '谷粒学院,IT在线视频教程,Java视频,HTML5视频,前端视频,Python视频,大数据视频' },
        { hid: 'description', name: 'description', content: '谷粒学院是国内领先的IT在线视频学习平台、职业教育平台。截止目前,谷粒学院线上、线下学习人次数以万计！会同上百个知名开发团队联合制定的Java、HTML5前端、大数据、Python等视频课程，被广大学习者及IT工程师誉为：业界最适合自学、代码量最大、案例最多、实战性最强、技术最前沿的IT系列视频课程！' }
    ],
    link: [
        { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
},
```



**6、在命令提示终端中进入项目目录**



**7、安装依赖**

npm install



**8、测试运行**

npm run dev



**9、NUXT目录结构**

（1）资源目录 assets

 用于组织未编译的静态资源如 LESS、SASS 或 JavaScript。

（2）组件目录 components

用于组织应用的 Vue.js 组件。Nuxt.js 不会扩展增强该目录下 Vue.js 组件，即这些组件不会像页面组件那样有 asyncData 方法的特性。

（3）布局目录 layouts

用于组织应用的布局组件。

（4）页面目录 pages

用于组织应用的路由及视图。Nuxt.js 框架读取该目录下所有的 .vue 文件并自动生成对应的路由配置。

（5）插件目录 plugins

用于组织那些需要在 根vue.js应用 实例化之前需要运行的 Javascript 插件。

（6）nuxt.config.js 文件

nuxt.config.js 文件用于组织Nuxt.js 应用的个性化配置，以便覆盖默认配置。



### 幻灯片插件

**1、安装插件**

```
npm install vue-awesome-swiper
```



**2、配置插件**

在 plugins 文件夹下新建文件 nuxt-swiper-plugin.js，内容是

```
import Vue from 'vue'
import VueAwesomeSwiper from 'vue-awesome-swiper/dist/ssr'
Vue.use(VueAwesomeSwiper)
```

在 nuxt.config.js 文件中配置插件

将 plugins 和 css节点 复制到 module.exports节点下

![image-20220511152146044](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511152146044.png)



### 页面布局

**1、复制静态资源**

将静态原型中的css、img、js、photo目录拷贝至assets目录下 

将favicon.ico复制到static目录下

**2、定义布局**

我们可以把页头和页尾提取出来，形成布局页

修改layouts目录下default.vue，从静态页面中复制首页，修改了原始文件中的资源路径为~/assets/，将主内容区域的内容替换成`<nuxt />`

内容如下：

![image-20220511152317672](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511152317672.png)



**3、定义首页面**

修改pages/index.vue：

修改了原始文件中的资源路径为~/assets/

![image-20220511152520864](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511152520864.png)





### 路由

**1、固定路由**

点击，跳转。跳转的路径是固定的



**2、动态路由**

如果我们需要根据id查询一条记录，就需要使用动态路由。NUXT的动态路由是以下划线开头的vue文件，参数名为下划线后边的文件名

在pages下的course目录下创建_id.vue



### 封装axios

> 为了更好的操作ajax，我们用axios来操作
>
> 我们参考guli-admin将axios操作封装起来

下载axios ，使用命令 **npm install axios**

创建utils文件夹，utils下创建request.js

```react
import axios from 'axios'
// 创建axios实例
const service = axios.create({
  baseURL: 'http://localhost:8201', // api的base_url
  timeout: 20000 // 请求超时时间
})
export default service
```



**整合教师页面和课程页面**

**就是复制两个vue页面**

**然后分别定义两个动态路由页面**





## 整合Redis

> 这里整合的redis实例是尚荣宝项目的，给树状图做缓存
>
> 下面在整合一个前端的banner轮播图

### 树状图整合

**1、centos上运行redis服务器**

![image-20220508212707013](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220508212707013.png)



**2、目前数据库是空的**

```
127.0.0.1:6379> keys *
(empty array)
127.0.0.1:6379> 
```



**3、在查询接口实现类中通过redistemplate加上redis缓存**

![image-20220508212645197](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220508212645197.png)



**4、访问前端项目，看redis中是否会加上key和value**

![image-20220508213916996](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220508213916996.png)





**5、测试**

![image-20220508214318344](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220508214318344.png)



### banner整合

第二种整合方式采用注解形式，注解形式的整合需要redis的配置文件

配置文件的写法是固定的，如下：

**一、配置类**

```java
@Configuration
@EnableCaching  //开启缓存
public class RedisConfig extends CachingConfigurationSelector {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setConnectionFactory(factory);
        //key序列化方式
        template.setKeySerializer(redisSerializer);
        //value序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //value hashmap序列化
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        return template;
    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        // 配置序列化（解决乱码的问题）,过期时间600秒
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(600))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                .disableCachingNullValues();
        RedisCacheManager cacheManager = RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .build();
        return cacheManager;
    }
}
```



**二、配置文件**

```properties
# 服务端口
server.port=8004
# 服务名
spring.application.name=service-cms
spring.cloud.nacos.discovery.server-addr=127.0.0.1:8848

# mysql数据库连接
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/guli?serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=root

#返回json的全局时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

#配置mapper xml文件的路径
mybatis-plus.mapper-locations=classpath:com/caq/educms/mapper/xml/*.xml

spring.redis.host=172.20.10.9
spring.redis.port=6379
spring.redis.database= 0
spring.redis.timeout=1800000

spring.redis.lettuce.pool.max-active=20
spring.redis.lettuce.pool.max-wait=-1
#最大阻塞等待时间(负数表示没限制)
spring.redis.lettuce.pool.max-idle=5
spring.redis.lettuce.pool.min-idle=0

#mybatis日志
mybatis-plus.configuration.log-impl=org.apache.ibatis.logging.stdout.StdOutImpl
```



**三、修改实现类**

```java
@Service
public class CrmBannerServiceImpl extends ServiceImpl<CrmBannerMapper, CrmBanner> implements CrmBannerService {

    @Cacheable(value = "banner",key = "'selectIndexList'")
    @Override
    public List<CrmBanner> selectAllBanner() {

        //根据id进行降序排序，显示排列之后的前两条记录
        QueryWrapper<CrmBanner> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        //拼接sql语句
        queryWrapper.last("limit 2");
        List<CrmBanner> list = baseMapper.selectList(null);
        return list;
    }
}
```



**四、测试**

![image-20220511201420247](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220511201420247.png)





### 注意点

> redis主要是配置文件，对配置文件的详解可看如下文章
>
> [Redis配置文件详解 - 云+社区 - 腾讯云 (tencent.com)](https://cloud.tencent.com/developer/article/1947475)

**（1）关闭liunx防火墙**

（2）找到redis配置文件， 注释一行配置

默认情况这个bind不改的话只能接受本机的访问请求

![image-20220521200723885](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220521200723885.png)



**修改** **protected-mode yes**

**改为protected-mode no**

> 关掉redis的bind项和没设置redis密码的时候，能让redis接受其他主机的响应









## 整合JWT(JSON Web Token)

### 用户登录业务介绍

#### 单一服务器模式

**一般情况是用户将账号密码发给服务器，服务器验证后把数据保存到session中（cookie是数据存在客户端，session是数据存在服务端）。服务端返回sessionId给客户端，客户端会把这个信息存入用户的cookie中，每次请求的从cookie中取值和服务端的保存的数据对比，确认身份。**



最开始学javaweb的时候，做登录都是保存到session域中，保存之后判断用户登录与否通过取session域中的数据来决定



这种登录模式只适合单一的小项目，不方便横向扩展...



#### SSO(single sign on)模式

> 单点登录
>
> 客户端登录后，将账户密码存到认证中心，其余服务通过访问认证中心进行身份验证

![image-20220521205204424](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220521205204424.png)

**优点 ：** 

用户身份信息独立管理，更好的分布式管理。

 可以自己扩展安全策略

**缺点：**

   认证服务器访问压力较大。



token模式登录流程

![image-20220522155053567](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220522155053567.png)



#### SSO登录三种常见的方式

- session广播
- cookie+redis
- 使用token实现token

**优点：**

无状态： token无状态，session有状态的

基于标准化: 你的API可以采用标准化的 JSON Web Token (JWT)

**缺点：**

占用带宽

无法在服务器端销毁

**注：基于微服务开发，选择token的形式相对较多，因此我使用token作为用户认证的标准**







### 传统用户身份验证

![image-20220522160031343](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220522160031343.png)



Internet服务无法与用户身份验证分开。一般过程如下：

1. 用户向服务器发送用户名和密码。
2. 验证服务器后，相关数据（如用户角色，登录时间等）将保存在当前会话中。
3. 服务器向用户返回session_id，session信息都会写入到用户的Cookie。
4. 用户的每个后续请求都将通过在Cookie中取出session_id传给服务器。
5. 服务器收到session_id并对比之前保存的数据，确认用户的身份。

这种模式最大的问题是，没有分布式架构，无法支持横向扩展。



### 解决方案

1. session广播
2. 将透明令牌存入cookie，将用户身份信息存入redis



**另外一种灵活的解决方案：**

使用自包含令牌，通过客户端保存数据，而服务器不保存会话数据。 JWT是这种解决方案的代表。



### JWT令牌

![image-20220522160432679](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220522160432679.png)



典型的，一个JWT看起来如下图：

![image-20220522160528304](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220522160528304.png)

该对象为一个很长的字符串，字符之间通过"."分隔符分为三个子串。

每一个子串表示了一个功能块，总共有以下三个部分：**JWT头、有效载荷和签名**



### JWT的原则

JWT的原则是在服务器身份验证之后，将生成一个JSON对象并将其发送回用户

{
  "sub": "1234567890",
  "name": "Jack",
  "admin": true
}

之后，==当用户与服务器通信时，客户在请求中发回JSON对象。服务器仅依赖于这个JSON对象来标识用户。为了防止用户篡改数据，服务器将在生成对象时添加签名。==

**服务器不保存任何会话数据，即服务器变为无状态，使其更容易扩展。**



客户端接收服务器返回的JWT，将其存储在Cookie或localStorage中。

此后，客户端将在与服务器交互中都会带JWT。如果将它存储在Cookie中，就可以自动发送，但是不会跨域，因此一般是将它放入HTTP请求的Header Authorization字段中。当跨域时，也可以将JWT被放置于POST请求的数据主体中。



优势：

- 生产的token可以包含基本信息，比如id、用户昵称、头像等信息，避免再次查库
- 存储在客户端，不占用服务端的内存资源
- ....



### 整合

**添加依赖**

```
<dependencies>
    <!-- JWT-->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
    </dependency>
</dependencies>
```



**创建JWT工具类**

```java
public class JwtUtils {

    public static final long EXPIRE = 1000 * 60 * 60 * 24;
    public static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    public static String getJwtToken(String id, String nickname){

        String JwtToken = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject("guli-user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", id)
                .claim("nickname", nickname)
                .signWith(SignatureAlgorithm.HS256, APP_SECRET)
                .compact();

        return JwtToken;
    }

    /**
     * 判断token是否存在与有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if(StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取会员id
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if(StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("id");
    }
}
```





![image-20220512164513655](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220512164513655.png)





## 整合腾讯云短信服务

> 这里整合的为腾讯云短信服务，视频中是阿里云短信。
>
> 由于阿里云短信申请不容易成功，所以我们这里用腾讯云。
>
> 看着sdk文档很容易就能整合成功~

[短信 Java SDK-SDK 文档-文档中心-腾讯云-腾讯云 (tencent.com)](https://cloud.tencent.com/document/product/382/43194)



### 后端编码

**建模块，改pom，yml，启动类**

![image-20220522170553780](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220522170553780.png)



**业务类**

![image-20220522171138897](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220522171138897.png)



### 前端编码

> 主要技术点是：页面，倒计时功能
>
> 这两个功能主要是前端知识点，这里不过多展示

![image-20220522171426843](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220522171426843.png)



使用完这些插件之后，其余的套路和之前整合的一样

四大步：

1. **添加路由**
2. **点击路由显示页面**
3. **api文件夹创建js文件，定义后端接口地址和参数**
4. **创建vue页面引入js，调用方法实现功能**



噢噢噢，这个是写后台管理系统的时候的套路对吧

前台系统也差不多的了

1. **api文件夹创建js文件，定义后端接口地址和参数**
2. **创建vue页面引入js，调用方法实现功能**



![image-20220522171819342](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220522171819342.png)



![image-20220522172453985](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220522172453985.png)

















## 微信扫描登录

### OAuth2

[OAuth2.0 详解 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/89020647)

**什么是OAuth2？**

OAuth 不是一个API或者服务，而是一个验证授权(Authorization)的开放标准，所有人都有基于这个标准实现自己的OAuth。



**为什么要有OAuth?**

OAuth2的出现是为了解决安全性问题，OAuth使得第三方应用对资源的访问更加安全



**微信扫码登录的具体流程**

[微信开放平台 (qq.com)](https://open.weixin.qq.com/)

[准备工作 | 微信开放文档 (qq.com)](https://developers.weixin.qq.com/doc/oplatform/Website_App/WeChat_Login/Wechat_Login.html)



> httpclient就是不用在浏览器中输入url访问资源也能实现浏览器的过程

![img](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/730bd7bb80c05490a688330820419d9b.png)



微信扫码登录流程

> 来自于微信开放平台官网

```text
1. 第三方发起微信授权登录请求，微信用户允许授权第三方应用后，微信会拉起应用或重定向到第三方网站，并且带上授权临时票据 code 参数；
2. 通过 code 参数加上 AppID 和AppSecret等，通过 API 换取access_token；
3. 通过access_token进行接口调用，获取用户基本数据资源或帮助用户实现基本操作。
```



### 开发流程

> 微信扫码登录需要有商户微信信息
>
> 这里采用的是视频提供的





**建模块，改pom，yml，启动类**

![image-20220523134600004](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523134600004.png)







![image-20220523150714529](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523150714529.png)

![image-20220523151318757](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523151318757.png)



![image-20220523151443593](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523151443593.png)



![image-20220523152158251](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523152158251.png)



![image-20220523152952334](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523152952334.png)



有了access_token我们就可以通过接口来获取用户信息了，从而把用户保存到数据库中

**存数据库**

> 由官网可知，请求成功后返回的结果是一个json字符串

![image-20220523152459534](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523152459534.png)



如下实例：

```json
{"access_token":"56_jgDYj0kFSTarb6dLk3S8v32kVFmACL7MSBlAeBllfWMtfCqmFnvaAk2jfQTnjmVJ0tt7mAwaqHQ6NUt3DNJIYq8LH7utQA6QXIwfIdC46lE",
 "expires_in":7200,
 "refresh_token":"56_vQaXS1y1Fnp6zf4lZkFBDA7FNRdrkgDBPSytNMFmwdvey5oufKUIB2-7mjdIK7hjNzdD0pCAe3V7Heerszs1xiRm0jjqRufX_ddaDBviuIc",
 "openid":"o3_SC501zRkVcwqQ_sbnIMcp4awU",
 "scope":"snsapi_login",
 "unionid":"oWgGz1FS61brgcCChgq5yO4mQuZM"}
```



数据库表的结构如下：

![image-20220523152758674](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523152758674.png)





代码如下：

![image-20220523153407411](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523153407411.png)



![image-20220523155403180](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523155403180.png)



前端页面不多说了，了解即可（CV）

![image-20220523155906259](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523155906259.png)





## 整合首页课程和名师

### 名师页面静态效果整合

```vue
<template>
  <div id="aCoursesList" class="bg-fa of">
    <!-- 讲师列表 开始 -->
    <section class="container">
      <header class="comm-title all-teacher-title">
        <h2 class="fl tac">
          <span class="c-333">全部讲师</span>
        </h2>
        <section class="c-tab-title">
          <a id="subjectAll" title="全部" href="#">全部</a>
          <!-- <c:forEach var="subject" items="${subjectList }">
                            <a id="${subject.subjectId}" title="${subject.subjectName }" href="javascript:void(0)" onclick="submitForm(${subject.subjectId})">${subject.subjectName }</a>
          </c:forEach>-->
        </section>
      </header>
      <section class="c-sort-box unBr">
        <div>
          <!-- /无数据提示 开始-->
          <section class="no-data-wrap">
            <em class="icon30 no-data-ico">&nbsp;</em>
            <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
          </section>
          <!-- /无数据提示 结束-->
          <article class="i-teacher-list">
            <ul class="of">
              <li>
                <section class="i-teach-wrap">
                  <div class="i-teach-pic">
                    <a href="/teacher/1" title="姚晨" target="_blank">
                      <img src="~/assets/photo/teacher/1442297885942.jpg" alt>
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a href="/teacher/1" title="姚晨" target="_blank" class="fsize18 c-666">姚晨</a>
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span class="fsize14 c-999">北京师范大学法学院副教授、清华大学法学博士。自2004年至今已有9年的司法考试培训经验。长期从事司法考试辅导，深知命题规律，了解解题技巧。内容把握准确，授课重点明确，层次分明，调理清晰，将法条法理与案例有机融合，强调综合，深入浅出。</span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">北京师范大学法学院副教授</p>
                  </div>
                </section>
              </li>
              <li>
                <section class="i-teach-wrap">
                  <div class="i-teach-pic">
                    <a href="/teacher/1" title="谢娜" target="_blank">
                      <img src="~/assets/photo/teacher/1442297919077.jpg" alt>
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a href="/teacher/1" title="谢娜" target="_blank" class="fsize18 c-666">谢娜</a>
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span class="fsize14 c-999">十年课程研发和培训咨询经验，曾任国企人力资源经理、大型外企培训经理，负责企业大学和培训体系搭建；曾任专业培训机构高级顾问、研发部总监，为包括广东移动、东莞移动、深圳移动、南方电网、工商银行、农业银行、民生银行、邮储银行、TCL集团、清华大学继续教育学院、中天路桥、广西扬翔股份等超过200家企业提供过培训与咨询服务，并担任近50个大型项目的总负责人。</span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">资深课程设计专家，专注10年AACTP美国培训协会认证导师</p>
                  </div>
                </section>
              </li>
              <li>
                <section class="i-teach-wrap">
                  <div class="i-teach-pic">
                    <a href="/teacher/1" title="刘德华" target="_blank">
                      <img src="~/assets/photo/teacher/1442297927029.jpg" alt>
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a href="/teacher/1" title="刘德华" target="_blank" class="fsize18 c-666">刘德华</a>
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span class="fsize14 c-999">上海师范大学法学院副教授、清华大学法学博士。自2004年至今已有9年的司法考试培训经验。长期从事司法考试辅导，深知命题规律，了解解题技巧。内容把握准确，授课重点明确，层次分明，调理清晰，将法条法理与案例有机融合，强调综合，深入浅出。</span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">上海师范大学法学院副教授</p>
                  </div>
                </section>
              </li>
              <li>
                <section class="i-teach-wrap">
                  <div class="i-teach-pic">
                    <a href="/teacher/1" title="周润发" target="_blank">
                      <img src="~/assets/photo/teacher/1442297935589.jpg" alt>
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a href="/teacher/1" title="周润发" target="_blank" class="fsize18 c-666">周润发</a>
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span class="fsize14 c-999">法学博士，北京师范大学马克思主义学院副教授，专攻毛泽东思想概论、邓小平理论，长期从事考研辅导。出版著作两部，发表学术论文30余篇，主持国家社会科学基金项目和教育部重大课题子课题各一项，参与中央实施马克思主义理论研究和建设工程项目。</span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">考研政治辅导实战派专家，全国考研政治命题研究组核心成员。</p>
                  </div>
                </section>
              </li>
              <li>
                <section class="i-teach-wrap">
                  <div class="i-teach-pic">
                    <a href="/teacher/1" title="钟汉良" target="_blank">
                      <img src="~/assets/photo/teacher/1442298121626.jpg" alt>
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a href="/teacher/1" title="钟汉良" target="_blank" class="fsize18 c-666">钟汉良</a>
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span class="fsize14 c-999">具备深厚的数学思维功底、丰富的小学教育经验，授课风格生动活泼，擅长用形象生动的比喻帮助理解、简单易懂的语言讲解难题，深受学生喜欢</span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">毕业于师范大学数学系，热爱教育事业，执教数学思维6年有余</p>
                  </div>
                </section>
              </li>
              <li>
                <section class="i-teach-wrap">
                  <div class="i-teach-pic">
                    <a href="/teacher/1" title="唐嫣" target="_blank">
                      <img src="~/assets/photo/teacher/1442297957332.jpg" alt>
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a href="/teacher/1" title="唐嫣" target="_blank" class="fsize18 c-666">唐嫣</a>
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span class="fsize14 c-999">中国科学院数学与系统科学研究院应用数学专业博士，研究方向为数字图像处理，中国工业与应用数学学会会员。参与全国教育科学“十五”规划重点课题“信息化进程中的教育技术发展研究”的子课题“基与课程改革的资源开发与应用”，以及全国“十五”科研规划全国重点项目“掌上型信息技术产品在教学中的运用和开发研究”的子课题“用技术学数学”。</span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">中国人民大学附属中学数学一级教师</p>
                  </div>
                </section>
              </li>
              <li>
                <section class="i-teach-wrap">
                  <div class="i-teach-pic">
                    <a href="/teacher/1" title="周杰伦" target="_blank">
                      <img src="~/assets/photo/teacher/1442297969808.jpg" alt>
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a href="/teacher/1" title="周杰伦" target="_blank" class="fsize18 c-666">周杰伦</a>
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span class="fsize14 c-999">中教一级职称。讲课极具亲和力。</span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">毕业于北京大学数学系</p>
                  </div>
                </section>
              </li>
              <li>
                <section class="i-teach-wrap">
                  <div class="i-teach-pic">
                    <a href="/teacher/1" title="陈伟霆" target="_blank">
                      <img src="~/assets/photo/teacher/1442297977255.jpg" alt>
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a href="/teacher/1" title="陈伟霆" target="_blank" class="fsize18 c-666">陈伟霆</a>
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span
                      class="fsize14 c-999"
                    >政治学博士、管理学博士后，北京师范大学马克思主义学院副教授。多年来总结出了一套行之有效的应试技巧与答题方法，针对性和实用性极强，能帮助考生在轻松中应考，在激励的竞争中取得高分，脱颖而出。</span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">长期从事考研政治课讲授和考研命题趋势与应试对策研究。考研辅导新锐派的代表。</p>
                  </div>
                </section>
              </li>
            </ul>
            <div class="clear"></div>
          </article>
        </div>
        <!-- 公共分页 开始 -->
        <div>
          <div class="paging">
            <!-- undisable这个class是否存在，取决于数据属性hasPrevious -->
            <a href="#" title="首页">首</a>
            <a href="#" title="前一页">&lt;</a>
            <a href="#" title="第1页" class="current undisable">1</a>
            <a href="#" title="第2页">2</a>
            <a href="#" title="后一页">&gt;</a>
            <a href="#" title="末页">末</a>
            <div class="clear"></div>
          </div>
        </div>
        <!-- 公共分页 结束 -->
      </section>
    </section>
    <!-- /讲师列表 结束 -->
  </div>
</template>
<script>
export default {};
</script>
```





### 讲师列表页

**后端开发**

![image-20220523164003514](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523164003514.png)





**前端开发**

![image-20220523164057526](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523164057526.png)



**测试**

![image-20220523164302631](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523164302631.png)







### 讲师详情页

> 动态路由实现
>
> 在详情页我们要查看讲师信息，课程信息
>
> 所以后端就两个接口，一个根据路径中的参数查询讲师信息
>
> 一个来查询讲师所讲的课程信息

效果如下：

![image-20220523164340272](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523164340272.png)





**根据讲师id查询讲师所讲课程列表**

```java
/**
	 * 根据讲师id查询当前讲师的课程列表
	 * @param teacherId
	 * @return
	 */
@Override
public List<Course> selectByTeacherId(String teacherId) {

    QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();

    queryWrapper.eq("teacher_id", teacherId);
    //按照最后更新时间倒序排列
    queryWrapper.orderByDesc("gmt_modified");

    List<Course> courses = baseMapper.selectList(queryWrapper);
    return courses;
}
```



**根据ID查询讲师**

```java
@ApiOperation(value = "根据ID查询讲师")
@GetMapping(value = "{id}")
public R getById(
		@ApiParam(name = "id", value = "讲师ID", required = true)
		@PathVariable String id){

	//查询讲师信息
	Teacher teacher = teacherService.getById(id);

	//根据讲师id查询这个讲师的课程列表
	List<Course> courseList = courseService.selectByTeacherId(id);

	return R.ok().data("teacher", teacher).data("courseList", courseList);
}
```



**前端开发**

```vue
<template>
  <div id="aCoursesList" class="bg-fa of">
    <!-- 讲师介绍 开始 -->
    <section class="container">
      <header class="comm-title">
        <h2 class="fl tac">
          <span class="c-333">讲师介绍</span>
        </h2>
      </header>
      <div class="t-infor-wrap">
        <!-- 讲师基本信息 -->
        <section class="fl t-infor-box c-desc-content">
          <div class="mt20 ml20">
            <section class="t-infor-pic">
              <img :src="teacher.avatar">
            </section>
            <h3 class="hLh30">
              <span class="fsize24 c-333">{{teacher.name}}&nbsp;
                {{ teacher.level===1?'高级讲师':'首席讲师' }}
              </span>
            </h3>
            <section class="mt10">
              <span class="t-tag-bg">{{teacher.intro}}</span>
            </section>
            <section class="t-infor-txt">
              <p
                class="mt20">{{teacher.career}}</p>
            </section>
            <div class="clear"></div>
          </div>
        </section>
        <div class="clear"></div>
      </div>
      <section class="mt30">
        <div>
          <header class="comm-title all-teacher-title c-course-content">
            <h2 class="fl tac">
              <span class="c-333">主讲课程</span>
            </h2>
            <section class="c-tab-title">
              <a href="javascript: void(0)">&nbsp;</a>
            </section>
          </header>
          <!-- /无数据提示 开始-->
          <section class="no-data-wrap" v-if="courseList.length==0">
            <em class="icon30 no-data-ico">&nbsp;</em>
            <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
          </section>
          <!-- /无数据提示 结束-->
          <article class="comm-course-list">
            <ul class="of">
              <li v-for="course in courseList" :key="course.id">
                <div class="cc-l-wrap">
                  <section class="course-img">
                    <img :src="course.cover" class="img-responsive" >
                    <div class="cc-mask">
                      <a href="#" title="开始学习" target="_blank" class="comm-btn c-btn-1">开始学习</a>
                    </div>
                  </section>
                  <h3 class="hLh30 txtOf mt10">
                    <a href="#" :title="course.title" target="_blank" class="course-title fsize18 c-333">{{course.title}}</a>
                  </h3>
                </div>
              </li>
             
            </ul>
            <div class="clear"></div>
          </article>
        </div>
      </section>
    </section>
    <!-- /讲师介绍 结束 -->
  </div>
</template>
<script>
import teacherApi from '@/api/teacher'
export default {
  //params.id获取路径id值
  asyncData({ params, error }) {
    return teacherApi.getTeacherInfo(params.id)
      .then(response => {
        return {
          teacher: response.data.data.teacher,
          courseList: response.data.data.courseList
        }
      })
  }

};
</script>
```















## 整合微信支付

> [微信支付-开发者文档 (qq.com)](https://pay.weixin.qq.com/wiki/doc/apiv3_partner/apis/chapter4_2_2.shtml)

需求如下：

- 课程分为免费课程和付费课程，如果是免费课程可以直接观看，如果是付费观看的课程，用户需下单支付后才可以观看
- 如果是免费课程，在用户选择课程，进入到课程详情页面时候，直接显示 “立即观看”，用户点击立即观看，可以切换到播放列表进行视频播放
- 如果是付费课程，在用户选择课程，进入到课程详情页面时候，会显示 “立即购买”
- 点击“立即购买”，会生成课程的订单，跳转到订单页面
- 点击“去支付”，会跳转到支付页面，生成微信扫描的二维码
- 使用微信扫描支付后，会跳转回到课程详情页面，同时显示“立即观看”



### 后端开发

**建模块，改pom，yml，启动类**

![image-20220523165907907](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523165907907.png)



**业务类**

> 业务类通过代码生成器生成，在生成的基础上进行改动即可



**开发创建订单接口**

![image-20220523171242902](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523171242902.png)



![image-20220523171811637](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523171811637.png)



![image-20220523171946916](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523171946916.png)





![image-20220523172048422](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523172048422.png)



### 开发微信支付接口

> 这部分不复杂，其实写法也是很固定的

![image-20220523200050729](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523200050729.png)



![image-20220523200414919](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523200414919.png)





**支付订单号查询**

![image-20220523200447576](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523200447576.png)



![image-20220523200534277](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523200534277.png)





![image-20220523200634254](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523200634254.png)









### 前端开发

![image-20220523200730420](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523200730420.png)

![image-20220523200820715](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523200820715.png)



![image-20220523201245363](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523201245363.png)









## 整合统计分析

**建模块，改pom，yml，启动类**

![image-20220523202254687](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523202254687.png)



### 统计某一天的注册人数

> 这个接口的实现定义在了service_ucenter模块中，它是用来获取某一天的注册人数的。
>
> 之后在service_statistics模块中调用service_ucenter模块中的此接口

![image-20220523204810442](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523204810442.png)



具体实现如下：

```xml
<mapper namespace="com.caq.eduucenter.mapper.UcenterMemberMapper">
    <!--查询某一天注册人数-->
    <select id="countRegisterDay" resultType="java.lang.Integer">
        SELECT COUNT(*) FROM ucenter_member uc
        WHERE DATE(uc.gmt_create)=#{day}
    </select>
</mapper>
```



**下面这个sql的意思就是获取ucenter_member中创建日期等于2022-05-16的数量**

```sql
SELECT
	COUNT(*) 
FROM
	ucenter_member uc 
WHERE
	DATE( uc.gmt_create ) = '2022-05-16'
-- 获取日期时间格式里面日期部分
```





### 实现服务调用

![image-20220523202942240](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523202942240.png)



**显示数据**

> 接口这里，我们只需要得到日期和日期对应数量两个集合即可

![image-20220523214957493](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523214957493.png)





### 添加定时任务

> http://cron.ciding.cc/
>
> 定时执行统计注册人数方法，这样就保证了统计表数据更新



**日期工具类**

> 可以指定时间执行某个操作
>
> 通过@EnableScheduling注解标注即可

```java
@Component
public class ScheduledTask {

    @Autowired
    private StatisticsDailyService dailyService;

    /**
     * 测试
     * 每天七点到二十三点每五秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void task1() {
        System.out.println("*********++++++++++++*****执行了");
    }

    /**
     * 每天凌晨1点执行定时，每天一点执行一次统计注册人数数量
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void task2() {
        //获取上一天的日期
        String day = DateUtil.formatDate(DateUtil.addDays(new Date(), -1));
        dailyService.createStatisticsByDay(day);

    }
}
```



**cron表达式怎么写？**

![image-20220523203259210](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523203259210.png)



### 统计数据图表显示

> https://echarts.baidu.com/
>
> 这里我们采用ECharts来实现图标展示
>
> 给apache，用于图表展示，提供了常规的[折线图](https://echarts.baidu.com/option.html#series-line)、[柱状图](https://echarts.baidu.com/option.html#series-line)、[散点图](https://echarts.baidu.com/option.html#series-scatter)、[饼图](https://echarts.baidu.com/option.html#series-pie)、[K线图](https://echarts.baidu.com/option.html#series-candlestick)，用于统计的[盒形图](https://echarts.baidu.com/option.html#series-boxplot)，用于地理数据可视化的[地图](https://echarts.baidu.com/option.html#series-map)、[热力图](https://echarts.baidu.com/option.html#series-heatmap)、[线图](https://echarts.baidu.com/option.html#series-lines)，用于关系数据可视化的[关系图](https://echarts.baidu.com/option.html#series-graph)、[treemap](https://echarts.baidu.com/option.html#series-treemap)、[旭日图](https://echarts.baidu.com/option.html#series-sunburst)，多维数据可视化的[平行坐标](https://echarts.baidu.com/option.html#series-parallel)，还有用于 BI 的[漏斗图](https://echarts.baidu.com/option.html#series-funnel)，[仪表盘](https://echarts.baidu.com/option.html#series-gauge)，并且支持图与图之间的混搭



**生成注册人数页面**

![image-20220523205721881](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523205721881.png)



![image-20220523205857259](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523205857259.png)



**创建生成统计页面**

```vue
<template>
  <div class="app-container">
    <!--表单-->
    <el-form :inline="true" class="demo-form-inline">

      <el-form-item label="日期">
        <el-date-picker
          v-model="day"
          type="date"
          placeholder="选择要统计的日期"
          value-format="yyyy-MM-dd" />
      </el-form-item>


      <el-button
        :disabled="btnDisabled"
        type="primary"
        @click="create()">生成</el-button>
    </el-form>

  </div>
</template>
<script>
import sta from '@/api/sta'
export default {
    data() {
        return {
            day:'',
            btnDisabled: false
        }
    },
    created() {

    },
    methods:{
        create() {
            sta.createStaData(this.day)
                .then(response => {
                    //提示信息
                    this.$message({
                        type: 'success',
                        message: '生成数据成功!'
                    })
                    //跳转到图表显示页面
                    this.$router.push({path:'/sta/show'})
                })
        }
    }
}
</script>

```



**生成图表页面**

先来看下官方文档给出的实例

> 可以看出我们只需要按要求在后端查询出数据，然后传给前端
>
> 前端做数据显示即可

![image-20220523210923391](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523210923391.png)



![image-20220523211243291](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523211243291.png)





### 样式调整

> 参考配置手册：https://echarts.baidu.com/option.html#title

![image-20220523211442301](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523211442301.png)





## 整合Gateway网关

> [Spring全家桶--SpringCloud（中级）_小蜗牛耶的博客-CSDN博客_springcloud](https://blog.csdn.net/qq_45714272/article/details/123797260?spm=1001.2014.3001.5502)
>
> 详细介绍可看上文

![image-20220523215349123](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523215349123.png)



![image-20220523215359541](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523215359541.png)



**建模块、改pom、yml、启动类**

![image-20220523215621092](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523215621092.png)





### 网关相关配置

> 可以把之前控制类上写的@CrossOrigin注解去掉
>
> 所有请求通过gateway网关才会转发给相应微服务，
>
> 我们在gateway中解决跨域问题

![image-20220523215653182](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523215653182.png)



### 全局Filter

> 固定写法

```java
package com.atguigu.gateway.filter;

/**
 * <p>
 * 全局Filter，统一处理会员登录与外部不允许访问的服务
 * </p>
 *
 * @author qy
 * @since 2019-11-21
 */
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        //谷粒学院api接口，校验用户必须登录
        if(antPathMatcher.match("/api/**/auth/**", path)) {
            List<String> tokenList = request.getHeaders().get("token");
            if(null == tokenList) {
                ServerHttpResponse response = exchange.getResponse();
                return out(response);
            } else {
//                Boolean isCheck = JwtUtils.checkToken(tokenList.get(0));
//                if(!isCheck) {
                    ServerHttpResponse response = exchange.getResponse();
                    return out(response);
//                }
            }
        }
        //内部服务接口，不允许外部访问
        if(antPathMatcher.match("/**/inner/**", path)) {
            ServerHttpResponse response = exchange.getResponse();
            return out(response);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private Mono<Void> out(ServerHttpResponse response) {
        JsonObject message = new JsonObject();
        message.addProperty("success", false);
        message.addProperty("code", 28004);
        message.addProperty("data", "鉴权失败");
        byte[] bits = message.toString().getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = response.bufferFactory().wrap(bits);
        //response.setStatusCode(HttpStatus.UNAUTHORIZED);
        //指定编码，否则在浏览器中会中文乱码
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
```





### 自定义异常处理

![image-20220523220133477](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523220133477.png)

![image-20220523220142482](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220523220142482.png)







## 整合配置中心

> [jar包和war包区别及理解_*猪耳朵*的博客-CSDN博客_jar war](https://blog.csdn.net/cjw12581/article/details/107463971)
>
> [Spring全家桶--SpringCloud（高级）_小蜗牛耶的博客-CSDN博客](https://blog.csdn.net/qq_45714272/article/details/123915679?spm=1001.2014.3001.5502)

### 为什么需要配置中心

在开发阶段不适合使用war包，因为在开发阶段，经常需要添加或删除Web应用程序的内容，更新 [Servlet](https://so.csdn.net/so/search?q=Servlet&spm=1001.2101.3001.7020)类文件，而每一次改动后，重新建立war包将是一件浪费时间的事情。在产品发布阶段，使用war文件比较合适的，因为在这个时候，几乎不需要再做什么改动了。



在系统开发过程中，开发者通常会将一些需要变更的参数、变量等从代码中分离出来独立管理，以独立的配置文件的形式存在。目的是让静态的系统工件或者交付物（如 WAR，JAR 包等）更好地和实际的物理运行环境进行适配。配置管理一般包含在系统部署的过程中，由系统管理员或者运维人员完成。配置变更是调整系统运行时的行为的有效手段。



如果微服务架构中没有使用统一配置中心时，所存在的问题：

\- **配置文件分散在各个项目里，不方便维护**

\- **配置内容安全与权限**

\- **更新配置后，项目需要重启**

==nacos配置中心：系统配置的集中管理（编辑、存储、分发）、动态更新不重启、回滚配置（变更管理、历史版本管理、变更审计）等所有与配置相关的活动。==



![image-20220524092334617](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524092334617.png)

![image-20220524092411906](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524092411906.png)





### jar包和war包区别及理解

==**jar是类的归档文件**==
JAR（Java Archive，Java 归档文件）是与平台无关的文件格式，它允许将许多文件组合成一个压缩文件，为 J2EE 应用程序创建的jar文件是 EAR 文件（企业 jar文件），jar文件格式以流行的 ZIP 文件格式为基础。与 ZIP 文件不同的是，jar文件不仅用于压缩和发布，而且还用于部署和封装库、组件和插件程序，并可被像编译器和 JVM 这样的工具直接使用。在 jar中包含特殊的文件，如 manifests 和部署描述符，用来指示工具如何处理特定的 jar。
通常是开发时要引用通用类，打成jar包便于存放管理，当你使用某些功能时就需要这些jar包的支持，需要导入jar包。
jar包就是java的类进行编译生成的class文件打包的压缩包，包里面就是一些class文件。当我们自己使用Maven写一些java程序，进行打包生成jar包。同时在可以在其他的工程下使用，但是我们在这个工程依赖的jar包，在其他工程使用该JAR包也要导入。



==**war包是一个Web应用程序**==
一个web程序进行打包便于部署的压缩包，里面包含我们web程序需要的一些东西，其中包括web.xml的配置文件，前端的页面文件，以及依赖的jar。便于我们部署工程，直接放到tomcat的webapps目录下，直接启动tomcat即可。同时，可以使用WinRAR查看war包，直接将后缀.war改成.rar。



**==jar包和war包区别==**

**jar**是java普通项目打包，通常是开发时要引用通用类，打成jar包便于存放管理。当你使用某些功能时就需要这些jar包的支持，需要导入jar包。**war**是java web项目打包，web网站完成后，打成war包部署到服务器，目的是为了节省资源，提供效率。



### 读取配置文件

![image-20220524084846596](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524084846596.png)





![image-20220524091637274](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524091637274.png)



![image-20220524091913957](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524091913957.png)



**重启测试**

![image-20220524092023186](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524092023186.png)





### 多配置文件加载

**在dev环境写两个配置文件，一个端口配置一个其他配置**

![image-20220524092603975](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524092603975.png)



**测试**

![image-20220524095202572](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524095202572.png)





![image-20220524095446382](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524095446382.png)





## 整合Jenkins

### 代码上传到码云

省略...

### 环境配置

**代码中需要包含Dockerfile文件**

![image-20220524095938488](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524095938488.png)



**在项目pom文件中指定打包类型，包含build部分内容**

![image-20220524100009338](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524100009338.png)



**安装jenkins环境**

在centos环境安装以下环境

- java
- maven
- git
- docker

其中maven的setttings文件最好改成国内源，不然构建的会很慢！



**配置环境变量**

![image-20220524100308095](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524100308095.png)



**部署jenkins**

```
[root@mysql jenkins]# ll
total 92716
-rw-r--r-- 1 root root 94928325 May 20 07:19 jenkins.war

[root@mysql jenkins]# nohup java -jar  /usr/local/jenkins/jenkins.war >/usr/local/jenkins/jenkins.out &
[1] 5570

[root@mysql jenkins]# nohup: ignoring input and redirecting stderr to stdout
```



**登录**

![image-20220524101545453](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524101546657.png)

> 下面这一步不太好用，退出之后还是没有updates文件夹，可以在网上下载好插件，然后把插件复制到plugins再打开就有这些功能了

![image-20220524101609591](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524101609591.png)



**jdk环境配置**

![image-20220524101903702](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524101903702.png)



**git配置**

![image-20220524102010071](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524102010071.png)



**maven配置**

![image-20220524102023279](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524102023279.png)

保持配置即可....



### 构建作业

构建思路：

- 建立任务
- 选择仓库代码
- 选择执行作业的方式



1、建立任务

![image-20220524102201990](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524102201990.png)



2、选择仓库代码

![image-20220524102354875](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524102354875.png)



3、选择执行作业的方式

![image-20220524102537271](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524102537271.png)

代码如下：

```shell
#!/bin/bash
#maven打包
mvn clean package
echo 'package ok!'
echo 'build start!'
cd ./infrastructure/eureka_server
service_name="eureka-server"
service_prot=8761
#查看镜像id
IID=$(docker images | grep "$service_name" | awk '{print $3}')
echo "IID $IID"
if [ -n "$IID" ]
then
    echo "exist $SERVER_NAME image,IID=$IID"
    #删除镜像
    docker rmi -f $service_name
    echo "delete $SERVER_NAME image"
    #构建
    docker build -t $service_name .
    echo "build $SERVER_NAME image"
else
    echo "no exist $SERVER_NAME image,build docker"
    #构建
    docker build -t $service_name .
    echo "build $SERVER_NAME image"
fi
#查看容器id
CID=$(docker ps | grep "$SERVER_NAME" | awk '{print $1}')
echo "CID $CID"
if [ -n "$CID" ]
then
    echo "exist $SERVER_NAME container,CID=$CID"
    #停止
    docker stop $service_name
    #删除容器
    docker rm $service_name
else
    echo "no exist $SERVER_NAME container"
fi
#启动
docker run -d --name $service_name --net=host -p $service_prot:$service_prot $service_name
#查看启动日志
docker logs  $service_name
```

> 第一次可能有些慢，之后就会很快

![image-20220521142847507](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220521142847507.png)



![image-20220524101515900](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524101515900.png)

```shell
[root@mysql jenkins]# docker ps -a
CONTAINER ID   IMAGE          COMMAND                  CREATED         STATUS         PORTS     NAMES
96d5a7108ef9   demojenkins2   "java -jar /demojenk…"   2 minutes ago   Up 2 minutes             demojenkins2


```



部署成功啦！！！

![image-20220521143008672](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220521143008672.png)



# 四、项目总结和复盘

## 项目描述

（1）

> 　　　　B2C(Business to Customer)。B2C中的B是Business，意思是企业，2则是to的谐音，C是Customer，意思是消费者，所以B2C是企业对消费者的电子商务模式。这种形式的电子商务一般以网络零售业为主，主要借助于Internet开展在线销售活动。

在线教育系统，分为前台网站系统和后台管理系统，B2C模式。

前台用户系统包括课程、讲师、问答、文章几大大部分，使用了微服务技术架构，前后端分离开发。

后端的主要技术架构是：SpringBoot + SpringCloud + MyBatis-Plus + MySQL + Maven+EasyExcel+ nginx

前端的架构是：Node.js + Vue.js +element-ui+NUXT+ECharts



其他涉及到的中间件包括Redis、阿里云OSS、阿里云视频点播

业务中使用了ECharts做图表展示，使用EasyExcel完成分类批量添加、注册分布式单点登录使用了JWT



（2）

项目前后端分离开发，后端采用SpringCloud微服务架构，持久层用的是MyBatis-Plus，微服务分库设计，使用Swagger生成接口文档

接入了阿里云视频点播、阿里云OSS。

系统分为前台用户系统和后台管理系统两部分。

前台用户系统包括：首页、课程、名师、问答、文章。

后台管理系统包括：讲师管理、课程分类管理、课程管理、统计分析、Banner管理、订单管理、权限管理等功能。





## 前后端联调经常遇到的问题

  1、请求方式post、get

   2、json、x-wwww-form-urlencoded混乱的错误

   3、后台必要的参数，前端省略了

   4、数据类型不匹配

   5、空指针异常

## 前后端分离项目中的跨域问题是如何解决的

后端服务器配置：我们的项目中是通过Spring注解解决跨域的 @CrossOrigin

也可以使用nginx反向代理、httpClient、网关





## 说说你做了哪个部分、遇到了什么问题、怎么解决的

分布式id生成器在前端无法处理，总是在后三位进行四舍五入。

分布式id生成器生成的id是19个字符的长度，前端javascript脚本对整数的处理能力只有2的53次方，也就是最多只能处理16个字符

解决的方案是把id在程序中设置成了字符串的性质



### 前端渲染和后端渲染有什么区别

前端渲染是返回json给前端，通过javascript将数据绑定到页面上

后端渲染是在服务器端将页面生成直接发送给服务器，有利于SEO的优化



## 能画一下系统架构图吗

![image-20220524104239798](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220524104239798.png)



# 五、Bug记录

## maven错误解决

用我的仓库

删了包，让它重新下





## 执行了全局异常处理

![image-20220412163418570](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220412163418570.png)





![image-20220412163505493](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220412163505493.png)



## Unexpected token o in JSON at position 1 前端JSON数据包解析的问题

https://blog.csdn.net/qq_45790384/article/details/121734015

**清理浏览器cookie**

设置nginx





## 常见的排错方式

如下错误

![image-20220516105619537](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220516105619537.png)



**排错思路**

==从头开始想，当我点击这个按钮的时候发生了什么事，从前端想到后端依次检查。如果都没有错误那就检查其他配置，如nginx，nacos，等第三方技术==



好，那么我们来实践一下

**1、从前到后发森什么事了？**

![image-20220516111618146](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220516111618146.png)



**2、详细分析**

![image-20220516112054147](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220516112054147.png)



==用开发者工具抓包，看看请求的过程都发生了什么==

![image-20220516112405497](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220516112405497.png)





> 因为整个项目是微服务架构，这里其实是订单微服务调用了课程信息、用户信息微服务。
>
> 用户信息都是显示出来的，那就说明是课程微服务出问题了，我们先用swagger进行测试看看接口的功能有没有问题

![image-20220516112908009](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220516112908009.png)





问题逐渐清晰了，后端功能没问题，那就是前端的问题了

其实刚才我们就能定位到是前端的问题，因为课程id参数为undefined，参数是通过前端传的。为了更严谨，我们选择都测试。



让目光再次回到前端代码

![image-20220516113626404](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220516113626404.png)



![image-20220516113819243](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220516113819243.png)



**再次测试**

![image-20220516113935794](https://typora-1259403628.cos.ap-nanjing.myqcloud.com/image-20220516113935794.png)







## Feign调用异常FeignException$NotFound: [404] during

一般来说，feign报404错误有以下几个原因
1、路径错误
在服务消费者断采用GetMapping方式，如
@GetMapping(“knowledge/metadata/delete/{mdcode}”)

在服务提供者端，用
@RestController
@RequestMapping(“knowledge”)
public class KnowledgeGraphController {

@RequestMapping(“metadata/delete/{mdcode}”)
（实现方法)
}

服务消费者端，一定要加上knowledge呀喂

2、在多个客户端上启动了服务提供者服务，而这两边的服务方法没同步，所以在调用feign时，会采用负载均衡，在多个客户端上一边读取一次。如果这个时候恰好读的是没有指定方法的客户端提供的服务，就会报404错误。
建议改好方法之后提交，两边再跑服务

3、路径上参数为null
例如mdcode 为null,匹配不到路径地址，触发不了路径问题


























# 六、参考

## 视频演示

[尚硅谷_谷粒学苑-微服务+全栈在线教育实战项目_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1dQ4y1A75e?p=138&spm_id_from=pageDriver)

## 什么是跨域

https://www.jianshu.com/p/8fa2acd103ea


