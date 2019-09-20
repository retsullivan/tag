package org.improving.tag;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration            //this is autowiring - spring is going to follow the norms automatically
@ComponentScan("org.improving.tag")
//these two lines make it so spring is configured


public class SpringContext {


}
