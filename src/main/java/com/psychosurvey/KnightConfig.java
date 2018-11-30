package com.psychosurvey;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {

    @Bean
    @Qualifier("knight")
    public Knight knight(){
        return new Knight();
    }

}
