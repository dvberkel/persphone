/**
 * 
 */
package org.effrafax.comiccollection.cli;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.effrafax.comiccollection.domain.model.Omnibus;
import org.effrafax.comiccollection.domain.service.CreationService;
import org.effrafax.comiccollection.domain.service.RetrievalService;

/**
 * @author dvberkel
 */
public class CommandLineInterface {

	/**
	 * The scanner to read the standard input.
	 */
	public static Scanner scanner;

	/**
	 * The {@link CommandLineInterface}.
	 * 
	 * @param args
	 *            no arguments are expected
	 */
	public static void main(String[] args) {

		scanner = new Scanner(System.in);
		System.out.println("Welkom to Comic Collection.");

		mainMenu();
		scanner.close();
	}

	/**
	 * The main menu of this {@link CommandLineInterface}.
	 */
	private static void mainMenu() {

		int option = -1;
		while (option != 0) {
			System.out.println("Main menu");
			System.out.println("1] create a Omnibus");
			System.out.println("2] Select a Omnibus");
			System.out.println("0] quit");

			option = readIntegerOption();
			switch (option) {
				case 1:
					createOmnibus();
					break;
				case 2:
					selectOmnibus();
					break;
				case 0:
					break;
				default:
					System.out.println("That was not a valid option");
			}
		}
	}

	/**
	 * This methods reads an integer from standard input and returns it.
	 * 
	 * @return an integer inputted.
	 */
	private static int readIntegerOption() {

		int input = -1;
		while (true) {
			try {
				System.out.println("Input an integer: ");
				input = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("That is not a valid option. Try again.");
			}
		}
		return input;
	}

	/**
	 * Creates an {@link Omnibus}.
	 */
	private static void createOmnibus() {

		CreationService.createOmnibus();
	}

	private static void selectOmnibus() {

		int option = -1;
		while (option != 0) {
			Collection<Omnibus> omnibusses = RetrievalService.getAllOmnibusses();

			System.out.println("Select Omnibus");
			for (Omnibus omnibus : omnibusses) {
				System.out.println(String.format("%d] Omnibus %d", omnibus.getId(), omnibus.getId()));
			}
			System.out.println("0] back to main menu");

			option = readIntegerOption();
			switch (option) {
				case 0:
					break;
				default:
					System.out.println("testing");
			}
		}

	}
}
