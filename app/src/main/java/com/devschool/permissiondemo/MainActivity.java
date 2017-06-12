package com.devschool.permissiondemo;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.button_call)
    Button buttonCall;
    public static final int PERMISSION_CALL = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }


    @OnClick(R.id.button_call)
    @AfterPermissionGranted(PERMISSION_CALL)
    public void onViewClicked() {
        String[] perms = {Manifest.permission.CALL_PHONE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:0377778888"));
            startActivity(callIntent);
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, "CALL PERMISSION", PERMISSION_CALL, perms);
        }

    }



}
