package ai.lentra.config.hibernate;

import org.hibernate.dialect.PostgreSQL95Dialect;

import java.sql.Types;

public class ProjectPostgreSQL95Dialect extends PostgreSQL95Dialect {
    public ProjectPostgreSQL95Dialect() {
        this.registerColumnType(Types.JAVA_OBJECT, "jsonb");
    }
}
