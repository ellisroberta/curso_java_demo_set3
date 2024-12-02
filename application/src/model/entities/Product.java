package model.entities;

import java.util.Objects;

public class Product {

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Primeira implementação do método equals
    @Override
    public boolean equals(Object o) {
        // Usando o operador instanceof com pattern matching (disponível a partir do Java 16)
        // Isso torna o código mais limpo e evita a necessidade de um cast explícito.
        if (!(o instanceof Product product)) return false;
        // Compara os atributos name e price para verificar se os objetos são iguais.
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        // Gera um código hash com base nos atributos name e price.
        return Objects.hash(name, price);
    }

    // Segunda implementação do método equals
    /*
    @Override
    public boolean equals(Object o) {
        // Verifica se o objeto é nulo ou se não é da classe Product
        if (o == null || getClass() != o.getClass()) return false;
        // Realiza um cast explícito, que pode lançar uma ClassCastException se o objeto não for do tipo correto.
        Product product = (Product) o;
        // Compara os atributos name e price para verificar se os objetos são iguais.
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        // Gera um código hash com base nos atributos name e price.
        return Objects.hash(name, price);
    }
    */

    // Comentário sobre qual implementação usar:
    // A primeira implementação (com instanceof e pattern matching) é preferível por ser mais moderna e limpa.
    // Ela lida automaticamente com o caso onde 'o' é null e evita a necessidade de um cast explícito.
    //
    // Por outro lado, a segunda implementação (com getClass()) é mais restritiva, garantindo que apenas instâncias da classe Product sejam consideradas iguais.
    // Use essa abordagem se precisar dessa restrição de classe.
    // No entanto, isso pode limitar a flexibilidade se você planeja usar heranças.
}