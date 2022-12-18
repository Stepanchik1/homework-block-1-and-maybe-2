import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private int ID;
    private byte departmentNumber;
    private long telephoneNumber;
    private boolean FamilyStatus;
    private int salary;

    public Employee(String name, String surname, String patronymic, int ID, byte departmentNumber, long telephoneNumber, boolean familyStatus, int salary) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.ID = ID;
        this.departmentNumber = departmentNumber;
        this.telephoneNumber = telephoneNumber;
        this.FamilyStatus = familyStatus;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public byte getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(byte departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public long getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(long telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public boolean getFamilyStatus() {
        return FamilyStatus;
    }

    public void setFamilyStatus(boolean familyStatus) {
        FamilyStatus = familyStatus;
    }

    public String getFIO() {
        return surname + " " + name + " " + patronymic;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return ID == employee.ID && departmentNumber == employee.departmentNumber && telephoneNumber == employee.telephoneNumber && FamilyStatus == employee.FamilyStatus && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, ID, departmentNumber, telephoneNumber, FamilyStatus);
    }

    @Override
    public String toString() {
        return // "Данные сотрудника: \n" +
                "Фамилия: " + this.surname + "\n" +
                        "Имя: " + this.name + "\n" +
                        "Отчество: " + this.patronymic + "\n" +
                        "ID: " + this.ID + "\n" +
                        "Отдел: " + whatTheDepartment(this.departmentNumber) + "\n" +
                        "Зарплата: " + this.salary + " руб/мес\n" +
                        "Номер телефона: " + this.telephoneNumber + "\n" +
                        "Семейный статус: " + familyStatusToString(this.FamilyStatus)
                ;
    }

    public static String familyStatusToString(boolean FamilyStatus) {
        if (FamilyStatus == true) {
            return "женат";
        } else {
            return "не женат";
        }
    }

    public String whatTheDepartment(int i) {
        switch (i) {
            case 1:
                return "Производственный отдел";
            case 2:
                return "Отдел кадров";
            case 3:
                return "Отдел разработок";
            case 4:
                return "Отдел продаж";
            case 5:
                return "Отдел обслуживания";
            default:
                return "Отдел не указан или указан некорректно";
        }
    }

    public static String outDepartment(int dep) {
        String WhatTheDepartment = "";
        switch (dep) {
            case 1:
                WhatTheDepartment = "производственном отделе";
                break;
            case 2:
                WhatTheDepartment = "отделе кадров";
                break;
            case 3:
                WhatTheDepartment = "отделе разработок";
                break;
            case 4:
                WhatTheDepartment = "отделе продаж";
                break;
            case 5:
                WhatTheDepartment = "отделе обслуживания";
                break;
            default:
                break;

        }
        return WhatTheDepartment;
    }
}