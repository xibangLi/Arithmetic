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

    private static int queenCount = 8;
    private static int caluteCount = 0;

    public void EightQueenSoultion(int queenNumber){
        Date start = new Date();
        //8皇后问题，最小值为4
        queenCount = queenNumber < 4 ? 8 :queenNumber;
        //初始化
        int[][] chess = new int[queenCount][queenCount];
        for(int i = 0; i < queenCount; i++){
            for (int j = 0; j < queenCount; j++){
                //初始化二维数组为0
                chess[i][j] = 0;
            }
        }

        //计算
        putQueenAtRow(chess, 0);

        Date end = new Date();
        long time = end.getTime() - start.getTime();
        // 输出结果
        System.out.println(queenNumber+"皇后花费"+ time +"ms计算完毕:共"+caluteCount+"种解");
    }

    private static void putQueenAtRow(int[][] chess, int row){
        if(row == queenCount){
            caluteCount++;
            System.out.println("第"+caluteCount+"种解");
            for(int i = 0; i < queenCount; i++){
                for(int k = 0; k < queenCount; k++){
                    System.out.print(chess[i][k] + "   ");
                }
                System.out.println();
            }
            return ;
        }

        int[][] tempChess = chess.clone();
        //
        for(int i = 0; i < queenCount; i++){
            //清空当前行
            for(int k = 0; k < queenCount; k++){
                tempChess[row][k] = 0;
            }
            tempChess[row][i] = 1;
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
            if(col+step < queenCount && chess[row-step][col+step] == 1){//判断右上方
                return false;
            }
            step++;
        }
        return true;
    }

}
