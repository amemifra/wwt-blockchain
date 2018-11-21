package com.worlwidetech.blockchain.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.worlwidetech.blockchain.beans.Block;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockchainService {

    List<Block> blockchain = new ArrayList<>();

    @Autowired
    EncryptService encryptService;

    public boolean isValidNewBlock(Block newBlock, Block previousBlock) throws NoSuchAlgorithmException {
        if (previousBlock.getIndex() + 1 != newBlock.getIndex()) {
            System.out.println("Invalid index");
            return false;
        } else if (!previousBlock.getHash().equals(newBlock.getPreviousHash())) {
            System.out.println("Invalid hash");
            return false;
        } else if (!encryptService.calculateHash(newBlock).toString().equals(newBlock.getHash())) {
            System.out.println(
                new StringBuilder("Invalid hash calculated: ")
                .append(encryptService.calculateHash(newBlock).toString())
                .append(" >>> Is different from >>>> ")
                .append(newBlock.getHash()).toString()
            );
            return false;
        }
        return true;
    }

    public void replaceChain(List<Block> newBlocks) {

    }

    public Block genarateNextBlock(Object blockData) throws NoSuchAlgorithmException {
        Block previousBlock = getLatestBlock();
        Integer nextIndex = previousBlock.getIndex();
        Long nextTimestamp = new Date().getTime() / 1000;
        byte[] nextHash = encryptService.calculateHash(nextIndex, previousBlock.getHash(), nextTimestamp, blockData);
        return new Block(nextIndex, previousBlock.getHash(), nextTimestamp, blockData, nextHash.toString());
    }

    public Block getGenesisBlock() {
        return new Block(0, "0", new Date().getTime() / 1000, "My fucking new block", "816534932c2b7154836da6afc367695e6337db8a921823784c14378abed4f7d7");
    }

    public Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

}