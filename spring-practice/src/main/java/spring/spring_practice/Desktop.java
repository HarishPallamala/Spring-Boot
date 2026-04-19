package spring.spring_practice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{

    public void compile() {
        System.out.println("Compile Message from Desktop Class");
    }
}
