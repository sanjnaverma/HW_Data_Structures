
public class IntMax implements Maximizer<Integer> {

	public Integer getMax(Integer t1, Integer t2){
		Integer verdict = null;
		if (t1 > t2){
			 verdict = t1;
		}
		else if (t1 < t2){
			verdict = t2;
		}
		else if (t1 == t2){
			 verdict = t1;
		}
		return verdict;
	}
	
	public Integer getGlobalMin(){
		return Integer.MIN_VALUE;
	}
}
