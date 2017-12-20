package parallelga;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Output{
	public static void File(Data[][] data){

	    Scanner scanner = new Scanner(System.in);
	    System.out.print("ファイル名を入力 > ");

	    String input = scanner.nextLine();
	    scanner.close();

		try {
				File file = new File("..\\GA\\txtfiles\\",input+".txt");
				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				
				
				for(int gene=0;gene<data.length;gene++){
					if(PGAmain.grayF==0){
						for(int i=0;i<PGAmain.ISLAND;i++){ //いつもの
							for(int i2=0;i2<data[0][0].Pop.length;i2++){
								pw.println(data[gene][i].Pop[i2]+" "+data[gene][i].Pop3[i2]);
							}
							pw.println("*");
						}
					}else if(PGAmain.grayF==1){
						for(int i=0;i<PGAmain.ISLAND;i++){ //いつもの
							for(int i2=0;i2<data[0][0].Pop.length;i2++){
							pw.println(Fitness.Gray(data[gene][i].Pop[i2])+" "+data[gene][i].Pop3[i2]);
							}
							pw.println("*");
						}
						
					}
					pw.println("#");
				}
				pw.close();
			
		   } catch (IOException e) {
			   System.out.println(e);
		   }
		System.out.println("保存終了");
	}
}