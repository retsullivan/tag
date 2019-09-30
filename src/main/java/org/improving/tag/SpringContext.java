package org.improving.tag;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;


@Configuration            //this is autowiring - spring is going to follow the norms automatically
@ComponentScan("org.improving.tag")
//these two lines make it so spring is configured


public class SpringContext {
    @Bean
    public Scanner getScanner () {return new Scanner(System.in); }


}
