package com.greenmile.projeto.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/importarcsv")
public class BatchResource {

	@Autowired
	Job job;

	@Autowired
	JobLauncher jobLauncher;

	@PostMapping("/load")
	public BatchStatus load() throws JobExecutionAlreadyRunningException, JobRestartException,
	JobInstanceAlreadyCompleteException, JobParametersInvalidException {

	    Map<String, JobParameter> maps = new HashMap<>();
	    maps.put("time", new JobParameter(System.currentTimeMillis()));
	    JobParameters parameters = new JobParameters(maps);
	    JobExecution jobExecution = jobLauncher.run(job, parameters);

	    System.out.println("Job Execution " + jobExecution.getStatus());

	    System.out.println("Batch is running..");
	      while (jobExecution.isRunning()) {
	        System.out.println("...");
	        }
	    return jobExecution.getStatus();
	 }
	
}
