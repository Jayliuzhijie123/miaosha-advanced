package com.miaosha.controller;

import com.miaosha.config.ServerInfo;
import com.miaosha.constant.SeckillConstant;
import com.miaosha.global.Result;
import com.miaosha.model.Evaluate;
import com.miaosha.model.Order;
import com.miaosha.service.GoodsService;
import com.miaosha.service.OrderService;
import freemarker.template.Configuration;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@Slf4j
public class GoodsController {

    @Resource
    private ServerInfo serverInfo;

    @Resource
    private GoodsService goodsService;

    @Resource
    private HttpServletResponse response;

    @Resource
    private OrderService orderService;

    @Resource
    private Configuration freemarkerConfig;

    @GetMapping("/goods/{id}.html")
    public ModelAndView index(@PathVariable("id") Integer id) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("goods", goodsService.selectGoodsById(id));
        map.put("covers", goodsService.findCovers(id));
        map.put("details", goodsService.findDetails(id));
        map.put("params", goodsService.findParams(id));
        return new ModelAndView("goods", map);
    }

    @GetMapping("/evaluate/{gid}")
    @ResponseBody
    public List<Evaluate> evaluate(@PathVariable("gid") Long goodsId) {
        log.info("位于 [{}:{}] 的服务器正在处理", serverInfo.getAddress(), serverInfo.getPort());
        return goodsService.findEvaluateByGoodsId(goodsId);
    }

    @PostMapping("/seckill/{gid}")
    @ResponseBody
    public Map<String, Object> purchaseGoods(@PathVariable("gid") Integer goodsId,
                               @RequestParam("userId") String userId) {
        goodsService.purchaseGoods(goodsId, userId, SeckillConstant.NUM);
        String orderNo = goodsService.sendMsgToQueue(userId);
        Map<String, Object> success = Result.success();
        Map<String, Object> data = new HashMap<>(2);
        data.put("orderNo", orderNo);
        data.put("userId", userId);
        success.put("data", data);
        return success;
    }

    @GetMapping("checkOrder")
    public ModelAndView checkOrder(@RequestParam("orderNo") String orderNo) {
        Order order = orderService.selectOrderByOrderNo(orderNo);
        ModelAndView modelAndView = new ModelAndView();
        if (order != null) {
            //订单已创建完成
            modelAndView.addObject("order", order);
            //转向order.ftl
            modelAndView.setViewName("/order");
        } else {
            //订单未创建完成
            modelAndView.addObject("orderNo", orderNo);
            modelAndView.setViewName("/waiting");
        }
        return modelAndView;
    }


//    @GetMapping("/goodsAll")
//    public void staticAll() throws IOException, TemplateException {
//        Template template = freemarkerConfig.getTemplate("goods.ftl");
//        FileWriter fileWriter = null;
//        List<Integer> goodsIds = goodsService.findAll();
//        for (Integer gid : goodsIds) {
//            HashMap<String, Object> map = new HashMap<>(16);
//            map.put("goods", goodsService.selectGoodsById(gid));
//            map.put("covers", goodsService.findCovers(gid));
//            map.put("details", goodsService.findDetails(gid));
//            map.put("params", goodsService.findParams(gid));
//
//            File file = new File(Constant.templatePath + "goods" + File.separator + gid + ".html");
//            fileWriter = new FileWriter(file);
//            template.process(map, fileWriter);
//        }
//
//        response.getWriter().println("ok");
//
//        if (fileWriter != null) {
//            fileWriter.close();
//        }
//    }
}
