/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;
import java.rmi.*;

/**
 *
 * @author brand
 */
public interface Metodos extends Remote{
     public float[] suma(float[]arreglo)throws RemoteException;
    public float[] resta(float[]arreglo)throws RemoteException;
    public float[] multiplicacion(float[]arreglo)throws RemoteException;
    public float[] division(float[]arreglo)throws RemoteException;
    
}
