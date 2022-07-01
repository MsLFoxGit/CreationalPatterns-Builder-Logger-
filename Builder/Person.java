package Netology.СreationalPatterns.Builder;

import java.util.OptionalInt;
import java.util.Random;

class Person {
    protected final String name;
    protected final String surname;
    private String age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = age + "";
    }

    public boolean hasAge() { return getAge().isPresent(); }

    public boolean hasAddress() { return address != null; }

    public String getName() { return name;}

    public String getSurname() { return surname; }

    public OptionalInt getAge() { return age == null ? OptionalInt.empty() : OptionalInt.of(Integer.parseInt(age)); }

    public String getAddress() { return address; }


    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = getAge().getAsInt() + 1 + "";
            System.out.printf("С днем рождения, %s %s!\n", getName(), getSurname());
        }
        else System.out.printf("Возраст %s %s неизвестен!\n", getName() , getSurname() );
    }

    public PersonBuilder newChildBuilder() {
        return  new PersonBuilder()
                .setSurname(getSurname())
                .setAge(new Random().nextInt(18))
                .setAddress(getAddress());
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + getName().hashCode();
        hash = 31 * hash + getSurname().hashCode();
        hash = 31 * hash + getAge().hashCode();
        hash = 31 * hash + getAddress().hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return  getName() + " "
                + getSurname() +
                ", возраст " + ( hasAge() ? getAge().getAsInt() : "Unknown" ) +
                ", адрес " +  ( hasAddress() ? getAddress()  : "Unknown" ) ;
    }
}
