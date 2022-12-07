public class Main {

    public static void main(String[] args) {

        Author JR = new Author("Joan ", "Rolling");
        Author JT = new Author("John ", "Tolkin");
        Author VI = new Author("Vanya ", "Ivanov");

        Book GP = new Book(2008, "Гарри Поттер", JR);
        Book VK = new Book(1954, "Влателин Колец", JT);

        System.out.println(GP.getYear() + " " + GP.getTitle() + " "+ JR.getName()+JR.getSirname());
        System.out.println(VK.getYear() + " " + VK.getTitle() + " "+ JT.getName()+JT.getSirname());
        GP.setYear(2012);
        JT.setName("Ronald ");
        System.out.println(GP.getYear() + " " + GP.getTitle() + " "+ JR.getName()+JR.getSirname());
        System.out.println(VK.getYear() + " " + VK.getTitle() + " "+ JT.getName()+JT.getSirname());
    }
    }