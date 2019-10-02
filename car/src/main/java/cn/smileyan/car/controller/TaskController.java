package cn.smileyan.car.controller;

import cn.smileyan.car.util.ExcelUtil;
import jxl.read.biff.BiffException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {

    @GetMapping("/")
    private Map<String,Object> task() throws IOException, BiffException {
        Map<String, Object> mytask = new HashMap<>();
        List<String> strings = ExcelUtil.toList("my-csdn.xls");
        mytask.put("result",strings);
        return mytask;
    }
}
