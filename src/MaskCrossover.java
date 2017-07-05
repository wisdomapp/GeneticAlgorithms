import java.util.ArrayList;

public class MaskCrossover{


	public static String[] Cross(String[] NewPop){
		StringBuilder[] tmp2 = new StringBuilder[NewPop.length];
		for(int i=0;i<NewPop.length;i++){
			tmp2[i]=new StringBuilder("");
			tmp2[i].append(NewPop[i]);
		}
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
				String Mask="";
				for(int i2=0;i2<NewPop[0].length();i2++){
					Mask +=(int)(Math.random()+0.5);
				}
				int y=(int) (Math.random()*NewPop.length); //どの集団と交叉させるか
				//int m=(int) (Math.random()*NewPop[i].length()); //何文字目で区切るか
				while(lst.contains(y)){
					 y=(int) (Math.random()*NewPop.length);
					 //System.out.println("roop");
				}
				//System.out.println("NewPoP["+i+"]とNewPop["+y+"]が交叉");
				//System.out.println("マスクは"+Mask);
				char tmp3=' ';
				for(int z=0;z<NewPop[0].length();z++){
					if(Mask.charAt(z)=='0'){
						
							//System.out.println((z+1)+"文字目を交叉");
							tmp3=tmp2[y].charAt(z);
							tmp2[y].setCharAt(z,tmp2[i].charAt(z));
							tmp2[i].setCharAt(z, tmp3);
						
					}
				}
				lst.add(y);

			}
			//System.out.println(tmp[i]);
		}


		String[] NewPop2=new String[NewPop.length];
		System.out.println("交叉結果");
		for(int i3=0;i3<NewPop.length;i3++){
			NewPop2[i3]=new String(tmp2[i3]);
			System.out.println("NewPop2["+i3+"]="+NewPop2[i3]);

		}
		System.out.println("交叉終了");
		return NewPop2;
	}
}