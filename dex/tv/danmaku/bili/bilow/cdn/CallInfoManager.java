package tv.danmaku.bili.bilow.cdn;

import com.bilibili.app.comm.billow.biz.BuildConfig;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;

public class CallInfoManager {
    private static volatile CallInfoManager mInstance;
    final String TAG = "CallInfoManager";
    private Map<Integer, ConnectionInfoRecord> contents = new ConcurrentHashMap();

    private CallInfoManager() {
    }

    public static CallInfoManager getInstance() {
        if (mInstance == null) {
            synchronized (CallInfoManager.class) {
                if (mInstance == null) {
                    mInstance = new CallInfoManager();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class ConnectionInfoRecord {
        private String connectionIp;
        private String url;

        public ConnectionInfoRecord(String url, String ip) {
            this.url = url;
            this.connectionIp = ip;
        }
    }

    public void needCache(int key) {
        ConnectionInfoRecord callinfo = new ConnectionInfoRecord("", "");
        if (BuildConfig.DEBUG) {
            BLog.d("CallInfoManager", "needCache " + key);
        }
        this.contents.put(Integer.valueOf(key), callinfo);
    }

    public void fill(String url, String ip, int key) {
        ConnectionInfoRecord record = this.contents.get(Integer.valueOf(key));
        if (record != null) {
            record.url = url;
            record.connectionIp = ip;
            this.contents.put(Integer.valueOf(key), record);
        }
        if (BuildConfig.DEBUG) {
            BLog.d("CallInfoManager", "fill " + key + ", needCache=" + (record != null ? "yes" : "no, ") + ip + ", " + url);
        }
    }

    public String pickupIp(int key) {
        ConnectionInfoRecord record = this.contents.remove(Integer.valueOf(key));
        if (record != null) {
            return record.connectionIp;
        }
        return "";
    }

    public int size() {
        return this.contents.size();
    }
}