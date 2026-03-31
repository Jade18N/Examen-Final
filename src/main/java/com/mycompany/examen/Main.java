/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jade
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Mascota> lista = new ArrayList<>();

        int opcion = 0;

        do {
            System.out.println("\n MENU ");
            System.out.println("1. Registrar mascota");
            System.out.println("2. Mostrar mascotas");
            System.out.println("3. Ejecutar sonido");
            System.out.println("4. Buscar por nombre");
            System.out.println("5. Salir");

            System.out.print("Seleccione: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                // registrar
                case 1:
                    System.out.println("Tipo: 1.Perro  2.Gato");
                    int tipo = Integer.parseInt(sc.nextLine());

                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Edad: ");
                    int edad = Integer.parseInt(sc.nextLine());

                    if (id <= 0 || edad <= 0 || nombre.isEmpty()) {
                        System.out.println(" Datos inválidos");
                        break;
                    }

                    if (tipo == 1) {
                        lista.add(new Perro(id, nombre, edad));
                    } else if (tipo == 2) {
                        lista.add(new Gato(id, nombre, edad));
                    } else {
                        System.out.println(" Tipo inválido");
                        break;
                    }

                    System.out.println(" Mascota registrada");
                    break;

                // mostrar
                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("Lista vacía");
                    } else {
                        for (Mascota m : lista) {
                            m.mostrarInfo();
                            System.out.println("Tipo: " + m.getClass().getSimpleName());
                            System.out.println("Sonido: " + m.hacerSonido());

                        }
                    }
                    break;

                // muestra el sonido por id
                case 3:
                    System.out.print("Ingrese ID de su mascota para saber el sonido: ");
                    int buscarId = Integer.parseInt(sc.nextLine());

                    boolean encontrado = false;

                    for (Mascota m : lista) {
                        if (m.getId() == buscarId) {
                            System.out.println("Sonido: " + m.hacerSonido());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Mascota no encontrada");
                    }
                    break;

                // buscar por nombre
                case 4:
                    System.out.print("Nombre: ");
                    String buscarNombre = sc.nextLine();

                    encontrado = false;

                    for (Mascota m : lista) {
                        if (m.getNombre().equalsIgnoreCase(buscarNombre)) {
                            m.mostrarInfo();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Mascota no encontrada");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida vuelvalo a intentar");
            }

        } while (opcion != 5);
    }
}