package vista;

import controlador.Procesos;
import javax.swing.ImageIcon;
import objetos.EProceso;

public class ItemProceso extends javax.swing.JPanel {

    
    //Iconos
    private final String dir = "/assets/icons/";
    private final ImageIcon listo         = new ImageIcon( getClass().getResource(dir + "listo" + ".png"));
    private final ImageIcon ejecucion     = new ImageIcon( getClass().getResource(dir + "run2" + ".png"));
    private final ImageIcon bloqueado     = new ImageIcon( getClass().getResource(dir + "bloqueado" + ".png"));
    private final ImageIcon suspendido    = new ImageIcon( getClass().getResource(dir + "suspendido" + ".png"));
    private final ImageIcon finalizado    = new ImageIcon( getClass().getResource(dir + "listo" + ".png"));
    

    //Atributos
    private String nombre;
    private int tiempoRestante;
    private int estado;
    private double tamanio;
    
    
    
    public ItemProceso() {
        initComponents();
    }
    

    public ItemProceso(EProceso eProceso) {
        initComponents();

        this.nombre = eProceso.getNombre();
        this.tiempoRestante = eProceso.getTiempoEjecucion();
        this.tamanio = eProceso.getTamanio();
        this.setEstado( eProceso.getEstado() );

        //Datos de proceso
        lblNombre.setText(this.nombre);
        lblTiempo.setText("" + this.tiempoRestante);
        lblTamanio.setText("" + this.tamanio);
        lblID.setText("" + eProceso.getID());
        
        //this.setName( ""+eProceso.getId() );
        
        //this.validate();
    }
    
    
    public void setID(int id){
        lblID.setText(""+id);
        update();
    }
    
    
    public void setNombre(String nombre){
        lblNombre.setText(nombre);
        update();
    }
    
    
    public void setTiempo(int tiempo) {
        this.tiempoRestante = tiempo;
        lblTiempo.setText( ""+tiempo );
        update();
    }


    public void setTamaño(double tamanio) {
        this.tamanio = tamanio;
        lblTamanio.setText("" + this.tamanio + " MB");
        update();
    }
    
    
    
    
    public void setEstado(int estado){
        
        this.estado = estado;
        if( estado == Procesos.LISTO ){
            this.setBackground(Procesos.VERDE);
            lblIconoEstado.setIcon(listo);
        }
        
        else if( estado == Procesos.EJECUTANDOSE ){
            this.setBackground(Procesos.AZUL);
            lblIconoEstado.setIcon(ejecucion);
        }
        
        else if(estado == Procesos.BLOQUEADO){
            this.setBackground(Procesos.ROJO);
            lblIconoEstado.setIcon(bloqueado);
        }
        
        else if(estado == Procesos.SUSPENDIDO){
            this.setBackground(Procesos.AMARILLO);
            lblIconoEstado.setIcon(suspendido);
        }
        
        else{
            this.setBackground(Procesos.NEGRO);
            lblIconoEstado.setIcon(listo);
        }
        
        update();
    }
    
    private void update(){
        this.validate();
        this.repaint();
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        lblIconoEstado = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblTamanio = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 102));
        setAutoscrolls(true);

        lblNombre.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");
        lblNombre.setToolTipText("Nombre del proceso");
        lblNombre.setPreferredSize(null);

        lblTiempo.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblTiempo.setForeground(new java.awt.Color(255, 255, 255));
        lblTiempo.setText("Tiempo");
        lblTiempo.setToolTipText("Tiempo restante del proceso");
        lblTiempo.setPreferredSize(null);

        lblIconoEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/listo.png"))); // NOI18N

        lblID.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblID.setText("ID");
        lblID.setToolTipText("Identificador");

        lblTamanio.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        lblTamanio.setForeground(new java.awt.Color(255, 255, 255));
        lblTamanio.setText("Tamaño");
        lblTamanio.setToolTipText("Tamaño del proceso (MB)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIconoEstado)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTamanio)
                        .addGap(18, 18, 18)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblID)
                            .addComponent(lblTamanio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblIconoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIconoEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTamanio;
    private javax.swing.JLabel lblTiempo;
    // End of variables declaration//GEN-END:variables
}
