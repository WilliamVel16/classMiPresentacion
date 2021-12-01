package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is used for show use MouseListener and KeyListener
 * @autor William Velasco - 2042577 william.velasco@correounivalle.edu.co
 * @version v1.0.0 date: 27/11/2021
 */
public class GUI_Presentacion extends JFrame{

    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private JLabel labelImagen;
    private JTextArea textoExpectativas;
    private Titulos titulo;
    private Escucha escucha;


    /**
     * Constructor of GUI_Presentation class
     */
    public GUI_Presentacion(){
        initGUI();

        //window base configuration
        this.setTitle("Mi presentacion");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * This metod is used to set up the defatult JComponent configuration,
     * Create Listener and control objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener object and control object
        escucha = new Escucha();
        //Set up JComponents
        titulo = new Titulos("Hola soy William, oprime los botones...",Color.black);
        this.add(titulo,BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi...",
                              TitledBorder.DEFAULT_POSITION, TitledBorder.DEFAULT_POSITION,
                              new Font("Calibri",Font.PLAIN,20),Color.BLACK));

        this.add(panelDatos,BorderLayout.CENTER);

        panelDatos.addKeyListener(escucha);
        panelDatos.setFocusable(true);
        panelDatos.requestFocusInWindow(); //consultar

        miFoto = new JButton("Este soy yo");
        miFoto.addMouseListener(escucha);
        miHobby = new JButton("Este es mi hobby");
        miHobby.addMouseListener(escucha);
        misExpectativas = new JButton("Creo que...");
        misExpectativas.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);
        misExpectativas.setEnabled(true);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(10,12);
    }


    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements MouseListener, KeyListener {

        private ImageIcon image;


        @Override
        public void keyTyped(KeyEvent e) {


            panelDatos.removeAll();


                System.out.println("Char:" + e.getKeyChar());

                if(e.getKeyChar() == 'm' || e.getKeyChar() == 'M'){
                    textoExpectativas.setText("No se mucho de java pero sí de objetos\n" +
                            "Quiero aprender a crear GUI's, tengo una gran motivación en\n" +
                            "este curso, espero desarrollarlo de buena manera para\n" +
                            "estimular mis habilidades y  aumentar mi conocimiento sobre java.");
                    textoExpectativas.setBackground(null);
                    textoExpectativas.setFont(new Font("Calibri",3,18));
                    panelDatos.add(textoExpectativas);
                }

            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            panelDatos.removeAll();

            if (e.getSource() == miFoto) {
                image = new ImageIcon(getClass().getResource("/recursos/yo.jpg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            } else {
                if (e.getSource() == miHobby) {
                    if (e.getClickCount() == 2) {
                        image = new ImageIcon(getClass().getResource("/recursos/futbol.png"));
                        labelImagen.setIcon(image);
                        panelDatos.add(labelImagen);

                    }
                }
            }
            panelDatos.setFocusable(true);
            panelDatos.requestFocusInWindow();
            revalidate();
            repaint();
        }


        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}