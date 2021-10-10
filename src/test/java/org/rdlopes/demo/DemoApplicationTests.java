package org.rdlopes.demo;

import org.junit.jupiter.api.Test;
import org.rdlopes.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private DemoApplication application;

    @Test
    void contextLoads() {
        assertThat(application).isNotNull();
    }

}
