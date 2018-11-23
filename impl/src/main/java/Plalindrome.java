/**
 * 测试是否回文
 */
public class Plalindrome {
    public static void main(String[] args) {
        System.out.println(isPlalindrome("aba"));
        System.out.println(isPlalindrome("abc"));
        System.out.println(isPlalindrome("aaaa"));
    }

    /**
     * 回文是指顺读和倒读都一样的字符串
     * */
    public static boolean isPlalindrome(String str){
        char[] charArray = str.toCharArray();

        for (int i = 0, j = charArray.length - 1; i < j; i++, j--){
            if(charArray[i] != charArray[j]){
                return false;
            }
        }
        return true;
    }
}
