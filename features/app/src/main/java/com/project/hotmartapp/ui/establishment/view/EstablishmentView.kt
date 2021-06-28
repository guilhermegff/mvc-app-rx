package com.project.hotmartapp.ui.establishment.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.hotmartapp.R
import com.project.hotmartapp.core.ObservableView
import com.project.hotmartapp.ui.establishment.component.PictureViewItem
import com.project.hotmartapp.ui.establishment.component.PicturesAdapter
import com.project.hotmartapp.ui.establishment.component.PicturesAdapterListener
import com.project.hotmartapp.ui.establishment.view.controller.EstablishmentViewContract
import com.project.hotmartservice.model.Establishment

class EstablishmentView(layoutInflater: LayoutInflater, viewGroup: ViewGroup?, val picturesAdapter: PicturesAdapter) :
    ObservableView<EstablishmentViewContract.Listener>(layoutInflater, viewGroup, R.layout.fragment_establishment),
    EstablishmentViewContract, PicturesAdapterListener {

    override fun showEstablishment(establishment: Establishment) {
        val picturesCollection = rootView.findViewById<RecyclerView>(R.id.picturesCollectionView)
        picturesAdapter.add(createItems())

        picturesCollection.adapter = picturesAdapter

        picturesCollection.visibility = View.VISIBLE
    }

    override fun onPictureClick(pictureViewItem: PictureViewItem) {
        //TODO("Not yet implemented")
    }

    private fun createItems() : ArrayList<PictureViewItem> {
        return arrayListOf(PictureViewItem(""),
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