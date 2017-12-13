package parallelga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input{
	public static void Firstinput() throws IOException{
		System.out.println("生成する世代数を入力。");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String buf=br.readLine();
		PGAmain.generation=Integer.parseInt(buf);

		System.out.println("̂一点交叉なら0、一様交叉なら1を入力。");
		InputStreamReader isr2=new InputStreamReader(System.in);
		BufferedReader br2=new BufferedReader(isr2);
		String buf2=br2.readLine();
		PGAmain.crossingF=Integer.parseInt(buf2);

		System.out.println("̂二進数なら0、グレイコードなら1を入力。");
		InputStreamReader isr4=new InputStreamReader(System.in);
		BufferedReader br4=new BufferedReader(isr4);
		String buf4=br4.readLine();
		PGAmain.grayF=Integer.parseInt(buf4);
		
		System.out.println("生成する集団数を入力。");
		InputStreamReader isr5=new InputStreamReader(System.in);
		BufferedReader br5=new BufferedReader(isr5);
		String buf5=br5.readLine();
		PGAmain.group=Integer.parseInt(buf5);

		System.out.println("̂個体の長さを入力。");
		InputStreamReader isr6=new InputStreamReader(System.in);
		BufferedReader br6=new BufferedReader(isr6);
		String buf6=br6.readLine();
		PGAmain.kotaicho=Integer.parseInt(buf6);
		
	}
}