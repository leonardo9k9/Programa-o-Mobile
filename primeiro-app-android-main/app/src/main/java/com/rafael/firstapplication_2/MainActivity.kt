package com.rafael.firstapplication_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafael.firstapplication_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declaração da variável para o View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Infla o layout usando o View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuração para layout edge-to-edge (mantive seu código original)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura o listener de clique para o botão
        binding.buttonShowData.setOnClickListener {
            // Obtém o texto digitado nos campos de e-mail e senha
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Cria a mensagem para ser exibida no Toast
            val message = "Email: $email\nSenha: $password"

            // Exibe o Toast com as informações
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}
