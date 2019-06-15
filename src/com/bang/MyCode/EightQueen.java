package com.bang.MyCode;

import java.util.Date;

/**
 * Title:
 * Description:
 * Company: 三峡高科
 *
 * @Author: lixibang
 * @Data by 2019年06月14日 18:38.
 */
public class EightQueen {

    private static int queenTotal = 8;
    private static int calculateCount = 0;
    private static int total = 0;

    public void EightQueenSolution(int queenNumber){
        Date start = new Date();
        //8皇后问题，最小值为4
        queenTotal = queenNumber < 4 ? 8 :queenNumber;
        //初始化
        int[][] chess = new int[queenTotal][queenTotal];
        for(int i = 0; i < queenTotal; i++){
            for (int j = 0; j < queenTotal; j++){
                //初始化二维数组为0
                chess[i][j] = 0;
            }
        }

        //计算
        putQueenAtRow(chess, 0);

        Date end = new Date();
        long time = end.getTime() - start.getTime();
        // 输出结果
        System.out.println(queenNumber+"皇后花费"+ time +"ms计算完毕:共"+calculateCount+"种解");
        System.out.println("clone："+total);
    }

    private static void putQueenAtRow(int[][] chess, int row){
        //递归退出条件，如果row==queenTotal，说明已经有了row个皇后了
        if(row == queenTotal){
            calculateCount++;
            System.out.println("第"+calculateCount+"种解");

            //打印二维数组
            for(int i = 0; i < queenTotal; i++){
                for(int k = 0; k < queenTotal; k++){
                    System.out.print(chess[i][k] + "   ");
                }
                System.out.println();
            }
            return ;
        }

        int[][] tempChess = chess.clone();
        total++;

        //循环放置皇后
        for(int i = 0; i < queenTotal; i++){
            //清空当前行
            for(int k = 0; k < queenTotal; k++){
                tempChess[row][k] = 0;
            }
            tempChess[row][i] = 1;
            //判断当前位置的皇后是否安全，如果安全，进行下一行操作，如果不安全，
            //继续尝试当前行的下一个位置，此时需要先清空当前行(即上一个循环)
            if(isSafety(tempChess, row, i)){

                putQueenAtRow(tempChess, row+1);
            }
        }
    }

    //判断当前位置的皇后是否安全
    private static boolean isSafety(int[][] chess, int row, int col){
        int step = 1;
        //从最后一行开始循环判断
        while(row - step >= 0 ){
            if(chess[row-step][col] == 1){//判断中上方
                return false;
            }
            if(col-step >= 0 && chess[row-step][col-step] == 1){//判断左上方
                return false;
            }
            if(col+step < queenTotal && chess[row-step][col+step] == 1){//判断右上方
                return false;
            }
            step++;
        }
        return true;
    }

}
