package com.xiaodong.verification.controller;

import com.xiaodong.verification.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lixiaodong on 16/8/25.
 */
@Controller
@RequestMapping("redis")
public class RedisController {

    private static final Logger LOG = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisService redisService;

    @ResponseBody
    @RequestMapping("addZSet.do")
    public String addZSet(String value, long score) {
        try {
            redisService.addZSet(value, score);
            return "ok";
        } catch (Exception e) {
            LOG.error("putZSet fail ,value={}", value, e);
            return e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping("removeZSet.do")
    public String removeZSet(String value) {
        try {
            redisService.removeZSet(value);
            return "ok";
        } catch (Exception e) {
            LOG.error("removeZSet fail, value={}", value, e);
            return e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping("rangeByScoreZSet.do")
    public String rangeByScoreZSet(long score) {
        try {
            return redisService.rangeByScoreZSet(score).toString();
        } catch (Exception e ) {
            LOG.error("rangeByScoreZSet fail ", e);
            return e.getMessage();
        }
    }
}
