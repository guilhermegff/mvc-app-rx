package com.project.hotmartapp.ui.establishment.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ErrorView
import com.project.hotmartapp.core.ErrorViewListener
import com.project.hotmartapp.core.ObservableView
import com.project.hotmartapp.ui.establishment.component.establishment.EstablishmentViewItem
import com.project.hotmartapp.ui.establishment.component.pictures.PictureViewItem
import com.project.hotmartapp.ui.establishment.component.pictures.PicturesAdapter
import com.project.hotmartapp.ui.establishment.component.pictures.PicturesAdapterListener
import com.project.hotmartapp.ui.establishment.component.reviews.ReviewViewItem
import com.project.hotmartapp.ui.establishment.component.reviews.ReviewsAdapter
import com.project.hotmartapp.ui.establishment.view.controller.EstablishmentViewContract
import com.project.hotmartservice.model.Week
import com.project.hotmartservice.model.WorkDay

class EstablishmentView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?,
                        private val picturesAdapter: PicturesAdapter,
                        private val reviewsAdapter: ReviewsAdapter)
    : ObservableView<EstablishmentViewContract.Listener>(layoutInflater, viewGroup, R.layout.fragment_establishment),
    EstablishmentViewContract, PicturesAdapterListener, ErrorViewListener {

    private val moreReviewsComponent = rootView.findViewById<ConstraintLayout>(R.id.moreReviewsComponent)
    private val moreReviewsView = rootView.findViewById<TextView>(R.id.moreReviewsView)
    private val progressBar = rootView.findViewById<ProgressBar>(R.id.progressBarView)
    private val errorView = rootView.findViewById<ErrorView>(R.id.errorView)

    override fun bindBackButton() {
        rootView.findViewById<ImageView>(R.id.arrowBackView).let { imageView ->
            imageView.setOnClickListener {
                listeners.forEach {
                    it.onBackButtonClick()
                }
            }
        }
    }

    override fun bindReviewsButton() {
        moreReviewsComponent.setOnClickListener {
            listeners.forEach {
                it.onMoreReviewsClick()
            }
        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showError() {
        errorView.errorViewListener = this
        errorView.visibility = View.VISIBLE
    }

    override fun doAction() {
        errorView.visibility = View.GONE
        listeners.forEach {
            it.onErrorViewClick()
        }
    }

    override fun showEstablishment(establishmentViewItem: EstablishmentViewItem) {
        rootView.findViewById<NestedScrollView>(R.id.nestedComponentView).visibility = View.VISIBLE
        rootView.findViewById<TextView>(R.id.establishmentTitleView).text = establishmentViewItem.title
        rootView.findViewById<RatingBar>(R.id.ratingStarsView).rating = establishmentViewItem.rating.toFloat()
        rootView.findViewById<TextView>(R.id.ratingScoreView).text = establishmentViewItem.rating.toString()
        rootView.findViewById<TextView>(R.id.aboutTextView).text = establishmentViewItem.about
    }

    override fun showContacts(establishmentViewItem: EstablishmentViewItem) {
        rootView.findViewById<TextView>(R.id.phoneNumberView).text = establishmentViewItem.phone
        rootView.findViewById<TextView>(R.id.addressView).text = establishmentViewItem.adress
    }

    override fun showSchedule(establishmentViewItem: EstablishmentViewItem) {
        rootView.findViewById<TextView>(R.id.weekdayHoursView).text = formatSchedule(establishmentViewItem.schedule)
    }

    override fun showPictures() {
        rootView.findViewById<RecyclerView>(R.id.picturesCollectionView).let { recycler ->
            recycler.adapter = picturesAdapter
            recycler.visibility = View.VISIBLE
        }
        picturesAdapter.registerListener(this)
        picturesAdapter.add(createItems())
    }

    override fun showReviewsCount(total: Int) {
        moreReviewsView.text = rootView.context.resources.getString(R.string.more_reviews, total)
    }

    override fun showReviews(reviews: ArrayList<ReviewViewItem>) {
        rootView.findViewById<RecyclerView>(R.id.reviewsCollectionView).let { recycler ->
            recycler.adapter = reviewsAdapter
            recycler.visibility = View.VISIBLE
        }
        reviewsAdapter.add(reviews)
    }

    override fun showAllReviews(reviews: ArrayList<ReviewViewItem>) {
        reviewsAdapter.clear()
        reviewsAdapter.add(reviews)
        moreReviewsComponent.visibility = View.GONE
    }

    override fun onPictureClick(pictureViewItem: PictureViewItem) {
        //TODO("Not yet implemented")
    }

    private fun formatSchedule(schedule: Week) : String {
        val list = ArrayList<WorkDay>(7)
        schedule.sunday?.let { list.add(it.copy(id = 0, text = rootView.resources.getString(R.string.monday))) }
        schedule.monday?.let { list.add(it.copy(id = 1, text = rootView.resources.getString(R.string.tuesday))) }
        schedule.tuesday?.let { list.add(it.copy(id = 2, text = rootView.resources.getString(R.string.wednesday))) }
        schedule.wednesday?.let { list.add(it.copy(id = 3, text = rootView.resources.getString(R.string.thursday))) }
        schedule.thursday?.let { list.add(it.copy(id = 4, text = rootView.resources.getString(R.string.friday))) }
        schedule.friday?.let { list.add(it.copy(id = 5, text = rootView.resources.getString(R.string.saturday))) }
        schedule.saturday?.let { list.add(it.copy(id = 6, text = rootView.resources.getString(R.string.sunday))) }

        return  getScheduleString(list)
    }

    private fun getScheduleString(list: ArrayList<WorkDay>) : String {
        val string = StringBuilder()
        list.distinctBy { it.open; it.close }.forEach { workDay ->
            val daysWithSameHours = list.filter { it.open == workDay.open && it.close == workDay.close } as ArrayList
            string.append("${writeScheduleString(daysWithSameHours)}\n")
        }
        return string.toString()
    }

    private fun writeScheduleString(list: ArrayList<WorkDay>) : String {
        val string = StringBuilder()
        when(list.size >= 2) {
            true -> {
                when(list.size == 2) {
                    true -> {
                        string.append("${list[0].text} ${rootView.resources.getString(R.string.and)} ${list[list.size - 1].text}: ${list[0].open} ${rootView.resources.getString(R.string.to_hour)} ${list[0].close}")
                    }
                    false -> {
                        string.append("${list[0].text} ${rootView.resources.getString(R.string.to_day)} ${list[list.size - 1].text}: ${list[0].open} ${rootView.resources.getString(R.string.to_hour)} ${list[0].close}")
                    }
                }
            }
            false -> {
                if(list.size == 1) {
                    string.append("${list[0].text}: ${list[0].open} ${rootView.resources.getString(R.string.to_hour)} ${list[0].close}")
                }
            }
        }
        return string.toString()
    }

    private fun createItems() : ArrayList<PictureViewItem> {
        return arrayListOf(
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem(""),
            PictureViewItem("")
        )
    }
}