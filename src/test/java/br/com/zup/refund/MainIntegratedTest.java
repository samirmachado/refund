package br.com.zup.refund;

import static org.junit.Assert.assertFalse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RefundApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class MainIntegratedTest {
    
    @Autowired
    protected ObjectMapper mapper; 

    // @Value("open.database.manager")
    private static Boolean openDatabaseManager = false;
    
    // @Value("spring.datasource.url")
    private static String datasourceUrl = "jdbc:hsqldb:mem:test";

    // @Value("spring.datasource.username")
    private static String datasourceUsername = "username";

    // @Value("spring.datasource.password")
    private static String datasourcePassword = "password";

    @Autowired
    protected MockMvc mockMvc;
    
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @BeforeClass
    public static void beforeAll() {
        if(openDatabaseManager) {
            DatabaseManagerSwing.main(new String[] { "--url", datasourceUrl, "--user", datasourceUsername
                    , "--password", datasourcePassword, "--noexit" });
        }
    }
    
        public EntityManager getEntityManager() { 
            return Persistence.createEntityManagerFactory("PU").
                    createEntityManager(); 
        };


    public void clearDatabase() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery("TRUNCATE SCHEMA PUBLIC RESTART IDENTITY AND COMMIT NO CHECK").executeUpdate();
    }
    
    @Test
    public void shouldNotShowDatabaseManagerTest() throws Exception {
        assertFalse(openDatabaseManager);
    }
}
