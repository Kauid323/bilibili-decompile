package tv.danmaku.bili.report.biz.main.cdn;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

public class TrackerEvent {
    private static final String TAG = "misaka.apm.trackerevent";
    private final String DOMAIN_DEFAULT;
    private final String DOMAIN_FIELD_ERROR;
    private final String DOMAIN_HTTP_ERROR;
    private final String DOMAIN_SERIALIZATION_ERROR;
    private final String ERRNO_NA;
    private final String ERROR;
    private final String SUCCESS;
    private final String TYPE_ANDROID_OKHTTP;
    private final String TYPE_IOS_BFCAPIREQUEST;
    public final String api;
    public final Throwable exception;
    public final String host;
    public final int httpcode;
    public final long reqBodySize;
    public final long requestTime;
    public final long respBodySize;
    public final String scheme;
    public final long timeused;
    public final String url;

    private TrackerEvent(Builder builder) {
        this.SUCCESS = MineReporter.LIVE_TYPE_NOT_UPPER_NO_LIVE;
        this.ERROR = MineReporter.LIVE_TYPE_UPPER_NO_LIVE;
        this.TYPE_ANDROID_OKHTTP = "000001";
        this.TYPE_IOS_BFCAPIREQUEST = "001000";
        this.DOMAIN_DEFAULT = "00000000";
        this.DOMAIN_HTTP_ERROR = "00000001";
        this.DOMAIN_SERIALIZATION_ERROR = "00000010";
        this.DOMAIN_FIELD_ERROR = "00000011";
        this.ERRNO_NA = "0000000000000000";
        this.url = builder.url;
        Uri parsed = Uri.parse(this.url);
        this.scheme = parsed.getScheme();
        this.host = parsed.getHost();
        this.api = parsed.getPath();
        this.requestTime = builder.requestTime;
        this.timeused = builder.timeused;
        this.reqBodySize = builder.reqBodySize;
        this.respBodySize = builder.respBodySize;
        this.httpcode = builder.httpcode;
        this.exception = builder.exception;
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Builder {
        private Throwable exception;
        private int httpcode;
        private long reqBodySize;
        private long requestTime;
        private long respBodySize;
        private long timeused;
        private final String url;

        public Builder(String url) {
            this.url = url;
        }

        public Builder setRequestTime(long requestTime) {
            this.requestTime = requestTime;
            return this;
        }

        public Builder setTimeused(long timeused) {
            this.timeused = timeused;
            return this;
        }

        public Builder setReqBodySize(long reqBodySize) {
            this.reqBodySize = reqBodySize;
            return this;
        }

        public Builder setRespBodySize(long respBodySize) {
            this.respBodySize = respBodySize;
            return this;
        }

        public Builder setHttpcode(int httpcode) {
            this.httpcode = httpcode;
            return this;
        }

        public Builder setException(Throwable exception) {
            this.exception = exception;
            return this;
        }

        public TrackerEvent build() {
            return new TrackerEvent(this);
        }
    }

    public Map<String, String> asExtension() {
        boolean error = isError();
        Map<String, String> map = new HashMap<>();
        map.put("request_uri", buildUrl());
        map.put("start_request_ts", String.valueOf(this.requestTime / 1000));
        map.put("request_package_size", String.valueOf(this.reqBodySize));
        map.put("response_package_size", String.valueOf(this.respBodySize));
        map.put("http_code", String.valueOf(this.httpcode));
        map.put("consumer_time", String.valueOf(this.timeused));
        map.put("request_args", error ? encodeReqArgs() : "");
        map.put("biz_errcode", String.valueOf(errorCode()));
        if (this.exception != null) {
            map.put("exception_name", this.exception.getClass().getName());
            map.put("exception_message", this.exception.getMessage());
        }
        return map;
    }

    public boolean isError() {
        return this.httpcode < 200 || this.httpcode > 399;
    }

    private String buildUrl() {
        return new Uri.Builder().scheme(this.scheme).authority(this.host).path(this.api).build().toString();
    }

    private String encodeReqArgs() {
        String result = null;
        Uri uri = Uri.parse(this.url);
        if (uri != null) {
            result = uri.getEncodedQuery();
        }
        if (result != null) {
            return result;
        }
        return "";
    }

    private int errorCode() {
        StringBuilder builder = new StringBuilder();
        if (isError()) {
            builder.append(MineReporter.LIVE_TYPE_UPPER_NO_LIVE);
        } else {
            builder.append(MineReporter.LIVE_TYPE_NOT_UPPER_NO_LIVE);
        }
        builder.append("000001");
        builder.append(getDomain());
        builder.append(getCode());
        String code = builder.toString();
        BLog.vfmt(TAG, "Final error code = %s.", code);
        try {
            return Integer.parseInt(code, 2);
        } catch (Exception e) {
            return 0;
        }
    }

    private String getDomain() {
        if (isError()) {
            return "00000001";
        }
        return "00000000";
    }

    private String getCode() {
        return "0000000000000000";
    }
}