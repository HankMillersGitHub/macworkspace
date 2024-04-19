package _01_String;

public class Exer_01_Reverse {
    public static void main(String[] args) {
        System.out.println(reverse("abcdefghijklmn",3,9));
        System.out.println(myTrim("****" + "   this is   "));
        System.out.println(getNumber("abcabcabcabcabcdefghijklmnopqabc","abc"));
        System.out.println(maxCommonSubstring("abcdefghijklmnopqrstuvwxyz", "abcjklmnjqka"));
    }
    // 手写reverse
    public static String reverse(String str,int beginIndex,int endIndex){
        char[] chars = str.toCharArray();
        char[] chars1 = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            if(i >= beginIndex && i < endIndex){
                chars1[i] = chars[chars.length - 1 - i];
            }else{
                chars1[i] = chars[i];
            }
        }
        return String.copyValueOf(chars1);
    }
    // 手写trim
    public static String myTrim(String str){
        if (str == null) {
            return null;
        }
        int start = 0;
        int end = str.length() - 1;
        // 移除开头的空白字符
        while (start <= end && Character.isWhitespace(str.charAt(start))) {
            start++;
        }
        // 移除结尾的空白字符
        while (end >= start && Character.isWhitespace(str.charAt(end))) {
            end--;
        }
        // 如果整个字符串都是空白字符，则返回空字符串
        if (start > end) {
            return "";
        }
        // 截取非空白字符部分
        return str.substring(start, end + 1);
    }

    // 获取一个字符串在另一个字符串中出现的次数
    /**
     * @param farStr:
     * @param sonStr:
    int
     * return
     * @author HankMiller
     * @date 2024/04/17 18:52
     * {@link }
     * @description 判断sonStr在farStr中出现的次数
     */
    public static int getNumber(String farStr,String sonStr){
        int count = 0;
        int index = farStr.indexOf(sonStr);
        while (index >= 0){
            count++;
            index = farStr.indexOf(sonStr,index + sonStr.length());
        }
        return count;
    }

    // 获取两个字符串中最大的相同子串
    public static String maxCommonSubstring(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            return ""; // 如果有一个字符串为空，则返回空字符串
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int maxLen = 0; // 记录最长公共子串的长度
        int endIndex = 0; // 记录最长公共子串的结束位置
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i - 1; // 更新最长公共子串的结束位置
                    }
                }
            }
        }
        if (maxLen == 0) {
            return ""; // 如果最长公共子串的长度为0，则返回空字符串
        }
        // 根据最长公共子串的结束位置和长度，获取最长公共子串
        return str1.substring(endIndex - maxLen + 1, endIndex + 1);
    }
}
