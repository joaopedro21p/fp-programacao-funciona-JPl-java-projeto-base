
package exercicios;

import exercicios.base.Aula;
import lombok.NonNull;

import java.util.stream.Stream;

public class Aula04 extends Aula {

    public Aula04() {
        final var curso = generator.CURSOS[3];
        final char homem = 'M';
        final char mulher = 'F';

        System.out.printf("Maior nota de todos os Estudantes: %.2f%n",
                maiorNotaTodosEstudantes(estudantes.stream()));

        System.out.printf("Maior nota dos Estudantes homens: %.2f%n",
                maiorNotaHomens(estudantes.stream()));

        System.out.printf("Maior nota das mulheres do curso de %s: %.2f%n",
                curso.getNome(),
                maiorNotaCursoAndSexo(estudantes.stream(), curso, mulher));

        System.out.printf("Média de notas dos Estudantes do curso de %s: %.2f%n",
                curso.getNome(),
                mediaNotaTodosEstudantesCurso(estudantes.stream(), curso));

        System.out.printf("Total dos homens do curso de %s: %d%n",
                curso.getNome(),
                totalEstudantesCursoAndSexo(estudantes.stream(), curso, homem));

        System.out.printf("Total das mulheres do curso de %s: %d%n",
                curso.getNome(),
                totalEstudantesCursoAndSexo(estudantes.stream(), curso, mulher));
    }

    public static void main(String[] args) {
        new Aula04();
    }

    protected double maiorNotaCursoAndSexo(
            @NonNull final Stream<Estudante> stream,
            @NonNull final Curso curso,
            final char sexo) {

        return stream
                .filter(estudante -> estudante.getCurso().equals(curso))
                .filter(estudante -> estudante.getSexo() == sexo)
                .mapToDouble(Estudante::getNota)
                .max()
                .orElse(0.0);
    }

    protected long totalEstudantesCursoAndSexo(
            @NonNull final Stream<Estudante> stream,
            @NonNull final Curso curso,
            final char sexo) {

        return stream
                .filter(estudante -> estudante.getCurso().equals(curso))
                .filter(estudante -> estudante.getSexo() == sexo)
                .count();
    }

    protected double mediaNotaTodosEstudantesCurso(
            @NonNull final Stream<Estudante> stream,
            @NonNull final Curso curso) {

        return stream
                .filter(estudante -> estudante.getCurso().equals(curso))
                .mapToDouble(Estudante::getNota)
                .average()
                .orElse(0.0);
    }

    protected double maiorNotaTodosEstudantes(
            @NonNull final Stream<Estudante> stream) {

        return stream
                .mapToDouble(Estudante::getNota)
                .max()
                .orElse(0.0);
    }

    protected double maiorNotaHomens(
            @NonNull final Stream<Estudante> stream) {

        return stream
                .filter(estudante -> estudante.getSexo() == 'M')
                .mapToDouble(Estudante::getNota)
                .max()
                .orElse(0.0);
    }
}
