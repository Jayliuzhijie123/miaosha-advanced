package com.miaosha.controller;

import com.miaosha.constant.Constant;
import com.miaosha.service.GoodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@Slf4j
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private HttpServletResponse response;

    @GetMapping("/goods/{id}")
    public ModelAndView index(@PathVariable("id") Integer id) {
//        log.info("gid: {}", id);
        Map<String, Object> map = new HashMap<>(16);
        map.put("goods", goodsService.selectGoodsById(id));
        map.put("covers", goodsService.findCovers(id));
        map.put("details", goodsService.findDetails(id));
        map.put("params", goodsService.findParams(id));
        return new ModelAndView("goods", map);
    }

    @GetMapping("/evaluate/{gid}")
    @ResponseBody
    public Object evaluate(@PathVariable("gid") Long goodsId) {
        return goodsService.findEvaluateByGoodsId(goodsId);
    }
}
