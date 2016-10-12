package com.xiaodong.verification.controller;

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
