import io.swagger.model.SoolutionRepository;
import io.swagger.model.Soolution;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@EntityScan(basePackages = { "io.swagger" })
@EnableJpaRepositories(basePackages = "io.swagger")
@ContextConfiguration(
        classes = { SoolvedJpaConfig.class },
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class BancoEmMemoriaTest {


    @Resource
    SoolutionRepository soolutionRepository;

    @Test
    public void testeBancoEmMemoriaJpa() {
        //Levei 8 horas pra resolver um bug e implementar isso, nao conhecia SpringBoot kkkkk :)
        Soolution newSolutionTest = new Soolution();
        String testID = "-999999";
        newSolutionTest.setId(testID);
        newSolutionTest.setDescription("Falha ao realizar teste unitario com banco em memoria");
        newSolutionTest.setCausa("Alterada a senha do banco de dados e não foi modificado os arquivos de config");
        newSolutionTest.setSolution("Efetuada a correção da versao 3.06.1771");
        newSolutionTest.setStatus("Fixed");
        soolutionRepository.save(newSolutionTest);

        Soolution databaseSolution = soolutionRepository.findOne(testID);
        assertThat(databaseSolution.getDescription()).isEqualTo(newSolutionTest.getDescription());

    }


}
