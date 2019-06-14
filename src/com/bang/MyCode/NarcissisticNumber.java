package com.bang.MyCode;


/**
 * Title:
 * Description:
 * Company: 三峡高科
 *
 * @Author: lixibang
 * @Data by 2019年06月13日 18:05.
 */
public class NarcissisticNumber {

    public static void Narcissistic(int maxNumber) {
        if (maxNumber > 0) {
            //遍历maxNumber之内的数字
            for (int i = 1; i < maxNumber; i++) {
                //分离number数
                String[] splitNumber = SplitNumber(i);
                //判断是否是水仙花数
                if (Calcute(i, splitNumber)) {
                      // 打印水仙花数
                      System.out.print(getNumberType(i)+"\n");
                }
            }
        }

    }

    //分离number数
    private static String[] SplitNumber(int number) {
        char[] strNumber = String.valueOf(number).toCharArray();
        String[] splitNumber = new String[strNumber.length];
        for (int i = 0; i < strNumber.length; i++) {
            splitNumber[i] = String.valueOf(strNumber[i]);
        }

        return splitNumber;
    }

    //判断是否是水仙花数
    private static Boolean Calcute(int number, String[] splitNumber){
        int sum = 0;
        //通过数组判断是几位数
        for (int i = 0; i < splitNumber.length; i++) {
            int mathPowNumber_x = Integer.parseInt(splitNumber[i]);
            int mathPowNumber_y = splitNumber.length;
            //计算幂次方运算
            sum += Math.pow(mathPowNumber_x, mathPowNumber_y);
        }

        if (number == sum) {
            return true;
        }

        return false;
    }

    //根据数字位数获取自幂数名字
    private static String getNumberType(int number){
        String type;
        int length = String.valueOf(number).length();
        switch (length) {
            case 1:
                type = "独身数:";
                break;
            case 2:
                type = "没有:";
                break;
            case 3:
                type = "水仙花数:";
                break;
            case 4:
                type = "四叶玫瑰数:";
                break;
            case 5:
                type = "五角星数:";
                break;
            case 6:
                type = "六合数:";
                break;
            case 7:
                type = "北斗七星数:";
                break;
            case 8:
                type = "八仙数:";
                break;
            case 9:
                type = "九九重阳数:";
                break;
            case 10:
                type = "十全十美数:";
                break;
            case 11:
                type = "一心一意数:";
                break;
                default:
                    type = "我都不知道的数:";
        }

        return length + "位自幂数:"+ type + number;
    }

}
