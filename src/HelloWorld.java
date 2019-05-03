import com.clearspring.analytics.stream.quantile.TDigest;
import java.util.Random;
import java.util.Arrays; 

public class HelloWorld {

	public static void main(String[] args) {
		Random randomGen = new Random();
		TDigest tDigester = new TDigest(100);
		
		double[] entries = new double[51000];
		
		for(int i = 0; i < 51000; i++) {
			double randomNum = randomGen.nextDouble() * 100;
			entries[i] = randomNum;
			tDigester.add(randomNum);
		}
		
		double median = tDigester.quantile(0.500000);
		Arrays.sort(entries);
		
		System.out.println("tDigester median: " + median);
		System.out.println("actual median: " + entries[25500]);
		System.out.println("centroidCount: " + tDigester.centroidCount());
		
	}

}
