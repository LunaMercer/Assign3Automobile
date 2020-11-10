package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class OptionSet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Option> selectedOptions;
	private String optionSetName;

	/* default constructor */
	public OptionSet() {
		selectedOptions = new ArrayList<Option>();
		optionSetName = "";
	}

	/* parameterized constructor */
	public OptionSet(String name, int size) {
		selectedOptions = new ArrayList<Option>(size);
		optionSetName = name;
	}

	/* Retrieves a list of selected options */
	public ArrayList<Option> getSelectedOptions() {
		return selectedOptions;
	}

	/* Sets a list of selected options */
	public void setSelectedOptions(ArrayList<Option> selectedOptions) {
		this.selectedOptions = selectedOptions;
	}

	/* Gets the name of the set */
	public String getOptionSetName() {
		return optionSetName;
	}

	/* Sets the name for the options set */
	public void setOptionSetName(String optionSetName) {
		this.optionSetName = optionSetName;
	}

	/* addOption() adds new Option to the OptionSet */
	protected void addOption(Option option) {
		this.selectedOptions.add(option);
	}

	/*
	 * findOption() finds the option by optionName in the Option Set and returns it
	 */
	protected Option findOption(String optionName) {
		Option matchingOption = null;
		Iterator<Option> optionsIterator = this.selectedOptions.iterator();
		while (optionsIterator.hasNext()) {
			Option option = optionsIterator.next();
			if (option.getName().equalsIgnoreCase(optionName)) {
				matchingOption = option;
				break;
			}
		}
		return matchingOption;
	}

	/* Retrieves an index of an option in the set */
	protected int getIndexOfAnOption(String optionName) {
		int indexToReturn = -1;
		for (int i = 0; i < this.selectedOptions.size(); i++) {
			if (this.selectedOptions.get(i).getName().equalsIgnoreCase(optionName)) {
				indexToReturn = i;
				break;
			}
		}
		return indexToReturn;
	}

	// deletes an Option from the list
	protected boolean deleteOption(String optionName) {
		int index = this.getIndexOfAnOption(optionName);
		// if option not found, return false
		if (index <= -1) {
			return false;
		}

		this.selectedOptions.remove(index);
		return true;
	}

	/* Creates a descriptive string for this class instance */
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("OptionSet Name: ").append(this.optionSetName);
		String str = stringBuffer.toString();
		return str;
	}

	/* Prints automotive object's attributes */
	protected void print() {
		System.out.println(toString());
		this.selectedOptions.forEach(option -> option.print());
	}

}
