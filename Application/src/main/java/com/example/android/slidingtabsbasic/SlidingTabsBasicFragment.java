/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.example.android.slidingtabsbasic;

import com.example.android.common.logger.Log;
import com.example.android.common.view.SlidingTabLayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A basic sample which shows how to use {@link com.example.android.common.view.SlidingTabLayout}
 * to display a custom {@link ViewPager} title strip which gives continuous feedback to the user
 * when scrolling.
 */
public class SlidingTabsBasicFragment extends Fragment {

    static final String LOG_TAG = "SlidingTabsBasicFragment";

    String Page0 = new String("direct touch");
    String Page1 = new String("auditory feedback");
    String Page2 = new String("comparative evaluation");
    String Page3 = new String("the others");
    String Page4 = new String("");

    String Item00 = new String("Direct-touch vs. mouse input for tabletop displays");
    String Item01 = new String("Evaluating tactile feedback and direct vs. indirect stylus input in pointing and crossing selection tasks");
    String Item02 = new String("Occlusion-aware interfaces");
    String Item03 = new String("High precision touch screen interaction");
    String Item04 = new String("Precise selection techniques for multi-touch screens");
    String Item10 = new String("“Writing with music”:exploring the use of auditory feedback in gesture interfaces");
    String Item11 = new String("Using Audio Cues to Support Motion Gesture Interaction on Mobile Devices");
    String Item12 = new String("Using sound in multi-touch interfaces to change materiality and touch behavior");
    String Item13 = new String("");
    String Item14 = new String("");
    String Item20 = new String("A comparative evaluation of finger and pen stroke gestures");
    String Item21 = new String("");
    String Item22 = new String("");
    String Item23 = new String("");
    String Item24 = new String("");
    String Item30 = new String("Understanding the consistency of users’ pen and finger stroke gesture articulation");
    String Item31 = new String("");
    String Item32 = new String("");
    String Item33 = new String("");
    String Item34 = new String("");
    /**
     * A custom {@link ViewPager} title strip which looks much like Tabs present in Android v4.0 and
     * above, but is designed to give continuous feedback to the user when scrolling.
     */
    private SlidingTabLayout mSlidingTabLayout;

    /**
     * A {@link ViewPager} which will be used in conjunction with the {@link SlidingTabLayout} above.
     */
    private ViewPager mViewPager;

    /**
     * Inflates the {@link View} which will be displayed by this {@link Fragment}, from the app's
     * resources.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    // BEGIN_INCLUDE (fragment_onviewcreated)
    /**
     * This is called after the {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)} has finished.
     * Here we can pick out the {@link View}s we need to configure from the content view.
     *
     * We set the {@link ViewPager}'s adapter to be an instance of {@link SamplePagerAdapter}. The
     * {@link SlidingTabLayout} is then given the {@link ViewPager} so that it can populate itself.
     *
     * @param view View created in {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
        // END_INCLUDE (setup_slidingtablayout)
    }
    // END_INCLUDE (fragment_onviewcreated)

    /**
     * The {@link android.support.v4.view.PagerAdapter} used to display pages in this sample.
     * The individual pages are simple and just display two lines of text. The important section of
     * this class is the {@link #getPageTitle(int)} method which controls what is displayed in the
     * {@link SlidingTabLayout}.
     */
    class SamplePagerAdapter extends PagerAdapter {

        /**
         * @return the number of pages to display
         */



        public int getCount() {
            return 10;
        }

        /**
         * @return true if the value returned from {@link #instantiateItem(ViewGroup, int)} is the
         * same object as the {@link View} added to the {@link ViewPager}.
         */
        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        // BEGIN_INCLUDE (pageradapter_getpagetitle)
        /**
         * Return the title of the item at {@code position}. This is important as what this method
         * returns is what is displayed in the {@link SlidingTabLayout}.
         * <p>
         * Here we construct one using the position value, but for real application the title should
         * refer to the item's contents.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            if (position==0){
                return Page0 ;
            }else if(position==1){
                return Page1;
            }else if(position==2){
                return Page2;
            }else if(position==3){
                return Page3;
            }
            return null;
        }
        // END_INCLUDE (pageradapter_getpagetitle)

        /**
         * Instantiate the {@link View} which should be displayed at {@code position}. Here we
         * inflate a layout from the apps resources and then change the text view to signify the position.
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // Inflate a new layout from our resources
            View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item,
                    container, false);
            // Add the newly created View to the ViewPager
            container.addView(view);

            ListView lv;

            lv = (ListView) view.findViewById(R.id.listView1);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //ここに処理を書く
                    ListView listView = (ListView) parent;
                    String item = (String) listView.getItemAtPosition(position);
                    if(item.equals("Occlusion-aware interfaces")){
                        Page0 = "Usability Issues";
                        Page1 = "Interaction Techniques";
                        Page2 = "CONFIGURABLE MODEL";
                        Page3 = "The Others";

                        Item00 = "Improving menu placement strategies for pen input";
                        Item01 = "Evaluating tactile feedback and direct vs. indirect stylus input in pointing and crossing selection tasks";
                        Item02 = "Direct Pen Interaction with a Conventional Graphical User Interface";
                        Item03 = " Left-Handed Scrolling for Pen-Based Devices";
                        Item04 = "";
                        Item10 = " Fluid interaction techniques for the control and annotation of digital video";
                        Item11 = "CrossY: a crossing-based drawing application";
                        Item12 = "Beyond paper: supporting active reading with free form digital ink annotations";
                        Item13 = "Shift: a technique for operating pen-based interfaces using touch";
                        Item14 = "Precise selection techniques for multi-touch screens";
                        Item20 = "Hand Occlusion with Tablet-sized Direct Pen Input";
                        Item21 = "Interactive environmentaware display bubbles";
                        Item22 = "Shadow tracking on multi-touch tables";
                        Item23 = "Occlusion-aware menu design for digital tabletops";
                        Item24 = "";
                        Item30 = "More than dotting the i's --- foundations for crossing-based interfaces";
                        Item31 = "Mnemonic rendering: an image-based approach for exposing hidden changes in dynamic displays";
                        Item32 = "Interactive environmentaware display bubbles";
                        Item33 = "HybridPointing: fluid switching between absolute and relative pointing with a direct input device";
                        Item34 = " Interacting with hidden content using content-aware free-space transparency";

                    }

                }
            });

            // Retrieve a TextView from the inflated View, and update it's text
            TextView title = (TextView) view.findViewById(R.id.item_title);
            //title.setText(String.valueOf(position + 1));
            //リスト項目がクリックされた時の処理

            if(position==0){
                /*title.setText("・Direct-touch vs. mouse input for tabletop displays\n\n" +
                        "・Evaluating tactile feedback and direct vs. indirect stylus input in pointing and crossing selection tasks\n\n" +
                        "・Occlusion-aware interfaces\n\n" +
                        "・High precision touch screen interaction\n\n" +
                        "・Precise selection techniques for multi-touch screens");*/
                String[] members = { Item00, Item01, Item02, Item03, Item04 };

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                        android.R.layout.simple_expandable_list_item_1, members);

                lv.setAdapter(adapter);


            }else if(position==1){
                /*title.setText("・“Writing with music”:exploring the use of auditory feedback in gesture interfaces\n\n" +
                        "・ Using Audio Cues to Support Motion Gesture Interaction on Mobile Devices\n\n" +
                        "・ Using sound in multi-touch interfaces to change materiality and touch behavior");*/
                String[] members = { Item10, Item11, Item12, Item13, Item14 };
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                        android.R.layout.simple_expandable_list_item_1, members);

                lv.setAdapter(adapter);
            }else if(position==2){
                // title.setText("・A comparative evaluation of finger and pen stroke gestures");
                String[] members = { Item20, Item21, Item22, Item23, Item24 };
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                        android.R.layout.simple_expandable_list_item_1, members);

                lv.setAdapter(adapter);
            }else if(position==3){
                // title.setText("・Understanding the consistency of users’ pen and finger stroke gesture articulation");
                String[] members = { Item30, Item31, Item32, Item33, Item34 };
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                        android.R.layout.simple_expandable_list_item_1, members);

                lv.setAdapter(adapter);
            }else{
                title.setText("");
            }

            Log.i(LOG_TAG, "instantiateItem() [position: " + position + "]");

            // Return the View
            return view;
        }

        /**
         * Destroy the item from the {@link ViewPager}. In our case this is simply removing the
         * {@link View}.
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            Log.i(LOG_TAG, "destroyItem() [position: " + position + "]");
        }

    }
}
