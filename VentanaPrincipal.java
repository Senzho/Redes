package InterfazGrafica;

import LogicaDeNegocio.CodigoDireccion;
import LogicaDeNegocio.Ip;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
eimport javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame implements MouseListener, KeyListener{
    private Container contenedor;
    private JLabel etiquetaDireccion;
    private JPanel panelIp;
    private JPanel panelTextos;
    private JScrollPane scrollInformacion;
    private JPanel panelScroll;
    private JTextField textoX1;
    private JTextField textoX2;
    private JTextField textoX3;
    private JTextField textoX4;
    private JButton botonDatos;
    
    public VentanaPrincipal(){
        iniciarComponentes();
        setTitle("Cálculo de Redes");
s        setSize(500,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void iniciarComponentes(){
        contenedor=getContentPane();
        BorderLayout borderLayoutPrincipal = new BorderLayout();
        contenedor.setLayout(borderLayoutPrincipal);
        contenedor.add(etiquetaDireccion = new JLabel("Ingresa la dirección IP:"), BorderLayout.NORTH);
        contenedor.add(panelIp = new JPanel(), BorderLayout.CENTER);
        contenedor.add(botonDatos = new JButton("Calcular Datos"), BorderLayout.SOUTH);
        botonDatos.addMouseListener(this);
        BorderLayout borderLayoutIp = new BorderLayout();
        panelIp.setLayout(borderLayoutIp);
        panelIp.add(panelTextos = new JPanel(), BorderLayout.NORTH);
        panelIp.add(scrollInformacion = new JScrollPane(panelScroll = new JPanel()), BorderLayout.CENTER);
        FlowLayout flowLayoutTextos = new FlowLayout();
        panelTextos.setLayout(flowLayoutTextos);
l        panelTextos.add(textoX1 = new JTextField(2));
        textoX1.addKeyListener(this);
        panelTextos.add(new JLabel("."));
        panelTextos.add(textoX2 = new JTextField(2));
        textoX2.addKeyListener(this);
        panelTextos.add(new JLabel("."));
        panelTextos.add(textoX3 = new JTextField(2));
        textoX3.addKeyListener(this);
        panelTextos.add(new JLabel("."));
        panelTextos.add(textoX4 = new JTextField(2));
        textoX4.addKeyListener(this);
        BoxLayout boxLayoutScroll = new BoxLayout(panelScroll, BoxLayout.Y_AXIS);
        panelScroll.setLayout(boxLayoutScroll);
    }
    public JPanel informacionIp(){
        JPanel panelInformacion = new JPanel();
        int x1=Integer.valueOf(textoX1.getText());
        int x2=Integer.valueOf(textoX2.getText());
        int x3=Integer.valueOf(textoX3.getText());
        int x4=Integer.valueOf(textoX4.getText());
        Ip ip = new Ip(x1, x2, x3, x4);
e        BoxLayout boxLayoutInfo = new BoxLayout(panelInformacion, BoxLayout.Y_AXIS);
        panelInformacion.setLayout(boxLayoutInfo);
        JLabel direccionIp;
        panelInformacion.add(direccionIp = new JLabel(ip.getDirecciónIp()));
        direccionIp.setFont(new Font(" Arial " , Font.PLAIN , 31 ));
        panelInformacion.add(new JLabel(" "));
        panelInformacion.add(new JLabel("Clase: "+ ip.getClase()));
        panelInformacion.add(new JLabel("Máscara: "+ip.getMascara()));
        panelInformacion.add(new JLabel("Prefijo: "+ip.getPrefijo()));
        panelInformacion.add(new JLabel("Dirección de Red: "+ip.getDireccionRed()));
        panelInformacion.add(new JLabel("Dirección de Broadcast: "+ip.getDireccionBroadcast()));
        panelInformacion.add(new JLabel(" "));
        return panelInformacion;
    }
    public CodigoDireccion validarDireccion(){
        CodigoDireccion codigo = CodigoDireccion.DireccionValida;
        String texto1 = textoX1.getText();
        String texto2 = textoX2.getText();
        String texto3 = textoX3.getText();
        String texto4 = textoX4.getText();
        if ("".equals(texto1) || "".equals(texto2) || "".equals(texto3) || "".equals(texto4)){
            codigo = CodigoDireccion.CamposVacios;
        }else{
            int segmento1 = Integer.parseInt(texto1);
            int segmento2 = Integer.parseInt(texto2);
            int segmento3 = Integer.parseInt(texto3);
            int segmento4 = Integer.parseInt(texto4);
            if (segmento1 > 255 || segmento2 > 255 || segmento3 > 255 || segmento4 > 255){
                codigo=CodigoDireccion.DireccionNoValida;
            }
        }
        return codigo;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource().equals(botonDatos)){
            if (validarDireccion().equals(CodigoDireccion.CamposVacios)){
                JOptionPane.showMessageDialog(null, "Debes llenar los 4 campos");
            }else{
                if (validarDireccion().equals(CodigoDireccion.DireccionNoValida)){
                    JOptionPane.showMessageDialog(null, "La dirección no es válida");
                }else{
                    panelScroll.add(informacionIp(), BorderLayout.CENTER);
                    panelScroll.setVisible(false);
                    panelScroll.setVisible(true);
                }
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent me) {
        
    }
    @Override
    public void mouseReleased(MouseEvent me) {
        
    }
    @Override
    public void mouseEntered(MouseEvent me) {
        
    }
    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if (!Character.isDigit(ke.getKeyChar())){
            ke.consume();
        }else{
            JTextField texto = (JTextField) ke.getSource();
            if (texto.getText().length()==3){
                ke.consume();
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent ke) {
        
    }
    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
}
