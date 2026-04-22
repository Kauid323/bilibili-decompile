package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.common.chronoscommon.message.ResponseDefine;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CommandDmListRequest.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/CommandDmListRequest;", "", "<init>", "()V", "Request", "Response", "CommandDmItem", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class CommandDmListRequest {

    /* compiled from: CommandDmListRequest.kt */
    @RequestDefine(method = "CommandDmListRequest")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/CommandDmListRequest$Request;", "", "<init>", "()V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
    }

    /* compiled from: CommandDmListRequest.kt */
    @ResponseDefine
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/CommandDmListRequest$Response;", "", "<init>", "()V", "danmakuList", "", "Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/CommandDmListRequest$CommandDmItem;", "getDanmakuList", "()Ljava/util/List;", "setDanmakuList", "(Ljava/util/List;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Response {
        @JSONField(name = "command_list")
        private List<CommandDmItem> danmakuList;

        public final List<CommandDmItem> getDanmakuList() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.danmakuList);
        }

        public final void setDanmakuList(List<CommandDmItem> list) {
            this.danmakuList = list;
        }
    }

    /* compiled from: CommandDmListRequest.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR \u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\"\u0010%\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R\"\u00105\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010*\u001a\u0004\b6\u0010'\"\u0004\b7\u0010)¨\u00068"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/CommandDmListRequest$CommandDmItem;", "", "<init>", "()V", "danmakuId", "", "getDanmakuId", "()Ljava/lang/String;", "setDanmakuId", "(Ljava/lang/String;)V", "oid", "getOid", "setOid", RankRouter.BundleKey.AUTHOR_SPACE_MID, "getMid", "setMid", "command", "getCommand", "setCommand", "content", "getContent", "setContent", "progress", "", "getProgress", "()J", "setProgress", "(J)V", "ctime", "getCtime", "setCtime", "mtime", "getMtime", "setMtime", "extra", "getExtra", "setExtra", "type", "getType", "()Ljava/lang/Long;", "setType", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "autoCreate", "", "getAutoCreate", "()Ljava/lang/Boolean;", "setAutoCreate", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "countDown", "getCountDown", "setCountDown", "attr", "getAttr", "setAttr", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CommandDmItem {
        @JSONField(name = "attr")
        private Long attr;
        @JSONField(name = "autoCreate")
        private Boolean autoCreate;
        @JSONField(name = "command")
        private String command;
        @JSONField(name = "content")
        private String content;
        @JSONField(name = "countDown")
        private Long countDown;
        @JSONField(name = "ctime")
        private String ctime;
        @JSONField(name = "danmaku_id")
        private String danmakuId;
        @JSONField(name = "extra")
        private String extra;
        @JSONField(name = RankRouter.BundleKey.AUTHOR_SPACE_MID)
        private String mid;
        @JSONField(name = "mtime")
        private String mtime;
        @JSONField(name = "oid")
        private String oid;
        @JSONField(name = "progress")
        private long progress;
        @JSONField(name = "type")
        private Long type;

        public final String getDanmakuId() {
            return this.danmakuId;
        }

        public final void setDanmakuId(String str) {
            this.danmakuId = str;
        }

        public final String getOid() {
            return this.oid;
        }

        public final void setOid(String str) {
            this.oid = str;
        }

        public final String getMid() {
            return this.mid;
        }

        public final void setMid(String str) {
            this.mid = str;
        }

        public final String getCommand() {
            return this.command;
        }

        public final void setCommand(String str) {
            this.command = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final long getProgress() {
            return this.progress;
        }

        public final void setProgress(long j) {
            this.progress = j;
        }

        public final String getCtime() {
            return this.ctime;
        }

        public final void setCtime(String str) {
            this.ctime = str;
        }

        public final String getMtime() {
            return this.mtime;
        }

        public final void setMtime(String str) {
            this.mtime = str;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final void setExtra(String str) {
            this.extra = str;
        }

        public final Long getType() {
            return this.type;
        }

        public final void setType(Long l) {
            this.type = l;
        }

        public final Boolean getAutoCreate() {
            return this.autoCreate;
        }

        public final void setAutoCreate(Boolean bool) {
            this.autoCreate = bool;
        }

        public final Long getCountDown() {
            return this.countDown;
        }

        public final void setCountDown(Long l) {
            this.countDown = l;
        }

        public final Long getAttr() {
            return this.attr;
        }

        public final void setAttr(Long l) {
            this.attr = l;
        }
    }
}