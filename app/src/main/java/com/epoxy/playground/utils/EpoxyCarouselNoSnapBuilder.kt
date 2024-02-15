package com.epoxy.playground.utils

import com.airbnb.epoxy.CarouselModelBuilder
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.ModelCollector


fun ModelCollector.carouselNoSnapBuilder(builder: EpoxyCarouselNoSnapBuilder.() -> Unit): CarouselNoSnapModel_ {
    val carouselBuilder = EpoxyCarouselNoSnapBuilder().apply { builder() }
    add(carouselBuilder.carouselNoSnapModel)
    return carouselBuilder.carouselNoSnapModel
}

class EpoxyCarouselNoSnapBuilder(
    internal val carouselNoSnapModel: CarouselNoSnapModel_ = CarouselNoSnapModel_()
) : ModelCollector, CarouselNoSnapModelBuilder by carouselNoSnapModel {
    private val models = mutableListOf<EpoxyModel<*>>()

    override fun add(model: EpoxyModel<*>) {
        models.add(model)

        // Set models list every time a model is added so that it can run debug validations to
        // ensure it is still valid to mutate the carousel model.
        carouselNoSnapModel.models(models)
    }
}


inline fun EpoxyController.carousel(modelInitializer: CarouselModelBuilder.() -> Unit) {
    CarouselModel_().apply {
        modelInitializer()
    }.addTo(this)
}

/** Add models to a CarouselModel_ by transforming a list of items into EpoxyModels.
 *
 * @param items The items to transform to models
 * @param modelBuilder A function that take an item and returns a new EpoxyModel for that item.
 */
inline fun <T> CarouselModelBuilder.withModelsFrom(
    items: List<T>,
    modelBuilder: (T) -> EpoxyModel<*>
) {
    models(items.map { modelBuilder(it) })
}
