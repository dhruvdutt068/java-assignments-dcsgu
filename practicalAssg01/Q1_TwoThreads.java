// Q1: Thread Creation using Thread class
// Think of threads like two friends doing different tasks at the same time!

class NumberThread extends Thread {
    // This thread prints numbers 1 to 10
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500); // Wait half a second (like taking a breath!)
            } catch (Exception e) {
                System.out.println("Oops! Something went wrong");
            }
        }
    }
}

class AlphabetThread extends Thread {
    // This thread prints alphabets A to J
    public void run() {
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.println("Alphabet: " + c);
            try {
                Thread.sleep(500); // Wait half a second
            } catch (Exception e) {
                System.out.println("Oops! Something went wrong");
            }
        }
    }
}

public class Q1_TwoThreads {
    public static void main(String[] args) {
        // Create two friends (threads)
        NumberThread friend1 = new NumberThread();
        AlphabetThread friend2 = new AlphabetThread();
        
        // Tell both friends to start their work!
        friend1.start();
        friend2.start();
        
        System.out.println("Both friends are working together!");
    }
}

/* 
EXPLANATION FOR A 5-YEAR-OLD:
================================
Imagine you have two friends:
- Friend 1 counts numbers: 1, 2, 3... up to 10
- Friend 2 says alphabets: A, B, C... up to J

Instead of waiting for one friend to finish before the other starts,
BOTH friends talk at the same time! That's what threads do!

OUTPUT will look like (mixed up):
Number: 1
Alphabet: A
Number: 2
Alphabet: B
... and so on!
*/