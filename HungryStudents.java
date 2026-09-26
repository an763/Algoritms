import java.util.LinkedList;
import java.util.Queue;


public class HungryStudents {

    public int hungryStudents(int [] students, int [] sandwiches){
        Queue<Integer> studentQueue = new LinkedList<>();
        Queue<Integer> sandwichQueue = new LinkedList<>();
        for(int i= 0; i<students.length ; i++){
            studentQueue.add(students[i]);
            sandwichQueue.add(sandwiches[i]);
        }

        while(!sandwichQueue.isEmpty()){
            if(studentQueue.contains(sandwichQueue.peek())){
                if(sandwichQueue.peek() == studentQueue.peek()){
                    sandwichQueue.poll();
                    studentQueue.poll();
                }else{
                    int studentChoice = studentQueue.poll();
                    studentQueue.add(studentChoice);
                }
            }else{
                return studentQueue.size();
            }
        }
        return 0;
    }
}
