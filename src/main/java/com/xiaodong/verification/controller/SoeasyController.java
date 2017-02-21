package com.xiaodong.verification.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 一些模拟合作方服务
 */
@Controller
@RequestMapping("soeasy")
public class SoeasyController {

    private static final Logger LOG = LoggerFactory.getLogger(SoeasyController.class);

    private static final String PATH = "/Users/lixiaodong/Pictures/";

    @RequestMapping("tid.do")
    @ResponseBody
    public String tid(String requestData) {
        LOG.info("requestData={}", requestData);
        JSONObject dataJson = JSON.parseObject(requestData);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "0");
        jsonObject.put("message", "查询成功");
        if ("query".equals(dataJson.getJSONObject("data").getString("action"))) {
            JSONObject data = new JSONObject();
            data.put("tid", "7824C8D5FBBE4CD396E0486074916323");
            jsonObject.put("data", data);
        } else {
            jsonObject.put("status", "20012");
        }
        return jsonObject.toJSONString();
    }

    @RequestMapping("limit.do")
    @ResponseBody
    public String limit(String idCard, String mobileCollectTime, String jingdongCollectTime) {
        LOG.info("参数idCard={},mobileCollectTime={},jingdongCollectTime={}",idCard,mobileCollectTime,jingdongCollectTime);
        return "{\"data\":{\"mobile\":true,\"jingdong\":true},\"code\":0,\"message\":\"\"}";
    }

    @RequestMapping("receipt.do")
    @ResponseBody
    public String receipt() {
        return "{\"success\":true,\"message\":\"生成token成功\",\"data\":{\"token\":\"4666e064864744c89f5c982222e0a5fc\",\"cell_phone_num\":\"13717706442\",\"datasource\":{\"id\":\"ce197d36b9734a65aaf6277aaf331ad7\",\"website\":\"chinamobilebj\",\"name\":\"北京移动\",\"category\":\"mobile\",\"category_name\":\"移动运营商\",\"create_time\":{\"year\":2014,\"month\":6,\"dayOfMonth\":7,\"hourOfDay\":10,\"minute\":49,\"second\":14},\"update_time\":{\"year\":2016,\"month\":5,\"dayOfMonth\":18,\"hourOfDay\":4,\"minute\":6,\"second\":10},\"offline_times\":0,\"status\":1,\"website_code\":16,\"reset_pwd_method\":0,\"sms_required\":2,\"required_captcha_user_identified\":0}},\"code\":65557}";
    }

    @RequestMapping("collect.do")
    @ResponseBody
    public String collect() {
        try {
            Thread.sleep(60000L);
        } catch (InterruptedException e) {
            LOG.error("", e);
        }
        return "{\"success\":true,\"data\":{\"type\":\"CONTROL\",\"content\":\"开始采集行为数据\",\"process_code\":10008,\"finish\":true}}";
    }

    @RequestMapping("face.do")
    @ResponseBody
    public String face(String api_key, String api_secret, String comparison_type,
                       String face_image_type, String idcard_name, String idcard_number,
                       @RequestParam MultipartFile[] image_ref, String delta,
                       @RequestParam MultipartFile image_best, @RequestParam MultipartFile image_env,
                       @RequestParam MultipartFile[] image_action) {
        LOG.info("api_key={},api_secret={},comparison_type={},face_image_type={}," +
                "idcard_name={},idcard_number={},image_ref={},deldata={},image_best={}" +
                "image_env={},image_action={}",
                api_key, api_secret, comparison_type, face_image_type, idcard_name, idcard_number,
                image_ref.length, delta, image_best.getSize(), image_env.getSize(), image_action.length);
        try {
            int i = 0;
            for (MultipartFile file:image_ref) {
                file.transferTo(new File(PATH + "IMAGE_REF" + (++i) + ".jpg"));
            }
            i = 0;
            for (MultipartFile file:image_action) {
                file.transferTo(new File(PATH + "IMAGE_ACTION" + (++i) + ".jpg"));
            }
            image_best.transferTo(new File(PATH + "IMAGE_REF.jpg"));
            image_env.transferTo(new File(PATH + "IMAGE_ENV.jpg"));
            return "ok";
        } catch (IOException e) {
            LOG.error("",e);
            return e.getMessage();
        }
    }
}
