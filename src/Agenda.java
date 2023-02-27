import java.util.Scanner;

public class Agenda {
    Kontaktua[] agenda;

    int agendaLuzera = 10;

    public Agenda() {
        agenda = new Kontaktua[agendaLuzera];
    }
    public Agenda(Integer agendaLuzera) {
        this.agendaLuzera = agendaLuzera;
        agenda = new Kontaktua[agendaLuzera];
    }
    public void setAgendaLuzera(int agendaLuzera) {

        this.agendaLuzera = agendaLuzera;
    }

    private boolean KontaktuaBaAlDago(Kontaktua k) {
        for (int i = 0; i < agenda.length; i++) {
            //Agenda guztia pasa, existitzen al duen ikusteko
            //existitzen bada, true itzultzen du
            if ((agenda[i] != null) && (agenda[i].equals(k))) {
                return true;
            }
        }
        return false;
    }
    public boolean kontaktuBerriaSortu(String kontaktuIzena, String telefonoZenbakia) {

        Kontaktua k = new Kontaktua(kontaktuIzena, telefonoZenbakia);
        boolean sortuDa=false;

        if (!KontaktuaBaAlDago(k)){

            for (int i = 0; i < agenda.length; i++) {
                if (agenda[i] == null) {
                    agenda[i] = k;
                    System.out.println("Ongi sortu da kontaktua!");
                    sortuDa = true;
                    return true;
                }
            }
        }
        else {
            System.out.println("Agenda beteta dago!");
        }
        if(!sortuDa){
            System.out.println("Aurretik sortutako dago izen bereko kontaktu bat!");
        }

        return false;
    }
    public String zenbakiaIrakurri() {
        Scanner sc = new Scanner(System.in);

        String telefonoZenbakia = "";
        boolean baliozkoLuzera = false;
        boolean guztiakDigituak = false;

        try {
            telefonoZenbakia = sc.nextLine();
            //guztiakDigituak = telefonoZenbakia.matches("[0-9]{9}");

                if(telefonoZenbakia.length()==9 && telefonoZenbakia.matches("[0-9]{9}")){

                    baliozkoLuzera = true;

                }
            return telefonoZenbakia;
            }

        catch(Exception e){
            System.out.println("Ez da baliozko sarrera!");
        }
        return telefonoZenbakia;
    }
    public void agendaBistaratu(){

        try{
            for (int i = 0; i < agenda.length; i++) {
                if (agenda[i]!=null) System.out.println(agenda[i].toString());
            }
        }

        catch(Exception e){
            System.out.println("Ez dago kontakturik agendan!");

        }
    }
    public void KontaktuaEzabatu(String kontaktuIzena){

        for (int i =0;i<agenda.length;i++){

            if(agenda[i].equals(kontaktuIzena)&&agenda[i]!=null&&kontaktuIzena!=null){
                agenda[i] = null;

                System.out.println("Kontaktua ongi ezabatua izan da!");
                break;
            }
            if(agenda[i] == null){

                System.out.println("Ez dago kontakturik agendan!");
            }
            if(kontaktuIzena==null){
                System.out.println("Sartu baliozko kontaktu bat!");
            }
        }
    }
    public void KontaktuaBilatu(String kontaktuIzena) {
        for (int i = 0; i < agenda.length; i++) {

            if (agenda[i]!=null && agenda[i].equals(kontaktuIzena)) {
                System.out.println("Hau da kontaktua: " + agenda[i].toString());
                break;

            }
            else {
                System.out.println("Ez da aurkitu "+kontaktuIzena+ " izeneko kontakturik agendan!");
            }
                if (agenda[i] == null) {

                System.out.println("Ez dago kontakturik agendan!");
            }
        }
    }
    public boolean agendaBeteta(){
        boolean agendaBeteta = false;

        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] != null) {
                agendaBeteta = true;
                break;
            }
        }
        return agendaBeteta;
    }
    public int zenbatHutsune(){
        int zenbatHutsune = 0;

        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i]== null) {
                zenbatHutsune++;
            }
        }
        return zenbatHutsune;
    }
}
