import java.io.UnsupportedEncodingException;

/**
 * Created by ASUS on 2017/11/7.
 */
public class UnicodeUtil {
    public static String string2Unicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }

        return unicode.toString();
    }
    public static String unicode2String(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        String test = "最代码网站地址:www.zuidaima.com";

        String unicode = string2Unicode(test);

        String string = unicode2String(unicode) ;

        System.out.println(unicode);

        System.out.println(string);



    }
}
