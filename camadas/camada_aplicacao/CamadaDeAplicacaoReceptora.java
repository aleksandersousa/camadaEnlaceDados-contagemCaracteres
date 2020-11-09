/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 02/11/2020*
Ultima alteracao: 07/11/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */
package camadas.camada_aplicacao;

import camadas.AplicacaoReceptora;
import util.Constantes;
import util.Conversao;
import util.Util;

public class CamadaDeAplicacaoReceptora {

  /* *****************************************************************************
  Metodo: camadaDeAplicacaoReceptora*
  Funcao: Converter o array de numeros ascii em string*
  Parametros: int[] quadro: vetor com os numeros em ASCII*
  Retorno: void*
  ***************************************************************************** */
  public static void camadaDeAplicacaoReceptora(int[] quadro) {
    int[] asciiArray = Conversao.bitsParaAscii(quadro);

    Util.imprimirNaTela(
      Conversao.asciiParaString(asciiArray, Constantes.ASCII_DECODIFICADO),
      Constantes.ASCII_DECODIFICADO
    );

    String mensagem = Conversao.asciiParaMensagem(asciiArray);
    AplicacaoReceptora.aplicacaoReceptora(mensagem);
  }
}
