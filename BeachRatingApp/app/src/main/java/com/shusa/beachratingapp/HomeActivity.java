package com.shusa.beachratingapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private final String CLASS_TAG = this.getClass().getSimpleName();

    // ArrayList to Store Beach Objects and its associated Recycler View.
    private final ArrayList<Beach> BEACHES = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.i(CLASS_TAG, String.valueOf(R.string.log_entered_function));

        initialize();
        final RecyclerView RECYCLER_VIEW = findViewById(R.id.home_beach_rv);

        // 5) Once stored with OOP, we must populate the recycler view with the proper data.
        final BeachAdapter BEACH_ADAPTER = new BeachAdapter(this, BEACHES);
        RECYCLER_VIEW.setAdapter(BEACH_ADAPTER);
        RECYCLER_VIEW.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initialize() {
        // fetchLatestXML()
        // 1) This function would reach out to the AWS for the latest XML of supported beaches.
            // Restful or AWS API intent system are both options for this task.
        // 2) This function would also download the XML from the AWS and overwrite the local "lists.xml."
            // Limitation: Fetch would only happen on first time startup of application.

        // validateXML()
        // 3) this function would validate that the xml is parseable

        // 4) The next step is to extract the data from the xml and store the XML Data into beach objects.
            // Limitation: Need a Dynamic Way to Get X beaches --> Cannot dynamically call "R.array.x" in this setup.
        storeBeachBundle(this.getResources().getStringArray(R.array.boardwalk_beach));
        storeBeachBundle(this.getResources().getStringArray(R.array.safe_haven_beach));
        storeBeachBundle(this.getResources().getStringArray(R.array.sunset_beach));
    }

    // Function to iterate through data associated with a beach, then store it in the Beach object.
        // Limitation: Static Hard-coded index management leaves no room for updating the control set.
    private void storeBeachBundle(final String[] INPUT_BUNDLE) {
        Beach tempBeach = new Beach();

        for (int i = 0; i < INPUT_BUNDLE.length; i++) {
            final String TEMP_BEACH_ITEM = INPUT_BUNDLE[i];

            // Limitation: Requires data fields to be properly formatted.
            if (i == 0) {
                tempBeach.setName(TEMP_BEACH_ITEM);
            } else if (i == 1) {
                final String BEACH_NAME = tempBeach.getName();
                int resourceID = (R.drawable.launch_background);

                // Limitation: Unwanted Static Case Switch Statement Implementation
                    //... I could not figure out how to cast a string reference of an integer
                switch (BEACH_NAME) {
                    case "Boardwalk Beach":
                        resourceID = (R.drawable.boardwalk_beach);
                        break;
                    case "Safe Haven Beach":
                        resourceID = (R.drawable.safe_haven_beach);
                        break;
                    case "Sunset Beach":
                        resourceID = (R.drawable.sunset_beach);
                        break;
                    default:
                        Log.e(CLASS_TAG, String.valueOf(R.string.log_dataset_invalid_beach_name));
                        break;
                }
                tempBeach.setImageLocation(resourceID);
            } else if (i == 2) {
                tempBeach.setDisplayRating(TEMP_BEACH_ITEM);
            } else {
                Log.e(CLASS_TAG, String.valueOf(R.string.log_dataset_invalid_count));
            }
        }
        // Adding the beach entry from the XML into the ArrayList of Beach objects.
        BEACHES.add(tempBeach);
    }
}
