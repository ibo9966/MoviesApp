package com.example.filmleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var kategoriListe:ArrayList<Kategoriler>
    private lateinit var adapter:KategoriAdapter
    private lateinit var vt : VeriTabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veritabaniKopyala()

        toolbarKategori.title = "Kategoriler"
        setSupportActionBar(toolbarKategori)

        kategoriRv.setHasFixedSize(true)
        kategoriRv.layoutManager = LinearLayoutManager(this)

        vt = VeriTabaniYardimcisi(this)

        kategoriListe = Kategorilerdao().tumKategoriler(vt)

        adapter = KategoriAdapter(this,kategoriListe)
        kategoriRv.adapter=adapter
    }
    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)

        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}