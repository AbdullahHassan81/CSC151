import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
// use these websites for JSON (https://copilot.microsoft.com/chats/Re6t8zbYA14d2oFy87qFE) 
//(https://jenkov.com/tutorials/java-json/jackson-jsonnode.html) (https://www.javadoc.io/doc/com.fasterxml.jackson.core/jackson-databind/latest/com/fasterxml/jackson/databind/JsonNode.html) 
//The Exchange Rates (https://v6.exchangerate-api.com/v6/590f27b67384db04e619ce5f/latest/USD) (https://app.exchangerate-api.com/dashboard/confirmed)
//This one is not working
//10:58 at 4/21/25
//The issues are Cannot cast from string to converter.JsonNode
//The method asDouble() is undefined for the type String

public class converter{

    public static void main(String[] args) {

        final String API_KEY = "590f27b67384db04e619ce5f"; // Replace with your API key from the currency API
        final String API_URL = "https://v6.exchangerate-api.com/v6/590f27b67384db04e619ce5f/latest/USD" + API_KEY + "/latest/USD";
        final Map<String, Double> exchangeRates = new HashMap<>();

        fetchExchangeRates(); // Fetch initial rates
        // Call a method periodically to refresh the rates (you can adjust the interval)
        Timer timer = new Timer(1000 * 60 * 60, e -> fetchExchangeRates()); // Refresh rates every hour
        timer.start();
        
        // Set up the GUI
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JTextField searchBar = new JTextField();
        searchBar.setBounds(20, 20, 340, 30);
        frame.add(searchBar);

        List<String> sortedCurrencies = new ArrayList<>(exchangeRates.keySet());
        Collections.sort(sortedCurrencies);

        JComboBox<String> currencyDropdown = new JComboBox<>(sortedCurrencies.toArray(new String[0]));
        currencyDropdown.setBounds(20, 70, 340, 30);
        frame.add(currencyDropdown);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(20, 120, 340, 30);
        frame.add(convertButton);

        JLabel outputLabel = new JLabel("");
        outputLabel.setBounds(20, 170, 340, 30);
        frame.add(outputLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String usdInput = searchBar.getText();
                    double usdAmount = Double.parseDouble(usdInput);
                    if (usdAmount <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive amount.");
                        return;
                    }
                    String selectedCurrency = (String) currencyDropdown.getSelectedItem();
                    double convertedAmount = usdAmount * exchangeRates.get(selectedCurrency);
                    outputLabel.setText(String.format("%.2f USD = %.2f %s", usdAmount, convertedAmount, selectedCurrency));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        frame.setVisible(true);
    }

    private static void fetchExchangeRates() {
        try {
            String API_URL = null;
            // Send the request to the API
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            

            class ObjectMapper {

            JsonNode readTree(String toString) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            }

            
            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.toString());
            JsonNode conversionRates = (JsonNode) rootNode.path("conversion_rates");
            
            // Update the exchange rates
            exchangeRates.clear(); // Clear previous rates
            Iterator<String> fieldNames = conversionRates.fieldNames();
            while (fieldNames.hasNext()) {
                String country = fieldNames.next();
                // what data type is this?
                String rate = conversionRates.path(country);
                exchangeRates.put(country, rate.asDouble());
            }
            
            System.out.println("Exchange rates updated.");
        } catch (Exception e) {
            System.err.println("Error fetching exchange rates: " + e.getMessage());
        }
    }

    public static String getAPI_KEY() {
        String API_KEY = null;
        return API_KEY;
    }

    public static Map<String, Double> getExchangeRates() {
        Map<String, Double> exchangeRates = null;
        return exchangeRates;
    }

    private static class exchangeRates {

        private static void clear() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public exchangeRates() {
        }
    }

    private static class JsonNode {

        public JsonNode() {
        }

        private Iterator<String> fieldNames() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        private String path(String country) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}



/* 
//Java Code to Fetch Exhcange Rates
//This one had problems
//10:53pm at 4/21/25

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyRateFetcher {

    // Replace with your API key
    private static final String API_KEY = "YOUR_API_KEY";
    
    // API URL for fetching exchange rates
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    public static void main(String[] args) {
        try {
            // Make an API request
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            
            // Get the response from the API
            Scanner scanner = new Scanner(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            
            while (scanner.hasNext()) {
                response.append(scanner.nextLine());
            }
            
            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.toString());
            
            // Get exchange rates for Middle Eastern and African countries
            JsonNode conversionRates = rootNode.path("conversion_rates");
            
            // Example: Get the exchange rate for some countries (USD to local currency)
            System.out.println("1 USD = " + conversionRates.path("AED").asText() + " AED");
            System.out.println("1 USD = " + conversionRates.path("EGP").asText() + " EGP");
            System.out.println("1 USD = " + conversionRates.path("NGN").asText() + " NGN");
            System.out.println("1 USD = " + conversionRates.path("SAR").asText() + " SAR");
            // Add more currencies as needed
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//With it Automatic Periodic Updates
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CurrencyRateUpdater {
    public static void main(String[] args) {
        // Schedule to update every 24 hours (86400 seconds)
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(CurrencyRateFetcher::main, 0, 24, TimeUnit.HOURS);
    }
}








//Adding Updated Currency With My Code
//this one also works(10:44 on 4/21/25)
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.*;
import com.fasterxml.jackson.databind.*;

public class AbdullahCurrencyConverter {
    
    private static final String API_KEY = "YOUR_API_KEY"; // Replace with your API key from the currency API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private static Map<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        fetchExchangeRates(); // Fetch initial rates
        // Call a method periodically to refresh the rates (you can adjust the interval)
        Timer timer = new Timer(1000 * 60 * 60, e -> fetchExchangeRates()); // Refresh rates every hour
        timer.start();
        
        // Set up the GUI as before...
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JTextField searchBar = new JTextField();
        searchBar.setBounds(20, 20, 340, 30);
        frame.add(searchBar);

        List<String> sortedCurrencies = new ArrayList<>(exchangeRates.keySet());
        Collections.sort(sortedCurrencies);

        JComboBox<String> currencyDropdown = new JComboBox<>(sortedCurrencies.toArray(new String[0]));
        currencyDropdown.setBounds(20, 70, 340, 30);
        frame.add(currencyDropdown);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(20, 120, 340, 30);
        frame.add(convertButton);

        JLabel outputLabel = new JLabel("");
        outputLabel.setBounds(20, 170, 340, 30);
        frame.add(outputLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String usdInput = searchBar.getText();
                    double usdAmount = Double.parseDouble(usdInput);
                    if (usdAmount <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive amount.");
                        return;
                    }
                    String selectedCurrency = (String) currencyDropdown.getSelectedItem();
                    double convertedAmount = usdAmount * exchangeRates.get(selectedCurrency);
                    outputLabel.setText(String.format("%.2f USD = %.2f %s", usdAmount, convertedAmount, selectedCurrency));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        frame.setVisible(true);
    }

    private static void fetchExchangeRates() {
        try {
            // Send the request to the API
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.toString());
            JsonNode conversionRates = rootNode.path("conversion_rates");

            // Update the exchange rates
            exchangeRates.clear(); // Clear previous rates
            Iterator<String> fieldNames = conversionRates.fieldNames();
            while (fieldNames.hasNext()) {
                String country = fieldNames.next();
                exchangeRates.put(country, conversionRates.path(country).asDouble());
            }
            
            System.out.println("Exchange rates updated.");
        } catch (Exception e) {
            System.err.println("Error fetching exchange rates: " + e.getMessage());
        }
    }
}








//its working (tested at 10:39 on 4/21/25)
//Corrected Code
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {

    private static final String API_KEY = "YOUR_API_KEY"; // Replace with your API key from the currency API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private static Map<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        fetchExchangeRates(); // Fetch initial rates
        // Call a method periodically to refresh the rates (you can adjust the interval)
        Timer timer = new Timer(1000 * 60 * 60, e -> fetchExchangeRates()); // Refresh rates every hour
        timer.start();
        
        // Set up the GUI
        JFrame frame = new JFrame("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JTextField searchBar = new JTextField();
        searchBar.setBounds(20, 20, 340, 30);
        frame.add(searchBar);

        List<String> sortedCurrencies = new ArrayList<>(exchangeRates.keySet());
        Collections.sort(sortedCurrencies);

        JComboBox<String> currencyDropdown = new JComboBox<>(sortedCurrencies.toArray(new String[0]));
        currencyDropdown.setBounds(20, 70, 340, 30);
        frame.add(currencyDropdown);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(20, 120, 340, 30);
        frame.add(convertButton);

        JLabel outputLabel = new JLabel("");
        outputLabel.setBounds(20, 170, 340, 30);
        frame.add(outputLabel);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String usdInput = searchBar.getText();
                    double usdAmount = Double.parseDouble(usdInput);
                    if (usdAmount <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive amount.");
                        return;
                    }
                    String selectedCurrency = (String) currencyDropdown.getSelectedItem();
                    double convertedAmount = usdAmount * exchangeRates.get(selectedCurrency);
                    outputLabel.setText(String.format("%.2f USD = %.2f %s", usdAmount, convertedAmount, selectedCurrency));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        frame.setVisible(true);
    }

    private static void fetchExchangeRates() {
        try {
            // Send the request to the API
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.toString());
            JsonNode conversionRates = rootNode.path("conversion_rates");

            // Update the exchange rates
            exchangeRates.clear(); // Clear previous rates
            Iterator<String> fieldNames = conversionRates.fieldNames();
            while (fieldNames.hasNext()) {
                String country = fieldNames.next();
                exchangeRates.put(country, conversionRates.path(country).asDouble());
            }
            
            System.out.println("Exchange rates updated.");
        } catch (Exception e) {
            System.err.println("Error fetching exchange rates: " + e.getMessage());
        }
    }

    public static String getAPI_KEY() {
        return API_KEY;
    }
}
*/