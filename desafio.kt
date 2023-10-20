import kotlin.time.Duration.Companion.minutes

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {
    private val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) { 
        inscritos.add(usuario) }

    fun imprimirMatriculado() {
        println("ALunos Matriculados")
        inscritos.sortBy { it.nome }
        inscritos.forEachIndexed { index, inscrito ->
            println("${index + 1} - ${inscrito.nome}")
        }
    }

    fun imprimirFormacao() {
        println("Formação")
        println("Nome: $nome \n")
    }
    fun imprimirConteudosFormacao() {
        println("Conteúdo do Programa")
        conteudos.forEach { conteudo ->
            println("Nome: ${conteudo.nome} \nDuração: ${conteudo.duracao.minutes} \nNível: ${conteudo.nivel} \n")
        }
    }
}

fun main() {
    val conteudos = listOf(
        ConteudoEducacional(nome = "Introdução ao Kotlin", duracao = 20, nivel = Nivel.BASICO),
        ConteudoEducacional(nome = "Resolvendo desafios com Kotlin", duracao = 120, nivel = Nivel.INTERMEDIARIO),
        ConteudoEducacional(nome = "Primeiros Passos no Android Studio", duracao = 120, nivel = Nivel.DIFICIL)
    )
    val formacao = Formacao("Mobile Android com Kotlin", conteudos)
    val usuario = Usuario("João Humberto")
    val usuario2 = Usuario("Marina Barreto")

    formacao.matricular(usuario)
    formacao.matricular(usuario2)
    formacao.imprimirFormacao()
    formacao.imprimirConteudosFormacao()
    formacao.imprimirMatriculado()
}
