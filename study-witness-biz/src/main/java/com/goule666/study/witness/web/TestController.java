package com.goule666.study.witness.web;

import com.goule666.study.witness.entity.GlUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wlnie
 * @date 2018/12/26 17:32
 * @description
 **/
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return null;
    }
}
