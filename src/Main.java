public class Main {

    public static void main(String[] args) {

        Author JR = new Author("Joan ", "Rolling");
        Author JT = new Author("John ", "Tolkin");
        Author VI = new Author("Vanya ", "Ivanov");

        Book GP = new Book(2008, "Гарри Поттер", JR);
        Book VK = new Book(1954, "Влателин Колец", JT);

        System.out.println(GP.getYear() + " " + GP.getTitle() + " "+ JR.getName()+JR.getSurname());
        System.out.println(VK.getYear() + " " + VK.getTitle() + " "+ JT.getName()+JT.getSurname());
        GP.setYear(2012);
        JT.setName("Ronald ");

        System.out.println(GP.getYear() + " " + GP.getTitle() + " "+ GP.getAutor().getName()+GP.getAutor().getSurname());
        System.out.println(VK.getYear() + " " + VK.getTitle() + " "+ VK.getAutor().getName()+VK.getAutor().getSurname());

        System.out.println(GP.equals(VK)); //Проверяем equals
        Book VK2 = new Book(1954, "Влателин Колец", JT);
        System.out.println(VK.equals(VK2));
        System.out.println(VK+" и "+GP);  //Проверяем toString
        System.out.println(JT+" и "+JR);
    }
    }