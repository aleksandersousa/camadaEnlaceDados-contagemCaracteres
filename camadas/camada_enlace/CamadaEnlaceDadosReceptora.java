/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 02/11/2020*
Ultima alteracao: 07/11/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */
package camadas.camada_enlace;

import camadas.camada_aplicacao.CamadaDeAplicacaoReceptora;

public class CamadaEnlaceDadosReceptora {
  public static void camadaEnlaceDadosReceptora(int[] quadro) {
    quadro = CamadaEnlaceDadosReceptoraEnquadramento.camadaDeEnlaceDeDadosReceptoraEnquadramento(quadro);
    CamadaDeAplicacaoReceptora.camadaDeAplicacaoReceptora(quadro);
  }
}
