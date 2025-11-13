package vista;

import controlador.Error;
import controlador.MiLista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import modelo.Cliente;

/**
 *
 * @author Mª Del Pilar Parra Vergara 1º DAM
 */
public class Vista extends JFrame{
    
    //Etiquetas para identificar los campos de texto
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel fechaNacLabel;
    private JLabel edadLabel;
    private JLabel saldoLabel;
    private JLabel saldoMaxLabel;
    
    //Cadenas para las etiquetas
    private static String numeroString = "Número: ";
    private static String nombreString = "Nombre: ";
    private static String fechaNacString = "Fecha Nac: ";
    private static String edadString = "Edad: ";
    private static String saldoString = "Saldo: ";
    private static String saldoMaxString = "Saldo Max: ";    

    //Text fields para introducir números
    private TextField numeroField;
    private TextField nombreField;
    private TextField fechaNacField;
    private TextField edadField;
    private TextField saldoField;
    private TextField saldoMaxField;
    
    //Botones para movernos por los clientes 
    private JButton principioButton;
    private JButton anteriorButton;
    private JButton siguienteButton;
    private JButton finalButton;
    
    //Botones para borrar, insertar, modificar y ordenar
    private JButton borrarButton;
    private JButton insertarButton;
    private JButton modificarButton;
    private JButton ordenarButton;
    
    //Botones para aceptar y cancelar
    private JButton aceptarButton;
    private JButton cancelarButton;
    
    // Panel que contendrá los botones aceptar y cancelar
    JPanel buttonJPanelConfirmacion;
    JPanel buttonJPanelAccion;
    
    // Operación para que el botón Aceptar sepa quien le ha llamado y pueda hacer la operación que corresponda
    private String operacion;
    
    public Vista() {
        super ("Pilar Parra");
       //Creamos las etiquetas.
        numeroLabel = new JLabel(numeroString);
        nombreLabel = new JLabel(nombreString);
        fechaNacLabel = new JLabel (fechaNacString);
        edadLabel = new JLabel(edadString);
        saldoLabel = new JLabel(saldoString);
        saldoMaxLabel = new JLabel(saldoMaxString);

        //Campo donde vamos a introducir el número
        numeroField = new TextField(10);
        //Campo donde se va a introducir el nombre
        nombreField = new TextField(10);
        //Campo para introducir la fecha de nacimiento
        fechaNacField = new TextField(10);
        //Campo donde vamos a introducir la edad
        edadField = new TextField(10);
        //En este campo se introducira el saldo
        saldoField = new  TextField(10);
        //Campo que muestra el saldo máximo
        saldoMaxField = new TextField(10);
        
        //Instancia los botones para poder movernos 
        principioButton = new JButton("Principio");
        anteriorButton = new JButton("Anterior");
        siguienteButton = new JButton("Siguiente");
        finalButton = new JButton("Final");
        
        //Instancia los botones borrar, insertar, modificar y ordenar
        borrarButton = new JButton("Borrar");
        insertarButton = new JButton("Insertar");
        modificarButton = new JButton("Modificar");
        ordenarButton = new JButton("Ordenar");
        
        //Instancia los botones aceptar y cancelar
        aceptarButton = new JButton("Aceptar");
        cancelarButton = new JButton("Cancelar");
        
        // Instanciamos la lista
        MiLista miLista = new MiLista();
        // Sirve para convertir de DATE a Sring en el formato DD/MM/YYYY
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        
        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(0, 1));
        labelPanel.add(numeroLabel);
        labelPanel.add(nombreLabel);
        labelPanel.add(fechaNacLabel);
        labelPanel.add(edadLabel);
        labelPanel.add(saldoLabel);
        labelPanel.add(saldoMaxLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(0, 1));
        fieldPanel.add(numeroField);
        fieldPanel.add(nombreField);
        fieldPanel.add(fechaNacField);
        fieldPanel.add(edadField);
        fieldPanel.add(saldoField);
        fieldPanel.add(saldoMaxField);
        
        //Se crea el panel que contiene los botones de movimiento
        JPanel buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new GridLayout(1,0));
        
        //Se añaden los botones de movimiento
        buttonJPanel.add(principioButton);
        buttonJPanel.add(anteriorButton);
        buttonJPanel.add(siguienteButton);
        buttonJPanel.add(finalButton);
        
        //Se crea el panel que contiene los botones de acción
        buttonJPanelAccion = new JPanel();
        buttonJPanelAccion.setLayout(new GridLayout(1,0));
        
        //Se añaden los botones de acción
        buttonJPanelAccion.add(borrarButton);
        buttonJPanelAccion.add(insertarButton);
        buttonJPanelAccion.add(modificarButton);
        buttonJPanelAccion.add(ordenarButton);
        
        //Se crea el panel que contiene los botones de aceptar y cancelar
        buttonJPanelConfirmacion = new JPanel();
        buttonJPanelConfirmacion.setLayout(new GridLayout(1,0));
        
        // Se añaden los botones aceptar y cancelar
        buttonJPanelConfirmacion.add(aceptarButton);
        buttonJPanelConfirmacion.add(cancelarButton);
        
//        JPanel botonesPanel = new JPanel();
//        botonesPanel.setLayout(new BoxLayout(botonesPanel, BoxLayout.Y_AXIS)); // Vertical
        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(0,1,0,4));//Los numeros entre parentesis es el espacio entre los botones
        //botonesPanel.add();
        //botonesPanel.add(Box.createVerticalStrut(1)); // Espacio entre botones
        botonesPanel.add(buttonJPanel);
        //botonesPanel.add(Box.createVerticalStrut(1)); // Espacio entre botones
        botonesPanel.add(buttonJPanelAccion);
        botonesPanel.add(buttonJPanelConfirmacion);

        
        //Incluye los tres paneles en otro panel,
        //etiquetas a la izquierda, campos de texto a la derecha y botones abajo
        JPanel contentPanel = new JPanel();
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.setLayout(new BorderLayout(5,5));//Los numeros entre parentesis es el espacio entre el texto y los botones
        contentPanel.add(labelPanel, BorderLayout.CENTER);
        contentPanel.add(fieldPanel, BorderLayout.EAST);
        contentPanel.add(botonesPanel, BorderLayout.SOUTH);
        //contentPanel.add(buttonJPanelAccion, BorderLayout.AFTER_LINE_ENDS);
        
        //Contenedor del objeto "Doble", hijo de JFrame
        setContentPane(contentPanel);  //this.setContentPane(contentPane);       
        
        // Al inicio ocultamos el panel de los botones aceptar y cancelar
        buttonJPanelConfirmacion.setVisible(false);
        
        // Al inicio deshabilitamos los campos
        numeroField.setEnabled(false);
        nombreField.setEnabled(false);
        fechaNacField.setEnabled(false);
        edadField.setEnabled(false);
        saldoField.setEnabled(false);
        saldoMaxField.setEnabled(false);
        
         // Al inicio deshabilitamos todos los botones de movimiento
        principioButton.setEnabled(false);
        anteriorButton.setEnabled(false);
        siguienteButton.setEnabled(false);
        finalButton.setEnabled(false);
                
        //Evento del boton principio
        principioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Principio");
                // Llamamos al método ir al principio que nos devuelve el primer elemento
                Cliente cli = miLista.irAlPrincipio();
                // Mostramos el primer elemento
                numeroField.setText(cli.getNumero()+" ");
                nombreField.setText(cli.getNombre());
                fechaNacField.setText(fecha.format(cli.getFechaNac().getTime()));
                edadField.setText(cli.getEdad()+" ");
                saldoField.setText(cli.getSaldo()+" ");
                saldoMaxField.setText(cli.getSaldoMax()+" ");

                //Deshabilitamos botones principio y anterior y activamos siguiente y final
                principioButton.setEnabled(false); 
                anteriorButton.setEnabled(false); 
                siguienteButton.setEnabled(true);
                finalButton.setEnabled(true);
            }
        });

        //Evento del boton anterior
        anteriorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Anterior");
                // Llamamos al método anterior y recuperamos el cliente anterior
                Cliente cli = miLista.anterior();
                // Mostramos el cliente anterior
                numeroField.setText(cli.getNumero()+" ");
                nombreField.setText(cli.getNombre());
                fechaNacField.setText(fecha.format(cli.getFechaNac().getTime()));
                edadField.setText(cli.getEdad()+" ");
                saldoField.setText(cli.getSaldo()+" ");
                saldoMaxField.setText(cli.getSaldoMax()+" ");

                // Si ya estoy en el primer elemento de la lista, deshabilitamos anterior y principio y habilitamos siguiente y final
                if (miLista.getActual() == 0) {
                   principioButton.setEnabled(false);
                   anteriorButton.setEnabled(false); 
                } 
                   siguienteButton.setEnabled(true);
                   finalButton.setEnabled(true);
            }
        });
        
        //Evento del boton siguiente
        siguienteButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                System.out.println("Siguiente");
                // Llamamos al método siguiente y recuperamos el cliente siguiente
                Cliente cli = miLista.siguiente();
                // Mostramos el cliente siguiente
                numeroField.setText(String.valueOf(cli.getNumero()));
                nombreField.setText(cli.getNombre());
                fechaNacField.setText(fecha.format(cli.getFechaNac().getTime()));
                edadField.setText(String.valueOf(cli.getEdad()));
                saldoField.setText(String.valueOf(cli.getSaldo()));
                saldoMaxField.setText(String.valueOf(cli.getSaldoMax()));

                // Si hemos llegado al final, deshabilitamos siguiente y final y habilitamos principio y anterior
                if (miLista.getActual() == miLista.getClientes().size()-1) {
                   siguienteButton.setEnabled(false);
                   finalButton.setEnabled(false);
                } 
                   principioButton.setEnabled(true);
                   anteriorButton.setEnabled(true);
            }
        });
        
        //Evento del boton final
        finalButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                System.out.println("Final");
                // Llamamos al método final para ir al último cliente y lo recuperamos
                Cliente cli = miLista.irAlFinal();
                // Mostramos el último cliente
                numeroField.setText(String.valueOf(cli.getNumero()));
                nombreField.setText(cli.getNombre());
                fechaNacField.setText(fecha.format(cli.getFechaNac().getTime()));
                edadField.setText(String.valueOf(cli.getEdad()));
                saldoField.setText(String.valueOf(cli.getSaldo()));
                saldoMaxField.setText(String.valueOf(cli.getSaldoMax()));

                // Como estoy en el final si o si, deshabilitamos siguiente y final y habilitamos anterior y principio
                siguienteButton.setEnabled(false);
                finalButton.setEnabled(false);
                principioButton.setEnabled(true);
                anteriorButton.setEnabled(true);
            }
        });
        
        //Evento del boton insertar
        insertarButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                System.out.println("Insertar registro");
                // Vacíamos los campos para poder escribir los nuevos valores
                numeroField.setText("");
                nombreField.setText("");
                fechaNacField.setText("");
                edadField.setText("");
                saldoField.setText("");
                saldoMaxField.setText("");
                
                // Incidamos que operación estamos haciendo para que el botón aceptar sepa que operación se está realizando
                operacion = "insertar";
                
                // Mostramos el panel con los botones aceptar y cancelar
                buttonJPanelConfirmacion.setVisible(true);
                
                // Mientras estamos creando un cliente nuevo, deshabilitamos los botones para moverse
                siguienteButton.setEnabled(false);
                finalButton.setEnabled(false);
                principioButton.setEnabled(false);
                anteriorButton.setEnabled(false);
                
                // Ocultamos las acciones
                buttonJPanelAccion.setVisible(false);
                
                // Habilitamos los campos
                numeroField.setEnabled(true);
                nombreField.setEnabled(true);
                fechaNacField.setEnabled(true);
                edadField.setEnabled(true);
                saldoField.setEnabled(true);
                saldoMaxField.setEnabled(true);

            }
        });
        
        //Evento del boton modificar
        modificarButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                // Si la lista no está vacía, podemos modificar un cliente, en otro caso no hará nada
                if (!miLista.esVacia()) {
                    // Mostramos el panel con los botones aceptar y cancelar
                    buttonJPanelConfirmacion.setVisible(true);
                    // Ocultamos las acciones
                    buttonJPanelAccion.setVisible(false);
                    // indicamos la operación que estamos realizando para que el botón aceptar sepa que operación se está realizando
                    operacion = "modificar";
                    System.out.println("Modificar registro");
                    
                     // Habilitamos los campos
                    numeroField.setEnabled(true);
                    nombreField.setEnabled(true);
                    fechaNacField.setEnabled(true);
                    edadField.setEnabled(true);
                    saldoField.setEnabled(true);
                    saldoMaxField.setEnabled(true);
                   
               }
            }
        });
        
        //Evento del boton ordenar
        ordenarButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                // SI la lista no está vacía, podemos ordenar, en otro caso no hará nada
               if (!miLista.esVacia()) {
                   System.out.println("Ordenar lista");
                   // llamamos al método para ordenar clientes
                   miLista.ordenarPorNumeroDeCliente();
                   // Vamos al principio de la lista, la cual se encontrará ordenada
                    Cliente cli = miLista.irAlPrincipio();
                    numeroField.setText(String.valueOf(cli.getNumero()));
                    nombreField.setText(cli.getNombre());
                    fechaNacField.setText(fecha.format(cli.getFechaNac().getTime()));
                    edadField.setText(String.valueOf(cli.getEdad()));
                    saldoField.setText(String.valueOf(cli.getSaldo()));
                    saldoMaxField.setText(String.valueOf(cli.getSaldoMax()));
                    
                    // Como vamos a la primera posición deshabilitmos principio y anterior
                    siguienteButton.setEnabled(true);
                    finalButton.setEnabled(true);
                    principioButton.setEnabled(false);
                    anteriorButton.setEnabled(false);
               }
            }
        });
        
        //Evento del boton borrar
        borrarButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                // si la lista no está vacía podemos borrar, en otro caso no hará nada
                if (!miLista.esVacia()) {
                    // Mostramos el panel con los botones aceptar y cancelar
                    buttonJPanelConfirmacion.setVisible(true);
                    // Ocultamos las acciones
                    buttonJPanelAccion.setVisible(false);
                    // Indicamos la operación a realizar para que el botón aceptar sepa que operación se está realizando
                    operacion = "borrar";
                    System.out.println("Borrar registro");
                }
               
            }
        });
        
        //Evento del boton aceptar
        aceptarButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                if (operacion.equals("insertar")) { // Si estamos realizado un insertar
                    GregorianCalendar fechaNac = Error.comprobarFecha(fechaNacField.getText());
                    boolean saldo = Error.comprobarSaldo(saldoField.getText(), saldoMaxField.getText());
                    if (fechaNac == null) { // Si la fecha es nula es que no cumple el formato dd/mm/yyyy
                        fechaNacLabel.setForeground(Color.red); // Indicamos la fecha en rojo
                    } else {
                        fechaNacLabel.setForeground(Color.black); // Si la fecha es correcta se indica en negro (por si previamenete estaba en rojo)
                        if (!saldo){ // Comprobamos el saldo
                            saldoLabel.setForeground(Color.red);
                        }else{
                            saldoLabel.setForeground(Color.black);
                            // Instanciamos un nuevo cliente con los datos del formulario
                            Cliente cli = new Cliente (Integer.parseInt(numeroField.getText()), 
                            nombreField.getText(), fechaNac, Integer.parseInt(edadField.getText()), Float.parseFloat(saldoField.getText()), Float.parseFloat(saldoMaxField.getText()));
                            // llamamos a insertar
                            miLista.insertarCliente(cli);
                            // Ocultamos el panel de los botones Acpetar y Cancelar
                            buttonJPanelConfirmacion.setVisible(false);
                            // Ponemos visible las acciones
                            buttonJPanelAccion.setVisible(true);
                            System.out.println("Registro insertado");
                            // Si tras insertar el nuevo cliente, hay más de un cliente en la lista, habilitamos los botones de movimiento, en otro caso, no
                            if (miLista.getClientes().size() > 1) {
                                principioButton.setEnabled(true);
                                anteriorButton.setEnabled(true);
                                siguienteButton.setEnabled(true);
                                finalButton.setEnabled(true);
                            }
                            
                             // Deshabilitamos los campos
                            numeroField.setEnabled(false);
                            nombreField.setEnabled(false);
                            fechaNacField.setEnabled(false);
                            edadField.setEnabled(false);
                            saldoField.setEnabled(false);
                            saldoMaxField.setEnabled(false);
                      
                        }
                    }
               } else if (operacion.equals("borrar"))  { // Para borrar
                    if (!miLista.esVacia()) { // sólo borramos si hay elementos en la lista
                        // llamamos al método borrar pasándole el cliente que tenemos actualmente en la pantalla
                        miLista.borrarCliente(miLista.obtenerClienteActual());
                        // Ocultamos el panel de los botones Aceptar y cancelar
                        buttonJPanelConfirmacion.setVisible(false);
                        // Ponemos visible las acciones
                        buttonJPanelAccion.setVisible(true);
                        System.out.println("Registro borrado");
                        // Vacíamos los campos depsués de borrar
                        numeroField.setText("");
                        nombreField.setText("");
                        fechaNacField.setText("");
                        edadField.setText("");
                        saldoField.setText("");
                        saldoMaxField.setText("");
                        
                        // Si sólo hay un cliente no habilitamos los botones de movimientos
                        if (miLista.getClientes().size() == 1) {
                            principioButton.setEnabled(false);
                            anteriorButton.setEnabled(false);
                            siguienteButton.setEnabled(false);
                            finalButton.setEnabled(false);
                        }
                        // Si la lista está rellena obtenemos el cliente actual y lo mostramos
                        if (!miLista.esVacia()) {
                            Cliente cli = miLista.obtenerClienteActual();
                            numeroField.setText(String.valueOf(cli.getNumero()));
                            nombreField.setText(cli.getNombre());
                            fechaNacField.setText(fecha.format(cli.getFechaNac().getTime()));
                            edadField.setText(String.valueOf(cli.getEdad()));
                            saldoField.setText(String.valueOf(cli.getSaldo()));
                            saldoMaxField.setText(String.valueOf(cli.getSaldoMax()));
                        }
                    }
               } else if (operacion.equals("modificar")) { // Modificar
                    if (!miLista.esVacia()) {
                            // Comprobamos fecha y salgo a la hora de actualizar
                            GregorianCalendar fechaNac = Error.comprobarFecha(fechaNacField.getText());
                            boolean saldo = Error.comprobarSaldo(saldoField.getText(), saldoMaxField.getText());
                            if (fechaNac == null) {
                            fechaNacLabel.setForeground(Color.red);
                            } else {
                                fechaNacLabel.setForeground(Color.black);
                                if (!saldo){
                                    saldoLabel.setForeground(Color.red);
                                }else{
                                    saldoLabel.setForeground(Color.black);
                                    // Modificamos cliente. obtenemos el actual y modificamos sus datos por los del formulario
                                    Cliente clienteModificar = miLista.obtenerClienteActual();
                                    clienteModificar.setNumero(Integer.parseInt(numeroField.getText()));
                                    clienteModificar.setNombre(nombreField.getText());
                                    clienteModificar.setFechaNac(fechaNac);
                                    clienteModificar.setEdad(Integer.parseInt(edadField.getText()));
                                    clienteModificar.setSaldo(Float.parseFloat(saldoField.getText()));
                                    clienteModificar.setSaldoMax(Float.parseFloat(saldoMaxField.getText()));
                                    // llamamos a modificar
                                    miLista.modificarCliente(clienteModificar);
                                    // Ocultamos el panel
                                    buttonJPanelConfirmacion.setVisible(false);
                                    // Ponemos visible las acciones
                                    buttonJPanelAccion.setVisible(true);
                                    System.out.println("Registro modificado");

                                     // Deshabilitamos los campos
                                    numeroField.setEnabled(false);
                                    nombreField.setEnabled(false);
                                    fechaNacField.setEnabled(false);
                                    edadField.setEnabled(false);
                                    saldoField.setEnabled(false);
                                    saldoMaxField.setEnabled(false);
                                }
                            }   
                        
                    }
               }               
            }
        });
        
        //Evento del boton cancelar
        cancelarButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                // Ocultamos el panel de los botones Aceptar y cancelar
                buttonJPanelConfirmacion.setVisible(false);
                // Ponemos visible las acciones
                buttonJPanelAccion.setVisible(true);
                // Si hay más de un cliente en la lista habilitamos todos los botones de movimientos
                if (miLista.getClientes().size() > 1) {
                    principioButton.setEnabled(true);
                    anteriorButton.setEnabled(true);
                    siguienteButton.setEnabled(true);
                    finalButton.setEnabled(true);
                }
                // Si la lista no está vacía obtenemos el cliente actual y mostramos sus datos
                if (!miLista.esVacia()) {
                    Cliente cli = miLista.obtenerClienteActual();
                    numeroField.setText(String.valueOf(cli.getNumero()));
                    nombreField.setText(cli.getNombre());
                    fechaNacField.setText(fecha.format(cli.getFechaNac().getTime()));
                    edadField.setText(String.valueOf(cli.getEdad()));
                    saldoField.setText(String.valueOf(cli.getSaldo()));
                    saldoMaxField.setText(String.valueOf(cli.getSaldoMax()));
                } else {// Si la lista está vacía limpiamos los campos para evitar que se queden datos rellenos
                    numeroField.setText("");
                    nombreField.setText("");
                    fechaNacField.setText("");
                    edadField.setText("");
                    saldoField.setText("");
                    saldoMaxField.setText("");
                }
                
                 // Deshabilitamos los campos
                numeroField.setEnabled(false);
                nombreField.setEnabled(false);
                fechaNacField.setEnabled(false);
                edadField.setEnabled(false);
                saldoField.setEnabled(false);
                saldoMaxField.setEnabled(false);
            }
        });
                

}

    public static void main(String[] args) {
        final Vista app = new Vista();

        //Lo que pasa si cerramos la ventana
        app.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
        app.pack();
        app.setVisible(true);
    }
   
}
