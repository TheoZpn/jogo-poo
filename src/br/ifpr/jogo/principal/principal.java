package br.ifpr.jogo.principal;

import javax.swing.JFrame;

import br.ifpr.jogo.modelo.Fase;


public class principal extends JFrame{
    public principal(){
        Fase fase = new Fase();
        super.add(fase);
        super.setTitle("Jogo do IFPR - Campus Paranavaí");
        super.setSize(1820, 980); 
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
        
    }
    public static void main(String[] args) {
        principal principal = new principal();
    }
}
