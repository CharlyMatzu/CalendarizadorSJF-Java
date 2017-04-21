package controlador;

import java.util.ArrayList;
import java.util.List;
import objetos.EProceso;
import vista.DlgProceso;
import vista.FrmPrincipal;

public class Control {

    //private final FrmPrincipal frame;
    private DlgProceso dlgProceso;
    private StringBuffer accion;

    //Proceso
    private EProceso eProceso;
    private Procesador procesador;
    private final List<EProceso> listaProcesos;
    private String[] datosProceso;

    /**
     * Constructor vacio que inicializa la lista de procesos
     */
    public Control() {
        this.listaProcesos = new ArrayList<>();
    }

    //================================================ METODOS
    
    
    /**
     * Abre cuadro de dialogo para capturar nuevo proceso y posteriormente
     * agregarlo
     *
     * @param frame ventana principal
     * @return true si se agrego elemento, false su no se agrego
     */
    public boolean nuevoProceso(FrmPrincipal frame) {
        
        //Inicializando Accion como cancelar
        accion = new StringBuffer(Procesos.CANCELAR);
        //Creando proceso
        eProceso = new EProceso();
        //Capturando datos de dialogo
        dlgProceso = new DlgProceso(frame, true, accion, this.eProceso);
        
        //Si la accion fue cancelar regresa false
        if( accion.substring(0).equals(Procesos.CANCELAR) )
            return false;
        
        //Agrega proceso
        agregarProceso(this.eProceso, frame);
        return true;
        
    }

    /**
     * Metodo que crear un nuevo objeto tipo EProceso el cual le envia como
     * parametros el nombre, tiempo y tamaño del proceso.
     * @param eProceso Proceso
     * @param frame ventana principal
     */
    public void agregarProceso(EProceso eProceso, FrmPrincipal frame) {

        //Nuevo Proceso
        //eProceso = new EProceso(nombre, tiempo, tamanio);
        listaProcesos.add(eProceso);
        //Agregando a Frame
        frame.agregarItemProceso(eProceso.getItemProceso());
        frame.consola("Proceso  <" + listaProcesos.get(Procesos.NUM_PROCESOS - 1).getNombre() + ">  agregado");
        frame.setNumeroProcesos(Procesos.NUM_PROCESOS);

    }

    /**
     * Crea un nuevo objeto tipo Procesador que se encarga de ejecutar los
     * procesos creados, enviandole las lista y la clase como parametros
     *
     * @param frame ventana principal
     */
    public void ejecutarProcesos(FrmPrincipal frame) {
        procesador = new Procesador(listaProcesos, frame);
        procesador.start();
    }

   
    

    
}
