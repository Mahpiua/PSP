package modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author Mª Del Pilar Parra Vergara 1º DAM
 */
public class Cliente implements Comparable<Cliente>{
    private int numero;
    private String nombre;
    private GregorianCalendar fechaNac;
    private int edad;
    private float saldo;
    private float saldoMax;

    public Cliente(int numero, String nombre, GregorianCalendar fechaNac, int edad, float saldo, float saldoMaximo) {
        this.numero = numero;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.edad = edad;
        this.saldo = saldo;
        this.saldoMax = saldoMaximo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldoMax() {
        return saldoMax;
    }

    public void setSaldoMax(float saldoMax) {
        this.saldoMax = saldoMax;
    }
    
    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", numero=" + numero + ", edad=" + edad + ", saldo=" + saldo + '}';
    }

    @Override
    public int compareTo(Cliente o) {
        return numero - o.getNumero();
    }
}
