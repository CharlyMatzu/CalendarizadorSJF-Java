
package controlador;

import java.awt.Color;
import java.util.Random;


public class Procesos {
    
    //-----Atributos ESTATICOS
    public static int NUM_PROCESOS = 0;
    public static final double MEMORIA_OS = 2.1;
    public static double MEMO_INDICE = Procesos.MEMORIA_OS;
    
    //Estados
    public static final int EJECUTANDOSE = 1;
    public static final int LISTO = 2;
    public static final int BLOQUEADO = 3;
    public static final int SUSPENDIDO = 4;
    public static final int FINALIZADO = 5;
    
    //Acciones
    public static final String ACEPTAR = "Apectar";
    public static final String CANCELAR = "Cancelar";
    
    //-------------ITEM PROCESO
    //Colores
    public static final Color AZUL        = new Color(26, 143, 243);
    public static final Color VERDE       = new Color(53, 196, 109);
    public static final Color ROJO        = new Color(233, 77, 84);
    public static final Color AMARILLO    = new Color(246, 198, 47);
    public static final Color NEGRO       = new Color(102, 102, 102);
    
    private static final Random rnd = new Random();
    
    /**
     * Metodo que regresa un valor aleatorio dentro de un rango
     * @param DESDE
     * @param HASTA
     * @return 
     */
    public static int random(int DESDE, int HASTA){
        return rnd.nextInt(HASTA-DESDE+1)+DESDE;
    }
    
    /**
     * Metodo que regresa un valor aleatorio dentro de un rango
     * @param DESDE
     * @param HASTA
     * @return 
     */
    public static double random(double DESDE, double HASTA){
        return rnd.nextDouble() * HASTA + DESDE;
    }
    
}
