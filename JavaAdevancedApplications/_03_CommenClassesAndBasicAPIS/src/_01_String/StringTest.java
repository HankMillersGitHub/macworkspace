package _01_String;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "helloWorldhelloworldhelloworld";
        // 1. String repalce(char oldChar,char newChar) 返回一个新的字符串，他是通过newChar替换的
        System.out.println(str2.replace('l','o'));
        // 2. String repalce(CharSequence target,CharSequence repalcement) 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
        System.out.println(str2.replace("hello", str1));
        // 3. String repalceAll(String regex,String replacement) 使用给定的replacement替换所有匹配给定的正则表达式的子字符串
        System.out.println(str2.replaceAll("[^a-zA-Z]", str1));
        // 4. String replaceFirst(String regex,String replacement) 使用给定的replacement替换第一个匹配给定的正则表达式的子字符串
        System.out.println(str2.replaceFirst("[^a-zA-Z]", str1));
    }

}
