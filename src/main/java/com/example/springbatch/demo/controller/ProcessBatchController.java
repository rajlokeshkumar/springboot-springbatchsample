package com.example.springbatch.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbatch.demo.service.BatchProcessingService;

@RestController
public class ProcessBatchController {

	
	@Autowired
	private BatchProcessingService batchProcessingService;
	
	
	@GetMapping(path = "/processBatch")
	@ResponseBody
	public String processBatch() throws Exception {
		 Long batchId=batchProcessingService.processBatch();
		return  batchId.toString();
	}
	
}
