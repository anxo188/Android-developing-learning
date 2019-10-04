package anxo.calculaletranif.Core;

public class CalculoLetraNif {
    private static String alfabeto = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static char obtainLetraNif(int dni){
        return alfabeto.charAt( dni % alfabeto.length() );
    }
}
