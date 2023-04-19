package co.istad.thymeleaf.webapp.service;

import co.istad.thymeleaf.webapp.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUpload uploadSingle(MultipartFile file);
}
