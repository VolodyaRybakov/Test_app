package com.aqulasoft.aquariumcalculator;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.HashSet;

public class AddFishDialog {

    public static AlertDialog getDialog(Activity activity, FishListFragment listener, HashSet<String> fishKinds) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        View view = activity.getLayoutInflater().inflate(R.layout.add_fish_dialog, null); // Получаем layout по его ID

        builder.setView(view);
        builder.setCancelable(true);

        AutoCompleteTextView kindView = view.findViewById(R.id.etFishKind);
        if (fishKinds.size() > 0) {
            kindView.setAdapter(new ArrayAdapter<>(view.getContext(), R.layout.simple_list_item, R.id.fish_kind_list_item, fishKinds.toArray(new String[]{})));
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
                        R.string.incorrect_data,
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

        AlertDialog dialog = builder.create();

        dialog.setOnShowListener(arg0 -> {
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
        });

        return dialog;
    }
}
