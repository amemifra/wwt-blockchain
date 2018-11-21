package com.worlwidetech.blockchain.beans;

public class Block {
    Integer index;
    String previousHash;
    Long timestemp;
    Object data;
    String hash;
    
    
	public Block() {
		super();
	}


	public Block(Integer index, String previousHash, Long timestemp, Object data, String hash) {
		super();
		this.index = index;
		this.previousHash = previousHash;
		this.timestemp = timestemp;
		this.data = data;
		this.hash = hash;
	}


	public Integer getIndex() {
		return index;
	}


	public void setIndex(Integer index) {
		this.index = index;
	}


	public String getPreviousHash() {
		return previousHash;
	}


	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}


	public Long getTimestemp() {
		return timestemp;
	}


	public void setTimestemp(Long timestemp) {
		this.timestemp = timestemp;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public String getHash() {
		return hash;
	}


	public void setHash(String hash) {
		this.hash = hash;
	}
	
	
    
    
}