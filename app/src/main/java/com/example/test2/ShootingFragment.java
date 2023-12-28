package com.example.test2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.test2.databinding.FragmentShootingBinding;

public class ShootingFragment extends Fragment {

    private FragmentShootingBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentShootingBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View attackButton = view.findViewById(R.id.goto_attack_button);
        if (attackButton != null) {
            attackButton.setOnClickListener(v -> {
                NavHostFragment.findNavController(ShootingFragment.this)
                        .navigate(R.id.action_ShootingFragment_to_AttackFragment2);
            });
        } else {
            Log.e("ShootingFragment", "Attack button not found in the layout");
        }

        View chargeButton = view.findViewById(R.id.goto_charge_button);
        if (chargeButton != null) {
            chargeButton.setOnClickListener(v -> {
                NavHostFragment.findNavController(ShootingFragment.this)
                        .navigate(R.id.action_ShootingFragment_to_ChargeFragment);
            });
        } else {
            Log.e("ShootingFragment", "Charge button not found in the layout");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}