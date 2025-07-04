import java.util.ArrayList;
import java.util.List;

public class Knapsack {

	public static void main(String[] args) {
		String merchantFilterList = "testDropp,Travel and Leisure,Mamey,Big Biz Real,Deep Center,Mike Lawn Care,Studio D8,WEB23";
		String[] merchantFilterArray = merchantFilterList.split(",");
		List<String> list = new ArrayList<>();
		list.add("Mamey, Inc.");
		list.add("Big Biz Real Estate Llc");
		list.add("Deep Center Field Press");
		list.add("Mike Lawn Care");
		System.out.println("merchantFilterArray sizze "+merchantFilterArray.length)	;
		
		for(int j =0; j < list.size(); j++) {
		for(int i=0 ; i< merchantFilterArray.length; i++ ) {
			if(list.get(j).contains(merchantFilterArray[i])) {
				System.out.println("TRUE")	;
			}
		}
		}
	}
	
	
	public long f(int n, int []a) {
		
		int i = 1;
		
		return 1l;
	}

}
