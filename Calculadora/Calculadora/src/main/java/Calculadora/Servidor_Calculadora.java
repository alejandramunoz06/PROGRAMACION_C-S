/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculadora;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author brand
 */

public class Servidor_Calculadora extends UnicastRemoteObject implements Metodos
{
    public Servidor_Calculadora() throws RemoteException
    {
        super();
    }
    
         @Override
         public float[] suma(float[]arreglo)throws RemoteException
         {
            float denominador1, denominador2, numerador1, numerador2, denominadorfinal, suma, suma2, sumafinal;
            numerador1 = arreglo[0];
            denominador1 = arreglo[1];
            numerador2 = arreglo[2];
            denominador2 = arreglo[3];

            if (denominador1 == denominador2)
            {
                denominadorfinal = denominador1;
                suma = numerador1 + numerador2;
                float division;
                division = suma / denominadorfinal;
                arreglo[0]= suma;
                arreglo[1]= denominadorfinal;
                arreglo[2]= division;
                return arreglo;
            }
            denominadorfinal = denominador1 * denominador2;
            suma = numerador1 * denominador2;
            suma2 = numerador2 * denominador1;
            sumafinal = suma + suma2;
            float division;
            division = sumafinal/denominadorfinal;
            arreglo[0]= sumafinal;
            arreglo[1]= denominadorfinal;
            arreglo[2]= division;
            return arreglo;
         }
          @Override
         public float[] resta(float[]arreglo)throws RemoteException
         {
            float denominador1, denominador2, numerador1, numerador2, denominadorfinal, resta, resta2, restafinal;
            numerador1 = arreglo[0];
            denominador1 = arreglo[1];
            numerador2 = arreglo[2];
            denominador2 = arreglo[3];

            if (denominador1 == denominador2) 
            {
                denominadorfinal = denominador1;
                resta = numerador1 - numerador2;
                float division;
                division = resta / denominadorfinal;
                arreglo[0]= resta;
                arreglo[1]= denominadorfinal;
                arreglo[2]= division;

                return arreglo;

            }
            denominadorfinal = denominador1 * denominador2;
            resta = numerador1 * denominador2;
            resta2 = numerador2 * denominador1;
            restafinal = resta - resta2;
            float division;
            division = restafinal/denominadorfinal;
            arreglo[0]= restafinal;
            arreglo[1]= denominadorfinal;
            arreglo[2]= division;
            return arreglo;
         }
         @Override
         public float[] multiplicacion(float[]arreglo)throws RemoteException
         {
            float denominador1, denominador2, numerador1, numerador2, denominadorfinal, multiplicacion, division;
            numerador1 = arreglo[0];
            denominador1 = arreglo[1];
            numerador2 = arreglo[2];
            denominador2 = arreglo[3];

            denominadorfinal = denominador1 * denominador2;
            multiplicacion = numerador1 * numerador2;
            division = multiplicacion / denominadorfinal;
            arreglo[0]= multiplicacion;
            arreglo[1]= denominadorfinal;
            arreglo[2]= division;
            return arreglo;
            /*float[] equis = {1};
            return equis;*/  
         }
         @Override
         public float[] division(float[]arreglo)throws RemoteException
         {
            float denominador1, denominador2, numerador1, numerador2, denominadorfinal, numeradorfinal, division;
            numerador1 = arreglo[0];
            denominador1 = arreglo[1];
            numerador2 = arreglo[2];
            denominador2 = arreglo[3];
            
            numeradorfinal = numerador1 * denominador2;  
            denominadorfinal = numerador2 * denominador1;            
            division = numeradorfinal / denominadorfinal;
            arreglo[0]= numeradorfinal;
            arreglo[1]= denominadorfinal;
            arreglo[2]= division;
            return arreglo;
            /*float[] equis = {1};
            return equis;*/  
         }
          public static void main(String[] args) 
          {
                try{
                    Registry registro = LocateRegistry.createRegistry(9999);
                    registro.rebind("Calcu", new Servidor_Calculadora());
                    System.out.println("Servidor activo");
                }
                catch (RemoteException ex){
                    System.out.println(ex.getMessage());
                }

           }
}


