package com.br.meusconvidados.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.br.meusconvidados.Entities.GuestEntity;
import com.br.meusconvidados.R;
import com.br.meusconvidados.business.GuestBusiness;
import com.br.meusconvidados.constats.GuestConstants;

public class GuestFormActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private GuestBusiness mGuestBusiness;
    private int mGuestId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_form);

        this.mViewHolder.mEditName = findViewById(R.id.edit_name);
        this.mViewHolder.mRadioNotConfirmed = findViewById(R.id.radio_not_confirmed);
        this.mViewHolder.mRadioPresent = findViewById(R.id.radio_present);
        this.mViewHolder.mRadioAbsent = findViewById(R.id.radio_absent);
        this.mViewHolder.mButtonSave = findViewById(R.id.button_save);
        mGuestBusiness = new GuestBusiness(this);

        this.loadDataFromActivities();


        this.setListeners();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_save) {
            this.handleSave();
        }
    }

    private void handleSave() {

        if (!this.validateSave()) {
            return;
        }

        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setName(this.mViewHolder.mEditName.getText().toString());

        if (this.mViewHolder.mRadioNotConfirmed.isChecked()) {
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.NOT_CONFIRMED);
        } else if (this.mViewHolder.mRadioPresent.isChecked()) {
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.PRESENT);
        } else {
            guestEntity.setConfirmed(GuestConstants.CONFIRMATION.ABSENT);
        }

        if (this.mGuestBusiness.insert(guestEntity)) {
            Toast.makeText(getApplicationContext(), getString(R.string.salvo_com_sucesso), Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(getApplicationContext(), getString(R.string.erro_ao_salvar), Toast.LENGTH_SHORT).show();
        }
        finish();

    }

    private Boolean validateSave() {
        if (this.mViewHolder.mEditName.getText().toString().equals("")) {
            this.mViewHolder.mEditName.setError(getString(R.string.nome_obrigatorio));
            return false;
        }
        return true;
    }

    private void loadDataFromActivities() {
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            this.mGuestId = bundle.getInt(GuestConstants.BundleConstants.GUEST_ID);

            GuestEntity guestEntity = this.mGuestBusiness.load(this.mGuestId);

            this.mViewHolder.mEditName.setText(guestEntity.getName());

            if (guestEntity.getConfirmed() == GuestConstants.CONFIRMATION.PRESENT) {
                this.mViewHolder.mRadioPresent.setChecked(true);
            } else if (guestEntity.getConfirmed() == GuestConstants.CONFIRMATION.ABSENT) {
                this.mViewHolder.mRadioAbsent.setChecked(true);
            } else if (guestEntity.getConfirmed() == GuestConstants.CONFIRMATION.NOT_CONFIRMED) {
                this.mViewHolder.mRadioNotConfirmed.setChecked(true);
            }
        }
    }

    private void setListeners() {
        this.mViewHolder.mButtonSave.setOnClickListener(this);
    }


    private static class ViewHolder {
        EditText mEditName;
        RadioButton mRadioNotConfirmed, mRadioPresent, mRadioAbsent;
        Button mButtonSave;

    }
}
