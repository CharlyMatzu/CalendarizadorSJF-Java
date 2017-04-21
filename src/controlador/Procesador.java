package controlador;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import objetos.EProceso;
import vista.FrmPrincipal;

public class Procesador extends Thread {

    //Extras
    DecimalFormat decimal = new DecimalFormat("#.#");
    NumberFormat nf = NumberFormat.getInstance();
    
    //Procesos
    private EProceso atendiendo;
    private EProceso siguiente;
    private final List<EProceso> listaProcesos;

    //Hilo
    private boolean continuar;
    private final Thread procesador;
    private final int tiempo = 500;

    //Principal
    private final FrmPrincipal frame;

    /**
     * Constructor que recibe como parametro una lista de procesos, un
     * tiempoRestante de quantum y una referencia al JFrame principal
     *
     * @param listaProcesos Lista de procesos
     * @param frame referencia al JFrame principal
     */
    public Procesador(List<EProceso> listaProcesos, FrmPrincipal frame) {
        this.listaProcesos = listaProcesos;
        this.frame = frame;

        //Hilo
        procesador = new Thread(this, "Hilo Procesador");
        this.continuar = true;

    }

    /**
     * Metodo que se encarga de ordenar la lista de forma ascedente de menor a
     * mayor usando su ordenamiento Natural (CompareTo)
     */
    public void ordenamientoSJF() {
        frame.consola("Ordenando procesos - SJF");
        //Ordenamiento
        Collections.sort(listaProcesos);
        //Actualizando procesos en pantalla
        actualizarProcesos();
    }
    
    /**
     * Metodo que limpia el contenedor de procesos
     * y los agrega de nuevo
     */
    public void actualizarProcesos(){
        pausa(500);
        frame.limpiarProcesos();
        for (EProceso proceso : listaProcesos) {
            pausa(500);
            frame.agregarItemProceso(proceso.getItemProceso());
        }
    }
    
    
    /**
     * metodo que asigna asignarMemoria inicial y final a cada uno de los procesos en base a su
 tamaño y los procesos anteriores
     */
    public void asignarMemoria(){
        
        //Pequeña pausa
        frame.consola("Asignando memoria.....");
        pausa(1000);
        
        //Asignando memoria
        for (EProceso proceso : listaProcesos) {
            proceso.setMemoriaInicial( redondear( Procesos.MEMO_INDICE) );
            Procesos.MEMO_INDICE += proceso.getTamanio();
            proceso.setMemoriaFinal( redondear( Procesos.MEMO_INDICE) );
            Procesos.MEMO_INDICE += .1;
        }
    }
    
    /**
     * Redondea un valor decimal a 2 digitos
     * @param valor valor a redodnear
     * @return valor redondeado
     */
    public double redondear(double valor){
        double number = -1;
        try {
            //return Double.parseDouble( decimal.format( valor ) );
            number = nf.parse( decimal.format( valor ) ).doubleValue();
        } catch (ParseException ex) { System.out.println( ex.getMessage() ); }
        return number;
    }
    

    //======================================== Metodos Hilo
    
    /**
     * Metodo que cambia la variable "continuar" a false para
     * que se detenga el ciclo de run "run"
     */
    private void detenerEjecucion() {
        this.continuar = false;
    }
    

    /**
     * Hilo de ejecucion
     */
    @Override
    public void run() {
        continuar = true;

        //Se ordena (logicamente)
        ordenamientoSJF();
        //Se asigna memoria a cada proceso
        asignarMemoria();

        //Carga de proceso
        cambioDeContexto();

        //Ciclo de Ejecución
        while (continuar) {
            pausa(this.tiempo);
            ejecutar();
        }
    }

    /**
     * El encargado de ejecutar el proceos actual; decrementar su valor en -1
     * cada vez que se "ejecute". Cuando el tiempo del proceso llega a cero se
     * realiza el cambio de contexo
     */
    private void ejecutar() {
        //Si le queda tiempo
        if (atendiendo.getTiempoEjecucion() > 0) {
            atendiendo.setTiempoEjecucion(atendiendo.getTiempoEjecucion() - 1);
            frame.tiempoRestante(this.atendiendo);
        } //Si se acaba su tiempo
        else {
            frame.consola("Proceso -" + this.atendiendo.getNombre() + "- Finalizado");
            pausa(1000);
            this.atendiendo.setEstado(Procesos.FINALIZADO);
            listaProcesos.remove(0);
            
            //CAMBIO DE CONTEXTO
            frame.contexto();
            cambioDeContexto();
        }
    }

    /**
     * Metodo que realiza el cambio de cambioDeContexto entre proceso Saca al
     * proceso actual y mete al nuevo proceso
     */
    public void cambioDeContexto() {
        
        //Si quedan proceso en lista
        if (listaProcesos.size() > 0) {

            //----Proceso a ejecutar
            this.atendiendo = listaProcesos.get(0);
            this.atendiendo.setEstado(Procesos.EJECUTANDOSE);
            frame.memoria(this.atendiendo);
            frame.carga();

            //----Proceso siguiente
            //Si queda más de un proceso (dos en adelante)
            if (listaProcesos.size() > 1) {
                this.siguiente = listaProcesos.get(1);
                frame.procesos(this.atendiendo.getNombre(), this.siguiente.getNombre(), 0);
            } else {
                this.siguiente = null;
                frame.procesos(this.atendiendo.getNombre(), "NINGUNO", 0);
            }

            frame.consola("Iniciando ejecución de proceso  -" + this.atendiendo.getNombre() + 
                            "\n" +atendiendo.toString() );
                            
        } //Si ya no quedan procesos
        else {
            frame.procesos("NINGUNO", "NINGUNO", 0);
            frame.consola("...FIN DE LA EJECUCION");
            //Termina ejecucion de Hilo
            this.detenerEjecucion();
        }
    }
    
    
    /**
     * Encargado de hacer una pequeña pausa
     * @param tiempo tiempo en milisegundos
     */
    public void pausa(int tiempo){
        try { Thread.sleep(tiempo); } 
        catch (InterruptedException e) { System.out.println(e.getMessage() ); }
    }

}
