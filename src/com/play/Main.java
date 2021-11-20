package com.play;

import java.util.Scanner;

public class Main {
//update
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}

	static String valider = "";
	static int choix;
	static int pay;
	static int choixJeuFinal;
	static int choixDureeFinal;
//menu
	public static void menu() {
		System.out.println("Voila la liste des jeux disponibles :");
		System.out.println("Football : \n 1 - FIFA \n 2 - PES ");
		System.out.println("Guerre : \n 3 - Counter-Strike \n 4 - Assassin's Creed");
		int choix = valide();
		int nb = valide1(choix);
	

	}
	public static void listDuree() {
		System.out.println("Tu peux choisie la Durée :");
		System.out.println("1 - 30 min ==========> 5DH");
		System.out.println("2 - 1h ==========> 10DH");
		System.out.println("3 - 2h ==========> 18DH");
		System.out.println("4 - 5h ==========> 40DH");
		System.out.println("5 - Joueur de luxe ==========> 65DH");
		int choix = valide();
		int dr = valideDuree(choix);
	}
	//fonction pour verifier lorsque le nombre choisie trouver dans la liste des jeux ou non 
	public static int valide1 (int nombre) {
		if (nombre <= 0 || nombre > 4) {
			System.out.println("ce choix n'est pas disponible dans la liste des jeux");
			menu();
		}
		else {
			System.out.println("DONE");
			int choixJeuFinal = nombre;
			listDuree();
			
		}

		return nombre;
		
	}
	public static int valideDuree(int nombre) {
		if (nombre <= 0 || nombre > 5) {
			System.out.println("Cette durée n'est pas disponible");
			listDuree();
		}
		else {
			System.out.println("DONE");
			payMontant(nombre);
			int choixDureeFinal = nombre;
			 
			
			
			
		}
		return nombre;
		
	}
	// function pour verifier le type de choix du joueur int ou string
	public static int valide() {
		Scanner sc = new Scanner(System.in);
		String choixTemp = "";
		do {
			valider = "";
			try {

				choixTemp = sc.nextLine();
				choix = Integer.parseInt(choixTemp);

			} catch (Exception e) {
				System.out.println("Choisit un nombre");
				valider = "null";

			}
		} while (valider == "null");
		return choix;
	}

	public static void nvJoueur(String typejeux, int duree) {
		
	}
	
	public static int payMontant(int nombre) {
		switch (nombre) {
		case 1:
			System.out.println("Veuiller paye le montant nécessaire ==> 5DH");
			break;
		case 2:
			System.out.println("Veuiller paye le montant nécessaire ==> 10DH");
			break;
		case 3:
			System.out.println("Veuiller paye le montant nécessaire ==> 18DH");
			break;
		case 4:
			System.out.println("Veuiller paye le montant nécessaire ==> 40DH");
			break;
		case 5:
			System.out.println("Veuiller paye le montant nécessaire ==> 65DH");
			break;
		}			
		return choix;
		
	}
	


}
