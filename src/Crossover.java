public class Crossover{
	
	public static void Cross(String[] NewPop){
		double probability=1.0; //交差確率
		String[] tmp=new String[NewPop.length];
		
		for(int z=0;z<NewPop.length;z++){
			tmp[z]=NewPop[z];
		}
		
		for(int i=0;i<NewPop.length;i++){
			if(Math.random() <= probability){
				int y=(int) (Math.random()*NewPop[i].length()); //どの集団と交叉させるか
				int m=(int) (Math.random()*NewPop[i].length()); //何文字目で区切るか
				System.out.println("NewPoP["+i+"]はNewPop["+y+"]と"+(m+1)+"文字目で交叉");
				if(y==i){
					 y=(int) (Math.random()*NewPop[i].length());
				}
				String tmp1=tmp[i].substring(0,m);
				String tmp2=tmp[i].substring(m);
				String tmp3=tmp[y].substring(0,m);
				String tmp4=tmp[y].substring(m);
				tmp[i]=tmp1+tmp4;
				tmp[y]=tmp3+tmp2;
				
				
			}
			System.out.println(tmp[i]);
		}
	}
}