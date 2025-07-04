import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionCombinationSum {
	
	public static void main(String args[]) {
		
		int [] arr = {2,3,4};
		int target = 7;
		List<List<Integer>> combList1 = combinationSum(arr,target);
		
		List<List<Integer>> combList2 = combinationSum2(arr,target);
		
		System.out.println("The list is ");
		
	}
	
	
    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds)); 
            return; 
        }
        
        for(int i = ind; i < arr.length;i++) {
            if(i > ind && arr[i] == arr[i-1]) continue; 
            if(arr[i]>target) break; 
            
            ds.add(arr[i]); 
            findCombinations(i+1, arr, target - arr[i], ans, ds); 
            ds.remove(ds.size() - 1); 
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); 
        findCombinations(0, candidates, target, ans, new ArrayList<>()); 
        return ans; 
    }
    
    private static void findCombinations1(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(ind == arr.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(ds)); 
            }
            return; 
        }
        
        if(arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations1(ind, arr, target - arr[ind], ans, ds); 
            ds.remove(ds.size() - 1); 
        }
        findCombinations1(ind + 1, arr, target, ans, ds);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations1(0, candidates, target, ans, new ArrayList<>()); 
        return ans; 
    }
    
    public static void listWithSubsetSum(List<Integer> org, List<Integer> subsetSum, int index, int runningSum) {
    	if(index == org.size()) {
    		subsetSum.add(runningSum);
    		return;
    	}
    	
    	listWithSubsetSum(org,subsetSum,index+1, runningSum+org.get(index));
    	listWithSubsetSum(org,subsetSum,index+1, runningSum);
    }
    
    public void allPossibleUniqueCombinations(List<Integer> org, List<Integer> temp, List<List<Integer>> res, int index) {
    	if(index == org.size()) {
    		res.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	
    	for(int i = index; i< org.size(); i++) {
    		if(i > index && org.get(i) == org.get(i-1)) continue;
    		
    		temp.add(org.get(i));
    		allPossibleUniqueCombinations(org,temp,res,i+1);
    		temp.remove(temp.size()-1);
    	}
    }
    
    public void allPossibleUniquePermutations(List<Integer> org, List<Integer> temp, List<List<Integer>> res, int index) {
    	if(index == org.size()) {
    		res.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	
    	for(int i = index; i< org.size(); i++) {
    		if(i > index && org.get(i) == org.get(i-1)) continue;
    		
    		temp.add(org.get(i));
    		allPossibleUniqueCombinations(org,temp,res,i+1);
    		temp.remove(temp.size()-1);
    	}
    }
    
    
    public void solveNQueens(int[][] chess, int col, List<int[][]> result) {
    	if(col == chess[0].length) {
    		result.add(chess);
    		return;
    	}
    	
    	for(int row = 0; row<chess.length; row++) {
    		if(isSafe(chess, row, col)) {
    			chess[row][col] = 1;
    			solveNQueens(chess,  col,  result);
    			chess[row][col] = 0;
    		}
    	}
    }
    
    public boolean isSafe(int[][] chess, int row, int col) {
    	int tempRow = row;
    	int tempCol = col;
    	// check left row
    	while(col >=0) {
    		if(chess[row][col] == 1) return false;
    		col--;
    	}
    	
		row = tempRow;
		col = tempCol;

    	// check upper diagonal
    	while(col >=0 && row >=0) {
    		if(chess[row][col] == 1) return false;
    		col--;
    		row--;
    	}
    	row = tempRow;
    	col = tempCol;    	
    	// check lower diagonal
    	while(col >=0 && row < chess.length) {
    		if(chess[row][col] == 1) return false;
    		col--;
    		row++;
    	}
    	
    	
    	return true;
    }
}
