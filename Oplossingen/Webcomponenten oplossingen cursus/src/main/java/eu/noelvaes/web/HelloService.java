package eu.noelvaes.web;

public class HelloService {
   public void handleHello(HelloBean hello) {
      System.out.println("Handling " + hello.getName());
   }
}
