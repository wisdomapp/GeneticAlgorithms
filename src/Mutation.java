public class Mutation{
	
	public static String[] Mut (String[] NewPop2){
		
		StringBuilder[] tmp = new StringBuilder[NewPop2.length];
		for(int i=0;i<NewPop2.length;i++){
			tmp[i]=new StringBuilder("");
			//System.out.println("test");
			tmp[i].append(NewPop2[i]);
		}
		
		double Mutpro=1.0/NewPop2[0].length();
		
		for(int i=0;i<NewPop2.length;i++){
			for(int i2=0;i2<NewPop2[0].length();i2++){
				if(Math.random() <= Mutpro){
					if(NewPop2[i].charAt(i2)=='1'){
						tmp[i].setCharAt(i2,  '0');
						System.out.println("NewPop2["+i+"]の"+(i2+1)+"文字目が0に突然変異");
					}else{
						tmp[i].setCharAt(i2,  '1');
						System.out.println("NewPop2["+i+"]の"+(i2+1)+"文字目が1に突然変異");
					}
				}
			}
			
		}
		
		System.out.println("突然変異終了");
		for(int i3=0;i3<NewPop2.length;i3++){
			System.out.println("NewPop["+i3+"]="+tmp[i3]);
		}
		return NewPop2;
	}
	
}