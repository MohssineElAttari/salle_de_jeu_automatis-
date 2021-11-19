package salle_de_jeu_automatisé;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}

	static String valider = "";
	static int choix;
//menu
	public static void menu() {
		System.out.println("Voila la liste des jeux disponibles :");
		System.out.println("Football : \n 1 - FIFA \n 2 - PES ");
		System.out.println("Guerre : \n 3 - Counter-Strike \n 4 - Assassin's Creed");
		int choix = valide();
		while (choix < 0 || choix > 4) {
			System.out.println("ce choix n'est pas disponible dans la liste des jeux");
			choix = valide();
		}
		switch (choix) {
		case 1:
			System.out.println("choix 1");
			break;
		case 2:
			System.out.println("choix 2");
			break;
		case 3:
			System.out.println("choix 3");
			break;
		case 4:
			System.out.println("choix 4");
			break;
		default:
			System.out.println("ce choix n'est pas disponible dans la liste des jeux");
			break;
		}
	}

	public static int valide() {
		Scanner sc = new Scanner(System.in);
		String choixTemp = "";
		do {
			valider = "";
			try {

				choixTemp = sc.nextLine();
				choix = Integer.parseInt(choixTemp);

			} catch (Exception e) {
				System.out.println("veuillez entrer le nombre de jeu que vous choisie");
				valider = "null";

			}
		} while (valider == "null");
		return choix;
	}

	public static void nvJoueur(String typejeux, int duree) {

	}

}
