/**
 * 
 */
package org.effrafax.comiccollection.cli;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.effrafax.comiccollection.domain.model.Album;
import org.effrafax.comiccollection.domain.model.Comic;
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

	/**
	 * This menu allows the selection of {@link Omnibus}ses.
	 */
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
					showComics(new Long(option));
			}
		}

	}

	/**
	 * Lists all the comics of the omnibus with {@omnibusId}
	 * 
	 * @param omnibusId
	 *            the id of the omnibus
	 */
	private static void showComics(Long omnibusId) {

		int option = -1;
		while (option != 0) {
			Omnibus omnibus = RetrievalService.getOmnibus(omnibusId);

			System.out.println(String.format("Comics in Omnibus %d", omnibusId));
			for (Comic comic : omnibus.getComics()) {
				System.out.println(String.format("%d] %s", comic.getId(), comic.getName()));
			}
			System.out.println(" 0] back to Select Omnibus");
			System.out.println("-1] Add Comic");

			option = readIntegerOption();
			switch (option) {
				case 0:
					break;
				case -1:
					addComic(omnibusId);
					break;
				default:
					showAlbums(omnibusId, new Long(option));
			}
		}

	}

	/**
	 * Adds a comic to the {@link Omnibus}.
	 * 
	 * @param omnibusId
	 *            the id of the {@link Omnibus}.
	 */
	private static void addComic(Long omnibusId) {

		System.out.println(String.format("Add comic to omnibus %d", omnibusId));
		String name = "";
		do {
			System.out.println("Enter name of comic");
			name = scanner.nextLine();
		} while (isEmpty(name));

		CreationService.addComic(omnibusId, name);
	}

	/**
	 * Determines if {@code name} is empty.
	 * 
	 * @param name
	 *            string under scrutiny
	 * @return {@code true} if {@code name} is null or contains only
	 *         whitespaces, {@code false} otherwise.
	 */
	private static boolean isEmpty(String name) {

		return isNull(name) || onlyContainsWhitespace(name);
	}

	/**
	 * Determines if {@code name} is null.
	 * 
	 * @param name
	 *            the string under scrutiny
	 * @return {@code true} if {@code name} is null, {@code false} otherwise.
	 */
	private static boolean isNull(String name) {

		return name == null;
	}

	/**
	 * Determines if {@code name} only contains whitespace.
	 * 
	 * @param name
	 *            string under scrutiny.
	 * @return {@code true} if {@code name} only contains whitespaces.
	 */
	private static boolean onlyContainsWhitespace(String name) {

		return name.trim().length() == 0;
	}

	/**
	 * Shows the albums for the comic with {@code comicId}.
	 * 
	 * @param omnibusId
	 *            id of the {@link Omnibus} to which the {@link Comic} belongs.
	 * @param comicId
	 *            if of the {@link Comic}.
	 */
	private static void showAlbums(Long omnibusId, Long comicId) {

		int option = -1;
		while (option != 0) {
			Comic comic = RetrievalService.getComic(comicId);

			System.out.println(String.format("Albums in Comic %s", comic.getName()));
			for (Album album : comic.getAlbums()) {
				System.out.println(String.format("%d) %s", album.getIndex(), album.getName()));
			}
			System.out.println(" 0] back to comic");
			System.out.println("-1] Add Album");

			option = readIntegerOption();
			switch (option) {
				case 0:
					break;
				case -1:
					addAlbum(omnibusId, comicId);
					break;
				default:
					/* Do nothing */
			}
		}
	}

	/**
	 * Adds a comic to the {@link Omnibus}.
	 * 
	 * @param omnibusId
	 *            the id of the {@link Omnibus}.
	 * @param comicId
	 *            the id of the {@link Comic}.
	 */
	private static void addAlbum(Long omnibusId, Long comicId) {

		System.out.println(String.format("Add album to comic %d", comicId));
		String name = "";
		do {
			System.out.println("Enter name of album");
			name = scanner.nextLine();
		} while (isEmpty(name));
		Integer index = null;
		do {
			System.out.println("Enter index of album");
			index = scanner.nextInt();
		} while (index == null);

		CreationService.addAlbum(omnibusId, comicId, index, name);
	}

}
