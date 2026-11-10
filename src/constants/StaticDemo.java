package constants;

public class StaticDemo {
    static int count;                       // счётчик созданных объектов

    public StaticDemo(){
        count++;
    }

    static void main(){
        System.out.println(count);
        StaticDemo st = new StaticDemo();
        StaticDemo st2 = new StaticDemo();
        System.out.println(count);
    }
}


class InterfaceTarget{

    public static String theme = "тёмная";

    static void main(){

        System.out.println("Текущая тема " + theme);
        theme = "светлая";
        System.out.println("Тема изменена на " + theme);

    }
}

class Character{
     public String name;
     public static boolean isPause = false;

     public Character(String name) {
         this.name = name;
     }

     public void movie(){
         System.out.println(isPause ? name + " замарожен и не может двигатся" : name + " игрок бежит");
     }

     static void main(){

         Character character = new Character("Рыцарь");
         Character character1 = new Character("Гоблин");

         character.movie();
         character1.movie();

         isPause = true;

         character.movie();
         character1.movie();

     }
}


