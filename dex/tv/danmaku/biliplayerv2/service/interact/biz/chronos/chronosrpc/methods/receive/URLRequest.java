package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.common.chronoscommon.message.ResponseDefine;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: URLRequest.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/URLRequest;", "", "<init>", "()V", "Request", "Response", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class URLRequest {

    /* compiled from: URLRequest.kt */
    @RequestDefine(method = "URLRequest")
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR,\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR,\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010 \u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\"\u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(¨\u0006-"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/URLRequest$Request;", "", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "header", "", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "method", "getMethod", "setMethod", "parameters", "getParameters", "setParameters", "files", "getFiles", "setFiles", "timeout", "", "getTimeout", "()Ljava/lang/Integer;", "setTimeout", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", IjkMediaMeta.IJKM_KEY_FORMAT, "getFormat", "setFormat", "ungzip", "", "getUngzip", "()Ljava/lang/Boolean;", "setUngzip", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "scmActionId", "getScmActionId", "setScmActionId", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "files")
        private Map<String, String> files;
        @JSONField(name = IjkMediaMeta.IJKM_KEY_FORMAT)
        private String format;
        @JSONField(name = "header")
        private Map<String, String> header;
        @JSONField(name = "method")
        private String method;
        @JSONField(name = "parameters")
        private Map<String, String> parameters;
        @JSONField(name = "scm_action_id")
        private Boolean scmActionId;
        @JSONField(name = "timeout")
        private Integer timeout;
        @JSONField(name = "ungzip")
        private Boolean ungzip;
        @JSONField(name = "url")
        private String url;

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final Map<String, String> getHeader() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.header);
        }

        public final void setHeader(Map<String, String> map) {
            this.header = map;
        }

        public final String getMethod() {
            return this.method;
        }

        public final void setMethod(String str) {
            this.method = str;
        }

        public final Map<String, String> getParameters() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.parameters);
        }

        public final void setParameters(Map<String, String> map) {
            this.parameters = map;
        }

        public final Map<String, String> getFiles() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.files);
        }

        public final void setFiles(Map<String, String> map) {
            this.files = map;
        }

        public final Integer getTimeout() {
            return this.timeout;
        }

        public final void setTimeout(Integer num) {
            this.timeout = num;
        }

        public final String getFormat() {
            return this.format;
        }

        public final void setFormat(String str) {
            this.format = str;
        }

        public final Boolean getUngzip() {
            return this.ungzip;
        }

        public final void setUngzip(Boolean bool) {
            this.ungzip = bool;
        }

        public final Boolean getScmActionId() {
            return this.scmActionId;
        }

        public final void setScmActionId(Boolean bool) {
            this.scmActionId = bool;
        }
    }

    /* compiled from: URLRequest.kt */
    @ResponseDefine
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR>\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001a"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/URLRequest$Response;", "", "<init>", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "header", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getHeader", "()Ljava/util/HashMap;", "setHeader", "(Ljava/util/HashMap;)V", "content", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", IjkMediaMeta.IJKM_KEY_FORMAT, "getFormat", "setFormat", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Response {
        @JSONField(name = "code")
        private int code;
        @JSONField(name = "content")
        private String content;
        @JSONField(name = IjkMediaMeta.IJKM_KEY_FORMAT)
        private String format;
        @JSONField(name = "header")
        private HashMap<String, Object> header;

        public final int getCode() {
            return this.code;
        }

        public final void setCode(int i) {
            this.code = i;
        }

        public final HashMap<String, Object> getHeader() {
            return this.header;
        }

        public final void setHeader(HashMap<String, Object> hashMap) {
            this.header = hashMap;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final String getFormat() {
            return this.format;
        }

        public final void setFormat(String str) {
            this.format = str;
        }
    }
}