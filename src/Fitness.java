public class Fitness{

	public static void conversion(int x,int y,String Pop[]){
		
		int[] Pop2=new int[x];
		
		for(int i=0;i<x;i++){
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
		
	}
	
}