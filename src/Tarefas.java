import java.util.ArrayList;

public class Tarefas {
    private int id;
    private String titulo;
    private String descricao;
    private Boolean situacao;
    private ArrayList<String> tags;


    public Tarefas(int id, String titulo, String descricao, ArrayList<String> tags){
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.situacao = Boolean.FALSE;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public ArrayList<String> getTags() { return tags; }

    public void setTags(ArrayList<String> tags) { this.tags = tags; }

}
