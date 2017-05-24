public class GAmain{
	public static void main(String[] args){
		int[] Pop2=Random.Ranview();
		double[] Pop3=Fitness.Compatible(Pop2);
		Roulette.Pselect(Pop3);
		
	}
}