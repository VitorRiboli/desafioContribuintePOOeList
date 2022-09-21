package entities;

import java.util.ArrayList;
import java.util.List;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	List<TaxPayer> taxPayer = new ArrayList<>();
	
	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		super();
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void addTaxPayer(TaxPayer tp) {
		taxPayer.add(tp);
	}
	
	public double salaryTax() {
		double salaryMonth = this.salaryIncome / 12;
		
		if(salaryMonth < 3000.0) {
			return 0.0;
		}
		if(salaryMonth <= 5000.0) {
			return this.salaryIncome * 0.10;
		}
		else {
			return this.salaryIncome * 0.20;
		}	
	}
	
	public double servicesTax() {
		if(this.servicesIncome <= 0) {
			return 0.0;
		}
		else {
			return this.servicesIncome * 0.15;
		}
	}
	
	public double capitalTax() {
		if(this.capitalIncome <= 0) {
			return 0.0;
		}
		else {
			return this.capitalIncome * 0.20;
		}
	}
	
	//Imposto Bruto
	public double grossTax() {
		return capitalTax() + servicesTax() + salaryTax();
	}
	
	
	//Abatimento
	public double taxRebate() {
		if((this.educationSpending + this.healthSpending) >= ((grossTax() * 30) / 100)) {
			return (grossTax() * 30) / 100;
		}
		else {
			return this.educationSpending + this.healthSpending;
		}
	}
	
	//Imposto devido
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Imposto bruto total: R$ " + String.format("%.2f", grossTax()));
		sb.append("\nAbatimento: R$ " + String.format("%.2f", taxRebate()));
		sb.append("\nImposto devido: " + String.format("%.2f", netTax()));
		
		return sb.toString();
	}
	
	
}
