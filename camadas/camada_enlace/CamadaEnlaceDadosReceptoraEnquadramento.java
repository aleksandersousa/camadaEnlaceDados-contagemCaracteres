/* ***************************************************************
Autor: Aleksander Santos Sousa*
Matricula: 201810825*
Inicio: 02/11/2020*
Ultima alteracao: 07/11/2020*
Nome: Simulador de Redes*
Funcao: Simular o envio de uma mensagem de texto.
*************************************************************** */
package camadas.camada_enlace;

import java.util.ArrayList;

import util.Constantes;
import util.Conversao;
import util.Util;

public class CamadaEnlaceDadosReceptoraEnquadramento {
  /* *****************************************************************************
  Metodo: camadaDeEnlaceDeDadosReceptoraEnquadramento*
  Funcao: Desfazer o que a camada de enlace transmissora fez*
  Parametros: int[] quadro: vetor de inteiros com os bits*
  Retorno: int[] quadroDesenquadrado = vetor com os quadros decodificados*
  ***************************************************************************** */
  static public int[] camadaDeEnlaceDeDadosReceptoraEnquadramento(int[] quadro){
    int[] quadroDesenquadrado = enquadramentoReceptoraContagemDeCaracteres(quadro);

    Util.imprimirNaTela(
      Conversao.bitsParaString(quadroDesenquadrado), Constantes.QUADRO_DECODIFICADO
    );

    return quadroDesenquadrado;
  }

  /* *****************************************************************************
  Metodo: enquadramentoReceptoraContagemDeCaracteres*
  Funcao: Desfazer o que a contagem de caracteres transmissora fez*
  Parametros: int[] quadro: vetor de inteiros com os bits*
  Retorno: int[] quadroDesenquadrado = vetor com os quadros decodificados*
  ***************************************************************************** */
  private static int[] enquadramentoReceptoraContagemDeCaracteres(int[] quadro) {
    ArrayList<Integer> quadroArray = new ArrayList<>();
    ArrayList<Integer> asciiArray = new ArrayList<>();
    int[] tempAsciiArray = Conversao.bitsParaAscii(quadro);

    for(int i=0; i<tempAsciiArray.length; i++){
      if(tempAsciiArray[i] != 0){
        asciiArray.add(tempAsciiArray[i]);
      }
    }

    int index = 0;
    while(index < asciiArray.size()){
      int tamanhoQuadro = asciiArray.get(index);

      if(index > 0){
        quadroArray.add(Constantes.ESPACO);
      }

      index++;
      for(int i=1; i<tamanhoQuadro; i++){
        quadroArray.add(asciiArray.get(index));
        index++;
      }
    }

    int[] tempQuadro2 = new int[quadroArray.size()];
    for(int i=0; i<quadroArray.size(); i++){
      tempQuadro2[i] = quadroArray.get(i);
    }

    int[] quadroDesenquadrado = Conversao.asciiParaBits(tempQuadro2);

    return quadroDesenquadrado;
  }
}
