/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 02/11/2020*
Ultima alteracao: 07/11/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */
package camadas.camada_enlace;

import util.Constantes;
import util.Conversao;

import util.Util;

public class CamadaEnlaceDadosTransmissoraEnquadramento {
  /*
   * *****************************************************************************
   * Metodo: camadaDeEnlaceDeDadosTransmissoraEnquadramento* Funcao: Enviar os
   * quadros para a camada fisica* Parametros: int[] quadro: vetor de inteiros com
   * os bits* Retorno: int[] quadroEnquadrado = vetor com os quadros*
   */
  static public int[] camadaDeEnlaceDeDadosTransmissoraEnquadramento(int[] quadro) {
    int[] quadroEnquadrado = enquadramentoContagemDeCaracteres(quadro);

    Util.imprimirNaTela(Conversao.bitsParaString(quadroEnquadrado), Constantes.QUADRO_CODIFICADO);

    return quadroEnquadrado;
  }

  /*
   * *****************************************************************************
   * Metodo: enquadramentoContagemDeCaracteres* Funcao: Cria os quadros com a
   * contagem de caracteres* Parametros: int[] quadro: vetor de inteiros com os
   * bits* Retorno: int[] quadroEnquadrado = vetor com os quadros*
   */
  private static int[] enquadramentoContagemDeCaracteres(int[] quadro) {
    int[] quadroEnquadrado;

    int numeroDeBits = 32 - Integer.numberOfLeadingZeros(quadro[quadro.length - 1]);
    numeroDeBits = Conversao.arredondaBits(numeroDeBits);

    if (numeroDeBits <= 24) {
      quadroEnquadrado = new int[quadro.length];
    } else {
      quadroEnquadrado = new int[quadro.length + 1];
    }

    int[] asciiArray = Conversao.bitsParaAscii(quadro);
    int[] quadroArray;
    int indexAsciiArray = 0;
    int tamanhoQuadro = 0;
    int indexQuadroEnquadrado = 0;
    int bits = 0; // inteiro responsavel por armazenar os bits

    while (indexAsciiArray < asciiArray.length) {
      for (int i = indexAsciiArray; i < asciiArray.length; i++) { // pegando o tamanho do quadro
        if (asciiArray[i] == Constantes.ESPACO) {
          break;
        }
        tamanhoQuadro++;
      }

      quadroArray = new int[tamanhoQuadro + 1];

      for (int i = 0; i < tamanhoQuadro + 1; i++) { // adicionando os chars ao quadro
        if (i == 0) {
          quadroArray[i] = tamanhoQuadro + 1;
        } else {
          quadroArray[i] = asciiArray[indexAsciiArray];
          indexAsciiArray++;
        }
      }

      indexAsciiArray++; // pega o proximo caractere, excluindo o espaco

      for (int i = 0; i < quadroArray.length; i++) { // transformando os chars em bits
        bits <<= 8;
        bits |= quadroArray[i];

        if (Conversao.arredondaBits(32 - Integer.numberOfLeadingZeros(bits)) == 32) {
          quadroEnquadrado[indexQuadroEnquadrado] = bits;
          indexQuadroEnquadrado++;
          bits = 0;
        }
      }

      if (indexQuadroEnquadrado < quadroEnquadrado.length) {
        if (indexAsciiArray - 1 == asciiArray.length) { // checa se eh o ultimo char do array
          quadroEnquadrado[indexQuadroEnquadrado] = bits;
          indexQuadroEnquadrado++;
          bits = 0;
        }
      }

      tamanhoQuadro = 0;
    }

    return quadroEnquadrado;
  }
}
