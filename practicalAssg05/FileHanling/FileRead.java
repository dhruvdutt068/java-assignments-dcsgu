import java.util.*;
import java.io.*;

class FileRead{
	public static void main(String[] args){
		//BUfferedReader and FileReader 
		//--> terminal help file read
		//--> file reader help file open krva mate
		try{
			String fileName = "input.txt";
			String newLine;
			FileReader file = new FileReader(fileName);
			BufferedReader br = new BufferedReader(file);
			//BufferedReader br = new BufferedReader(new FileReader(fileName))
		
		while((newLine = br.readLine()) != null){
			System.out.println(newLine);
		}
		}catch(Exception e){System.out.println("Error: "+ e);}
		
	}
}