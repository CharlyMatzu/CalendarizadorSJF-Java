
package objetos;

import controlador.Procesos;
import vista.ItemProceso;


public class EProceso implements Comparable<EProceso> {
    
    //Componente de interfaz gráfica
    private ItemProceso itemProceso;
    
    //Atributos
    protected int id;
    protected int estado;
    protected String nombre;
    protected int tiempoEjecucion;
    protected double tamanio;
    protected double memoriaInicial;
    protected double memoriaFinal;

    
    /**
     * Constructor vacio que crea un itemProceso
     */
    public EProceso() {
        this.itemProceso = new ItemProceso();
    }

    
    /**
     * Constructor que inicializa el ID, nombre, tiempo, tamaño y el estado del proceso
     * en "Listo", además de crear un itemProceso
     * @param nombre nombre de proceso
     * @param tiempoEjecucion tiempo de ejecucion 
     * @param tamanio tamaño
     */
    public EProceso(String nombre, int tiempoEjecucion, double tamanio) {
        this.nombre = nombre;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tamanio = tamanio;

        //Comienza en listo
        this.estado = Procesos.LISTO;
        
        //Asigna ID e incrementa para el proximo
        this.id = ++Procesos.NUM_PROCESOS;
        
        //Creando itemProceso
        this.itemProceso = new ItemProceso(this);
    }
    
    
    

    public int getID() {
        return id;
    }

    /**
     * Asigna un ID al proceso automaticamente en base a un atributo estatico
     * el cual es incremenado
     */
    public void autoSetID() {
        Procesos.NUM_PROCESOS++;
        this.id = Procesos.NUM_PROCESOS;
        this.getItemProceso().setID(Procesos.NUM_PROCESOS);
    }

    public int getEstado() {
        return estado;
    }

    /**
     * Asigna un estado
     * @param estado estado
     */
    public void setEstado(int estado) {
        this.estado = estado;
        this.getItemProceso().setEstado(estado);
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna un nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.getItemProceso().setNombre(nombre);
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    /**
     * Asigna un tiempo de ejecucion
     * @param tiempoEjecucion tiempo
     */
    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
        this.getItemProceso().setTiempo(tiempoEjecucion);
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamaño(double tamanio) {
        this.tamanio = tamanio;
        this.getItemProceso().setTamaño(tamanio);
    }

    public double getMemoriaInicial() {
        return memoriaInicial;
    }

    public void setMemoriaInicial(double memoriaInicial) {
        this.memoriaInicial = memoriaInicial;
    }

    public double getMemoriaFinal() {
        return memoriaFinal;
    }

    public void setMemoriaFinal(double memoriaFinal) {
        this.memoriaFinal = memoriaFinal;
    }

    public ItemProceso getItemProceso() {
        return itemProceso;
    }

    public void setItemProceso(ItemProceso itemProceso) {
        this.itemProceso = itemProceso;
    }

    
    //--------------------------------
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    /**
     * Metodo que indica que este objeto puede ser igual a otro
     * al comparase con el ID
     * @param obj objeto a comparar
     * @return true si son iguales, false si no lo son
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EProceso other = (EProceso) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    

    /**
     * Metodo que define el orden natural del proceso mediante su tiempo de
     * ejecucion
     *
     * @param eProceso Proceso
     * @return negativo si el proceso del parametro es mayor, positivo si es
     * menor y cero si es igual
     */
    @Override
    public int compareTo(EProceso eProceso) {
        return this.tiempoEjecucion - eProceso.tiempoEjecucion;
    }

    @Override
    public String toString() {
        return  "ID: " + getID() +
                "\n Tiempo: " + getTiempoEjecucion()  +
                "\n Tamaño: " + getTamanio() +
                "\n Memo Inicial: " + getMemoriaInicial()+ 
                "\n Memo Final: " + getMemoriaFinal();
    }
    
    
    
    
    
    
    
    
    
}
