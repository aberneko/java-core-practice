package oop.polymorphism.Generic.TypeLimitation;
import java.util.ArrayList;

public class Main {
    static void main() {

        GuestPortable<Guest> guestGuestPortable = new GuestPortable<>();
        guestGuestPortable.addGuest(new Guest("Родион", "Бонопардик"));
        guestGuestPortable.addGuest(new Guest("Олег", "Родионович"));

        GuestPortable<GuestVip> guestVipGuestPortable = new GuestPortable<>();
        guestVipGuestPortable.addGuest(new GuestVip("Кристина", "Королевская", "1234543", 3));
        guestVipGuestPortable.addGuest(new GuestVip("Евгений", "Прелесный", "3421234", 6));

        GuestPortable<GuestVipLite> guestVipLiteGuestPortable = new GuestPortable<>();
        guestVipGuestPortable.addGuest(new GuestVipLite("Кристина", "Королевская", "1234543", 3, "бомж"));

        // GuestPortable<GuestAdministrator> guestAdministratorGuestPortable = new GuestPortable<>();
        // ошибка компиляции

        guestGuestPortable.printGuests(); System.out.println();
        guestVipGuestPortable.printGuests(); System.out.println();

        VipZone<GuestVip> vipZone = new VipZone<>();
        addVipZone(guestVipGuestPortable, vipZone);
        vipZone.printAll();
        System.out.println();
        System.out.printf("Всего участников банкета в (VIP Zone): %s участника ", vipZone.total()); System.out.println();

        giveSouvenirs(guestGuestPortable);
        giveSouvenirs(guestVipGuestPortable);
        giveSouvenirs(guestVipLiteGuestPortable);

        addToSpecialTable(guestGuestPortable, new GuestVip("ewe", "fwefwe", "fwefw", 132));
        addToSpecialTable(guestVipGuestPortable, new GuestVip("ewe", "fwefwe", "fwefw", 132));
        System.out.println();
        guestGuestPortable.printGuests();
        guestVipGuestPortable.printGuests();

        //addToSpecialTable(guestVipLiteGuestPortable, new GuestVip("opiop", "jklsd", "ddfdf", 121)); // не соответсвует контрвариантности

    }

    static <T extends Guest & IVipGuest> void addVipZone(GuestPortable<T> guestVipGuestPortable, VipZone<T> vipZone){
        for(T list : guestVipGuestPortable.getArrayList()){
            vipZone.checkIn(list);
        }
    }

    static void giveSouvenirs(GuestPortable<? extends Guest> guestPortable){
        for (Guest g : guestPortable.getArrayList()){
            System.out.printf("Подарок для: %s", g.getDescription()); System.out.println();
        }
    }

    static void addToSpecialTable(GuestPortable<? super GuestVip> guests, GuestVip vip) {
        guests.addGuest(vip);
        guests.printGuests();
        vip.print();

        // Можно только тип Object
        for(Object o : guests.getArrayList()) {
            if(o instanceof Guest g){ g.print(); }
            if (o instanceof GuestVip v){ v.print(); }
        }
        // Если мы передадим сюда Вип гостя у него нет такого метода
//        for(GuestVip vip : guests.getArrayList()) {
//           vip.print();
//        }
    }
}

interface HasVipBand{
    String getBandId(); // Номер VIP-браслета
}
interface HasSeat{
    int getNumber(); // Номер места за столом
}
interface IVipGuest extends HasVipBand, HasSeat {}

class Guest {

    String name;
    String surname;

    public Guest(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String getDescription(){
        return "Крестьянин: " + name + " " + surname;
    }

    // метод для понятия огроничение снизу запрещает читать
   public void print(){
       System.out.println("Ты дурачёк");
   }
}

class GuestVip extends Guest implements IVipGuest{

    String bandId;
    int seatNumber;

    public GuestVip(String name, String surname, String bandId, int seatNumber){
        super(name,surname);
        this.bandId = bandId;
        this.seatNumber = seatNumber;
    }

//    @Override
//    public String getDescription(){
//        return "Дворянин: " + name + " " + surname;
//    }

    @Override
    public String getBandId(){
        return bandId;
    }

    @Override
    public int getNumber(){
        return seatNumber;
    }

}

// если бы у меня был наследник класса GuestVip для ограничения снизу то выскочила бы ошибка
class GuestVipLite extends GuestVip{

    String type;

    public GuestVipLite(String name, String surname, String bandId, int seatNumber, String type){
        super(name,surname,bandId,seatNumber);
        this.type = type;
    }

    public String getType(){
        return type;
    }

}

class GuestPortable<T extends Guest>{ // bounded type parameter
    //  ограничением по верхней границе (upper bound) или ограничением параметра типа сверху.

    ArrayList<T> arrayList = new ArrayList<>();

    public void addGuest(T guest){
        arrayList.add(guest);
    }

    public ArrayList<T> getArrayList(){
        return arrayList;
    }

    public void printGuests(){
        for (T type : arrayList){
            System.out.println(type.getDescription());
        }
    }
}

class VipZone<T extends Guest & IVipGuest>{
    ArrayList<T> list = new ArrayList<>();

    void checkIn(T guest){
        System.out.println("Регистрация (ФИО): " + guest.getDescription());
        System.out.println("Браслет: №" + guest.getBandId() +
                ", Номер столика №" + guest.getNumber()); System.out.println();
        list.add(guest);
    }

    public int total() {
        return list.size();
    }

    public void printAll() {
        for (T guest : list) {
            System.out.println(guest.getDescription() +
                    " [band = " + guest.getBandId() +
                    ", seat = " + guest.getNumber() + "]");
        }
    }
}

// Не унаследован
class GuestAdministrator{

    String login;
    String password;

    public GuestAdministrator(String login, String password){
        this.login = login;
        this.password = password;
    }

}

