package com.fuzzychin.blog.controller;

import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.Tag;
import com.fuzzychin.blog.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/tag")
public class TagController {

    static private Logger logger = LoggerFactory.getLogger(TagController.class);

    @Autowired
    public TagService tagService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> queryTag(){
        return ResponseEntity.ok(tagService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createTag(@RequestBody Tag tag){
        return ResponseEntity.ok(tagService.save(tag));
    }

    @RequestMapping(path = "/{tagId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTag(@PathVariable("tagId") Long tagId, @RequestBody Tag updatedTag){
        Tag tag = tagService.findOneTag(tagId);

        if(tag != null){
            if (!tag.getDescriptor().equals(updatedTag.getDescriptor())) {
                tag.setDescriptor(updatedTag.getDescriptor());
            }
            if (!tag.getContent().equals(updatedTag.getContent())) {
                tag.setContent(updatedTag.getContent());
            }
            tagService.save(tag);
            return ResponseEntity.ok(tag);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(path = "/{tagId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTag(@PathVariable("tagId") Long tagId){
        Tag tag = tagService.findOneTag(tagId);

        if (tag != null){
            tagService.deleteTag(tag);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}