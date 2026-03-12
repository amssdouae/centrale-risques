package com.creditagricole.risques.batch.reader;

import com.creditagricole.risques.entity.Credit;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.OraclePagingQueryProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class CreditItemReader {

    @Bean
    public JdbcPagingItemReader<Credit> creditReader(DataSource dataSource) {

        JdbcPagingItemReader<Credit> reader = new JdbcPagingItemReader<>();

        reader.setDataSource(dataSource);
        reader.setPageSize(10);

        OraclePagingQueryProvider queryProvider = new OraclePagingQueryProvider();

        queryProvider.setSelectClause("SELECT ID, MONTANT, TYPE_CREDIT, STATUT, CLIENT_ID");
        queryProvider.setFromClause("FROM CREDIT");

        Map<String, Order> sortKeys = new HashMap<>();
        sortKeys.put("ID", Order.ASCENDING);

        queryProvider.setSortKeys(sortKeys);

        reader.setQueryProvider(queryProvider);

        reader.setRowMapper((rs, rowNum) -> {

            Credit credit = new Credit();

            credit.setId(rs.getLong("ID"));
            credit.setMontant(rs.getDouble("MONTANT"));
            credit.setTypeCredit(rs.getString("TYPE_CREDIT"));
            credit.setStatut(rs.getString("STATUT"));

            return credit;
        });

        return reader;
    }
}