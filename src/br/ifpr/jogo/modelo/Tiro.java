package br.ifpr.jogo.modelo;

import javax.swing.ImageIcon;

public class Tiro extends ElementoGrafico{
    private static int VELOCIDADE = 30;

    public Tiro(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        this.posicaoEmX = posicaoPersonagemEmX;
        this.posicaoEmY = posicaoPersonagemEmY-165;
    }

    public void carregar() {
        ImageIcon carregando = new ImageIcon("recursos\\tiro2.png");
        this.imagem = carregando.getImage();
        this.alturaImagem = this.imagem.getWidth(null);
        this.larguraImagem = this.imagem.getHeight(null);
    }
    public void atualizar() {
    this.posicaoEmX = this.posicaoEmX + VELOCIDADE;
    }
}




