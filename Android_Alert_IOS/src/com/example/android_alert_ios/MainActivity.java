package com.example.android_alert_ios;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;


public class MainActivity extends Activity {
	
	private ProgressDialog tipDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 final AlertCustom alertCustom = new AlertCustom(MainActivity.this);
			        alertCustom.setAlertTitle("title");
			        alertCustom.setAlertContent("This is content,you may be repair content ");
			        alertCustom.showAlertCustom(new AlertCustom.DialogClick() {
			            @Override
			            public void alertClickOk(boolean click) {
			                if (click) {
			                    alertCustom.dismissAlert();
			                    System.out.println("close");
			                } else {
			                	System.out.println("Open");
			                    alertCustom.dismissAlert();
			                }
			            }
			        });
			}
		});
      findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			showTipDialog();
		}
	});
  
    }
    
    public void showTipDialog(){
    	tipDialog = new ProgressDialog(this, R.style.myDialog);
    	tipDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	tipDialog.setMessage("please warting...");
    	tipDialog.setOnCancelListener(new OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				System.out.println("cancle warting");
			}
		});
    	tipDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
