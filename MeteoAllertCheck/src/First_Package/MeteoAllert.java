package First_Package;
import java.io.IOException;
/**
 * 
 * @author Giovanni Emanuele Longo
 *
 */
//Facade for manage a Framework
public class MeteoAllert {
	private Intermediator meteoAllert;
	/**
	 * Constructor
	 * @throws IOException
	 */
	public MeteoAllert() throws IOException { meteoAllert=new Intermediator();}
	/**
	 * 
	 * @param region
	 * @param city
	 * @return value meteo_allert
	 * @throws IOException
	 */
	public int searchAllertInCity(String region, String city) throws IOException {return meteoAllert.MeteoAllert(region, city);}
}
