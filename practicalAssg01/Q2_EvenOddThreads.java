// Q2: Thread Creation using Runnable interface
// Like giving instructions to workers!

class EvenPrinter implements Runnable {
    // This prints even numbers (2, 4, 6, 8...)
    public void run() {
        System.out.println("👷 Even Worker started!");
        
        for (int i = 2; i <= 20; i += 2) {
            System.out.println("Even: " + i);
            
            try {
                Thread.sleep(300); // Wait a little bit
            } catch (InterruptedException e) {
                System.out.println("Error in even thread!");
            }
        }
        
        System.out.println("✅ Even Worker finished!\n");
    }
}

class OddPrinter implements Runnable {
    // This prints odd numbers (1, 3, 5, 7...)
    public void run() {
        System.out.println("👷 Odd Worker started!");
        
        for (int i = 1; i <= 20; i += 2) {
            System.out.println("Odd: " + i);
            
            try {
                Thread.sleep(300); // Wait a little bit
            } catch (InterruptedException e) {
                System.out.println("Error in odd thread!");
            }
        }
        
        System.out.println("✅ Odd Worker finished!\n");
    }
}

public class Q2_EvenOddThreads {
    public static void main(String[] args) {
        System.out.println("🎯 Starting Even and Odd Number Printer\n");
        
        // Step 1: Create the instruction papers (Runnable objects)
        EvenPrinter evenJob = new EvenPrinter();
        OddPrinter oddJob = new OddPrinter();
        
        // Step 2: Hire workers and give them instructions (Create Thread objects)
        Thread evenWorker = new Thread(evenJob);
        Thread oddWorker = new Thread(oddJob);
        
        // Step 3: Tell workers to start working!
        evenWorker.start();
        oddWorker.start();
        
        System.out.println("🚀 Both workers are now printing numbers!\n");
    }
}

/*
=================================================================
EXPLANATION FOR A 5-YEAR-OLD:
=================================================================

🎯 WHAT IS RUNNABLE?

Think of it like this:
- You write down instructions on a piece of paper 📝
- You give that paper to a worker 👷
- The worker reads and follows the instructions!

RUNNABLE = The instruction paper 📝
THREAD = The worker who follows instructions 👷

=================================================================
STEP-BY-STEP BREAKDOWN:
=================================================================

STEP 1: Write Instructions (implements Runnable)
-------------------------------------------------
class EvenPrinter implements Runnable {
    public void run() {
        // Instructions: Print 2, 4, 6, 8...
    }
}

This is like writing: "Dear Worker, please print all even numbers"

STEP 2: Create the Instruction Papers
-------------------------------------------------
EvenPrinter evenJob = new EvenPrinter();
OddPrinter oddJob = new OddPrinter();

Now we have 2 instruction papers ready!

STEP 3: Hire Workers and Give Instructions
-------------------------------------------------
Thread evenWorker = new Thread(evenJob);
Thread oddWorker = new Thread(oddJob);

We hired 2 workers:
- Worker 1 gets the "even numbers" instruction
- Worker 2 gets the "odd numbers" instruction

STEP 4: Tell Workers to Start!
-------------------------------------------------
evenWorker.start();
oddWorker.start();

Both workers start working at THE SAME TIME!

=================================================================
WHY USE RUNNABLE INSTEAD OF EXTENDING THREAD?
=================================================================

❌ PROBLEM with "extends Thread":
class MyClass extends Thread {
    // Now MyClass can ONLY extend Thread
    // Cannot extend any other class!
}

✅ SOLUTION with "implements Runnable":
class MyClass implements Runnable {
    // Can still extend another class if needed!
    // More flexible! 🎉
}

=================================================================
REAL LIFE ANALOGY:
=================================================================

SCENARIO: Restaurant Kitchen 🍳

Runnable = Recipe cards
Thread = Chefs who cook

Chef 1 gets Recipe Card "Make Pizza" 🍕
Chef 2 gets Recipe Card "Make Burger" 🍔

Both chefs cook at the SAME TIME!
That's multithreading with Runnable!

=================================================================
WHAT HAPPENS IN THE CODE:
=================================================================

Main thread starts
    ↓
Creates 2 instruction papers (Runnable)
    ↓
Hires 2 workers (Thread)
    ↓
Both workers start at SAME TIME
    ↓
Even Worker prints: 2, 4, 6, 8, 10, 12, 14, 16, 18, 20
Odd Worker prints: 1, 3, 5, 7, 9, 11, 13, 15, 17, 19
    ↓
Both finish and stop!

=================================================================
SAMPLE OUTPUT (numbers will be MIXED):
=================================================================

🎯 Starting Even and Odd Number Printer

🚀 Both workers are now printing numbers!

👷 Even Worker started!
👷 Odd Worker started!
Even: 2
Odd: 1
Even: 4
Odd: 3
Odd: 5
Even: 6
Even: 8
Odd: 7
Odd: 9
Even: 10
Even: 12
Odd: 11
Odd: 13
Even: 14
Even: 16
Odd: 15
Odd: 17
Even: 18
Even: 20
Odd: 19
✅ Even Worker finished!

✅ Odd Worker finished!

NOTE: The order might be different each time you run!
That's because both workers are working SIMULTANEOUSLY!

=================================================================
KEY CONCEPTS TO REMEMBER:
=================================================================

1️⃣ RUNNABLE = Instructions (what to do)
2️⃣ THREAD = Worker (who does it)
3️⃣ run() method = The actual work
4️⃣ start() method = Begin the work
5️⃣ Both threads run AT THE SAME TIME!

🎓 IMPORTANT: 
- Call thread.start() NOT thread.run()
- start() creates a new thread
- run() just calls the method normally (no new thread!)

=================================================================
QUICK COMPARISON:
=================================================================

METHOD 1: extends Thread
-------------------------
class MyThread extends Thread {
    public void run() { }
}
MyThread t = new MyThread();
t.start();

METHOD 2: implements Runnable (BETTER!)
-------------------------
class MyJob implements Runnable {
    public void run() { }
}
Thread t = new Thread(new MyJob());
t.start();

✅ Method 2 is BETTER because:
- More flexible
- Can extend other classes
- Cleaner code separation

=================================================================
*/