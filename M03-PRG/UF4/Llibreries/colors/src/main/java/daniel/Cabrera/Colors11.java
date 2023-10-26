package daniel.Cabrera;

public class Colors11 {

    public Colors11() {

    }

    // Normal
//        public   String roig = "\033[0;31m";       /* 0 -> normal ;  31 -> red */
    public String cyan = "\033[0;36m";       /* 1 -> negrita ;  36 -> cyan */
    public String verd = "\033[0;32m";       /* 4 -> subratllat ;  32 -> green */
    public String blau = "\033[0;34m";       /* 9 -> strike ;  34 -> blue */
    public String negre = "\033[0;30m";      /* 3 -> italic; */
    public String marro = "\033[0;33m";
    public String magenta = "\033[0;35m";
    public String gris = "\033[0;37m";


    // Negreta
    public String roigN = "\033[1;31m";
    public String cyanN = "\033[1;36m";
    public String verdN = "\033[1;32m";
    public String blauN = "\033[1;34m";
    public String negreN = "\033[1;30m";
    public String marroN = "\033[1;33m";
    public String magentaN = "\033[1;35m";
    public String grisN = "\033[1;37m";


    // Cursiva
    public String roigC = "\033[3;31m";
    public String cyanC = "\033[3;36m";
    public String verdC = "\033[3;32m";
    public String blauC = "\033[3;34m";
    public String negreC = "\033[3;30m";
    public String marroC = "\033[3;33m";
    public String magentaC = "\033[3;35m";
    public String grisC = "\033[3;37m";


    // Subratllat
    public String roigS = "\033[4;31m";
    public String cyanS = "\033[4;36m";
    public String verdS = "\033[4;32m";
    public String blauS = "\033[4;34m";
    public String negreS = "\033[4;30m";
    public String marroS = "\033[4;33m";
    public String magentaS = "\033[4;35m";
    public String grisS = "\033[4;37m";


    // Ratllat
    public String roigT = "\033[9;31m";
    public String cyanT = "\033[9;36m";
    public String verdT = "\033[9;32m";
    public String blauT = "\033[9;34m";
    public String negreT = "\033[9;30m";
    public String marroT = "\033[9;33m";
    public String magentaT = "\033[9;35m";
    public String grisT = "\033[9;37m";


    // NO COLOR
    public String nc = "\033[0m";     /* to flush the previous property */



/*

EXEMPLE PRINT:

 System.out.println("\n\n\t"+verd+" PROVA"+nc+"\n");



    */


}
