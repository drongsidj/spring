package top.igio.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

/**
 * @author ljl
 * @version V1.0
 * @data 2023/7/9 19:27
 * @description
 */
@RunWith(MockitoJUnitRunner.class)
public class ContinueTest {

    @Test
    public void foreachTest() {
        ArrayList<Object> objects = new ArrayList<>();

        ArrayList<Object> testArray = new ArrayList<>();
        for(int i=0;i<100;i++){
            String s = "第" + i;
            objects.add(s);
        }

        for (Object object : objects) {
            boolean flag = true;
            if (object != null) {
                if(Integer.valueOf(String.valueOf(object).substring(1))%2!=0){
                    flag = true;
                } else {
                    System.out.println("这个不加入数组"+ object);
                    flag = false;
                    continue;
                }
            }
            System.out.println("出现这个表示加入数组-----------------");
            if(flag) {
                System.out.println("这个加入数组"+ object);
                testArray.add(object);
            }
        }
        System.out.println(testArray);
        System.out.println("最终的数组个数为："+ testArray.size());
    }

}
