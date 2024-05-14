package com.example.doctorapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.doctorapplication.R;
import com.example.doctorapplication.activity.PatientDetail;
import com.example.doctorapplication.model.Patient;

import java.util.ArrayList;

public class DoctorManagePatientAdapter extends ArrayAdapter<Patient> {

    private static class ViewHolder {
        TextView PatientName;
        ImageView PatientPicture;
        ImageButton PatientDetail;
    }

    public DoctorManagePatientAdapter(Context context, ArrayList<Patient> patients) {
        super(context, R.layout.item_doctor_manage_patient, patients);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Patient patient = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_doctor_manage_patient, parent, false);
            viewHolder.PatientName = convertView.findViewById(R.id.PatientName);
            viewHolder.PatientPicture = convertView.findViewById(R.id.PatientPicture);
            viewHolder.PatientDetail = convertView.findViewById(R.id.PatientDetail);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.PatientName.setText(patient.getPatientName());
        // Set patient picture if available

        viewHolder.PatientDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start PatientDetail activity
                Context context = getContext();
                if (context != null) {
                    Intent intent = new Intent(context, PatientDetail.class);
                    // Pass any necessary data to the intent
                    context.startActivity(intent);
                }
            }
        });

        return convertView;
    }
}
