import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrConvert {

    private static final String API_KEY = "590f27b67384db04e619ce5f"; // Replace with your API key from the currency API
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private static Map<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        fetchExchangeRates(); // Fetch initial rates
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
}