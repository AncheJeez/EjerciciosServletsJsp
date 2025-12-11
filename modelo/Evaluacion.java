/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Evaluacion {
    
    private List<NotaAlumno> listaAlumnos = new ArrayList<>();

//    public Evaluacion(List<NotaAlumno> listaAlumnos) {
//        this.listaAlumnos = listaAlumnos;
//    }
    public void addAlumno(NotaAlumno alumno) {
        listaAlumnos.add(alumno);
    }
    
    public List<NotaAlumno> getAlumnosOrdenados() {
        List<NotaAlumno> ordenados = new ArrayList<>(listaAlumnos);
        Collections.sort(ordenados, Comparator.comparing(NotaAlumno::getApellido)
                                              .thenComparing(NotaAlumno::getNombre));
        return ordenados;
    }

    public List<NotaAlumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<NotaAlumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }
    
    public int totalAlumnos(){
        return getListaAlumnos().size();
    }
    
    public double getMedias(){
        if(!getListaAlumnos().isEmpty()){
            int total = this.totalAlumnos();
            double sumaAlumnos = 0;
            for(int i=0;i<=total;i++){
                double nota = this.getListaAlumnos().get(i).getNota();
                sumaAlumnos = sumaAlumnos + nota;
            }
            double media = sumaAlumnos / total;
            return media;
        }else{
            return 0;
        }
    }
    
    public int getFrecuencia(int nota){
        int frecuencia = 0;
        for(int i=0;i<=this.totalAlumnos();i++){
            if(this.getListaAlumnos().get(i).getNota() == nota){
                frecuencia = frecuencia + 1;
            }
        }
        return frecuencia;
    }
    
    public int[] getFrecuencias() {
        int[] frec = new int[10];
        for (NotaAlumno a : listaAlumnos) {
            int index = Math.min((int) a.getNota(), 9);
            frec[index]++;
        }
        return frec;
    }
}
