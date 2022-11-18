package Test2013;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 标题：猜年龄
 美国数学家维纳智力早熟，11岁就上了大学，他曾在1935年-1936年来中国清华大学讲学，一次，他参加某个重要会议，年轻的脸孔引人注目。
 于是有人问他的年龄，他回答说：“我年龄的立方是个4位数。我年龄的4次方是6位数。
 这10个数字正好包含了从0到9这10个数字，每个恰好出现1次。“
 请你推算一下，他当时到底有多年轻。

 * @author nihao
 * @create 2022-11-16 11:40
 */
public class GuessAge {
    public static void main(String[] args) {
        for(int age = 11;age <= 100;age++){
            String age3 = age * age * age + "";
            String age4 = age * age * age * age + "";
            if(age3.length() == 4 && age4.length() == 6 && CheckAge(age3,age4)){
                System.out.println(age);
            }
        }
    }

    public static boolean CheckAge(String age3, String age4){
        String age = age3 + age4;
        Set<Character> set = new HashSet<Character>();
        for(int i = 0;i < age.length();i++){
            set.add(age.charAt(i));
        }
        return set.size() == 10;
    }
}
