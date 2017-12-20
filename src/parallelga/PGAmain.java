package parallelga;

import java.io.IOException;

public class PGAmain{
	static int ISLAND=4;//島の数
	static int grayF=0;//グレイコードフラグ
	static int group=0;//集団数
	static int kotaicho=0;//個体長
	static int generation;//世代数
	static int crossingF;//交叉フラグ
	static int fileF;//ファイル保存フラグ

	public static void PGA() throws IOException{

		Input.Firstinput();//初期入力
		Data[][] data=new Data[generation][ISLAND]; //データ構造体配列
		for(int i=0;i<data.length;i++){//初期化
			for(int i2=0;i2<ISLAND;i2++){
				data[i][i2]=new Data(generation);
			}
		}

		System.out.println("第一世代開始");//初期集団
		for(int i=0;i<ISLAND;i++){
			System.out.println("島"+(i));
			data[0][i].Pop=Random.Ranview();
		}
		for(int i=0;i<ISLAND;i++){//10進数変換
			System.out.println("島"+(i));
			data[0][i].Pop2=Fitness.conversion(data[0][i].Pop);
		}


		for(int i=0;i<ISLAND;i++){//適合度計算
			System.out.println("島"+(i));
			data[0][i].Pop3=Fitness.Compatible(data[0][i].Pop2,data[0][i].Pop);
		}
		for(int i=0;i<ISLAND;i++){//エリート戦略
			data[0][i].Elite=Roulette.Elite(data[0][i].Pop3);
			System.out.println("島"+i+"のエリートは"+data[0][i].Elite);
		}
		for(int i=0;i<ISLAND;i++){//確率分布計算
			System.out.println("島"+(i));
			data[0][i].PopS=Roulette.Pselect(data[0][i].Pop3);
		}
		for(int i=0;i<ISLAND;i++){//ルーレット選択
			//System.out.println("島"+(i));
			data[0][i].Select=Roulette.Select(data[0][i].PopS);
		}
		for(int i=0;i<ISLAND;i++){//淘汰
			System.out.println("島"+(i));
			data[0][i].NewPop=Roulette.GenerationalChange(data[0][i].Pop, data[0][i].Select);
		}
		if(crossingF==0){
			for(int i=0;i<ISLAND;i++){//一点交叉
				System.out.println("島"+(i));
				data[0][i].NewPop2=Crossover.Cross(data[0][i].NewPop);
			}
		}else{
			for(int i=0;i<ISLAND;i++){ //一様交叉
				System.out.println("島"+(i));
				data[0][i].NewPop2=MaskCrossover.Cross(data[0][i].NewPop);
			}
		}
		for(int i=0;i<ISLAND;i++){//突然変異
			System.out.println("島"+(i));
			data[0][i].NewPop3=Mutation.Mut(data[0][i].NewPop2);
		}
		for(int i=0;i<ISLAND;i++){//エリート処理
			System.out.println("島"+(i));
			int tmp[]=Fitness.conversion(data[0][i].NewPop3);
			double tmp2[]=Fitness.Compatible(tmp,data[0][i].Pop);
			System.out.println("えりーとは"+data[0][i].Pop3[data[0][i].Elite]);
			for(int i2=0;data[0][i].Pop.length>i2;i2++){
				//int t=data[i].Pop.length;


				if(tmp2[i2]>data[0][i].Pop3[data[0][i].Elite]){
					System.out.println("えりーとよりいいのある");
					break;
				}
				if(i2+1>=data[0][i].Pop.length){
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
							System.out.println("いちばん低いのはは"+min);
							System.out.println(data[0][i].NewPop3[min]+"をへんこう");
							data[0][i].NewPop3[min]=data[0][i].Pop[data[0][i].Elite];
							System.out.println(data[0][i].NewPop3[min]+"にへんこう");
							break;
						}
					}

				}
			}
		}




		/*for(int i=0;i<ISLAND;i++){//テスト用コード
			//System.out.println("島"+i+"のエリートは"+data[0][i].Elite);
			for(int i2=0;i2<data[0][i].Pop3.length;i2++){
				//System.out.println("PoP[0]["+i+"]は"+data[0][i].Pop3[i2]);


		}*/

	}
}