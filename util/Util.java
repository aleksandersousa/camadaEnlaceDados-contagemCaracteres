/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 02/11/2020*
Ultima alteracao: 07/11/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */
package util;

import view.PainelDireito;
import view.PainelEsquerdo;
import view.TelaPrincipal;

public class Util {
  /*
   * ************************************************************** Metodo:
   * imprimirNaTela* Funcao: Imprimir as informacoes na tela* Parametros: String
   * strMensagem: texto a ser impresso int tipoDeImpressao: em qual caixa de texto
   * sera impresso* Retorno: void*
   */
  public static void imprimirNaTela(String strMensagem, int tipoDeImpressao) {
    try {
      switch (tipoDeImpressao) {
        case Constantes.ASCII:// imprime tabela ascii
          PainelEsquerdo.arrayCaixasDeTexto.get(0).setText(strMensagem);
          PainelEsquerdo.arrayCaixasDeTexto.get(0).update(PainelEsquerdo.arrayCaixasDeTexto.get(0).getGraphics());
          break;
        case Constantes.ASCII_DECODIFICADO: // imprime tabela ascii decodificada
          PainelDireito.arrayCaixasDeTexto.get(1).setText(strMensagem);
          PainelDireito.arrayCaixasDeTexto.get(1).update(PainelDireito.arrayCaixasDeTexto.get(1).getGraphics());
          break;
        case Constantes.MENSAGEM_DECODIFICADA: // imprime mensagem decodificada
          PainelDireito.arrayCaixasDeTexto.get(4).setText(strMensagem);
          PainelDireito.arrayCaixasDeTexto.get(4).update(PainelDireito.arrayCaixasDeTexto.get(4).getGraphics());
          break;
        case Constantes.QUADRO_CODIFICADO: // imprime os quadros codificados
          PainelEsquerdo.arrayCaixasDeTexto.get(7).setText(strMensagem);
          PainelEsquerdo.arrayCaixasDeTexto.get(7).update(PainelEsquerdo.arrayCaixasDeTexto.get(7).getGraphics());
          break;
        case Constantes.QUADRO_DECODIFICADO: // imprime os quadros decodificados
          PainelDireito.arrayCaixasDeTexto.get(8).setText(strMensagem);
          PainelDireito.arrayCaixasDeTexto.get(8).update(PainelDireito.arrayCaixasDeTexto.get(8).getGraphics());
      }
      Thread.sleep(600);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /*
   * ************************************************************** Metodo:
   * repintarPainel* Funcao: inicializa o thread que repinta o painel canvas*
   * Parametros: nulo* Retorno: void*
   */
  public static void repintarCanvas() {
    try {
      TelaPrincipal.canvas.repintar();
      Thread.sleep(600);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
