public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }
}
