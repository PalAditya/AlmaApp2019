package iitbbs.almafiesta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.formmaster.FormBuilder;
import me.riddhimanadib.formmaster.model.BaseFormElement;
import me.riddhimanadib.formmaster.model.FormElementPickerSingle;
import me.riddhimanadib.formmaster.model.FormElementTextEmail;
import me.riddhimanadib.formmaster.model.FormElementTextPhone;
import me.riddhimanadib.formmaster.model.FormElementTextSingleLine;
import me.riddhimanadib.formmaster.model.FormHeader;

public class youFragment extends Fragment{

    View view;
    FormBuilder mFormBuilder=null;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.your_details, container, false);
        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerView);
        mFormBuilder = new FormBuilder(getActivity(),mRecyclerView);
        FormHeader header = FormHeader.createInstance("Personal Info");
        FormElementTextSingleLine element4 = FormElementTextSingleLine.createInstance().setTitle("Name").setTag(10000).setHint("Aditya");
        if(HelperClass.getSharedPreferencesString(getActivity(),"name","").length()!=0)
            element4.setValue(HelperClass.getSharedPreferencesString(getActivity(),"name",""));
        FormElementTextEmail element = FormElementTextEmail.createInstance().setTitle("Email").setTag(10001).setHint("Enter Email");
        if(HelperClass.getSharedPreferencesString(getActivity(),"email","").length()!=0)
            element.setValue(HelperClass.getSharedPreferencesString(getActivity(),"email",""));
        FormElementTextPhone element2 = FormElementTextPhone.createInstance().setTitle("Phone").setTag(10002).setHint("+8801712345678");
        if(HelperClass.getSharedPreferencesString(getActivity(),"phone","").length()!=0)
            element2.setValue(HelperClass.getSharedPreferencesString(getActivity(),"phone",""));
        FormElementTextSingleLine element3 = FormElementTextSingleLine.createInstance().setTitle("College").setTag(10003).setHint("KIIT");
        if(HelperClass.getSharedPreferencesString(getActivity(),"college","").length()!=0)
            element3.setValue(HelperClass.getSharedPreferencesString(getActivity(),"college",""));
        List<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        gender.add("Other");
        FormElementPickerSingle element5 = FormElementPickerSingle.createInstance().setTitle("Gender").setTag(10004).setOptions(gender).setPickerTitle("Pick any item");
        if(HelperClass.getSharedPreferencesString(getActivity(),"gender","").length()!=0)
            element5.setValue(HelperClass.getSharedPreferencesString(getActivity(),"gender",""));
        ArrayList<BaseFormElement> formItems = new ArrayList<>();
        formItems.add(header);
        formItems.add(element);
        formItems.add(element2);
        formItems.add(element3);
        formItems.add(element4);
        formItems.add(element5);
        mFormBuilder.addFormElements(formItems);
        mRecyclerView.refreshDrawableState();
        Button button=view.findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HelperClass.putSharedPreferencesString(getActivity(),"name",mFormBuilder.getFormElement(10000).getValue());
                HelperClass.putSharedPreferencesString(getActivity(),"college",mFormBuilder.getFormElement(10003).getValue());
                HelperClass.putSharedPreferencesString(getActivity(),"gender",mFormBuilder.getFormElement(10004).getValue());
                HelperClass.putSharedPreferencesString(getActivity(),"phone",mFormBuilder.getFormElement(10002).getValue());
                HelperClass.putSharedPreferencesString(getActivity(),"email",mFormBuilder.getFormElement(10001).getValue());
            }
        });
        return view;
    }
}
