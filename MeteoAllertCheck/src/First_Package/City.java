package First_Package;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*For this problem, I need a coordinates x,y. This coordinates are important for identify the city on the map/image.
 * I need the number of columns and rows. This two numbers is important and it changes according to the city.
 Then, is necessary to create a matrix [row,columns], for import the pixel in this matrix.
 */
/**
 * 
 * @author Giovanni Emanuele Longo
 *
 */
public class City {
	private int x;
	private int y;
	private int r[][];
	private int g[][];
	private int b[][];
	private String name;
	private City successive_city_of_list;
	private int row;
	private int columns;
	//Constructor
	/**
	 * Constructor
	 */
	public City(){
		x=y=row=columns=0;
		successive_city_of_list=null;
		name=null;
		r=null;
	}
	/**
	 * 
	 * @param x_coordinate
	 * @param y_coordinate
	 * @param next_city
	 * @param name
	 * @param row
	 * @param columns
	 */
	public City(int x,int y, City city_of_list, String name,int row,int columns) {
		this.x=x;
		this.y=y;
		this.successive_city_of_list=city_of_list;
		this.name=name;
		this.row=row;
		this.columns=columns;
		r=new int[row][columns];
		g=new int[row][columns];
		b=new int[row][columns];
	}
	//Set Function
	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {this.x=x;}
	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {this.y=y;}
	/**
	 * 
	 * @param row
	 */
	public void setRow(int row) {this.row=row;}
	/**
	 * 
	 * @param columns
	 */
	public void setColumns(int columns) {this.columns=columns;}
	/**
	 * 
	 * @param city_of_list
	 */
	public void setSuccessiveCityOfList(City city_of_list) {this.successive_city_of_list=city_of_list;}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {this.name=name;}
	/**
	 * Initialize r,g,b matrix
	 */
	public void setMatrix() {
		r=new int[row][columns];
		g=new int[row][columns];
		b=new int[row][columns];
	}
	/**
	 * 
	 * @return name
	 */
	String getName() {return name;}
	//Get Function 
	//Get Matrix information
	/**
	 * 
	 * @return x_coordinate
	 */
	public int getX() {return x;}
	/**
	 * 
	 * @return y_coordinate
	 */
	public int getY() {return y;}
	/**
	 * 
	 * @return row_number
	 */
	public int getRow() {return row;}
	/**
	 * 
	 * @return columns number
	 */
	public int getColumns() {return columns;}
	//Get Pixel
	/**
	 * 
	 * @param x
	 * @param y
	 * @return r[x][y] pixel value
	 */
	public int getRPixel(int x,int y) {return r[x][y];}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return g[x][y] pixel value
	 */
	public int getGPixel(int x,int y) {return g[x][y];}
	/**
	 * 
	 * @param x
	 * @param y
	 * @return b[x][y] pixel value
	 */
	public int getBPixel(int x,int y) {return b[x][y];}
	//Get Successive information 
	/**
	 * 
	 * @return successive to list
	 */
	City getSuccessiveCityOfList() {return successive_city_of_list;}
	//Fill 3 Matrix with correct pixel color
	/**
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void fillMatrix(String path)throws IOException{
		File image_to_work= new File(path);
		BufferedImage image = ImageIO.read(image_to_work);
		for(int i=0;i<row;i++) {
			for(int j=0;j<columns;j++) {
				int pixel_color=  image.getRGB(x-(row/2)+i,y-(columns/2)+j); 
				r[i][j]=(pixel_color & 0x00ff0000) >> 16;
				g[i][j]=(pixel_color & 0x0000ff00) >> 8;
				b[i][j]=pixel_color & 0x000000ff;
			}
		}
	}
	/**
	 * Function to print matrix
	 */
	public void printMatrix(){
		for(int i=0;i<row;i++) {
			for(int j=0;j<columns;j++) { System.out.println(r[i][j]);}
		}
	}
	/**
	 * 
	 * @return 1-2-0-(-1)
	 */
	int meteoAllert()
	{
		int media_red=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<columns;j++) {media_red=media_red+r[i][j];}
		}
		media_red=media_red/(row*columns);
		if(media_red>100)return 2;
		else {
			int media_blu=0;
			for(int i=0;i<row;i++) {
				for(int j=0;j<columns;j++) {media_blu=media_blu+b[i][j];}
			}
			media_blu=media_blu/(row*columns);
			if(media_blu>100)return 1;
			else return 0;
		}
	}
}