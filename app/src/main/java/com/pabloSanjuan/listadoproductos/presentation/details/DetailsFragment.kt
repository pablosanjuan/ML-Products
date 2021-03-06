package com.pabloSanjuan.listadoproductos.presentation.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabloSanjuan.listadoproductos.MainApplication
import com.pabloSanjuan.listadoproductos.data.models.Result
import com.pabloSanjuan.listadoproductos.databinding.FragmentDetailsBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment

class DetailsFragment : BaseFragment<DetailsViewModel, FragmentDetailsBinding>() {

    /**
     * Pablo Sanjuan
     *
     * Contiene la logica recibir a traves de NAVIGATION ARGS el objeto del resultado
     *
     * - implemente viewBinding directo en el xml y evitar asginar todos los parametros desde
     * la vista
     */

    private lateinit var viewModel: DetailsViewModel
    lateinit var result: Result

    companion object {
        const val RESULT_DATA = "result"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApplication.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = initViewModel()
        result = arguments?.getParcelable(RESULT_DATA) ?: Result()
        binding.item = DetailsViewModel.ProductModel(result)
        binding.imageLottieArrow.run {
            setAnimation("lottie_arrow.json")
            loop(true)
            speed = 1f
            playAnimation()
        }
    }
}