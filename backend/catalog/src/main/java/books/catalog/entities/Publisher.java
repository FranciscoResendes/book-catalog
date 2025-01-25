package books.catalog.entities;

import java.time.LocalDate;

public class Publisher {
    private String name;
    private String address;
    private String phone;
    private LocalDate founded;

    public Publisher() {
    }

    public Publisher(String name, String address, String phone, LocalDate founded) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFounded(LocalDate founded) {
        this.founded = founded;
    }
    
}
