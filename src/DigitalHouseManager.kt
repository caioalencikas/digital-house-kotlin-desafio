class DigitalHouseManager() {

    val listaAlunos = mutableListOf<Aluno>()
    val listaProfessores = mutableListOf<Professor>()
    val listaCursos = mutableListOf<Curso>()
    val listaMatriculas = mutableListOf<Matricula>()

    fun registrarCurso(nome: String, codigoCurso: Int, quantidadeMaximaDeAlunos: Int) {
        try {
            val curso = Curso(nome, codigoCurso, quantidadeMaximaDeAlunos)

            listaCursos.add(curso)

            println("Curso de ${nome} registrado com sucesso.")
        } catch(erro: Exception) {
            println("Erro: ${erro.message}")
        }
    }

    fun excluirCurso(codigoCurso: Int): Boolean {

        try {

            for (c in listaCursos) {
                if (c.codigoCurso == codigoCurso) {
                    val curso = c
                    listaCursos.remove(curso)
                    println("Curso de ${curso.nomeCurso} removido com sucesso.")
                    return true
                }
            }

        } catch(erro: Exception) {
            println("Erro: ${erro.message}")
        }

        println("Curso não existe")
        return false
    }

    fun registrarProfessorAdjunto(nome: String, sobrenome: String, codigoProfessor: Int, quantidadeDeHoras: Int) {
        try {
            val professorAdjunto = ProfessorAdjunto(nome, sobrenome, 0, codigoProfessor, quantidadeDeHoras)
            listaProfessores.add(professorAdjunto)
            println("Professor ${professorAdjunto.nomeProfessor} cadastrado com sucesso.")
        } catch(erro: Exception) {
            println("Erro: ${erro.message}")
        }
    }

    fun registrarProfessorTitular(nome: String, sobrenome: String, codigoProfessor: Int, especialidade: String) {
        try {
            val professorTitular = ProfessorTitular(nome, sobrenome, 0, codigoProfessor, especialidade)
            listaProfessores.add(professorTitular)
            println("Professor ${professorTitular.nomeProfessor} cadastrado com sucesso.")
        } catch(erro: Exception) {
            println("Erro: ${erro.message}")
        }
    }

    fun matricularAluno(nome: String, sobrenome: String, codigoAluno: Int) {
        try {
            val aluno = Aluno(nome, sobrenome, codigoAluno)
            listaAlunos.add(aluno)
            println("O aluno ${aluno.nomeAluno} foi cadastrado com sucesso.")
        } catch(erro: Exception) {
            println("Erro: ${erro.message}")
        }
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int): Boolean {

        var curso: Curso? = null
        var aluno: Aluno? = null

        try {

            for (c in listaCursos) {
                if (c.codigoCurso == codigoCurso) {
                    curso = c
                    break
                }
            }

            if (curso == null) {
                println("Curso não encontrado.")
                return false
            }

            for (a in listaAlunos) {
                if (a.codigoAluno == codigoAluno) {
                    aluno = a
                    break
                }
            }

            if (aluno == null) {
                println("Aluno não encontrado.")
                return false
            }


            if (curso.adicionarUmAluno(aluno)) {
                val matricula = Matricula(aluno, curso)
                listaMatriculas.add(matricula)
                println("Matrícula executada para o aluno ${aluno.nomeAluno} no curso ${curso.nomeCurso}.")
                return true
            }

        } catch(erro: Exception) {
            println("Erro: ${erro.message}")
        }
        return false
    }

    fun alocarProfessores(codigoCurso: Int, codigoProfessorTitular: Int, codigoProfessorAdjunto: Int) {
        var professorTitular: ProfessorTitular? = null
        var professorAdjunto: ProfessorAdjunto? = null
        var curso: Curso? = null

        try {
            listaCursos.forEach {
                if (it.codigoCurso == codigoCurso) {
                    curso = it
                }
            }

            if (curso == null) {
                println("Curso não encontrado.")
            }

            listaProfessores.forEach {
                if (it.codigoProfessor == codigoProfessorTitular) {
                    professorTitular = it as ProfessorTitular
                    curso?.professorTitular = professorTitular as ProfessorTitular
                    println("Professor titular ${professorTitular!!.nomeProfessor} alocado com sucesso no curso ${curso!!.nomeCurso}")
                } else if (it.codigoProfessor == codigoProfessorAdjunto) {
                    professorAdjunto = it as ProfessorAdjunto
                    curso?.professorAdjunto = professorAdjunto as ProfessorAdjunto
                    println("Professor adjunto ${professorAdjunto!!.nomeProfessor} alocado com sucesso no curso ${curso!!.nomeCurso}")
                }
            }

            if (professorTitular == null) {
                println("Código do professor titular: ${codigoProfessorTitular} não encontrado.")
            } else if (professorAdjunto == null) {
                println("Código do professor adjunto: ${codigoProfessorAdjunto} não encontrado.")
            }

        } catch(erro: Exception) {
            println("Erro: ${erro.message}")
        }
    }

}