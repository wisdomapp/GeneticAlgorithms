public class Fitness{

	public static void conversion(int x,int y,String Pop[]){
		
		for(int i=0;i<x;i++){
			int tmp=0;
			int multi=1;
			for(int i2=0;i2<Pop[0].length();i2++){
				if(Pop[i].charAt(Pop[0].length()-i2-1)=='1'){
					tmp += multi;
				}
				multi += multi;
				
			}
			System.out.println(tmp);
		}
		
	}
	
}