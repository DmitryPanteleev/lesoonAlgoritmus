package lesson6;

import java.time.LocalDate;

class Student {

    private String firstName;
    private String lastName;
    private int yearBirthday;
    private int montBirthday;
    private int dayMonthBirthday;
    private LocalDate birthday ;
    private int yearOfStudy;

    Student(String firstName, String lastName, int dayMonthBirthday, int montBirthday, int yearBirthday, int yearOfStudy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBirthday = yearBirthday;
        this.montBirthday = montBirthday;
        this.dayMonthBirthday = dayMonthBirthday;
        this.birthday = LocalDate.of(yearBirthday, montBirthday, dayMonthBirthday);
        this.yearOfStudy = yearOfStudy;
    }

    public void addStudy(String firstName, String lastName, int dayMonthBirthday, int montBirthday, int yearBirthday, int yearOfStudy) {
        new Student(firstName, lastName, dayMonthBirthday, montBirthday, yearBirthday, yearOfStudy);

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }
}
