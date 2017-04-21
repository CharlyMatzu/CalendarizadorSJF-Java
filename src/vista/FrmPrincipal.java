package vista;

import controlador.Control;
import controlador.Procesos;
import extras.WrapLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.text.DefaultCaret;
import objetos.EProceso;
import objetos.Fecha;

public class FrmPrincipal extends JFrame {

    
    private final Control control;
    //Tiempo
    private Fecha fecha;
    private Timer reloj;

    public FrmPrincipal() {
        initComponents();
        control = new Control();
        inicializar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pFondo = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConsola = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        lblNumProcesos = new javax.swing.JLabel();
        scrollProcesos = new javax.swing.JScrollPane();
        pProcesos = new javax.swing.JPanel();
        lblReloj = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblContexto = new javax.swing.JLabel();
        lblCargando = new javax.swing.JLabel();
        lblAtendiendo = new javax.swing.JLabel();
        lblSiguiente = new javax.swing.JLabel();
        lblTiempoRestante = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblMemoriaInicial = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblMemoriaFinal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTamanio = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemReset = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pFondo.setBackground(new java.awt.Color(255, 255, 255));

        btnNuevo.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/agregar.png"))); // NOI18N
        btnNuevo.setText("Agregar");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        txtConsola.setEditable(false);
        txtConsola.setBackground(new java.awt.Color(51, 51, 51));
        txtConsola.setColumns(20);
        txtConsola.setForeground(new java.awt.Color(0, 255, 0));
        txtConsola.setLineWrap(true);
        txtConsola.setRows(5);
        jScrollPane1.setViewportView(txtConsola);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Consola:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Procesos:");

        btnIniciar.setBackground(new java.awt.Color(255, 255, 255));
        btnIniciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.setEnabled(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        lblNumProcesos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNumProcesos.setText("0");

        scrollProcesos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollProcesos.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pProcesos.setLayout(new FlowLayout(FlowLayout.CENTER));
        scrollProcesos.setViewportView(pProcesos);

        lblReloj.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblReloj.setText("00:00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("SISTEMA OPERATIVO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Contexto:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cargando:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("PROCESADOR");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("T. Restante");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Siguiente:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Atendiendo:");

        lblContexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblContexto.setText("NO");

        lblCargando.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCargando.setText("NO");

        lblAtendiendo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAtendiendo.setText("NINGUNO");

        lblSiguiente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSiguiente.setText("NINGUNO");

        lblTiempoRestante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTiempoRestante.setText("#");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Memoria Inicial:");

        lblMemoriaInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMemoriaInicial.setText("#");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Memoria Final:");

        lblMemoriaFinal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMemoriaFinal.setText("#");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Tamaño:");

        lblTamanio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTamanio.setText("#");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("MEMORIA");

        javax.swing.GroupLayout pFondoLayout = new javax.swing.GroupLayout(pFondo);
        pFondo.setLayout(pFondoLayout);
        pFondoLayout.setHorizontalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumProcesos))
                    .addComponent(scrollProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pFondoLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(lblCargando, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFondoLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(lblContexto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel3)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pFondoLayout.createSequentialGroup()
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pFondoLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblAtendiendo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblTiempoRestante, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addGroup(pFondoLayout.createSequentialGroup()
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMemoriaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pFondoLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblTamanio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblMemoriaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pFondoLayout.setVerticalGroup(
            pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFondoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReloj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNumProcesos)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(scrollProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pFondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblContexto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblCargando))
                        .addGap(18, 18, 18)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(lblAtendiendo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(lblSiguiente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(lblTiempoRestante)))
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(pFondoLayout.createSequentialGroup()
                                .addComponent(lblTamanio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMemoriaInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMemoriaFinal)))
                        .addGap(21, 21, 21))))
        );

        jMenu1.setText("Opciones");

        menuItemReset.setText("Reset");
        menuItemReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemResetActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemReset);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        control.ejecutarProcesos(this);
        btnIniciar.setEnabled(false);
        btnNuevo.setEnabled(false);

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        if ( control.nuevoProceso(this) )
            btnIniciar.setEnabled(true);

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void menuItemResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemResetActionPerformed
        
        this.reset();
        
    }//GEN-LAST:event_menuItemResetActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtendiendo;
    private javax.swing.JLabel lblCargando;
    private javax.swing.JLabel lblContexto;
    private javax.swing.JLabel lblMemoriaFinal;
    private javax.swing.JLabel lblMemoriaInicial;
    private javax.swing.JLabel lblNumProcesos;
    private javax.swing.JLabel lblReloj;
    private javax.swing.JLabel lblSiguiente;
    private javax.swing.JLabel lblTamanio;
    private javax.swing.JLabel lblTiempoRestante;
    private javax.swing.JMenuItem menuItemReset;
    private javax.swing.JPanel pFondo;
    private javax.swing.JPanel pProcesos;
    private javax.swing.JScrollPane scrollProcesos;
    private javax.swing.JTextArea txtConsola;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo que reestablece todas las elementos y objetos (listas y variables)
     * a su valor inicial
     */
    public void reset() {
        Procesos.MEMO_INDICE = Procesos.MEMORIA_OS;
        Procesos.NUM_PROCESOS = 0;
        

        limpiarProcesos();
        //Cambiando textos
        txtConsola.setText("");
        lblNumProcesos.setText("0");
        lblTiempoRestante.setText("#");
        lblTamanio.setText("#");
        lblMemoriaInicial.setText("#");
        lblMemoriaFinal.setText("#");
        
        //Enable/Disable
        btnIniciar.setEnabled(false);
        btnNuevo.setEnabled(true);
    }
    
    /**
     * Metodo que limpia el contenedor de procesos
     */
    public void limpiarProcesos(){
        pProcesos.removeAll();
        pProcesos.repaint();
    }
    
    
    /**
     * Metodo encargado de actualizar la etiqueta de numero de procesos
     * @param num 
     */
    public void setNumeroProcesos(int num){
        lblNumProcesos.setText(""+num);   
    }
    
    
    /**
     * Se encarga de actualiza el tiempo restante del proceso en pantalla de la
     * etiqueta "tiempo restante" y del "ItemProceso".
     *
     * @param proceso proceso actual
     */
    public void tiempoRestante(EProceso proceso) {
        lblTiempoRestante.setText("" + proceso.getTiempoEjecucion());
//        getItemProceso("" + proceso.getId()).setTiempo(proceso.getTiempoEjecucion());
    }
    
    
    /**
     * Metodo que actualiza las etiquetas de memoria a las del proceso actual
     *
     * @param proceso proceso actual
     */
    public void memoria(EProceso proceso) {
        lblTamanio.setText("" + proceso.getTamanio());
        lblMemoriaInicial.setText("" + proceso.getMemoriaInicial());
        lblMemoriaFinal.setText("" + proceso.getMemoriaFinal());
    }
    
    
    /**
     * Metodo que se encarga de actualiza la etiqueta "Contexto" del cambio de
     * cambio de Contexto
     */
    public void contexto() {
        //Borrando etiquetas
        lblTiempoRestante.setText("#");
        lblTamanio.setText("#");
        lblMemoriaInicial.setText("#");
        lblMemoriaFinal.setText("#");
        
        this.consola("Cambio de contexto...");
        lblContexto.setText("SI");
        try { Thread.sleep(1000);} catch (InterruptedException e) { System.out.println(e.getMessage()); }
        lblContexto.setText("NO");
    }
    
    
    /**
     * Metodo que se encarga de actualizar la etiqueta "cargando" de cambio de
     * contexto
     */
    public void carga() {
        this.consola("Cargando proceso...");
        lblCargando.setText("SI");
        try { Thread.sleep(1000);} catch (InterruptedException e) { System.out.println(e.getMessage()); }
        lblCargando.setText("NO");
    }
    
    
    /**
     * Metodo que actualiza, cuando hay cambio de cambioDeContexto, el texto de
     * la etiqueta "Atendiendo" y "Siguiente" que indican los procesos "actual"
     * y "proximo", además del tiempo de jecucion restante del proceso actual
     *
     * @param ateniendo proceso actual
     * @param siguiente proceso proximo una vez acabe el actual
     * @param tiempoRestante tiempo del proceso
     */
    public void procesos(String ateniendo, String siguiente, int tiempoRestante) {
        lblAtendiendo.setText(ateniendo);
        lblSiguiente.setText(siguiente);
        lblTiempoRestante.setText("" + tiempoRestante);
    }
    
    
    /**
     * Metodo que inicializa ciertos objetos, atributos y propiedades de algunos
     * elementos
     */
    private void inicializar() {
        this.setTitle("Calendarizador SJF - by Carlos Zuñiga");
        this.setLocationRelativeTo(this);

        reloj();

        //WrapLayut
        pProcesos.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 5));
        //Scroll
        scrollProcesos.getVerticalScrollBar().setUnitIncrement(16);
    }
    
    
    /**
     * Se encarga de actualizar el reloj en pantalla
     */
    private void reloj() {
        reloj = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecha = new Fecha();
                lblReloj.setText(fecha.getTiempo());
                //System.out.println("Hora actualizada: " + fecha.getTiempo());
            }
        });
        reloj.start();
    }
    
    
    /**
     * Metodo que recibe como parametro una cadena la cual es mostrada en una
     * "TextArea" con su hora.
     *
     * @param mensaje mensaje que será mostrado
     */
    public void consola(String mensaje) {
        String aux = txtConsola.getText();
        aux += "[" + fecha.getTiempo() + "] - " + mensaje + "\n";
        txtConsola.setText(aux);
        manageScroll();
    }
    
    /**
     * Metodo que mantiene el scroll en la parte inferior del panel
     */
    private void manageScroll() {
        DefaultCaret caret = (DefaultCaret) txtConsola.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }
    
    /**
     * Metodo que agrega un ItemProceso al contenedor
     * @param item itemProceso
     */
    public void agregarItemProceso(ItemProceso item){
        this.pProcesos.add(item);
        //Actualiza UI
        pProcesos.validate();
        pProcesos.repaint();
    }

}//Fin clase
