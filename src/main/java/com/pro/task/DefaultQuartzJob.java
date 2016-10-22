package com.pro.task;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class DefaultQuartzJob implements Job {
	private static Logger logger = Logger.getLogger(DefaultQuartzJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("Job：" + System.currentTimeMillis());
	}

}
