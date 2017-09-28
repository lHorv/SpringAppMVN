package nfg;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import nfg.model.Izdelek;
import nfg.repository.IzdelekRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringProjektMvnApplication.class)
public class IzdelekRepositoryIntegrationTest {
	
	@Autowired
	private IzdelekRepository izdelekRepository;
	
	@Test
	public void testFindAll() {
		List<Izdelek> izdelki = izdelekRepository.findAll();
		assertThat(izdelki.size(), is(greaterThanOrEqualTo(0)));
	}
}
