# Spring MVC 介绍

## 什么是 Spring MVC

Spring MVC 是 Spring Framework 的一个模块，是一个基于 MVC (Model-View-Controller) 设计模式的 Web 框架。它通过一系列注解和配置来简化 Web 应用程序的开发，提供了一个高度可配置和灵活的 Web 应用程序开发环境。

## MVC 架构

Spring MVC 基于 MVC 设计模式实现：

- **模型 (Model)**: 封装应用程序数据和业务逻辑
- **视图 (View)**: 负责数据的展示，通常是 HTML 页面
- **控制器 (Controller)**: 处理用户请求并调用业务逻辑

## Spring MVC 核心组件

1. **DispatcherServlet**: 前端控制器，所有请求的入口
2. **Handler Mapping**: 将请求映射到对应的处理器
3. **Controller**: 处理用户请求
4. **ModelAndView**: 包含模型数据和视图信息
5. **ViewResolver**: 解析视图名称，定位具体的视图实现
6. **View**: 渲染模型数据，生成响应内容

## 请求处理流程

1. 用户发送请求至前端控制器 DispatcherServlet
2. DispatcherServlet 通过 HandlerMapping 找到对应的 Handler (Controller)
3. 执行 Handler 处理业务并返回 ModelAndView
4. DispatcherServlet 通过 ViewResolver 解析视图
5. 视图渲染结果返回给用户

## Spring MVC 特点

- 基于注解的配置方式，简化开发
- 灵活的视图解析机制
- 强大的数据绑定和验证
- RESTful API 支持
- 优秀的异常处理机制
- 与 Spring 生态无缝集成

## 基本使用示例

```java
@Controller
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
```

## 配置示例

```java
@Configuration
@EnableWebMvc
@ComponentScan("com.example.controllers")
public class WebConfig implements WebMvcConfigurer {
    
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
```