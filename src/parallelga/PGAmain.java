package parallelga;

import java.io.IOException;

public class PGAmain{
	static int ISLAND=4;//島の数
	static int grayF=0;//グレイフラグ
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
			System.out.println("島"+(i+1));
			data[0][i].Pop=Random.Ranview(); 
		}
		for(int i=0;i<ISLAND;i++){//10進数変換
			data[0][i].Pop2=Fitness.conversion(data[0][i].Pop); 
		}


		
		for(int i=0;i<ISLAND;i++){//テスト用コード
			for(int i2=0;i2<data[0][i].Pop2.length;i2++){
				System.out.println("PoP[0]["+i+"]は"+data[0][i].Pop2[i2]);
			}
		}
		
	}
}