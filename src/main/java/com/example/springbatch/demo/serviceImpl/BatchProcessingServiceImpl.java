package com.example.springbatch.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbatch.demo.service.BatchProcessingService;

@Service
public class BatchProcessingServiceImpl implements BatchProcessingService {
	
	@Autowired
	private BatchProcessingServiceHelper batchProcessingServiceHelper;
	
	@Override
	public Long processBatch() throws Exception {
		System.out.println("Inside service");
		return batchProcessingServiceHelper.createBatch();
	}

}
