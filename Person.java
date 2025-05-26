//Person.java

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    protected String name;
    protected LocalDate dob;

    public Person(String name, String dobStr) {
        this.name = name;
        this.dob = parseDate(dobStr);
    }

    private LocalDate parseDate(String dobStr) {
        DateTimeFormatter formatter;
        if (dobStr.charAt(4) == '-') {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        }
        return LocalDate.parse(dobStr, formatter);
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAge() {
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Person p = new Person("Prapti", "2005-11-25");
        p.displayName();
        p.displayAge();
    }
}

