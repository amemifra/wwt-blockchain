package com.worlwidetech.blockchain.controller;

import java.util.List;

import com.worlwidetech.blockchain.beans.Block;
import com.worlwidetech.blockchain.service.BlockchainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class NodeController {

    @Autowired
    BlockchainService blockchainService;

    @GetMapping("blocks")
    public List<Block> getMethodName() {
        return blockchainService.getBlockchain();
    }
    


}