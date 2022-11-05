package com.example.springbatch.demo.processor;

import org.springframework.batch.item.ItemProcessor;

public class Batchprocessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("I am process");
		return null;
	}

	
}
