package com.shusa.fo4economizer;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ListBuilder extends AppCompatActivity {
    private final String CLASS_TAG = this.getClass().getSimpleName();

    private ArrayList<Item> ITEMS = new ArrayList<>();

    public ListBuilder() {

    }

    public ArrayList<Item> fillItemsArray(final Context CONTEXT, final String FILE_NAME) {
        final String ITEMS_STRING = getFileString(CONTEXT, FILE_NAME);

        StringBuilder SB = new StringBuilder();
        String key = "";
        String value;
        char c;

        String tempName = "";
        double tempWeight = 0.0;
        double tempValue = 0.0;
        int tempDifficulty = 0;
        String tempCraftList = "";

        for (int i = 0; i < ITEMS_STRING.length(); i++) {
            c = ITEMS_STRING.charAt(i);

            switch (c) {
                case ' ':
                    Log.i(CLASS_TAG, "Skipping Space");
                    break;
                case '\"':
                    Log.i(CLASS_TAG, "Skipping Quotation");
                    break;
                case '{':
                    Log.i(CLASS_TAG, "New Item Identified");
                    break;
                case ',':
                    key = SB.toString().toLowerCase();
                    Log.i(CLASS_TAG, "Key Identified [" + key + "]");
                    SB.setLength(0);
                    break;
                case ';':
                    value = SB.toString();
                    Log.i(CLASS_TAG, "Value Identified [" + value + "]");
                    switch (key) {
                        case "name":
                            tempName = value;
                            break;
                        case "weight":
                            tempWeight = Double.parseDouble(value);
                            break;
                        case "value":
                            tempValue = Double.parseDouble(value);
                            break;
                        case "difficulty":
                            tempDifficulty = Integer.parseInt(value);
                            break;
                        case "craft_list":
                            tempCraftList = value;
                            break;
                        default:
                            Log.e(CLASS_TAG, "Key [" + key + "] is not recognized.");
                            break;
                    }
                    SB.setLength(0);
                    break;
                case '}':
                    Log.i(CLASS_TAG, "New Item Finished");

                    if (tempWeight != 0.0 && tempValue != 0.0) {
                        Item component = new Item(tempName, tempWeight, tempValue);
                        ITEMS.add(component);
                    } else {
                        Item item = new Item(tempName, tempDifficulty, getCraftList(tempCraftList));
                        ITEMS.add(item);
                    }
                    // Clear all Temporary Values
                    SB.setLength(0);
                    tempName = "";
                    tempWeight = 0.0;
                    tempValue = 0.0;
                    tempDifficulty = 0;
                    tempCraftList = "";
                    break;
                default:
                    SB.append(c);
                    break;
            }
        }
        return ITEMS;
    }

    // Utility Method
    public String getFileString(final Context INPUT_CONTEXT, final String INPUT_FILE_NAME) {
        try {
            StringBuilder SB = new StringBuilder();
            InputStream IS = INPUT_CONTEXT.getAssets().open(INPUT_FILE_NAME);
            BufferedReader BR = new BufferedReader(new InputStreamReader(IS, StandardCharsets.UTF_8));

            String str;

            while ((str = BR.readLine()) != null) {
                SB.append(str);
            }
            BR.close();

            return SB.toString();
        } catch (Exception e) {
            Log.e(CLASS_TAG, "Exception: " + e);
        }
        return "ERROR";
    }

    private ArrayList<CraftBundle> getCraftList(final String INPUT_CRAFT_LIST_STRING) {
        final ArrayList<CraftBundle> CRAFTING_LIST = new ArrayList<>();
        StringBuilder SB = new StringBuilder();

        CraftBundle tempCraftBundle;
        Item tempItem = new Item();

        String tempString;

        char c = ' ';
        int tempInt;

        for (int i = 0; i < INPUT_CRAFT_LIST_STRING.length(); i++) {
            c = INPUT_CRAFT_LIST_STRING.charAt(i);

            switch (c) {
                case '[':
                    Log.i(CLASS_TAG, "Skipped Forward Bracket");
                    break;
                case '-':
                    Log.i(CLASS_TAG, "Skipped Hyphen");
                    break;
                case '=':
                    for (int j = 0; j < ITEMS.size(); j++) {
                        tempString = ITEMS.get(j).getName();

                        if (SB.toString().equals(tempString.toLowerCase())) {
                            tempItem = ITEMS.get(j);
                        }
                    }
                    SB.setLength(0);
                    break;
                case ']':
                    tempInt = Integer.parseInt(SB.toString());
                    SB.setLength(0);

                    tempCraftBundle = new CraftBundle(tempItem, tempInt);
                    CRAFTING_LIST.add(tempCraftBundle);
                    break;
                default:
                    SB.append(c);
                    break;
            }
        }
        return CRAFTING_LIST;
    }
}
