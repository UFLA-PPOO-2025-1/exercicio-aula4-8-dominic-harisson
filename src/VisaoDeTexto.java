import java.awt.Color;

public class VisaoDeTexto implements VisaoSimulador {
    private EstatisticasCampo estatisticas;

    public VisaoDeTexto() {
        estatisticas = new EstatisticasCampo();
    }

    /**
     * Define uma cor a ser usada para uma classe específica de animal.
     * @param classeAnimal A classe do animal.
     * @param cor A cor a ser usada para a classe fornecida.
     */
    @Override
    public void definirCor(Class<?> classeAnimal, Color cor) {
        //não tem sentido num método textual
    }

    /**
     * Determina se a simulação deve continuar a ser executada.
     * @return true Se houver mais de uma espécie viva.
     */
    @Override
    public boolean ehViavel(Campo campo) {
        return estatisticas.ehViavel(campo);
    }

    /**
     * Mostra o estado atual do campo.
     * @param passo Qual iteração do passo está sendo exibida.
     * @param campo O campo cujo estado será exibido.
     */
    @Override
    public void mostrarStatus(int passo, Campo campo) {
        estatisticas.reiniciar();

        for(int linha = 0; linha < campo.obterComprimento(); linha++) {
            for(int coluna = 0; coluna < campo.obterLargura(); coluna++) {
                Object animal = campo.obterObjetoEm(linha, coluna);
                if(animal != null) {
                    estatisticas.incrementarContagem(animal.getClass());
                }
            }
        }

        System.out.println("Passo: " + passo + " - " + estatisticas.obterDetalhesPopulacao(campo));
    }
    
    /**
     * Prepara para uma nova execução
     */
    @Override
    public void reiniciar() {
        estatisticas.reiniciar();
    }

    /**
     * Reabilita as opções da visão
     */
    @Override
    public void reabilitarOpcoes() {
        //sem uso aqui
    }
}