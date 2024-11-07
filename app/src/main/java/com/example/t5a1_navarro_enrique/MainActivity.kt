package com.example.t5a1_navarro_enrique

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5a1_navarro_enrique.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnClickListener {

    private lateinit var comidaAdapter: ComidaAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comidaAdapter = ComidaAdapter(getComidas(),this)
        linearLayoutManager = LinearLayoutManager(this)
        itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        binding.reciclerView.apply {
            layoutManager = linearLayoutManager
            adapter = comidaAdapter
            addItemDecoration(itemDecoration)
        }


    }

    private fun getComidas():MutableList<Comida>{
        val comidas = mutableListOf<Comida>()

        val pizza  = Comida ("Pizza", "https://w1.pngwing.com/pngs/865/530/png-transparent-hawaiian-pizza-drawing-pepperoni-food-cartoon-pizza-pizza-yellow-headgear-thumbnail.png", "https://es.wikipedia.org/wiki/Pizza")
        comidas.add(pizza)
        val paella  = Comida ( "Paella", "https://m.media-amazon.com/images/S/aplus-media-library-service-media/c25f6d5e-9125-4ea2-9e17-4656429ae639.__CR0,0,970,600_PT0_SX970_V1___.jpg", "https://es.wikipedia.org/wiki/Paella")
        comidas.add(paella)
        val kebap  = Comida ( "Kebap", "https://thumbs.dreamstime.com/z/personaje-de-dibujos-animados-divertido-del-kebab-ejemplo-155264785.jpg", "https://es.wikipedia.org/wiki/Kebab")
        comidas.add(kebap)
        val hamburguesa  = Comida ( "Hamburguesa", "https://e7.pngegg.com/pngimages/735/271/png-clipart-hamburger-cheeseburger-cartoon-burguer-miscellaneous-food.png", "https://es.wikipedia.org/wiki/Hamburguesa")
        comidas.add(hamburguesa)
        val pasta  = Comida ( "Pasta", "https://media.istockphoto.com/id/1275962427/es/vector/espaguetis-ilustraci%C3%B3n-de-color-vectorial-aislada-sobre-fondo-blanco.jpg?s=612x612&w=0&k=20&c=FhUczq-WbzCjKVUy_TGIJlJyxVv2QnmHPfcw1bbnrdo=", "https://es.wikipedia.org/wiki/Pasta")
        comidas.add(pasta)

        return comidas
    }

    override fun onClick(comida: Comida) {
        val intent = Intent(this, webView::class.java)
        intent.putExtra("wiki", comida.wiki)
        startActivity(intent)

    }
}