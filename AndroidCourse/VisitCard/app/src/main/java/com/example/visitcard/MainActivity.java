package com.example.visitcard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_ID = MainActivity.class.getSimpleName() + ".NAME";
    public static final String COMPANY_ID = MainActivity.class.getSimpleName() + ".COMPANY";
    public static final String EMAIL_ID = MainActivity.class.getSimpleName() + ".EMAIL";
    public final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    String currentPhotoPath;
    Bitmap imageCard;

    EditText editNome, editCompany, editEmail;
    Button buttonCreate;
    TextView textCardName, textCardCompany, textCardEmail;
    ImageView imageView_photo, imageViewCardPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.edit_nome);
        editCompany = findViewById(R.id.edit_company);
        editEmail = findViewById(R.id.edit_email);
        textCardName = findViewById(R.id.text_card_name);
        textCardCompany = findViewById(R.id.text_card_company);
        textCardEmail = findViewById(R.id.text_card_email);
        imageView_photo = findViewById(R.id.imageView_photo_edit);
        imageViewCardPhoto = findViewById(R.id.imageView_card);

    }

    public void createCard(View view) {

        editNome.getText().toString();
        editCompany.getText().toString();
        editEmail.getText().toString();

        textCardName.setText("Nome: "+editNome.getText().toString());
        textCardCompany.setText("Empresa: "+editCompany.getText().toString());
        textCardEmail.setText("E-mail: "+editEmail.getText().toString());
        Bitmap bitmap = ((BitmapDrawable) imageView_photo.getDrawable()).getBitmap();
        imageViewCardPhoto.setImageBitmap(bitmap);

        editNome.getText().clear();
        editCompany.getText().clear();
        editEmail.getText().clear();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView_photo.setImageBitmap(imageBitmap);
            imageCard = imageBitmap;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void takePhoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null){
            File photoFile = null;
            try{
                photoFile = createImageFile();
            } catch (IOException e) {

            }
            if(photoFile != null){
//                Uri photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider",
//                        photoFile);
                //takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }

        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );

        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}
