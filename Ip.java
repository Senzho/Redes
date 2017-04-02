package LogicaDeNegocio;

public class Ip {
    private String direcciónIp;
    private char clase;
    private String mascara;
    private String prefijo;
    private String direccionRed;
    private String direccionBroadcast;
    
    public Ip(int x1, int x2, int x3, int x4){
        this.direcciónIp=intAString(x1)+"."+intAString(x2)+"."+intAString(x3)+"."+intAString(x4);
        this.clase=calcularClase(x1);
        this.mascara=calcularMascara(this.clase);
        this.prefijo=calcularPrefijo(this.clase);
        this.direccionRed=calcularDireccionRed(x1, x2, x3, x4, this.clase);
        this.direccionBroadcast=calcularDireccionBroadcast(x1, x2, x3, x4, this.clase);
    }

    public String getDirecciónIp() {
        return direcciónIp;
    }
    public void setDirecciónIp(String direcciónIp) {
        this.direcciónIp = direcciónIp;
    }
    public char getClase() {
        return clase;
    }
    public void setClase(char clase) {
        this.clase = clase;
    }
    public String getMascara() {
        return mascara;
    }
    public void setMascara(String mascara) {
        this.mascara = mascara;
    }
    public String getPrefijo() {
        return prefijo;
    }
    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }
    public String getDireccionRed() {
        return direccionRed;
    }
    public void setDireccionRed(String direccionRed) {
        this.direccionRed = direccionRed;
    }
    public String getDireccionBroadcast() {
        return direccionBroadcast;
    }
    public void setDireccionBroadcast(String direccionBroadcast) {
        this.direccionBroadcast = direccionBroadcast;
    }
    
    public static String intAString(int valor){
        return String.valueOf(valor);
    }
    public static char calcularClase(int red1){
        char clase=' ';
        if (red1 > -1 && red1 < 128){
            clase='A';
        }
        if (red1 > 127 && red1 < 192){
            clase='B';
        }
        if (red1 > 191 && red1 < 224){
            clase='C';
        }
        if (red1 > 223 && red1 < 240){
            clase='D';
        }
        if (red1 > 239 && red1 < 248){
            clase='E';
        }
        if (red1 > 247){
            clase='I';
        }
        return clase;
    }
    public static String calcularMascara(char clase){
        String mascara="";
        switch(clase){
            case 'A':
                mascara="255.0.0.0";
            break;
            case 'B':
                mascara="255.255.0.0";
            break;
            case 'C':
                mascara="255.255.255.0";
            break;
        }
        return mascara;
    }
    public static String calcularPrefijo(char clase){
        String prefijo="";
        switch(clase){
            case 'A':
                prefijo="/8";
            break;
            case 'B':
                prefijo="/16";
            break;
            case 'C':
                prefijo="/24";
            break;
        }
        return prefijo;
    }
    public static String calcularDireccionRed(int x1, int x2, int x3, int x4, char clase){
        String direccionRed="";
        switch(clase){
            case 'A':
                direccionRed=intAString(x1)+".0.0.0";
            break;
            case 'B':
                direccionRed=intAString(x1)+"."+intAString(x2)+".0.0";
            break;
            case 'C':
                direccionRed=intAString(x1)+"."+intAString(x2)+"."+intAString(x3)+".0";
            break;
        }
        return direccionRed;
    }
    public static String calcularDireccionBroadcast(int x1, int x2, int x3, int x4, char clase){
        String direccionBroadcast="";
        switch(clase){
            case 'A':
                direccionBroadcast=intAString(x1)+".255.255.255";
            break;
            case 'B':
                direccionBroadcast=intAString(x1)+"."+intAString(x2)+".255.255";
            break;
            case 'C':
                direccionBroadcast=intAString(x1)+"."+intAString(x2)+"."+intAString(x3)+".255";
            break;
        }
        return direccionBroadcast;
    }
}
