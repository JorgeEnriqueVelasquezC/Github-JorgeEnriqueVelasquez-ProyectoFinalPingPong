/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
//Importamos los paquetes COLOR

import java.awt.Color;
//Importamos los paquetes GRÁFICOS
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo Vargas A. --- Jorge Enrique Velásquez C.
 */
//Colocar un HILO 
public class clsPelota extends Thread {
//Posición de la pelota

    private int px, py, w, h, posInicialPelotaX, posInicialPelotaY;
    private int VariaciónEnX, VariaciónEnY;
    private Graphics pintor;
    private Color color;
    private clsCancha clCancha;

//Para sortear la dirección "ARREGLOS"
    // private final int [] arrayOfRandoms = { -1, 1 };
    //private final int positivo = 2;
    //private final int negativo = 0;
    //CONSTRUCTOR
    public clsPelota(Graphics pintor, Color color, clsCancha clCancha) {
        //Tamaño de la pelota
        this.w = 20;
        this.h = 20;
        //Posición inicial de la pelota
        this.posInicialPelotaX = 400 - 10;
        this.posInicialPelotaY = 350 - 30;

        //Para que salga aleatoriamente desde arriba entre 1 y 800 (Ancho)
        this.px = this.posInicialPelotaX;
        this.py = this.posInicialPelotaY;
        this.pintor = pintor;
        this.color = color;
        //Cree estas variables para poder modificar su comportamiento de choque
        this.VariaciónEnX = -5;
        this.VariaciónEnY = -5;

        this.clCancha = clCancha;
    }

    //Aquí declaramos constantes, tienen un valor fijo
    public enum Golpeo {
        ARRIBA, IZQUIERDA, DERECHA, TABLITA, ABAJO
    }
//Método para sobrescribir

    @Override
    public void run() {
        while (true) {
            // Aqui hay que programar la direccion de la pelota..
            borrarP();
            this.py = this.py + this.VariaciónEnY;
            this.px = this.px + this.VariaciónEnX;
            pintarP();
            //System.out.println("x: "+ this.px + " y: " + this.py);
            //Para que no pase la pared de la derecha
            if (px > 680) {
                //System.out.println("Right Crash");
                //this.NuevaDirección(Golpeo.DERECHA);
                this.VariaciónEnX = -5;
                //this.VariaciónEnY = -5;
            }
            //Para que no pase la pared de la izquierda
            if (px < 10) {
                //System.out.println("Left Crash");
                //this.NuevaDirección(Golpeo.IZQUIERDA);
                this.VariaciónEnX = 5;
                //this.VariaciónEnY = -5;
            }
            //Para que no se pase arriba
            if (py < 70) {
                //System.out.println("Top Crash");
                //this.NuevaDirección(Golpeo.ARRIBA);
                this.VariaciónEnY = 5;
                //this.VariaciónEnX = 5;
            }
            //Para que la pelota regrese al lugar de origen
            if (this.py > 400) {
                //System.out.println("Hi Again");
                //this.NuevaDirección(Golpeo.ABAJO);
                this.px = this.posInicialPelotaX;
                this.py = this.posInicialPelotaY;
                this.VariaciónEnX = -5;
                this.VariaciónEnY = -5;
            }
            
            // FILA DE ARRIBA
            // BLOQUE 0
            if (this.px >= 40 + 10 && this.px <= 100 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[0] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 0);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 1
            if (this.px >= 105 + 10 && this.px <= 165 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[1] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 1);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 2
            if (this.px >= 170 + 10 && this.px <= 230 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[2] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 2);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 3
            if (this.px >= 235 + 10 && this.px <= 295 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[3] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 3);
                    this.VariaciónEnY = 5;
                }
            }
            //BLOQUE 4
            if (this.px >= 260 + 10 && this.px <= 320 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[4] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 4);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 5
            if (this.px >= 325 + 10 && this.px <= 385 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[5] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 5);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 6
            if (this.px >= 390 + 10 && this.px <= 450 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[6] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 6);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 7
            if (this.px >= 455 + 10 && this.px <= 515 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[7] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 7);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 8
            if (this.px >= 520 + 10 && this.px <= 580 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[8] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 8);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 9
            if (this.px >= 585 + 10 && this.px <= 645 + 10 && this.py >= 60 + 10 && this.py <= 100 + 10) {
                if (this.clCancha.PrimeraFilaDeBloques[9] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(0, 9);
                    this.VariaciónEnY = 5;
                }
            }
            // FILA DE ABAJO
            // BLOQUE 0
            if (this.px >= 40 + 10 && this.px <= 100 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[0] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 0);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 1
            if (this.px >= 105 + 10 && this.px <= 165 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[1] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 1);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 2
            if (this.px >= 170 + 10 && this.px <= 230 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[2] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 2);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 3
            if (this.px >= 235 + 10 && this.px <= 295 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[3] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 3);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 4
            if (this.px >= 260 + 10 && this.px <= 320 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[4] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 4);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 5
            if (this.px >= 325 + 10 && this.px <= 385 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[5] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 5);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 6
            if (this.px >= 390 + 10 && this.px <= 450 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[6] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 6);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 7
            if (this.px >= 455 + 10 && this.px <= 515 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[7] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 7);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 8
            if (this.px >= 520 + 10 && this.px <= 580 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[8] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 8);
                    this.VariaciónEnY = 5;
                }
            }
            // BLOQUE 9
            if (this.px >= 585 + 10 && this.px <= 645 + 10 && this.py >= 120 + 10 && this.py <= 160 + 10) {
                if (this.clCancha.SegundaFilaDeBloques[9] == 1) {
                    //System.out.println("Choco el ladrillo");
                    this.clCancha.choqueEnBloque(1, 9);
                    this.VariaciónEnY = 5;
                }
            }

            try {
                sleep(50);
            } catch (Exception e) {
            }

        }
    }

    //Para pintar la pelota
    private void pintarP() {
        this.pintor.setColor(Color.GREEN);
        this.pintor.clearRect(px, py, w, h);
        this.pintor.fillOval(px, py, w, h);
    }

    //Para borrar la pelota
    private void borrarP() {
        this.pintor.setColor(this.color);
        this.pintor.clearRect(px, py, w, h);
        this.pintor.fillOval(px, py, w, h);
    }

    //Todos los GET y SET de las variables (px, py, w, h)
    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getVariaciónEnX() {
        return VariaciónEnX;
    }

    public void setVariaciónEnX(int VariaciónEnX) {
        this.VariaciónEnX = VariaciónEnX;
    }

    public int getVariaciónEnY() {
        return VariaciónEnY;
    }

    public void setVariaciónEnY(int VariaciónEnY) {
        this.VariaciónEnY = VariaciónEnY;
    }

    public void dibujarPelotaInicial() {
        this.pintor.setColor(Color.GREEN);
        this.pintor.fillOval(this.posInicialPelotaX, this.posInicialPelotaY, w, h);
    }

//Líneas de código relacionado con el comportamiento de choque
    public void NuevaDirección(Golpeo objectCrash) {
        //"Random" Clase para sortear objetos (Entre 0 y 1)
        //int randomValue = (int) new Random().nextInt(positivo - negativo) + negativo;
        int Velocidad = 5;
        switch (objectCrash) {
//Para cambiar la dirección cuando toque la pared de arriba
            //case ARRIBA:
            //this.VariaciónEnY = Velocidad;
            //this.VariaciónEnX = Velocidad * arrayOfRandoms[randomValue];
            //break;
//Para cambiar la dirección cuando toque la pared de la derecha
            //case DERECHA:
            //this.VariaciónEnX = -Velocidad; 
            //this.VariaciónEnY = Velocidad * arrayOfRandoms[randomValue];
            //break;
//Para que vuelva a caer la pelota cuando pase el límite
            //case ABAJO:
            //System.out.println("PERDISTE");
            //this.px = (int)(Math.random()*700)-30;
            //this.py = 100;
            //break;
//Para cambiar la dirección cuando toque la pared de la izquierda
            //case IZQUIERDA:
            //this.VariaciónEnX = Velocidad; 
            //this.VariaciónEnY = Velocidad * arrayOfRandoms[randomValue];
            //break;
//Para cambiar la dirección cuando toque la tablita
            case TABLITA:
                this.VariaciónEnY = -Velocidad;
                //this.VariaciónEnX = Velocidad * arrayOfRandoms[randomValue];
                break;

        }

    }

}
