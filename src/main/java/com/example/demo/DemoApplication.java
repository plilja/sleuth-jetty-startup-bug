package com.example.demo;

import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public QueuedThreadPool queuedThreadPool() {
        return new QueuedThreadPool();
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(QueuedThreadPool queuedThreadPool) {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setPort(9000);
        factory.setThreadPool(queuedThreadPool);
        factory.setContextPath("/myapp");
        return factory;
    }
}

/**
 You should see something like the following stacktrace when attempting to start the application.

 Caused by: java.lang.NullPointerException: null
 at org.eclipse.jetty.util.component.AbstractLifeCycle.start(AbstractLifeCycle.java:61) ~[jetty-util-9.4.12.v20180830.jar:9.4.12.v20180830]
 at org.eclipse.jetty.util.component.ContainerLifeCycle.start(ContainerLifeCycle.java:138) ~[jetty-util-9.4.12.v20180830.jar:9.4.12.v20180830]
 at org.eclipse.jetty.server.Server.start(Server.java:416) ~[jetty-server-9.4.12.v20180830.jar:9.4.12.v20180830]
 at org.eclipse.jetty.util.component.ContainerLifeCycle.doStart(ContainerLifeCycle.java:117) ~[jetty-util-9.4.12.v20180830.jar:9.4.12.v20180830]
 at org.eclipse.jetty.server.handler.AbstractHandler.doStart(AbstractHandler.java:113) ~[jetty-server-9.4.12.v20180830.jar:9.4.12.v20180830]
 at org.eclipse.jetty.server.Server.doStart(Server.java:383) ~[jetty-server-9.4.12.v20180830.jar:9.4.12.v20180830]
 ... 15 common frames omitted
 */
