package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        tvResult.text = result.toString()

        val classificacao = if (result<18.5f) {
        "ABAIXO DO PESO"
        }else if(result in 18.5f..24.9f){
        "NORMAL"
        }else if(result in 24.9f..29.9f){
        "SOBREPESO I"
        }else if(result in 29.9f..39.9f){
        "OBESIDADE II"
        }else {
        "OBESIDADE GRAVE III"
        }
    tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}