package First_Package;

import java.io.IOException;

/*
 * I think a region as a list.
 * A element of list is a city of region.
 */
/**
 * 
 * @author Giovanni Emanuele Longo
 *
 */
public class Region {
	private City head_of_region;
	private String name;
	//Constructor
	/**
	 * Constructor
	 */
	public Region() {
		head_of_region=null;
		name="";
		}
	/**
	 * 
	 * @param head_of_region
	 * @param name
	 */
	public Region(City head_of_region, String name) {
		this.head_of_region=head_of_region;
		this.name=name;
		}
	//Set-Get
	/**
	 * 
	 * @param head_of_region
	 */
	public void setHead(City head_of_region) {this.head_of_region=head_of_region;}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {this.name=name;}
	/**
	 * 
	 * @return head of list
	 */
	public City getHead() {return head_of_region;}
	/**
	 * 
	 * @return name
	 */
	public String getName() {return name;}
	//Insert
	/**
	 * 
	 * @param new_city
	 */
	public void insert(City new_city) {
		if(head_of_region!=null) {new_city.setSuccessiveCityOfList(head_of_region);}
		head_of_region=new_city;
	}
	//Search
	/**
	 * 
	 * @param name
	 * @return pointer to city type
	 */
	public City search(String name) {
		if(head_of_region!=null) {
			City temp=head_of_region;
			while(temp.getSuccessiveCityOfList()!=null)
			{
				if(temp.getName().equals(name))	return temp;
				else temp=temp.getSuccessiveCityOfList();
			}
			if(temp.getName().equals(name))	return temp;
		}
		return null;
	}
	/**
	 * 
	 * @param path_image
	 * @throws IOException
	 */
	public void fillMatrixRegion(String path_image) throws IOException{
		City tmp=head_of_region;
		//This is the correct position for insert map path
		while(tmp!=null) { 
			tmp.fillMatrix(path_image);
			tmp=tmp.getSuccessiveCityOfList();
		}
	}
	/*
	public void printMatrixRegion() throws IOException{
		City tmp=head_of_region;
		//This is the correct position for insert map path
		while(tmp!=null) { 
			tmp.printMatrix();
			tmp=tmp.getSuccessiveCityOfList();
		}
	}*/
}