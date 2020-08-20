package com.example.testapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFishDialog {

    public static AlertDialog getDialog(Activity activity, FishListFragment listener, ArrayList<String> fishKinds) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        View view = activity.getLayoutInflater().inflate(R.layout.add_fish_dialog, null); // Получаем layout по его ID

        builder.setView(view);
        builder.setCancelable(true);

        AutoCompleteTextView kindView = view.findViewById(R.id.etFishKind);
        if (fishKinds.size() > 0) {
            kindView.setAdapter(new ArrayAdapter<>(view.getContext(), R.layout.simple_list_item, R.id.fish_kind_list_item, fishKinds));
        }

        builder.setPositiveButton(android.R.string.ok, (dialog, which) -> {
            EditText nameView = view.findViewById(R.id.etFishName);
            EditText heightView = view.findViewById(R.id.etFishHeigth);
            EditText lengthView = view.findViewById(R.id.etFishLength);

            String name = String.valueOf(nameView.getText());
            String strHeight = String.valueOf(heightView.getText());
            String strLength = String.valueOf(lengthView.getText());
            String kind = String.valueOf(kindView.getText());

            if (name.isEmpty() || strHeight.isEmpty() || strLength.isEmpty() || kind.isEmpty()) {
                Toast.makeText(activity.getApplicationContext(),
                        "Данные были введены неверно или неполностью. Рыбку добавлять не будем",
                        Toast.LENGTH_SHORT).show();
            }

            try {
                float height = Float.parseFloat(strHeight);
                float length = Float.parseFloat(strLength);
                listener.onAddFishInDialogClick(name, length, height, kind);
            } catch (NumberFormatException e) {
            }
            dialog.dismiss();
        });

        builder.setNegativeButton(android.R.string.cancel, (dialog, which) -> dialog.dismiss());

        return builder.create();
    }
}
