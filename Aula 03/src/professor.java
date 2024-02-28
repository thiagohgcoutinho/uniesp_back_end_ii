public class professor extends pessoa{
    private double salario;
    private String disciplina;


    public professor(String nome, Long cpf, String dataNascimento, double salario, String disciplina) {
        super(nome, cpf, dataNascimento);
        this.salario = salario;
        this.disciplina = disciplina;
    }
}
