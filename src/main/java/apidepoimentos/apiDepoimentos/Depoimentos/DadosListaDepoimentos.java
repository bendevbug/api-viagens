package apidepoimentos.apiDepoimentos.Depoimentos;

public record DadosListaDepoimentos(

        Long id,
        String nome,
        String depoimento,
        byte[] imagem
) {
    public DadosListaDepoimentos(Depoimento depoimento) {
        this(depoimento.getId(), depoimento.getNome(), depoimento.getDepoimento(), depoimento.getImagem());
    }

}
