package apidepoimentos.apiDepoimentos.Depoimentos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "tb_depoimentos")
@Entity(name = "Depoimento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Depoimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String depoimento;
    private byte[] imagem;

    public Depoimento(DadosDepoimento dados) {
        this.depoimento = dados.depoimento();
        this.nome = dados.nome();
        this.imagem = dados.imagem();
    }
}