package me.redbean.timeLimit;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculaterTest {

    @Test(timeout = 5)                          // 1. 수행 시간 확인 (milliseconds)
    public void timelimit5(){
        Calculater calculater = new Calculater();
        for (int i = 0; i < 100000; i++) {
            calculater.add(1,2);
        }
    }

}