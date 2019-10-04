package anxo.configuradorcoche;

public class Coche {

    private String observaciones;
    private boolean berlina;
    private boolean suv;
    private boolean familiar;
    private boolean maletero;
    private boolean alc;
    private boolean navegador;

    public Coche() {
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setBerlina(boolean berlina) {
        this.berlina = berlina;
    }

    public void setSuv(boolean suv) {
        this.suv = suv;
    }

    public void setFamiliar(boolean familiar) {
        this.familiar = familiar;
    }

    public void setMaletero(boolean maletero) {
        this.maletero = maletero;
    }

    public void setAlc(boolean alc) {
        this.alc = alc;
    }

    public void setNavegador(boolean navegador) {
        this.navegador = navegador;
    }

    public Coche(String observaciones, boolean berlina, boolean suv, boolean familiar, boolean maletero, boolean alc, boolean navegador) {
        this.observaciones = observaciones;
        this.berlina = berlina;
        this.suv = suv;
        this.familiar = familiar;
        this.maletero = maletero;
        this.alc = alc;
        this.navegador = navegador;
    }

    public String toString(){
        StringBuffer aux = new StringBuffer();

        aux.append("SODA");

        if(isSUV()){
            aux.append("- SUV ");
        } else if ( isBerlina()){
            aux.append("- BERLINA ");
        }else{
            aux.append("- FAIL ");
        }
        if(isFamiliar()){
            aux.append("- SW ");
        }
        if(hasMaletero()){
            aux.append("- MALETERO ");
        }
        if(hasAlc()){
            aux.append("- AIRE ");
        }
        if(hasNav()){
            aux.append("- NAVEGADOR ");
        }
        if( observaciones != null ) {
            aux.append("-  " + observaciones);
        }
        return aux.toString();
    }
    boolean isSUV(){
        return suv;
    }
    boolean isBerlina(){
        return berlina;
    }
    boolean isFamiliar(){
        return familiar;
    }
    boolean hasAlc(){
        return alc;
    }
    boolean hasMaletero(){
        return maletero;
    }
    boolean hasNav(){
        return navegador;
    }
}
