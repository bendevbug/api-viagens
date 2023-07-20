package apidepoimentos.apiDepoimentos.Depoimentos;

public record DadosDepoimento(
        Long id,
        String nome,
        String depoimento,
        byte[] imagem
) { }
