import java.util.ArrayList;
import java.util.List;

public class RecursionRelated {

	public static void main(String args[]) {
/*		int[] arr = { 1,2,3};
		List<Integer> intList = new ArrayList<Integer>(arr.length);
		for (int i : arr) {
			intList.add(i);
		}
		 printSubSequence(intList);
		System.out.println(" ============ ");
		//printSubSequenceSum(intList, 7);
		List<List<Integer>> result = new ArrayList<>();
/*		printCombinationSumII(intList,result,new ArrayList<>(),0,4);
		for(List lst: result) {
			System.out.print("One possible sub ==> ");
			for (int i =0; i<lst.size();i++) {
				System.out.print(" , "+lst.get(i));
			}
			System.out.println(" ============ ");
		}
		*/
/*		printAllDistinctSets(intList,new ArrayList<>(), 0,result);
		
		for(List lst: result) {
			System.out.print("One possible sub ==> ");
			for (int i =0; i<lst.size();i++) {	
				System.out.print(" , "+lst.get(i));
			}
			System.out.println("");
		}*/
		List<List<String>> res = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		String s = "aabb";
		palindromePartition(res, temp, s, 0);
		System.out.println(" ======Tower Of Hanoi====== ");
		int count = towerOfHanoi(1,3,2,3,0);
		System.out.println("Total Steps ::==> "+count);
	}

	public static void printSubSequenceSum(List<Integer> list, int target) {
		List<Integer> printList = new ArrayList<>();
		recursivePrintSubseqTargetSumReducingTarget(list, printList, list.size(), 0, target, 0);
	}

	public static void printSubSequence(List<Integer> list) {
		List<Integer> printList = new ArrayList<>();
		recursivePrint(list, printList, list.size(), 0);
	}

	private static void recursivePrint(List<Integer> originalList, List<Integer> toBePrinted, int size,
			int currentIndex) {
		if (currentIndex == size) {
			System.out.println("  ");
			System.out.print("One possible sub ==> ");
			for (int i = 0; i < toBePrinted.size(); i++) {
				System.out.print(toBePrinted.get(i) + ",");
			}
			return;
		}

		// take the element from list
		toBePrinted.add(originalList.get(currentIndex));
		recursivePrint(originalList, toBePrinted, size, currentIndex + 1);
		int removeIndex = toBePrinted.size() - 1;
		toBePrinted.remove(removeIndex);
		// dont take the element from list
		recursivePrint(originalList, toBePrinted, size, currentIndex + 1);
	}

	public static void recursivePrintSubseqTargetSum(List<Integer> originalList, List<Integer> toBePrinted, int size,
			int currentIndex, int target, int currentSum) {

		if (currentIndex == size) {
			if (currentSum == target) {
				System.out.print("One possible sub ==> ");
				for (int i = 0; i < toBePrinted.size(); i++) {
					System.out.print(toBePrinted.get(i) + ",");
				}
				System.out.println(" ");
			}
			return;
		}

		// take the element from list
		toBePrinted.add(originalList.get(currentIndex));
		currentSum = currentSum + originalList.get(currentIndex);
		recursivePrintSubseqTargetSum(originalList, toBePrinted, size, currentIndex + 1, target, currentSum);
		int removeIndex = toBePrinted.size() - 1;
		currentSum = currentSum - toBePrinted.get(removeIndex);
		toBePrinted.remove(removeIndex);
		// dont take the element from list
		recursivePrintSubseqTargetSum(originalList, toBePrinted, size, currentIndex + 1, target, currentSum);
	}

	public static void recursivePrintSubseqTargetSumReducingTarget(List<Integer> originalList,
			List<Integer> toBePrinted, int size, int currentIndex, int target, int currentSum) {

		if (currentIndex == size) {
			if (target == 0) {
				System.out.print("One possible sub ==> ");
				for (int i = 0; i < toBePrinted.size(); i++) {
					System.out.print(toBePrinted.get(i) + ",");
				}
				System.out.println(" ");
			}
			return;
		}

// take the element from list 
		toBePrinted.add(originalList.get(currentIndex));
		currentSum = currentSum + originalList.get(currentIndex);
		recursivePrintSubseqTargetSumReducingTarget(originalList, toBePrinted, size, currentIndex + 1, target - originalList.get(currentIndex), currentSum);
		int removeIndex = toBePrinted.size() - 1;
		currentSum = currentSum - toBePrinted.get(removeIndex);
		toBePrinted.remove(removeIndex);
//dont take the element from list 
		recursivePrintSubseqTargetSumReducingTarget(originalList, toBePrinted, size, currentIndex + 1, target, currentSum);
	}
	
	public static void printCombinationSumII(List<Integer> org, List<List<Integer>> res, List<Integer> list, int index, int target) {
			if(target == 0) {
				res.add(new ArrayList<>(list));
				return;
			}
			
			for(int i=index; i< org.size(); i++) {
				if(i!=index && org.get(i) == org.get(i-1)) continue;
				if(org.get(i) > target) break;
				
				list.add(org.get(i));
				printCombinationSumII(org,res,list,i+1,target-org.get(i));
				list.remove(list.size()-1);
			}
	}
	
	public static void printAllDistinctSets(List<Integer> org, List<Integer> subsequence, int index, List<List<Integer>> result) {
		result.add(new ArrayList<>(subsequence));
		for(int i=index; i< org.size(); i++) {
			if(i> index && (org.get(i) == org.get(i-1))) {
				continue;
			}
			
			subsequence.add(org.get(i));
			printAllDistinctSets(org,subsequence,i+1,result);
			subsequence.remove(subsequence.size()-1);
		}
	}
	
	public static void palindromePartition(List<List<String>> result, List<String> temp, String s, int index) {
		if(index == s.length()) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i=index; i< s.length();i++) {
			if(isPalindrome(s,index,i)) {
				temp.add(s.substring(index, i+1));
				palindromePartition(result, temp, s,i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static boolean isPalindrome(String s, int low, int high) {
		while(low <= high) {
			if(s.charAt(low++) != s.charAt(high--)) return false;
		}
		return true;
	}
	
	
	public static void possiblePathsInMaze(List<String> result, String path, int row, int col,int[][] maze, int[][] visited){
		if(row == maze.length && col == maze[0].length) {
			result.add(path);
			return;
		}
		
		//Down
		if(row+1 < maze.length && maze[row+1][col] ==1 && visited[row+1][col] == 0) {
			visited[row][col] = 1;
			path = path+"D";
			possiblePathsInMaze(result,path,row+1, col, maze,visited);
			visited[row][col] = 0;
		}
		
		//Left
		if(col-1 >= 0 && maze[row][col-1] ==1 && visited[row][col-1] == 0) {
			visited[row][col] = 1;
			path = path+"L";
			possiblePathsInMaze(result,path,row, col-1, maze,visited);
			visited[row][col] = 0;
		}
		
		//Right
		if(col+1 < maze[0].length && maze[row][col+1] ==1 && visited[row][col+1] == 0) {
			visited[row][col] = 1;
			path = path+"R";
			possiblePathsInMaze(result,path,row, col+1, maze,visited);
			visited[row][col] = 0;
		}
		
		//Up
		if(row-1 >= 0 && maze[row-1][col] ==1 && visited[row-1][col] == 0) {
			visited[row][col] = 1;
			path = path+"U";
			possiblePathsInMaze(result,path,row-1, col, maze,visited);
			visited[row][col] = 0;
		}
	}
	
	public static int towerOfHanoi(int source, int destination, int helper, int disks, int count) {
		if(disks == 1) { // last disc .. move it from source to destination
			count++;
			System.out.println("Move disc "+disks +" from rod "+source +" to rod "+destination );
			return count;
		}
		
		count = towerOfHanoi(source, helper, destination, disks -1,count); // moving n-1 to helper from source	
		count++;
		System.out.println("Move disc "+disks +" from rod "+source +" to rod "+destination );
		count = towerOfHanoi(helper, destination, source, disks-1,count);
		return count;
	}

}
