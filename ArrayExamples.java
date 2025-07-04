
public class ArrayExamples {
	
	public static void main(String args[]) {
		int [] arr = {6,1,3,2,4,7};
		int maxProfit = maxProfit(arr);
		System.out.println("The max profit is :: "+maxProfit);
	}
	
	
	public static int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_price = prices[0];
         int i=1;         

         while(i<=prices.length-1){
             min_price = Math.min(min_price, prices[i]);
             max_profit = Math.max( max_profit , maxProfitSingle(prices,0,i ) + maxProfitSingle(prices, i+1,prices.length-1 )) ;              
             i++;
         }
         if(max_profit <= 0) return 0;
         return max_profit;
    }

    public static int maxProfitSingle(int[] prices, int startIndex, int endIndex) {
        if(startIndex >= endIndex) return 0;
        int max_profit = 0;
        int min_price = prices[startIndex];
         int i=startIndex + 1;         

         while(i<=endIndex){
             min_price = Math.min(min_price, prices[i]);
             max_profit = Math.max(prices[i] - min_price , max_profit);             
             i++;
         }
         if(max_profit <= 0) return 0;
         return max_profit;
    }
    
    
    public int maxProfitDaily(int[] prices) {
        int profit = 0;
        for(int i=1; i< prices.length; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }  

}
