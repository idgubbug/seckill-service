package com.andy.seckill.controller;

import com.andy.seckill.common.Result;
import com.andy.seckill.service.UserService;
import com.andy.seckill.vo.LoginVO;
import com.andy.seckill.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *
 * @author leone
 * @since 2018-10-26
 **/
@Slf4j
@Controller
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public Result<UserVO> user(Model model, UserVO vo) {
        return Result.success(vo);
    }

    @GetMapping("/login.do")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }


    @ResponseBody
    @GetMapping("/login")
    public Result login(@RequestBody LoginVO loginVO) {
        return userService.login(loginVO);
    }

    @GetMapping("/verifyCode/{signal}")
    public void verifyCode(@PathVariable("signal") String signal, HttpServletResponse response) {
        log.info("signal: {}", signal);
        userService.verifyCode(signal, response);
    }

}
