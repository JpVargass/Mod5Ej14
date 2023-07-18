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
        binding.btnOk.setOnClickListener{
            when (binding.radioGroup.checkedRadioButtonId){
             R.id.rbtnVerSaldo ->
                 binding.textMonto.setText(saldo.toString())
             R.id.rbtnIngresar -> ingresarSaldo()
             R.id.rbtnRetirar -> retirarSaldo()


            }
        }

    }

    private fun retirarSaldo() {
       val montogiro = binding.textMonto.toString().toInt()
        if (montogiro <= saldo)
        {
            saldo -= montogiro
            limpiarMonto()

            Toast.makeText(applicationContext,"El retiro ha sido realizado correctamente"+saldo, Toast.LENGTH_LONG).show()

        } else  {
            Toast.makeText(applicationContext,"El retiro ha sido realizado correctamente"+saldo, Toast.LENGTH_LONG).show()
        }
          }

    private fun limpiarMonto() {
        binding.textMonto.text.clear()
    }

    private fun ingresarSaldo() {
        saldo += binding.textMonto.text.toString().toInt()
        Toast.makeText(applicationContext,"Su saldo ha sido incrementado"+saldo, Toast.LENGTH_LONG).show()

    }
}