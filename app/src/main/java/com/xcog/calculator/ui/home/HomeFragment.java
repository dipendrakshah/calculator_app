package com.xcog.calculator.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.xcog.calculator.GeneralCalculatorActivity;
import com.xcog.calculator.R;
import com.xcog.calculator.ScientificCalculatorActivity;
import com.xcog.calculator.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find the buttons in the layout using their IDs
        Button simpleCalculatorButton = view.findViewById(R.id.btnGeneralCalc);
        Button scientificCalculatorButton = view.findViewById(R.id.btnScientificCalc);

        // Set an onClickListener to handle click events for the simple calculator button
        simpleCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(getActivity(), GeneralCalculatorActivity.class);
                 startActivity(intent);
            }
        });

        // Set an onClickListener to handle click events for the scientific calculator button
        scientificCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScientificCalculatorActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    public Button getBtnGeneralCalc() {
        return btnGeneralCalc;
    }

    public Button getBtnScientificCalc() {
        return btnScientificCalc;
    }*/

}