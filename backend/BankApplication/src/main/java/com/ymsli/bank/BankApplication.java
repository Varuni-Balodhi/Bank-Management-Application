package com.ymsli.bank;
//SpringBoot will scan this package and all the sub packages.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
		System.out.println("Spring has started");
	}
}
//JVM starts execution from main()
//Spring boot initializes the entire application context from here
//Embedded tomcat server is started
//All the components,beans and configuration are loaded here.
/*
 @SpringBootApplication=@SpringBootConfiguration+@EnableAutoConfiguration+@ComponentScan
 
 */
