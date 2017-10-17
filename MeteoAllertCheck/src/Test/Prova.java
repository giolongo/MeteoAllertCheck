package Test;
import First_Package.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class Prova {

	@Test
	public void test() throws IOException {
		MeteoAllert prova=new MeteoAllert();
		//assertEquals((prova.searchAllertInCity("Sicilia", "Catania")),0);
		assertEquals((prova.searchAllertInCity("Molise", "Catania")),0);
	}
}
