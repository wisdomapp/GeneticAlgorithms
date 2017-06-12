import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GAmain{
	public static void main(String[] args){
		
		int x;
		try{
			System.out.println("生成する世代数を入力。");
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			String buf=br.readLine();
			x=Integer.parseInt(buf);

			}catch(Exception e){
				x=0;
			}

		String Pop[]=Random.Ranview(); //初期集団
		int Pop2[]=Fitness.conversion(Pop); //10進数変換
		for(int i=0;i<x;i++){
			
			double[] Pop3=Fitness.Compatible(Pop2); //適合度計算
			double[] PopS=Roulette.Pselect(Pop3); //確率分布計算
			int[] Select=Roulette.Select(PopS); //集団選択
			String[] NewPop=Roulette.GenerationalChange(Pop, Select); //世代交代
			String[] NewPop2=Crossover.Cross(NewPop); //一点交叉
			String[] NewPop3=Mutation.Mut(NewPop2); //突然変異
			System.out.println("第"+(i+1)+"世代終了");
			if(x==i+1)break;
			System.out.println("第"+(i+2)+"世代開始");
			Pop=NewPop3;
			Pop2=Fitness.conversion(Pop); //10進数変換
			
		}
		
	}
}