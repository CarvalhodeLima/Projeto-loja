package repositorios;

import entidades.CarrinhoDeCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeComprasRepositorio {

    private List<CarrinhoDeCompras> carrinhos = new ArrayList<>();

    public void salvar(CarrinhoDeCompras carrinho) {
        carrinhos.add(carrinho);
    }

    public void atualizar(CarrinhoDeCompras carrinhoExistente, CarrinhoDeCompras carrinhoAtualizado) {
        int index = carrinhos.indexOf(carrinhoExistente);
        if (index != -1) {
            carrinhos.set(index, carrinhoAtualizado);
        }
    }

    public void remover(CarrinhoDeCompras carrinho) {
        carrinhos.remove(carrinho);
    }

    public void listarTodos() {
        for (CarrinhoDeCompras carrinho : carrinhos) {
            System.out.println(carrinho +"\n");
        }
    }
}
