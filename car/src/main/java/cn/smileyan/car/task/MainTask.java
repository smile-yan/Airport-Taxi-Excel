package cn.smileyan.car.task;

import cn.smileyan.car.util.ExcelUtil;
import cn.smileyan.car.util.WebUtil;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

@Component
public class MainTask {
    private static final Log LOGGER = LogFactory.getLog(MainTask.class);
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Scheduled(fixedRate = 3*60*1000)
    public void mainTask() {
        String html = WebUtil.getHtmlResourceByUrl("http://www.whalebj.com/xzjc/default.aspx?from=singlemessage",
                "utf-8");
        String[] data = new String[5];
        data[0] = simpleDateFormat.format(System.currentTimeMillis());
        String something = WebUtil.getSomething(html,"场内待运车辆数为：", ";");
        data[1] = WebUtil.getSomething(something, "：", "辆").replace("：","");
        String something2 = WebUtil.getSomething(html,"前半小时进场车辆数为：", ";");
        data[2] = WebUtil.getSomething(something2, "：", "辆").replace("：","");
        String something3 = WebUtil.getSomething(html,"前半小时离场车辆数为：", "；");
        data[3] = WebUtil.getSomething(something3, "：", "辆").replace("：","");
        String something4 = WebUtil.getSomething(html,"辆(",")");
        data[4] = something4.substring(2);
        LOGGER.info(data[0]+"\t"+data[1]+"\t"+data[2]+"\t"+data[3]+"\t"+data[4]);
        try {
            ExcelUtil.insertExcel("my-data.xls", data);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }


}
