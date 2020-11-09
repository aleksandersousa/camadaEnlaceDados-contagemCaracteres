/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 02/11/2020*
Ultima alteracao: 07/11/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */
package camadas;

import camadas.camada_aplicacao.CamadaDeAplicacaoTransmissora;

public class AplicacaoTransmissora {

  /* **************************************************************
  Metodo: aplicacaoTransmissora*
  Funcao: chama a camada de aplicacao transmissora.*
  Parametros: nulo*
  Retorno: void*
  *************************************************************** */
  public static void aplicacaoTransmissora(String txtMensagem) {
    CamadaDeAplicacaoTransmissora.camadaDeAplicacaoTransmissora(txtMensagem);
  }
}
