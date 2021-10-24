package com.shusa.fo4economizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailedListAdapter extends ArrayAdapter<DetailedList> {

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
        nameTextView.setText(CURRENT_DETAILED_ITEM.getName());
        difficultyTextView.setText(intToString(CURRENT_DETAILED_ITEM.getDifficulty()));

        // Section 2
        baseValueTextView.setText(doubleToString(CURRENT_DETAILED_ITEM.getBaseValue()));
        saleValueTextView.setText(doubleToString(CURRENT_DETAILED_ITEM.getSaleValue()));
        ruinedValueTextView.setText(doubleToString(CURRENT_DETAILED_ITEM.getRuinedValue()));
        prestineValueTextView.setText(doubleToString(CURRENT_DETAILED_ITEM.getPrestineValue()));

        // Section 3
        baseVPWTextView.setText(doubleToString(CURRENT_DETAILED_ITEM.getBaseVPW()));
        saleVPWTextView.setText(doubleToString(CURRENT_DETAILED_ITEM.getSaleVPW()));
        ruinedVPWTextView.setText(doubleToString(CURRENT_DETAILED_ITEM.getRuinedVPW()));
        prestineVPWTextView.setText(doubleToString(CURRENT_DETAILED_ITEM.getPrestineVPW()));

        // Section 4
        weightTextView.setText(doubleToString(CURRENT_DETAILED_ITEM.getWeight()));

        // Section 5
        craftListTextView.setText(CURRENT_DETAILED_ITEM.getCraftList());

        return listViewItem;
    }

    // Member Methods
    private String doubleToString(final double INPUT_DBL) {
        return "" + INPUT_DBL;
    }

    private String intToString(final int INPUT_INT) {
        return "" + INPUT_INT;
    }
}
