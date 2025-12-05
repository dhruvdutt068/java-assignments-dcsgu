import java.util.*;
import java.io.*;

class FileWrite{
	public static void main(String[] args){
		try{
			String fileName = "output.txt";
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			String text ="Write this content in my file output.txt";
			
			bw.write(text);
			bw.newLine();
			
			bw.close();
		}catch(Exception e){System.out.println("Error: "+e);}
	}
}