package com.example.primeiroprojetoantonio;

public class Pessoa {

    private String nome;
    private int idade;
    private float altura;
    private int sexo;

    public Pessoa(String nome, int idade, float altura, int sexo) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getSexo() {
        return sexo;
    }

    public String getSexoLiteral (){
        String retorno = "";
        if (this.sexo == 1){
            retorno = "Masculino";/*sexo será masculino*/
        } else if(this.sexo == 2){
            retorno = "Feminino"; /*sexo será feminino*/
        } else{
            retorno = "Não declarar"; /*sexo será não declarar*/
        }
        return retorno;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}
