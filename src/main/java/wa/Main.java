package wa;

import java.util.List;
import java.util.Optional;

import wa.Utente;
import wa.UtenteDao;

public class Main {

	public static void main(String[] args) {
		UtenteDao cd = new UtenteDao();

        // create a new utente
        Utente tom = new Utente("Tom", "Password");
        cd.save(tom);

        // get a utente
        Optional<Utente> opt = cd.get("mariorossi");
        if (opt.isPresent()) {
            System.out.println("Utente mariorossi: " + opt.get());

            
        } else {
            System.out.println("Unexpected! Can't get utente 2");
        }
/*
        // rename a utente
        tom.setPassword("cambiopassword");
        cd.update(tom);

        opt = cd.get("mariorossi");
        if (opt.isPresent()) {
            System.out.println("Utente 1: " + opt.get());
        } else {
            System.out.println("Unexpected! Can't get utente 1");
        }

        // delete a utente
        cd.delete("Tom");

        opt = cd.get("mariorossi");
        if (opt.isPresent()) {
            System.out.println("Unexpected! Utente 501 still alive: " + opt.get());
        } else {
            System.out.println("Utente 501 is no more");
        }
        */

        // get all utenti
        List<Utente> utenti = cd.getAll();
        System.out.println("Utenti: " + utenti);
    }
	}


