/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author 6248489
 */
public class Calculo {

    /* Alterar limites superiores e inferiores */
    int limSuperior = 2;
    int limInferior = 1;
    int i, j;
    double h;
    int loop;
    double meio = 0;
    double ultimoResultado = 0;
    double resultado = 0;

    public Calculo() {
        /* Por algum motivo o programa não considerou a atribuição global */
        ultimoResultado = 0;
    }

    /* Alterar para a formula pedida */
    public double formula(double valor) {
        return valor * 2;

    }

    public void calculo() {
        loop = 1;

        do {
            h = (limSuperior - limInferior) / loop;
            System.out.println("h = " + h);

            /* Gerar o array */
            double array[] = new double[loop + 1];
            double diferenca = limSuperior - limInferior / loop;
            for (j = 0; j < loop + 1; j++) {
                array[j] = limInferior + (diferenca * j);
            }

            for (double b : array) {
                System.out.println(b);
            }

            //Calcular o meio da formula 
            // Se o loop for igual a 1, ele vai ignorar o FOR e depois irá multiplicar 2 por 0 
            meio = 0.0;
            for (int k = 0; k < loop - 1; k++) {
                meio += formula(array[k + 1]);
            }
            /* Multiplicar por 2 */
            meio *= 2;

            /* Resolver */
            System.out.println("ArrayLength = " + array.length);
            resultado = (h / 2.0);
            resultado *= (formula(array[0]) + meio + formula(array[array.length - 1]));
            System.out.println("Resultado do loop " + loop + " foi de: " + resultado);

            array = null;
            loop++;
        } while (erro(resultado) > 0.01);

    }

    /* Arrumar */
    private double erro(double resultadoFuncao) {

        double E = (resultadoFuncao - ultimoResultado) / resultadoFuncao;
        ultimoResultado = resultadoFuncao;
        return E;
    }
}