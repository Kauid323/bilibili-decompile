package tv.danmaku.bili.report.biz.api.produce.model;

import android.net.Uri;
import com.bilibili.commons.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class ReportEvent implements IReportEvent {
    public static final int SOURCE_API = 0;
    public static final int SOURCE_NA = -1;
    public static final int SOURCE_PLAY_URL = 1;
    Map<String, Object> mMaterial = new HashMap();
    int mSource;

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface Factory {
        ReportEvent getReportEvent();
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Tag {
        public static final String API = "api";
        public static final String HOST = "host";
        public static final String HTTPCODE = "httpcode";
        public static final String INTERFACE = "interface";
        public static final String PARSESTATE = "parsestate";
        public static final String REQSIZE = "reqSize";
        public static final String RESPCODE = "respcode";
        public static final String RESPMSG = "respmsg";
        public static final String RESPSIZE = "respSize";
        public static final String SAMPLING = "sampling";
        public static final String TIMEUSED = "timeused";
        public static final String URL = "url";
    }

    public ReportEvent(int source) {
        this.mSource = source;
    }

    @Override // tv.danmaku.bili.report.biz.api.produce.model.IReportEvent
    public Object get(String tag) {
        return this.mMaterial.get(tag);
    }

    @Override // tv.danmaku.bili.report.biz.api.produce.model.IReportEvent
    public void put(String tag, Object value) {
        this.mMaterial.put(tag, value);
    }

    @Override // tv.danmaku.bili.report.biz.api.produce.model.IReportEvent
    public int getSource() {
        return this.mSource;
    }

    public int getInt(String tag) {
        Object o = this.mMaterial.get(tag);
        if (o == null || !(o instanceof Integer)) {
            return Integer.MIN_VALUE;
        }
        return ((Integer) o).intValue();
    }

    public String getString(String tag) {
        Object o = this.mMaterial.get(tag);
        if (o == null || !(o instanceof String)) {
            return null;
        }
        return (String) o;
    }

    public long getLong(String tag) {
        Object o = this.mMaterial.get(tag);
        if (o == null || !(o instanceof Long)) {
            return Long.MIN_VALUE;
        }
        return ((Long) o).longValue();
    }

    public void generateInterface() {
        String interfaceName = getInterfaceName(getString("url"));
        put(Tag.INTERFACE, interfaceName);
    }

    private static String getInterfaceName(String url) {
        StringBuilder builder = new StringBuilder();
        if (url != null) {
            Uri parsed = Uri.parse(url);
            String host = parsed.getHost();
            String path = parsed.getPath();
            builder.append(parsed.getScheme()).append("://");
            if ("bangumi.bilibili.com".equals(host) && StringUtils.startsWith(path, "/api/season/recommend/rnd")) {
                builder.append(host).append("/api/season/recommend/rnd/#season_id.json");
            } else {
                builder.append(parsed.getAuthority()).append(parsed.getPath());
            }
        }
        return builder.toString();
    }
}