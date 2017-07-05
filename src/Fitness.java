public class Fitness{

	public static int[] conversion(String Pop[]){
		
		int[] Pop2=new int[Pop.length];
		
		/*for(int i=0;i<Pop.length;i++){
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
		}*/
		for(int i=0;i<Pop.length;i++){
		Pop2[i]=Integer.parseInt(Pop[i],2);
		//System.out.println(Pop2[i]);
		}
		
		return Pop2;
	}
	
	public static double[] Compatible(int[] Pop2 ,String[] Pop){
		double Pop3[]=new double[Pop2.length];
		double multi=Math.pow(2.0,Pop[0].length() );
		for(int i=0;i<Pop2.length;i++){
			
			
			double tmp=Pop2[i]/multi;
			Pop3[i]=-4*tmp*(tmp-1);//適合度関数
			System.out.println("Pop2["+i+"]の適合度は"+Pop3[i]);
		}
		return Pop3;
	}
	
}