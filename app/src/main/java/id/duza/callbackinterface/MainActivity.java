package id.duza.callbackinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogEditor.setOnPositiveButtonClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnShowDialog = (Button) findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showEditorDialog();
            }
        });
    }

    private void showEditorDialog() {
        DialogEditor dialogEditor = new DialogEditor();
        dialogEditor.show(getFragmentManager(), "editor");
    }

    @Override
    public void onPositiveButtonClicked(String user) {
        // Get string username from edit text in dialog editor
        TextView tvUser = (TextView) findViewById(R.id.tv_user);
        tvUser.setText(user);
        Toast.makeText(MainActivity.this, "Yeaay! High five " + user + " :D ", Toast.LENGTH_SHORT).show();
    }
}
