package java_assesment_day4_collections;

import java.util.Objects;

class Address {
    String street;
    String city;
    String state;
    String zip;

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(street, address.street) && Objects.equals(zip, address.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, zip);
    }


    @Override
    public String toString() {
        return "Street: " + street + ", City: " + city + ", State: " + state + ", Zip: " + zip;
    }
}
