import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeTest {
    @Test
    public void Test2(){
        var number = new Prime();
        assertTrue(number.isPrime(2));
    }

    @Test
    public void Test3(){
        var number = new Prime();
        assertTrue(number.isPrime(3));
    }

    @Test
    public void Test4(){
        var number = new Prime();
        assertFalse(number.isPrime(4));
    }

    @Test
    public void Test5(){
        var number = new Prime();
        assertTrue(number.isPrime(5));
    }

    @Test
    public void Test6(){
        var number = new Prime();
        assertFalse(number.isPrime(6));
    }
}
