package br.com.rodrigo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import br.com.rodrigo.config.FileStorageConfig;
import br.com.rodrigo.exception.FileStorageException;
import br.com.rodrigo.exception.MyFileNotFoundException;

@Service
public class FileStorageService {

	private final Path fileStorageLocation;

	@Autowired
	public FileStorageService(FileStorageConfig fileStorageConfig) {
		this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception e) {
			throw new FileStorageException("Could not create the directory", e);
		}
	}

	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("Filename contains inavlid name");
			}

			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

			return fileName;
		} catch (Exception e) {
			throw new FileStorageException("Could not store file", e);
		}
	}
	
	//Download
	public Resource loadFileAsREsource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists()) {
				return resource;
			}else {
				throw new MyFileNotFoundException("File not found");
			}
		} catch (Exception e) {
			throw new MyFileNotFoundException("File not found", e);
		}
	}

}
