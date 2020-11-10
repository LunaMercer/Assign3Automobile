package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Automobile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private float basePrice;
	private ArrayList<OptionSet> optionSets;
	private String make;
	private String model;
	private ArrayList<Option> choice = new ArrayList<Option>();

	static LinkedHashMap<String, OptionSet> linkedHashmapOptionSets = new LinkedHashMap<String, OptionSet>();

	/** default constructor */
	public Automobile() {
		name = "";
		basePrice = 0f;
		optionSets = new ArrayList<OptionSet>();
	}

	/** parameterized constructor */
	public Automobile(String name, float basePrice) {
		optionSets = new ArrayList<OptionSet>();
		this.name = name;
		this.basePrice = basePrice;
	}

	/** parameterized constructor */
	public Automobile(String name, float basePrice, int optionSetSize) {
		optionSets = new ArrayList<OptionSet>(optionSetSize);
		this.name = name;
		this.basePrice = basePrice;
	}

	/** Gets the name of this model/automobile */
	public String getName() {
		return name;
	}

	/** Sets the name of this model/automobile */
	public void setName(String name) {
		this.name = name;
	}

	/** Gets the base price of this model/automobile */
	public float getBasePrice() {
		return basePrice;
	}

	/** Sets the base price of this model/automobile */
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	/**
	 * Retrieves the option sets of this model/automobile
	 * 
	 * @return list - the ArrayList of the models option set
	 */
	public ArrayList<OptionSet> getOptionSets() {
		return optionSets;
	}

	/**
	 * Retrieves an option sets of this model/automobile by index
	 * 
	 * @param i - index of the option set in the ArrayList
	 * 
	 * @return optionSet - the option set at the given index
	 */
	public OptionSet getOptionSetByIndex(int i) {
		return this.optionSets.get(i);
	}

	/**
	 * Retrieves an option sets of this model/automobile by name
	 * 
	 * @param name - the name of this model
	 * 
	 * @return OptionSet - single option set matching the name or null
	 */
	public OptionSet getOptionSetByName(String name) {
		Iterator<OptionSet> iterator = this.optionSets.iterator();
		while (iterator.hasNext()) {
			OptionSet optSet = iterator.next();
			if (optSet.getOptionSetName().equalsIgnoreCase(name)) {
				return optSet;
			}
		}
		return null;
	}

	/**
	 * Sets OptionSets of this model
	 * 
	 * @param ArrayList of all the OptionSets created for this model/automobile
	 */
	public void setOptionSets(ArrayList<OptionSet> optionSets) {
		this.optionSets = optionSets;
	}

	/**
	 * Adds optionSet in the optionSet array
	 * 
	 * @param name   - the name of the option set to add
	 * 
	 * @param length - the length of the option set to be added
	 */
	public void addOptionSet(String name, int length, ArrayList<Option> options) {
		OptionSet opset = new OptionSet(name, length);
		opset.setSelectedOptions(options);
		this.optionSets.add(opset);
	}

	/**
	 * addOption() adds option in the required OptionSet.
	 * 
	 * @param optionSetName the name of the set to search from.
	 * 
	 * @param optionName    the name of the option to add in the matching set if any
	 * 
	 * @param price         the price of the new Option to be added to the matching
	 *                      set
	 * 
	 * @return the boolean indication if deletion was successful = true or
	 *         unsuccessful = false
	 */
	public void addOption(String optionSetName, String optionName, float price) {
		OptionSet optSet = this.getOptionSetByName(optionSetName);
		if (optSet != null) {
			optSet.addOption(new Option(optionName, price));
		}
	}

	/**
	 * Searches for the option in the required optionSet using @optionName and
	 * returns option object if found else null.
	 * 
	 * @param optionSetName the name of the set to search from.
	 * 
	 * @param optionName    the name of the option to find in the matching set if
	 *                      any
	 * 
	 * @return the boolean indication if deletion was successful = true or
	 *         unsuccessful = false
	 */
	public Option findOption(String optionSetName, String optionName) {
		OptionSet optSet = this.getOptionSetByName(optionSetName);
		Option opt = null;
		if (optSet != null) {
			opt = optSet.findOption(optionName);
		}
		return opt;
	}

	/**
	 * Deletes the required OptionSet from the option set array of this model
	 * 
	 * @param optionSetName the name of the set to delete from this model/automobile
	 * 
	 * @return the boolean indication if deletion was successful = true or
	 *         unsuccessful = false
	 */
	public boolean deleteOptionSet(String optionSetName) {
		OptionSet opset = this.getOptionSetByName(optionSetName);
		if (opset == null) {
			return false;
		}
		this.optionSets.remove(opset);
		return true;
	}

	/**
	 * Deletes the required option from the optionSetArray
	 * 
	 * @param optionSetName the name of the set to select options from
	 * 
	 * @param optionName    the name of the option to delete from the matching set
	 * 
	 * @return the boolean indication if deletion was successful = true or
	 *         unsuccessful = false
	 */
	public boolean deleteOption(String optionSetName, String optionName) {
		OptionSet opset = this.getOptionSetByName(optionSetName);
		if (opset != null) {
			return opset.deleteOption(optionName);
		}
		return false;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets an Option in the choices list of this automobile/model by Option name
	 * 
	 * @param name - specifies the name of the option to pick the option from the
	 *             current model choices
	 * 
	 * @return - returns the matching option if any from the choices list else
	 *         returns an empty new Option
	 * 
	 */
	public Option getOptionChoice(String name) {
		Iterator<Option> itr = this.choice.iterator();
		Option option = new Option();
		while (itr.hasNext()) {
			Option opt = itr.next();
			if (opt.getName().equalsIgnoreCase(name)) {
				option = opt;
			}
		}

		return option;
	}

	/**
	 * Gets the price of an Option in the choices list of this automobile/model
	 * 
	 * @param name - specifies the name of the option to pick the option from the
	 *             current model choices
	 * 
	 * @return - returns the price value of the selected Option as an integer
	 * 
	 */
	public int getOptionChoicePrice(String name) {
		return (int) this.getOptionChoice(name).getPrice();
	}

	/**
	 * Adds a new option to the current choices of this model
	 * 
	 * @param setName    - specifies the name of the set to pick the option from
	 * 
	 * @param optionName - specifies the name of the option in the OptionSet found
	 *                   by the @param setName
	 * 
	 */
	public void setOptionChoice(String setName, String optionName) {
		OptionSet optSet = this.getOptionSetByName(setName);
		this.choice.add(optSet.findOption(optionName));
	}

	/**
	 * Fetches the total price for all the choices added to this model/automobile
	 * 
	 * @return - the total price of the model option choices in integer
	 */
	public int getTotalPrice() {
		Iterator<Option> itr = this.choice.iterator();
		float price = 0f;
		while (itr.hasNext()) {
			price += itr.next().getPrice();
		}
		return (int) price;
	}

	/** to String() converts buffered string to a string */
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Automotive Name: ").append(name).append("Base Price: ").append(basePrice);
		String str = stringBuffer.toString();
		return str;
	}

	/** print() prints automotive objects attributes */
	public void print() {
		System.out.println(toString());
		Iterator<OptionSet> itr = this.optionSets.iterator();
		while (itr.hasNext()) {
			OptionSet optSet = itr.next();
			optSet.print();
		}
	}

	public static void main(String[] args) {
		System.out.println("AUTOMOBILE MODEL");
		Automobile autoMoblie = new Automobile("Model 1", 600);

		ArrayList<Option> options = new ArrayList<Option>();
		options.add(new Option("Option 1 set 1", 600.0f));
		options.add(new Option("Option 2 set 1", 650.0f));
		options.add(new Option("Option 3 set 1", 680.0f));
		OptionSet opt1 = new OptionSet("Option Set 1", options.size());
		opt1.setSelectedOptions(options);

		autoMoblie.addOptionSet(opt1.getOptionSetName(), opt1.getSelectedOptions().size(), opt1.getSelectedOptions());

		linkedHashmapOptionSets.clear();
		linkedHashmapOptionSets.put(opt1.getOptionSetName(), opt1);

		options.clear();
		options.add(new Option("Option a set 2", 800.0f));
		options.add(new Option("Option b set 2", 850.0f));
		options.add(new Option("Option c set 2", 880.0f));
		OptionSet opt2 = new OptionSet("Option Set 2", options.size());
		linkedHashmapOptionSets.put(opt2.getOptionSetName(), opt2);
		
		autoMoblie.addOptionSet(opt2.getOptionSetName(), opt2.getSelectedOptions().size(), opt2.getSelectedOptions());
		
		autoMoblie.print();
	}
}
