import java.util.ArrayList;

public class Crossover{
	
	public static String[] Cross(String[] NewPop){
		System.out.println("交叉開始");
		double probability=1.0; //交叉確率
		ArrayList<Integer> lst = new ArrayList<>();
		String[] tmp=new String[NewPop.length];
		
		for(int z=0;z<NewPop.length;z++){
			tmp[z]=NewPop[z];
		}
		
		for(int i=0;i<NewPop.length;i++){
			
			if(lst.contains(i))i++;
			if(NewPop.length%2==0){
				if(lst.size()==NewPop.length){
					break;
				}
				lst.add(i);
			}else{
				lst.add(i);
				if(lst.size()==NewPop.length){;
					break;
				}
				
			}
			
			if(Math.random() <= probability){
				int y=(int) (Math.random()*NewPop.length); //どの集団と交叉させるか
				int m=(int) (Math.random()*NewPop[i].length()); //何文字目で区切るか
				while(lst.contains(y)){
					 y=(int) (Math.random()*NewPop.length);
					 //System.out.println("roop");
				}
				System.out.println("NewPoP["+i+"]はNewPop["+y+"]と"+(m+1)+"文字目で交叉");
				String tmp1=tmp[i].substring(0,m);
				String tmp2=tmp[i].substring(m);
				String tmp3=tmp[y].substring(0,m);
				String tmp4=tmp[y].substring(m);
				tmp[i]=tmp1+tmp4;
				tmp[y]=tmp3+tmp2;
				lst.add(y);
				
			}
			//System.out.println(tmp[i]);
		}
		System.out.println("交叉終了");
		for(int i3=0;i3<NewPop.length;i3++){
			System.out.println("NewPop["+i3+"]="+tmp[i3]);
		}
		
		return tmp;
	}
}