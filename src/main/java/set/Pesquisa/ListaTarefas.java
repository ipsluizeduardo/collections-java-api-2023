package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    //atributos
    private Set<Tarefa> tarefasSet;

    public  ListaTarefas() {
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefasSet.add(tarefa);
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        if(!tarefasSet.isEmpty()) {
            for(Tarefa t : tarefasSet) {
                if(t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaParaRemover =t;
                    break;
                }
            }
            tarefasSet.remove(tarefaParaRemover);
        } else {
            System.out.println("O conjunto esta vazia");
        }

        if(tarefaParaRemover == null) {
            System.out.println("Tarefa não encontrada!");
        }
    }

    public void exibirTarefas() {
        if(!tarefasSet.isEmpty()) {
            System.out.println(tarefasSet);
        } else {
            System.out.println("Tarefa não encontrada");
        }
    }

    public int contarTarefas() {
        return tarefasSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for(Tarefa t : tarefasSet) {
            if (t.isConcluido()) {
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasNãoConcluidas = new HashSet<>();
        for(Tarefa t : tarefasSet) {
            if(!t.isConcluido()) {
                tarefasNãoConcluidas.add(t);
            }
        }

        return  tarefasNãoConcluidas;
    }

    public void marcarTarefaConcluida(String descicao) {
        for (Tarefa t : tarefasSet) {
            if(t.getDescricao().equalsIgnoreCase(descicao)) {
                t.setConcluido(true);
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        Tarefa tarefaParaMarcarComoPendente = null;
        for(Tarefa t : tarefasSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaMarcarComoPendente = t;
                break;
            }
        }

        if (tarefaParaMarcarComoPendente != null) {
            tarefaParaMarcarComoPendente.setConcluido(true);
            System.out.println("Tarefa não como pendente: " + tarefaParaMarcarComoPendente.getDescricao());
        } else {
             System.out.println("Tarefa não encontrada na lista.");
        }
    }

    public void limparListaTarefas() {
        if(tarefasSet.isEmpty()) {
            System.out.println("A lista esta vazia!");
        } else {
            tarefasSet.clear();
        }
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 1", false));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 2", false));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 3", false));
        listaTarefas.adicionarTarefa(new Tarefa("Tarefa 4", false));
        listaTarefas.exibirTarefas();

        listaTarefas.removerTarefa("Tarefa 55");
        listaTarefas.exibirTarefas();

        System.out.println("Existem " + listaTarefas.contarTarefas() + " na lista de tarefas.");

        System.out.println(listaTarefas.obterTarefasConcluidas());

        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaConcluida("Tarefa 2");
        listaTarefas.marcarTarefaConcluida("Tarefa 1");
        listaTarefas.exibirTarefas();
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
