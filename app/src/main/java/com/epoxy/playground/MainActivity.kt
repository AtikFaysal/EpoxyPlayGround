package com.epoxy.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.airbnb.epoxy.epoxyView
import com.epoxy.playground.databinding.ActivityMainBinding
import com.epoxy.playground.demodata.DemoDataProduce
import com.epoxy.playground.epoxymodel.CardItemModel
import com.epoxy.playground.epoxymodel.CardItemModel_
import com.epoxy.playground.epoxymodel.appTopBar
import com.epoxy.playground.epoxymodel.cardItem
import com.epoxy.playground.utils.carouselNoSnapBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val topBarView by epoxyView(
        viewId = R.id.topBarStub,
        initializer = {},
        modelProvider = {
            appTopBar {
                greeting(getString(R.string.format_greeting, "Atik Faysal"))
                onClickListener {
                    Toast.makeText(this@MainActivity, "Add money button clicked",Toast.LENGTH_SHORT).show()
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        topBarView.invalidate()

        binding.mainViewRcv.withModels {
            carouselNoSnapBuilder {
                id("carousel_item_view")
                numViewsToShowOnScreen(1f)
                DemoDataProduce.cardItems.forEachIndexed { index, i ->
                    cardItem {
                        id("card_item_id_$index")
                        entity(i)
                    }
                }
            }
        }
    }
}