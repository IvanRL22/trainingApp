package com.apps.ivanrl.trainingApp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(
    properties = "spring.jpa.hibernate.ddl-auto=validate"
)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SchemaValidationTest {

    @Test
    @Disabled // Disabled while using in-mem DB
    public void testSchemaValidity() {
    }

}
   