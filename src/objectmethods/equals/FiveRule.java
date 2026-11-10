package objectmethods.equals;

import java.util.Objects;

public class FiveRule {

    public static void main(String[] args) {
        Song theRockBandSong = new Song("Popular MethodEquals.Song", "The Rock Band", "John Doe");
        Song johnDoeSong = new Song("Popular MethodEquals.Song", "The Rock Band", "John Doe");

        Song rapSong = new Song("A song about a hard life", "Popular Rapper", "Popular Rapper");

        Song richardRoeSong = new Song("A song about a hard life", "Popular Rapper", "Richard Roe");

        //  рефлексивность
        boolean check0 = false;
        if (johnDoeSong.equals(johnDoeSong)) {
            check0 = true;
        }

        //  симметричность
        boolean check1 = false;
        if (theRockBandSong.equals(johnDoeSong) &&
                johnDoeSong.equals((Object) theRockBandSong)) {
            check1 = true;
        }

        // неравенство объекту другого класса
        boolean check2 = false;
        if (!rapSong.equals(42)) {
            check2 = true;
        }

        // неравенство пустой ссылке
        boolean check3 = false;
        if (!theRockBandSong.equals(null)) {
            check3 = true;
        }

        //правильное сравнение объектов одного класса
        boolean check4 = true;
        if (richardRoeSong.equals(johnDoeSong)) {
            check4 = false;
        }

        //  ранзитивность
        boolean check5 = false;
        Song popularSong = new Song("Popular MethodEquals.Song", "The Rock Band", "John Doe");
        if (popularSong.equals(theRockBandSong) && theRockBandSong.equals(johnDoeSong)
                && popularSong.equals(johnDoeSong)) {
            check5 = true;
        }

        //  согласованность
        boolean check6 = true;
        boolean result = rapSong.equals(richardRoeSong);
        for (int i = 0; i < 10; i++) {
            if (rapSong.equals(richardRoeSong) != result) {
                check6 = false;
            }
        }

        if (check0 && check1 && check2 &&
                check3 && check4 && check5 && check6) {
            System.out.println("Поздравляем! Метод equals реализован верно.");
        } else {
            System.out.println("Что-то здесь не так.");
        }
    }

}

class Song {
    public final String title;
    public final String artist;
    public final String songwriter;

    public Song(String title, String artist, String songwriter) {
        this.title = title;
        this.artist = artist;
        this.songwriter = songwriter;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        Song son = (Song) object;
        return Objects.equals(title, son.title) &&
                Objects.equals(artist, son.artist) &&
                Objects.equals(songwriter, son.songwriter);
    }

}
