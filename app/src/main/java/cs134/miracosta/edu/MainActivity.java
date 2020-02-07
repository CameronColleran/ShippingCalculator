/**
 * (Controller) Class which feeds data from ShipItem to activity_main
 *
 * @author Cameron Colleran
 */
package cs134.miracosta.edu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Locale;
import cs134.miracosta.edu.Model.ShipItem;

public class MainActivity extends AppCompatActivity
{
    /**
     * Instance variables
     * Bridging view and model
     */

    /** ShipItem object to store data and do calculations */
    ShipItem shipItem;
    /** WeightEditText variable to link up to view */
    private EditText weightEditText;
    /** BaseCostTextView variable to link up to view */
    private TextView baseCostTextView;
    /** AddedCostTextView variable to link up to view */
    private TextView addedCostTextView;
    /** TotalCostTextView variable to link up to view */
    private TextView totalCostTextView;
    /** NumberFormat object to help format currency output in text views */
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wiring up instance variables
        shipItem = new ShipItem();
        weightEditText = findViewById(R.id.weightEditText);
        baseCostTextView = findViewById(R.id.baseCostTextView);
        addedCostTextView = findViewById(R.id.addedCostTextView);
        totalCostTextView = findViewById(R.id.totalCostTextView);

        /**
         * Reading data from weightEditText and storing in shipItem
         */
        weightEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                // Read input from weightEditText and store in shipItem (model)
                try
                {
                    double weight = Double.parseDouble(weightEditText.getText().toString());
                    shipItem.setWeight(weight);
                }
                catch (NumberFormatException e)
                {
                    shipItem.setWeight(0.0);
                }
                // Updating text views
                calculatePayments();
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

    }

    /**
     * Setting Text Views to match up to data in the ShipItem object (model)
     */
    public void calculatePayments()
    {
        baseCostTextView.setText(currency.format(shipItem.getBaseCost()));
        addedCostTextView.setText(currency.format(shipItem.getAddedCost()));
        totalCostTextView.setText(currency.format(shipItem.getTotalCost()));
    }


}
