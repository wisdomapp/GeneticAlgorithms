package parallelga;



public class Random{
	public static String[] Ranview(){


		String[] Pop=new String[PGAmain.group];
		//System.out.println("第1世代開始\n初期集団");
		for(int i=0;i<PGAmain.group;i++){
			Pop[i]="";
			for(int i2=0;i2<PGAmain.kotaicho;i2++){
				Pop[i] +=(int)(Math.random()+0.5);
			}
		}

		for(int i=0;i<PGAmain.group;i++){
			System.out.println("Pop["+i+"]="+Pop[i]);
			}
		return Pop;
	}

}

