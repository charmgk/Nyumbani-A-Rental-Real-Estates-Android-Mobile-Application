package com.muguku.mash.nyumbani;

/**
 * Created by mash on 7/27/17.
 */

         import android.app.AlertDialog;
         import android.content.Context;
         import android.content.Intent;
         import android.os.AsyncTask;
         import android.widget.Toast;
         import java.io.BufferedReader;
         import java.io.BufferedWriter;
         import java.io.IOException;
         import java.io.InputStream;
         import java.io.InputStreamReader;
         import java.io.OutputStream;
         import java.io.OutputStreamWriter;
         import java.net.HttpURLConnection;
         import java.net.MalformedURLException;
         import java.net.URL;
         import java.net.URLEncoder;


public class BackgroundTask extends AsyncTask<String,Void,String>  {


    AlertDialog alertDialog;
    Context ctx;


    BackgroundTask(Context ctx)
    {
        this.ctx =ctx;
    }
    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Nyumbani!");
    }
    @Override
    protected String doInBackground(String... params) {

        //For genymotion
        String reg_url = "http://10.0.3.2/mnyumba/php/register.php";
        String login_url = "http://10.0.3.2/mnyumba/php/login.php";

        //for actual devices
/*        String reg_url = "http://192.168.173.154/mnyumba/php/register.php";
        String login_url = "http://192.168.173.154/mnyumba/php/login.php";*/

        //For android adb emulator
       /* String reg_url = "http://10.0.2.2/mnyumba/webapp/register.php";
        String login_url = "http://10.0.2.2/mnyumba/webapp/login.php";*/


        String method = params[0];
        if (method.equals("register")) {
            String email = params[1];
            String user_name = params[2];
            String user_pass = params[3];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                //httpURLConnection.setDoInput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                //httpURLConnection.connect();
                httpURLConnection.disconnect();

                return "Registration Successful. Karibu Nyumbani!";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login"))
        {
            String login_name = params[1];
            String login_pass = params[2];
            try {

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                        URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


                return response;




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {

        if(result.equals("Registration Successful. Karibu Nyumbani!"))
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            Intent signInIntent = new Intent(ctx, LoginActivity.class);
            ctx.startActivity(signInIntent);
        }

        else
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            Intent signInIntent = new Intent(ctx, HomeNavigationActivity.class);
            ctx.startActivity(signInIntent);
        }

    }

}
