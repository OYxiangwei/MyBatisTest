# MyBatisTest
mybatis_demo
导入所需jar包(pom.xml-dependencies-build)
配置文件 mybatis.cfg.xml(configuration-typeAliases-[environments-environment-transactionManager-dataSource]-mappers)
实体类 User(类get/set方法）
创建方法接口（UserMapper.java- 增删改查接口）
定义映射文件(UserMapper.xml(mapper namespace-resultMap-<update id="updateUser"  parameterType="User">）
日志记录 log4j.properties
测试类 UserTest（读取Mybatis 配置文件-sqlSessionFactory-session-session.getMapper-mapper.方法）



