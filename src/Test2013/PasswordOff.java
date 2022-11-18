package Test2013;

import com.sun.javafx.image.BytePixelSetter;

import java.util.Scanner;

/**
 * @author nihao
 * @create 2022-11-16 21:47
 */
public class PasswordOff {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.next();//正序字符串
        String s2 = reserve(s1);//逆序字符串
        int[][] arr = new int[s1.length()][s2.length()];
        //第一行
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(0)){
                arr[0][i] = 1;
            }else{
                arr[0][i] = i == 0 ? 0 : arr[0][i - 1];
            }
        }
        //第一列
        for (int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i) == s1.charAt(0)){
                arr[i][0] = 1;
            }else{
                arr[i][0] = i == 0 ? 0 : arr[i - 1][0];
            }
        }
        //其他
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if(s1.charAt(j) == s2.charAt(i)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                }else{
                    arr[i][j] = arr[i-1][j] > arr[i][j-1] ? arr[i-1][j] : arr[i][j-1];
                }
            }
        }
        int result = s1.length() - arr[s2.length()-1][s1.length()-1];
        System.out.println(result);

    }

    public static String reserve(String s){
        char[] arr1 = s.toCharArray();
        char[] arr2 = new char[arr1.length];
        int j = arr1.length-1;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[j];
            j--;
        }
        return new String(arr2);
    }
}
