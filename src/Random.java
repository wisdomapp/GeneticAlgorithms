import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Random{
	public static void Ranview(){



		int x;
		int y;

		try{
		System.out.println("¶¬‚·‚éW’c”‚ğ“ü—ÍB");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String buf=br.readLine();
		x=Integer.parseInt(buf);

		System.out.println("ŒÂ‘Ì‚Ì’·‚³‚ğ“ü—ÍB");
		InputStreamReader isr2=new InputStreamReader(System.in);
		BufferedReader br2=new BufferedReader(isr2);
		String buf2=br2.readLine();
		y=Integer.parseInt(buf2);

		}catch(Exception e){
			x=0;
			y=0;
		}

		String[] Pop=new String[x];

		for(int i=0;i<x;i++){
			Pop[i]="";
			for(int i2=0;i2<y;i2++){
				Pop[i] +=(int)(Math.random()+0.5);
			}
		}

		for(int i=0;i<x;i++){
			System.out.println("Pop["+i+"]="+Pop[i]);
			}

		Fitness.conversion(x,y,Pop);
	}

	}