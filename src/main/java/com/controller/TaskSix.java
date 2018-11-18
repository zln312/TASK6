package com.controller;

import com.model.Excellent;
import com.service.ExcellentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskSix {
    @Autowired
    private ExcellentService excellentService;

    private Logger logger = Logger.getLogger(TaskSix.class);

    @RequestMapping(value = "/excellent/{id}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable(value = "id") long id, ModelAndView modelAndView) {
        logger.info(id);
        String viewName;
        long code;
        if (id < 0) {
            viewName = "noData";
            code = -210;     //参数不正确
        } else {
            Excellent excellent = excellentService.showOne(id);
            if (null == excellent) {
                viewName = "noData";
                code = -220;       //数据不存在
            } else {
                viewName = "task6";
                code = 200;
                modelAndView.addObject("student", excellent);
            }
        }
        modelAndView.setViewName(viewName);
        modelAndView.addObject("code", code);
        return modelAndView;
    }


    @RequestMapping(value = "/excellent", method = RequestMethod.POST)

    public ModelAndView add(Excellent excellent, ModelAndView modelAndView) {
        logger.info("学员姓名：" + excellent.getName());

        if (excellentService.add(excellent)) {
            modelAndView.addObject("code", 200);

        } else {
            modelAndView.addObject("code", -230);  //添加数据失败
        }
        modelAndView.setViewName("noData");
        return modelAndView;
    }

    @RequestMapping(value = "/excellent", method = RequestMethod.PUT)
    public ModelAndView update(Excellent excellent, ModelAndView modelAndView) {
        logger.info("修改的信息" + excellent);
        long code;
        if (excellentService.update(excellent)) {
            code = 200;
        } else {
            code = -240;     //修改数据失败
        }
        modelAndView.addObject("code", code);
        modelAndView.setViewName("noData");
        return modelAndView;
    }

    @RequestMapping(value = "/excellent", method = RequestMethod.DELETE)
    public ModelAndView delete(long id, ModelAndView modelAndView) {
        logger.info("删除的id:" + id);
        long code;
        if (id < 0) {
            code = -210;
        } else {
            if (excellentService.delete(id)) {
                code = 200;
            } else {
                code = -250;      //删除数据失败
            }
        }
        modelAndView.setViewName("noData");
        modelAndView.addObject("code", code);
        return modelAndView;
    }
}
