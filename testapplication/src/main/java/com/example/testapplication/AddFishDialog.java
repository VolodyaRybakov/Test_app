package com.example.testapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFishDialog {

    public static AlertDialog getDialog(Activity activity, FishListFragment listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        View view = activity.getLayoutInflater().inflate(R.layout.add_fish_dialog, null); // Получаем layout по его ID

        builder.setView(view);
        builder.setCancelable(true);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText nameView = view.findViewById(R.id.etFishName);
                String name = String.valueOf(nameView.getText());
                EditText heightView = view.findViewById(R.id.etFishHeigth);
                float height = Float.parseFloat(String.valueOf(heightView.getText()));
                EditText lengthView = view.findViewById(R.id.etFishLength);
                float length = Float.parseFloat(String.valueOf(lengthView.getText()));
                EditText kindView = view.findViewById(R.id.etFishKind);
                String kind = String.valueOf(kindView.getText());
                listener.onAddFishInDialogClick(name, length, height, kind);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return builder.create();

    }
}
