package com.worlwidetech.blockchain;

import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;

import com.worlwidetech.blockchain.service.EncryptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlockchainApplication {

	@Autowired
	EncryptService encryptService;

	public static void main(String[] args) {
		SpringApplication.run(BlockchainApplication.class, args);
	}

	@PostConstruct
	public void onInit() throws NoSuchAlgorithmException {
		encryptService.setUpEncryption();
	}
}
