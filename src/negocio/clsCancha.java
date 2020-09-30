/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
//Importar los gráficos de JAVA

import java.awt.Graphics;
//Importar los colores
import java.awt.Color;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
//import javax.swing.JLabel;
import negocio.clsPelota.Golpeo;
import presentacion.formJuego;
//import negocio.clsPelota;

/**
 *
 * @author Leonardo Vargas A. --- Jorge Enrique Velásquez C.
 */
public final class clsCancha extends Thread {

    //Cancha, color, tablero puntos, pelota, tablita
    private Graphics pintor;
    private Color color;
    private formJuego form;
    //Datos para la tablita
    //Posición de la tablita
    private int tx, ty, th, tw;
    //Pelota "Declarar la variable privada"
    private clsPelota objPelota;
    //Puntos
    public int puntos;
    //Vidas
    public int vidas;
    //Vectores
    public int[] PrimeraFilaDeBloques, SegundaFilaDeBloques;
    //Es o no es bloque
    private final int ES_BLOQUE = 1;
    private final int NO_ES_BLOQUE = 0;
    //Primer Fila, Segunda fila
    private final int PRIMER_FILA = 0;
    private final int SEGUNDA_FILA = 1;

    //CONSTRUCTOR
    public clsCancha(Graphics pintor, Color color, formJuego form) {
        this.pintor = pintor;
        this.color = color;
        //Tamaño de la tablita
        this.th = 15;
        this.tw = 95;
        //Posición de la tablita
        this.tx = 400 - tw / 2;
        this.ty = 350;
        //Puntos
        this.puntos = 0;
        //Vidas
        this.vidas = 3;
        //Form
        this.form = form;
        //Darle vida a la variable privada "Pelota"
        this.objPelota = new clsPelota(pintor, color, this);
        // Vectores 
        this.PrimeraFilaDeBloques = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        this.SegundaFilaDeBloques = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        this.pintarBloques();
    }

    //Método que se encarga de iniciar la pelota (Juego)
    public void dibujarTableroInicial() {
        try {
            Thread.sleep(100);
            this.objPelota.dibujarPelotaInicial();
            this.DibujarTablita();
        } catch (InterruptedException ex) {
            Logger.getLogger(clsCancha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void IniciarPelota() {
        this.objPelota.start();

    }

    //Método que se encarga de pausar la pelota (Juego)
    public void SuspenderPelota() {
        this.objPelota.suspend();
    }

    //Método que se encarga de reanudar la pelota (Juego)
    public void ContinuarPelota() {
        this.objPelota.resume();
    }

    //Método que se encarga de terminar el juego
    public void TerminarJuego() {
        this.objPelota.stop();
        this.stop();
    }

    @Override
    public void run() {
        // Lógica para el juego
        while (true) {
            this.pintarBloques();
            Rectangle tablita = new Rectangle(tx, ty, tw, th);
            Rectangle pelota = new Rectangle(objPelota.getPx(), objPelota.getPy(), 20, 20 + 10);
            boolean sw = tablita.intersects(pelota);
            if (sw) {
                //System.out.println("Chocaron...");
                //Para que aumente los puntos
                this.objPelota.NuevaDirección(Golpeo.TABLITA);
                //this.aumentarPuntos();
            } else 
            //Para que disminuya la vida
            if (objPelota.getPy() >= 400) {
                this.vidas--;
                this.form.ReducirVidas(this.vidas);
            }
            if (vidas == 0) {
                this.mostrarMensaje("TE QUEDASTE SIN VIDAS");
                this.TerminarJuego();
            }

            if (validarSiExistenBloques()) {
                this.mostrarMensaje("¡GANASTE!");
                this.TerminarJuego();
            }

            //Para que aumente la velocidad de la pelota "Nivel 2"
            /*if (this.puntos >= 10) {
                int Vpy = this.objPelota.getVariaciónEnY();
                if (Vpy == 5) {
                    Vpy = Vpy + 5;
                }
                if (Vpy == -5) {
                    Vpy = Vpy - 5;
                }
                objPelota.setVariaciónEnY(Vpy);
                int Vpx = this.objPelota.getVariaciónEnX();
                if (Vpx == 5) {
                    Vpx = Vpx + 5;
                }
                if (Vpx == -5) {
                    Vpx = Vpx - 5;
                }
                objPelota.setVariaciónEnX(Vpx);
            }
            */
            try {
                sleep(50);
            } catch (Exception e) {
            }

        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane jOptionPane = new JOptionPane(mensaje);
        JDialog dialog = jOptionPane.createDialog(this.form, "Mensaje");
        dialog.setModal(false);
        dialog.setVisible(true);
    }

    // TODO LO RELACIONADO CON LOS BLOQUES
    public void pintarBloques() {
        for (int i = 0; i < this.PrimeraFilaDeBloques.length; i++) {
            if (this.PrimeraFilaDeBloques[i] == this.ES_BLOQUE) {
                this.pintor.setColor(Color.RED);
            } else {
                this.pintor.setColor(this.color);
            }
            this.pintor.clearRect((i * 65) + 40, 60, 60, 40);
            this.pintor.fillRect((i * 65) + 40, 60, 60, 40);
        }

        for (int i = 0; i < this.SegundaFilaDeBloques.length; i++) {
            if (this.SegundaFilaDeBloques[i] == this.ES_BLOQUE) {
                this.pintor.setColor(Color.RED);
            } else {
                this.pintor.setColor(this.color);
            }
            this.pintor.clearRect((i * 65) + 40, 120, 60, 40);
            this.pintor.fillRect((i * 65) + 40, 120, 60, 40);
        }
    }

    // TODO LO RELACIONADO CON EL CHOQUE DE LA PELOTA
    public void choqueEnBloque(int fila, int columna) {
        this.aumentarPuntos();
        if (fila == this.PRIMER_FILA) {
            this.PrimeraFilaDeBloques[columna] = this.NO_ES_BLOQUE;
        } else if (fila == this.SEGUNDA_FILA) {
            this.SegundaFilaDeBloques[columna] = this.NO_ES_BLOQUE;
        }
    }
    // PARA QUE AUMENTE PUNTOS AL TOCAR BARRITA O BLOQUES
    private void aumentarPuntos() {
        this.puntos++;
        this.form.AumentarPuntos(this.puntos);
    }
    // LO QUE VALIDA SI AÚN EXISTEN BLOQUES
    private boolean validarSiExistenBloques() {
        for (int i = 0; i < this.PrimeraFilaDeBloques.length; i++) {
            if (this.PrimeraFilaDeBloques[i] == this.ES_BLOQUE) {
                return false;
            }
        }

        for (int i = 0; i < this.SegundaFilaDeBloques.length; i++) {
            if (this.SegundaFilaDeBloques[i] == this.ES_BLOQUE) {
                return false;
            }
        }
        return true;
    }

    //Método que se encarga de dibujar la tablita
    public void DibujarTablita() {
        this.pintor.setColor(Color.BLACK);
        this.pintor.fillRect(tx, ty, tw, th);
    }

    //Método que se encarga de limpiar la tablita
    public void LimpiarTablita() {
        this.pintor.setColor(this.color);
        this.pintor.fillRect(tx, ty, tw, th);
        this.pintor.clearRect(tx, ty, tw, tw);
    }

    //Método para mover a la derecha la tablita
    public void moverDerechaTablita() {
        if (this.tx < 700) {
            LimpiarTablita();
            this.tx = this.tx + 20;
            DibujarTablita();
        }
    }

    //Método para mover a la izquierda la tablita
    public void moverIzquierdaTablita() {
        if (this.tx > 10) {
            LimpiarTablita();
            this.tx = this.tx - 20;
            DibujarTablita();
        }
    }
}
