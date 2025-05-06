import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class JordiCurrencyConverter {
    public static void main(String[] args) {
        // Define exchange rates (static for now, can be updated dynamically)
        Map<String, Double> exchangeRates = new LinkedHashMap<>();
        addExchangeRates(exchangeRates);

        // Get USD amount from user
        String usdInput = JOptionPane.showInputDialog("Enter amount in USD:");
        if (usdInput == null) return; // Exit if canceled
        double usdAmount;
        try {
            usdAmount = Double.parseDouble(usdInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value.");
            return;
        }

        // Create searchable JComboBox
        JComboBox<String> comboBox = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        comboBox.setEditable(true);

        // Add search functionality
        JTextField editor = (JTextField) comboBox.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String input = editor.getText().toLowerCase();
                comboBox.removeAllItems();

                for (String currency : exchangeRates.keySet()) {
                    if (currency.toLowerCase().contains(input)) {
                        comboBox.addItem(currency);
                    }
                }

                editor.setText(input);
                comboBox.showPopup();
            }
        });

        // Show the dropdown inside JOptionPane
        int option = JOptionPane.showConfirmDialog(null, comboBox, "Select a currency",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option != JOptionPane.OK_OPTION) return; // Exit if canceled

        String selectedCurrency = (String) comboBox.getSelectedItem();
        if (selectedCurrency != null && exchangeRates.containsKey(selectedCurrency)) {
            double convertedAmount = usdAmount * exchangeRates.get(selectedCurrency);
            JOptionPane.showMessageDialog(null,
                    String.format("%.2f USD = %.2f %s", usdAmount, convertedAmount, selectedCurrency));
        } else {
            JOptionPane.showMessageDialog(null, "Invalid selection.");
        }
    }

    // Method to add exchange rates and remove duplicates
    private static void addExchangeRates(Map<String, Double> exchangeRates) {
        String[][] currencies = {
            {"Afghanistan (AFN)", "71.60"}, {"Armenia (AMD)", "391.32"}, {"Bahrain (BHD)", "0.38"},
            {"Cyprus (EUR)", "0.90"}, {"Egypt (EGP)", "50.59"}, {"Georgia (GEL)", "2.76"},
            {"Iran (IRR)", "421112.50"}, {"Iraq (IQD)", "1309.88"}, {"Israel (ILS)", "3.70"},
            {"Jordan (JOD)", "0.71"}, {"Kuwait (KWD)", "0.31"}, {"Lebanon (LBP)", "89596.0"},
            {"Oman (OMR)", "0.38"}, {"Palestine (ILS)", "3.70"}, {"Qatar (QAR)", "3.65"},
            {"Saudi Arabia (SAR)", "3.75"}, {"Syria (SYP)", "13002.0"}, {"Turkey (TRY)", "37.95"},
            {"United Arab Emirates (AED)", "3.67"}, {"Yemen (YER)", "245.65"},
            {"Algeria (DZD)", "132.87"}, {"Angola (AOA)", "912.00"}, {"Benin (XOF)", "593.50"},
            {"Botswana (BWP)", "13.84"}, {"Burkina Faso (XOF)", "593.50"}, {"Burundi (BIF)", "2971.20"},
            {"Cabo Verde (CVE)", "99.77"}, {"Cameroon (XAF)", "593.41"}, {"Central African Republic (XAF)", "593.41"},
            {"Chad (XAF)", "593.41"}, {"Comoros (KMF)", "453.50"}, {"Democratic Republic of the Congo (CDF)", "2905.93"},
            {"Republic of the Congo (XAF)", "593.41"}, {"Djibouti (DJF)", "178.07"}, {"Egypt (EGP)", "50.24"},
            {"Equatorial Guinea (XAF)", "593.41"}, {"Eritrea (ERN)", "15.00"}, {"Eswatini (ZAR)", "18.78"},
            {"Eswatini (SZL)", "18.85"}
        };

        // Use a Set to check for duplicates
        Set<String> uniqueCurrencies = new HashSet<>();
        for (String[] currency : currencies) {
            if (!uniqueCurrencies.contains(currency[0])) {
                uniqueCurrencies.add(currency[0]);
                exchangeRates.put(currency[0], Double.parseDouble(currency[1]));
            }
        }
    }
}
