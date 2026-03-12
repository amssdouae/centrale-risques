package com.creditagricole.risques.batch.config;

import com.creditagricole.risques.entity.Client;
import com.creditagricole.risques.entity.Credit;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchJobConfig {

    @Bean
    public Step clientStep(JobRepository jobRepository,
                           PlatformTransactionManager transactionManager,
                           JdbcPagingItemReader<Client> clientReader,
                           ItemProcessor<Client, Client> clientItemProcessor,
                           FlatFileItemWriter<Client> clientWriter) {

        return new StepBuilder("clientStep", jobRepository)
                .<Client, Client>chunk(10, transactionManager)
                .reader(clientReader)
                .processor(clientItemProcessor)
                .writer(clientWriter)
                .build();
    }

    @Bean
    public Step creditStep(JobRepository jobRepository,
                           PlatformTransactionManager transactionManager,
                           JdbcPagingItemReader<Credit> creditReader,
                           ItemProcessor<Credit, Credit> creditItemProcessor,
                           FlatFileItemWriter<Credit> creditWriter) {

        return new StepBuilder("creditStep", jobRepository)
                .<Credit, Credit>chunk(10, transactionManager)
                .reader(creditReader)
                .processor(creditItemProcessor)
                .writer(creditWriter)
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository,
                   Step clientStep,
                   Step creditStep) {

        return new JobBuilder("centraleRisqueJob", jobRepository)
                .start(clientStep)
                .next(creditStep)
                .build();
    }
}