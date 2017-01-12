package pl.primesystems.clientsystem.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.context.annotation.Bean;

public class TableNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Bean
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return new Identifier("PS_"+name.getText(), name.isQuoted());
    }
}
