package br.ifpr.jogo.modelo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.Rectangle;

public class FaseUm extends Fase{
    public FaseUm(){
        super();
        ImageIcon carregando = new ImageIcon("recursos\\espaco3.jpg");
        this.fundo = carregando.getImage();

        personagem = new Personagem(VELOCIDADE_DE_DESLOCAMENTO);
        personagem.carregar();
        this.inicializaInimigos();        
        this.timer = new Timer(DELAY, this);
        this.timer.start();
    
    }

   public void inicializaInimigos(){
        inimigos = new ArrayList<Inimigo>();

        for (int i = 0; i < QTDE_DE_INIMIGOS; i++) {
            int x = (int) (Math.random() * 8000 + 1024);
            int y = (int) (Math.random() * 650 + 30);
            Inimigo inimigo = new Inimigo(x, y);
            inimigos.add(inimigo);
        }
    }

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        if (emJogo) {
            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(personagem.getImagem(), personagem.getPosicaoEmX(), personagem.getPosicaoEmY(), this);
            // Recuperar a nossa lista de tiros (getTiros) e atribuímos para uma variável
            // local chamada tiros.
            ArrayList<Tiro> tiros = personagem.getTiros();
            // Criando um laço de repetição (foreach). Iremos percorrer toda a lista.
            for (Tiro tiro : tiros) {
                // Carregando imagem do objeto tiro pelo método carregar.
                tiro.carregar();
                // Desenhar o tiro na nossa tela.
                graficos.drawImage(tiro.getImagem(), tiro.getPosicaoEmX(), tiro.getPosicaoEmY(), this);
        }

            ArrayList<SuperTiro> superTiros = personagem.getSuperTiros();
            for (SuperTiro superTiro : superTiros) {
                superTiro.carregar();
                graficos.drawImage(superTiro.getImagem(), superTiro.getPosicaoEmX(), superTiro.getPosicaoEmY(), this);
            }

            // Criando um laço de repetição (foreach). Iremos percorrer toda a lista.
            for (Inimigo inimigo : inimigos) {
                // Carregando imagem do objeto inimigo pelo método carregar.
                inimigo.carregar();
                // Desenhar o inimigo na nossa tela.
                graficos.drawImage(inimigo.getImagem(), inimigo.getPosicaoEmX(), inimigo.getPosicaoEmY(), this);
            }
        } else {
            ImageIcon fimDeJogo = new ImageIcon("recursos\\gameover2.png");
            graficos.drawImage(fimDeJogo.getImage(), 700, 400, null);
        }   
        g.dispose();
    }


    @Override
    public void verficarColisoes() {
        Rectangle formaPersonagem = this.personagem.getRectangle();
        for (int i = 0; i < this.inimigos.size(); i++) {
            Inimigo inimigo = inimigos.get(i);
            Rectangle formaInimigo = inimigo.getRectangle();
            if (formaInimigo.intersects(formaPersonagem)) {
                this.personagem.setEhVisivel(false);
                inimigo.setEhVisivel(false);
                emJogo = false;
            }
            ArrayList<Tiro> tiros = this.personagem.getTiros();
            for (int j = 0; j < tiros.size(); j++) {
                Tiro tiro = tiros.get(j);
                Rectangle formaTiro = tiro.getRectangle();
                if (formaInimigo.intersects(formaTiro)) {
                    inimigo.setEhVisivel(false);
                    tiro.setEhVisivel(false);
            }
        }
            ArrayList<SuperTiro> superTiros = this.personagem.getSuperTiros();
            for (int s = 0; s < superTiros.size(); s++) {
                SuperTiro superTiro = superTiros.get(s);
                Rectangle formaSuper =superTiro.getRectangle();
                if (formaInimigo.intersects(formaSuper)) {
                    inimigo.setEhVisivel(false);
                }
            }        
    }
}


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
            personagem.atirar();
        if(e.getKeyCode() == KeyEvent.VK_Q)
                personagem.superAtirar();            
        else
            personagem.mover(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.personagem.parar(e);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personagem.atualizar();
        // Recuperar a nossa lista de tiros (getTiros) e atribuímos para uma variável
        // local chamada tiros.
        ArrayList<Tiro> tiros = personagem.getTiros();
        // Criando um laço de repetição (for). Iremos percorrer toda a lista.
        for (int i = 0; i < tiros.size(); i++) {
            // Obter o objeto tiro da posicao i do ArrayList
            Tiro tiro = tiros.get(i);
            // Verificar se (if) a posição do x (tiro.getPosicaoEmX()) é maior do que a
            // largura da nossa janela
            if (tiro.getPosicaoEmX() > LARGURA_DA_JANELA || !tiro.getEhVisivel())
                // Remover da lista se estiver fora do campo de visão (LARGURA_DA_JANELA)
                tiros.remove(tiro);
            else
                // Atualizar a posição do tiro.
                tiro.atualizar();
    }
        ArrayList<SuperTiro> superTiros = personagem.getSuperTiros();
        // Criando um laço de repetição (for). Iremos percorrer toda a lista.
        for (int i = 0; i < superTiros.size(); i++) {
            // Obter o objeto tiro da posicao i do ArrayList
            SuperTiro superTiro = superTiros.get(i);
            // Verificar se (if) a posição do x (tiro.getPosicaoEmX()) é maior do que a
            // largura da nossa janela
            if (superTiro.getPosicaoEmX() > LARGURA_DA_JANELA || !superTiro.getEhVisivel())
                // Remover da lista se estiver fora do campo de visão (LARGURA_DA_JANELA)
                superTiros.remove(superTiro);
            else
                // Atualizar a posição do tiro.
                superTiro.atualizar();
        }    
        // Criando um laço de repetição (for). Iremos percorrer toda a lista.
        for (int i = 0; i < this.inimigos.size(); i++) {
            // Obter o objeto inimigo da posicao i do ArrayList
            Inimigo inimigo = this.inimigos.get(i);
            // Verificar se (if) a posição do x (inimigo.getPosicaoEmX()) é maior do que a
            // largura da nossa janela
            if (inimigo.getPosicaoEmX() < 0 || !inimigo.getEhVisivel())
                // Remover da lista se estiver fora do campo de visão (0)
                inimigos.remove(inimigo);
            else
                // Atualizar a posição do inimigo.
                inimigo.atualizar();
        }
        this.verficarColisoes();
        repaint();
}

    


}