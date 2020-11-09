/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 02/11/2020*
Ultima alteracao: 07/11/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */
package camadas.camada_enlace;

import camadas.MeioDeComunicacao;

public class CamadaEnlaceDadosTransmissora {
  public static void camadaEnlaceDadosTransmissora(int[] quadro) {
    quadro = CamadaEnlaceDadosTransmissoraEnquadramento.camadaDeEnlaceDeDadosTransmissoraEnquadramento(quadro);
    MeioDeComunicacao.meioDeComunicacao(quadro);
  }
}
