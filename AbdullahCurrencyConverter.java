import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

//add a search bar
//add a droup down bar (with JOPTION)
//also make something that looks for duplicates
// currency of the date of 4/03/2025

public class AbdullahCurrencyConverter {
    public static void main(String[] args)
    {
        // Define exchange rates (static for now, can be updated dynamically)
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("Afghanistan (AFN)", 71.60);
        exchangeRates.put("Armenia (AMD)", 391.32);
        exchangeRates.put("Bahrain (BHD)", 0.38);
        exchangeRates.put("Cyprus (EUR)", 0.90);
        exchangeRates.put("Egypt (EGP)", 50.59);
        exchangeRates.put("Georgia (GEL)", 2.76);
        exchangeRates.put("Iran (IRR)", 421112.50);
        exchangeRates.put("Iraq (IQD)", 1309.88 );
        exchangeRates.put("Israel (ILS)", 3.70);
        exchangeRates.put("Jordan (JOD)", 0.71);
        exchangeRates.put("Kuwait (KWD)", 0.31 );
        exchangeRates.put("Lebanon (LBP)", 89596.);
        exchangeRates.put("Oman (OMR)", 0.38);
        exchangeRates.put("Palestine (ILS)", 3.70);
        exchangeRates.put("Qatar (QAR)", 3.65);
        exchangeRates.put("Saudi Arabia (SAR)", 3.75);
        exchangeRates.put("Syria (SYP)", 13002.);
        exchangeRates.put("Turkey (TRY)", 37.95);
        exchangeRates.put("United Arab Emirates (AED)", 3.67);
        exchangeRates.put("Yemen (YER)", 245.65);
        //The next 54 are African count
        //The documents was a different documents
        exchangeRates.put("Algeria (DZD)", 132.87);
        exchangeRates.put("Angola (AOA)", 912.00);
        exchangeRates.put("Benin (XOF)", 593.50);
        exchangeRates.put("Botswana (BWP)", 13.84);
        exchangeRates.put("Burkina Faso (XOF)", 593.50);
        exchangeRates.put("Burundi (BIF)", 2971.20);
        exchangeRates.put("Cabo Verde (CVE)", 99.77);
        exchangeRates.put("Cameroon (XAF)", 593.41);
        exchangeRates.put("Central African Republic (XAF)", 593.41);
        exchangeRates.put("Chad (XAF)", 593.41);
        exchangeRates.put("Comoros (KMF)", 453.50);
        exchangeRates.put("Democratic Republic of the Congo (CDF)", 2905.93);
        exchangeRates.put("Republic of the Congo (XAF)", 593.41);
        exchangeRates.put("Djibouti (DJF)", 178.07);
        exchangeRates.put("Egypt (EGP)", 50.24);
        exchangeRates.put("Equatorial Guinea (XAF)", 593.41);
        exchangeRates.put("Eritrea (ERN)",  15.00);
        exchangeRates.put("Eswatini (ZAR)", 18.78);
        exchangeRates.put("Eswatini (SZL)", 18.85);
        exchangeRates.put("Ethiopia (ETB)", 131.63);
        exchangeRates.put("Gabon (XAF)", 593.41);
        exchangeRates.put("Gambia (GMD)", 71.50);
        exchangeRates.put("Ghana (GHS)", 15.50);
        exchangeRates.put("Guinea (GNF)", 8653.92);
        exchangeRates.put("Guinea-Bissau (XOF)", 593.50);
        exchangeRates.put("Ivory Coast (XOF)", 593.50);
        exchangeRates.put("Kenya (KES)", 129.25);
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");
        exchangeRates.put(" ");


        // Get USD amount from user
        String usdInput = JOptionPane.showInputDialog("Enter amount in USD:");
        double usdAmount = Double.parseDouble(usdInput);

        // Select currency
        Object[] currencies = exchangeRates.keySet().toArray();
        String selectedCurrency = (String) JOptionPane.showInputDialog(
                null,
                "Select a currency:",
                "Currency Converter",
                JOptionPane.QUESTION_MESSAGE,
                null,
                currencies,
                currencies[0]);
        // Convert currency
        double convertedAmount = usdAmount * exchangeRates.get(selectedCurrency);

        // Display result
        JOptionPane.showMessageDialog(null, 
                String.format("%.2f USD = %.2f %s", usdAmount, convertedAmount, selectedCurrency)); 
    }
public static void switch_method(){

}
    
}
