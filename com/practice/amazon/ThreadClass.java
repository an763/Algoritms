package com.practice.amazon;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * 
In the context of Java threads, a Future represents the result of an asynchronous computation. It is part of the Executor Framework
 and allows you to work with tasks that execute in a separate thread, while providing a way to retrieve the result or check 
 the task's status at a later time.

Key Concepts of Future:
Asynchronous Execution:

A Future is used to handle the result of a computation that is executed asynchronously (in a separate thread).
When you submit a task to an ExecutorService (such as submit() method), it immediately returns a Future object, even though the
 task might still be running.
Retrieving Results:

You can use the get() method of the Future object to retrieve the result of the computation once it is done. This method blocks 
the calling thread until the result is available.
Checking Task Status:

The Future allows you to check if the task is completed with the isDone() method.
You can also cancel the task if it hasn’t finished execution using the cancel() method.
Common Methods in Future:
get():

Waits for the task to complete and retrieves the result. If the task hasn't finished yet, this method blocks until the task completes.
It can throw an InterruptedException if the thread was interrupted while waiting, and an ExecutionException if the task threw an exception.
isDone():

Returns true if the task has finished (either successfully, with an error, or by cancellation), and false if it's still running.
cancel(boolean mayInterruptIfRunning):

Attempts to cancel the execution of the task.
If the task is already completed, it will not be canceled.
If mayInterruptIfRunning is set to true, the task will be interrupted if it is running.
isCancelled():

Returns true if the task was successfully canceled.
Example of Using Future:
Here’s an example that demonstrates how a Future can be used with an ExecutorService to handle the result of a concurrent computation:
 *
 */

public class ThreadClass {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create an ExecutorService with a single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        // Submit a Callable task that returns a result
        Future<Integer> future = executor.submit(new MyCallable());
        
        // Do some other tasks while the Callable is executing asynchronously
        System.out.println("Doing other work while waiting for the result...");
        
        // Check if the task is done
        if (!future.isDone()) {
            System.out.println("Task is not done yet.");
        }
        
        // Retrieve the result (blocks until the result is available)
        Integer result = future.get();  // This will block until the task finishes
        System.out.println("Result from the future: " + result);
        
        // Shut down the ExecutorService
        executor.shutdown();
        
        multipleFutureExample();
    }
	
	
	public static void multipleFutureExample() {
		ExecutorService executor = Executors.newFixedThreadPool(3);
        
        Future<String> future1 = executor.submit(new Task(1));
        Future<String> future2 = executor.submit(new Task(2));
        Future<String> future3 = executor.submit(new Task(3));
        
        // Do other work while waiting for tasks to complete
        
        // Get results (blocks if the task isn't done)
        try {
			System.out.println(future1.get());
		
        System.out.println(future2.get());
        System.out.println(future3.get());
        
        // Shutdown the executor
        executor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        // Simulate a long-running task
        Thread.sleep(2000);
        return 10;  // Return some result
    }
}

/**
 * Explanation of Example:
Callable:

We use Callable instead of Runnable here because Callable can return a result (in this case, an Integer) and can throw exceptions.
The call() method in MyCallable simulates some work (e.g., sleeping for 2 seconds) and returns the result 10.
Submitting a Task:

The task is submitted to the ExecutorService using the submit() method, which returns a Future object.
Future Object:

While the task is running asynchronously, we can check its status using isDone(), or we can retrieve the result using get() (which will block if the task hasn't finished yet).
After 2 seconds, the get() method will return 10, which is the result from the call() method.
Executor Shutdown:

Finally, the executor.shutdown() method ensures the executor service is properly terminated after task execution.
Key Points About Future:
Blocking Nature:

The get() method will block the calling thread until the task completes. This can be useful when you need the result but should be avoided if you need to continue other work while waiting.
Non-blocking Checks:

You can check if a task is done without blocking using the isDone() method. This allows for non-blocking behavior where you periodically check whether the task has completed.
Cancelable Tasks:

You can use the cancel() method to stop a task if it is still running. This can be useful when the result is no longer needed, or if the task is taking too long to complete.
Handling Multiple Futures:

If you have multiple tasks running concurrently, you can store multiple Future objects and check their statuses or get their results independently.
A More Complex Example with Multiple Futures:
 */


class Task implements Callable<String> {
    private final int id;
    
    Task(int id) {
        this.id = id;
    }
    
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Task " + id + " completed";
    }
}
