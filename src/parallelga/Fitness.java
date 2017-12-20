package parallelga;

public class Fitness{

	public static int[] conversion(String[] Pop){


		int[] Pop2=new int[Pop.length];

		if(PGAmain.grayF==0){
			for(int i=0;i<Pop.length;i++){
				Pop2[i]=Integer.parseInt(Pop[i],2);
				//System.out.println(Pop2[i]);
			}
		}else if(PGAmain.grayF==1){
			//グレイコード変換
			for(int i=0;i<Pop.length;i++){
				Pop2[i]=Integer.parseInt(Gray(Pop[i]),2);
				//System.out.println("Pop["+i+"]十進数は"+Pop2[i]);
				
			}
		}else{
			System.out.println("error");
			System.exit(1);
		}

		return Pop2;
	}

	public static double[] Compatible(int[] Pop2 ,String[] Pop){
		double Pop3[]=new double[Pop2.length];
		double multi=Math.pow(2.0,Pop[0].length() );
		for(int i=0;i<Pop2.length;i++){


			double tmp=Pop2[i]/multi;
			//Pop3[i]=-4*tmp*(tmp-1);//適合度関数
			Pop3[i]=Math.abs(Math.sin(5*Math.PI*tmp));
			//Pop3[i]=tmp*Math.abs(Math.sin(4*Math.PI*tmp));//関数(GraphPanelも修正必須)
			System.out.println("Pop2["+i+"]の適合度は"+Pop3[i]);
		}
		return Pop3;
	}

	public static String Gray(String Pop){
		String Tmp="";
		for(int z=0;Pop.length()>z;z++){
			if(z==0){
				Tmp+=String.valueOf(Pop.charAt(0));
			}else{
				char t0,t1;
				int s0,s1;
				t0=Pop.charAt(z);
				t1=Tmp.charAt(z-1);
				s0= Integer.parseInt(String.valueOf(t0));
				s1=Integer.parseInt(String.valueOf(t1));
				int h=s0^s1;
				Tmp+=String.valueOf(h);
			}

		}
		//System.out.println("二進数は"+Tmp);
		return Tmp;
	}
}