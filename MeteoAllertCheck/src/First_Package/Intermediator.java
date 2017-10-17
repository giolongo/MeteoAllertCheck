package First_Package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 
 * @author Giovanni Emanuele Longo
 *
 */
public class Intermediator {
	private Region italy[];
	private int number_of_region;
	private String path_region_list;
	private String path_to_region_txt;
	private String path_image;
	/**
	 * constructor
	 * @param path_of_file
	 * @throws IOException
	 */
	public Intermediator () throws IOException {
		FileReader path_to_charge;
		//conf.txt contenets all information for path position and the number of region, this is the file to change for modify all
		path_to_charge=new FileReader("conf.txt");
		BufferedReader buffer_for_read;
		buffer_for_read=new BufferedReader(path_to_charge);
		//Path for region list
		path_region_list=buffer_for_read.readLine();
		//Path contenet list of regions, tehere are one txt file for region
		path_to_region_txt=buffer_for_read.readLine();
		//Number of region
		number_of_region=Integer.parseInt(buffer_for_read.readLine());
		//Path of image to analize
		path_image=buffer_for_read.readLine();
		path_to_charge=new FileReader(path_region_list);
		buffer_for_read=new BufferedReader(path_to_charge);
		italy=new Region[number_of_region];		
		for(int i=0;i<number_of_region;i++) {
			italy[i]=new Region();
			italy[i].setName(buffer_for_read.readLine());
		}
		buffer_for_read.close();
		divideInformationsForCityinAList(path_to_region_txt);	
	}
	//public void printListName() {for(int i=0;i<number_of_region;i++) System.out.println(italy[i].getName());}
	/**
	 * 
	 * @param part_path_of_file
	 * @throws IOException
	 */
	public void divideInformationsForCityinAList(String part_path_of_file) throws IOException {
		//Create path's final
		FileReader file_for_name_of_city;
		BufferedReader buffer_for_read;
		for(int i=0;i<number_of_region;i++){
			String final_path;
			final_path=part_path_of_file+italy[i].getName()+".txt";
			//Open and read file
			file_for_name_of_city=new FileReader(final_path);
			buffer_for_read=new BufferedReader(file_for_name_of_city);
			String tmp=buffer_for_read.readLine();
			while(tmp!=null) {
				//Split a file string, because in this there are more informations
				String[] str = tmp.split(" ");
				City new_city=new City(Integer.parseInt(str[0]),Integer.parseInt(str[1]),null,str[2],Integer.parseInt(str[3]),Integer.parseInt(str[4]));
				italy[i].insert(new_city);
				tmp=buffer_for_read.readLine();
			}
			buffer_for_read.close();
		}
	}
	/**
	 * 
	 * @param region
	 * @param city
	 * @param path
	 * @return value meteo_allert
	 * @throws IOException
	 */
	int MeteoAllert(String region, String city) throws IOException {
		City city_to_allert;
		int i=0;
		int indicator_of_array=-1;
		while(i<number_of_region){
			String tmp=italy[i].getName();
			if(tmp.equals(region))indicator_of_array=i;
			i++;}
		if(indicator_of_array!=-1){
			city_to_allert=italy[indicator_of_array].search(city);
			city_to_allert.fillMatrix(path_image);
			return city_to_allert.meteoAllert();
		}
		else return -1;
	}	
	//Se le mappe cambiano da regione in regione è necessario inserire una procedura che riesca a comprendere a quale regione appartiene la cartina passata
}
