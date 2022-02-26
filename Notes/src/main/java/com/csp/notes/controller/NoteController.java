package com.csp.notes.controller;

import com.csp.notes.entity.Note;
import com.csp.notes.service.NoteService;
import org.springframework.web.bind.annotation.*;

/**
 * @author csp
 * @date 2022/2/22 16:30
 * @description
 */
@RestController
public class NoteController {

    private final NoteService noteService;

    NoteController(NoteService noteService){

        this.noteService = noteService;
    }


    @RequestMapping(value = "/{label}",method = RequestMethod.POST)
    public void redirect(@PathVariable(value = "label") String label,@RequestParam String content){
        noteService.createNote(content,label);
    }

    /**
     * 接收application/x-www-form-urlencoded和multipart/form-data格式的参数，可不用@RequestParam
     * 前端axios需要用qs.stringify处理一下
     * @param content 内容
     */
    @PostMapping("/createNote")
    public void CreateNote(@RequestParam String content,@RequestParam String label){
        noteService.createNote(content,label);

    }

    /**
     * 接受application/json格式参数，要用@RequestBody
     * @param note 封装的对象
     */
    @PostMapping("/createNote2")
    public void CreateNote(@RequestBody Note note){
        noteService.createNote(note.getContent(),note.getLabel());

    }
}
