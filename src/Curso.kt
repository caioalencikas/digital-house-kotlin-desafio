class Curso(val nomeCurso: String, val codigoCurso: Int, val quantidadeMaximaAlunos: Int) {
 
    var professorTitular: ProfessorTitular? = null
    var professorAdjunto: ProfessorAdjunto? = null
    var listaAlunosMatriculados = mutableListOf<Aluno>()


    fun adicionarUmAluno(umAluno: Aluno): Boolean {
        try {
            if (listaAlunosMatriculados.size >= quantidadeMaximaAlunos) {
                println("Não foi possível matricular o aluno ${umAluno.nomeAluno} no curso ${nomeCurso}, pois não há mais vagas.")
                return false
            } else if (listaAlunosMatriculados.contains(umAluno)) {
                println("Não foi possível matricular o aluno ${umAluno.nomeAluno} no curso ${nomeCurso}, pois o aluno já está matriculado nesse curso.")
                return false
            } else {
                listaAlunosMatriculados.add(umAluno)
                println("O aluno ${umAluno.nomeAluno} foi matriculado no curso ${nomeCurso}.")
                return true
            }
        } catch(erro: Exception) {
            println("Erro: ${erro.message}")
            return false
        }
    }

    fun excluirAluno(umAluno: Aluno) {
        try {
            listaAlunosMatriculados.remove(umAluno)
            println("O aluno ${umAluno.nomeAluno} foi desmatriculado do curso ${nomeCurso}.")
        } catch(erro: Exception) {
            println("Erro: ${erro.message}")
        }
    }

}