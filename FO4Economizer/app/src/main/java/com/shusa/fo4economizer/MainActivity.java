package com.shusa.fo4economizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String CLASS_TAG = this.getClass().getSimpleName();

    // Items List Members
    private ArrayList<Item> ITEMS = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateItems();
        populateListView();
        //logAll();
    }

    private void populateItems() {
        ListBuilder LB = new ListBuilder();
        final Context CONTEXT = this;
        final String ITEMS_FILE_NAME = "game_items.txt";
        ITEMS = LB.fillItemsArray(CONTEXT, ITEMS_FILE_NAME);
    }

    private void populateListView() {
        final ArrayList<DetailedList> LIST_OF_DETAILED_ITEMS = new ArrayList<>();
        Item tempItem;

        for (int i = 0; i < ITEMS.size(); i++) {
            tempItem = ITEMS.get(i);

            // Section 1
            final String NAME = tempItem.getName();
            final int DIFFICULTY = tempItem.getDifficulty();

            // Section 2
            final double BASE_VALUE = tempItem.getBaseValue();
            final double SALE_VALUE = tempItem.getSaleValue();
            final double RUINED_VALUE = tempItem.getRuinedValue();
            final double PRESTINE_VALUE = tempItem.getPrestineValue();

            // Section 3
            final double BASE_VPW = tempItem.getBaseVPW();
            final double SALE_VPW = tempItem.getSaleVPW();
            final double RUINED_VPW = tempItem.getRuinedVPW();
            final double PRESTINE_VPW = tempItem.getPrestineVPW();

            // Section 4
            final double WEIGHT = tempItem.getWeight();

            // Section 5
            final ArrayList<CraftBundle> CRAFT_LIST = tempItem.getCraftList();

            // Create CraftBundle String
            StringBuilder SB = new StringBuilder();

            for (int j = 0; j < CRAFT_LIST.size(); j++) {
                final CraftBundle CRAFT_LIST_BUNDLE = CRAFT_LIST.get(j);
                final Item CRAFT_LIST_ITEM = CRAFT_LIST_BUNDLE.getItem();
                final int CRAFT_LIST_ITEM_COUNT = CRAFT_LIST_BUNDLE.getCount();

                SB.append("[");
                SB.append(CRAFT_LIST_ITEM.getName());
                SB.append(", ");
                SB.append(CRAFT_LIST_ITEM_COUNT);

                if (j == (CRAFT_LIST.size() - 1)) {
                    SB.append("]");
                } else {
                    SB.append("],  ");
                }
            }
            final String CRAFT_BUNDLE = SB.toString();

            // Populate List of Detailed Items
            LIST_OF_DETAILED_ITEMS.add(new DetailedList(NAME, DIFFICULTY,
                    BASE_VALUE, SALE_VALUE, RUINED_VALUE, PRESTINE_VALUE,
                    BASE_VPW, SALE_VPW, RUINED_VPW, PRESTINE_VPW,
                    WEIGHT, CRAFT_BUNDLE));
        }
        // Link Adapter and View
        final ListView itemsListView = findViewById(R.id.activity_main_items_lv);
        final DetailedListAdapter ITEMS_ADAPTER = new DetailedListAdapter(this, LIST_OF_DETAILED_ITEMS);
        itemsListView.setAdapter(ITEMS_ADAPTER);
    }

    private void logAll() {
        Item tempItem;

        // Log Items
        for (int i = 0; i < ITEMS.size(); i++) {
            tempItem = ITEMS.get(i);

            final double DIFFICULTY = tempItem.getDifficulty();

            final double BASE_VALUE = tempItem.getBaseValue();
            final double SALE_VALUE = tempItem.getSaleValue();
            final double RUINED_VALUE = tempItem.getRuinedValue();
            final double PRESTINE_VALUE = tempItem.getPrestineValue();

            final double WEIGHT = tempItem.getWeight();

            final double BASE_VPW = tempItem.getBaseVPW();
            final double SALE_VPW = tempItem.getSaleVPW();
            final double RUINED_VPW = tempItem.getRuinedVPW();
            final double PRESTINE_VPW = tempItem.getPrestineVPW();

            final ArrayList<CraftBundle> CRAFT_LIST = tempItem.getCraftList();

            Log.e(CLASS_TAG, "Difficulty [" + tempItem.getName() + "]: " + DIFFICULTY);
            Log.e(CLASS_TAG, "Base Value [" + tempItem.getName() + "]: " + BASE_VALUE);
            Log.e(CLASS_TAG, "Sale Value [" + tempItem.getName() + "]: " + SALE_VALUE);
            Log.e(CLASS_TAG, "Ruined Value [" + tempItem.getName() + "]: " + RUINED_VALUE);
            Log.e(CLASS_TAG, "Prestine Value [" + tempItem.getName() + "]: " + PRESTINE_VALUE);
            Log.e(CLASS_TAG, "Weight: [" + tempItem.getName() + "]: " + WEIGHT);
            Log.e(CLASS_TAG, "Base VPW [" + tempItem.getName() + "]: " + BASE_VPW);
            Log.e(CLASS_TAG, "Sale VPW [" + tempItem.getName() + "]: " + SALE_VPW);
            Log.e(CLASS_TAG, "Ruined VPW [" + tempItem.getName() + "]: " + RUINED_VPW);
            Log.e(CLASS_TAG, "Prestine VPW [" + tempItem.getName() + "]: " + PRESTINE_VPW);
            for (int j = 0; j < CRAFT_LIST.size(); j++) {
                final CraftBundle CRAFT_LIST_BUNDLE = CRAFT_LIST.get(j);
                final Item CRAFT_LIST_ITEM = CRAFT_LIST_BUNDLE.getItem();
                final int CRAFT_LIST_ITEM_COUNT = CRAFT_LIST_BUNDLE.getCount();

                Log.e(CLASS_TAG, "CraftList: [" + tempItem.getName() + "], " + "Index: [" + j +
                        "]: (" + CRAFT_LIST_ITEM.getName() + ", " + CRAFT_LIST_ITEM_COUNT + ")");
            }
            Log.e(CLASS_TAG, "===============================================================");
        }
    }
}