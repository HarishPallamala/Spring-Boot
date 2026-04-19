package spring.spring_practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Developers {

    @Autowired // field Injection
    @Qualifier("desktop")
    private Computer machineObj; // confused becasue there are 2 objects in IoC with type Computer -> Laptop & Desktop -> use Primary or Qualifyer()

//    private final Machine machineObj;
//    Developers(Machine machineObj){
//        this.machineObj = machineObj;
//    }

//    @Autowired
//    public Developers(Machine machineObj) {
//        this.machineObj = machineObj;
//    }

    public void printMessage(){
        machineObj.compile();
        System.out.println("Just working with Spring");
    }
}
