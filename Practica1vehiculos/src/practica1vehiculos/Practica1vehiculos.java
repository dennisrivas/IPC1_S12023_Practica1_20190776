/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica1vehiculos;
import java.util.Scanner;
import java.lang.Double;
import static java.lang.Integer.parseInt;

/**
 *
 
 */
public class Practica1vehiculos {
    
    public static String Arregloautos [][] = new String[10][5];
    public static String Arreglodescuentos [][] = new String[10][2];
    public static String Arreglousuarios [][] = new String[10][2];
     public static int indescuentos = 0;
    public static int inautos = 0;
    public static int inusuarios = 0;
    public static String usuario = "admin_201907662";
    public static String contraseña = "201907662";
    public static Scanner entrada = new Scanner(System.in);
    public static int bentrada ;
    public static String opcionmenu = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       do 
//        {
//           
//        }while(bentrada != 1);
        
        String eos="0";
        do
        {
            
            ingresarpag();
            System.out.println("Desea salir del programa");
            System.out.println("0 No");
            System.out.println("1 Si");                     
            Scanner ent = new Scanner(System.in);
            eos = ent.nextLine();
        }while(eos.equals("0"));
    }
     public static void ingresarpag()
    {
        mensaje("**********************************");
        mensaje("1. Ingresar como adiministrador");
        mensaje("2. Ingresar como cliente");
        mensaje("");
        opcionmenu = ObtenerD("ingrese el numero de la opcion que desea ingresar");
        
        
        
        switch(opcionmenu){
            case "1": 
                 do 
                 {
                   Ingresaradmin();
                 }while(bentrada != 1);
                 String eos="0";
                do
                {
                    mostrarmenu();
                    System.out.println("Desea salir del programa");
                    System.out.println("0 No");
                    System.out.println("1 Si");                     
                    Scanner ent = new Scanner(System.in);
                    eos = ent.nextLine();
                }while(eos.equals("0"));
                 
                break;
//            case "2": 
//                menucliente();
//               
//                
//                break;
//            case "3": 
//                exit();
//                break;
            default:
                mensaje("Esta opcion no es valida");
                    
        }
    }
     public static void Ingresaradmin()
    {
        
        mensaje("******************************");
        mensaje("Ha saleccionado entrar como administrador");
        mensaje("para entrar debe ingresar los siguientes datos");
        mensaje("");
        String eusuario = ObtenerD("Ingrese el usuario");
        mensaje("");
        String econtraseña = ObtenerD("Ingrese la contraseña");
        if (eusuario.equals(usuario) && econtraseña.equals(contraseña))
        {
            bentrada = 1;
        }
        else
        {
            mensaje("Los datos ingresados son incorrectos");
        }
        
    }
     public static void mostrarmenu()
    {
       
        mensaje("*****  Administrador  *****");
        mensaje("");
        mensaje("1. Agregar vehiculos");
        mensaje("2. Agregar descuento");
        mensaje("3. Realizar reportes");
        mensaje("4. Mostrar usuarios");
        mensaje("5. regresar a menú principal");
        mensaje("");
        opcionmenu = ObtenerD("ingrese el numero de la opcion que desea ingresar");
        
        
        
        switch(opcionmenu){
            case "1": 
                Agregarvehiculo();
                 int verp;
                 mensaje("Desea ver los autos ingresados?");
                 mensaje("0 Si");
                 mensaje("1 No");
                 verp= parseInt(entrada.nextLine());
                 if(verp==0){
                     mostrarautos();
                 }
                 
                break;
            case "2": 
                Agregardescuento();
                int verc;
                 mensaje("Desea ver los descuentos ingresados?");
                 mensaje("0 Si");
                 mensaje("1 No");
                 verc= parseInt(entrada.nextLine());
                 if(verc==0){
                     //mostrardescuentos();
                 }
                
                break;
            case "3": 
                Realizarreportes();
                
                break;
            case "4": 
                Mostrarusuarios();
                break;
            default:
                mensaje("Esta opcion no es valida");
                    
        }
    }
     public static void Agregarvehiculo()
    {
        if(inautos<10)
      {
          String Marca ="";
          String Linea ="";
          String Modelo ="";
          String Placa ="";
          String Costo ="";
          Marca = ObtenerD("ingrese la Marca");
          Linea = ObtenerD("ingrese la Linea");
          Modelo = ObtenerD("ingrese el Modelo");
          Placa = ObtenerD("ingrese la Placa");
          Costo = ObtenerD("ingrese el Costo de alquiler por día (debe ser mayor a 0)");
          
          int validarprecio=0;
          validarprecio=parseInt(Costo);
          int existeproducto=0;
          existeproducto = evaluarvehiculo(Placa);
          if(existeproducto != -1)
          {
              if(validarprecio>0)
              {
                Arregloautos[inautos][0]=Marca;
                Arregloautos[inautos][1]=Linea;
                Arregloautos[inautos][2]=Modelo;
                Arregloautos[inautos][3]=Placa;
                Arregloautos[inautos][4]=Costo;
                
            
                inautos ++;
              }
              else
              {
              mensaje("el precio ingresado no es valido");
              }
          }
          else
          {
              mensaje("Las placa de este vehiculo ya existe por favor ingresar una distinto");
          }
          
          
           
          
      }
      else 
      {
         mensaje("ya no hay espacio para ingresar productos al almacen");
      }
    }
     public static void Agregardescuento()
    {
         mensaje("por el momento nada");
    }
     public static void Realizarreportes()
    {
         mensaje("por el momento nada");
    }
     public static void Mostrarusuarios()
    {
         mensaje("por el momento nada");
    }
     public static int evaluarvehiculo(String placa)
     {
         int voy=0;
         for(int i=0; i<10; i++)
         {
             if(Arregloautos[i][3]!= null)
             {
                 if(Arregloautos[i][3].equals(placa))
                 {
                     voy=1;
                 }
                 
             }
            
         }
         if(voy == 1)
         {
             return -1;
         }
         else
         {
             return 0;
         }
     }
     public static void mostrarautos()
     {
        for(int i=0; i<10; i++){
            System.out.print(i+" ");
            for(int j=0; j<5; j++){
                System.out.print(Arregloautos[i][j]+" ");
            }
            mensaje("");
        }
     }
     
     
      public static void mensaje(String msj)
    {
        System.out.println(msj);
    }
      public static String ObtenerD(String msj)
    {
        mensaje(msj);
        return entrada.nextLine();
    }
    
     
    
}
