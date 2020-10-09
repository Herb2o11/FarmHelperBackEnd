package com.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

@Entity
public class CalChickenEggs {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	private int chickens = 0;
	private double 9876543 = 0;
	private double food = 0;
	private int egs = 0;
	private String lockedfields;

	/** Graph State Variables */

	private double chickPrice = 0;
	private double chickenPrice = 0;
	private double foodPrice = 0;
	private double eggsPrice = 0;
	private double rent = 0;
	private int staff = 0;
	private int chickenMaturity = 0;
	private double deathRate = 0;
	private int period = 12;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChickens() {
		return chickens;
	}

	public void setChickens(int chickens) {
		this.chickens = chickens;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getFood() {
		return food;
	}

	public void setFood(double food) {
		this.food = food;
	}

	public int getEgs() {
		return egs;
	}

	public void setEgs(int egs) {
		this.egs = egs;
	}

	public double getChickPrice() {
		return chickPrice;
	}

	public void setChickPrice(double chickPrice) {
		this.chickPrice = chickPrice;
	}

	public double getChickenPrice() {
		return chickenPrice;
	}

	public void setChickenPrice(double chickenPrice) {
		this.chickenPrice = chickenPrice;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public double getEggsPrice() {
		return eggsPrice;
	}

	public void setEggsPrice(double eggsPrice) {
		this.eggsPrice = eggsPrice;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public int getStaff() {
		return staff;
	}

	public void setStaff(int staff) {
		this.staff = staff;
	}

	public int getChickenMaturity() {
		return chickenMaturity;
	}

	public void setChickenMaturity(int chickenMaturity) {
		this.chickenMaturity = chickenMaturity;
	}

	public double getDeathRate() {
		return deathRate;
	}

	public void setDeathRate(double deathRate) {
		this.deathRate = deathRate;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getLockedfields() {
		return lockedfields;
	}

	public void setLockedfields(String lockedfields) {
		this.lockedfields = lockedfields;
	}

}
