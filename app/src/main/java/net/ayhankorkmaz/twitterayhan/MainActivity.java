package net.ayhankorkmaz.twitterayhan;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class MainActivity extends Activity {
	
	SharedPreferences pref;

    //Tweeter üzerinden ouşturacağıız API le gelen KEY ve SECRET buraya yazin
    private static String API_key = "oxFLxPHVdnc5ZfIzPfQlYSd8I";
    private static String API_secret = "AYIiThOXM4JdDqTTCuWUHDDYaJyoBq6MrPJofReh9HV2CoFG9S";
  

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        pref = getPreferences(0);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("API_key", API_key);
        edit.putString("API_secret", API_secret);
        edit.commit();  

		Fragment login = new LoginFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();	              
        ft.replace(R.id.content_frame, login);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
	}


}


