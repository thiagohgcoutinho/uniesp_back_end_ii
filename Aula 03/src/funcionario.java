public class funcionario extends pessoa{
    private double salario;
    private String dataAdmissao;
    private String cargo;


    public funcionario(String nome, Long cpf, String dataNascimento, double salario, String dataAdmissao, String cargo) {
        super(nome, cpf, dataNascimento);
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
        this.cargo = cargo;

    }
}
