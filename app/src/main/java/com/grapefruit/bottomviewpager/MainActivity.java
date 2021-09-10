package com.grapefruit.bottomviewpager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import com.grapefruit.bottomviewpager.databinding.ActivityMainBinding;
import com.grapefruit.bottomviewpager.fragments.FragmentFour;
import com.grapefruit.bottomviewpager.fragments.FragmentOne;
import com.grapefruit.bottomviewpager.fragments.FragmentThree;
import com.grapefruit.bottomviewpager.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.viewpager.setOffscreenPageLimit(4);
        binding.viewpager.setAdapter(new PagerAdapter(this));
        binding.viewpager.setUserInputEnabled(false); // viewpager 스크롤 이동 방지

        binding.bottom.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_one:
                    binding.viewpager.setCurrentItem(0, true);
                    return true;
                case R.id.bottom_two:
                    binding.viewpager.setCurrentItem(1, true);
                    return true;
                case R.id.bottom_three:
                    binding.viewpager.setCurrentItem(2, true);
                    return true;
                case R.id.bottom_four:
                    binding.viewpager.setCurrentItem(3, true);
                    return true;
            }
            return false;
        });
    }

    public class PagerAdapter extends FragmentStateAdapter {

        private static final int ONE = 0;
        private static final int TWO = 1;
        private static final int THREE = 2;
        private static final int FOUR = 3;

        private String[] titles = {"1", "2", "3", "4"};

        public PagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case ONE:
                    return FragmentOne.newInstance(titles[position]);
                case TWO:
                    return FragmentTwo.newInstance(titles[position]);
                case THREE:
                    return FragmentThree.newInstance(titles[position]);
                case FOUR:
                    return FragmentFour.newInstance(titles[position]);
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }
}