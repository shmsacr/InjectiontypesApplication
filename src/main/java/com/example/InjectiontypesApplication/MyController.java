package com.example.InjectiontypesApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    /*
    Injection Yöntemleri

    Field injection
    Setter injection
    Constructor injection

    */

    //Field injection
//    @Autowired
//    private FirstClass firstClass;

    private FirstClass firstClass;

    //Setter injection
    private SecondClass secondClass;

    public MyController(ThirdClass thirdClass) {
        this.thirdClass = thirdClass;
    }

    @Autowired
    public MyController(FirstClass firstClass, @Qualifier("thirdClass") ThirdClass thirdClass) {
        this.firstClass = firstClass;
        this.thirdClass = thirdClass;
    }

    //Constructor injection
    private ThirdClass thirdClass;

    @GetMapping("/names")
    public String getNameOfClass(){
        return this.firstClass.getName() + " - " + this.secondClass.getName() + "-" + this.thirdClass.getName();
    }

    @Autowired
    public void setNameOfClass(SecondClass secondClass){
     this.secondClass = secondClass;
    }
}
