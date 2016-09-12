package id.duza.callbackinterface;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by duza on 12/09/16.
 */
public class DialogEditor extends DialogFragment {

    setOnPositiveButtonClicked mCallback;

    public interface setOnPositiveButtonClicked {
         void onPositiveButtonClicked(String user);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_editor, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Setup view from dialog_editor.xml
        final EditText etUser = (EditText) v.findViewById(R.id.et_user);

        builder.setView(v)
                .setTitle("Username")
                .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String user = etUser.getText().toString();
                        try {
                            mCallback = (setOnPositiveButtonClicked) getActivity();
                            mCallback.onPositiveButtonClicked(user); //Call onPositiveButton method in MainActivity
                        } catch (ClassCastException e)  {
                            throw new ClassCastException(getActivity() + "must implement setOnPositiveButtonClicked");
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        return builder.create();
    }
}
