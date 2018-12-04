package locadora.modelodados;
public class Relatorio {
    private String Nome;
    private String NomeModelo;
     private String DataEntrada;
    private String DataSaida;
    private double Valor;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getNomeModelo() {
        return NomeModelo;
    }

    public void setNomeModelo(String NomeModelo) {
        this.NomeModelo = NomeModelo;
    }

    public String getDataEntrada() {
        return DataEntrada;
    }

    public void setDataEntrada(String DataEntrada) {
        this.DataEntrada = DataEntrada;
    }

    public String getDataSaida() {
        return DataSaida;
    }

    public void setDataSaida(String DataSaida) {
        this.DataSaida = DataSaida;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

 
}
