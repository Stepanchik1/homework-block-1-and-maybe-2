public class Main {

    public static void main(String[] args) {
        int year = 2011;

        visokos(year);


        String android = "Android";
        String IOS = "IOS";
        // Вводим название операционной системы
        String OS = "Android";
        boolean versia = IOS.equals(OS);
        version(versia);
        vipusk(year);
        int rasstoyanie = 101;
        dostavka(rasstoyanie);

    }

    public static void dostavka (int p) {
        if (p<0) {
            System.out.println("Некорректно задано расстояние");}
        else {
            if (p <= 20) {
                System.out.println("Потребуются 1 сутки");
            } else {
                System.out.println("Потребуется " + (2+((p-1) - 20) / 40) + " суток");
            }
        }
    }

    public static void vipusk (int year) {
        if (year<2012) {
            System.out.println("Установите лайт версию приложения");
        }
    }


    public static void version (boolean version ) {
      if (version==true) {
          System.out.println("Используйте версию для IOS");}
      else {
          System.out.println("Используйте версию для Android");
      }
    }

    public static void visokos(int y) {
        if (y>=400) {
            if ((y%4 == 0&&y%100 != 0)||y%400 == 0) {
                System.out.println("Високосный год");}
            else {
                System.out.println("Невисокосный год");}}
        else if (y<400||y>=100) {
            if (y%4 == 0&&y%100 != 0) {
                System.out.println("Високосный год");}
            else {
                System.out.println("Невисокосный год");}}
        else if (y<100||y>0) {
            if (y%4 == 0) {
                System.out.println("Високосный год");}
            else {
                System.out.println("Невисокосный год");}}
        else if (y==0) {
            System.out.println("Нулевого года не существует");
        }
        else if (y<0) {
            System.out.println("Некорректно задан год");}
    }
}


