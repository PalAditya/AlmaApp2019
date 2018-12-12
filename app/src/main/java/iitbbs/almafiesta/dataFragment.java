package iitbbs.almafiesta;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

@SuppressLint("ValidFragment")
public class dataFragment extends Fragment  {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;

    List<Fragment> frags;

    char menu;

    @SuppressLint("ValidFragment")
    public dataFragment(char menuNo)
    {
        menu = menuNo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sample, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new sliderAdapter(getChildFragmentManager()));
        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        frags = new Vector<Fragment>();
        setFrags();

        return view;
    }

    void setFrags()
    {
        frags = new Vector<Fragment>();
        switch(menu)
        {
            case 'n':
                for(int i=0; i<2; i++)
                    frags.add(new contentFragment(menu,i));
                break;
            case 'p':
                break;
            case 't':
                for(int i=0; i<7; i++)
                    frags.add(new contentFragment(menu,i));
                break;
            case 'm':
                int r=0;
                String x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                if(x.length()!=0)
                    r=Integer.parseInt(x);
                frags.add(new contentFragment(menu,r));
                for(int i=0; i<5; i++)
                    if(i!=r)
                    frags.add(new contentFragment(menu,i));
                break;
            case 'c':
                r=0;
                x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                if(x.length()!=0)
                    r=Integer.parseInt(x);
                frags.add(new contentFragment(menu,r));
                for(int i=0; i<3; i++)
                    if(i!=r)
                    frags.add(new contentFragment(menu,i));
                break;
            case 'd':
                r=0;
                x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                if(x.length()!=0)
                    r=Integer.parseInt(x);
                frags.add(new contentFragment(menu,r));
                for(int i=0; i<3; i++)
                    if(i!=r)
                    frags.add(new contentFragment(menu,i));
                break;
            case 'l':
                r=0;
                x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                if(x.length()!=0)
                    r=Integer.parseInt(x);
                frags.add(new contentFragment(menu,r));
                for(int i=0; i<4; i++)
                    if(i!=r)
                    frags.add(new contentFragment(menu,i));
                break;
            case 'a':
                r=0;
                x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                if(x.length()!=0)
                    r=Integer.parseInt(x);
                frags.add(new contentFragment(menu,r));
                for(int i=0; i<2; i++)
                    if(i!=r)
                    frags.add(new contentFragment(menu,i));
                break;
            case 'q':
                r=0;
                x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                if(x.length()!=0)
                    r=Integer.parseInt(x);
                frags.add(new contentFragment(menu,r));
                for(int i=0; i<1; i++)
                    if(i!=r)
                    frags.add(new contentFragment(menu,i));
                break;
            case 'f':
                r=0;
                x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                if(x.length()!=0)
                    r=Integer.parseInt(x);
                frags.add(new contentFragment(menu,r));
                for(int i=0; i<3; i++)
                    if(i!=r)
                    frags.add(new contentFragment(menu,i));
                break;
        }
    }



    private class sliderAdapter extends FragmentPagerAdapter{

        //String tabs[]={"Chief", "G-Sec Socio Cultural", "Public Relations", "Media and Marketing", "Hospitality", "MUN", "Pronites", "Sponsorship", "Events", "Transportation","Web Development", "Design and Decor"};
        String tabs[]={"Chief", "G-Sec Socio Cultural", "Public Relations",   "Sponsorship", "Events", "Web Development", "Design, Decoration and Development"};
        public sliderAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return frags.get(position);
        }

        @Override
        public int getCount() {
            int count=0;
            switch(menu)
            {
                case 'n':
                    count=2;
                    break;
                case 'p':
                    break;
                case 't':
                    count=7;
                    break;
                case 'm':
                    count=5;
                    break;
                case 'c':
                    count=3;
                    break;
                case 'd':
                    count=3;
                    break;
                case 'l':
                    count=4;
                    break;
                case 'a':
                    count=2;
                    break;
                case 'q':
                    count=1;
                    break;
                case 'f':
                    count=3;
                    break;
            }
            return count;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch(menu)
            {
                case 'n':
                    tabs = new String[]{"News", "Gallery"};
                    break;
                case 'p':
                    break;
                case 't':
                    //tabs = new String[]{"Chief", "G-Sec Socio Cultural", "Public Relations", "Media and Marketing", "Hospitality", "MUN", "Pronites", "Sponsorship", "Events", "Transportation","Web Development", "Design and Decor"};
                    tabs=new String[]{"Chief", "G-Sec Socio Cultural", "Public Relations",   "Sponsorship", "Events", "Web Development", "Design, Decoration and Development"};
                    break;
                case 'm':
                    int r=0;
                    String x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                    if(x.length()!=0)
                        r=Integer.parseInt(x);
                    tabs = new String[]{"Euphony", "Upbeat", "Track The Track", "Duetto", "Unplugged"};
                    String temp=tabs[0];
                    tabs[0]=tabs[r];
                    tabs[r]=temp;
                    break;
                case 'c':
                    r=0;
                    x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                    if(x.length()!=0)
                        r=Integer.parseInt(x);
                    tabs = new String[]{"Rip-Out", "Topsy Turvy", "Rab Ne Bana Di Jodi"};
                    temp=tabs[0];
                    tabs[0]=tabs[r];
                    tabs[r]=temp;
                    break;
                case 'd':
                    r=0;
                    x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                    if(x.length()!=0)
                        r=Integer.parseInt(x);
                    tabs = new String[]{"Face Off", "N Circled", "Spot-Light"};
                    temp=tabs[0];
                    tabs[0]=tabs[r];
                    tabs[r]=temp;
                    break;
                case 'l':
                    //tabs = new String[]{"Litspree","IIT BBSR MUN", "Parliamentary Debate", "Seedha Samvad", "Drishtikon"};
                    r=0;
                    x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                    if(x.length()!=0)
                        r=Integer.parseInt(x);
                    tabs = new String[]{"IIT BBSR MUN", "Seedha Samvad", "Drishtikon", "Poetry Slam"};
                    temp=tabs[0];
                    tabs[0]=tabs[r];
                    tabs[r]=temp;
                    break;
                case 'a':
                    //tabs = new String[]{"Shaedz", "Rangoli"};
                    r=0;
                    x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                    if(x.length()!=0)
                        r=Integer.parseInt(x);
                    tabs = new String[]{"Shaedz", "Face painting"};
                    temp=tabs[0];
                    tabs[0]=tabs[r];
                    tabs[r]=temp;
                    break;
                case 'q':
                    r=0;
                    x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                    if(x.length()!=0)
                        r=Integer.parseInt(x);
                    tabs = new String[]{"Retro Quiz"};
                    temp=tabs[0];
                    tabs[0]=tabs[r];
                    tabs[r]=temp;
                    break;
                case 'f':
                    r=0;
                    x=HelperClass.getSharedPreferencesString(getActivity(),"Layout","");
                    if(x.length()!=0)
                        r=Integer.parseInt(x);
                    tabs = new String[]{"Pic Of The Day", "Short Film Making", "Documentary Making"};
                    temp=tabs[0];
                    tabs[0]=tabs[r];
                    tabs[r]=temp;
                    break;
            }

            return tabs[position];
        }
    }
}