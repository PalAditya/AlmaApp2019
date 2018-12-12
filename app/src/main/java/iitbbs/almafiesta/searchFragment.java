package iitbbs.almafiesta;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class searchFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search, container, false);
        final AutoCompleteTextView autoCompleteTextView=view.findViewById(R.id.autoCompleteTextView);
        String arr[]={"Shaedz","Mun","Face painting","Seedha Samvad","Drishtikon","Poetry Slam","Euphony"
        ,"Upbeat","Track the Track"," Duetto","Unplugged","Rip Out","Topsy Turvy","Rab Ne Bana Di Jodi",
        "Face off","N circled","Spot-light","Pic of the Day","Short Film Making","Documentary Making","Retro Quiz"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_dropdown_item_1line,arr);
        autoCompleteTextView.setAdapter(adapter);
        Button button=view.findViewById(R.id.buttonSearch);
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                String str=autoCompleteTextView.getText()+"";
                char menu='z';
                str=str.toLowerCase();
                if(str.equals("mun"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","0");
                    menu='l';
                }
                else if(str.equals("seedha samvad"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","1");
                    menu='l';
                }
                else if(str.equals("drishtikon"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","2");
                    menu='l';
                }
                else if(str.equals("poetry slam"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","3");
                    menu='l';
                }
                else if(str.equals("euphony"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","0");
                    menu='m';
                }
                else if(str.equals("upbeat"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","1");
                    menu='m';
                }
                else if(str.equals("track the track"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","2");
                    menu='m';
                }
                else if(str.equals("duetto"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","3");
                    menu='m';
                }
                else if(str.equals("unplugged"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","4");
                    menu='m';
                }
                else if(str.equals("rip out"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","0");
                    menu='c';
                }
                else if (str.equals("topsy turvy"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","1");
                    menu='c';
                }
                else if(str.equals("rab ne bana di jodi"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","2");
                    menu='c';
                }
                else if(str.equals("face off"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","0");
                    menu='d';
                }
                else if(str.equals("n circled"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","1");
                    menu='d';
                }
                else if(str.equals("spot-light"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","2");
                    menu='d';
                }
                else if(str.equals("shaedz"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","0");
                    menu='a';
                }
                else if(str.equals("face painting"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","1");
                    menu='a';
                }
                else if(str.equals("pic of the day"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","0");
                    menu='f';
                }
                else if(str.equals("short film making"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","1");
                    menu='f';
                }
                else if(str.equals("documentary making"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","2");
                    menu='f';
                }
                else if(str.equals("retro quiz"))
                {
                    HelperClass.putSharedPreferencesString(getActivity(),"Layout","0");
                    menu='q';
                }
                else
                {
                    Toast.makeText(getActivity(),"Please try searching manually or different keywords",Toast.LENGTH_SHORT).show();
                }
                if(menu!='z') {
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.setCustomAnimations(R.xml.enter_from_left, R.xml.exit_to_right, R.xml.enter_from_right, R.xml.exit_to_left);
                    ft.replace(R.id.content_frame, new dataFragment(menu));
                    ft.addToBackStack(null).commit();
                }
            }
        });
        return view;
    }
}
