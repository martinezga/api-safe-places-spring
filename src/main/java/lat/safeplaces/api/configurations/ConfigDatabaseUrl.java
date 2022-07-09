package lat.safeplaces.api.configurations;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("postgresUrl")
public class ConfigDatabaseUrl {
    @Value("${spring.datasource.url}")
    private String dbUri;

    private static final Logger logger = LoggerFactory.getLogger(ConfigDatabaseUrl.class);

    @Bean
    public DataSource dataSource() {
        System.out.println("--- " + dbUri);
        HikariConfig config = new HikariConfig();
        String[] dbUrl1 = dbUri.split("@");
        String dbUrl = "jdbc:postgresql://" + dbUrl1[1];
        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUrl1[0].split(":")[1].replace("//", ""));
        config.setPassword(dbUrl1[0].split(":")[2]);
        System.out.println("--- " + config);
        return new HikariDataSource(config);
    }
}