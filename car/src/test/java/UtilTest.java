import cn.smileyan.car.util.WebUtil;

public class UtilTest {
    public static void main(String[] args) {
        String html = WebUtil.getHtmlResourceByUrl("http://www.whalebj.com/xzjc/default.aspx?from=singlemessage",
                "utf-8");
        String something = WebUtil.getSomething(html,"场内待运车辆数为：", ";");
        System.out.println(something);
        String something2 = WebUtil.getSomething(html,"前半小时进场车辆数为：", ";");
        System.out.println(something2);
        String something3 = WebUtil.getSomething(html,"前半小时离场车辆数为：", "；");
        System.out.println(something3);
    }
}
