package com.springboot.rest.jobs;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;

import com.springboot.rest.tasklet.FileDeletingTasklet;


@Configuration
@EnableBatchProcessing
public class ProcessMultiFilesJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private SimpleJobLauncher jobLauncher;

	@Value("file:D:\\temp\\")
	private Resource directory;

	@Bean
	public ResourcelessTransactionManager transactionManager() {
		System.out.println("ProcessMultiFilesJob.transactionManager()");
		return new ResourcelessTransactionManager();
	}

	@Bean
	public MapJobRepositoryFactoryBean mapJobRepositoryFactory(ResourcelessTransactionManager txManager)
			throws Exception {
		System.out.println("ProcessMultiFilesJob.mapJobRepositoryFactory()");

		MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean(txManager);

		factory.afterPropertiesSet();

		return factory;
	}

	@Bean
	public JobRepository jobRepository(MapJobRepositoryFactoryBean factory) throws Exception {
		System.out.println("ProcessMultiFilesJob.jobRepository()");
		return factory.getObject();
	}

//	@Scheduled(cron = "* */5 * * * *")
//	@Scheduled(cron = "* 5 */1 * * *")
	@Scheduled(cron = "* 37 */1 * * ?")
	public void perform() throws Exception {

		System.out.println("ProcessMultiFilesJob.perform()");
		System.err.println("Job Started at :" + new Date());

		JobParameters param = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis())).toJobParameters();

		JobExecution execution = jobLauncher.run(readFiles(), param);

		System.err.println("Job finished with status :" + execution.getStatus());
	}

	@Bean
	public Job readFiles() {
		System.out.println("ProcessMultiFilesJob.readFiles()");
		return jobBuilderFactory.get("readFiles").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}

	@Bean
	public Step step1() {
		System.out.println("ProcessMultiFilesJob.step1()");
		return stepBuilderFactory.get("step1").tasklet(fileDeletingTasklet()).build();
	}

	@Bean
	public FileDeletingTasklet fileDeletingTasklet() {
		System.out.println("ProcessMultiFilesJob.fileDeletingTasklet()");
		FileDeletingTasklet tasklet = new FileDeletingTasklet();
		tasklet.setDirectory(directory);
		return tasklet;
	}

	@Bean
	public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
		System.out.println("ProcessMultiFilesJob.jobLauncher()");
		SimpleJobLauncher launcher = new SimpleJobLauncher();
		launcher.setJobRepository(jobRepository);
		return launcher;
	}
}