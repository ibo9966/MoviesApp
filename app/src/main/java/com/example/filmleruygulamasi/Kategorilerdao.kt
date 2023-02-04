package com.example.filmleruygulamasi

class Kategorilerdao {

    fun tumKategoriler(vt:VeriTabaniYardimcisi):ArrayList<Kategoriler>{
        val db = vt.writableDatabase

        val kategorilerListe = ArrayList<Kategoriler>()

        val c = db.rawQuery("SELECT * FROM kategoriler",null)

        while (c.moveToNext()){
            val kategori= Kategoriler(c.getInt(c.getColumnIndexOrThrow("kategori_id"))
                ,c.getString(c.getColumnIndexOrThrow("kategori_ad")))
            kategorilerListe.add(kategori)
        }
        return kategorilerListe
    }
}