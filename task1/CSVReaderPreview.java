package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CSVReaderPreview {
    public static void main(String[] args) {
        // TO DO: Write your code below 
        String filePath = "dataset/dataset.csv";
        String row;
        try{
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String headerRow = br.readLine();
            if (headerRow == null) {
                System.out.println("Empty CSV");
                return;
            }

            System.out.println("=== Data Preview ===\n");
            
            String[] columnHeaders = headerRow.split(",");
            System.out.println("Columns:");
            for (String header : columnHeaders) {
                System.out.print(header + " ");
            }
            System.out.println("\nTotal columns: " + columnHeaders.length);
            System.out.println("\nFirst 5 Records:\n");

            int recordCount = 0;

            //first 5 data rows
            while ((row = br.readLine()) != null && recordCount < 5) {
                String[] recordFields = row.split(",");
                System.out.println(String.join(" ", recordFields));
                recordCount++;
            }

            //remaining records
            while (br.readLine() != null) {
                recordCount++;
            }

            System.out.println("\nTotal Records excluding header: " + recordCount);

        } catch (IOException e) {
            System.err.println("An error occurred: ");
            e.printStackTrace();
        }
    }
}