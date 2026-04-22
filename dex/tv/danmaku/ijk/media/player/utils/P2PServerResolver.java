package tv.danmaku.ijk.media.player.utils;

import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.ijk.media.player.P2P;

public class P2PServerResolver {
    private static final long SERVER_CONNECT_TIMEOUT = 15;
    private static final long SERVER_READ_TIMEOUT = 10;
    private static final String TAG = "IJKMEDIA_P2PServerResolver";
    private static final String TV_BOX_VERSION_1 = "fSDRQgpusmIbrzyc";
    private static final String TV_BOX_VERSION_2 = "XxIdVEtsYRStcpsMdgJnoKxSbWLbZdyP";
    private P2P.DEVICE_TYPE mDeviveType;
    private List<String> mIpv6StunServers;
    private boolean mIsRelease;
    private boolean mIsResolved = false;
    private List<String> mLiveTrackerServers;
    private String mP2PServerUrl;
    private int mP2PVersion;
    private String mProxyData;
    private String mProxyDataPath;
    private List<String> mStunServers;
    private List<String> mTrackerServers;

    public P2PServerResolver(String P2PServerUrl, P2P.DEVICE_TYPE type, int p2pVersion, boolean release, String proxyDataPath) {
        this.mP2PServerUrl = P2PServerUrl;
        this.mDeviveType = type;
        this.mP2PVersion = p2pVersion;
        this.mIsRelease = release;
        this.mProxyDataPath = proxyDataPath;
    }

    public void setNeedResolved() {
        this.mIsResolved = false;
    }

    public boolean resolve() {
        synchronized (this) {
            if (this.mIsResolved) {
                return true;
            }
            try {
                Request request = getRequest(this.mP2PServerUrl);
                BLog.i(TAG, request.toString() + request.headers().toString());
                Call call = getOkHttpClient().newCall(request);
                Response response = call.execute();
                ResponseBody body = response.body();
                if (body == null) {
                    response.close();
                    return false;
                }
                int code = response.code();
                switch (code) {
                    case 200:
                        String resp = response.body().string();
                        BLog.i(TAG, "resolved " + resp);
                        parseHttpResp(resp);
                        response.close();
                        this.mProxyData = resp;
                        this.mIsResolved = true;
                        return true;
                    default:
                        response.close();
                        return false;
                }
            } catch (Exception e) {
                BLog.w(TAG, e);
                return false;
            }
        }
    }

    public List<String> getTrackerServers() {
        synchronized (this) {
            if (this.mTrackerServers != null && this.mTrackerServers.size() != 0) {
                return new ArrayList(this.mTrackerServers);
            }
            return null;
        }
    }

    public List<String> getStunServers() {
        synchronized (this) {
            if (this.mStunServers != null && this.mStunServers.size() != 0) {
                return new ArrayList(this.mStunServers);
            }
            return null;
        }
    }

    public List<String> getIpv6StunServers() {
        synchronized (this) {
            if (this.mIpv6StunServers != null && this.mIpv6StunServers.size() != 0) {
                return new ArrayList(this.mIpv6StunServers);
            }
            return null;
        }
    }

    public List<String> getLiveTrackerServers() {
        synchronized (this) {
            if (this.mLiveTrackerServers != null && this.mLiveTrackerServers.size() != 0) {
                return new ArrayList(this.mLiveTrackerServers);
            }
            return null;
        }
    }

    public void parseHttpResp(String resp) {
        try {
            JSONObject json = new JSONObject(resp);
            JSONObject data = json.optJSONObject("data");
            if (data != null) {
                JSONArray stuns = data.optJSONArray("stuns");
                List<String> stunList = new ArrayList<>();
                for (int i = 0; stuns != null && i < stuns.length(); i++) {
                    stunList.add(stuns.optString(i));
                }
                this.mStunServers = stunList;
                JSONArray ipv6Stuns = data.optJSONArray("stun6s");
                List<String> ipv6StunList = new ArrayList<>();
                for (int i2 = 0; ipv6Stuns != null && i2 < ipv6Stuns.length(); i2++) {
                    ipv6StunList.add(ipv6Stuns.optString(i2));
                }
                this.mIpv6StunServers = ipv6StunList;
                JSONArray trackers = data.optJSONArray("trackers");
                List<String> trackerList = new ArrayList<>();
                for (int i3 = 0; trackers != null && i3 < trackers.length(); i3++) {
                    trackerList.add(trackers.optString(i3));
                }
                this.mTrackerServers = trackerList;
                JSONArray liveTrackers = data.optJSONArray("live_trackers");
                List<String> liveTrackerList = new ArrayList<>();
                for (int i4 = 0; liveTrackers != null && i4 < liveTrackers.length(); i4++) {
                    liveTrackerList.add(liveTrackers.optString(i4));
                }
                this.mLiveTrackerServers = liveTrackerList;
            }
        } catch (JSONException e) {
        }
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();
    }

    private Request getRequest(String url) {
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put("appkey", getAppKey());
        headerMap.put("ts", String.valueOf(SystemClock.elapsedRealtime()));
        headerMap.put("version", String.valueOf(this.mP2PVersion));
        headerMap.put("type", String.valueOf(this.mDeviveType.ordinal()));
        if (this.mIsRelease) {
            headerMap.put("channel", "release");
        } else {
            headerMap.put("channel", "beta");
        }
        String sign = md5(getParamString(headerMap) + checkTvBoxType(9, TV_BOX_VERSION_2));
        headerMap.put("sign", sign);
        String requestUrl = url + getParamString(headerMap);
        Request.Builder builder = new Request.Builder().url(requestUrl).get();
        return builder.build();
    }

    private String getParamString(HashMap<String, String> paramMap) {
        String paramString = "";
        Object[] keyArr = paramMap.keySet().toArray();
        Arrays.sort(keyArr);
        for (Object key : keyArr) {
            if (paramString.length() > 0) {
                paramString = paramString + "&";
            }
            paramString = paramString + key + "=" + paramMap.get(key);
        }
        return paramString;
    }

    private String getAppKey() {
        return checkTvBoxType(3, TV_BOX_VERSION_1);
    }

    private String checkTvBoxType(int model, String version) {
        StringBuilder newSb = new StringBuilder();
        byte[] bytes = version.getBytes();
        for (byte aByte : bytes) {
            int loop = (((aByte + model) - 65) % 57) + 65;
            int s = 0;
            while (loop > 90 && loop < 97) {
                model += s * model;
                s++;
                loop = (((aByte + model) - 65) % 57) + 65;
                System.out.println("t" + model);
            }
            newSb.append((char) loop);
        }
        return newSb.toString();
    }

    private String md5(String plainText) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(plainText.getBytes(Charset.forName("UTF-8")));
            byte[] hash = digest.digest();
            return toHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            return "000000000000000000000000000000000000";
        }
    }

    private String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            int intVal = b & 255;
            if (intVal < 16) {
                hexString.append('0');
            }
            hexString.append(Integer.toHexString(intVal));
        }
        return hexString.toString();
    }

    public void writeProxyDataToFile() {
        if (this.mProxyData.isEmpty()) {
            return;
        }
        File file = new File(this.mProxyDataPath);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            BufferedWriter writer = null;
            try {
                try {
                    try {
                        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.mProxyDataPath, false), "UTF-8"));
                        writer.write(this.mProxyData);
                        writer.close();
                    } catch (IOException e) {
                        BLog.w(TAG, e);
                        if (writer != null) {
                            writer.close();
                        }
                    }
                } catch (Throwable th) {
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e2) {
                            BLog.w(TAG, e2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                BLog.w(TAG, e3);
            }
        } catch (IOException e4) {
            BLog.w(TAG, e4);
        }
    }

    public String readProxyDataFromFile() {
        String proxyData = "";
        BufferedReader reader = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(this.mProxyDataPath);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                    reader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String tempString = reader.readLine();
                        if (tempString == null) {
                            break;
                        }
                        proxyData = proxyData + tempString;
                    }
                    reader.close();
                    reader.close();
                } catch (IOException e) {
                    BLog.w(TAG, e);
                    if (reader != null) {
                        reader.close();
                    }
                }
            } catch (Throwable th) {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e2) {
                        BLog.w(TAG, e2);
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            BLog.w(TAG, e3);
        }
        return proxyData;
    }
}