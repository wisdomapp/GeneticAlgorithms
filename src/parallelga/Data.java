package parallelga;

public class Data{
	String[] Pop={}; //初期集団
	int[] Pop2={}; //10進数変換
	double[] Pop3={};//適合度計算
	double[] PopS={}; //確率分布計算
	int[] Select={}; //集団選択
	String[] NewPop={}; //世代交代
	String[] NewPop2={}; //一点交叉
	String[] NewPop3={}; //突然変異
	int Elite; //エリート個体

	public Data(int i){
		this.Pop=new String[i];//初期集団
		this.Pop2=new int[i]; //10進数変換
		this.Pop3=new double[i];//適合度計算
		this.PopS=new double[i]; //確率分布計算
		this.Select=new int[i]; //集団選択
		this.NewPop=new String[i]; //世代交代
		this.NewPop2=new String[i]; //一点交叉
		this.NewPop3=new String[i]; //突然変異
		this.Elite=0; //エリート個体
	}
}