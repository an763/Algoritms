import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShortestSalesPath {

	static class Node {
		int cost;
		Node[] children;
		Node parent;

		Node(int cost) {
			this.cost = cost;
			children = null;
			parent = null;
		}
	}

	static class SalesPath {
		int min_cost = Integer.MAX_VALUE;
		int currentCost = 0;

		int getCheapestCost(Node rootNode) {
			if (rootNode.children == null)
				return rootNode.cost;

			for (Node child : rootNode.children) {
				currentCost = rootNode.cost + getCheapestCost(child);
				if (currentCost < min_cost)
					min_cost = currentCost;
			}
			

			return min_cost;
		}
	}

	static int sockMerchant(int n, int[] ar) {

		Map<Integer, Integer> colorMap = new HashMap<>();
		int existing_count = 0;

		for (int i = 0; i < n; i++) {
			if (colorMap.containsKey(ar[i])) {
				existing_count = colorMap.get(ar[i]);
				colorMap.put(ar[i], existing_count + 1);
			} else {
				colorMap.put(ar[i], 1);
			}
		}

		Iterator<Integer> vals = colorMap.values().iterator();
		int count = 0;
		while (vals.hasNext()) {
			count += (vals.next()) / 2;
		}

		return count;

	}

	public static void main(String args[]) {
		int[] arr = { 1, 1, 3, 1, 2, 1, 3, 3, 3, 3 };
		int count = sockMerchant(10, arr);
		System.out.println("The count is :: " + count);
		int valleyCount = countingValleys(8, "UDDDUDUU");
		System.out.println("The valleyCount is :: " + valleyCount);
		testTree();
	}

	static int countingValleys(int n, String s) {
		int valleyCount = 0;
		int currentLevel = 0;
		char[] chrArr = s.toCharArray();
		for (int i = 0; i < chrArr.length; i++) {
			if (currentLevel == 0 && chrArr[i] == 'D') {
				valleyCount++;
			}
			if (chrArr[i] == 'U') {
				currentLevel++;
			} else {
				currentLevel--;
			}

		}
		return valleyCount;

	}

	static void findSum(SumNode root, List<Integer> sumList, int runningSum) {
		if (root == null) {
			return;
		}

		int newRunningSum = runningSum + root.value;
		if (root.left == null && root.right == null) {
			sumList.add(newRunningSum);
			return;
		}

		findSum(root.left, sumList, newRunningSum);
		findSum(root.right, sumList, newRunningSum);
	}
	
	
	static void findStrSum(SumNode root, List<String> sumList, String runningSum) {
		if (root == null) {
			return;
		}

		String newRunningSum = runningSum + root.value;
		if (root.left == null && root.right == null) {
			sumList.add(newRunningSum);
			return;
		}

		findStrSum(root.left, sumList, newRunningSum);
		findStrSum(root.right, sumList, newRunningSum);
	}

	static class SumNode {
		int value;
		SumNode left;
		SumNode right;

		SumNode(int value, SumNode left, SumNode right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public static void testTree() {
		SumNode sumNode3 = new SumNode(3, null, null);
		SumNode sumNode4 = new SumNode(4, null, null);
		SumNode sumNode2 = new SumNode(2, sumNode3, sumNode4);
		SumNode sumNode6 = new SumNode(6, null, null);
		SumNode sumNode5 = new SumNode(5, sumNode6, null);
		SumNode sumNode1 = new SumNode(1, sumNode2, sumNode5);
		List<String> sumList = new ArrayList<>();
		findStrSum(sumNode1, sumList, "");
		System.out.println("The sumList is :: " + sumList);

	}

	/*
	 *      1
	 *     2 5 
	 *    3 4 6
	 * 
	 * 
	 * [123, 124, 156]
	 * 
	 * [6, 3, 7, 6, 12, 7, 6]
	 * 
	 * [6, 3, 3, 7, 6, 2, 1, 12, 7, 6, 6, 1] [6, 3, 7, 6, 3, 2, 12, 7, 6, 6, 1, 1]
	 * 
	 */

}
