package br.ifpr.jogo.modelo;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Personagem extends ElementoGrafico {
    private int deslocamentoEmX;
    private int deslocamentoEmY;
    private int velocidadeDeDeslocamento;
    private ArrayList<Tiro> tiros;

    private static final int POSICAO_INICIAL_EM_X = 100;
    private static final int POSICAO_INICIAL_EM_Y = 100;

    public Personagem(){
        this.posicaoEmX = POSICAO_INICIAL_EM_X;
        this.posicaoEmY = POSICAO_INICIAL_EM_Y;
        this.tiros = new ArrayList<Tiro>();
    }

    public Personagem(int velocidadeDeDeslocamento) {
        this.posicaoEmX = POSICAO_INICIAL_EM_X;
        this.posicaoEmY = POSICAO_INICIAL_EM_Y;
        this.tiros = new ArrayList<Tiro>();
        this.velocidadeDeDeslocamento = velocidadeDeDeslocamento;
    }

    public void atirar() {
        int frenteDaNave = this.posicaoEmX + this.larguraImagem;
        int meioDaNave = this.posicaoEmY + (this.alturaImagem / 2);
        Tiro tiro = new Tiro(frenteDaNave, meioDaNave);
        this.tiros.add(tiro);
    }

    public void carregar(){
        ImageIcon carregando = new ImageIcon("recursos\\personagem4.png");
        this.imagem = carregando.getImage();
        this.alturaImagem = this.imagem.getWidth(null);
        this.larguraImagem = this.imagem.getHeight(null);

    }
    public void atualizar(){
        this.posicaoEmX = this.posicaoEmX + this.deslocamentoEmX;
        this.posicaoEmY = this.posicaoEmY + this.deslocamentoEmY;
}

    public void mover(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch(codigo) {
        case KeyEvent.VK_UP:
            this.deslocamentoEmY = - this.velocidadeDeDeslocamento;

        break;
        case KeyEvent.VK_DOWN:
            this.deslocamentoEmY = this.velocidadeDeDeslocamento;

        break;
        case KeyEvent.VK_RIGHT:
            this.deslocamentoEmX = this.velocidadeDeDeslocamento;

        break;
        case KeyEvent.VK_LEFT:
            this.deslocamentoEmX = - this.velocidadeDeDeslocamento;

        break;
        case KeyEvent.VK_W:
            this.deslocamentoEmY = - this.velocidadeDeDeslocamento;

        break;
        case KeyEvent.VK_S:
            this.deslocamentoEmY = this.velocidadeDeDeslocamento;

        break;
        case KeyEvent.VK_D:
            this.deslocamentoEmX = this.velocidadeDeDeslocamento;

        break;
        case KeyEvent.VK_A:
            this.deslocamentoEmX = - this.velocidadeDeDeslocamento;

        break;
    }

    }

    public void parar(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        switch(codigo) {
        case KeyEvent.VK_UP:
        this.deslocamentoEmY = 0;

        break;

        case KeyEvent.VK_DOWN:
        this.deslocamentoEmY = 0;

        break;
        case KeyEvent.VK_RIGHT:
        this.deslocamentoEmX = 0;

        break;
        case KeyEvent.VK_LEFT:
        this.deslocamentoEmX = - 0;

        break;
        case KeyEvent.VK_W:
        this.deslocamentoEmY = 0;

        break;

        case KeyEvent.VK_S:
        this.deslocamentoEmY = 0;

        break;
        case KeyEvent.VK_D:
        this.deslocamentoEmX = 0;

        break;
        case KeyEvent.VK_A:
        this.deslocamentoEmX = - 0;

        break;
        default:
        break;
    }
    }
    public int getVelocidadeDeDeslocamento() {
        return this.velocidadeDeDeslocamento;
    }

    public void setVelocidadeDeDeslocamento(int velocidadeDeDeslocamento) {
        this.velocidadeDeDeslocamento = velocidadeDeDeslocamento;
    }

    public ArrayList<Tiro> getTiros() {
        return this.tiros;
    }

    public void setTiros(ArrayList<Tiro> tiros) {
        this.tiros = tiros;
    }
    public int getDeslocamentoEmX() {
        return this.deslocamentoEmX;
}

    public void setDeslocamentoEmX(int deslocamentoEmX) {
        this.deslocamentoEmX = deslocamentoEmX;
}

    public int getDeslocamentoEmY() {
        return this.deslocamentoEmY;
}

    public void setDeslocamentoEmY(int deslocamentoEmY) {
        this.deslocamentoEmY = deslocamentoEmY;
}
}