/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;

import com.example.android.miwok.R;
import com.example.android.miwok.ui.fragments.ColorsFragment;
import com.example.android.miwok.ui.fragments.FamilyFragment;
import com.example.android.miwok.ui.fragments.NumbersFragment;
import com.example.android.miwok.ui.fragments.PhrasesFragment;

public class MainActivity extends AppCompatActivity {
    private final int NUMBERS_POSITION = 0;
    private final int FAMILY_POSITION = 1;
    private final int COLORS_POSITION = 2;
    private final int PHRASES_POSITION = 3;

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.miwok_pager);
        /** set the adapter for ViewPager */
        viewPager.setAdapter(new MiwokPagerAdapter(
                getSupportFragmentManager()));

        // Give the TabLayout the ViewPager
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case NUMBERS_POSITION:
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.category_numbers));
                        tabLayout.setTabTextColors(getResources().getColor(R.color.primary_dark_color), getResources().getColor(R.color.category_numbers));
                        break;
                    case FAMILY_POSITION:
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.category_family));
                        tabLayout.setTabTextColors(getResources().getColor(R.color.primary_dark_color), getResources().getColor(R.color.category_family));
                        break;
                    case COLORS_POSITION:
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.category_colors));
                        tabLayout.setTabTextColors(getResources().getColor(R.color.primary_dark_color), getResources().getColor(R.color.category_colors));
                        break;
                    case PHRASES_POSITION:
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.category_phrases));
                        tabLayout.setTabTextColors(getResources().getColor(R.color.primary_dark_color), getResources().getColor(R.color.category_phrases));
                        break;
                    default:
                        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.category_numbers));
                        tabLayout.setTabTextColors(getResources().getColor(R.color.primary_dark_color), getResources().getColor(R.color.category_numbers));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public class MiwokPagerAdapter extends FragmentPagerAdapter {

        public MiwokPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /** Show a Fragment based on the position of the current screen */
            switch (position) {
                case NUMBERS_POSITION:
                    return new NumbersFragment();
                case FAMILY_POSITION:
                    return new FamilyFragment();
                case COLORS_POSITION:
                    return new ColorsFragment();
                case PHRASES_POSITION:
                    return new PhrasesFragment();
                default:
                    return new NumbersFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case NUMBERS_POSITION:
                    return new SpannableString(getString(R.string.category_numbers));
                case FAMILY_POSITION:
                    return new SpannableString(getString(R.string.category_family));
                case COLORS_POSITION:
                    return new SpannableString(getString(R.string.category_colors));
                case PHRASES_POSITION:
                    return new SpannableString(getString(R.string.category_phrases));
                default:
                    return new SpannableString(getString(R.string.category_numbers));
            }
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
            return 4;
        }
    }
}
