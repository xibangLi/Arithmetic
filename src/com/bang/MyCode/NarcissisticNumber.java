package com.bang.MyCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 * Description:
 * Company: 三峡高科
 *
 * @Author: lixibang
 * @Data by 2019年06月13日 18:05.
 */
public class NarcissisticNumber {

    public void Narcissistic(int maxNumber) {
        if (maxNumber > 0) {
            //遍历maxNumber之内的数字
            for (int i = 1; i < maxNumber; i++) {
                //分离number数
                String[] splitNumber = SplitNumber(i);
                //判断是否是水仙花数
                if (Calcute(i, splitNumber)) {
                    //打印水仙花数
                    System.out.print("水仙花数："+i);
                }
            }
        }

    }

    //分离number数
    private String[] SplitNumber(double number) {
        char[] strNumber = String.valueOf(number).toCharArray();
        String[] splitNumber = new String[strNumber.length];
        for (int i = 0; i < strNumber.length; i++) {
            splitNumber[i] = String.valueOf(strNumber[i]);
        }

        return splitNumber;
    }

    //判断是否是水仙花数
    private Boolean Calcute(double number, String[] splitNumber){
        double sum = 0;
        //通过数组判断是几位数
        for (int i = 0; i < splitNumber.length; i++) {
            double mathPowNumber_x = Double.parseDouble(splitNumber[i]);
            double mathPowNumber_y = splitNumber.length;
            //计算幂次方运算
            sum += Math.pow(mathPowNumber_x, mathPowNumber_y);
        }

        if (number == sum) {
            return true;
        }

        return false;
    }


}
