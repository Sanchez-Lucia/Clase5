import empresa.Persona;
import empresa.Producto;
import ventas.Carrito;
import ventas.Descuento;
import ventas.DescuentoPorcentajeConTope;
import ventas.ItemCarrito;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String archivo="/Volumes/Macintosh HD/AP/items.csv";
        Object[] lineas=null;
        try {
            lineas = Files.readAllLines(Paths.get(archivo)).toArray();
            for (Object linea : lineas ) {
                System.out.println(linea.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Persona persona = new Persona();
        persona.setNombre("Lucia");
        persona.setApellido("Sanchez");
        persona.setFechaDeNacimiento(LocalDate.of(1989,  3, 8));


        Carrito carro=new Carrito();
        carro.setPersona(persona);
        carro.setFechaCompra(LocalDateTime.now());
        for (int i=1; i<lineas.length; i++){
            //Separar en vector
            String[] lineaI = lineas[i].toString().split(";");
            ItemCarrito itemI = new ItemCarrito();
            itemI.setCantidad(Integer.parseInt(lineaI[0]));
            //Crear los objetos producto
            Producto productoI=new Producto();
            productoI.setCodigo(lineaI[1]);
            productoI.setNombre(lineaI[2]);
            productoI.setPrecio(Float.parseFloat(lineaI[3]));
            //Pasar el producto al item
            itemI.setProducto(productoI);
            itemI.setPrecioUnitario(productoI.getPrecio());
            //Pasar items al carro

            switch (i) {
                case 1: {
                    carro.setItem1(itemI);
                    break;
                }
                case 2: {
                    carro.setItem2(itemI);
                    break;
                }
                case 3: {
                    carro.setItem3(itemI);
                    break;
                }
                case 4: {
                    carro.setItem4(itemI);
                    break;
                }
                case 5: {
                    carro.setItem5(itemI);
                    break;
                }
            }

        }

       /* Consulta manual de descuentos
        System.out.println("Ingrese el tipo de descuento. \"1\" para el descuento fijo | \"2\" para el descuento en porcentaje | \"3\" para el descuento de porcentaje con tope");
        String tipoDescuentoStr = "";
        Scanner entradaEscaner1 = new Scanner (System.in);
        tipoDescuentoStr = entradaEscaner1.nextLine();
        int tipoDescuento = Integer.parseInt(tipoDescuentoStr);

        switch (tipoDescuento) {
            case 1: {
                System.out.println("Ingrese el monto a descontar");
                break;
            }
            case 2: {
                System.out.println("Ingrese el porcentaje de descuento");
                break;
            }
            case 3: {
                System.out.println("Ingrese el porcentaje de descuento con tope");
                break;
            }
        }

        String descuentoStr = "";
        Scanner entradaEscaner2 = new Scanner (System.in);
        descuentoStr = entradaEscaner2.nextLine();
        float descuento = Float.parseFloat(descuentoStr);

        if (tipoDescuento == 3) {
            System.out.println("Ingrese el tope del monto a descontar");
            String valorTopeStr ="";
            Scanner entradaEscaner3 = new Scanner (System.in);
            valorTopeStr = entradaEscaner3.nextLine();
            float valorTope = Float.parseFloat(valorTopeStr);
            DescuentoPorcentajeConTope descuento1 = new DescuentoPorcentajeConTope();
            descuento1.setTope(valorTope);
        }
       */

        //System.out.println("El descuento es: " + descuento + " y el tipo de descuento es: " + tipoDescuento);

        System.out.println("Precio del carrito sin descuento: " + carro.precio(0,1));
        System.out.println("--------------------------------------------");
        System.out.println("Precio final del carrito con descuento fijo: " + carro.precio(1000, 1));
        System.out.println("Precio final del carrito con descuento fijo: " + carro.precio(500, 1));
        System.out.println("Precio final del carrito con descuento fijo: " + carro.precio(50, 1));
        System.out.println("--------------------------------------------");
        System.out.println("Precio final del carrito con descuento de porcentaje: " + carro.precio(10, 2));
        System.out.println("Precio final del carrito con descuento de porcentaje: " + carro.precio(100, 2));
        System.out.println("Precio final del carrito con descuento de porcentaje: " + carro.precio(50, 2));
        System.out.println("--------------------------------------------");
        DescuentoPorcentajeConTope descuento1 = new DescuentoPorcentajeConTope();
        descuento1.setTope(1000);
        System.out.println("Precio final del carrito con descuento de porcentaje con tope: " + carro.precio(10, 3));
        System.out.println("Precio final del carrito con descuento de porcentaje con tope: " + carro.precio(100, 3));
        System.out.println("Precio final del carrito con descuento de porcentaje con tope: " + carro.precio(50, 3));




    }
}