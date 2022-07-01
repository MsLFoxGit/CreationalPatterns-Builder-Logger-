package Netology.СreationalPatterns.Builder;

import java.util.OptionalInt;

class PersonBuilder {
    private String name;
    private String surname;
    private String age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) throw new IllegalArgumentException();
        this.age = age +  "";
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person ;
        if ( age == null ) person = new Person( name, surname );
        else person = new Person( name, surname , Integer.parseInt(age));
        return person;
    }
}
