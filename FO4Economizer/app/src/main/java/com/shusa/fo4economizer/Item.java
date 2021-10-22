package com.shusa.fo4economizer;

import java.util.ArrayList;

public class Item {
	// Explicit Data Members
	private String name = "";

	private double weight;

	private double baseValue;
	private double saleValue;
	private double ruinedValue;
	private double prestineValue;

	private int difficulty = 0;

	private ArrayList<CraftBundle> craftList = new ArrayList<>();

	// Explicit Constructor ========================================================================
	public Item(String _name, int _difficulty, ArrayList<CraftBundle> _craft_list) {
		name = _name;
		difficulty = _difficulty;
		craftList = _craft_list;
		initialize();
	}

	public Item(String _name, double _weight, double _base_value) {
		name = _name;
		weight = _weight;
		baseValue = _base_value;
		difficulty = 0;
	}

	// Default Constructor
	public Item() {

	}

	// Getters =====================================================================================
	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public double getBaseValue() {
		return baseValue;
	}

	public double getSaleValue() {
		switch (difficulty) {
			case 0:
				saleValue = baseValue;
				break;
			case 1:
				saleValue = (baseValue * 1.01);
				break;
			case 2:
				saleValue = (baseValue * 1.02);
				break;
			case 3:
				saleValue = (baseValue * 1.04);
				break;
			case 4:
				saleValue = (baseValue * 1.08);
				break;
			case 5:
				saleValue = (baseValue * 1.16);
				break;
			case 6:
				saleValue = (baseValue * 1.32);
				break;
			case 7:
				saleValue = (baseValue * 1.64);
				break;
			case 8:
				saleValue = (baseValue * 1.128);
				break;
			case 9:
				saleValue = (baseValue * 1.256);
				break;
			case 10:
				saleValue = (baseValue * 1.512);
				break;
		}
		return saleValue;
	}

	public double getRuinedValue() {
		if (difficulty == 0) {
			ruinedValue = 0.0;
		} else {
			ruinedValue = (baseValue * .5);
		}
		return ruinedValue;
	}

	public double getPrestineValue() {
		switch (difficulty) {
			case 0:
				prestineValue = 0.0;
				break;
			case 1:
				prestineValue = (baseValue * 2);
				break;
			case 2:
				prestineValue = (baseValue * 2.33);
				break;
			case 3:
				prestineValue = (baseValue * 2.66);
				break;
			case 4:
				prestineValue = (baseValue * 3);
				break;
			case 5:
				prestineValue = (baseValue * 3.33);
				break;
			case 6:
				prestineValue = (baseValue * 3.66);
				break;
			case 7:
				prestineValue = (baseValue * 4);
				break;
			case 8:
				prestineValue = (baseValue * 4.33);
				break;
			case 9:
				prestineValue = (baseValue * 4.66);
				break;
			case 10:
				prestineValue = (baseValue * 5);
				break;
		}
		return prestineValue;
	}

	public double getBaseVPW() {
		return (baseValue / weight);
	}

	public double getSaleVPW() {
		return (saleValue / weight);
	}

	public double getRuinedVPW() {
		return (ruinedValue / weight);
	}

	public double getPrestineVPW() {
		return (prestineValue / weight);
	}

	public int getDifficulty() {
		return difficulty;
	}

	public ArrayList<CraftBundle> getCraftList() {
		return craftList;
	}

	// Member Methods ==============================================================================
	public void initialize() {
		CraftBundle craftBundle;
		Item craftItem;
		int craftCount;

		for (int i = 0; i < craftList.size(); i++) {
			craftBundle = craftList.get(i);
			craftItem = craftBundle.getItem();
			craftCount = craftBundle.getCount();

			weight += (craftItem.getWeight() * craftCount);
			baseValue += (craftItem.getBaseValue() * craftCount);
		}
	}
}
