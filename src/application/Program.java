package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> taxPayer = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int N = sc.nextInt();
		
		System.out.println();
		
		for (int i = 0; i < N; i++) {
			System.out.println("Digite os dados do " + (i+1) + "o contribuinte:");
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			
			TaxPayer tp = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
			taxPayer.add(tp);
			System.out.println();
		}
		
		System.out.println();
		/*
		for (TaxPayer tp : taxPayer) {
			System.out.println(tp);
			System.out.println();
		}
		*/
		for (int i=0; i<N; i++) {
			System.out.println("Resumo do " + (i+1) + "o contribuinte: ");
			System.out.println(taxPayer);
			System.out.println();
		}
		
		
		sc.close();

	}

}
