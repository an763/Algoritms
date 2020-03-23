
public class Collatz {
	
	public static int getNumSteps(int num) {
		if(num == 1) return 0;
		if(num%2 ==0) {
			return getNumSteps(num/2) +1;
		}else {
			return getNumSteps(3*num +1) +1;
		}
	}
	
	public static void main(String args[]) {
		int steps2 = getNumSteps(2);
		int steps6 = getNumSteps(6);
		int steps50 = getNumSteps(50);
		int steps27 = getNumSteps(27);
		
		System.out.println("The number of steps2 :: "+steps2);
		System.out.println("The number of steps6 :: "+steps6);
		System.out.println("The number of steps27 :: "+steps27);
		System.out.println("The number of steps50 :: "+steps50);
		
	}

}
