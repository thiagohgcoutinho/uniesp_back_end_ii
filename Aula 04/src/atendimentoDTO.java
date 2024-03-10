public class atendimentoDTO {

    private final String nomePaciente;
    private final String telefone;
    private final String dataConsulta;
    private final String horaConsulta;
    private final String medico;

    public atendimentoDTO(String nomePaciente, String telefone, String dataConsulta, String horaConsulta, String medico) {
        this.nomePaciente = nomePaciente;
        this.telefone = telefone;
        this.dataConsulta = dataConsulta;
        this.horaConsulta = horaConsulta;
        this.medico = medico;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public String getMedico() {
        return medico;
    }
}
