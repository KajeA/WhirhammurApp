package com.example.test2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.test2.databinding.FragmentAttackBinding;

public class AttackFragment extends Fragment {

    private FragmentAttackBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAttackBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText strengthInput = view.findViewById(R.id.strength_input);
        EditText toughnessInput = view.findViewById(R.id.toughness_input);
        Button calculate = view.findViewById(R.id.calculate_wound_button);
        TextView woundsMessageOutput = view.findViewById(R.id.wounds_message_output);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int strength = Integer.parseInt(strengthInput.getText().toString());
                int toughness = Integer.parseInt(toughnessInput.getText().toString());
                String wounds_message = "";

            // if strength is double toughness 2+
            // if strength is greater than toughness 3+
            // if strength is equal to toughness 4+
            // if strength is less than toughness 5+
            // if strength is half toughness 6+
            if (strength >= 2 * toughness) {
                wounds_message = getString(R.string.wounds_message_double);
            } else if (strength > toughness) {
                wounds_message = getString(R.string.wounds_message_greater);
            } else if (strength == toughness) {
                wounds_message = getString(R.string.wounds_message_equal);
            } else if (strength < toughness) {
                wounds_message = getString(R.string.wounds_message_less);
            } else if (strength <= toughness / 2)
                wounds_message = getString(R.string.wounds_message_half);
            }

            woundsMessageOutput.setText(wounds_message);

        });
    };


//        view.findViewById(R.id.goto_attack_button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(AttackFragment.this)
//                        .navigate(R.id.action_ShootingFragment_to_AttackFragment);
//            }
//        });


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}