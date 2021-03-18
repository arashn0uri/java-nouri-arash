import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Persona paolo = new Persona("Paolo", "Rossi", Sesso.M);
        System.out.println(paolo);
        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String data;
        try {
            Date date = simpleDateFormat.parse("22-09-1990");
            paolo.setDataNascita(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(paolo);
        Studente gianni = new Studente("Gianni", "Bianchi", Sesso.M, 1);
        System.out.println(gianni);
        System.out.println(Compito.getNextId());
        Compito compito1 = new Compito();
        System.out.println(Compito.getNextId());
        Compito compito2 = new Compito();
        System.out.println(Compito.getNextId());
        System.out.println(compito1);
        System.out.println(compito2);
    }
}
