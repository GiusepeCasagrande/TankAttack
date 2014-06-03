import java.awt.*;
import java.awt.Graphics;
import java.awt.Image.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import sun.audio.*;
import javax.sound.midi.*;
import javax.sound.*;
import java.*;
import java.io.*;

public class TankAttack extends Applet implements Runnable, ITamanhos, KeyListener
{
  protected CMapa m_mapa;
  protected Image img_buffer;
  protected Image[] base_imagem = new Image[4];
  protected Graphics gfx_buffer;
//  protected Color m_cor = Color.green; 
  protected CTanque m_tanque1, m_tanque2 ;
  protected CBase m_base2, m_base1;
  protected CTiro m_tiro1, m_tiro2;
  protected boolean fim_do_jogo = false;
  
  public void init()
  {
    img_buffer = createImage(TELA_LARGURA, TELA_ALTURA);
    gfx_buffer = img_buffer.getGraphics();  
    m_mapa = new CMapa(getImage(getCodeBase(), " Bloco.gif"), this);
    m_tanque1 = new CTanque(736, 416 , BLOCO_LARGURA , BLOCO_ALTURA, getImage(getCodeBase(), "TanqueUP.gif"), this);
    m_tanque1.SetarDirecao(UP);
    m_tanque2 = new CTanque(32, 64 , BLOCO_LARGURA , BLOCO_ALTURA, getImage(getCodeBase(), "TanqueDOWN.gif"), this);
    m_tanque2.SetarDirecao(DOWN);
    
    m_base1 = new CBase(704, 448, BLOCO_LARGURA * 4, BLOCO_ALTURA * 4,
            getImage(getCodeBase(), " Base1.gif"),
            getImage(getCodeBase(), " Base3.gif"), 
            getImage(getCodeBase(), " Base2.gif"), 
            getImage(getCodeBase(), " Base4.gif"), this, m_mapa );
   /**/ 
    m_base2 = new CBase(0, 0, BLOCO_LARGURA * 4, BLOCO_ALTURA * 4, 
            getImage(getCodeBase(), " Base1.gif"),
            getImage(getCodeBase(), " Base2.gif"), 
            getImage(getCodeBase(), " Base3.gif"), 
            getImage(getCodeBase(), " Base4.gif"), this, m_mapa );
    
    m_tiro1 = new CTiro();
    m_tiro2 = new CTiro();

    addKeyListener(this);  
  }

  public void start()
  {
    this.play(getCodeBase(), "riverkwai.mid");
  }

  public void run()
  {
  }

  public void paint( Graphics g )
  {
        gfx_buffer.drawImage( getImage(getCodeBase(), "Fundo.jpg"), 0, 0, this );
        m_mapa.Desenhar( gfx_buffer );    
        m_base1.Desenhar( gfx_buffer );
        m_base2.Desenhar( gfx_buffer );
        m_tanque1.Desenhar( gfx_buffer );
        m_tanque2.Desenhar( gfx_buffer );
        g.drawImage(img_buffer,0,0,this); //desenha no apllet        
        
        if ( fim_do_jogo )
        {
            g.drawImage(getImage(getCodeBase(), "TelaFim.gif"),0,0, this);                       
        }
    
    //g.drawImage(img_buffer,0,0,this); //desenha no apllet
  }



  public void update(Graphics g)
  {
    paint( g );
  }

  public void stop(){ }
  
  public void keyPressed(KeyEvent e) 
  {     
      if (e.getKeyCode()==e.VK_RIGHT)
      {       
        if (m_tanque1.ObterDirecao() != RIGHT)
            {    
                m_tanque1.SetarDirecao(RIGHT);
                m_tanque1.SetarImagem(getImage(getCodeBase(), "TanqueRIGHT.gif"));
            }
        else
            {
                if ( m_tanque1.ObterX2() < TELA_LARGURA )
                    if ( (!m_tanque1.ChecarColisaoRIGHT( m_mapa )) && (!m_tanque1.ChecarColisaoTanqueRIGHT(m_tanque2)) )
                        {
                            m_tanque1.IncX( m_tanque1.VELOCIDADE );              
                            this.play(getCodeBase(), "Mover.wav");
                         }
                   else this.play(getCodeBase(), "Colidir.wav");
            } 
      }
      else if (e.getKeyCode()==e.VK_LEFT)
           {
               if (m_tanque1.ObterDirecao()!=LEFT)
                   {
                     m_tanque1.SetarDirecao(LEFT);
                     m_tanque1.SetarImagem(getImage(getCodeBase(), "TanqueLEFT.gif"));
                   }
               else
                   {
                     if ( m_tanque1.ObterX() > 0 )
                        if ( (!m_tanque1.ChecarColisaoLEFT( m_mapa )) && (!m_tanque1.ChecarColisaoTanqueLEFT(m_tanque2)) )
                            {
                                m_tanque1.DecX( m_tanque1.VELOCIDADE );
                                this.play(getCodeBase(), "Mover.wav");
                            }
                        else this.play(getCodeBase(), "Colidir.wav");
                   }
            }
            else if (e.getKeyCode()==e.VK_UP)
                 {
                   if (m_tanque1.ObterDirecao()!=UP)
                       {
                         m_tanque1.SetarDirecao(UP);
                         m_tanque1.SetarImagem(getImage(getCodeBase(), "TanqueUP.gif"));
                       }
                       
                   else
                       {
                         if ( m_tanque1.ObterY() > 0)
                            if ( (!m_tanque1.ChecarColisaoUP(m_mapa)) && (!m_tanque1.ChecarColisaoTanqueUP(m_tanque2)))
                                {
                                    m_tanque1.DecY( m_tanque1.VELOCIDADE );
                                    this.play(getCodeBase(), "Mover.wav");
                                }
                            else this.play(getCodeBase(), "Colidir.wav");    
                       }
                 }
                 else if (e.getKeyCode()==e.VK_DOWN)
                      {
                        if (m_tanque1.ObterDirecao()!=DOWN)
                            {
                              m_tanque1.SetarDirecao(DOWN);
                              m_tanque1.SetarImagem(getImage(getCodeBase(), "TanqueDOWN.gif"));
                            }
                          
                        else
                            {
                              if ( m_tanque1.ObterY2() < TELA_ALTURA)
                                  if ( (!m_tanque1.ChecarColisaoDOWN( m_mapa )) && (!m_tanque1.ChecarColisaoTanqueDOWN(m_tanque2)))
                                      {
                                          m_tanque1.IncY( m_tanque1.VELOCIDADE );      
                                          this.play(getCodeBase(), "Mover.wav");
                                      }
                                  else this.play(getCodeBase(), "Colidir.wav");
                              
                            }
                      }
                      
                 else if (e.getKeyCode()==e.VK_ENTER)
                        {
                          this.play(getCodeBase(), "Tiro.wav");  
                          m_tanque1.Atirar( m_mapa, m_tiro1, m_tanque2 );                                                    
                        }  

            
    
//     repaint();
     /************************/
     /*Movimento do tanque 2*/
     /***********************/
     if (e.getKeyCode()==e.VK_D)
      {       
        if (m_tanque2.ObterDirecao() != RIGHT)
            {    
                m_tanque2.SetarDirecao(RIGHT);
                m_tanque2.SetarImagem(getImage(getCodeBase(), "TanqueRIGHT.gif"));
            }
        else
            {
                if ( m_tanque2.ObterX2() < TELA_LARGURA )
                    if ( (!m_tanque2.ChecarColisaoRIGHT( m_mapa )) && (!m_tanque2.ChecarColisaoTanqueRIGHT(m_tanque1)))
                        {
                            m_tanque2.IncX( m_tanque2.VELOCIDADE );              
                            this.play(getCodeBase(), "Mover.wav");
                         }
                   else this.play(getCodeBase(), "Colidir.wav");
            } 
      }
      else if (e.getKeyCode()==e.VK_A)
           {
               if (m_tanque2.ObterDirecao()!=LEFT)
                   {
                     m_tanque2.SetarDirecao(LEFT);
                     m_tanque2.SetarImagem(getImage(getCodeBase(), "TanqueLEFT.gif"));
                   }
               else
                   {
                     if ( m_tanque2.ObterX() > 0 )
                        if ( (!m_tanque2.ChecarColisaoLEFT( m_mapa )) && (!m_tanque2.ChecarColisaoTanqueLEFT(m_tanque1)))
                            {
                                m_tanque2.DecX( m_tanque2.VELOCIDADE );
                                this.play(getCodeBase(), "Mover.wav");
                            }
                        else this.play(getCodeBase(), "Colidir.wav");
                   }
            }
            else if (e.getKeyCode()==e.VK_W)
                 {
                   if (m_tanque2.ObterDirecao()!=UP)
                       {
                         m_tanque2.SetarDirecao(UP);
                         m_tanque2.SetarImagem(getImage(getCodeBase(), "TanqueUP.gif"));
                       }
                       
                   else
                       {
                         if ( m_tanque2.ObterY() > 0)
                            if ( (!m_tanque2.ChecarColisaoUP(m_mapa)) && (!m_tanque2.ChecarColisaoTanqueUP(m_tanque1)))                                {
                                    m_tanque2.DecY( m_tanque2.VELOCIDADE );
                                    this.play(getCodeBase(), "Mover.wav");
                                }
                            else this.play(getCodeBase(), "Colidir.wav");    
                       }
                 }
                 else if (e.getKeyCode()==e.VK_S)
                      {
                        if (m_tanque2.ObterDirecao()!=DOWN)
                            {
                              m_tanque2.SetarDirecao(DOWN);
                              m_tanque2.SetarImagem(getImage(getCodeBase(), "TanqueDOWN.gif"));
                            }
                          
                        else
                            {
                              if ( m_tanque2.ObterY2() < TELA_ALTURA)
                                  if ( (!m_tanque2.ChecarColisaoDOWN( m_mapa )) && (!m_tanque2.ChecarColisaoTanqueDOWN(m_tanque1)))
                                      {
                                          m_tanque2.IncY( m_tanque2.VELOCIDADE );      
                                          this.play(getCodeBase(), "Mover.wav");
                                      }
                                  else this.play(getCodeBase(), "Colidir.wav");
                              
                            }
                      }                      
                 else if (e.getKeyCode()==e.VK_G)
                        {
                          this.play(getCodeBase(), "Tiro.wav");                                                      
                          m_tanque2.Atirar( m_mapa, m_tiro2, m_tanque1 );                          
                        }
   
   repaint();
     
   if ( m_base1.Destruida() || m_base2.Destruida() )
       AcabaJogo();
     
} 
  
  void AcabaJogo()
  {  
      this.play(getCodeBase(), "aplausos.wav");
      fim_do_jogo = true;
  }
  
  public void keyReleased(KeyEvent e) {  }
  
  public void keyTyped(KeyEvent e) {  }
  
}