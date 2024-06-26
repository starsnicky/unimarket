class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private boolean mesmoNumero;

    public Cliente(String nome, String cpf, String telefone, boolean mesmoNumero) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.mesmoNumero = mesmoNumero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isMesmoNumero() {
        return mesmoNumero;
    }

    public void setMesmoNumero(boolean mesmoNumero) {
        this.mesmoNumero = mesmoNumero;
    }
}
