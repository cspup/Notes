package com.cspup.notes.controller;

import com.cspup.notes.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author csp
 * @date 2022/2/22 20:41
 * @description
 */
@Controller
public class IndexController {

    final private NoteService noteService;

    IndexController(NoteService noteService) {
        this.noteService = noteService;
    }


    @RequestMapping(value = "/{label}", method = RequestMethod.GET)
    public String index(@PathVariable String label, ModelMap model) {
        String content = noteService.getLastContent(label);
        model.addAttribute("content", content);
        return "index";
    }

}
