package apidepoimentos.apiDepoimentos.Depoimentos;

public record DadosListaDepoimentos(
        String nome,
        String depoimento,
        byte[] imagem
) {
    public DadosListaDepoimentos(Depoimento depoimento) {
        this(depoimento.getNome(), depoimento.getDepoimento(), depoimento.getImagem());
    }

}
