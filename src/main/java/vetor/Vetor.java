package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T> implements Comparable<T>{

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		if (!isCheio()) {
			indice = indice + 1;
			arrayInterno[indice] = o;
			tamanho = tamanho + 1;
		}
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		int i = 0;
		T retorno = null;
		while (i <= indice) {
			if (arrayInterno[i].equals(o)) {
				retorno = arrayInterno[i];
				arrayInterno[i] = null;
				swift(i);
				break;
			}
			i++;
		}
		return retorno;
	}

	private void swift(int i) {
		T aux = null;
		for (int j = i; j < indice; j++) {
			arrayInterno[j] = arrayInterno[j+1];
		}
		arrayInterno[indice] = null;
		indice--;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		int i = 0;
		T resultado = null;
		while (i <= indice) {
			if (arrayInterno[i].equals(o)) {
				resultado = arrayInterno[i];
				break;
			}
		}
		return resultado;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		if (indice == -1)
			return true;
		else
			return false;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		if (indice == tamanho-1) 
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
