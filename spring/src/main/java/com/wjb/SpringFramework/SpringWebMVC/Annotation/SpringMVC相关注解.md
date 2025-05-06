# Spring MVC 相关注解

Spring MVC 框架提供了许多专用注解，用于简化 Web 应用程序的开发。以下是 Spring MVC 模块特有的注解：

## 控制器相关注解

- `@Controller` - 标记一个类作为 Spring MVC 控制器
- `@RestController` - 组合注解，相当于 `@Controller` + `@ResponseBody`

## 请求映射注解

- `@RequestMapping` - 映射 Web 请求到特定处理器类/方法
- `@GetMapping` - 处理 HTTP GET 请求的快捷方式
- `@PostMapping` - 处理 HTTP POST 请求的快捷方式
- `@PutMapping` - 处理 HTTP PUT 请求的快捷方式
- `@DeleteMapping` - 处理 HTTP DELETE 请求的快捷方式
- `@PatchMapping` - 处理 HTTP PATCH 请求的快捷方式

## 请求参数注解

- `@RequestParam` - 绑定请求参数到方法参数
- `@PathVariable` - 绑定 URL 模板变量到方法参数
- `@RequestBody` - 绑定 HTTP 请求体到方法参数
- `@RequestHeader` - 绑定 HTTP 请求头到方法参数
- `@CookieValue` - 绑定 HTTP cookie 值到方法参数
- `@RequestPart` - 处理 multipart/form-data 请求中的部分内容

## 响应处理注解

- `@ResponseBody` - 将方法返回值直接作为 HTTP 响应体
- `@ResponseStatus` - 指定响应的 HTTP 状态码
- `@ModelAttribute` - 绑定方法参数或返回值到模型属性

## 异常处理注解

- `@ExceptionHandler` - 声明异常处理方法
- `@ControllerAdvice` - 定义全局控制器增强，常用于全局异常处理
- `@RestControllerAdvice` - `@ControllerAdvice` 和 `@ResponseBody` 的组合

## 其他注解

- `@SessionAttributes` - 声明会话属性
- `@CrossOrigin` - 配置跨域资源共享(CORS)
- `@InitBinder` - 自定义请求参数绑定器

这些注解使得 Spring MVC 应用程序的开发更加便捷和声明式，减少了样板代码，提高了开发效率。

# Spring MVC 相关注解面试题

## 1、@Controller 和 @RestController 的区别

- 1.本质区别
    - `@Controller` 是一个基础注解，标识一个类作为Spring MVC控制器。
    - `@RestController` 是一个组合注解，等同于 `@Controller + @ResponseBody`。
- 2.返回值处理
    - @Controller：
        - 默认返回视图名称（View）
        - 返回的字符串会被解析为视图名，然后由ViewResolver查找对应的视图文件
        - 适合返回HTML页面
    - @RestController：

        - 默认返回数据对象（而非视图）
        - 返回的对象会被自动序列化为JSON/XML等格式作为HTTP响应体
        - 适合构建RESTful API

> 注意：`@RestController` 是 Spring 4.x 引入的，之前的版本需要在 `@Controller` 上添加 `@ResponseBody` 注解来实现相同的功能。

- 3.使用场景
    - `@Controller`：适用于需要返回视图的传统Web应用程序
    - `@RestController`：适用于构建RESTful Web服务或API

        - `@Controller` 示例：
        ```java
        @Controller
        public class MyController {
            @RequestMapping("/hello")
            public String hello() {
                return "hello"; // 返回视图名称
            }
        }
        ```

        - `@RestController` 示例：
        ```java
        @RestController
        public class MyRestController {
            @GetMapping("/api/hello")
            public String hello() {
                return "Hello, World!"; // 返回JSON数据
            }
        }
        ```

**面试回答参考：**
> - `@Controller` 是一个基础注解，用于标识一个类作为 Spring MVC 控制器，默认返回视图名称，适用于需要返回视图的场景。
> - `@RestController` 是一个组合注解，等同于 `@Controller + @ResponseBody`，用于构建 RESTful API，默认返回 JSON 数据，适用于需要返回数据对象的场景。
> - 需要注意的是，`@RestController` 是 Spring 4.x 引入的，4.x之前的版本需要在 `@Controller` 上添加 `@ResponseBody` 注解来实现相同的功能。