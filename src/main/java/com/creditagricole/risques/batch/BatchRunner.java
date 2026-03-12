package com.creditagricole.risques.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BatchRunner implements CommandLineRunner {

    private final JobLauncher jobLauncher;
    private final Job job;

    public BatchRunner(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @Override
    public void run(String... args) throws Exception {

        Thread.sleep(3000); // attendre que Spring démarre complètement

        jobLauncher.run(
                job,
                new JobParametersBuilder()
                        .addLong("time", System.currentTimeMillis())
                        .toJobParameters()
        );
    }
}