package com.rafael.firstapplication_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.firstapplication_2.databinding.ActivityMainBinding

// MainActivity é a tela principal
// Ela herda de AppCompatActivity, que é uma classe base para atividades que usam a barra de aplicativos (ActionBar).
class MainActivity : AppCompatActivity() {

    // Declaração da variável 'binding'.
    // 'lateinit' significa que vamos inicializá-la mais tarde.
    // ActivityMainBinding é uma classe gerada automaticamente pelo Android Studio
    // para nos dar acesso fácil e seguro aos componentes (views) do nosso layout XML.
    private lateinit var binding: ActivityMainBinding

    // O método onCreate é chamado quando a atividade é criada pela primeira vez.
    // É aqui que a maior parte da inicialização deve acontecer.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla ou seja, cria os objetos de view o layout XML usando a classe de binding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Define o layout inflado como o conteúdo da tela da nossa atividade.
        setContentView(binding.root)

        // Os códigos a seguir (enableEdgeToEdge e setOnApplyWindowInsetsListener)
        // foram gerados pelo template do Android Studio para lidar com a exibição
        // do app em tela cheia, ajustando os preenchimentos (padding) para não
        // sobrepor as barras de sistema (como a barra de status e de navegação).
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura um "ouvinte de cliques" para o nosso botão.
        // O código dentro das chaves { ... } será executado toda vez que o botão for pressionado.
        // Acessamos o botão diretamente através do objeto 'binding' (binding.buttonShowData).
        binding.buttonShowData.setOnClickListener {
            // Pega o texto que foi digitado no campo de e-mail.
            // .text retorna o conteúdo, e .toString() o converte para uma String.
            val email = binding.editTextEmail.text.toString()

            // Pega o texto que foi digitado no campo de senha.
            val password = binding.editTextPassword.text.toString()

            // Cria a mensagem de texto que será exibida.
            // Usamos "\n" para criar uma quebra de linha entre o e-mail e a senha.
            val message = "Email: $email\nSenha: $password"

            // Cria e exibe um "Toast".
            // Um Toast é uma pequena mensagem pop-up que aparece na tela por um curto período.
            // Parâmetros:
            // - this: O contexto (a própria atividade).
            // - message: O texto a ser exibido.
            // - Toast.LENGTH_LONG: A duração que a mensagem ficará na tela (pode ser LONG ou SHORT).
            // .show() efetivamente exibe o Toast.
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}