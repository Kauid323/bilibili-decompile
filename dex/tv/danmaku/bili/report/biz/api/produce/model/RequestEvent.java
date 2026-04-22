package tv.danmaku.bili.report.biz.api.produce.model;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.util.Pools;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

@Deprecated
public class RequestEvent implements ReportEvent.Factory {
    public static final int PARSE_STATE_FIELD_ERROR = 4;
    public static final int PARSE_STATE_JSON_ERROR = 3;
    public static final int PARSE_STATE_OK = 1;
    public static final int PARSE_STATE_READ_ERROR = 2;
    static final Pools.Pool<RequestEvent> sPool = new Pools.SynchronizedPool(10);
    public String api;
    public int errorCode;
    public Throwable exception;
    public String host;
    public String hostIp;
    public int httpcode;
    public String httpmsg;
    public String idc;
    public long reqBodySize;
    public long requestTime;
    public long respBodySize;
    public int respcode;
    public byte[] respdata;
    public byte[] responseBody;
    public String scheme;
    public long timeused;
    public String traceId;
    public String url;
    public String xcache;
    public String respmsg = "";
    public int parsestate = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public @interface ParseState {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RequestEvent(String url) {
        initialize(url);
    }

    private void initialize(String url) {
        this.url = url;
        Uri parsed = Uri.parse(url);
        this.scheme = parsed.getScheme();
        this.host = parsed.getHost();
        this.api = parsed.getPath();
    }

    public static RequestEvent obtain(String url) {
        RequestEvent event = (RequestEvent) sPool.acquire();
        if (event == null) {
            return new RequestEvent(url);
        }
        event.initialize(url);
        return event;
    }

    public void recycle() {
        this.respmsg = "";
        this.httpmsg = "";
        this.errorCode = 0;
        this.respcode = 0;
        this.httpcode = 0;
        this.parsestate = 1;
        this.timeused = 0L;
        this.respdata = null;
        this.api = null;
        this.host = null;
        this.scheme = null;
        this.url = null;
        this.reqBodySize = 0L;
        this.respBodySize = 0L;
        sPool.release(this);
    }

    public String[] asArgs() {
        return new String[]{ReportEvent.Tag.API, this.api, ReportEvent.Tag.HOST, this.host, "url", Uri.encode(this.url), "httpmsg", "", ReportEvent.Tag.HTTPCODE, String.valueOf(this.httpcode), ReportEvent.Tag.RESPCODE, String.valueOf(this.respcode), ReportEvent.Tag.RESPMSG, Uri.encode(this.respmsg), ReportEvent.Tag.PARSESTATE, String.valueOf(this.parsestate), ReportEvent.Tag.TIMEUSED, String.valueOf(this.timeused)};
    }

    public String toString() {
        return "Event{" + TextUtils.join(",", asArgs()) + "}";
    }

    @Override // tv.danmaku.bili.report.biz.api.produce.model.ReportEvent.Factory
    public ReportEvent getReportEvent() {
        ReportEvent event = new ReportEvent(0);
        event.put("url", this.url);
        event.put(ReportEvent.Tag.HOST, this.host);
        event.put(ReportEvent.Tag.API, this.api);
        event.put(ReportEvent.Tag.HTTPCODE, Integer.valueOf(this.httpcode));
        event.put(ReportEvent.Tag.RESPCODE, Integer.valueOf(this.respcode));
        event.put(ReportEvent.Tag.RESPMSG, this.respmsg);
        event.put(ReportEvent.Tag.PARSESTATE, Integer.valueOf(this.parsestate));
        event.put(ReportEvent.Tag.TIMEUSED, Long.valueOf(this.timeused));
        event.put(ReportEvent.Tag.REQSIZE, Long.valueOf(this.reqBodySize));
        event.put(ReportEvent.Tag.RESPSIZE, Long.valueOf(this.respBodySize));
        return event;
    }

    public boolean isValid() {
        boolean corrupted = this.api == null || this.host == null || this.httpcode == 0;
        return !corrupted;
    }
}