package com.luis_santiago.aigol.utils.tools.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.luis_santiago.aigol.utils.tools.data.news.score.TableTeam;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;

import static com.google.android.gms.internal.zzt.TAG;
import static java.lang.System.load;

/**
 * Created by legendarywicho on 8/10/17.
 */

public class Utils {

    public static void throwDialogue(Context context){
        AlertDialog.Builder mBuilder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBuilder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            mBuilder = new AlertDialog.Builder(context);
        }

        mBuilder.setTitle("¡Chicharito la fallo!")
                .setMessage("There is no internet connection")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                });
        mBuilder.show();
    }

    public static Boolean checkForInternetConection (Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo!=null && networkInfo.isConnected();
    }

    public static void DownloadImage(ImageView imageView, String url){
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView, new Callback.EmptyCallback(){
                    @Override
                    public void onSuccess() {
                        // do nothing for now
                    }
                });
        Picasso.with(imageView.getContext())
                .load(url)
                .into(target);
    }

    private static Target target = new Target() {
        @Override
        public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    File file = new File(Environment.getExternalStorageDirectory().getPath() + "/team_logo.jpg");
                    try {
                        file.createNewFile();
                        FileOutputStream outputStream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 75, outputStream);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    public static TableTeam generateTableTeam(DataSnapshot snapshot){
        Long position = (Long) snapshot.child("position").getValue();
        String name = (String) snapshot.child("name").getValue();
        String logo = (String) snapshot.child("team_logo").getValue();
        Long matchesPlayed = (Long) snapshot.child("matches_played").getValue();
        Long goalDifference = (Long) snapshot.child("goal_difference").getValue();
        Long goalFor = (Long) snapshot.child("goal_for").getValue();
        Long goalAfter = (Long) snapshot.child("goal_afer").getValue();
        Long points = (Long) snapshot.child("points").getValue();
        Log.e(TAG, "THE NEW POSITION"+Long.toString(points));
        TableTeam tableTeam = new TableTeam(
                Long.toString(position),
                logo,
                name,
                Long.toString(matchesPlayed),
                Long.toString(goalFor),
                Long.toString(goalAfter),
                Long.toString(goalDifference),
                Long.toString(points)
        );
        return tableTeam;
    }
}
