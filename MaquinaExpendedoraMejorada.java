public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Numero de billetes vendidos
    private int numeroBilletes;
    //Tipo de maquina
    private String tipoDeBillete;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, String tipoBillete) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        numeroBilletes = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        tipoDeBillete = tipoBillete;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (cantidadDeDineroQueFalta <= 0) {        
             // Simula la impresion de un billete
             System.out.println("##################");
             System.out.println("# Billete de tren:");
             System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
             System.out.println("# " + precioBillete + " euros.");
             if (tipoDeBillete == "premio"){
                 System.out.println("# Enhorabuena tienes un descuento del 10% en el comercio que tu elijas.");
             }
             System.out.println("##################");
             System.out.println();         
        
             // Actualiza el total de dinero acumulado en la maquina
             totalDineroAcumulado = totalDineroAcumulado + precioBillete;
             // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
             balanceClienteActual = balanceClienteActual - precioBillete;
             //Contar numero de billetes
             numeroBilletes = numeroBilletes + 1;
        }
        else {
            System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
                        
        }
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    /**
     * Vacia todo el dinero
     */
    public int vaciarDineroDeLaMaquina() {
        int sumaDelDinero = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual > 0){
           
            sumaDelDinero = -1;
        }
        else{
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        return sumaDelDinero;     
    }
    
    /**
     * Cuenta numero de billetes vendidos
     */
    public int getNumeroBilletesVendidos(){
        return numeroBilletes;
    }
    
    /**
     * Imprime numero de billetes
     */
    public void imprimeNumeroBilletes(){
           // Imprime el numero de billetes
           System.out.println("##################");
           System.out.println("# Billetes de tren:");
           System.out.println("# Vendidos " + numeroBilletes);
           System.out.println("##################");
           System.out.println();
    }
}
