package Test2013;

import java.util.Scanner;

/**
 * @author nihao
 * @create 2022-11-16 20:25
 */
public class SetDice {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int mod = 1000000007;
        int n = input.nextInt();//骰子数量
        int m = input.nextInt();//互斥组合数量
        boolean[][] hc = new boolean[7][7];
        for (int i = 0; i < m; i++) {
            int one = input.nextInt();//互斥的第一个数字
            int two = input.nextInt();//互斥的第二个数字
            hc[one][two] = true;
            hc[two][one] = true;
        }
        long[][] data = new long[2][7];
        for (int i = 1; i <= 6; i++) {
            data[0][i] = 1;//将第一行元素全部设为1
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 6; j++) {
                data[1][j] = 0;//将第二行全部设置为0
            }
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    int up = k;
                    int down = 0;
                    if(j == 1) down = 4;
                    if(j == 4) down = 1;
                    if(j == 2) down = 5;
                    if(j == 5) down = 2;
                    if(j == 3) down = 6;
                    if(j == 6) down = 3;
                    if(hc[up][down] == true || hc[down][up] == true)
                        continue;
                    data[1][j] = (data[1][j] + data[0][k]) % mod;
                }
            }
            for (int j = 1; j <= 6; j++) {
                data[0][j] = data[1][j];//将第二行填充到第一行
            }
        }
        long sum = 0;
        //累加到第二行
        for (int i = 1; i <= 6; i++) {
            sum = (sum + data[1][i]) % mod;
        }
        //考虑骰子旋转
        for (int i = 1; i <= n; i++) {
            sum = (sum * 4) % mod;
        }
        System.out.println(sum);
    }
}
