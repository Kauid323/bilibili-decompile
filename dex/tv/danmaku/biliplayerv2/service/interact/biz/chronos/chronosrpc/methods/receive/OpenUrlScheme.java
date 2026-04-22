package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OpenUrlScheme.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme;", "", "<init>", "()V", "Request", "BizParams", "ContainerType", "ScreenState", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OpenUrlScheme {

    /* compiled from: OpenUrlScheme.kt */
    @RequestDefine(method = "OpenURLScheme")
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010!\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR \u0010$\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$Request;", "", "<init>", "()V", "scheme", "", "getScheme", "()Ljava/lang/String;", "setScheme", "(Ljava/lang/String;)V", "address", "getAddress", "setAddress", "biz", "getBiz", "setBiz", "needLogin", "", "getNeedLogin", "()Ljava/lang/Boolean;", "setNeedLogin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "needPausePlay", "getNeedPausePlay", "setNeedPausePlay", "containerType", "", "getContainerType", "()Ljava/lang/Integer;", "setContainerType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "screenState", "getScreenState", "setScreenState", "extra", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$BizParams;", "getExtra", "()Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$BizParams;", "setExtra", "(Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$BizParams;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "address")
        private String address;
        @JSONField(name = "biz")
        private String biz;
        @JSONField(name = "container_type")
        private Integer containerType;
        @JSONField(name = "extra")
        private BizParams extra;
        @JSONField(name = "should_login")
        private Boolean needLogin;
        @JSONField(name = "should_pause_play")
        private Boolean needPausePlay;
        @JSONField(name = "scheme")
        private String scheme;
        @JSONField(name = "orientation_state")
        private Integer screenState;

        public final String getScheme() {
            return this.scheme;
        }

        public final void setScheme(String str) {
            this.scheme = str;
        }

        public final String getAddress() {
            return this.address;
        }

        public final void setAddress(String str) {
            this.address = str;
        }

        public final String getBiz() {
            return this.biz;
        }

        public final void setBiz(String str) {
            this.biz = str;
        }

        public final Boolean getNeedLogin() {
            return this.needLogin;
        }

        public final void setNeedLogin(Boolean bool) {
            this.needLogin = bool;
        }

        public final Boolean getNeedPausePlay() {
            return this.needPausePlay;
        }

        public final void setNeedPausePlay(Boolean bool) {
            this.needPausePlay = bool;
        }

        public final Integer getContainerType() {
            return this.containerType;
        }

        public final void setContainerType(Integer num) {
            this.containerType = num;
        }

        public final Integer getScreenState() {
            return this.screenState;
        }

        public final void setScreenState(Integer num) {
            this.screenState = num;
        }

        public final BizParams getExtra() {
            return this.extra;
        }

        public final void setExtra(BizParams bizParams) {
            this.extra = bizParams;
        }
    }

    /* compiled from: OpenUrlScheme.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$BizParams;", "", "<init>", "()V", "operId", "", "getOperId", "()Ljava/lang/String;", "setOperId", "(Ljava/lang/String;)V", "buzzwordId", "getBuzzwordId", "setBuzzwordId", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BizParams {
        @JSONField(name = "buzzword_id")
        private String buzzwordId;
        @JSONField(name = "oper_id")
        private String operId;

        public final String getOperId() {
            return this.operId;
        }

        public final void setOperId(String str) {
            this.operId = str;
        }

        public final String getBuzzwordId() {
            return this.buzzwordId;
        }

        public final void setBuzzwordId(String str) {
            this.buzzwordId = str;
        }
    }

    /* compiled from: OpenUrlScheme.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$ContainerType;", "", "<init>", "()V", "DEFAULT", "", "INNER_PLAYER", "TRANSPARENCY_WEB", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ContainerType {
        public static final int DEFAULT = 0;
        public static final int INNER_PLAYER = 1;
        public static final ContainerType INSTANCE = new ContainerType();
        public static final int TRANSPARENCY_WEB = 2;

        private ContainerType() {
        }
    }

    /* compiled from: OpenUrlScheme.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/OpenUrlScheme$ScreenState;", "", "<init>", "()V", "DEFAULT", "", "PORTRAIT", "LANDSCAPE", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ScreenState {
        public static final int DEFAULT = 0;
        public static final ScreenState INSTANCE = new ScreenState();
        public static final int LANDSCAPE = 2;
        public static final int PORTRAIT = 1;

        private ScreenState() {
        }
    }
}