package com.example.testapplication;

import android.app.Activity;
import android.view.View;

import mehdi.sakout.aboutpage.Element;

import androidx.appcompat.app.AlertDialog;

import mehdi.sakout.aboutpage.AboutPage;

public class ShowAboutDialog {
    public static AlertDialog getDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        View aboutPage = new AboutPage(activity)
                .isRTL(false)
                .enableDarkMode(false)
                .setImage(R.drawable.main_logo_akva)
                .setDescription("This description better than default")
                .addItem(new Element().setTitle(activity.getString(R.string.version_code) + " " + MainActivity.getVersionCode()))
                .addItem(new Element().setTitle(activity.getString(R.string.version_name) + " " + MainActivity.getVersionName()))
                .addGroup(activity.getString(R.string.connect_with_us))
                .addEmail("elmehdi.sakout@gmail.com")
                .addWebsite("https://mehdisakout.com/")
                .addFacebook("the.medy")
                .addTwitter("medyo80")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addInstagram("medyo80")
                .addGitHub("medyo")
                .create();

        builder.setView(aboutPage);
        builder.setCancelable(true);

        builder.setPositiveButton(android.R.string.ok, (dialog, which) -> dialog.dismiss());

        return builder.create();
    }
}
