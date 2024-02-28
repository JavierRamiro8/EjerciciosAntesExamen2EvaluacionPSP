package Termometro;

public class TermometroDigital extends ManejadorObserverTermometro {
    public TermometroDigital(){
        super();
    }
    public void setTemperatura(int temperatura){
        super.setTemperatura(temperatura);
        System.out.println("la temperatura es de "+temperatura+"ºC");
    }
}
