import java.io.*;

// Thread 1: Read from a file
class FileReaderThread extends Thread {
    private String fileName;

    FileReaderThread(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Reading File:");

            while ((line = br.readLine()) != null) {
                System.out.println("Read: " + line);
                Thread.sleep(300); // slow down to show multi-threading
            }

        } catch (Exception e) {
            System.out.println("Error reading file: " + e);
        }
    }
}

// Thread 2: Write to a file
class FileWriterThread extends Thread {
    private String fileName;

    FileWriterThread(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {

            for (int i = 1; i <= 5; i++) {
                String text = "This is line " + i;
                bw.write(text);
                bw.newLine();

                System.out.println("Written: " + text);
                Thread.sleep(500); // slow down to show multi-threading
            }

        } catch (Exception e) {
            System.out.println("Error writing file: " + e);
        }
    }
}

// Main class
public class MultiThreadFileHandling {
    public static void main(String[] args) {

        FileReaderThread reader = new FileReaderThread("input.txt");
        FileWriterThread writer = new FileWriterThread("output.txt");

        reader.start();  // Thread for reading
        writer.start();  // Thread for writing
    }
}
