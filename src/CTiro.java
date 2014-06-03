import java.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;

public class CTiro extends CObjetoAvancado implements ITamanhos
{  
  
  public void Dispara( byte direcao, CMapa mapa, CTanque tanque, int x , int y )
  {
      m_x = x;
      m_y = y;
      this.SetarXY( m_x , m_y );      
      
      switch ( direcao )
      {
        case UP:                           
                while ( ((!ChecarColisaoUP( mapa )) && (!ChecarColisaoTanqueUP( tanque ))) && (m_y > 0) )
                {
                    this.SetarY( m_y -= 32 );
                }
                if ( m_y > 0 )
                {
                    if ( ChecarColisaoUP( mapa ) )
                    {                    
                        m_y -= 32;
                        mapa.DestroiBloco( this.ObterPosicaoXMapa(), this.ObterPosicaoYMapa() );                    
                    }
                    else if ( ChecarColisaoTanqueUP( tanque ) )
                    {
                        tanque.Destroi();
                    }
                }                 
        break;
        
        case RIGHT:
                    while ( (!ChecarColisaoRIGHT( mapa )) && (!ChecarColisaoTanqueRIGHT(tanque)) && this.ObterX2() < TELA_LARGURA )
                    {
                        this.SetarX( m_x += 32 );
                    }
                    
                    if ( this.ObterX2() < TELA_LARGURA )
                    {
                        if ( ChecarColisaoRIGHT( mapa ) )
                        {                    
                            m_x += 32;
                            mapa.DestroiBloco( this.ObterPosicaoXMapa(), this.ObterPosicaoYMapa() );                    
                        }
                        else if(ChecarColisaoTanqueRIGHT(tanque))
                            tanque.Destroi();
                    }   
        break;
        
        case DOWN:
                    while ( (!ChecarColisaoDOWN( mapa )) && (!ChecarColisaoTanqueDOWN(tanque)) && this.ObterY2() < TELA_ALTURA )
                    {
                        this.SetarY( m_y += 32 );
                    }
                    
                    if ( this.ObterY2() < TELA_ALTURA )
                    {
                        if ( ChecarColisaoDOWN( mapa ) )
                        {                    
                            m_y += 32;
                            mapa.DestroiBloco( this.ObterPosicaoXMapa(), this.ObterPosicaoYMapa() );                    
                        }
                        else if (ChecarColisaoTanqueDOWN(tanque))
                            tanque.Destroi();
                    }
        break;
        
        case LEFT:
                    while ( (!ChecarColisaoLEFT( mapa )) && (!ChecarColisaoTanqueLEFT(tanque)) && m_x > 0 )
                    {
                        this.SetarX( m_x -= 32 );
                    }
                    
                    if ( m_x > 0 )
                    {
                        if ( ChecarColisaoLEFT( mapa ) )
                        {                    
                            m_x -= 32;
                            mapa.DestroiBloco( this.ObterPosicaoXMapa(), this.ObterPosicaoYMapa() );                    
                        }
                        else if (ChecarColisaoTanqueLEFT(tanque))
                            tanque.Destroi();
                    }
        break;

      }/**/
    
  }
    
}
