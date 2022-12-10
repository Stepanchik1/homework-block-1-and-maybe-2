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
        System.out.println(GP.getYear() + " " + GP.getTitle() + " "+ JR.getName()+JR.getSurname());
        System.out.println(VK.getYear() + " " + VK.getTitle() + " "+ JT.getName()+JT.getSurname());

boolean f = GP.equals(VK);
        System.out.println(f);
        System.out.println(VK);
        System.out.println(VK.toString());



        Book VK2 = new Book(1954, "Влателин Колец", JT);


      boolean g = VK.equals(VK2);
        System.out.println(g);
        System.out.println(VK.getClass());


        System.out.println("абвгд" == "абвгд");
        Provement A = new Provement();
        Provement B = new Provement();
        System.out.println(A.toString().equals(B.toString()));
        System.out.println(Provement.DD);
        System.out.println(A.DD == B.DD);

        System.out.println(VK.hashCode()+" "+VK2.hashCode());

    }
    }