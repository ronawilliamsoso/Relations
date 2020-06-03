package com.example.relations.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * @author Wei
 * @date 04.04.20
 */

@RestController
@RequiredArgsConstructor
public class UploadFileController {


    @PostMapping(value = "/uploadFile/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadDrawResultsFile(@RequestParam MultipartFile multipartFile) throws IOException {

        String fullFilePath = "/Users/Wei/code" + File.separator + multipartFile.getOriginalFilename();
        File file = determineFileLocationForExport(fullFilePath, multipartFile.getOriginalFilename());
        Files.copy(multipartFile.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("oooooo");

    }

    public File determineFileLocationForExport(String fullFilePath, String fileName) throws IOException {

        File file = new File(fullFilePath);
        if (file.exists()) {
            file.deleteOnExit();
            System.out.println("Removed existing file: ===> " + fullFilePath);
        }
        return new File(fullFilePath);

    }


}
