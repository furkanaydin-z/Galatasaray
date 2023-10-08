package com.example.galatasaraylegends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var list : ArrayList<LegendsData>
    private lateinit var adapter: LegendsAdapter

    lateinit var imageid : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recyclerLayoutView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        getUserData()
        adapter = LegendsAdapter(list)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : LegendsAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity, NewActivity::class.java)

                intent.putExtra("heading", list[position].heading)
                intent.putExtra("imageid", list[position].imageid)
                intent.putExtra("news", news[position])
                startActivity(intent)
            }
        })
    }

      private  fun getUserData() {
            list = arrayListOf<LegendsData>()


            imageid = arrayOf(
                R.drawable.sneijder,
                R.drawable.cardel,
                R.drawable.eboue,
                R.drawable.taffarel,
                R.drawable.hagi,
                R.drawable.metinoktay,
                R.drawable.balta,
                R.drawable.mongragon,
                R.drawable.arda,
                R.drawable.drogba,
                R.drawable.korkmaz,
                R.drawable.melo,
                R.drawable.elmander,
                R.drawable.sabri,
                R.drawable.selcuk,
                R.drawable.terim,

            )

            heading = arrayOf(
                getString(R.string.sneijder1),
                getString(R.string.cardel),
                getString(R.string.eboue),
                getString(R.string.taffarel),
                getString(R.string.hagi),
                getString(R.string.metinoktay),
                getString(R.string.balta),
                getString(R.string.mondragon),
                getString(R.string.arda),
                getString(R.string.drogba),
                getString(R.string.korkmaz),
                getString(R.string.melo),
                getString(R.string.elmander),
                getString(R.string.sabri),
                getString(R.string.selcuk),
                getString(R.string.terim),

            )

            news = arrayOf(
                getString(R.string.sneijder),
                getString(R.string.cardel1),
                getString(R.string.eboue1),
                getString(R.string.taffarel1),
                getString(R.string.hagi1),
                getString(R.string.metinoktay1),
                getString(R.string.balta1),
                getString(R.string.mongragon1),
                getString(R.string.arda1),
                getString(R.string.drogba1),
                getString(R.string.korkmaz1),
                getString(R.string.melo1),
                getString(R.string.elmander1),
                getString(R.string.sabri1),
                getString(R.string.selcuk1),
                getString(R.string.terim1)
            )


            for (g in imageid.indices) {

                val line = LegendsData(imageid[g], heading[g])
                list.add(line)
            }

        }

}