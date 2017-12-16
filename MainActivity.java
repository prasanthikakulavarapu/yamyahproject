package com.example.vamsikrishna.myapp2;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends Activity {
    Button button;
    ImageView imageView;
    static final int CAM_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.image_view);
        button.setOnclickListener(new View.OnClickListener() {
            @Override
            publlic void onClick(View v) {
                Indent camera_intent = new Indent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent,CAM_REQUEST);

            }
        }};
    }
    private File getFile()
    {
        File folder = new File("sdcard/camera_app");
        if(!folder.exists())
        {
            folder.mkdir();
        }
        File image_file = new File(folder,"cam_image.jpg");
        return image_file;

        @Override
          protected void  onActivityResult(int requestCode,int resultCode,Indent data){
            String path = "sdcard/camera_app/cam_image.jpg";
            imageView.setImageDrawable(Drawable.createFromPath(path));
    }
}
