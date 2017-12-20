import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parallelga.PGAmain;

public class GAmain{
	static int gray=0;//グレイコードフラグ
	static int parallelGA=0;//並列分散フラグ
	public static void main(String[] args) throws IOException{

		int x;//世代数
		int y;//交叉フラグ
		int z;//ファイル保存フラグ

		System.out.println("̂シンプルGAなら0、並列分散GAなら1を入力。");
		InputStreamReader isr5=new InputStreamReader(System.in);
		BufferedReader br5=new BufferedReader(isr5);
		String buf5=br5.readLine();
		parallelGA=Integer.parseInt(buf5);

		if(parallelGA==1){
			PGAmain.PGA();
		}else{

		System.out.println("生成する世代数を入力。");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String buf=br.readLine();
		x=Integer.parseInt(buf);

		System.out.println("̂一点交叉なら0、一様交叉なら1を入力。");
		InputStreamReader isr2=new InputStreamReader(System.in);
		BufferedReader br2=new BufferedReader(isr2);
		String buf2=br2.readLine();
		y=Integer.parseInt(buf2);

		System.out.println("̂二進数なら0、グレイコードなら1を入力。");
		InputStreamReader isr4=new InputStreamReader(System.in);
		BufferedReader br4=new BufferedReader(isr4);
		String buf4=br4.readLine();
		gray=Integer.parseInt(buf4);

		Data[] data=new Data[x]; //データ構造体配列
		for(int i=0;i<data.length;i++){
			data[i]=new Data(x);
		}

		data[0].Pop=Random.Ranview(); //初期集団
		data[0].Pop2=Fitness.conversion(data[0].Pop); //10進数変換
		for(int i=0;i<x;i++){

			data[i].Pop3=Fitness.Compatible(data[i].Pop2,data[i].Pop); //適合度計算
			data[i].Elite=Roulette.Elite(data[i].Pop3);//エリート戦略
			System.out.println("エリート番号は"+data[i].Elite);
			data[i].PopS=Roulette.Pselect(data[i].Pop3); //確率分布計算
			data[i].Select=Roulette.Select(data[i].PopS); //ルーレット選択
			data[i].NewPop=Roulette.GenerationalChange(data[i].Pop, data[i].Select); //淘汰
			if(y==0){
				data[i].NewPop2=Crossover.Cross(data[i].NewPop); //一点交叉
			}else{
				data[i].NewPop2=MaskCrossover.Cross(data[i].NewPop); //一様交叉
			}
			data[i].NewPop3=Mutation.Mut(data[i].NewPop2); //突然変異
			int tmp[]=Fitness.conversion(data[i].NewPop3);
			double tmp2[]=Fitness.Compatible(tmp,data[i].Pop);

			System.out.println("えりーとは"+data[i].Pop3[data[i].Elite]);
			for(int i2=0;data[i].Pop.length>i2;i2++){
				//int t=data[i].Pop.length;


				if(tmp2[i2]>data[i].Pop3[data[i].Elite]){
					System.out.println("えりーとよりいいのある");
					break;
				}
				if(i2+1>=data[i].Pop.length){
					System.out.println("エリートといれかえ");
					double values[]=tmp2;
					double max=values[0];
					int min;
					for(int index=1;index<values.length;index++){
						max=Math.min(max,values[index]);
					}
					for(int index=0;index<values.length;index++){
						if(values[index]==max){
							min=index;
							System.out.println("いちばんざこは"+min);
							System.out.println(data[i].NewPop3[min]+"をへんこう");
							data[i].NewPop3[min]=data[i].Pop[data[i].Elite];
							System.out.println(data[i].NewPop3[min]+"にへんこう");
							break;
						}
					}

				}
			}
			System.out.println("第"+(i+1)+"世代終了");
			if(x==i+1)break;
			System.out.println("第"+(i+2)+"世代開始");
			data[i+1].Pop=data[i].NewPop3;
			data[i+1].Pop2=Fitness.conversion(data[i].NewPop3); //10進数変換

		}

		System.out.println("ファイル保存するなら0,しないなら1を入力");
		InputStreamReader isr3=new InputStreamReader(System.in);
		BufferedReader br3=new BufferedReader(isr3);
		String buf3=br3.readLine();
		z=Integer.parseInt(buf3);
		if(z==0)Output.File(data);
		System.out.println("終了");
		}
	}
}