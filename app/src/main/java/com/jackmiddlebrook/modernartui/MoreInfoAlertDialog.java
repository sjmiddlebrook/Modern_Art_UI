package com.jackmiddlebrook.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * creates custom alert dialog with button to MOMA website
 * Created by jackmiddlebrook on 2/6/15.
 */
public class MoreInfoAlertDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog_layout, null);
        Button notNowButton = (Button) view.findViewById(R.id.not_now_button);
        notNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        Button visitMomaButton = (Button) view.findViewById(R.id.visit_moma);
        visitMomaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Go to the Moma page to learn more
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.moma.org/collection/browse_results.php?criteria=O%3AAD%3AE%3A4293&page_number=3&template_id=1&sort_order=1"));
                startActivity(intent);
            }
        });

        builder.setView(view);


        return builder.create();
    }
}
