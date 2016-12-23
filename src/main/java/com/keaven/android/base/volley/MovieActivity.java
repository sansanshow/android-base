package com.keaven.android.base.volley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.keaven.android.base.BaseActivity;
import com.keaven.android.base.BaseApplication;
import com.keaven.android.base.R;
import com.keaven.android.base.volley.adpter.CustomListAdapter;
import com.keaven.android.base.volley.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a-keaven on 2016/12/20.
 */
public class MovieActivity extends BaseActivity {
    // 用来打Log日志的TAG
    private static final String TAG = MovieActivity.class.getSimpleName();
    // JSON地址
    private static final String url = "http://api.androidhive.info/json/movies.json";
    private ProgressDialog pDialog;
    //用来存储Movie对象的list
    private List<Movie> movieList = new ArrayList<Movie>();
    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        listView = (ListView) findViewById(R.id.movie_list);
        adapter = new CustomListAdapter(this, movieList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // 加载框
        pDialog.setMessage("Loading...");
        pDialog.show();

        // 发送一个Json请求
        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // 解析json数据
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Movie movie = new Movie();
                                movie.setTitle(obj.getString("title"));
                                movie.setThumbnailUrl(obj.getString("image"));
                                movie.setRating(((Number) obj.get("rating"))
                                        .doubleValue());
                                movie.setYear(obj.getInt("releaseYear"));

                                // Genre是一个json数组
                                JSONArray genreArry = obj.getJSONArray("genre");
                                ArrayList<String> genre = new ArrayList<String>();
                                for (int j = 0; j < genreArry.length(); j++) {
                                    genre.add((String) genreArry.get(j));
                                }
                                movie.setGenre(genre);

                                // 将解析好的一个movie对象添加到list中
                                movieList.add(movie);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // 通知listview我们的数据已经改变，现在更新
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // 将request添加到requestQueue中
        BaseApplication.getInstance().addToRequestQueue(movieReq);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
