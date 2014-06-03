import java.awt.*;

public class CObjeto
{
//------------------------------------------------------------
// Classe básica para manipulação de objetos

    protected int m_x, m_y;
    protected int m_largura, m_altura;
    protected boolean m_existe = true;


    CObjeto(int x, int y, int largura, int altura)
    {
      m_x = x;
      m_y = y;
      m_largura = largura;
      m_altura = altura;
    }
     CObjeto(){}

    public boolean ChecarColisao(int x1, int y1, int x2, int y2)
    {
    	if ((m_x + m_largura < x1)
      ||  (m_y + m_altura  < y1)
      ||  (m_x           > x2)
      ||  (m_y           > y2))
      {
        return false;
      }
      else
      {
        return true;
      }
    }

    public boolean ChecarColisaoX(int x1, int x2)
    {
      if ((m_x + m_largura < x1)
      ||  (m_x           > x2))
      {
        return false;
      }
      else
      {
        return true;
      }
    }

    public boolean ChecarColisaoY(int y1, int y2)
    {
      if ((m_y + m_altura < y1)
      ||  (m_y          > y2))
      {
        return false;
      }
      else
      {
        return true;
      }
    }

    public void SetarX(int x)
    {
      m_x = x;
    }

    public int ObterX()
    {
      return m_x;
    }
    
    public int ObterX2()
    {
      return (m_x + m_largura);
    }

    public void IncX(int incremento)
    {
      m_x += incremento;
    }

    public void DecX(int decremento)
    {
      m_x -= decremento;
    }

    public void SetarY(int y)
    {
      m_y = y;
    }

    public int ObterY()
    {
      return m_y;
    }

    public int ObterY2()
    {
      return (m_y + m_altura);
    }

    public void IncY(int incremento)
    {
        m_y += incremento;
    }

    public void DecY(int decremento)
    {
        m_y -= decremento;
    }

    public void SetarXY(int x, int y)
    {
        m_x = x;
	m_y = y;
    }

    public void SetarLargura(int largura)
    {
      m_largura = largura;
    }

    public int ObterLargura()
    {
      return m_largura;
    }

    public void SetarAltura(int altura)
    {
      m_altura = altura;
    }

    public int ObterAltura()
    {
      return m_altura;
    }

    public void SetarExiste()
    {
      m_existe = true;
    }

    public void SetarNaoExiste()
    {
      m_existe = false;
    }

    public boolean Existe()
    {
      return m_existe;
    }

    public void Desenhar(Graphics g){ }
    
    public int ObterPosicaoXMapa()
    {
       return (m_x / 32);  
    }

    public int ObterPosicaoYMapa()
    {
      return (m_y / 32); 
    }
    
  
}

