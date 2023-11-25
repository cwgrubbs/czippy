package com.czawlz.multimediaconverter;

import com.czawlz.multimediaconverter.service.FileStorageService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultimediaConverterApplication implements CommandLineRunner {
	@Resource
	FileStorageService storageService;

	public static void main(String[] args) {
		SpringApplication.run(MultimediaConverterApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
		//storageService.deleteAll();
		storageService.init();
	}
}
