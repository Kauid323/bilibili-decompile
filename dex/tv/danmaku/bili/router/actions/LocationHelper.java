package tv.danmaku.bili.router.actions;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.location.BLLocation;
import com.bilibili.location.LocationManager;
import com.bilibili.location.LocationService;
import java.util.concurrent.atomic.AtomicBoolean;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.login.LoginReporterV2;

@Deprecated
public class LocationHelper {
    public static JSONObject getLocation(final Context context, final int locType, boolean isCanceled) {
        final JSONObject[] resJson = {null};
        if (isCanceled) {
            resJson[0] = generateLocationResult(null, locType, 1, "");
        } else {
            synchronized (LocationHelper.class) {
                final AtomicBoolean hasCallback = new AtomicBoolean(false);
                HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.bili.router.actions.LocationHelper$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationHelper.lambda$getLocation$1(context, locType, hasCallback, resJson);
                    }
                });
                while (!hasCallback.get()) {
                    try {
                        LocationHelper.class.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        BLog.d("Get location info: " + String.valueOf(resJson[0]));
        return resJson[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getLocation$1(Context context, final int locType, final AtomicBoolean hasCallback, final JSONObject[] resJson) {
        LocationManager locationManager = LocationManager.getInstanse(context.getApplicationContext());
        if (locType == 0) {
            BLLocation location = locationManager.getLastLocation();
            hasCallback.set(true);
            resJson[0] = generateLocationResult(location, locType, 0, null);
            synchronized (LocationHelper.class) {
                LocationHelper.class.notifyAll();
            }
            return;
        }
        locationManager.requestLocation(new LocationService.LocationListaner() { // from class: tv.danmaku.bili.router.actions.LocationHelper$$ExternalSyntheticLambda0
            public final void onLocationChanged(BLLocation bLLocation, int i, String str) {
                LocationHelper.lambda$getLocation$0(hasCallback, resJson, locType, bLLocation, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getLocation$0(AtomicBoolean hasCallback, JSONObject[] resJson, int locType, BLLocation loc, int errorCode, String msg) {
        hasCallback.set(true);
        resJson[0] = generateLocationResult(loc, locType, errorCode, msg);
        synchronized (LocationHelper.class) {
            LocationHelper.class.notifyAll();
        }
    }

    private static JSONObject generateLocationResult(BLLocation loc, int locType, int errorCode, String msg) {
        JSONObject res = new JSONObject();
        switch (errorCode) {
            case 0:
                res.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, 0);
                res.put("type", Integer.valueOf(locType));
                if (loc != null) {
                    JSONObject locJson = new JSONObject();
                    JSONObject coorJson = new JSONObject();
                    String coor = loc.getLat() + "," + loc.getLon();
                    locJson.put("cityId", loc.getCityId());
                    locJson.put("cityName", loc.getCityName());
                    coorJson.put("type", loc.getType());
                    coorJson.put("coor", coor);
                    locJson.put("coordinate", coorJson);
                    res.put("location", locJson);
                    break;
                }
                break;
            case 1:
                res.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, 2);
                break;
            case 2:
            case 3:
            case 4:
                res.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, 1);
                break;
        }
        return res;
    }
}