package objetos;



import java.util.GregorianCalendar;

public class Fecha extends GregorianCalendar {

    /**
     * Constructor que recibe como parametro una cadena que representa una fecha
     * en formato dd/mm/aaaa el cual se separa en subStrings y luego son
     * convertidos en enteros para poder ser creada la nueva fecha luego son
     * asignados. Se llama un constructor de la misma clase para asignarlos
     *
     * @param fecha fecha de tipo String en formato dd/mm/aaaa
     */
    public Fecha(String fecha) {
        //Obteniendo subStrings y convirtiendo
        this(Integer.parseInt(fecha.substring(0, 2)),
                Integer.parseInt(fecha.substring(3, 5)),
                Integer.parseInt(fecha.substring(6)));
    }

    /**
     * Constructor vacio
     */
    public Fecha() {
    }

    /**
     * Constructor que recibe los parametros "día", "mes" y "Año" e inicializa
     * las horas minutos y segundos en cero Al empezar el mes en 0 este se le
     * resta "-1" para utilziar los valores conocidos
     *
     * @param dia dia del mes, por ejemplo: 1,2,3... 29,30
     * @param mes numero de mes del año: 1 = Enero, 2 = Febrero, 3 = Marzo... 12
     * = Diciembre
     * @param anio año, por ejemplo: "2015"
     */
    public Fecha(int dia, int mes, int anio) {
        super(anio, mes - 1, dia);
        this.set(Fecha.HOUR, 0);
        this.set(Fecha.MINUTE, 0);
        this.set(Fecha.SECOND, 0);
        this.set(Fecha.MILLISECOND, 0);
    }

    /**
     * Constructor que recibe como parametro un objeto del tipo "Fecha" y que
     * inicializa el objeto con los valores de dicho parametro
     *
     * @param fecha parametro tipo "Fecha" de la cual se obtienen los valores
     */
    public Fecha(Fecha fecha) {
        super(fecha.get(Fecha.YEAR), fecha.get(Fecha.MONTH), fecha.get(Fecha.DAY_OF_MONTH));
    }

    //--------------GETTERS AND SETTERS
    /**
     * Metodo que recibe como parametro el día y se lo asigna al objeto
     *
     * @param dia valor entero del día del mes, por ejemplo: 1,2,3... 30
     */
    public void setDia(int dia) {
        this.set(Fecha.DAY_OF_MONTH, dia);
    }

    /**
     * Metodo que regresa el valor entero del mes del año del objeto
     *
     * @return valor entero del dia
     */
    public int getDia() {
        return this.get(Fecha.DAY_OF_MONTH);
    }

    /**
     * Metodo que recibe como parametro el mes y se lo asigna al objeto Al
     * empezar el mes en 0 este se le resta "-1" para utilziar los valores
     * conocidos
     *
     * @param mes valor entero del mes desde 1 a 12
     */
    public void setMes(int mes) {
        this.set(Fecha.MONTH, mes - 1);
    }

    /**
     * Metodo que recibe como parametro el mes del año y se lo asigna al objeto
     * Al empezar el mes en 0 este se le suma "+1" para utilziar los valores
     * conocidos
     *
     * @return valor entero del mes del 1 al 12
     */
    public int getMes() {
        return this.get(Fecha.MONTH) + 1;
    }

    /**
     * Metodo que recibe como parametro el valor entero del año y se lo asigna
     * al objeto
     *
     * @param anio valor entero del año con 4 digitos, por ejemplo: 2015
     */
    public void setAnio(int anio) {
        this.set(Fecha.YEAR, anio);
    }

    /**
     * Metodo que regresa el valor entero del año
     *
     * @return valor entero del año en 4 digitos
     */
    public int getAnio() {
        return this.get(Fecha.YEAR);
    }

    //------------------------------ HORA
    public String getTiempo() {
        String am_pm;
        if( this.get(Fecha.AM_PM) == 0 )
                am_pm = "AM";
        else
                am_pm = "PM";
        return this.get(Fecha.HOUR_OF_DAY) + ":" + this.get(Fecha.MINUTE) + ":" + this.get(Fecha.SECOND) +" "+ am_pm;
        
        
    }

    //------------------------------- METODOS
    /**
     * Metodo que recibe como parametro un objeto del tipo "Fecha" del cual se
     * obtienen los valores "día", "mes" y "año" y son asignados al objeto. Al
     * empezar el mes en 0 este se le resta "-1" para utilziar los valores
     * conocidos
     *
     * @param fecha objeto del tipo "Fecha"
     */
    public void setFecha(Fecha fecha) {
        this.set(Fecha.DAY_OF_MONTH, fecha.get(Fecha.DAY_OF_MONTH));
        this.set(Fecha.MONTH, fecha.get(Fecha.MONTH) - 1);
        this.set(Fecha.YEAR, fecha.get(Fecha.YEAR));
    }

    /**
     * Metodo que recibe como parametro valores de "dias", "meses" y "años" y
     * calcula una nueva fecha que sera regresada como valor
     *
     * @param dias valor entero de dias que se sumaran
     * @param meses valor entero de meses que se sumaran agregandole siempre +1
     * @param anios valor entero de años que se sumaran
     * @return regresa un objeto tipo "Fecha" con la fecha calculada
     */
    public Fecha vencimiento(int dias, int meses, int anios) {
        Fecha fecha = new Fecha(this);
        fecha.add(Fecha.DAY_OF_MONTH, dias);
        fecha.add(Fecha.MONTH, (meses + 1));
        fecha.add(Fecha.YEAR, anios);
        return fecha;
    }

    /**
     * Metodo que recibe como parametro valores de "dias" y "meses" y calcula
     * una nueva fecha que sera regresada como valor
     *
     * @param dias valor entero de dias que se sumaran
     * @param meses valor entero de meses que se sumaran agregandole siempre +1
     * @return regresa un objeto tipo "Fecha" con la fecha calculada
     */
    public Fecha vencimiento(int dias, int meses) {
        return this.vencimiento(dias, meses, 0);
    }

    /**
     * Metodo que recibe como parametro valores de "dias" y calcula una nueva
     * fecha que sera regresada como valor
     *
     * @param dias valor entero de dias que se sumaran
     * @return regresa un objeto tipo "Fecha" con la fecha calculada
     */
    public Fecha vencimiento(int dias) {
        return this.vencimiento(dias, 0, 0);
    }

    /**
     * Metodo que calcula los días transcurridos desde la fecha de la clase
     * hasta la fecha dada por el parametro
     *
     * @param hasta Fecha final
     * @return retorna la diferencia de días desde la fecha de la clase hasta la
     * del parametro
     */
    public int lapso(Fecha hasta) {

        //Conversion a Dias
        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;

        long diferencia = (hasta.getTimeInMillis() - this.getTimeInMillis()) / MILLSECS_PER_DAY;
        return (int) diferencia;

    }

    /**
     * Meotod que regresa una cadena de caracteres de la fecha del objeto
     *
     * @return fecha en formato dd/mm/aaaa
     */
    @Override
    public String toString() {
        return this.getDia() + "/" + this.getMes() + "/" + this.getAnio();
    }

    // conseguir la representacion de la fecha en milisegundos
//        long milis1 = cal1.getTimeInMillis();
//        long milis2 = cal2.getTimeInMillis();
//
//        // calcular la diferencia en milisengundos
//        long diff = milis2 - milis1;
//
//        // calcular la diferencia en segundos
//        long diffSeconds = diff / 1000;
//
//        // calcular la diferencia en minutos
//        long diffMinutes = diff / (60 * 1000);
//
//        // calcular la diferencia en horas
//        long diffHours = diff / (60 * 60 * 1000);
//
//        // calcular la diferencia en dias
//        long diffDays = diff / (24 * 60 * 60 * 1000);
//
//        System.out.println("En milisegundos: " + diff + " milisegundos.");
//        System.out.println("En segundos: " + diffSeconds + " segundos.");
//        System.out.println("En minutos: " + diffMinutes + " minutos.");
//        System.out.println("En horas: " + diffHours + " horas.");
//        System.out.println("En dias: " + diffDays + " dias.");
}//end class
