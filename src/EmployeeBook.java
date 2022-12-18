import java.util.Objects;
import java.util.Scanner;

public class EmployeeBook {
    private static Employee[] employee = new Employee[50000];

    public static Employee[] getEmployee() {
        return employee;
    }

    public static void setEmployee(Employee[] employee) {
        EmployeeBook.employee = employee;
    }

    public void createEmployee() {
        String FIO[] = Enter.fio();
        int Department = Enter.numberOfDepartment();
        long telephone = Enter.enterTelephoneNumber();
        boolean IsMarried = Enter.isMarried();
        int salary = Enter.salary();
        for (int i = 0; ; i++) {
            int ID = Department * 10000 + i + 1;
            if (i >= 10000) {
                System.out.println("база производственного отдела №" + Department + " заполнена");
                break;
            } else if ((EmployeeBook.getEmployee()[ID - 10001] == null) || (EmployeeBook.getEmployee()[ID - 10001].getID()) == 0) {
                employee[ID - 10001] = new Employee(FIO[0], FIO[1], FIO[2], ID, (byte) Department, telephone, IsMarried, salary);
                System.out.println("Успешно добавлен новый сотрудник: \n" + getEmployee()[ID - 10001]);
                break;
            }

        }
    }

    public static Employee searchingEmployeeByID(int ID) {
        Employee[] Searching = EmployeeBook.getEmployee();
        for (int i = 0; i < Searching.length; i++) {
            if (Searching[i] != null) {
                if ((Searching[i].getID() == ID)) {
                    return Searching[i];
                }
            }
        }
        System.out.println("По такому ID никто не найден");
        return null;
    }

    public void changeEmployee() {
        boolean exit = false;
        for (; exit == false; ) {
            System.out.println("Выберите сотрудника (или введите 0, чтоб вернуться назад)\n ID: ");
            int ID = Enter.enterIDwith0();
            if (ID == 0) {
                break;
            }
            Scanner in = new Scanner(System.in);
            if (ID > 10000 && ID < 60000) {
                if (searchingEmployeeByID(ID) != null) {
                    System.out.println("Найден сотрудник: \n" + searchingEmployeeByID(ID) + "\n \n");
                    System.out.println("Что вы хотите изменить? \n" +
                            "Фамилию - 1 \n" +
                            "Имя - 2 \n" +
                            "Отчество - 3 \n" +
                            "Номер телефона - 4 \n" +
                            "Рабочий отдел - 5 \n" +
                            "Семейный статус - 6 \n" +
                            "Зарплату - 7 \n" +
                            "ID - 8 \n" +
                            "Все параметры - 9 \n" +
                            "Назад - 0");
                    int chose = in.nextInt();
                    switch (chose) {
                        case 1:
                            Scanner in1 = new Scanner(System.in);
                            System.out.println("введите новую фамилию");
                            String surname = in1.nextLine();
                            EmployeeBook.getEmployee()[ID - 10001].setSurname(surname);
                            System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[ID - 10001]);
                            break;
                        case 2:
                            Scanner in2 = new Scanner(System.in);
                            System.out.println("введите новое имя");
                            String name = in2.nextLine();
                            EmployeeBook.getEmployee()[ID - 10001].setName(name);
                            System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[ID - 10001]);
                            break;
                        case 3:
                            Scanner in3 = new Scanner(System.in);
                            System.out.println("введите новое отчество");
                            String patronymic = in3.nextLine();
                            EmployeeBook.getEmployee()[ID - 10001].setPatronymic(patronymic);
                            System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[ID - 10001]);
                            break;
                        case 4:
                            long tel = Enter.enterTelephoneNumber();
                            EmployeeBook.getEmployee()[ID - 10001].setTelephoneNumber(tel);
                            System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[ID - 10001]);
                            break;
                        case 5:
                            int dep = Enter.numberOfDepartment();
                            EmployeeBook.getEmployee()[ID - 10001].setDepartmentNumber((byte) dep);
                            int newIDdep = Enter.generateID((byte) dep);
                            if (newIDdep==0) {System.out.println("Вы вернулись в начало (Изменить сотрудника):");
                                break;}
                            EmployeeBook.getEmployee()[newIDdep - 10001] = new Employee("", "", "", 0, (byte) 0, 0l, false, 0);
                            EmployeeBook.getEmployee()[newIDdep - 10001].setName(EmployeeBook.getEmployee()[ID - 10001].getName());
                            EmployeeBook.getEmployee()[newIDdep - 10001].setSurname(EmployeeBook.getEmployee()[ID - 10001].getSurname());
                            EmployeeBook.getEmployee()[newIDdep - 10001].setPatronymic(EmployeeBook.getEmployee()[ID - 10001].getPatronymic());
                            EmployeeBook.getEmployee()[newIDdep - 10001].setDepartmentNumber(EmployeeBook.getEmployee()[ID - 10001].getDepartmentNumber());
                            EmployeeBook.getEmployee()[newIDdep - 10001].setTelephoneNumber(EmployeeBook.getEmployee()[ID - 10001].getTelephoneNumber());
                            EmployeeBook.getEmployee()[newIDdep - 10001].setFamilyStatus(EmployeeBook.getEmployee()[ID - 10001].getFamilyStatus());
                            EmployeeBook.getEmployee()[newIDdep - 10001].setSalary(EmployeeBook.getEmployee()[ID - 10001].getSalary());
                            EmployeeBook.getEmployee()[newIDdep - 10001].setID(newIDdep);
                            EmployeeBook.getEmployee()[ID - 10001] = null;
                            System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[newIDdep - 10001]);
                            break;
                        case 6:
                            boolean married = Enter.isMarried();
                            EmployeeBook.getEmployee()[ID - 10001].setFamilyStatus(married);
                            System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[ID - 10001]);
                            break;
                        case 7:
                            int salary = Enter.salary();
                            EmployeeBook.getEmployee()[ID - 10001].setSalary(salary);
                            System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[ID - 10001]);
                            break;
                        case 8:
                            int newID = Enter.enterNewID(EmployeeBook.getEmployee()[ID - 10001].getDepartmentNumber());
                            if (EmployeeBook.getEmployee()[newID - 10001] == null) {
                                Employee change = EmployeeBook.getEmployee()[ID - 10001];
                                change.setID(newID);
                                change.setDepartmentNumber((byte) (newID / 10000));
                                EmployeeBook.getEmployee()[newID - 10001] = change;
                                EmployeeBook.getEmployee()[ID - 10001] = null;
                                System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[newID - 10001]);
                                break;
                            } else {
                                System.out.println("Сотрудник с таким ID уже существует");
                                System.out.println("Вы вернулись в начало (Изменить сотрудника):");
                                break;
                            }
                        case 9:
                            String[] FIO = Enter.fio();
                            long tellall = Enter.enterTelephoneNumber();
                            boolean marriedall = Enter.isMarried();
                            int departmentall = Enter.numberOfDepartment();
                            int salaryall = Enter.salary();
                            if ((byte) departmentall == EmployeeBook.getEmployee()[ID - 10001].getDepartmentNumber()) {
                                EmployeeBook.getEmployee()[ID - 10001].setName(FIO[0]);
                                EmployeeBook.getEmployee()[ID - 10001].setSurname(FIO[1]);
                                EmployeeBook.getEmployee()[ID - 10001].setPatronymic(FIO[2]);
                                EmployeeBook.getEmployee()[ID - 10001].setDepartmentNumber((byte) departmentall);
                                EmployeeBook.getEmployee()[ID - 10001].setTelephoneNumber(tellall);
                                EmployeeBook.getEmployee()[ID - 10001].setFamilyStatus(marriedall);
                                EmployeeBook.getEmployee()[ID - 10001].setSalary(salaryall);
                                System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[ID - 10001]);
                                break;
                            } else {
                                int newIDall = Enter.generateID((byte) departmentall);
                                EmployeeBook.getEmployee()[newIDall - 10001] = new Employee("", "", "", 0, (byte) 0, 0l, false, 0);
                                EmployeeBook.getEmployee()[newIDall - 10001].setName(FIO[0]);
                                EmployeeBook.getEmployee()[newIDall - 10001].setSurname(FIO[1]);
                                EmployeeBook.getEmployee()[newIDall - 10001].setPatronymic(FIO[2]);
                                EmployeeBook.getEmployee()[newIDall - 10001].setDepartmentNumber((byte) departmentall);
                                EmployeeBook.getEmployee()[newIDall - 10001].setTelephoneNumber(tellall);
                                EmployeeBook.getEmployee()[newIDall - 10001].setFamilyStatus(marriedall);
                                EmployeeBook.getEmployee()[newIDall - 10001].setID(newIDall);
                                EmployeeBook.getEmployee()[newIDall - 10001].setSalary(salaryall);
                                EmployeeBook.getEmployee()[ID - 10001] = null;
                                System.out.println("Данные сотрудника успешно изменены: \n" + EmployeeBook.employee[newIDall - 10001]);
                                break;
                            }
                        case 0:
                            exit = true;
                            break;
                        default:
                            System.out.println("Изменить данные сотрудника: \n");
                            break;

                    }
                } else {
                    System.out.println("\n");
                }
            } else {
                System.out.println("Некорректно задан ID");
            }
        }
    }


    public static void deleteEmployee() {
        System.out.println("Введите ID сотрудника:");
        int ID = Enter.enterID();
        System.out.println("Найден сотрудник: \n" + EmployeeBook.getEmployee()[ID - 10001] + "\nВы уверены, что хотите полностью удалить данные этого сотрудника??? \nДа - 1, нет - любое число");
        Scanner in = new Scanner(System.in);
        byte chose = in.nextByte();
        switch (chose) {
            case 1:
                String name = EmployeeBook.getEmployee()[ID - 10001].getName();
                String surname = EmployeeBook.getEmployee()[ID - 10001].getSurname();
                String patronymic = EmployeeBook.getEmployee()[ID - 10001].getPatronymic();
                EmployeeBook.getEmployee()[ID - 10001] = null;
                System.out.println("Данные сотрудника (" + surname + " " + name + " " + patronymic + " ID:" + ID + ") полностью удалены");
                break;
            default:
                break;
        }
    }


    public static void findEmployeeCicle() {
        boolean exit = false;
        for (; exit == false; ) {
            System.out.println("Как желаете искать: \n 1 - по ID \n 2 - по Ф.И.О. и номеру телефона \n 3 - Найти всех сотрудников отдела \n 4 - по зарплате \n 5 - по семейному статусу \n 0 - назад");
            Scanner in = new Scanner(System.in);
            int chose = in.nextInt();
            switch (chose) {
                case 1:
                    findExployeeForID();
                    break;
                case 2:
                    findEmployee();
                    break;
                case 3:
                    findExployeeForDepartment();
                    break;
                case 4:
                    findEmployeeForSalary();
                    break;
                case 5:
                    findForFamilyStatus();
                    break;
                case 0:
                    exit = true;
                    break;
                default:


            }

        }
    }

    public static void findEmployeeForSalary() {
        for (; ; ) {
            System.out.println("Назад - 0");
            int searching = Enter.salary();
            if (searching == 0) {
                break;
            }
            boolean findOrNo = false;
            int number = 0;
            for (int i = 0; i < EmployeeBook.getEmployee().length; i++) {
                if (EmployeeBook.getEmployee()[i] != null) {
                    if (searching == EmployeeBook.getEmployee()[i].getSalary()) {
                        if (findOrNo = false) {
                            System.out.println("Найдены следующие сотрудники: \n");
                        }
                        findOrNo = true;
                        number++;
                        System.out.println(number + ")\n" + EmployeeBook.getEmployee()[i] + "\n");
                    }
                }
            }
            if (findOrNo == false) {
                System.out.println("С данной зарплатой никто не найден");
            }

        }
    }


    public static void findEmployee() {
        for (; ; ) {
            System.out.println("Назад - 0\nВведите через запятую любые параметры из следующих: \n фамилия, имя, отчество, номер телефона \n");
            Scanner in = new Scanner(System.in);
            String searching = in.nextLine();
            String Is0 = searching.trim();
            if (Is0.equals("0")) {
                break;
            }
            String s1 = searching.replace(" ", "");
            String s2 = s1.replace(".", "");
            String s3 = s2.replace("(", "");
            String s4 = s3.replace(")", "");
            String s5 = s4.replace("-", "");
            String s6 = s5.replace("/", "");
            String s7 = s6.replace("|", "");
            String s8 = s7.replace("\\", "");
            String s9 = s8.replace(":", "");
            String s10 = s9.replace(";", "");
            String s11 = s10.toLowerCase();
            String s12 = s11 + "+++"; //Для того, чтобы не находил отчество и фамилию при схожести с именем (напр. Петров при запросе "Петр")
            String[] strings = s12.split(",");
            boolean findOrNo = false;
            int number = 0;
            for (int i = 0; i < EmployeeBook.getEmployee().length; i++) {
                if (EmployeeBook.getEmployee()[i] != null) {
                    String FIO = EmployeeBook.getEmployee()[i].getName() + "+++" + EmployeeBook.getEmployee()[i].getSurname() + "+++" + EmployeeBook.getEmployee()[i].getPatronymic() + "+++";
                    //    String IDtext = Integer.toString(EmployeeBook.getEmployee()[i].getID());
                    String teltext = Long.toString(EmployeeBook.getEmployee()[i].getTelephoneNumber());
                    String Alltext = ((teltext + "+++" + FIO).replace(" ", "")).toLowerCase();
                    for (int j = 0; j < strings.length; j++) {
                        if (Alltext.contains(strings[j]) == false) {
                            break;
                        } else if (j == strings.length - 1) {
                            if (findOrNo == false) {
                                System.out.println("Найдены сотрудники: \n");
                            }
                            findOrNo = true;
                            number++;
                            System.out.println(number + ")\n" + employee[i] + "\n");
                        }
                    }
                }
            }


            if (findOrNo == false) {
                System.out.println("По такому запросу никто не найден");

            }
        }
    }

    public static void findExployeeForID() {
        for (; ; ) {
            System.out.println("Назад - 0\nВведите ID:");
            //    Scanner in = new Scanner(System.in);
            int searching = Enter.enterIDwith0();
            if (searching == 0) {
                break;
            }
            boolean findOrNot = false;
            for (int i = 0; i < EmployeeBook.getEmployee().length; i++) {
                if (EmployeeBook.getEmployee()[i] != null) {
                    int ID = EmployeeBook.getEmployee()[i].getID();
                    if (ID == searching) {
                        findOrNot = true;
                        System.out.println("Найден сотрудник: \n");
                        System.out.println(employee[i] + "\n");
                    }
                }
            }


            if (findOrNot == false) {
                System.out.println("По такому запросу никто не найден");
            }

        }
    }

    public static void findExployeeForDepartment() {
        for (; ; ) {
            byte dep = Enter.numberOfDepartmentWith0();
            if (dep == 0) {
                break;
            }

            boolean findOrNo = false;
            int number = 0;
            for (int i = 0; i < EmployeeBook.getEmployee().length; i++) {
                if (EmployeeBook.getEmployee()[i] != null) {
                    if (dep == EmployeeBook.getEmployee()[i].getDepartmentNumber()) {
                        if (findOrNo == false) {
                            System.out.println("В " + Employee.outDepartment(dep) + " найдены следующие сотрудники: \n");
                            findOrNo = true;
                        }
                        number++;
                        System.out.println(number + ")\n" + EmployeeBook.getEmployee()[i] + "\n");
                    }
                }
            }

            if (findOrNo == false) {
                System.out.println("В " + Employee.outDepartment(dep) +" сотрудники не найдены \n");
            }
        }
    }

    public static void findForFamilyStatus() {
        int dep = Enter.numberOfDepartmentWith0and6();
        if (dep != 0) {
            boolean exit = false;
            for (;exit==false ; ) {
                System.out.println("Показать всех женатых - 1 \nПоказать всех неженатых -2\nНазад - 0");
                Scanner in = new Scanner(System.in);
                int chose = in.nextInt();
                switch (chose) {
                    case 1:
                        if (dep == 6) {
                            findForFamilyStatusYes();}
                            else {findForFamilyStatusDepYes(dep);}
                            break;
                    case 2:
                        if (dep ==6) {
                            findForFamilyStatusNo();}
                        else {findForFamilyStatusDepNo(dep);}
                        break;
                    case 0:
                        exit=true;
                        break;
                    default:
                        }
                }
            }
        }

    public static void findForFamilyStatusYes() {
            boolean findOrNo = false;
            int number = 0;
            for (int i = 0; i < EmployeeBook.getEmployee().length; i++) {
                if (EmployeeBook.getEmployee()[i] != null) {
                    if (EmployeeBook.getEmployee()[i].getFamilyStatus() == true) {
                        if (findOrNo == false) {
                            System.out.println("Найдены следующие сотрудники: \n");
                            findOrNo = true;
                        }
                        number++;
                        System.out.println(number + ")\n" + EmployeeBook.getEmployee()[i] + "\n");
                    }
                }
            }

            if (findOrNo == false) {
                System.out.println("Женатых нема");
            }

    }
    public static void findForFamilyStatusDepYes(int dep) {
        boolean findOrNo = false;
        int number = 0;
        for (int i = 0; i < 10000; i++) {
            if (EmployeeBook.getEmployee()[(dep-1)*10000+i] != null) {
                if (EmployeeBook.getEmployee()[(dep-1)*10000+i].getFamilyStatus() == true) {
                    if (findOrNo == false) {
                        System.out.println("Найдены следующие сотрудники: \n");
                        findOrNo = true;
                    }
                    number++;
                    System.out.println(number + ")\n" + EmployeeBook.getEmployee()[(dep-1)*10000+i] + "\n");
                }
            }
        }

        if (findOrNo == false) {
            System.out.println("Женатых нема");
        }
    }

    public static void findForFamilyStatusDepNo(int dep) {
        boolean findOrNo = false;
        int number = 0;
        for (int i = 0; i < 10000; i++) {
            if (EmployeeBook.getEmployee()[(dep-1)*10000+i] != null) {
                if (EmployeeBook.getEmployee()[(dep-1)*10000+i].getFamilyStatus() == false) {
                    if (findOrNo == false) {
                        System.out.println("Найдены следующие сотрудники: \n");
                        findOrNo = true;
                    }
                    number++;
                    System.out.println(number + ")\n" + EmployeeBook.getEmployee()[(dep-1)*10000+i] + "\n");
                }
            }
        }

        if (findOrNo == false) {
            System.out.println("Неженатые отсутствуют");
        }
    }
    public static void findForFamilyStatusNo() {
        boolean findOrNo = false;
        int number = 0;
        for (int i = 0; i < EmployeeBook.getEmployee().length; i++) {
            if (EmployeeBook.getEmployee()[i] != null) {
                if (EmployeeBook.getEmployee()[i].getFamilyStatus() == false) {
                    if (findOrNo == false) {
                        System.out.println("Найдены следующие сотрудники: \n");
                        findOrNo = true;
                    }
                    number++;
                    System.out.println(number + ")\n" + EmployeeBook.getEmployee()[i] + "\n");
                }
            }
        }
        if (findOrNo == false) {
            System.out.println("Неженатые отсутствуют");
        }
    }

    public static void sortingUP() {
        int salary = 0;
        for (int i = 0; i < EmployeeBook.getEmployee().length; i++) {
            if (EmployeeBook.getEmployee()[i] != null) {
                if (salary < EmployeeBook.getEmployee()[i].getSalary()) {
                    salary = EmployeeBook.getEmployee()[i].getSalary();
                }
            }
        }
        System.out.println("Самая высокая зарплата на предприятии - "+salary+" руб/мес");
    }

    public static void sortingDown() {
        int salary = 999999999;
        for (int i = 0; i < EmployeeBook.getEmployee().length; i++) {
            if (EmployeeBook.getEmployee()[i] != null) {
                if (salary > EmployeeBook.getEmployee()[i].getSalary()) {
                    salary = EmployeeBook.getEmployee()[i].getSalary();
                }
            }
        }
        System.out.println("Самая низкая зарплата на предприятии - "+salary+" руб/мес");
    }

    public static void sortingAverage() {
        int salary = 0;
        int number = 0;
        for (int i = 0; i < EmployeeBook.getEmployee().length; i++) {
            if (EmployeeBook.getEmployee()[i] != null) {
                salary = salary + EmployeeBook.getEmployee()[i].getSalary();
                number++;
            }
        }
        int average = salary/number;
        System.out.println("Средняя зарплата на предприятии - "+average+" руб/мес");
    }

    public static void sorting () {
        boolean exit = false;
        for (;exit==false;) {
            System.out.println("Какие данные хотите посмотреть?\n1 - самая высокая зарплата на предприятии\n2 - самая низкая зарплата на предприятии\n3 - средняя зарплата на предприятии\n4 - анализ для отдела\nНазад - 0)");
            Scanner in = new Scanner(System.in);
            int chose = in.nextInt();
            switch (chose) {
                case 1:
                    sortingUP();
                    break;
                case 2:
                    sortingDown();
                    break;
                case 3:
                    sortingAverage();
                    break;
                case 4:
                    sortingForDepartment();
                    break;
                case 0:
                    exit = true;
                    break;

            }
        }
    }
   public static void sortingForDepartment () {
        for (;;) {
            int dep = Enter.numberOfDepartmentWith0();
            if (dep==0) {
                System.out.println("Назад");break;}
            boolean exit = false;
            for (;exit == false;) {
            System.out.println("1 - Посчитать самую высокую зарплату в отделе \n2 - Посчитать самую высокую зарплату в отделе\n3 - Посчитать среднюю зарплату в отделе\n0 - Назад\n");
            Scanner in = new Scanner (System.in);
            int chose = in.nextInt();
switch (chose) {
    case 0:
        exit = true;
        break;
    case 1:
        sortingForDepartmentUP(dep);
        break;
    case 2:
        sortingForDepartmentDown(dep);
        break;
    case 3:
        sortingForDepartmentAverage(dep);
    default:
        break;
}
}
        }
   }

    public static void sortingForDepartmentUP (int dep) {
        int salary = 0;
        for (int i = 0; i < 10000; i++) {
            if (EmployeeBook.getEmployee()[(dep - 1) * 10000 + i] != null) {
                if (salary < EmployeeBook.getEmployee()[(dep - 1) * 10000 + i].getSalary()) {
                    salary = EmployeeBook.getEmployee()[(dep - 1) * 10000 + i].getSalary();
                }
            }
        }
        System.out.println("Самая высокая зарплата в " + Employee.outDepartment(dep) + " - " + salary + " руб/мес");
    }

    public static void sortingForDepartmentDown (int dep) {
        int salary = 999999999;
        for (int i = 0; i < 10000; i++) {
            if (EmployeeBook.getEmployee()[(dep - 1) * 10000 + i] != null) {
                if (salary > EmployeeBook.getEmployee()[(dep - 1) * 10000 + i].getSalary()) {
                    salary = EmployeeBook.getEmployee()[(dep - 1) * 10000 + i].getSalary();
                }
            }
        }

        System.out.println("Самая низкая зарплата в " + Employee.outDepartment(dep) + " - " + salary + " руб/мес");
    }

    public static void sortingForDepartmentAverage (int dep) {
        int salary = 0;
        int number = 0;
        for (int i = 0; i < 10000; i++) {
            if (EmployeeBook.getEmployee()[(dep - 1) * 10000 + i] != null) {
                salary = salary + EmployeeBook.getEmployee()[(dep - 1) * 10000 + i].getSalary();
                number++;
            }
        }
        int average = salary/number;

        System.out.println("Средняя зарплата в " + Employee.outDepartment(dep) + " - "+average+" руб/мес");
    }
}

