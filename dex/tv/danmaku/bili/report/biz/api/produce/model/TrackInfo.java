package tv.danmaku.bili.report.biz.api.produce.model;

import android.text.TextUtils;
import com.bilibili.lib.rpc.track.util.HttpUtilsKt;

@Deprecated
public class TrackInfo {
    public int apiCode;
    public String apiMsg;
    public Throwable connectError;
    public long connectTimeCost;
    public byte[] data;
    public int httpCode;
    public String httpMethod;
    public String httpUrl;
    public Throwable parseError;
    public long parseTimeCost;
    public Throwable readError;
    public long readTimeCost;

    public int parseState() {
        if (this.readError != null) {
            return 2;
        }
        if (this.parseError != null) {
            return 3;
        }
        return 1;
    }

    public RequestEvent transToRequestEvent() {
        RequestEvent event = RequestEvent.obtain(this.httpUrl);
        if (this.httpCode != -1) {
            event.httpcode = this.httpCode;
        } else if (this.connectError != null) {
            event.httpcode = -1;
        }
        event.timeused = this.connectTimeCost;
        event.respdata = this.data;
        if (this.apiCode != Integer.MIN_VALUE) {
            event.respcode = this.apiCode;
        } else {
            event.respcode = 0;
        }
        if (!TextUtils.isEmpty(this.apiMsg)) {
            event.respmsg = this.apiMsg;
            event.parsestate = 0;
        } else if (this.connectError != null) {
            event.respmsg = HttpUtilsKt.errorMsg("connect error = ", this.connectError);
            event.parsestate = 0;
        } else if (this.readError != null) {
            event.respmsg = HttpUtilsKt.errorMsg("read error = ", this.readError);
            event.parsestate = 2;
        } else if (this.parseError != null) {
            event.respmsg = HttpUtilsKt.errorMsg("parse error = ", this.parseError);
            event.parsestate = 3;
        }
        event.reqBodySize = 0L;
        event.respBodySize = this.data != null ? this.data.length : 0L;
        return event;
    }
}