# PermissionDemo
Android Runtime permission using easy permission.

###Step's to include Easy permission in app

1. Add easy permission library in build.gradle (compile 'pub.devrel:easypermissions:0.4.0')
2. implement EasyPermissions.PermissionCallbacks to Activity or Fragment
3. Override onRequestPermissionsResult and forward results to EasyPermissions (EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);)
4. Create permission constant like "public static final int PERMISSION_CALL = 101;"
5. Annotate the method in which you want the permission with you permission constant (@AfterPermissionGranted(PERMISSION_CALL))
6. Create the permission array (String[] perms = {Manifest.permission.CALL_PHONE};)
7. Check for permission which you have using the permission array (if (EasyPermissions.hasPermissions(this, perms)))
8. In else just ask the required permission using the permission array (EasyPermissions.requestPermissions(this, "CALL PERMISSION", PERMISSION_CALL, perms);) 
9. Don't forget to add the permission you required in manifest.xml
   
