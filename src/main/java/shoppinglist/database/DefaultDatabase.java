package shoppinglist.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import shoppinglist.domain.Product;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Optional;

@Component
@Profile({"local", "dev"})
public class DefaultDatabase implements Database {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    DefaultDatabase(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Long insert(Product product) {
        String query = "insert into tasks (name, description) values (" +
                "?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return Optional.empty();
    }

    @Override
    public Product findProductById(Long id) {
        return null;
    }
}
