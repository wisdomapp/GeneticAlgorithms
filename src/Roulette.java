public class Roulette{
	
	static int ele;
	public static double[] Pselect(double[] Pop3){
	   // ele=Elite(Pop3);
		double[] PopS=new double[Pop3.length];
		double tmp=0.0;
		for(int i=0;i<Pop3.length;i++){
			if(i==ele)i++;
			if(i>=Pop3.length)break;
			tmp +=Pop3[i];
		}
		for(int i=0;i<Pop3.length;i++){
			if(i==ele)i++;
			if(i>=Pop3.length)break;
			PopS[i]=Pop3[i]/tmp;
			//System.out.println("Pop2["+i+"]の確率分布は"+PopS[i]);
		}


		return PopS;
	}

	public static int Elite(double[] Pop3){
		double values[]=Pop3;
		double max=values[0];
		//int ele=0;

		for(int index=1;index<values.length;index++){
			max=Math.max(max,values[index]);
		}
		for(int index=0;index<values.length;index++){
			if(values[index]==max){
				ele=index;
				break;
			}
		}
		return ele;
	}

	public static int[] Select(double[] PopS){
		
		int[] select=new int[PopS.length];
		int sle=0;
		for(int i=1;i<PopS.length;i++){
			double multi=0.0;
			double tmp=Math.random();
			//System.out.println((i)+"回目のルーレットは"+tmp);
			for(int i2=0;i2<PopS.length;i2++){
				if(i2==ele){
					i2++;
				}
				if(i2>=PopS.length)break;
				multi += PopS[i2];
				if(multi>tmp){
					sle=i2;
					break;
				}

			}
			//System.out.println("選択されたのはPop["+sle+"]");
			select[i]=sle;
		}
		select[0]=ele;
		return select;
	}

	public static String[] GenerationalChange(String[] Pop,int[] Select){

		String[] NewPop=new String[Pop.length];
		System.out.println("選択開始");
		for(int i=0;i<Pop.length;i++){
			NewPop[i]=Pop[Select[i]];
			System.out.println("NewPop["+i+"]="+NewPop[i]);
		}
		System.out.println("選択終了");
		return NewPop;
	}




}