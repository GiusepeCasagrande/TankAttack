import java.awt.*;
import java.applet.Applet;
import javax.swing.*;
import java.*;

public class CBase extends CObjeto implements ITamanhos
{

  Image m_imagem1, m_imagem2, m_imagem3, m_imagem4;
  Applet m_applet;
  CMapa m_mapa;

  CBase(int x, int y, int largura, int altura, Image imagem1,Image imagem2, 
        Image imagem3, Image imagem4, Applet applet, CMapa mapa)
  {
    super(x, y, largura, altura);
    m_mapa = mapa;
    m_applet = applet;
    m_imagem1 = imagem1;
    m_imagem2 = imagem2;
    m_imagem3 = imagem3;
    m_imagem4 = imagem4;
    m_mapa.SetarImagem( m_imagem1, ObterPosicaoXMapa(), ObterPosicaoYMapa() );
    m_mapa.SetarImagem( m_imagem2, ObterPosicaoXMapa() + 1, ObterPosicaoYMapa() );
    m_mapa.SetarImagem( m_imagem3, ObterPosicaoXMapa(), ObterPosicaoYMapa() + 1 );
    m_mapa.SetarImagem( m_imagem4, ObterPosicaoXMapa() + 1, ObterPosicaoYMapa() + 1 );
    m_mapa.SetarExiste( ObterPosicaoXMapa(), ObterPosicaoYMapa() );
    m_mapa.SetarExiste( ObterPosicaoXMapa() + 1, ObterPosicaoYMapa() );
    m_mapa.SetarExiste( ObterPosicaoXMapa(), ObterPosicaoYMapa() + 1 );
    m_mapa.SetarExiste( ObterPosicaoXMapa() + 1, ObterPosicaoYMapa() + 1 );
  }
/*
  public void Desenhar(Graphics g)
  {
    m_mapa.Desenhar( m_imagem1 );  
    g.drawImage( m_imagem1, m_x, m_y, m_applet);
    g.drawImage( m_imagem2, m_x + 32, m_y, m_applet);
    g.drawImage( m_imagem3, m_x + 32, m_y + 32, m_applet);
    g.drawImage( m_imagem4, m_x, m_y + 32, m_applet);
  }
/**/  
  public boolean Destruida()
  {
      if (      m_mapa.Existe( ObterPosicaoXMapa(), ObterPosicaoYMapa() ) ||
                m_mapa.Existe( ObterPosicaoXMapa() + 1, ObterPosicaoYMapa() ) ||
                m_mapa.Existe( ObterPosicaoXMapa(), ObterPosicaoYMapa() + 1 ) ||
                m_mapa.Existe( ObterPosicaoXMapa() + 1, ObterPosicaoYMapa() + 1 ) )
          return false;
      else return true;
  }
  
} 