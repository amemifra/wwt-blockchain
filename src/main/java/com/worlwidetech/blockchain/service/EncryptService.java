package com.worlwidetech.blockchain.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.worlwidetech.blockchain.beans.Block;

import org.springframework.stereotype.Service;

@Service
public class EncryptService {

    public void setUpEncryption() throws NoSuchAlgorithmException {
        String originalString = "WHAAAA";
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        System.out.println("Encode >>");
        System.out.println(encodedhash.toString());
        System.out.println("<< Encode ");
    }

    public byte[] calculateHash(Integer index, String previousHash, Long timestamp, Object data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        StringBuilder sb = new StringBuilder(index.toString())
                            .append(previousHash)
                            .append(timestamp.toString())
                            .append(data.toString());

        return digest.digest(sb.toString().getBytes(StandardCharsets.UTF_8));
    }

    public byte[] calculateHash(Block block) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        StringBuilder sb = new StringBuilder(block.getIndex().toString())
                            .append(block.getPreviousHash())
                            .append(block.getTimestemp().toString())
                            .append(block.getData().toString());

        return digest.digest(sb.toString().getBytes(StandardCharsets.UTF_8));
    }

}