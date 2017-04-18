package com.zombiesurvival.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.zombiesurvival.dao.factory.ConnectionFactory;
import com.zombiesurvival.model.Inventory;
import com.zombiesurvival.model.Item;
import com.zombiesurvival.model.Survivor;
import com.zombiesurvival.util.type.TypeGender;
import com.zombiesurvival.util.type.TypeItem;

public class SurvivorDao {
	
	ResultSet rsRetorno;
	StringBuilder sqlQuery;
	
	private Connection connection;

	public SurvivorDao() {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void addSurvivor(Survivor survivor){
		sqlQuery = new StringBuilder ();
		sqlQuery.append("INSERT INTO survivor( ");
		sqlQuery.append("name, age, gender, latitude, longitude ) ");
		sqlQuery.append("VALUES (?, ?, ?, ?, ?) ");
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setString(1, survivor.getName());
			pstQuery.setInt(2, survivor.getAge());
			pstQuery.setInt(3, survivor.getGender().ordinal());
			pstQuery.setString(4, survivor.getLatitude());
			pstQuery.setString(5, survivor.getLongitude());
			
			pstQuery.execute();
			pstQuery.close();
		}catch(SQLException e) {
			throw new RuntimeException("Failed to add a survivor", e);
		};
	}
	
	public Collection<Survivor> getSurvivors() {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("SELECT id, name, age, gender, latitude, longitude, delation, infected ");
		sqlQuery.append("FROM survivor" );
		
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			rsRetorno = pstQuery.executeQuery(); 

			Collection<Survivor> survivors = new ArrayList<Survivor>();
			Survivor survivor = null;
			
			while(rsRetorno.next()) {
				survivor = new Survivor();
				survivor.setId(rsRetorno.getInt("id"));
				survivor.setName(rsRetorno.getString("name"));
				survivor.setAge(rsRetorno.getInt("age"));
				if(rsRetorno.getInt("gender") == 0)
					survivor.setGender(TypeGender.FEMALE);
				else
					survivor.setGender(TypeGender.MALE);
				survivor.setLatitude(rsRetorno.getString("latitude"));
				survivor.setLongitude(rsRetorno.getString("longitude"));
				survivor.setDelation(rsRetorno.getInt("delation"));
				survivor.setInfected(rsRetorno.getBoolean("infected"));

				survivors.add(survivor);
			}
			rsRetorno.close();
			pstQuery.close();
			return survivors;
		} catch (SQLException e) {
			throw new RuntimeException("Failed to get survivors ", e);
		}
	}
	
	public Survivor getSurvivorByName(String name) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("SELECT id, name, age, gender, latitude, longitude, delation, infected ");
		sqlQuery.append("FROM survivor " );
		sqlQuery.append("WHERE survivor.name = ? " );
		
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setString(1, name);
			rsRetorno = pstQuery.executeQuery(); 
			
			Survivor survivor = null;
			if(rsRetorno.next()) {
				survivor = new Survivor();
				survivor.setId(rsRetorno.getInt("id"));
				survivor.setName(rsRetorno.getString("name"));
				survivor.setAge(rsRetorno.getInt("age"));
				if(rsRetorno.getInt("gender") == 0)
					survivor.setGender(TypeGender.FEMALE);
				else
					survivor.setGender(TypeGender.MALE);
				survivor.setLatitude(rsRetorno.getString("latitude"));
				survivor.setLongitude(rsRetorno.getString("longitude"));
				survivor.setDelation(rsRetorno.getInt("delation"));
				survivor.setInfected(rsRetorno.getBoolean("infected"));
			}
			rsRetorno.close();
			pstQuery.close();
			return survivor;
		} catch (SQLException e) {
			throw new RuntimeException("Failed to get survivor ", e);
		}
	}
	
	public Survivor getSurvivorById(Integer survivorId) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("SELECT id, name, age, gender, latitude, longitude, delation, infected ");
		sqlQuery.append("FROM survivor " );
		sqlQuery.append("WHERE survivor.id = ? " );
		
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setInt(1, survivorId);
			rsRetorno = pstQuery.executeQuery(); 
			
			Survivor survivor = null;
			if(rsRetorno.next()) {
				survivor = new Survivor();
				survivor.setId(rsRetorno.getInt("id"));
				survivor.setName(rsRetorno.getString("name"));
				survivor.setAge(rsRetorno.getInt("age"));
				if(rsRetorno.getInt("gender") == 0)
					survivor.setGender(TypeGender.FEMALE);
				else
					survivor.setGender(TypeGender.MALE);
				survivor.setLatitude(rsRetorno.getString("latitude"));
				survivor.setLongitude(rsRetorno.getString("longitude"));
				survivor.setDelation(rsRetorno.getInt("delation"));
				survivor.setInfected(rsRetorno.getBoolean("infected"));
			}
			rsRetorno.close();
			pstQuery.close();
			return survivor;
		} catch (SQLException e) {
			throw new RuntimeException("Failed to get survivor ", e);
		}
	}
	
	public Collection<Survivor> getSurvivorsByName(String name) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("SELECT id, name, age, gender, latitude, longitude, delation, infected ");
		sqlQuery.append("FROM survivor " );
		sqlQuery.append("WHERE survivor.name LIKE '%' || ? || '%' " );
		
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setString(1, name);
			rsRetorno = pstQuery.executeQuery(); 
			
			Collection<Survivor> survivors = new ArrayList<Survivor>();
			Survivor survivor = null;
			while(rsRetorno.next()) {
				survivor = new Survivor();
				survivor.setId(rsRetorno.getInt("id"));
				survivor.setName(rsRetorno.getString("name"));
				survivor.setAge(rsRetorno.getInt("age"));
				if(rsRetorno.getInt("gender") == 0)
					survivor.setGender(TypeGender.FEMALE);
				else
					survivor.setGender(TypeGender.MALE);
				survivor.setLatitude(rsRetorno.getString("latitude"));
				survivor.setLongitude(rsRetorno.getString("longitude"));
				survivor.setDelation(rsRetorno.getInt("delation"));
				survivor.setInfected(rsRetorno.getBoolean("infected"));

				survivors.add(survivor);
			}
			rsRetorno.close();
			pstQuery.close();
			return survivors;
		} catch (SQLException e) {
			throw new RuntimeException("Failed to get survivors ", e);
		}
	}
	
	public void addSurvivorInventory(Inventory inventory, Integer survivorId){
		sqlQuery = new StringBuilder ();
		sqlQuery.append("INSERT INTO inventory( ");
		sqlQuery.append("amount, id_item, id_survivor) ");
		sqlQuery.append("VALUES (?, ?, ?) ");
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setInt(1, inventory.getAmount());
			pstQuery.setInt(2, inventory.getItem().getId().ordinal());
			pstQuery.setInt(3, survivorId);
			
			pstQuery.execute();
			pstQuery.close();
		}catch(SQLException e) {
			throw new RuntimeException("Failed to add a item at inventory", e);
		};
	}
	
	public Inventory getInventoryByItemSurvivor(Survivor survivor, Item item) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("SELECT id, amount, id_item, id_survivor ");
		sqlQuery.append("FROM inventory " );
		sqlQuery.append("WHERE inventory.id_item = ? " );
		sqlQuery.append("and inventory.id_survivor = ? " );
		
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setInt(1, item.getId().ordinal());		
			pstQuery.setInt(2, survivor.getId());
			rsRetorno = pstQuery.executeQuery(); 
			
			Inventory inventory = null;
			if(rsRetorno.next()) {
				inventory = new Inventory();
				inventory.setId(rsRetorno.getInt("id"));
				inventory.setAmount(rsRetorno.getInt("amount"));
				inventory.setItem(item);
				inventory.setSurvivor(survivor);
			}
			
			rsRetorno.close();
			pstQuery.close();
			return inventory;
		} catch (SQLException e) {
			throw new RuntimeException("Failed to get inventory ", e);
		}
	}
	
	public void updateSurvivorLocation(Survivor survivor){
		sqlQuery = new StringBuilder ();
		sqlQuery.append("UPDATE survivor ");
		sqlQuery.append("SET latitude = ?, longitude = ? ");
		sqlQuery.append("WHERE survivor.id = ? ");
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setString(1, survivor.getLatitude());
			pstQuery.setString(2, survivor.getLongitude());
			pstQuery.setInt(3, survivor.getId());
			
			pstQuery.execute();
			pstQuery.close();
		}catch(SQLException e) {
			throw new RuntimeException("Failed to add a item at inventory", e);
		};
	}
	
	public void updateSurvivorDelation(Survivor survivor){
		sqlQuery = new StringBuilder ();
		sqlQuery.append("UPDATE survivor ");
		sqlQuery.append("SET delation = ?, infected = ? ");
		sqlQuery.append("WHERE survivor.id = ? ");
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setInt(1, survivor.getDelation());
			pstQuery.setBoolean(2, survivor.isInfected());
			pstQuery.setInt(3, survivor.getId());
			
			pstQuery.execute();
			pstQuery.close();
		}catch(SQLException e) {
			throw new RuntimeException("Failed to add a item at inventory", e);
		};
	}
	
	public void updateIventoryOwner(Inventory inventory){
		sqlQuery = new StringBuilder ();
		sqlQuery.append("UPDATE inventory ");
		sqlQuery.append("SET id_survivor = ? ");
		sqlQuery.append("WHERE inventory.id = ? ");
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setInt(1, inventory.getSurvivor().getId());
			pstQuery.setInt(2, inventory.getId());
			
			pstQuery.execute();
			pstQuery.close();
		}catch(SQLException e) {
			throw new RuntimeException("Failed to add a item at inventory", e);
		};
	}
	
	public void updateAmount(Inventory inventory){
		sqlQuery = new StringBuilder ();
		sqlQuery.append("UPDATE inventory ");
		sqlQuery.append("SET amount = ? ");
		sqlQuery.append("WHERE inventory.id = ? ");
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setInt(1, inventory.getAmount());
			pstQuery.setInt(2, inventory.getId());
			
			pstQuery.execute();
			pstQuery.close();
		}catch(SQLException e) {
			throw new RuntimeException("Failed to add a item at inventory", e);
		};
	}
	
	public List<Inventory> getInventariesBySurvivor(Survivor survivor) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("SELECT id, amount, id_item, id_survivor ");
		sqlQuery.append("FROM inventory " );
		sqlQuery.append("WHERE inventory.id_survivor = ? " );
		
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setInt(1, survivor.getId());
			rsRetorno = pstQuery.executeQuery(); 
			
			List<Inventory> inventoryList = new ArrayList<Inventory>();
			Inventory inventory = null;
			Item item = null;
			while(rsRetorno.next()) {
				inventory = new Inventory();
				inventory.setId(rsRetorno.getInt("id"));
				inventory.setAmount(rsRetorno.getInt("amount"));
				if(rsRetorno.getInt("id_item") == 0){
					item = new Item();
					item.setId(TypeItem.WATER);
					item.setPoints(4);
				}if(rsRetorno.getInt("id_item") == 1){
					item = new Item();
					item.setId(TypeItem.FOOD);
					item.setPoints(3);
				}if(rsRetorno.getInt("id_item") == 2){
					item = new Item();
					item.setId(TypeItem.MEDICATION);
					item.setPoints(2);
				}if(rsRetorno.getInt("id_item") == 3){
					item = new Item();
					item.setId(TypeItem.AMMUNITION);
					item.setPoints(1);
				}inventory.setItem(item);
				inventory.setSurvivor(survivor);
				
				inventoryList.add(inventory);
			}
			
			rsRetorno.close();
			pstQuery.close();
			return inventoryList;
		} catch (SQLException e) {
			throw new RuntimeException("Failed to get inventory ", e);
		}
	}
	
	public Item getItemById(int itemId) {
		sqlQuery = new StringBuilder ();
		sqlQuery.append("SELECT id "); 
		sqlQuery.append("FROM item " );
		sqlQuery.append("WHERE item.id = ? " );
		
		try {
			PreparedStatement pstQuery = connection.prepareStatement(sqlQuery.toString());
			pstQuery.setInt(1, itemId);
			rsRetorno = pstQuery.executeQuery(); 
			
			Item item = null;
			if(rsRetorno.next()) {
				if(rsRetorno.getInt("id") == 0){
					item = new Item();
					item.setId(TypeItem.WATER);
					item.setPoints(4);
				}if(rsRetorno.getInt("id") == 1){
					item = new Item();
					item.setId(TypeItem.FOOD);
					item.setPoints(3);
				}if(rsRetorno.getInt("id") == 2){
					item = new Item();
					item.setId(TypeItem.MEDICATION);
					item.setPoints(2);
				}if(rsRetorno.getInt("id") == 3){
					item = new Item();
					item.setId(TypeItem.AMMUNITION);
					item.setPoints(1);
				}
			}
			rsRetorno.close();
			pstQuery.close();
			return item;
		} catch (SQLException e) {
			throw new RuntimeException("Failed to get survivor ", e);
		}
	}
}
