package metier;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculMensualite {
    
	private ICreditMetier metier;
	@Before
	public void setUp() throws Exception {
		metier = new CreditMetierImpl();
	}
	

	@Test
	public void testCalculerMensualiteCredite() {
		double capital=200000;
		int duree =240;
		double taux =4.5;
		double resultatAttendu=1265.2987;
		double resCalcul = metier.calculerMensualiteCredite(capital, taux, duree);
		assertEquals(resultatAttendu, resCalcul,0.001);
		
	}

}
