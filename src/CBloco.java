import java.awt.*;
import java.*;
import java.applet.*;

public class CBloco extends CObjeto
{

  Image m_imagem;
  Applet m_applet;

  public CBloco(int x, int y, int largura, int altura, Image imagem, Applet applet)
  {
    super(x, y, largura, altura);
    m_imagem = imagem;
    m_existe = false;
  }

  public void Desenhar(Graphics g)
  {
    if ( this.Existe() )
        {
            g.drawImage( m_imagem, m_x, m_y, m_applet);
            //g.setColor(m_cor);
            //g.fillRect(m_x, m_y, m_largura, m_altura);
            //g.setColor( Color.black );
            //g.drawRect(m_x, m_y, m_largura, m_altura);
        }
    
  }

  public void SetarImagem( Image imagem )
  {
      m_imagem = imagem;
  }
  
}