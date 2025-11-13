package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mª Del Pilar Parra Vergara 1º DAM
 */
public class Error {
 
    public static GregorianCalendar comprobarFecha(String fechaValidar) {
            Date fecha;
            GregorianCalendar fechaN = null;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaValidar);
            int anio = Integer.parseInt(fechaValidar.split("/")[2]);
            if (anio < 1900 || anio > 2015) {
                return null;
            }
            
            fechaN = new GregorianCalendar();
            fechaN.setTime(fecha);                
        } catch (ParseException ex) {
            Logger.getLogger(Error.class.getName()).log(Level.SEVERE, null, ex);
            fechaN = null;
        }
        
        return fechaN;
    }
    
    public static boolean comprobarSaldo(String saldo, String saldoMax){
        boolean valido = true;
        try {
        double saldoFloat = Float.parseFloat(saldo);
        double saldoMaxFloat = Float.parseFloat(saldoMax);
        
        if(saldoFloat<=saldoMaxFloat){
            return true;
        }
        return false;
        } catch (NumberFormatException ex) {
            Logger.getLogger(Error.class.getName()).log(Level.SEVERE, null, ex);
            valido = false;
        }
        return valido;
    } 
    
}
