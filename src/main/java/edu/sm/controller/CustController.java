package edu.sm.controller;

import edu.sm.app.dto.CustDto;
import edu.sm.app.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {

    final CustService custService;

    String dir = "cust/";

    @RequestMapping("/get")
    public String get(Model model) {
        List<CustDto> list = custService.getAll();
        model.addAttribute("custs", list);
        model.addAttribute("center", dir + "get");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("center", dir + "add");
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") String id) {
        CustDto custDto = custService.get(id);
        model.addAttribute("cust", custDto);
        model.addAttribute("center", dir + "detail");
        return "index";
    }

    @RequestMapping("/update")
    public String update(Model model, CustDto custDto) {
        custService.modify(custDto);
        return "redirect:/cust/detail?id=" + custDto.getId();
    }

    @RequestMapping("/addimpl")
    public String addimpl(Model model, CustDto custDto) {
        CustDto saved = custService.add(custDto);
        return "redirect:/cust/detail?id=" + saved.getId();
    }

    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam("id") String id) {
        custService.delete(id);
        return "redirect:/cust/get";
    }
}
