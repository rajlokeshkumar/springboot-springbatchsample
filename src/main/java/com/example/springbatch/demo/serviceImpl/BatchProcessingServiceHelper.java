package com.example.springbatch.demo.serviceImpl;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatchProcessingServiceHelper {

	@Autowired
	private Job createJob;
	
	@Autowired
	private JobLauncher jobLauncher;
	
	public Long createBatch() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		JobParameters jobParameter=new JobParametersBuilder().toJobParameters();
		
		Long jobId=jobLauncher.run(createJob, jobParameter).getJobId();
		
		return jobId;
	}
	
}
