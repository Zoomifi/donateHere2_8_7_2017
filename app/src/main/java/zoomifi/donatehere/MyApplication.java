package zoomifi.donatehere;

import android.content.Context;

import com.parse.Parse;
import com.parse.ParseCrashReporting;

public class MyApplication extends android.app.Application {
    private static Context context;

    public MyApplication() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();

        System.out.println("APPLICATION CALLED");
        ParseCrashReporting.enable(this);
        //Parse.initialize(this, "4HEcYf3QM7WTNaCV5cdx4igevMjGCstzaQTgKaLQ", "UKvJxHiksfKfNNMPGiW9KtyH7g7NeTBCbHJX30y7");
        Parse.initialize(this, "LaQNRmRA3P03N96ht5UFtdssXUv6sb6okMihbcnf", "j9uIuNIeTPpZ14zrTUh9OL4RQ6QKcK1YL4gXXuId");

    }
    public static Context getAppContext() {
        return MyApplication.context;
    }
}
