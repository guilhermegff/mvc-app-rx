package com.project.hotmartapp.ui.establishment.view.controller

import com.project.hotmartapp.core.BaseController
import com.project.hotmartapp.core.BaseSchedulerProvider
import com.project.hotmartapp.core.ScreenNavigator
import com.project.hotmartapp.ui.establishment.component.reviews.ReviewViewItem
import com.project.hotmartapp.ui.establishment.toEstablishmentViewItem
import com.project.hotmartapp.ui.establishment.usecase.EstablishmentUseCase
import timber.log.Timber

class EstablishmentController(
    private val establishmentUseCase: EstablishmentUseCase,
    private val schedulerProvider: BaseSchedulerProvider,
    private val id: String,
    private val screenNavigator: ScreenNavigator
) : BaseController<EstablishmentViewContract>(), EstablishmentViewContract.Listener {

    val reviews by lazy { createReviewItems() }

    override fun observeLive() {
        loadEstablishment(id)
    }

    override fun registerListener(viewContract: EstablishmentViewContract) {
        super.registerListener(viewContract)
        this.viewContract.registerListener(this)
    }

    override fun onStart() {
        viewContract.registerListener(this)
    }

    override fun onStop() {
        viewContract.unregisterListener(this)
    }

    override fun initViews() {
        viewContract.bindBackButton()
        viewContract.bindReviewsButton()
    }

    private fun loadEstablishment(id: String) {
        establishmentUseCase.loadEstablishment(id)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .subscribe({
                when {
                    it.isSuccess -> {
                        it.getOrNull()?.let { establishment ->
                            establishment.toEstablishmentViewItem().let { establishmentViewItem ->
                                viewContract.showEstablishment(establishmentViewItem)
                            }
                            reviews.shuffle()
                            reviews.filterIndexed { index, _ ->
                                index < 3
                            }.let { threeReviews ->
                                viewContract.showReviewsCount(reviews.size)
                                viewContract.showReviews(threeReviews as ArrayList)
                            }
                            viewContract.showPictures()
                        }
                    }
                    it.isFailure -> {  }
                }
            }, { Timber.e(it, "loadEstablishment: %s", it.message) })
            .run { disposables.add(this) }
    }

    override fun onMoreReviewsClick() {
        viewContract.showAllReviews(reviews)
    }

    override fun onBackButtonClick() {
        screenNavigator.toLastScreen()
    }

    private fun createReviewItems() : ArrayList<ReviewViewItem> {
        return arrayListOf(
            ReviewViewItem("", 4.0, "Bom", "aaaa aaaaaa aaaaa aaaa aaaaaa aaaaaa aaaaaa aaa aaaaaaaa aaaaa aaaaa aaaa aaa ", ""),
            ReviewViewItem("", 5.0, "Muito bom", "", ""),
            ReviewViewItem("", 5.0, "Ótimo", "", ""),
            ReviewViewItem("", 4.5, "Gostei", "b bbb bbbb bbbbb bbbbbb bbbbb bbb bb bbbbb bbbb bbbb bb b", ""),
            ReviewViewItem("", 3.0, "Normal", "", ""),
            ReviewViewItem("", 3.5, "Eu volto", "cccc cc cc c cc ccc c cc cc cc c ", ""),
            ReviewViewItem("", 4.2, "Recomendo", "dd dd d dddd dd dd d d dd ddd ddddd d d dd d dd d  dd d d d d dd dd ddd ddd d d d dd d ", ""),
            ReviewViewItem("", 5.0, "Bom demais da conta", "", ""),
            ReviewViewItem("", 2.0, "", "", ""),
            ReviewViewItem("", 2.5, "", "", ""),
        )
    }
}