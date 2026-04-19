package spring.spring_practice;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // if you dont want this Primary then we can decide at Sub level where we are using this class object i.e., Qualifier("laptop") to avoid confusions
public class Laptop implements Computer {

    public void compile(){
        System.out.println("Compile Message from Laptop Class");
    }
}
