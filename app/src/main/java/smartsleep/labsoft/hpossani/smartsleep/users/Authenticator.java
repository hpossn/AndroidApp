package smartsleep.labsoft.hpossani.smartsleep.users;


import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hpossani on 08/10/16.
 */

public class Authenticator {
    private User user;

    public Authenticator(User user) {
        this.user = user;
    }

    public void authenticate(Context ctx) {


        RequestQueue queue = Volley.newRequestQueue(ctx);
        String url = "http://104.236.90.130:8000/restAPI/login";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("result", response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Result", "That didn't work!");
            }
        }) {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("username", user.getUsername());
                params.put("password",user.getPassword());

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };

        queue.add(stringRequest);
    }
}
