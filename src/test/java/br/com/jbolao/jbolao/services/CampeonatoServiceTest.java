package br.com.jbolao.jbolao.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.jbolao.jbolao.models.Campeonato;
import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class CampeonatoServiceTest {

	@Test
	public void testSaveInsert() {
		Campeonato campeonato = new Campeonato();
		Assert.assertTrue(campeonato.getId() > 0);
	}
	
}
