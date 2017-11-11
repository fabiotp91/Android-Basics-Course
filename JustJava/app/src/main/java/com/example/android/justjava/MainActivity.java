/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText textName = findViewById(R.id.name_text);
        String getName = textName.getText().toString();

        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(getName, price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //Only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, getName));
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(MainActivity.this, "You can´t order more than 100 cups!",
                    Toast.LENGTH_LONG).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(MainActivity.this, "You can´t order less than 0 cups!",
                    Toast.LENGTH_LONG).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int basePrice = 5;

        if(addWhippedCream){
            basePrice = basePrice + 1;
        }

        if(addChocolate){
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;
    }

    /**
     * Create summary of the order.
     *
     * @param price           of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @return text summary
     */
    private String createOrderSummary(String customerName,int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = getString(R.string.order_summary_name, customerName);
        priceMessage += "\n\n" + getString(R.string.order_summary_whipped_cream, addWhippedCream);
        priceMessage += "\n\n" + getString(R.string.order_summary_chocolate, addChocolate);
        priceMessage += "\n\n" + getString(R.string.order_summary_quantity, quantity);
        priceMessage += "\n\n" + getString(R.string.order_summary_price,
                NumberFormat.getCurrencyInstance().format(price));
        priceMessage += "\n\n" + getString(R.string.thank_you);
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
}