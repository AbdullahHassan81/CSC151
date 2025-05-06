 //Java Code to Fetch Exhcange Rates
 //This one is having problems (JsonNode and ObjectMapper cannot be resloved to a type)
 //With it Automatic Periodic Updates
 import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
 
 public class CurrencyRateFetcher {
 
     // Replace with your API key
     private static final String API_KEY = "590f27b67384db04e619ce5f";
     
     // API URL for fetching exchange rates
     private static final String API_URL = "https://v6.exchangerate-api.com/v6/590f27b67384db04e619ce5f/latest/USD" + API_KEY + "/latest/USD";
 
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
 
 public class CurrencyRateUpdater {
     public static void main(String[] args) {
         // Schedule to update every 24 hours (86400 seconds)
         ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
         scheduler.scheduleAtFixedRate(CurrencyRateFetcher::main, 0, 24, TimeUnit.HOURS);
     }
 }
 