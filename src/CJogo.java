

import java.awt.*;
import java.applet.Applet.*;
import javax.swing.JApplet;

public class CJogo
{
  protected CFase	m_fase;
  protected Image img_buffer;
  protected Graphics gfx_buffer;
  protected JApplet m_applet;

  CJogo( JApplet applet)
  {
    m_applet = applet;
    img_buffer = m_applet.createImage(640, 640);
    gfx_buffer = m_applet.getGraphics();  /**/
  }



	void Executar()
  {
    ExibirMenuPrincipal();
    m_fase.Atualizar();
    m_fase.Desenhar( gfx_buffer );
//    gfx_buffer.drawImage(img_buffer, 0, 0, m_applet);
  }


	void Desligar()
  {
  }


	protected void IniciarPartida()
  {
  }

	protected void ExecutarPartida(){ }
	protected void DesligarPartida(){ }

	protected void ExibirMenuPrincipal()
  {
    IniciarPartida();
    ExecutarPartida();
    DesligarPartida();
  }



}
