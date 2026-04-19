package spring.spring_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {
		// IoC stands for Inversion of Control. Instead of your code creating and managing objects manually, the container takes over that responsibility.
		/*
The two main IoC container types in Spring Framework
1. BeanFactory (basic container)
The simplest IoC container
Creates beans only when needed (lazy loading)
Rarely used directly in modern apps
2. ApplicationContext (advanced container)
A more powerful version of BeanFactory
Used in almost all real applications (especially Spring Boot)
		 */
		ApplicationContext context =
		SpringApplication.run(SpringPracticeApplication.class, args); // this line creates IoC of type ApplicationContext
		Developers dev = context.getBean(Developers.class); //Taking our Developers Object from IoC, to tell spring to create this Class object in IoC we will use @Component in Developer class
		dev.printMessage();
	}

}
