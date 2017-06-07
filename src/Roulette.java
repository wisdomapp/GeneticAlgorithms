public class Roulette{
	public static double[] Pselect(double[] Pop3){
		double[] PopS=new double[Pop3.length];
		double tmp=0.0;
		for(int i=0;i<Pop3.length;i++){
			tmp +=Pop3[i];
		}
		for(int i=0;i<Pop3.length;i++){
			PopS[i]=Pop3[i]/tmp;
			//System.out.println("Pop2["+i+"]の確率分布は"+PopS[i]);
		}
		
		
		return PopS;
	}
	
	public static int[] Select(double[] PopS){
		int[] select=new int[PopS.length];
		int sle=0;
		for(int i=0;i<PopS.length;i++){
			double multi=0.0;
			double tmp=Math.random();
			//System.out.println((i+1)+"回目のルーレットは"+tmp);
			for(int i2=0;i2<PopS.length;i2++){
				multi += PopS[i2];
				if(multi>tmp){
					sle=i2;
					break;
				}

			}
			//System.out.println("選択されたのはPop["+sle+"]");
			select[i]=sle;
		}
		return select;
	}
	
	public static String[] GenerationalChange(String[] Pop,int[] Select){
		
		String[] NewPop=new String[Pop.length];
		for(int i=0;i<Pop.length;i++){
			NewPop[i]=Pop[Select[i]];
			System.out.println("NewPop["+i+"]="+NewPop[i]);
		}
		System.out.println("選択終了");
		return NewPop;
	}
	
	
	
	
}