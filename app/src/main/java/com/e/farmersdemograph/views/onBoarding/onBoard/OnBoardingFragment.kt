package com.e.farmersdemograph.views.onBoarding.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.e.farmersdata.data.models.OnBoardSlide

import com.e.farmersdemograph.R
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_on_boarding.*

/**
 * A simple [Fragment] subclass.
 */
class OnBoardingFragment : Fragment(), OnBoardAdapter.ListItemClickListener {
    private lateinit var adapter: OnBoardAdapter
    private lateinit var viewModel: OnBoardViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter = OnBoardAdapter(activity, this)
        configViewModel()
        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

    }

    private fun configViewModel() {
        viewModel = ViewModelProvider(this)[OnBoardViewModel::class.java]
        viewModel.setData.value = getOnBoardData()
        viewModel.getData.observe(viewLifecycleOwner, Observer {response->
            adapter.submitList(response)
            view_pager.adapter = adapter
            initIndicators()
            setCurrentIndicator(0)
        })
    }

    private fun initIndicators() {
        val indicators = arrayOfNulls<ImageView>(adapter.itemCount)
        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(5, 0, 5, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(context)
            indicators[i]?.apply {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.indicator_in_active))
                this.layoutParams = layoutParams
            }
            ll_indicator.addView(indicators[i])
        }

    }

    private fun setCurrentIndicator(position: Int) {
        val count = ll_indicator.childCount
        for (i in 0 until count) {
            val imageView = ll_indicator[i] as ImageView
            if (i == position) {
                imageView.apply {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.indicator_active
                        )
                    )
                }

            } else {
                imageView.apply {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.indicator_in_active
                        )
                    )
                }
            }
        }
    }

    private fun getOnBoardData(): MutableList<OnBoardSlide> {
        return mutableListOf(
            OnBoardSlide(
                1,
                getString(R.string.on_board_header_1),
                getString(R.string.on_board_footer_1),
                R.drawable.capture_farmer
            ), OnBoardSlide(
                2,
                getString(R.string.on_board_header_2),
                getString(R.string.on_board_footer_2),
                R.drawable.site_stats
            ), OnBoardSlide(
                3,
                getString(R.string.on_board_header_3),
                getString(R.string.on_board_footer_3),
                R.drawable.cloud_storage
            ), OnBoardSlide(
                4,
                getString(R.string.on_board_header_4),
                getString(R.string.on_board_footer_4),
                R.drawable.artificial_intelligence
            )
        )

    }

    override fun onListItemClick() {
        val navController =
            Navigation.findNavController(requireActivity(), R.id.my_nav_host_fragment)
        navController.navigate(R.id.action_onboardingFragment_to_loginFragment)    }

}
