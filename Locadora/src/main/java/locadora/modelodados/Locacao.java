package locadora.modelodados;
public class Locacao {

    
        
    private Integer IdLocacao;
    
    
    private Integer IdUsuario;
    private String Nome;
    
    private Integer IdVeiculo;
    private String NomeModelo;
    private String DataEntrada;
    private String DataSaida;
    private double Valor;
    
    /**
     * @return the IdLocacao
     */
    public Integer getIdLocacao() {
        return IdLocacao;
    }

    /**
     * @param IdLocacao the IdLocacao to set
     */
    public void setIdLocacao(Integer IdLocacao) {
        this.IdLocacao = IdLocacao;
    }

    /**
     * @return the IdUsuario
     */
    public Integer getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(Integer IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the IdVeiculo
     */
    public Integer getIdVeiculo() {
        return IdVeiculo;
    }

    /**
     * @param IdVeiculo the IdVeiculo to set
     */
    public void setIdVeiculo(Integer IdVeiculo) {
        this.IdVeiculo = IdVeiculo;
    }

    /**
     * @return the NomeModelo
     */
    public String getNomeModelo() {
        return NomeModelo;
    }

    /**
     * @param NomeModelo the NomeModelo to set
     */
    public void setNomeModelo(String NomeModelo) {
        this.NomeModelo = NomeModelo;
    }

    /**
     * @return the DataEntrada
     */
    public String getDataEntrada() {
        return DataEntrada;
    }

    /**
     * @param DataEntrada the DataEntrada to set
     */
    public void setDataEntrada(String DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    /**
     * @return the DataSaida
     */
    public String getDataSaida() {
        return DataSaida;
    }

    /**
     * @param DataSaida the DataSaida to set
     */
    public void setDataSaida(String DataSaida) {
        this.DataSaida = DataSaida;
    }

    /**
     * @return the Valor
     */
    public double getValor() {
        return Valor;
    }

    /**
     * @param Valor the Valor to set
     */
    public void setValor(double Valor) {
        this.Valor = Valor;
    }


   
}
