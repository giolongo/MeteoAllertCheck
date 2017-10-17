package First_Package;
import java.io.*;

public class ProvaMain {
	public static void main(String[] args) throws IOException {
		//Insert here the path of file contenet a list of region
		MeteoAllert prova=new MeteoAllert();
		//Insert here the path of files contenet the city of region
		System.out.println(prova.searchAllertInCity("Sicilia", "Catania"));
	}
}
