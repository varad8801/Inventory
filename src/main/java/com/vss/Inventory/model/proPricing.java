package com.vss.Inventory.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class proPricing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	  private double unitPrice;
	    private double costPrice;
	    private double bulkPrice;
		public double getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}
		public double getCostPrice() {
			return costPrice;
		}
		public void setCostPrice(double costPrice) {
			this.costPrice = costPrice;
		}
		public double getBulkPrice() {
			return bulkPrice;
		}
		public void setBulkPrice(double bulkPrice) {
			this.bulkPrice = bulkPrice;
		}
		@Override
		public String toString() {
			return "proPricing [unitPrice=" + unitPrice + ", costPrice=" + costPrice + ", bulkPrice=" + bulkPrice + "]";
		}

}
