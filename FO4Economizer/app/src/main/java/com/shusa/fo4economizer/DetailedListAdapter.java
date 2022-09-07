package com.shusa.fo4economizer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DetailedListAdapter extends ArrayAdapter<DetailedList> {
    private final String CLASS_TAG = this.getClass().getSimpleName();

    // Explicit Constructor
    public DetailedListAdapter(final Context CONTEXT, final ArrayList<DetailedList> DETAILED_ITEM_LIST) {
        super(CONTEXT, 0, DETAILED_ITEM_LIST);
    }
    @Override
    public View getView(final int POSITION, final View CONVERT_VIEW, final ViewGroup PARENT) {
        final DetailedList CURRENT_DETAILED_ITEM = getItem(POSITION);
        View listViewItem = CONVERT_VIEW;

        if(listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(R.layout.detailed_list_item, PARENT, false);
        }
        // String Setters ==========================================================================
        final String TABS = "\t\t\t\t\t\t";

        // Section 1
        final String NAME_TEXT = CURRENT_DETAILED_ITEM.getName();
        final String DIFFICULTY_COLONTEXT = (getContext().getString(R.string.detailed_list_item_difficulty_colontext) +
                TABS + intToString(CURRENT_DETAILED_ITEM.getDifficulty()));

        // Section 2
        final String BASE_VALUE_COLONTEXT = (getContext().getString(R.string.detailed_list_item_base_value_colontext) +
                TABS + (doubleToString(CURRENT_DETAILED_ITEM.getBaseValue())));
        final String SALE_VALUE_COLONTEXT = (getContext().getString(R.string.detailed_list_item_sale_value_colontext) +
                TABS + (doubleToString(CURRENT_DETAILED_ITEM.getSaleValue())));
        final String RUINED_VALUE_COLONTEXT = (getContext().getString(R.string.detailed_list_item_ruined_value_colontext) +
                TABS + (doubleToString(CURRENT_DETAILED_ITEM.getRuinedValue())));
        final String PRESTINE_VALUE_COLONTEXT = (getContext().getString(R.string.detailed_list_item_prestine_value_colontext) +
                TABS + (doubleToString(CURRENT_DETAILED_ITEM.getPrestineValue())));

        // Section 3
        final String BASE_VPW_COLONTEXT = (getContext().getString(R.string.detailed_list_item_base_vpw_colontext) +
                TABS + (doubleToString(CURRENT_DETAILED_ITEM.getBaseVPW())));
        final String SALE_VPW_COLONTEXT = (getContext().getString(R.string.detailed_list_item_sale_vpw_colontext) +
                TABS + (doubleToString(CURRENT_DETAILED_ITEM.getSaleVPW())));
        final String RUINED_VPW_COLONTEXT = (getContext().getString(R.string.detailed_list_item_ruined_vpw_colontext) +
                TABS + (doubleToString(CURRENT_DETAILED_ITEM.getRuinedVPW())));
        final String PRESTINE_VPW_COLONTEXT = (getContext().getString(R.string.detailed_list_item_prestine_vpw_colontext) +
                TABS + (doubleToString(CURRENT_DETAILED_ITEM.getPrestineVPW())));

        // Section 4
        final String WEIGHT_COLONTEXT = (getContext().getString(R.string.detailed_list_item_weight_colontext) +
                TABS + (doubleToString(CURRENT_DETAILED_ITEM.getWeight())));

        // Section 5
        final String CRAFT_LIST_TEXT = (getContext().getString(R.string.detailed_list_item_craft_list_colontext) +
                TABS + (CURRENT_DETAILED_ITEM.getCraftList()));

        // View Initializations ====================================================================
        // Section 1
        TextView nameTextView = listViewItem.findViewById(R.id.detailed_list_item_name_tv);
        TextView difficultyTextView = listViewItem.findViewById(R.id.detailed_list_item_difficulty_tv);

        // Section 2
        TextView baseValueTextView = listViewItem.findViewById(R.id.detailed_list_item_base_value_tv);
        TextView saleValueTextView = listViewItem.findViewById(R.id.detailed_list_item_sale_value_tv);
        TextView ruinedValueTextView = listViewItem.findViewById(R.id.detailed_list_item_ruined_value_tv);
        TextView prestineValueTextView = listViewItem.findViewById(R.id.detailed_list_item_prestine_value_tv);

        // Section 3
        TextView baseVPWTextView = listViewItem.findViewById(R.id.detailed_list_item_base_vpw_tv);
        TextView saleVPWTextView = listViewItem.findViewById(R.id.detailed_list_item_sale_vpw_tv);
        TextView ruinedVPWTextView = listViewItem.findViewById(R.id.detailed_list_item_ruined_vpw_tv);
        TextView prestineVPWTextView = listViewItem.findViewById(R.id.detailed_list_item_prestine_vpw_tv);

        // Section 4
        TextView weightTextView = listViewItem.findViewById(R.id.detailed_list_item_weight_tv);

        // Section 5
        TextView craftListTextView = listViewItem.findViewById(R.id.detailed_list_item_craft_list_tv);

        // View Setters ============================================================================
        // Section 1
        nameTextView.setText(NAME_TEXT);

        if (CURRENT_DETAILED_ITEM.getDifficulty() == 0) {
            difficultyTextView.setVisibility(View.GONE);
        } else {
            difficultyTextView.setVisibility(View.VISIBLE);
            difficultyTextView.setText(DIFFICULTY_COLONTEXT);
        }

        // Section 2
        if (CURRENT_DETAILED_ITEM.getBaseValue() == 0.0) {
            baseValueTextView.setVisibility(View.GONE);
        } else {
            baseValueTextView.setVisibility(View.VISIBLE);
            baseValueTextView.setText(BASE_VALUE_COLONTEXT);
        }
        if (CURRENT_DETAILED_ITEM.getSaleValue() == 0.0) {
            saleValueTextView.setVisibility(View.GONE);
        } else {
            saleValueTextView.setVisibility(View.VISIBLE);
            saleValueTextView.setText(SALE_VALUE_COLONTEXT);
        }
        if (CURRENT_DETAILED_ITEM.getRuinedValue() == 0.0) {
            ruinedValueTextView.setVisibility(View.GONE);
        } else {
            ruinedValueTextView.setVisibility(View.VISIBLE);
            ruinedValueTextView.setText(RUINED_VALUE_COLONTEXT);
        }
        if (CURRENT_DETAILED_ITEM.getPrestineValue() == 0.0) {
            prestineValueTextView.setVisibility(View.GONE);
        } else {
            prestineValueTextView.setVisibility(View.VISIBLE);
            prestineValueTextView.setText(PRESTINE_VALUE_COLONTEXT);
        }

        // Section 3
        if (CURRENT_DETAILED_ITEM.getBaseVPW() == 0.0) {
            baseVPWTextView.setVisibility(View.GONE);
        } else {
            baseVPWTextView.setVisibility(View.VISIBLE);
            baseVPWTextView.setText(BASE_VPW_COLONTEXT);
        }
        if (CURRENT_DETAILED_ITEM.getSaleVPW() == 0.0) {
            saleVPWTextView.setVisibility(View.GONE);
        } else {
            saleVPWTextView.setVisibility(View.VISIBLE);
            saleVPWTextView.setText(SALE_VPW_COLONTEXT);
        }
        if (CURRENT_DETAILED_ITEM.getRuinedVPW() == 0.0) {
            ruinedVPWTextView.setVisibility(View.GONE);
        } else {
            ruinedVPWTextView.setVisibility(View.VISIBLE);
            ruinedVPWTextView.setText(RUINED_VPW_COLONTEXT);
        }
        if (CURRENT_DETAILED_ITEM.getPrestineVPW() == 0.0) {
            prestineVPWTextView.setVisibility(View.GONE);
        } else {
            prestineVPWTextView.setVisibility(View.VISIBLE);
            prestineVPWTextView.setText(PRESTINE_VPW_COLONTEXT);
        }

        // Section 4
        if (CURRENT_DETAILED_ITEM.getWeight() == 0.0) {
            weightTextView.setVisibility(View.GONE);
        } else {
            weightTextView.setVisibility(View.VISIBLE);
            weightTextView.setText(WEIGHT_COLONTEXT);
        }

        // Section 5
        if (CURRENT_DETAILED_ITEM.getCraftList().equals("")) {
            craftListTextView.setVisibility(View.GONE);
        } else {
            craftListTextView.setVisibility(View.VISIBLE);
            craftListTextView.setText(CRAFT_LIST_TEXT);
        }
        return listViewItem;
    }

    // Member Methods
    private String doubleToString(final double INPUT_DBL) {
        DecimalFormat df = new DecimalFormat("#,###.##");

        if (INPUT_DBL < 1.0) {
            df = new DecimalFormat("#,##0.00");
        }
        return df.format(INPUT_DBL);
    }

    private String intToString(final int INPUT_INT) {
        return "" + INPUT_INT;
    }
}
