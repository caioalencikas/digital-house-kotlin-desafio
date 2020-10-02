fun main() {

    val digitalHouseManager = DigitalHouseManager()


    println("")
    println("---------------------------------------------")
    println("Teste de Registro de cursos")
    println("---------------------------------------------")
    println("")

    digitalHouseManager.registrarCurso("Kotlin", 1, 5)
    digitalHouseManager.registrarCurso("JavaScript", 2, 10)
    digitalHouseManager.registrarCurso("Android", 3, 2)

    println("")
    println("---------------------------------------------")
    println("Teste de Exlusão de cursos")
    println("---------------------------------------------")
    println("")

    println("Exclusão curso 4")
    digitalHouseManager.excluirCurso(4)
    println("Exclusão curso 3 - 1ªvez")
    digitalHouseManager.excluirCurso(3)
    println("Exclusão curso 3 - 2ªvez")
    digitalHouseManager.excluirCurso(3)

    digitalHouseManager.registrarCurso("Android", 3, 2)
    digitalHouseManager.registrarCurso("Python", 4, 4)


    println("")
    println("---------------------------------------------")
    println("Teste de Registro de professores")
    println("---------------------------------------------")
    println("")

    digitalHouseManager.registrarProfessorTitular("Gustavo", "Guanabara", 1, "JavaScript")
    digitalHouseManager.registrarProfessorAdjunto("Caio", "Alencikas", 2, 10)
    digitalHouseManager.registrarProfessorTitular("Hugo", "Bowne-Anderson", 3, "Python")
    digitalHouseManager.registrarProfessorAdjunto("Lucas", "Gabriel", 4, 20)
    digitalHouseManager.registrarProfessorTitular("Felipe", "Medeiros", 5, "Android")


    println("")
    println("---------------------------------------------")
    println("Teste de Registro de alunos")
    println("---------------------------------------------")
    println("")

    digitalHouseManager.matricularAluno("Bill", "Gates", 1)
    digitalHouseManager.matricularAluno("Elon", "Musk", 2)
    digitalHouseManager.matricularAluno("Steve", "Jobs", 3)
    digitalHouseManager.matricularAluno("Mark", "Zuckerberg", 4)
    digitalHouseManager.matricularAluno("Alan", "Turing", 5)

    println("")
    println("---------------------------------------------")
    println("Teste de Matriculas de alunos em cursos")
    println("---------------------------------------------")
    println("")

    digitalHouseManager.matricularAluno(1, 3)
    digitalHouseManager.matricularAluno(2, 3)
    digitalHouseManager.matricularAluno(3, 3)

    println("")
    println("---------------------------------------------")
    println("Teste de alocar professores nos cursos")
    println("---------------------------------------------")
    println("")

    digitalHouseManager.alocarProfessores(1, 1, 2)
    digitalHouseManager.alocarProfessores(2, 3, 4)
    digitalHouseManager.alocarProfessores(3, 5, 4)



}