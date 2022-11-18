package Test2013;

import java.util.Scanner;

/**
 * @author nihao
 * @create 2022-11-16 15:43
 */
public class CutLattice {
    static int[][] arr;//存储矩阵中元素
    static int[][] state;//标记格子是否走过，1，走过，0，没走过
    static int m;//列数
    static int n;//行数
    static int sum;//二维数组的元素之和
    static int min = 100;//假设最小值为100
    public static void main(String[] args) {
        //输入
        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();
        arr = new int[n][m];
        state = new int[n][m];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = input.nextInt();
                sum = sum + arr[i][j];
            }
        }
        if(sum % 2 == 1){
            System.out.println("0");
            return;
        }
        //调用递归方法
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                move(i,j,0,0);
            }
        }

        System.out.println(min == 100 ? 0 : min);
    }
    public static void move(int row,int col,int step,int add){
        if(row < 0 || col < 0 || row > n - 1 || col > m-1 || state[row][col] == 1){
            return;
        }
        //判断累加的和为总和的一半
        if(add == sum/2 && state[0][0] == 1){
            min = step < min ? step : min;
            return;
        }
        state[row][col] = 1;//标记该格子已经走过了
        move(row - 1,col,step + 1,add + arr[row][col]);//上
        move(row + 1,col,step + 1,add + arr[row][col]);//下
        move(row ,col - 1,step + 1,add + arr[row][col]);//左
        move(row,col + 1,step + 1,add + arr[row][col]);//右
        state[row][col] = 0;//还原标记
    }
}
