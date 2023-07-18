package cl.jpvs.mod5ej14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import cl.jpvs.mod5ej14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOk.setOnClickListener {
            when (binding.radioGroup.checkedRadioButtonId) {
                R.id.rbtnVerSaldo ->
                    binding.textMonto.setText(saldo.toString())

                R.id.rbtnIngresar -> ingresarSaldo()
                R.id.rbtnRetirar -> retirarSaldo()


            }
        }

    }

    private fun ingresarSaldo() {
        saldo += binding.textMonto.text.toString().toInt()
        crearMensaje("Su saldo ha sido incrementado")
        limpiarMonto()

    }

    private fun retirarSaldo() {
        val montoGiro = binding.textMonto.text.toString().toInt()
        if (montoGiro <= saldo) {
            saldo -= montoGiro
            limpiarMonto()
            crearMensaje("El retiro ha sido realizado correctamente")

        } else {
            crearMensaje("El retiro no ha sido realizado , saldo Insuficiente")
        }
    }

    private fun limpiarMonto() {
        binding.textMonto.text.clear()
    }


    fun crearMensaje(texto: String) {
        Toast.makeText(applicationContext, texto, Toast.LENGTH_LONG).show()
    }
}