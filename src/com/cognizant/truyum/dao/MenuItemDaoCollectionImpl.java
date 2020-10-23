package com.cognizant.truyum.dao;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;
public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private static ArrayList<MenuItem>menuItemList;
	MenuItemDaoCollectionImpl() throws Exception{
		super();
		 if(menuItemList == null || menuItemList.isEmpty())
		   {
			   menuItemList = new ArrayList<MenuItem>();
			   menuItemList.add(new MenuItem((long) 01, "Sandwich", "Main Course",(float) 99.0, true,true,DateUtil.convertToDate("15/03/2017")));

				menuItemList.add(new MenuItem((long) 02, "Burger", "Main Course",(float) 129.0, true,false,DateUtil.convertToDate("23/12/2017")));

				menuItemList.add(new MenuItem((long) 03, "Pizza","Main Course", (float) 149.0, true,false ,DateUtil.convertToDate("21/08/2018")));

				menuItemList.add(new MenuItem((long) 04, "French Fries","Starters", (float) 57.0, false,true,DateUtil.convertToDate("02/07/2017")));

				menuItemList.add(new MenuItem((long) 05, "Chocolate Brownie", "Dessert",(float) 32.0, true,true,DateUtil.convertToDate("02/11/2022")));
			   
		   }
	   }

	public ArrayList<MenuItem> getMenuItemListAdmin() {
		
		// TODO Auto-generated method stub
		return menuItemList;
	}

	public ArrayList<MenuItem> getMenuItemListCustomer(){
		
		ArrayList<MenuItem> fil = new ArrayList<MenuItem>();
		for(MenuItem a:menuItemList)
		{
			Date d = a.getDateOfLaunch();
			String today = "19/08/2019";
			Date tdate = DateUtil.convertToDate(today);
			if(d.before(tdate) || d.equals(tdate))
			{
				if(a.isActive())
				{
					fil.add(a);
				}
			}
		}
		return fil;
		
	}


	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for(MenuItem a:menuItemList)
		{
			if(a.equals(menuItem))
			{
				a.setName(menuItem.getName());
				a.setActive(menuItem.isActive());
				a.setCategory(menuItem.getCategory());
				a.setDateOfLaunch(menuItem.getDateOfLaunch());
				a.setCategory(menuItem.getCategory());
				a.setFreeDelivery(menuItem.isFreeDelivery());
				
			}
		}
		
	}

	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for(MenuItem a: menuItemList)
		{
			if(a.getId()== menuItemId)
			{
				return a;
			}
		}
		return null;
	}


	}