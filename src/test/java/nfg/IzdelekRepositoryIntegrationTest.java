package nfg;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;

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
	
	@Test
	public void testFindByImeLike() {
		List<Izdelek> izdelki = izdelekRepository.findByImeLike("Mleko");
		assertNotNull(izdelki);
		assertThat(izdelki.get(0).getIme(), is("Mleko"));
	}
	
	@Test
	public void testGetIzdelkiByPriceRange() {
		List<Izdelek> izdelki = izdelekRepository.findByCenaGreaterThanEqualAndCenaLessThanEqual(2, 3);
		assertNotNull(izdelki);
		assertThat(izdelki.get(0).getIme(), is("Mleko"));
	}
	
	@Test
	public void testGetIzdelkiStartingWith() {
		List<Izdelek> izdelki = izdelekRepository.findBySifraStartingWith("MLE");
		assertNotNull(izdelki);
		assertThat(izdelki.get(0).getIme(), is("Mleko"));
	}
	
	@Test
	public void queryByName() {
		List<Izdelek> izdelki = izdelekRepository.queryByName("Marmelada");
		assertNotNull(izdelki);
		assertThat(izdelki.get(0).getIme(), is("Marmelada"));
	}
}
