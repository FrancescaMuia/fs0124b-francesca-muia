package it.epicode.app;

import it.epicode.library.dao.LibraryDao;
import it.epicode.library.dao.LibraryDaoImpl;
import it.epicode.library.dao.UserDaoImpl;
import it.epicode.library.entities.Book;
import it.epicode.library.entities.LibraryItem;
import it.epicode.library.entities.Magazine;
import it.epicode.library.entities.User;
import it.epicode.library.entities.enums.Frequency;
import java.util.Date;
import it.epicode.library.services.IsbValidatorImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Program {
	public static void main(String[] args) throws ParseException {
		LibraryDaoImpl biblio = new LibraryDaoImpl();
		UserDaoImpl user = new UserDaoImpl();

		LibraryItem libro1 = new Book("999999999", "1984", 1949, 1100, "George Orwell", "Distopia");
		LibraryItem libro2 = new Book("888888888", "Orgoglio e Pregiudizio", 1813, 1100, "Jane Austen", "Classico");
		LibraryItem libro3 = new Book("777777777", "Cronache del ghiaccio e del fuoco: Il gioco del trono", 1996, 694, "George R.R. Martin", "Fantasy epico");
		LibraryItem libro4 = new Book("666666666", "Il vecchio e il mare", 1952, 127, " Ernest Hemingway", "Narrativa");
		LibraryItem mag1 = new Magazine("321654987", "cucinare stanca", 2021, 50, Frequency.MENSILE);
		LibraryItem mag2 = new Magazine("123456789", "National Geographic", 2020, 30, Frequency.SEMESTRALE);
		LibraryItem mag3 = new Magazine("987654321", "Vogue", 2024, 60, Frequency.SETTIMANALE);

		//biblio.addItem(libro1);
		//biblio.addItem(libro2);
		//biblio.addItem(libro3);
		//biblio.addItem(libro4);
		//biblio.addItem(mag1);
		//biblio.addItem(mag2);
		//biblio.addItem(mag3);

		String isbn = "888888888";
		LibraryItem isbnTrovato = biblio.getItemByISBN(isbn);

		System.out.println(isbnTrovato);

		int annoPub = 1949;
		List<LibraryItem> pubAnno = biblio.getItemsByPublicationYear(annoPub);
		System.out.println("Libri pubblicati nel " + annoPub + ":" + pubAnno );


		String autore = "George Orwell";
		List<LibraryItem> autoreTrovato = biblio.getItemsByAuthor(autore);
		System.out.println("Libri dell'autore " + autore + ":" + autoreTrovato );


		String titolo = "1984";
		List<LibraryItem> titoloTrovato = biblio.getItemsByTitle(titolo);
		System.out.println("Libri con il titolo " + titolo + ":" + titoloTrovato + ":");


		String libroDaRimuovere = "999999999";
		//biblio.removeItemByISBN(libroDaRimuovere);


		Date dataDiNascita1 = new SimpleDateFormat("yyyy-MM-dd").parse("1992-05-08");
		User utente1 = new User("Anna", "Rossi", dataDiNascita1, 1);

		user.addUser(utente1);
	}
}
