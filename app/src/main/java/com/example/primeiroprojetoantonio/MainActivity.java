package com.example.primeiroprojetoantonio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.primeiroprojetoantonio.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;

public class MainActivity extends AppCompatActivity {

    /*
    TextView tvNome, tvIdade, tvAltura;
    EditText etNome, etIdade, etAltura;
    Button bSalvar, bCancelar;
    */
    ActivityMainBinding binding;
    ArrayList<Pessoa> listaPessoa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    //verificando as infromações
                    if (!binding.etNome.getText().toString().equals("")){
                        if (!binding.etIdade.getText().toString().equals("")){
                            if (!binding.etAltura.getText().toString().equals("")){
                                if (binding.rbMasculino.isChecked() || binding.rbFeminino.isChecked() || binding.rbNODeclarar.isChecked()){
                                    //obtendo as informações
                                    String nome = binding.etNome.getText().toString();
                                    int idade = Integer.parseInt(binding.etIdade.getText().toString());
                                    float altura = Float.parseFloat(binding.etIdade.getText().toString());
                                    int sexo = 0;

                                    if (binding.rbMasculino.isChecked()){
                                        sexo = 1;//sexo será masculino
                                    } else if(binding.rbFeminino.isChecked()){
                                        sexo = 2; //sexo será feminino
                                    } else{
                                        sexo = 3; //sexo será não declarar
                                    }

                                    //criando o objeto da classe
                                    Pessoa minhaPessoa = new Pessoa(nome, idade, altura, sexo);

                                    //adicionando na lista
                                    listaPessoa.add(minhaPessoa);

                                    Toast.makeText(MainActivity.this, "Dados cadastrados com sucesso.", Toast.LENGTH_SHORT).show();
                                    limpaCampos();
                                } else{
                                    Toast.makeText(MainActivity.this, "Informe o sexo!", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                binding.etAltura.setError("informe a altura!");
                                binding.etAltura.requestFocus();
                            }
                        }else{
                            binding.etIdade.setError("Informe a idade!");
                            binding.etIdade.requestFocus();
                        }
                    }else{
                        binding.etNome.setError("Informe o nome!");
                        binding.etNome.requestFocus();
                    }

                } catch(Exception e){
                    e.printStackTrace();

                    for (int i = 0; i <= e.getStackTrace().length; i++) {
                        /*mostrando detalhadamento o erro*/
                        System.out.println("Classe de erro: "+e.getStackTrace()[i].getClassName());
                        System.out.println("Método de erro: "+e.getStackTrace()[i].getMethodName());
                        System.out.println("Linha de erro: "+e.getStackTrace()[i].getLineNumber());
                        System.out.println("Exceção: "+e.getClass().getName());
                    }
                }
            }
        });

        binding.bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpaCampos();
            }
        });

        binding.bVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Declaração das variaveis auxiliares
                int quantidadeMasculino=0, quantidadeFeminino=0, quantidadeNaoDeclarar=0;
                float menorValor = Float.MAX_VALUE;
                Pessoa pessoaMaisBaixa = null;

                //navegando na lista de pessoas
                for (int i = 0; i < listaPessoa.size(); i++){
                    //obtendo cada um dos objetos
                    Pessoa minhaPessoa = listaPessoa.get(i);

                    //verificando qual é o sexo da pessoa
                    if (minhaPessoa.getSexo() == 1){
                        quantidadeMasculino++;
                    }else if (minhaPessoa.getSexo() == 2){
                        quantidadeFeminino++;
                    }else {
                        quantidadeNaoDeclarar++;
                    }

                    //verificando se a pessoa é a mais baica
                    if (minhaPessoa.getAltura() < menorValor){
                        menorValor = minhaPessoa.getAltura();
                        pessoaMaisBaixa = minhaPessoa;
                    }
                }
                Toast.makeText(MainActivity.this, "Quantidade masculino: "+quantidadeMasculino+"\nQuantidade feminino: "+quantidadeFeminino+"\nquantidade Não Declarar: "+quantidadeNaoDeclarar, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Nome da pessoa de menor altura: "+pessoaMaisBaixa.getNome()+"\nIdade da pessoa: "+pessoaMaisBaixa.getIdade()+"\nSexo da pessoa: "+pessoaMaisBaixa.getSexoLiteral(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.bSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finish();
            }
        });

        /*
        tvNome = findViewById(R.id.tvNome);
        tvIdade = findViewById(R.id.tvIdade);
        tvAltura = findViewById(R.id.tvAltura);

        etNome = findViewById(R.id.etNome);
        etIdade = findViewById(R.id.etIdade);
        etAltura = findViewById(R.id.etAltura);

        bSalvar = findViewById(R.id.bSalvar);
        bCancelar = findViewById(R.id.bCancelar);


        bSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = etNome.getText().toString();
                int idade = Integer.parseInt(etIdade.getText().toString());
                float altura = Float.parseFloat(etAltura.getText().toString());

                Toast.makeText(MainActivity.this, "Nome: "+nome+", Idade: "+idade+", Altura: "+altura, Toast.LENGTH_SHORT).show();

            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampos();
            }
        });
        */
    }

    public void limpaCampos(){
        binding.etNome.setText("");
        binding.etIdade.setText("");
        binding.etAltura.setText("");
        binding.rgSexo.clearCheck();
        /*
        etNome.setText("");
        etIdade.setText("");
        etAltura.setText("");
        */
    }

}