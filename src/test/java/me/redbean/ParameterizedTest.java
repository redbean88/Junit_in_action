package me.redbean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(value = Parameterized.class)   // 1.파라미터즈 테스트 러너 설정
public class ParameterizedTest {
    private double expected , valueOne , valueTwo;  // 2. 테스트에 사용할 변수 설정

    /**
     * 3. Prameters annotation 설정
     * 파라미터는 받으면 안됨
     * 리턴값은 반드시 collection 형태
     * @return collection
     */
    @Parameterized.Parameters
    public static Collection<Integer[]> testset(){
        return Arrays.asList(new Integer[][]{
                {2,1,1},
                {3,2,1},
                {4,3,1}
        });
    }

    /**
     * 생성자는 유일해야 하며, 중복시 오류 발생 ( IllegalArgumentException )
     * @param expected
     * @param valueOne
     * @param valueTwo
     */
    public ParameterizedTest(double expected, double valueOne, double valueTwo) {
        this.expected = expected;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Test
    public void sum(){
        Calculater calr = new Calculater();
        assertEquals(expected , calr.add(valueOne,valueTwo),0);
    }

}