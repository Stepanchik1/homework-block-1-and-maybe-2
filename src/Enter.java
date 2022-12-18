import java.util.Scanner;

public class Enter {


    public static int enterNewID(byte department) {
        for (;;) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите новый ID \n или \n Чтобы сгенерировать ID автоматически введите 0");
            int chose = in.nextInt();
            if (chose == 0) {
                return generateID(department);
            } else if (chose >= 10001 && chose <= 60000) {
                return chose;
            } else {
                System.out.println("Некорректно задан ID");
            }
        }
    }

    public static int enterID () {
        for (; ; ) {
            Scanner in = new Scanner(System.in);
            int ID = in.nextInt();
            if (ID <= 10000 || ID > 60000) {
                System.out.println("Некорректно введен ID");
            } else {
                return ID;
            }
        }
    }
    public static int generateID (byte byteDepartment) {
       int department = byteDepartment;
            Employee[] Searching = EmployeeBook.getEmployee();
            if ((department > 0)&&(department<6)) {
                for (int i = 0; i < Searching.length / 5; i++) {
                    if ((Searching[department*10000+i-10000] == null) || (Searching[department*10000+i-10000].getID()) == 0) {
                        int ID = department * 10000 + i + 1;
                        return ID;
                    }
                }
                System.out.println("База отдела №" + department + " полностью занята");
                return 0;
            }

            else {
                System.out.println("Некорректно указан номер производственного отдела");}
            return 0;
        }

        public static String enterTelephone () {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите номер телефона: ");
            String num = in.nextLine();
            return num;
        }

        public static long enterTelephoneNumber () {
            String num = enterTelephone();
            //    char Empty = '';
            String num1 = num.replace('-', ' ');
            String num2 = num1.replace('(', ' ');
            String num3 = num2.replace(')', ' ');
            String num4 = num3.replace(" ", "");
            String num5 = num4.trim();
            if (num5.startsWith("+7")) {
                long numfinish = Long.parseLong(num5.replace("+7", "8"));
                return numfinish;}
            if (num5.isEmpty()) {return 0l;
            }
            long numfinish = Long.parseLong(num5);
            return numfinish;

        }

        public static String[] fio () {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            System.out.println("Введите фамилию: ");
            String surname = in.nextLine();
            System.out.println("Введите отчество: ");
            String patronymic = in.nextLine();
            String[] FIO = new String[]{name, surname, patronymic};

            return FIO;
        }

        public static int salary () {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите зарплату сотрудника: ");
            String num = in.nextLine();
            String num1 = num.replace("-", "");
            String num2 = num1.replace(")", "");
            String num3 = num2.replace("(", "");
            String num4 = num3.replace(" ", "");
            String num5 = num4.replace(",", "");
            String num6 = num5.replace(".", "");
            String num7 = num6.replace("/", "");
            System.out.println(num7);
            int salary = Integer.parseInt(num7);
            return salary;
        }

        public static byte comand () {
            Scanner in = new Scanner(System.in);
            System.out.println("Что желаете сделать? \n Нажмите: \n 1 - Создать нового сотрудника \n 2 - Изменить данные сотрудника \n 3 - Удалить сотрудника \n 4 - Найти сотрудника \n 5 - Анализ данных по зарплате \n Чтобы выйти введите 0");
            byte comand = in.nextByte();
            return comand;
        }

        public static byte numberOfDepartment () {
            for (; ; ) {
                Scanner in = new Scanner(System.in);
                System.out.println("Введите номер отдела сотрудника: \n 1 - Производственный отдел \n 2 - Отдел кадров \n 3 - Отдел разработок \n 4 - отдел продаж \n 5 - отдел обслуживания");
                int num = in.nextInt();
                byte dep = (byte) num;
                if (num > 0 && num < 6) {
                    return dep;
                }
                System.out.println("Такого отдела нет \n");
            }
        }
        public static boolean isMarried () {
            Scanner in = new Scanner(System.in);
            boolean isMarrid = false;
            for (; ; ) {
                System.out.println("Введите семейный статус: женат/не женат");
                String num = in.nextLine();
                String num1 = num.trim();
                String num2 = num1.toLowerCase();
                if (num2.equals("не женат") || num2.equals("неженат")) {
                    isMarrid = false;
                    break;

                } else if (num2.equals("женат")) {
                    isMarrid = true;
                    break;
                } else {
                    System.out.println("Некорректно введенны данные");
                }
            }

            return isMarrid;
        }

    public static int enterIDwith0 () {
        for (; ; ) {
            Scanner in = new Scanner(System.in);
            int ID = in.nextInt();
            if (ID == 0) { return 0;}
            if (ID <= 10000 || ID > 60000) {
                System.out.println("Некорректно введен ID");}
            else {
                return ID;
            }
        }
    }
    public static byte numberOfDepartmentWith0 () {
        for (; ; ) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите номер отдела сотрудника: \n 1 - Производственный отдел \n 2 - Отдел кадров \n 3 - Отдел разработок \n 4 - отдел продаж \n 5 - отдел обслуживания \n 0 - Назад");
            int num = in.nextInt();
            if (num >= 0 && num < 6) {
                byte dep = (byte)num;
                return dep;
            }
            System.out.println("Такого отдела нет \n");
        }
    }


    public static byte numberOfDepartmentWith0and6 () {
        for (; ; ) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите номер отдела сотрудника: \n 1 - Производственный отдел \n 2 - Отдел кадров \n 3 - Отдел разработок \n 4 - отдел продаж \n 5 - отдел обслуживания \n 6 - Все предприятие \n 0 - Назад");
            int num = in.nextInt();
            if (num >= 0 && num <= 6) {
                byte dep = (byte)num;
                return dep;
            }
            System.out.println("Такого отдела нет \n");
        }
    }
}






