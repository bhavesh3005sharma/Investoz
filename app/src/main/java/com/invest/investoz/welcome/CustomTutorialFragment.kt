package com.invest.investoz.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment


class CustomTutorialFragment : Fragment() {
    private var layoutResId = 0
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getArguments() != null && getArguments()?.containsKey(ARG_LAYOUT_RES_ID) == true) {
            layoutResId = getArguments()?.getInt(ARG_LAYOUT_RES_ID) ?: 0
        }
    }

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater, @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(layoutResId, container, false)
    }

    companion object {
        private const val ARG_LAYOUT_RES_ID = "layoutResId"
        fun newInstance(layoutResId: Int): CustomTutorialFragment {
            val sampleSlide = CustomTutorialFragment()
            val args = Bundle()
            args.putInt(ARG_LAYOUT_RES_ID, layoutResId)
            sampleSlide.setArguments(args)
            return sampleSlide
        }
    }
}