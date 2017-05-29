public class Fitness{

	public static int[] conversion(String Pop[]){
		
		int[] Pop2=new int[Pop.length];
		
		for(int i=0;i<Pop.length;i++){
			int tmp=0;
			int multi=1;
			for(int i2=0;i2<Pop[0].length();i2++){
				if(Pop[i].charAt(Pop[0].length()-i2-1)=='1'){
					tmp += multi;
				}
				multi += multi;
				
			}
			
			Pop2[i]=tmp;
			System.out.println("Pop2["+i+"]="+Pop2[i]);
		}
		Fitness.Compatible(Pop2);
		return Pop2;
	}
	
	public static double[] Compatible(int[] Pop2){
		double Pop3[]=new double[Pop2.length];
		for(int i=0;i<Pop2.length;i++){
			double multi=1.0;
			for(int i2=0;i2<Pop2.length;i2++){
				multi += multi;
			}
			double tmp=Pop2[i]/multi;
			Pop3[i]=-4*tmp*(tmp-1);//適合度関数
			System.out.println("Pop2["+i+"]の適合度は"+Pop3[i]);
		}
		Roulette.Pselect(Pop3);
		return Pop3;
	}
	
}