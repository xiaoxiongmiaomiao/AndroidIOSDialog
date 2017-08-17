package com.example.android_alert_ios;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/22.
 */
public class AlertCustom {
     private Context context;
    private Dialog alertDialog;
    private Button btn_clickOK;
    private Button btn_clickCancel;
    public AlertCustom(Context context){
        this.context = context;
    }
    private String alertTitle;
    private String alertContent;

    public void setAlertTitle(String alertTitle){
        this.alertTitle = alertTitle;
    }
    public  void setAlertContent(String alertContent){
        this.alertContent = alertContent;
    }
    public  void showAlertCustom(final DialogClick click){
        showAlert(this.alertTitle,this.alertContent);
        btn_clickOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.alertClickOk(true);
            }
        });
        btn_clickCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.alertClickOk(false);
            }
        });
    }
    private void showAlert(String alertTitle,String alertContent){
        alertDialog = new Dialog(context,R.style.myDialog);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setCancelable(false);
        View inflate = LayoutInflater.from(context).inflate(R.layout.android_dialog_ios, null, false);
        alertDialog.setContentView(inflate);
        TextView title = (TextView) inflate.findViewById(R.id.alert_Android_Title);
        title.setText(alertTitle);
        TextView Content = (TextView)inflate.findViewById(R.id.alert_Android_Content);
        Content.setText(alertContent);
        btn_clickOK =  (Button) inflate.findViewById(R.id.android_alert_sure);
        btn_clickCancel = (Button) inflate.findViewById(R.id.android_alert_cancel);
        alertDialog.show();
    }

    public void dismissAlert(){
        if(alertDialog != null){
            alertDialog.dismiss();
        }
    }
    public  interface DialogClick{
        public void alertClickOk(boolean click);
    }
}
