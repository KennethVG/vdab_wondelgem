package exercise4_04;

import java.io.*;

public class AddressBean implements Serializable {
   private String firstName;
   private String lastName;
   private String street;
   private String number;   
   private String zipCode;
   private String city;
   private String country;
   private String phone;
   private String email;
   
   public String getFirstName() {
      return firstName;
   }
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   public String getStreet() {
      return street;
   }
   public void setStreet(String street) {
      this.street = street;
   }
   public String getNumber() {
      return number;
   }
   public void setNumber(String number) {
      this.number = number;
   }
   public String getZipCode() {
      return zipCode;
   }
   public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
   }
   public String getCity() {
      return city;
   }
   public void setCity(String city) {
      this.city = city;
   }
   public String getCountry() {
      return country;
   }
   public void setCountry(String country) {
      this.country = country;
   }
   public String getPhone() {
      return phone;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   @Override
   public String toString() {
      return String
            .format(
                  "AddressBean [firstName=%s, lastName=%s, street=%s, number=%s, zipCode=%s, city=%s, country=%s, phone=%s, email=%s]",
                  firstName, lastName, street, number, zipCode, city, country,
                  phone, email);
   }
   
   
}
