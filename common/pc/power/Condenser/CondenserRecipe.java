package Plasma.common.pc.power.Condenser;

import java.util.HashMap;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CondenserRecipe {
	/**
	 * @author Matheus
	 * @package Plasma.common.pc.power.Condenser
	 * @project Minecraft
	 */
	static HashMap<Integer, Integer> inHashMap = new HashMap<Integer, Integer>();
	static HashMap<Integer, ItemStack> outHashMap = new HashMap<Integer, ItemStack>();
	static HashMap<Item,Integer> itemInHashMap = new HashMap<Item,Integer>();
	static HashMap<Item, ItemStack> itemOutHashMap = new HashMap<Item, ItemStack>();
	
	int itemid;
	int powerToAdd;
	String type;
	Item item;
	ItemStack stack;
	public CondenserRecipe(int id, int power) {
		itemid = id;
		powerToAdd = power;
		type = "int";
	}
	public CondenserRecipe(Item item, int power) {
		this.item = item;
		powerToAdd = power;
		type = "Item";
	}
	static public void putIn(CondenserRecipe cRecipe) {
		if(cRecipe != null && cRecipe.type == "int") {
			inHashMap.put(cRecipe.powerToAdd, cRecipe.powerToAdd);
		}
		else  if(cRecipe != null && cRecipe.type == "Item") {
			itemInHashMap.put(cRecipe.item, cRecipe.powerToAdd);
		}
			
	}
	static public int getIn(Object itemID,String type) {
		if(type == "int") {
			return inHashMap.get(itemID);
			}
			else if(type == "Item") {
			}
			return itemInHashMap.get(itemID);
			}
	
	static public void putOut(CondenserRecipe cRecipe) {
		if(cRecipe != null && cRecipe.type == "int") {
			outHashMap.put(cRecipe.powerToAdd, cRecipe.stack);
		}
		else  if(cRecipe != null && cRecipe.type == "Item") {
			itemOutHashMap.put(cRecipe.item, cRecipe.stack);
		}
	}
	static	public ItemStack getOut(Object itemID,String type) {
		if(type == "int") {
		return outHashMap.get(itemID);
		}
		else if(type == "Item") {
		}
		return itemOutHashMap.get(itemID);
		}
		}
		
		

