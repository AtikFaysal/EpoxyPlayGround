package com.epoxy.playground

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.epoxyView
import com.epoxy.playground.databinding.ActivityMainBinding
import com.epoxy.playground.demodata.DemoDataProduce
import com.epoxy.playground.epoxymodel.DateItemModel
import com.epoxy.playground.epoxymodel.TransactionHistoryModel
import com.epoxy.playground.epoxymodel.appTopBar
import com.epoxy.playground.epoxymodel.billTypeItem
import com.epoxy.playground.epoxymodel.cardItem
import com.epoxy.playground.epoxymodel.recentTransactionHeading
import com.epoxy.playground.epoxymodel.spacer
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

            spacer {
                id("divider_1")
                height(20)
            }

            carouselNoSnapBuilder {
                id("bill_menu_item_view")
                numViewsToShowOnScreen(4.0f)
                DemoDataProduce.billMenuItems.forEachIndexed { index, billMenuEntity ->
                    billTypeItem {
                        id("menu_item_$index")
                        menuIcon(billMenuEntity.menuIcon)
                        menuName(billMenuEntity.menuName)
                    }
                }
            }

            spacer {
                id("divider_2")
                height(20)
            }

            recentTransactionHeading {
                id("recent_transaction_heading")
            }

            spacer {
                id("divider_3")
                height(20)
            }

            DateItemModel(
                "Today"
            ).id("date_title")
                .addTo(this)

            DemoDataProduce.getTransactionHistory().forEach {
                TransactionHistoryModel(
                    trxHistory = it,
                ).id("item_${it.trxId}").addTo(this)
            }
        }
    }
}