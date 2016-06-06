package me.shrimadhavuk.numselapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    EditText txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        txt1 = (EditText) findViewById(R.id.editText);

    }

    public void abtAcnpfm(View v){
        Toast.makeText(MainActivity.this, "https://shrimadhavuk.me", Toast.LENGTH_LONG).show();
    }

    public void launchAcnPfm(View v){
        String phonenumber = txt1.getText().toString();
        if(isPackageInstalled("com.whatsapp")){
            openWhatsappContact(phonenumber);
        }
    }

    public void openWhatsappContact(String number) {
        // http://stackoverflow.com/questions/15462874/sending-message-through-whatsapp
        Uri uri = Uri.parse("smsto:" + number);
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(i, ""));
    }

    private boolean isPackageInstalled(String uri) {
        // http://stackoverflow.com/questions/18752202/check-if-application-is-installed-android
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

}
