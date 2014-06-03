import java.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;

public class CObjetoAvancado extends CObjeto implements ITamanhos
{
    Image m_imagem;
    Applet m_applet;
    public final int VELOCIDADE = 32;
    protected byte m_direcao;
    
    CObjetoAvancado(int x, int y, int largura, int altura, Image imagem, Applet applet) 
    {
        super(x, y, largura, altura);
        m_imagem = imagem;
        m_applet = applet;    
    }
    
    CObjetoAvancado(){}
    
  public void Desenhar(Graphics g)
  {
    if ( this.Existe() ) g.drawImage( m_imagem, m_x, m_y, m_applet);
  }
  
  public void SetarDirecao(byte direcao)
  {
        m_direcao = direcao;
  }

  public byte ObterDirecao()
  {
      return m_direcao;
  }
  
  public void SetarImagem( Image imagem )
  {
       m_imagem = imagem;
  }
  
  public boolean ChecarColisaoTanqueUP( CTanque tanque )
  {
      if ( (tanque.ObterY() == this.ObterY() - 32) && (tanque.ObterX() == this.ObterX()) && tanque.Existe() )
          return true;
      else
          return false;
  }

  public boolean ChecarColisaoTanqueRIGHT( CTanque tanque )
  {
      if ( (tanque.ObterX() == (this.ObterX() + 32)) && (tanque.ObterY() == this.ObterY() && tanque.Existe()) )
          return true;
      else
          return false;
  }
  
  public boolean ChecarColisaoTanqueDOWN( CTanque tanque )
  {
      if ( (tanque.ObterY() == this.ObterY() + 32) && (tanque.ObterX() == this.ObterX()) && tanque.Existe() )
          return true;
      else
          return false;
  }
  
  public boolean ChecarColisaoTanqueLEFT( CTanque tanque )
  {
      if ( (tanque.ObterX() == this.ObterX() - 32) && (tanque.ObterY() == this.ObterY()) && tanque.Existe() )
          return true;
      else
          return false;
  }  
  
  public boolean ChecarColisaoUP(CMapa mapa)
  {
      if ( mapa.Existe( ObterPosicaoXMapa(), ObterPosicaoYMapa() - 1))
        return true;
      else
        return false;
  }
  
  public boolean ChecarColisaoDOWN(CMapa mapa)
  {
      if ( mapa.Existe( ObterPosicaoXMapa(), ObterPosicaoYMapa() + 1))
        return true;
      else
        return false;
  }
  
  public boolean ChecarColisaoRIGHT(CMapa mapa)
  {
      if ( mapa.Existe(this.ObterPosicaoXMapa() + 1,this.ObterPosicaoYMapa()))
        return true;
      else
        return false;
  }
  
  public boolean ChecarColisaoLEFT(CMapa mapa)
  {
      if ( mapa.Existe(this.ObterPosicaoXMapa() - 1,this.ObterPosicaoYMapa()))
        return true;
      else
        return false;
  }
}
