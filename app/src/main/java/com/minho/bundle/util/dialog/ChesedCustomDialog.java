package com.minho.bundle.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.minho.bundle.R;

public class ChesedCustomDialog extends Dialog {

    private String dialog_title;
    private String dialog_content;
    private View.OnClickListener click_confirm;

    public ChesedCustomDialog(Context context, String title, String content, View.OnClickListener click_confirm) {
        super(context);

        this.dialog_title = title;
        this.dialog_content = content;
        this.click_confirm = click_confirm;
    }


    private TextView dialog_chesed_title;
    private TextView dialog_chesed_content;
    private Button dialog_chesed_button_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_chesed);

        dialog_chesed_title = findViewById(R.id.dialog_chesed_title);
        dialog_chesed_content = findViewById(R.id.dialog_chesed_content);
        dialog_chesed_button_confirm = findViewById(R.id.dialog_chesed_button_confirm);

        if(click_confirm!=null){
            dialog_chesed_button_confirm.setOnClickListener(click_confirm);
        }

        dialog_chesed_title.setText(dialog_title);
        dialog_chesed_content.setText(dialog_content);

    }

}
