package exercise5_05;

import java.util.Locale;

public class Conversions {
   private static final float KW2HP_FACTOR = 1.341022F ;
   private static final float KM2MI_FACTOR = 0.621371192F ;
   
   public static float kw2hp(float kw){
      return kw*KW2HP_FACTOR;
   }
   
   public static float hp2kw(float hp){
      return hp/KW2HP_FACTOR;
   }
   
   public static String round(float value, int places) {
      return String.format(Locale.ENGLISH,"%."+places+"f",value);
   }

   public static float km2mi(float km){
      return km*KM2MI_FACTOR;
   }
   
   public static float mi2km(float mile){
      return mile/KM2MI_FACTOR;
   }
}
