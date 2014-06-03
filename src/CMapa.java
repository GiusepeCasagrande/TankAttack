import javax.swing.*;
import java.awt.*;
import java.applet.*;

public class CMapa implements ITamanhos
{
  CBloco m_blocos[][] = new CBloco[MAPA_LARGURA_BLOCOS][MAPA_ALTURA_BLOCOS];
  Image m_imagem;
  Applet m_applet;

  public CMapa(Image imagem, Applet applet)
  {
    m_imagem = imagem;
    m_applet = applet;
    
    for (int x = 0; x < MAPA_LARGURA_BLOCOS; ++x)
        for ( int y = 0; y < MAPA_ALTURA_BLOCOS; ++y)
        {
           m_blocos[x][y] = new CBloco(x * BLOCO_LARGURA, y * BLOCO_ALTURA,
                                    BLOCO_LARGURA, BLOCO_ALTURA, m_imagem, m_applet);          
           
           if ((( x > 2 ) || ( y > 2 )) &&
               (( x < MAPA_LARGURA_BLOCOS - 3 ) || ( y < MAPA_ALTURA_BLOCOS - 3 )))
                  m_blocos[x][y].SetarExiste();
        }
  }

  public void Desenhar(Graphics g)
  {
    for (int x = 0; x < MAPA_LARGURA_BLOCOS; x++)
        for ( int y = 0; y < MAPA_ALTURA_BLOCOS; y++)
             m_blocos[x][y].Desenhar(g);
  }
  
  public void SetarExiste( int x, int y )
  {
      m_blocos[x][y].SetarExiste();
  }

  public boolean Existe( int x, int y )
  {
      return m_blocos[x][y].Existe(); // verificar out of array aki!!!!!!!!!
      //ocorre quano dispara algo contar uma margem vazia
  }
  
  public void DestroiBloco(int x, int y)
  {
    m_blocos[x][y].SetarNaoExiste();
  }

  public void SetarImagem( Image imagem, int x, int y )
  {
       m_blocos[x][y].SetarImagem( imagem );
  }
  
}