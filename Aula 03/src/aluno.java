public class aluno extends pessoa{
    private int matricula;


    public aluno(String nome, Long cpf, String dataNascimento, int matricula) {
        super(nome, cpf, dataNascimento);
        this.matricula = matricula;
    }
}
