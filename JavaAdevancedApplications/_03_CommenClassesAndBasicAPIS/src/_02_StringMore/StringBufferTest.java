package _02_StringMore;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("abc");
        // 1. int indexOf(String str) 在当前字符序列中查询str第一次出现的标
        System.out.println(str.indexOf("a")); // 0
        // 2. int indexOf(String str,int fromIndex) 在当前字符序列[fromIndex,最后]中查寻str第一次出现的下标
        System.out.println(str.indexOf("b",1)); // 0
        // 3. int lastIndexOf(String str) 在当前字符串中查找str最后一次出现的下标
        System.out.println(str.lastIndexOf("c")); // 2
        // 4. int lastIndexOf(String str,int fromIndex) 在当前字符序列[fromIndex,最后]中查询str最后一次出现的位置
        System.out.println(str.lastIndexOf("c",1)); // 2
        // 5. String substring(int start) 截取当前字符序列的[start,最后]的字符序列
        System.out.println(str.substring(1)); // bc
        // 6. String subtring(int start,int end) 截取当前字符序列[start,end]
        System.out.println(str.substring(0, 1)); // ab
        // 7. String toString() 返回此字符串中数据的字符串表现形式
        System.out.println(str.toString());// abc
        // 8. void setLength(int newLength) 设置当前字符序列长度为newLength
        str.setLength(10);
        System.out.println(str.length()); // 10


    }

}
