package org.ticket.buy;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Ticket {

	private int km = 0;
	private int age = 0;
	private static final BigDecimal COST_PER_KM = new BigDecimal(0.21);
	private static final BigDecimal OVER_65_DISCOUNT = new BigDecimal(0.60);
	private static final BigDecimal UNDER_18_DISCOUNT = new BigDecimal(0.80);
//	private static int NORMAL_DURATION = 30;
//	private static int FLEXIBLE_DURATION = 30;
//	private LocalDate date;
//	private boolean isFlexible;

//	Constructor 
	public Ticket(int km, int age) throws Exception {

		setKm(km);
		setAge(age);

//		this.date = LocalDate.now();
//		this.setFlexible(isFlexible);

	}

//	Getters and Setters

	public int getKm() {
		return km;
	}

	public int getAge() {
		return age;
	}

	public void setKm(int km) throws Exception {
		if (isValidKm(km)) {
			throw new Exception("Negative km values are forbidden");
		}
		this.km = km;
	}

	public void setAge(int age) throws Exception {
		if (isValidAge(age)) {
			throw new Exception("Negative age values are forbidden");
		}
		this.age = age;
	}

	private boolean isValidKm(int km) {
		return km < 0;
	}

	private boolean isValidAge(int age) {
		return age < 0;
	}

//	Calculate ticket 

	public static BigDecimal getCostPerKm() {
		return COST_PER_KM;
	}

	public static BigDecimal getOver65Discount() {
		return OVER_65_DISCOUNT;
	}

	public static BigDecimal getUnder18Discount() {
		return UNDER_18_DISCOUNT;
	}

	private BigDecimal getDiscount() {
		if (age < 18) {
			return UNDER_18_DISCOUNT.multiply(COST_PER_KM);

		} else if (age > 65) {
			return OVER_65_DISCOUNT.multiply(COST_PER_KM);

		} else {
			return COST_PER_KM;
		}
	}

	public BigDecimal getFullTicketCost() {
		return getDiscount().multiply(BigDecimal.valueOf(km));
	}

	public String getCostDouble() {
		double formattedToDouble = getFullTicketCost().doubleValue();
		return String.format("%.2f", formattedToDouble);
	}

	@Override
	public String toString() {
		return "Km: " + getKm() + "\nAge: " + getAge() + "\nCost: " + getCostDouble() + "€";
	}

//	public boolean isFlexible() {
//		return isFlexible;
//	}
//
//	public void setFlexible(boolean isFlexible) {
//		this.isFlexible = isFlexible;
//	}

}
