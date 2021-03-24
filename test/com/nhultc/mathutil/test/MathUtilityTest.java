/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nhultc.mathutil.test;

import com.nhultc.mathutil.MathUtility;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class MathUtilityTest {
    
    //ta sẽ viết những đoạn code ở đây để test cái hàm chính getFactorial()
    //bên MathUtility coi máy chạy có đúng không
    //viết code để test code chính
    //đúng sai ở đây chúng tôi dùng màu sắc XANH ĐỎ
    @Test //biến hàm thường thành hàm main()
    //Shift-F6 để chạy
    public void testFactorialGivenRightArgumentReturnsGoodResult(){
        
        int n = 5; //tui muốn tính 5!
        long expected = 120; //tui hy vọng trả về 120
        long actual = MathUtility.getFactorial(n);
        assertEquals(expected, actual);
        //khớp thì màu xanh, sai lệch thì màu đỏ
        //màu xanh xuất hiện khi tất cả các tình huống xài hàm
        //test case đều xanh
        //màu đỏ xuất hiện ngay khi có ít nhất 1 thằng đỏ
        //                      một test case sai, tất cả bỏ đi
        //ẩn ý: hàm đã dùng thì phải đúng cho tất cả tính huống
        //mình test
        
        assertEquals(720, MathUtility.getFactorial(6)); //6! có đúng là 720
        assertEquals(24, MathUtility.getFactorial(4)); 
        assertEquals(6, MathUtility.getFactorial(3)); 
        assertEquals(2, MathUtility.getFactorial(2)); 
        assertEquals(1, MathUtility.getFactorial(1)); 
        assertEquals(1, MathUtility.getFactorial(0)); 
        //khi màu đỏ thì có 2 tình huống hàm bạn tính sai không như kì vọng
        //                               hàm tính đúng, bạn kì vọng sai
    }
    
    
    //ta sẽ đi test hàm có ném ra ngoại lệ như thiết kế hay không
    //hàm đc thiết kế rằng: đưa tham số n 0..20 -> tình huống n!
    //                      ném ra ngoại lệ cảnh báo sai tham số, ngoài
    //                      miền giá trị tính !
    //chốt: đưa tham số cà chớn phải ném về ngoại lệ
    //      nếu thấy đúng là ném về ngoại lệ khi đưa tham số cà chớn
    //      thì kết luận hàm đúng, XANH
    //thấy ngoại lệ khi đưa n cà chớn, mừng rơi nước mắt vì hàm chạy
    //đúng như thiết kế
    //ngoại lệ xuất hiện khi 5! thì là hàm đúng mà
    //ngoại lệ thì không phải giá trị để so sánh kiểu assertEquals()
    //vậy ta phải dùng kiểu khác!!!
    //@Test(expected = Exception.class) //không nên bắt mức cao nhất
                                        //mặc dù không sai
    @Test(expected = IllegalArgumentException.class)
    public void getFactorialGivenWrongArgumentThrowException(){
        MathUtility.getFactorial(40);
        MathUtility.getFactorial(-40);
        //cá luôn 2 thằng này phải ném về ngoại lệ IllegalArgumentException
    }
}
