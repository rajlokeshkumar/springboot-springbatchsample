package com.example.springbatch.demo.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springbatch.demo.launcher.JobCompletionListener;
import com.example.springbatch.demo.processor.Batchprocessor;
import com.example.springbatch.demo.reader.BatchReader;
import com.example.springbatch.demo.writer.BatchWriter;

@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
	@Bean
	public Job createJob() {

		return jobBuilderFactory.get("createJob").listener(listener())
				.incrementer(new RunIdIncrementer()).flow(createStep()).end().build();
	}
	
	@Bean
	public Step createStep() {

		return stepBuilderFactory.get("createStep").<String, String>chunk(1).reader(new BatchReader())
				.processor(new Batchprocessor()).writer(new BatchWriter()).build();
	}
	
	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

}
