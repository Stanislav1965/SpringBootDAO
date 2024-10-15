package ru.netology.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.netology.model.Products;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProductsRepository {

 //   private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String scriptName = read("myScript.sql");

    public ProductsRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Products> findAll(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", name);
        return namedParameterJdbcTemplate.query(
                scriptName,
                params,
                (rs, rowNum) -> {
                    String product_name = rs.getString("product_name");
                    return new Products(product_name);
                });
    }
}
