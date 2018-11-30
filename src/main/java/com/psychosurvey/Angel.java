package com.psychosurvey;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("angel")
public class Angel implements ExemplarOfJustice {

    @Override
    public void bringJustice() {
        System.out.println("Angel brings justice!");
    }
}
