package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//function modules

public class CsvUtils {

    private static final String FILE_PATH = "flight_data.csv";

    public static boolean writeToCsv(String flightName, String airlineName, String userName) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.append(flightName).append(",")
                  .append(airlineName).append(",")
                  .append(userName).append("\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<String[]> readFromCsv() {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                records.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

    public static List<String[]> readFlightsFromCsv() {
        String flightFilePath = "flights_data.csv";
        List<String[]> flightRecords = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(flightFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                flightRecords.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flightRecords;
    }

    public static boolean reduceAvailableSeats(String flightNumber) {
        String flightFilePath = "flights_data.csv";
        List<String[]> flightRecords = new ArrayList<>();
        boolean updated = false;
    
        try (BufferedReader br = new BufferedReader(new FileReader(flightFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(",");
                if (record[1].equals(flightNumber)) {
                    int availableSeats = Integer.parseInt(record[4]); // 5th attribute is the available seats
                    if (availableSeats > 0) {
                        record[4] = String.valueOf(availableSeats - 1);
                        updated = true;
                    }
                }
                flightRecords.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        if (updated) {
            try (FileWriter writer = new FileWriter(flightFilePath)) {
                for (String[] record : flightRecords) {
                    writer.append(String.join(",", record)).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    
        return updated;
    }
    
}
