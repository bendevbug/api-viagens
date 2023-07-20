package apidepoimentos.apiDepoimentos.Depoimentos;

import org.antlr.v4.runtime.misc.NotNull;

public record DadosAtualizacaoDepoimentos(@NotNull Long id, String nome, byte[] imagem, String depoimento) {

}
