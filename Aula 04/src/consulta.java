public class consulta {
    private String data;
    private String hora;
    private String medico;
    private double valor;

    public consulta(String data, String hora, String medico, double valor) {
        this.data = data;
        this.hora = hora;
        this.medico = medico;
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
