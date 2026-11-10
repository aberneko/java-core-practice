package enums;

import java.util.ArrayList;

public class ArrayFilms {

    static void main() {
        ArrayList<Film> film = new ArrayList<>();
        film.add(new Film("Американский пирог", FilmGenre.FAMALY_FILM));
        film.add(new Film("Полтора шпиона", FilmGenre.COMEDY_FILM));
        film.add(new Film("1+1", FilmGenre.DRAMA_FILM));
        film.add(new Film("Очень страшное кино 6", FilmGenre.HORROR_FILM));
        film.add(new Film("Гарри Поттер и Философский камень", FilmGenre.FANTASY_FILM));

        FilmGenre genre = FilmGenre.COMEDY_FILM;
        searchFilmByFilterGenre(film, genre);
    }

    public static void searchFilmByFilterGenre(ArrayList<Film> arrayList, FilmGenre genre){
        for(Film film : arrayList){
            if (film.getFilmGenre() == genre) {
                System.out.println(film.getTitle());
            }
        }
    }
}

enum FilmGenre{
    FAMALY_FILM,
    COMEDY_FILM,
    DRAMA_FILM,
    HORROR_FILM,
    FANTASY_FILM
}

class Film{
    private String title;
    private FilmGenre filmGenre;

    public Film(String title, FilmGenre filmGenre){
        this.title = title;
        this.filmGenre = filmGenre;
    }

    public String getTitle(){
        return title;
    }

    public FilmGenre getFilmGenre(){
        return filmGenre;
    }

}
