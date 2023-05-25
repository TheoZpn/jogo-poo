package br.ifpr.jogo.principal;

import javax.swing.JFrame;

import br.ifpr.jogo.modelo.Fase;


public class principal extends JFrame{
    public principal(){
        Fase fase = new Fase();
        super.add(fase);

        setVisible(true);
        setSize(1000, 666);
        setTitle("Meu jogo");
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        principal principal = new principal();
    }
}
