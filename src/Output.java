import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Output{
	public static void File(Data[] data){

	    Scanner scanner = new Scanner(System.in);
	    System.out.print("ファイル名を入力 > ");

	    String input = scanner.nextLine();
	    scanner.close();

		try {
			File file = new File("..\\GA\\txtfiles\\",input+".txt");
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

		      for(int i=0;i<data.length;i++){
		    	  if(GAmain.gray==0){
		    		  for(int i2=0;i2<data[0].Pop.length;i2++){
		    			  pw.println(data[i].Pop[i2]+" "+data[i].Pop3[i2]);
		    		  }
		    	  }else if(GAmain.gray==1){
		    		  for(int i2=0;i2<data[0].Pop.length;i2++){
		    			  pw.println(Fitness.Gray(data[i].Pop[i2])+" "+data[i].Pop3[i2]);
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