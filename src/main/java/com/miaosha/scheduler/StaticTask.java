package com.miaosha.scheduler;

import com.miaosha.constant.Constant;
import com.miaosha.model.Goods;
import com.miaosha.service.GoodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lzj on 2019/04/01
 */
public class StaticTask {
    @Resource
    private Configuration freemarkerConfig;

    @Resource
    private GoodsService goodsService;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void doStatic() throws IOException, TemplateException {
        Template template = freemarkerConfig.getTemplate("goods.ftl");
        FileWriter fileWriter = null;
        List<Goods> last5M = goodsService.findLast5M();
        for (Goods goods : last5M) {
            Integer gid = goods.getGoodsId();
            HashMap<String, Object> map = new HashMap<>(16);
            map.put("goods", goodsService.selectGoodsById(gid));
            map.put("covers", goodsService.findCovers(gid));
            map.put("details", goodsService.findDetails(gid));
            map.put("params", goodsService.findParams(gid));

            File file = new File(Constant.templatePath + "goods" + File.separator + gid + ".html");
            fileWriter = new FileWriter(file);
            template.process(map, fileWriter);
        }

        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}
