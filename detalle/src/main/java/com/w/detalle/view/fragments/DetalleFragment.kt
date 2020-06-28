package com.w.detalle.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.w.detalle.R
import com.w.detalle.model.Attribute
import com.w.detalle.model.Item
import com.w.detalle.model.Pictures
import com.w.detalle.presenter.DetallePresenterImpl
import com.w.detalle.util.FormatUtil.getNumberFormat
import com.w.detalle.view.DetalleActivity
import com.w.detalle.view.DetalleView
import com.w.detalle.view.adapters.DetalleImagePagerAdapter
import com.w.detalle.view.adapters.DetalleListAdapter
import kotlinx.android.synthetic.main.detalle_fragment.*


class DetalleFragment : Fragment() , DetalleView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.detalle_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callItemAPI(DetalleActivity.productId)
    }

    companion object DetalleFragmentCompanion {
        @JvmStatic
        fun newInstance() = DetalleFragment().apply {}
    }

    override fun showItem(item : Item) {
        setUpViewPager(item.body.pictures)
        setDataView(item)
        setRecycler(item.body.attributes)
        progress_bar.visibility = View.GONE
    }

    override fun callItemAPI(itemId: String) {
        progress_bar.visibility = View.VISIBLE
        val presenterImpl = DetallePresenterImpl(this)
        presenterImpl.callItemAPI(itemId)
    }

    private fun setUpViewPager(pictures : List<Pictures>) {
        val adapter = DetalleImagePagerAdapter(activity!!.supportFragmentManager)
        for (picture in pictures) run {
            adapter.addFragment(DetalleImageFragment.newInstance(picture.secureUrl))
        }
        view_pager!!.adapter = adapter
    }

    private fun setRecycler(attributes: List<Attribute>){
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = DetalleListAdapter(attributes)
        }
    }

    private fun setDataView(item: Item){
        title.text = item.body.title
        price.text = getNumberFormat(item.body.price)
    }



}
