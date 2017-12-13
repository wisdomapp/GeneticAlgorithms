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
		
		for(int i=0;i<ISLAND;i++){
			data[0][i].Pop=Random.Ranview(); //初期集団
		}
		for(int i=0;i<ISLAND;i++){
			for(int i2=0;i2<data[0][i].Pop.length;i2++){
				System.out.println("島"+i+"は"+data[0][i].Pop[i2]);
			}
		}
	}
}