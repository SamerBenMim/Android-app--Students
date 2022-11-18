package com.gl4.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2_android.WordListAdapter


class MainActivity : AppCompatActivity() {
    lateinit var recherche : EditText;

    lateinit var recyclerView : RecyclerView;
    lateinit  var checkBox : CheckBox;

    lateinit var spinner : Spinner;
    var matieres = listOf<String>("Cours","TP","TD")
    var etudiants = ArrayList<Etudiant>();
//    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        etudiants.add(Etudiant("Samer","BenMim",true ))
        etudiants.add(Etudiant("Amiraa","Bezzzzine", true))
        etudiants.add(Etudiant("hamdouni","aslaa", true))
    etudiants.add(Etudiant("khayaty","aziz", true))

    etudiants.add(Etudiant("dali","doudi", true))
        etudiants.add(Etudiant("zinb","kefi", true))
    etudiants.add(Etudiant("Salma","Borbor", true))



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    spinner = findViewById(R.id.spinner)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,matieres)
        recherche = findViewById(R.id.recherche)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity,  matieres[position] + " est  choisi!", Toast.LENGTH_LONG).show()
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {
            }
        }
        var adapt = WordListAdapter(etudiants);
        recyclerView.adapter = adapt;
        recyclerView.layoutManager = LinearLayoutManager(this)
        recherche.doOnTextChanged {text,start,before,count -> adapt.filter.filter(text)}

    }

//    private fun setCheckedChangedListener() {
//        this.checkboxID.setOnCheckedChangeListener { buttonView, isChecked ->
//            val msg = "You have " + if (isChecked) "checked" else "unchecked"
//            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
//        }
//    }




}

