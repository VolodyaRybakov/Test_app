package com.example.testapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class ShowAboutDialog extends DialogFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        Element versionElement = new Element();
        versionElement.setTitle(BuildConfig.VERSION_NAME);

        return new AboutPage(getContext())
                .isRTL(false)
                .setDescription(getString(R.string.about_description))
                .setImage(R.mipmap.main_logo_akva)
                .addPlayStore("com.AqulaSoft.AquariumCalculator", getString(R.string.playmarket_title))
                .addItem(versionElement)

                .addGroup(getString(R.string.about_contacts))
                .addEmail("AqulaSoft@gmail.com")

                .addGroup(getString(R.string.about_developers))
                .addGitHub("VolodyaRybakov", "VolodyaRybakov")
                .addGitHub("woipot", "Woipot")

                .create();
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            Objects.requireNonNull(dialog.getWindow()).setLayout(width, height);
        }
    }
}

