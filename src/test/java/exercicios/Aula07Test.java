
package exercicios;

import exercicios.base.Aula;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Aula07 extends Aula {

    private final Predicate<Estudante> mulheresAprovadas =
            estudante -> estudante.getSexo() == 'F'
                    && estudante.getCurso() != null
                    && estudante.getNota() >= 6;

    private final Comparator<Estudante> cursoCrescente =
            Comparator.comparing(estudante -> estudante.getCurso().getNome());

    private final Comparator<Estudante> notaCrescente =
            Comparator.comparingDouble(Estudante::getNota);

    private final Comparator<Estudante> cursoDecrescente =
            cursoCrescente.reversed();

    private final Comparator<Estudante> notaDecrescente =
            notaCrescente.reversed();

    private final Comparator<Estudante> cursoCrescenteNotaCrescente =
            cursoCrescente.thenComparing(notaCrescente);

    private final Comparator<Estudante> cursoDecrescenteNotaCrescente =
            cursoDecrescente.thenComparing(notaCrescente);

    private final Comparator<Estudante> cursoDecrescenteNotaDecrescente =
            cursoDecrescente.thenComparing(notaDecrescente);

    private final Comparator<Estudante> cursoCrescenteNotaDecrescente =
            cursoCrescente.thenComparing(notaDecrescente);

    public Aula07() {
        System.out.println("Mulheres aprovadas: "
                + getEstudantesMulheresAprovadas().size());

        System.out.println("Ordenadas por curso e nota: "
                + getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota().size());

        System.out.println("Curso decrescente e nota crescente: "
                + getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente().size());

        System.out.println("Lista modificável: "
                + getEstudantesMulheresAprovadasNaoOrdenadasModificavel().size());

        System.out.println("Tudo decrescente: "
                + getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente().size());

        System.out.println("Curso crescente e nota decrescente: "
                + getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente().size());
    }

    public static void main(String[] args) {
        new Aula07();
    }

    public List<Estudante> getEstudantesMulheresAprovadas() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .toList();
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoAndNota() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(cursoCrescenteNotaCrescente)
                .toList();
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoDecrescenteAndNotaCrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(cursoDecrescenteNotaCrescente)
                .toList();
    }

    public List<Estudante> getEstudantesMulheresAprovadasNaoOrdenadasModificavel() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .collect(java.util.stream.Collectors.toCollection(
                        java.util.ArrayList::new));
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasTotalmenteDecrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(cursoDecrescenteNotaDecrescente)
                .toList();
    }

    public List<Estudante> getEstudantesMulheresAprovadasOrdenadasPorCursoCrescenteAndNotaDecrescente() {
        return estudantes.stream()
                .filter(mulheresAprovadas)
                .sorted(cursoCrescenteNotaDecrescente)
                .toList();
    }
}
