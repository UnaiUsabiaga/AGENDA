import java.lang.reflect.Array;
import java.util.*;

public class Kontaktua {
    private String telefonoZenbakia   ;
    public String kontaktuIzena;

    public Kontaktua(String kontaktuIzena, String telefonoZenbakia) {

        this.kontaktuIzena = kontaktuIzena;
        this.telefonoZenbakia = telefonoZenbakia;
    }

    public String toString() {
        String str = "Izena: " + kontaktuIzena   +"\n" + "Telefonoa: " + telefonoZenbakia;
        return str;
    }
@Override
public boolean equals(Object o) {
        Kontaktua k = (Kontaktua) o;
        return k.kontaktuIzena.equals(kontaktuIzena);

}

}
