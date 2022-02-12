# 使用spring boot开发的个人博客网站后端接口
使用spring boot作为后端服务接口

# 实现功能
1. 实现了用户的注册与登录验证
2. 实现了文章的各种查询
3. 实现了文章的插入
4. 文章的修改(TODO)
5. 文章的删除(TODO)

# 如何运行项目
- 运行mybatis逆向生成代码
```bash
mvn mybatis-generator:generate
```

- 运行springboot项目
```bash
mvn spring-boot:run
```