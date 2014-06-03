import java.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;

public class CTanque extends CObjetoAvancado implements ITamanhos
{
  protected CTanque m_tanque;
  protected byte m_dano;
    
  CTanque(int x, int y, int largura, int altura, Image imagem, Applet applet)
  {
    super(x, y, largura, altura, imagem, applet);
    m_dano = 0;
  }
  
  public void Atirar( CMapa mapa, CTiro tiro, CTanque tanque)
  {
    tiro.Dispara( this.ObterDirecao(), mapa, tanque, this.ObterX(), this.ObterY() );
  }
  
  public void Destroi()
  {
      this.SetarNaoExiste();
      m_dano = 5;
  }
  
  public byte ObterDano()
  {
      return m_dano;
  }
  
  public void ReparaDano()
  {
      m_dano--;
  }
}
