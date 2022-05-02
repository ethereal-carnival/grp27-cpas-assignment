package com.bitswilp.cpad.dataimporter.api;

import com.bitswilp.cpad.dataimporter.services.DataUpdaterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @PostMapping("/upload-statistics")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

//         validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {
            dataUpdaterService.updateStatistics(file);
            model.addAttribute("status", dataUpdaterService.updateStatistics(file));
        }

        return "result";
    }

    @PostMapping("/upload-beds-data")
    public String uploadBedsData(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            model.addAttribute("status", dataUpdaterService.updateBedsData(file));
        }

        return "result";
    }

    @PostMapping("/upload-hospitals")
    public String uploadHospitals(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            model.addAttribute("status", dataUpdaterService.updateHospitals(file));
        }

        return "result";
    }
}
