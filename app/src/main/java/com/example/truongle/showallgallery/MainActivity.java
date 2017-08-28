package com.example.truongle.showallgallery;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity {

    /** The images. */
    private ArrayList<Photo> images;
    public static final String TAG="AAA";
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = getAllShownImagesPath(this);
        Log.d(TAG, "onCreate: "+images.size());
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewPhto);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        PhotoAdapter adater = new PhotoAdapter(this,images);

        recyclerView.setAdapter(adater);
//        GridView gallery = (GridView) findViewById(R.id.galleryGridView);
//
//        gallery.setAdapter(new ImageAdapter(this));
//
//        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1,
//                                    int position, long arg3) {
//                if (null != images && !images.isEmpty())
//                    Toast.makeText(
//                            getApplicationContext(),
//                            "position " + position + " " + images.get(position),
//                            Toast.LENGTH_LONG).show();
//
//                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
//                intent.putExtra("imagePath", images.get(position));
//                startActivity(intent);
//            }
//        });

    }

    /**
     * The Class ImageAdapter.
     */
//    private class ImageAdapter extends BaseAdapter {
//
//        /** The context. */
//        private Activity context;
//
//        /**
//         * Instantiates a new image adapter.
//         *
//         * @param localContext
//         *            the local context
//         */
//        public ImageAdapter(Activity localContext) {
//            context = localContext;
//            images = getAllShownImagesPath(context);
//        }
//
//        public int getCount() {
//            return images.size();
//        }
//
//        public Object getItem(int position) {
//            return position;
//        }
//
//        public long getItemId(int position) {
//            return position;
//        }
//
//        public View getView(final int position, View convertView,
//                            ViewGroup parent) {
//            ImageView picturesView;
//            if (convertView == null) {
//                picturesView = new ImageView(context);
//                picturesView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                picturesView
//                        .setLayoutParams(new GridView.LayoutParams(270, 270));
//
//            } else {
//                picturesView = (ImageView) convertView;
//            }
//
//            Glide.with(context).load(images.get(position))
//                   // .placeholder(R.drawable.ic_launcher)
//                  //  .centerCrop()
//                    .into(picturesView);
//
//            return picturesView;
//        }

        /**
         * Getting All Images Path.
         *
         * @param activity
         *            the activity
         * @return ArrayList with images Path
         */
        private ArrayList<Photo> getAllShownImagesPath(Activity activity) {
            Uri uri;
            Cursor cursor;
            int column_index_data, column_index_folder_name;
            ArrayList<Photo> listOfAllImages = new ArrayList<>();
            String absolutePathOfImage = null;
            uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

            String[] projection = { MediaStore.MediaColumns.DATA,
                    MediaStore.Images.Media.BUCKET_DISPLAY_NAME };

            cursor = activity.getContentResolver().query(uri, projection, null,
                    null, null);

            column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            column_index_folder_name = cursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
            while (cursor.moveToNext()) {
                absolutePathOfImage = cursor.getString(column_index_data);
//                listOfAllImages.add(absolutePathOfImage);
                File file = new File(absolutePathOfImage);
                Date lastModeDate = new Date(file.lastModified());
                Photo photo = new Photo(absolutePathOfImage,""+lastModeDate,"","");
                listOfAllImages.add(photo);
                Log.d(TAG, "getAllShownImagesPath: "+lastModeDate.toString());
            }
            return listOfAllImages;
        }
    }
