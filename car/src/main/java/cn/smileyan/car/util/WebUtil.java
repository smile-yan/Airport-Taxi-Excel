package cn.smileyan.car.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebUtil {
    /**
     * 根据开头和结尾关键字获得字符串
     * @param begin
     * @param end
     * @return
     */
    public static String getSomething(String html, String begin, String end) {
        int a = html.indexOf(begin);
        int b = html.indexOf(end,a);
        String result = html.substring(a,b);
        return result;
    }

    /**
     *
     * @param url
     * @param encoding
     * @return 返回字符串
     */
    public static String getHtmlResourceByUrl(String url, String encoding) {
        StringBuffer buffer=new StringBuffer();
        InputStreamReader isr=null;
        try {
            /**
             *  建立网络连接
             * 	打开网络连接
             */
            URL urlObj = new URL(url);
            URLConnection uc = urlObj.openConnection();

            /**
             * 从服务器下载源码到本地
             */
            isr =new InputStreamReader(uc.getInputStream(),encoding);
            BufferedReader reader =new BufferedReader(isr);

            String line;
            boolean flag=false;
            int count=0;
            while ((line=reader.readLine())!=null) {
                buffer.append(line+"\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try{
                if(null!=isr) {
                    isr.close();
                }
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        return buffer.toString();
    }
}
