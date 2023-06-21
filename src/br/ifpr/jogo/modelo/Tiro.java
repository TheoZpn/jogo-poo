package br.ifpr.jogo.modelo;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tiro {
    private int posicaoEmX;
    private int posicaoEmY;
    private Image imagem;
    private int larguraImagem;
    private int alturaImagem;
    private static int VELOCIDADE = 2;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        this.posicaoEmX = posicaoPersonagemEmX;
        this.posicaoEmY = posicaoPersonagemEmY;
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\tiro1.png");
        this.imagem = carregando.getImage();
        this.alturaImagem = this.imagem.getWidth(null);
        this.larguraImagem = this.imagem.getHeight(null);
    }
}