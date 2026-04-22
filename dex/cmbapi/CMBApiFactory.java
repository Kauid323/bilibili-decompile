package cmbapi;

import android.app.Activity;
import android.util.Log;

public class CMBApiFactory {
    private static final String TAG = "CMBSDK.CMBFactory";
    private static CMBApi mCmbApi;

    private CMBApiFactory() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static synchronized CMBApi createCMBAPI(Activity activity, String str) {
        CMBApi cMBApi;
        synchronized (CMBApiFactory.class) {
            mCmbApi = createCMBAPI(activity, str, false);
            cMBApi = mCmbApi;
        }
        return cMBApi;
    }

    private static CMBApi createCMBAPI(Activity activity, String str, boolean z) {
        Log.d(TAG, "createCMBAPI, appId = " + str + ", checkSignature = " + z);
        return new a(activity, str, z);
    }

    public static void destroyCMBAPI() {
        if (mCmbApi != null) {
            mCmbApi = null;
        }
    }

    public static CMBApi getCMBApi() {
        return mCmbApi;
    }
}