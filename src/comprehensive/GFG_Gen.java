package comprehensive;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;


public class GFG_Gen {

	public static void main(String[] args) {
		System.out.print(gen(10, 1));

		
			try {
				FileWriter write = new FileWriter(new File("src/comprehensive/test.g"));
				write.write(gen(10, 0));
				write.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}
	
	public static String gen(int nt, int t) {
		StringBuilder sb = new StringBuilder();
		
		//production rules for start non-terminal
		sb.append("{\n");
		sb.append("<start>\n");
		//<1>, <2>, ... <nt>
		for(int i = 1; i <= nt; i++)
			sb.append("<" + i + ">\n");
		sb.append("}\n");
		
		//production rules for each other non-terminal
		for(int i = 1; i<=nt; i++){
			sb.append("{\n");
			sb.append("<" + i + ">\n");//nt name\
			sb.append(i + "\n");
			sb.append("}\n");
		}
		return sb.toString();
	}

}
