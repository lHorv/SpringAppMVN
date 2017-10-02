package nfg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import nfg.controller.IzdelekController;
import nfg.model.Izdelek;
import nfg.repository.IzdelekRepository;

public class IzdelekControllerTest {
	
	@InjectMocks
	private IzdelekController ic;
	
	@Mock
	private IzdelekRepository izdelekRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testIzdelekGet() {
		Izdelek izdelek = new Izdelek();
		izdelek.setId(1L);
		
		when(izdelekRepository.findOne(1L)).thenReturn(izdelek);
		
		Izdelek i = ic.get(1L);
		
		verify(izdelekRepository).findOne(1L);
		
		//assertEquals(1L, i.getId().longValue());
		assertThat(i.getId(), is(1L));
	}
	
	@Test
	public void testIzdelekCreate() {
		Izdelek izdelek = new Izdelek();
		izdelek.setId(2L);
		
		when(izdelekRepository.saveAndFlush(izdelek)).thenReturn(izdelek);
		when(izdelekRepository.findOne(2L)).thenReturn(izdelek);
		
		ic.create(izdelek);
		Izdelek i = ic.get(2L);
		
		verify(izdelekRepository).saveAndFlush(izdelek);
		
		assertEquals(i.getId().longValue(), izdelek.getId().longValue());
	}
	
	@Test
	public void testIzdelekUpdate() {
		Izdelek newIzdelek = new Izdelek();
		newIzdelek.setId(3L);
		newIzdelek.setIme("Marmelada");
		
		when(izdelekRepository.saveAndFlush(newIzdelek)).thenReturn(newIzdelek);
		when(izdelekRepository.findOne(3L)).thenReturn(newIzdelek);
		
		ic.create(newIzdelek);
		
		Izdelek i = new Izdelek();
		i.setId(4L);
		i.setIme("Cokolada");
		ic.update(3L, i);
		
		Izdelek updatedIzdelek = new Izdelek();
		updatedIzdelek = ic.get(3L);
		
		verify(izdelekRepository, times(2)).saveAndFlush(newIzdelek);
		verify(izdelekRepository, times(2)).findOne(3L);
		
		assertEquals("Cokolada", updatedIzdelek.getIme());
	}
	
	@Test
	@Ignore
	public void testIzdelekDelete() {
		Izdelek izdelek = new Izdelek();
		izdelek.setId(4L);
		
		when(izdelekRepository.saveAndFlush(izdelek)).thenReturn(izdelek);
		when(izdelekRepository.findOne(4L)).thenReturn(izdelek);
		
		ic.create(izdelek);
		
		Izdelek i = ic.get(4L);
		assertNotNull(i);
		
		ic.delete(4L);
		Izdelek i2 = ic.get(4L);
		
		verify(izdelekRepository).saveAndFlush(izdelek);
		verify(izdelekRepository).delete(izdelek);
		verify(izdelekRepository, times(3)).findOne(4L);
		
		assertNull(i2);
	}
}
