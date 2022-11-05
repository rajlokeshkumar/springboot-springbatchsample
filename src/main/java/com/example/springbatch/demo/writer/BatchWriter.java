package com.example.springbatch.demo.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class BatchWriter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("I am writer");
		
	}

}
