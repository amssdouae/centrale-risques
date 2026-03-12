package com.creditagricole.risques.batch.reader;

import com.creditagricole.risques.entity.Client;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.OraclePagingQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class ClientItemReader {

    @Bean
    public JdbcPagingItemReader<Client> clientReader(DataSource dataSource) {

        JdbcPagingItemReader<Client> reader = new JdbcPagingItemReader<>();

        reader.setDataSource(dataSource);
        reader.setPageSize(10);

        OraclePagingQueryProvider queryProvider = new OraclePagingQueryProvider();

        queryProvider.setSelectClause("SELECT ID, NOM, PRENOM, CIN, TYPE_CLIENT, ADRESSE");
        queryProvider.setFromClause("FROM CLIENT");

        Map<String, Order> sortKeys = new HashMap<>();
        sortKeys.put("ID", Order.ASCENDING);

        queryProvider.setSortKeys(sortKeys);

        reader.setQueryProvider(queryProvider);

        reader.setRowMapper((rs, rowNum) -> {

            Client c = new Client();
            c.setId(rs.getLong("ID"));
            c.setNom(rs.getString("NOM"));
            c.setPrenom(rs.getString("PRENOM"));
            c.setCin(rs.getString("CIN"));
            c.setTypeClient(rs.getString("TYPE_CLIENT"));
            c.setAdresse(rs.getString("ADRESSE"));

            return c;
        });

        return reader;
    }
}