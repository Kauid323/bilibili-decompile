package tv.danmaku.bili.report.biz.api.produce.model;

import android.net.Uri;

public final class RequestEvent2 extends RequestEvent {
    public static final int RESULT_TYPE_FAILURE = 1;
    public static final int RESULT_TYPE_LOGIC_FAILURE = 2;
    public static final int RESULT_TYPE_SUCCESS = 0;
    public int connect;
    public int dns;
    public String dnsProvider;
    public String extra;
    public int latency;
    public int request;
    public int response;
    public int resultType;
    public int sslHandshake;

    public RequestEvent2(String url) {
        super(url);
    }

    @Override // tv.danmaku.bili.report.biz.api.produce.model.RequestEvent
    public String[] asArgs() {
        return new String[]{Uri.encode(this.url), this.scheme, Uri.encode(this.host), Uri.encode(this.api), Uri.encode(this.hostIp), this.dnsProvider, String.valueOf(this.httpcode), Uri.encode(this.httpmsg), String.valueOf(this.respcode), Uri.encode(this.respmsg), String.valueOf(this.resultType), String.valueOf(this.timeused), String.valueOf(this.dns), String.valueOf(this.connect), String.valueOf(this.sslHandshake), String.valueOf(this.request), String.valueOf(this.response), String.valueOf(this.latency), String.valueOf(this.reqBodySize), String.valueOf(this.respBodySize), Uri.encode(this.traceId), Uri.encode(this.extra)};
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Builder {
        private String dnsProvider;
        private Throwable exception;
        private String extra;
        private String hostIp;
        private int httpcode;
        private String httpmsg;
        private String idc;
        private long reqBodySize;
        private long requestTime;
        private long respBodySize;
        private int respcode;
        private String respmsg;
        private byte[] responseBody;
        private String traceId;
        private String url;
        public String xcache;
        private int parseState = 1;
        private int latency = -1;
        private int response = -1;
        private int request = -1;
        private int sslHandshake = -1;
        private int connect = -1;
        private int dns = -1;
        private long timeused = -1;

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getUrl() {
            return this.url;
        }

        public Builder setHostIp(String hostIp) {
            this.hostIp = hostIp;
            return this;
        }

        public Builder setDnsProvider(String dnsProvider) {
            this.dnsProvider = dnsProvider;
            return this;
        }

        public Builder setHttpcode(int httpcode) {
            this.httpcode = httpcode;
            return this;
        }

        public int getHttpcode() {
            return this.httpcode;
        }

        public Builder setHttpmsg(String httpmsg) {
            this.httpmsg = httpmsg;
            return this;
        }

        public String getHttpmsg() {
            return this.httpmsg;
        }

        public Builder setRespcode(int respcode) {
            this.respcode = respcode;
            return this;
        }

        public Builder setRespmsg(String respmsg) {
            this.respmsg = respmsg;
            return this;
        }

        public Builder setTimeused(long timeused) {
            this.timeused = timeused;
            return this;
        }

        public Builder setDns(int dns) {
            this.dns = dns;
            return this;
        }

        public Builder setConnect(int connect) {
            this.connect = connect;
            return this;
        }

        public Builder setSslHandshake(int sslHandshake) {
            this.sslHandshake = sslHandshake;
            return this;
        }

        public Builder setRequest(int request) {
            this.request = request;
            return this;
        }

        public Builder setResponse(int response) {
            this.response = response;
            return this;
        }

        public Builder setLatency(int latency) {
            this.latency = latency;
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

        public Builder setResponseBody(byte[] responseBody) {
            this.responseBody = responseBody;
            return this;
        }

        public Builder setExtra(String extra) {
            this.extra = extra;
            return this;
        }

        public Builder setParseState(int parseState) {
            this.parseState = parseState;
            return this;
        }

        public Builder setXcache(String xcache) {
            this.xcache = xcache;
            return this;
        }

        public Builder setRequestTime(long requestTime) {
            this.requestTime = requestTime;
            return this;
        }

        public Builder setTraceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        public Builder setIdc(String idc) {
            this.idc = idc;
            return this;
        }

        public Builder setException(Throwable exception) {
            this.exception = exception;
            return this;
        }

        public RequestEvent2 build() {
            RequestEvent2 result = new RequestEvent2(this.url);
            result.hostIp = this.hostIp;
            result.dnsProvider = this.dnsProvider;
            result.httpcode = this.httpcode;
            result.httpmsg = this.httpmsg;
            result.parsestate = this.parseState;
            result.respcode = this.respcode;
            result.respmsg = this.respmsg;
            result.resultType = getResultType();
            result.timeused = this.timeused;
            result.dns = this.dns;
            result.connect = this.connect;
            result.sslHandshake = this.sslHandshake;
            result.request = this.request;
            result.response = this.response;
            result.latency = this.latency;
            result.reqBodySize = this.reqBodySize;
            result.respBodySize = this.respBodySize;
            result.extra = this.extra;
            result.xcache = this.xcache;
            result.requestTime = this.requestTime;
            result.traceId = this.traceId;
            result.idc = this.idc;
            result.responseBody = this.responseBody;
            result.exception = this.exception;
            return result;
        }

        private int getResultType() {
            if (this.httpcode >= 200 && this.httpcode < 300) {
                if (this.respcode == 0) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
    }
}