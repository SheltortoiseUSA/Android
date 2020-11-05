package com.sheltortoiseusa.coffeecorner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Coffee receipt;

    private TextView quantityView;

    private TextView whippingCreamStatement;
    private TextView chocolateStatement;
    private TextView quantityViewStatement;
    private TextView totalCostStatement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);

        receipt = new Coffee();

        quantityView = (TextView) findViewById(R.id.textView3);

        whippingCreamStatement = (TextView) findViewById(R.id.textView5);
        chocolateStatement = (TextView) findViewById(R.id.textView6);
        quantityViewStatement = (TextView) findViewById(R.id.textView7);
        totalCostStatement = (TextView) findViewById(R.id.textView8);
    }
    public void toggleWhippingCream(View view) {
        receipt.setHasWhippingCream();

        whippingCreamStatement.setText("Has Whipping Cream: " + receipt.getWhippingCream());
    }
    public void toggleChocolate(View view) {
        receipt.setHasChocolate();

        chocolateStatement.setText("Has Chocolate: " + receipt.getChocolate());
    }
    public void increaseQuantity(View view) {
        receipt.increment();

        quantityView.setText(receipt.getQuantity());
        quantityViewStatement.setText("Quantity: " + receipt.getQuantity());
    }
    public void decreaseQuantity(View view) {
        receipt.decrement();

        quantityView.setText(receipt.getQuantity());
        quantityViewStatement.setText("Quantity: " + receipt.getQuantity());
    }
    public void completeOrder(View view) {
        totalCostStatement.setText("Total cost: $" + receipt.computeOrder());

        String message = (whippingCreamStatement.getText() + "\n" + chocolateStatement.getText() +
                "\n" + quantityViewStatement.getText() + "\n" + totalCostStatement.getText());

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:tylershelter@yahoo.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
