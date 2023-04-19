package co.istad.thymeleaf.webapp.service.impl;

import co.istad.thymeleaf.webapp.model.FileUpload;
import co.istad.thymeleaf.webapp.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${file.server-path}")
    private String fileServerPath;

    @Override
    public FileUpload uploadSingle(MultipartFile file) {
        int dotLastIndex = file.getOriginalFilename().lastIndexOf(".");
        String ext = file.getOriginalFilename().substring(dotLastIndex + 1);
        String uuid = UUID.randomUUID().toString();
        String newFileNew = String.format("%s%s%s", uuid, ".", ext);

        // 1. Create file path object
        Path paths = Paths.get(fileServerPath + newFileNew);
        try {
            // 2. Copy file with path object
            Files.copy(file.getInputStream(), paths);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new FileUpload(newFileNew, true);
    }
}
