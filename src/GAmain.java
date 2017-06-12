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
		Data[] data=new Data[x]; //データ構造体配列
		for(int i=0;i<data.length;i++){
			data[i]=new Data(x);
		}
		
		data[0].Pop=Random.Ranview(); //初期集団
		data[0].Pop2=Fitness.conversion(data[0].Pop); //10進数変換
		for(int i=0;i<x;i++){
			
			data[i].Pop3=Fitness.Compatible(data[i].Pop2); //適合度計算
			data[i].PopS=Roulette.Pselect(data[i].Pop3); //確率分布計算
			data[i].Select=Roulette.Select(data[i].PopS); //集団選択
			System.out.println("Popは"+data[i].Pop[i]);
			data[i].NewPop=Roulette.GenerationalChange(data[i].Pop, data[i].Select); //世代交代
			data[i].NewPop2=Crossover.Cross(data[i].NewPop); //一点交叉
			data[i].NewPop3=Mutation.Mut(data[i].NewPop2); //突然変異
			System.out.println("第"+(i+1)+"世代終了");
			if(x==i+1)break;
			System.out.println("第"+(i+2)+"世代開始");
			data[i+1].Pop2=Fitness.conversion(data[i].NewPop3); //10進数変換
			
		}
		
	}
}