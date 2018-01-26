package exercise4_04;

public class AddressServiceImpl implements AddressService {

   @Override
   public void registerAddress(AddressBean address) {
      System.out.println("Registration of address: " + address);
   }
}
