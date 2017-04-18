package com.zombiesurvival.business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zombiesurvival.dao.SurvivorDao;
import com.zombiesurvival.model.Inventory;
import com.zombiesurvival.model.Item;
import com.zombiesurvival.model.Survivor;
import com.zombiesurvival.util.type.TypeItem;

public class ZombieSurvivalBusiness {
	
	private SurvivorDao survivorDao = new SurvivorDao();
	
	public Boolean inventoryValidator(List<Inventory> inventories,  int survivorId) {
		Set<TypeItem> setItem = new HashSet<TypeItem>();
		for (Inventory inventory : inventories) {
			setItem.add(inventory.getItem().getId());
		}
		Survivor survivor = new Survivor();
		survivor.setId(survivorId);
		for (Inventory inventory : inventories) {
			if(inventory.getItem() == null || inventories.size() != 4 || 
					survivorDao.getInventoryByItemSurvivor(survivor, inventory.getItem()) != null ||
					setItem.size() != inventories.size()){
				return false;
			}
			survivorDao.addSurvivorInventory(inventory, survivorId);
		}
		
		return true;
	}
	
	public Boolean survivorValidator(Survivor survivor){
		if(survivorDao.getSurvivorByName(survivor.getName()) != null)
			return false;
		
		survivorDao.addSurvivor(survivor);
		return true;
	}
	
	public Boolean survivorUpdateValidator(Survivor survivor, int survivorId){
		Survivor survivorDB = survivorDao.getSurvivorById(survivorId);
		System.out.println(survivor.isInfected());
		if(survivorDB != null && survivor.getLatitude() != null && survivor.getLongitude() != null){
			survivorDB.setLatitude(survivor.getLatitude());
			survivorDB.setLongitude(survivor.getLongitude());
			survivorDao.updateSurvivorLocation(survivorDB);
			return true;
		}else if(survivorDB != null && survivor.isInfected()){
			survivorDB.setDelation(survivorDB.getDelation() + 1);
			if(survivorDB.getDelation() > 2)
				survivorDB.setInfected(true);
			
			survivorDao.updateSurvivorDelation(survivorDB);
			return true;
		}
		return false;
	}
	
	public String getReportPercentage(int status){
		List<Survivor> totalSurvivorsList = (ArrayList<Survivor>) survivorDao.getSurvivors();
		int countInfected = 0, countNotInfected = 0;
		
		for (Survivor survivor : totalSurvivorsList) {
			if(survivor.isInfected())
				countInfected++;
			else
				countNotInfected++;
		}
		if(status == 0){
			float precent = (countInfected*100)/totalSurvivorsList.size();
			return "Percentage of infected: " + precent;
		}else if(status == 1){
			float precent = (countNotInfected*100)/totalSurvivorsList.size();
			return "Percentage of not infected: " + precent;
		}
		return "wrong param";
	}
	
//	public Boolean tradeValidator(List<Inventory> inventoriesWillTrade){
//		Set<Integer> hashSetIdSurvivors = new HashSet<Integer>();
//		for (Inventory inventory : inventoriesWillTrade) {
//			hashSetIdSurvivors.add(inventory.getSurvivor().getId());
//		}
//		List<Inventory> inventoriesSurvivor1 = new ArrayList<Inventory>();
//		List<Inventory> inventoriesSurvivor2 = new ArrayList<Inventory>();
//		int somaPontos1 = 0; int somaPontos2 = 0;
//		
//		int count = 0;
//		
//		if(hashSetIdSurvivors.size() == 2){
//			
//		}
//
//	}

//	private boolean validaItens(List<Inventory> inventoriesWillTrade, List<Inventory> inventoriesCollextion){
//		int count = 0;
//		for (Inventory inventorytrade : inventoriesWillTrade) {
//			for (Inventory inventoryCollection : inventoriesCollextion) {
//				if(inventoryCollection.getItem().getId().equals(inventorytrade.getItem().getId()))
//					count ++;
//			}
//		}
//		if(count == inventoriesWillTrade.size())
//			return true;
//		
//		return false;
//	}
}

