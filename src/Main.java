import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int agendaTamaina=10;
        Agenda agenda;

        System.out.println("Agenda konfiguratzeko kontatu kopurua zehaztu (0 = berezko tamaina:10)");

        Agenda a= new Agenda();
        agendaTamaina = baliozkoZenbakia();

        if(agendaTamaina>0){
            agenda = new Agenda(agendaTamaina);
        }
        else{
            agenda = new Agenda(10);
        }
        System.out.println("Agenda konfiguratuta");

        String izena="";
        int aukeraketa;

        do{

            System.out.println("----------------------------");
            System.out.println("Ze operazio nahi duzu egin?");
            System.out.println("----------------------------");
            System.out.println("0 - Irten Sistematik");
            System.out.println("1 - Kontaktu berria SORTU");
            System.out.println("2 - Kontatu bat EZABATU");
            System.out.println("3 - Kontatu bat BILATU");
            System.out.println("4 - Agenda osoa bistaratu");
            System.out.println("5 - Agenda beteta dago?");
            System.out.println("6 - Zenbat hutsune daude agendan?");


            aukeraketa = baliozkoZenbakia();

            switch (aukeraketa) {
                case 0: {

                    System.out.println("Irten Sistematik");
                    exit(0);
                    break;
                }
                case 1: {//kontaktu berria sortzeko aukera

                    String telefonoZenbakia;
                    String kontaktuIzena = "";

                    //String scannerGarbiketa = sc.nextLine();

                    System.out.println("KONTAKTU BERRIA SORTU");
                    System.out.println("Sar ezazu kontaktu berriaren izena mesedez:");

                    kontaktuIzena = sc.nextLine();

                    System.out.println("Sar ezazu " + kontaktuIzena + " kontaktuaren telefono zenbakia:");

                    telefonoZenbakia = agenda.zenbakiaIrakurri();

                    agenda.kontaktuBerriaSortu(kontaktuIzena, telefonoZenbakia);

                    break;
                }
                case 2: {//kontatu bat ezabatzeko aukera

                    System.out.println("KONTAKTUA EZABATU");
                    //String scannerGarbiketa = sc.nextLine();
                    System.out.println("Ezabatu nahi duzun kontaktuaren izena idatzi mesedez:");

                    String kontaktuIzena = sc.nextLine();

                    agenda.KontaktuaEzabatu(kontaktuIzena);

                    break;
                }
                case 3: {//kontaktu bat bilatzeko

                    System.out.println("KONTAKTUA BILATU");
                    //String scannerGarbiketa = sc.nextLine();

                    System.out.println("Bilatu nahi duzun kontaktuaren izena idatzi:");

                    String kontaktuIzena = sc.nextLine();

                    agenda.KontaktuaBilatu(kontaktuIzena);

                    break;
                }
                case 4: {//agenda guztia bistaratzeko

                    System.out.println("AGENDA GUZTIA BISTARATU");
                    //String scannerGarbiketa = sc.nextLine();

                    agenda.agendaBistaratu();

                    break;
                }
                case 5: {//agenda beteta dagoen edo ez itzuliko diguen funtzioa
                    agenda.agendaBeteta();

                    if(agenda.agendaBeteta() == true) {
                        System.out.println("AGENDA BETETA DAGO");
                    }
                    else {
                        System.out.println("Agenda EZ dago beteta");
                    }
                    break;
                }
                case 6: {//zenbat hutsune dauden agendan jakiteko
                    System.out.println(agenda.zenbatHutsune() +" hutsune daude agendan");
                    break;
                }
                default: {
                    System.out.println("Ez da baliozkoa: " + aukeraketa);
                }
            }
        }
        while (aukeraketa!= 0);
    }

    private static int baliozkoZenbakia() {
        Scanner sc = new Scanner(System.in);

        int baliozkoZenbakia=0;
        boolean baliozkoBoolean=false;

        do{
            try {
                baliozkoZenbakia = sc.nextInt();
                if (baliozkoZenbakia >= 0 && baliozkoZenbakia < 11) {
                    baliozkoBoolean = true;
                }
                else {
                    System.out.println("1-10 bitarteko zenbakia sartu, mesedez");
                }
            }
            catch (Exception e) {
                sc.nextLine();
                System.out.println("1-10 bitarteko zenbakia sartu, mesedez");
            }
        }
        while (!baliozkoBoolean);

        return baliozkoZenbakia;
    }
}