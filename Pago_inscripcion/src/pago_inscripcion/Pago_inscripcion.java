package pago_inscripcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**@author GUSTAVO */
public class Pago_inscripcion extends JFrame implements ActionListener{
    private JButton boton1;
    private JLabel l1,l2,l3,l4;
    public Pago_inscripcion() {
        setLayout(null);
        boton1=new JButton("Activar Simulación");
        boton1.setBounds(10,10,180,30);
        add(boton1);
        boton1.addActionListener(this);
        l1=new JLabel("Clientes atendidos por caja:");
        l1.setBounds(10,50,400,30);
        add(l1);
        l2=new JLabel("Se marchan sin pagar:");
        l2.setBounds(10,90,400,30);
        add(l2);
        l3=new JLabel("Tiempo en cola:");
        l3.setBounds(10,130,400,30);
        add(l3);        
        l4=new JLabel("Cantidad en cola:");
        l4.setBounds(10,170,400,30);
        add(l4);        
        
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            simulacion();
        }
    }
    public void simulacion () {
        int estado1=0,estado2=0,estado3=0;
        int marchan=0;
        int llegada = 2 + (int) (Math.random () * 2);
        int salida1=-1,salida2=-1,salida3=-1;
        int cantAte1=0;
        int tiempoEnCola=0;
        int cantidadEnCola=0;
        cola cola1 = new cola ();
        for (int segundos = 0 ; segundos < 3600 ; segundos++) {
            if (llegada == segundos) {
                if (estado1==0) {
                    estado1=1;
                    salida1=segundos+50+(int)(Math.random()*50);
                } else {
                    if (estado2==0) {
                        estado2=1;
                        salida2=segundos+50+(int)(Math.random()*50);
                    } else {
                        if (estado3==0) {
                            estado3=1;
                            salida3=segundos+50+(int)(Math.random()*50);
                        } else {
                            if (cola1.cantidad()==50 ) {
                                marchan++;
                            } else {
                                if (cola1.cantidad()<=cola1.cantidad()) {
                                    cola1.insertar(segundos);
                                } else {
                                    if (cola1.cantidad()<=cola1.cantidad()) {
                                        cola1.insertar(segundos);
                                    }
                                }
                            }
                        }
                    }
                    
                }
                llegada=segundos+ 4+ (int) (Math.random () * 4);
            }
            if (salida1 == segundos) {
                cantAte1++;
                estado1=0;
                if(!cola1.vacia()) {
                    estado1=1;
                    cola1.extraer();
                    salida1=segundos+50+(int)(Math.random()*50);
                    tiempoEnCola=tiempoEnCola+(segundos);
                    cantidadEnCola++;                    
                }
            }
        }
        l1.setText("Clientes atendidos por caja:"+cantAte1);
        l2.setText("Se marchan sin pagar:"+marchan);
        l4.setText("Cantidad en cola:"+cantidadEnCola);
        
        if (cantidadEnCola>0) {
            int tiempoPromedio=tiempoEnCola/cantidadEnCola;
            l3.setText("Tiempo en cola:"+tiempoPromedio);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Pago_inscripcion super1=new Pago_inscripcion();
        super1.setBounds(0,0,390,250);
        super1.setVisible(true);
        super1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}