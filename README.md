# IT岗位求职记录系统

## 项目简介
这是一个基于Spring Boot + MySQL + Thymeleaf的IT岗位求职记录系统，用于管理和跟踪求职信息。

## 技术栈
- **后端框架**: Spring Boot 2.7.15
- **数据库**: MySQL
- **ORM框架**: Spring Data JPA
- **前端模板**: Thymeleaf
- **前端样式**: Bootstrap
- **构建工具**: Maven
- **编程语言**: Java 8

## 功能特性
- ✅ 岗位信息的增删改查（CRUD）操作
- ✅ 岗位状态管理（投递中、面试中、已录用、已拒绝）
- ✅ 按条件搜索筛选岗位信息
- ✅ 友好的用户界面，支持响应式设计
- ✅ 自动记录创建和更新时间

## 项目结构
```
src/main/java/com/example/jobrecorder/
├── JobRecorderApplication.java  # 应用程序入口
├── controller/                  # 控制器层
├── service/                     # 业务逻辑层
│   └── impl/                    # 业务逻辑实现
├── repository/                  # 数据访问层
└── entity/                      # 实体类

src/main/resources/
├── templates/                   # Thymeleaf模板
│   ├── layout/                  # 布局模板
│   └── job/                     # 岗位相关页面
└── application.properties       # 应用程序配置
```

## 快速开始

### 环境要求
- JDK 1.8+
- Maven 3.6+
- MySQL 5.7+

### 配置说明
1. 修改 `application.properties` 文件中的数据库连接信息：
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/job_recorder?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=1234
   ```

2. 确保MySQL数据库已创建数据库名为 `job_recorder`

### 运行方式
1. **使用Maven运行**:
   ```bash
   mvn spring-boot:run
   ```

2. **打包后运行**:
   ```bash
   mvn clean package
   java -jar target/job-recorder-0.0.1-SNAPSHOT.jar
   ```

## 访问地址
启动成功后，可通过以下地址访问系统：
- **系统首页**: http://localhost:8080/job-recorder/

## 系统信息
- **开发人员**: 王凯旋
- **学号**: 20234113
- **班级**: 信2305-1

## 注意事项
1. 首次运行时，系统会自动创建所需的数据表
2. 确保MySQL服务正在运行
3. 如需修改端口或上下文路径，可在application.properties中配置