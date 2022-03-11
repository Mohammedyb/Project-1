//package com.example.Request.RepositoryTest;
//
//import com.example.Request.dao.ReimbursementRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.TestPropertySource;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // don't let spring replace postgresql with an embedded database
//@TestPropertySource(properties = {
//        "spring.datasource.url=jdbc:tc:postgresql:9.6.8:///postgres", // testcontainers will run the lasted postgresql in a docker container
//        "spring.jpa.hibernate.ddl-auto=create", // create when test start drop when test ends
//        "spring.datasource.defer-data-initialization=true",
//        "spring.jpa.show-sql=true"
//})
//
//public class ModelRepositoryTests {
//    @Autowired
//    ReimbursementRepository repository;
//
//    @BeforeEach
//    public void setup() {}
//
//
//    @Test
//    public void contextLoads() {}
//
//    @Test
//    @DataSet("models.yml")
//    public void shouldReturnAllModels() {
//        List<Model> models = modelRepository.findAll();
//        System.out.println(models);
//    }
//
//    @Test
//    @DataSet("emptySet.yml")
//    public void shouldSaveModel() {
//        Model m = new Model();
//        m.setValue("Test-Value");
//
//        modelRepository.save(m);
//        Assert.assertEquals(1, modelRepository.count());
//    }
//
//    @Test
//    @DataSet("models.yml")
//    public void shouldSearchByValue() {
//        List<Model> models = modelRepository.findAllByValue("mumbo");
//        Assert.assertEquals(1, models.size());
//    }
//
//    @Test
//    @DataSet("models.yml")
//    public void shouldSearchByValueFuzzy() {
//        List<Model> models = modelRepository.findAllByValueLike("%umbo%");
//        Assert.assertEquals(3, models.size());
//    }
//
//    @Test
//    @DataSet("models.yml")
//    public void shouldCountByValueLike() {
//        Long count = modelRepository.countAllByValueLike("%amble%");
//        Assert.assertEquals(2L, count.longValue());
//    }
//}