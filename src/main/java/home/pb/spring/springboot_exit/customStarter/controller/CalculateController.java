package home.pb.spring.springboot_exit.customStarter.controller;

import home.pb.spring.calculatespringbootstarter.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @GetMapping("/add")
    public double add(double a, double b) {
        return calculateService.add(a,b);
    }
    @GetMapping("/sub")
    public double sub(double a, double b) {
        return calculateService.sub(a,b);
    }
    @GetMapping("/mul")
    public double mul(double a, double b) {
        return calculateService.mul(a,b);
    }
    @GetMapping("/div")
    public double div(double a, double b) {
        return calculateService.div(a,b);
    }
    @GetMapping("/setScale2")
    public double setScale(double a, int scale) {
        //四舍五入
        return calculateService.setScale(a,scale);
    }

    @GetMapping("/setScale")
    public double setScale(double a) {
        //四舍五入
        return calculateService.setScale(a);
    }

}
