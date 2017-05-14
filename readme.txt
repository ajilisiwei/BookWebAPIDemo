1.使用spring-boot+mybatis+groovy+maven实现一个简单的Restful WebAPI项目
2.使用mysql数据库
    (1).脚本
    create database books;
    use books;
    create table book(
        id int(5) auto_increment not null primary key,
        title varchar(30) not null,
        description varchar(100),
        pub_time date,
        author varchar(30)
    );
3.设置spring-boot的热部署
    (1).参考: http://blog.csdn.net/my_chen_suo_zhang/article/details/69396808
4.API调试工具: PostMan
4.项目已在linux上部署成功(使用spring-boot内置tomcat)