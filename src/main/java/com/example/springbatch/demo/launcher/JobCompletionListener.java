package com.example.springbatch.demo.launcher;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobCompletionListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("I am before job");
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("I am after job");
		
	}

	
	
	
}
