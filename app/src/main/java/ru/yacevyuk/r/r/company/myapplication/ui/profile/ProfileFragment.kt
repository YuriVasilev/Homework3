package ru.yacevyuk.r.r.company.myapplication.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.yacevyuk.r.r.company.myapplication.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    private lateinit var viewModel: ProfileViewModel


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = NameListAdapter()
        _binding?.nameRecyclerView?.adapter = adapter

        viewModel.names.observe(viewLifecycleOwner){
            adapter.items = it
        }
        binding.imageButton3.setOnClickListener{
            Toast.makeText(requireContext(), "Скоро", Toast.LENGTH_SHORT).show()
        }



    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}