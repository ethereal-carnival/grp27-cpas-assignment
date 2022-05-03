package com.bitswilp.cpad.dataimporter.api;

import com.bitswilp.cpad.dataimporter.services.DataUpdaterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    private final DataUpdaterService dataUpdaterService;

    public UploadController(DataUpdaterService dataUpdaterService) {
        this.dataUpdaterService = dataUpdaterService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file) {
        dataUpdaterService.updateData(file);
        return "upload-complete";
    }
}
