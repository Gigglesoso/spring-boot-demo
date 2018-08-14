package com.dkd.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HandleController {
	
	@RequestMapping(value = "/")
	public String upload() {
		return "upload";
	}
	
	
	@RequestMapping("/upload") 
	public String singleFileUpload(@RequestParam("file") MultipartFile file, HashMap<String, Object> map) {
	    if (file.isEmpty()) {
	    	map.put("message", "文件为空，请选择文件！");
	        return "finish";
	    }
	    try {
	        // Get the file and save it somewhere
	        byte[] bytes = file.getBytes();
	        Path path = Paths.get("D:/" + file.getOriginalFilename());
	        Files.write(path, bytes);
	        map.put("message","You successfully uploaded '" + file.getOriginalFilename() + "'");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "finish";
	}
}
