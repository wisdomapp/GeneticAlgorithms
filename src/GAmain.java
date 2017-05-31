public class GAmain{
	public static void main(String[] args){
		
		String Pop[]=Random.Ranview(); //初期集団
		int Pop2[]=Fitness.conversion(Pop); //10進数変換
		double[] Pop3=Fitness.Compatible(Pop2); //適合度計算
		double[] PopS=Roulette.Pselect(Pop3); //確率分布計算
		int[] Select=Roulette.Select(PopS); //集団選択
		String[] NewPop=Roulette.GenerationalChange(Pop, Select); //世代交代

		
	}
}