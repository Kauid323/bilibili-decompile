package tv.danmaku.bili.ui.garb.model;

import ComposableSingletons$CustomBottomSheetKt$;
import android.util.Base64;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.droid.StringUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.InfoEyesOperatingDataPublicQueryString;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: GarbData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0005\u001c\u001d\u001e\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbData;", "", "<init>", "()V", "opGarb", "Ltv/danmaku/bili/ui/garb/model/GarbData$GarbDetail;", "getOpGarb", "()Ltv/danmaku/bili/ui/garb/model/GarbData$GarbDetail;", "setOpGarb", "(Ltv/danmaku/bili/ui/garb/model/GarbData$GarbDetail;)V", "userGarb", "getUserGarb", "setUserGarb", "pureGarb", "", "Ltv/danmaku/bili/ui/garb/model/GarbData$PureGarbDetail;", "getPureGarb", "()Ljava/util/List;", "setPureGarb", "(Ljava/util/List;)V", "loadEquip", "Ltv/danmaku/bili/ui/garb/model/GarbData$LoadEquip;", "getLoadEquip", "()Ltv/danmaku/bili/ui/garb/model/GarbData$LoadEquip;", "setLoadEquip", "(Ltv/danmaku/bili/ui/garb/model/GarbData$LoadEquip;)V", "toString", "", "GarbDetail", "OpConf", "PureGarbDetail", "ColorDetail", "LoadEquip", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbData {
    @JSONField(name = "load_equip")
    private LoadEquip loadEquip;
    @JSONField(name = "common_equip")
    private GarbDetail opGarb;
    @JSONField(name = "skin_colors")
    private List<PureGarbDetail> pureGarb;
    @JSONField(name = "user_equip")
    private GarbDetail userGarb;

    public final GarbDetail getOpGarb() {
        return this.opGarb;
    }

    public final void setOpGarb(GarbDetail garbDetail) {
        this.opGarb = garbDetail;
    }

    public final GarbDetail getUserGarb() {
        return this.userGarb;
    }

    public final void setUserGarb(GarbDetail garbDetail) {
        this.userGarb = garbDetail;
    }

    public final List<PureGarbDetail> getPureGarb() {
        return this.pureGarb;
    }

    public final void setPureGarb(List<PureGarbDetail> list) {
        this.pureGarb = list;
    }

    public final LoadEquip getLoadEquip() {
        return this.loadEquip;
    }

    public final void setLoadEquip(LoadEquip loadEquip) {
        this.loadEquip = loadEquip;
    }

    /* compiled from: GarbData.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010*\u001a\u00020&J\u0006\u0010+\u001a\u00020&J\u0006\u0010,\u001a\u00020&J\b\u0010-\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010'\"\u0004\b(\u0010)¨\u0006."}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbData$GarbDetail;", "", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", ChannelRoutes.CHANNEL_NAME, "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", InfoEyesOperatingDataPublicQueryString.KEY_VER, "getVer", "setVer", "pkgUrl", "getPkgUrl", "setPkgUrl", "pkgMd5", "getPkgMd5", "setPkgMd5", "conf", "Ltv/danmaku/bili/ui/garb/model/GarbData$OpConf;", "getConf", "()Ltv/danmaku/bili/ui/garb/model/GarbData$OpConf;", "setConf", "(Ltv/danmaku/bili/ui/garb/model/GarbData$OpConf;)V", "colorData", "Ltv/danmaku/bili/ui/garb/model/GarbData$ColorDetail;", "getColorData", "()Ltv/danmaku/bili/ui/garb/model/GarbData$ColorDetail;", "setColorData", "(Ltv/danmaku/bili/ui/garb/model/GarbData$ColorDetail;)V", "isOp", "", "()Z", "setOp", "(Z)V", "isForce", "changeable", "primaryPageOnly", "toString", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class GarbDetail {
        @JSONField(name = "data")
        private ColorDetail colorData;
        @JSONField(name = "conf")
        private OpConf conf;
        @JSONField(name = "id")
        private long id;
        private boolean isOp;
        @JSONField(name = ChannelRoutes.CHANNEL_NAME)
        private String name;
        @JSONField(name = "package_md5")
        private String pkgMd5;
        @JSONField(name = "package_url")
        private String pkgUrl;
        @JSONField(name = InfoEyesOperatingDataPublicQueryString.KEY_VER)
        private long ver;

        public final long getId() {
            return this.id;
        }

        public final void setId(long j) {
            this.id = j;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final long getVer() {
            return this.ver;
        }

        public final void setVer(long j) {
            this.ver = j;
        }

        public final String getPkgUrl() {
            return this.pkgUrl;
        }

        public final void setPkgUrl(String str) {
            this.pkgUrl = str;
        }

        public final String getPkgMd5() {
            return this.pkgMd5;
        }

        public final void setPkgMd5(String str) {
            this.pkgMd5 = str;
        }

        public final OpConf getConf() {
            return this.conf;
        }

        public final void setConf(OpConf opConf) {
            this.conf = opConf;
        }

        public final ColorDetail getColorData() {
            return this.colorData;
        }

        public final void setColorData(ColorDetail colorDetail) {
            this.colorData = colorDetail;
        }

        public final boolean isOp() {
            return this.isOp;
        }

        public final void setOp(boolean z) {
            this.isOp = z;
        }

        public final boolean isForce() {
            if (this.conf == null) {
                return false;
            }
            OpConf opConf = this.conf;
            Intrinsics.checkNotNull(opConf);
            return (opConf.getAttr() & 1) == 1;
        }

        public final boolean changeable() {
            if (this.conf == null) {
                return true;
            }
            OpConf opConf = this.conf;
            Intrinsics.checkNotNull(opConf);
            return ((opConf.getAttr() >> 1) & 1) == 1;
        }

        public final boolean primaryPageOnly() {
            if (this.conf == null) {
                return false;
            }
            OpConf opConf = this.conf;
            Intrinsics.checkNotNull(opConf);
            return ((opConf.getAttr() >> 2) & 1) == 1;
        }

        public String toString() {
            long j = this.id;
            String str = this.name;
            long j2 = this.ver;
            String str2 = this.pkgUrl;
            String str3 = this.pkgMd5;
            OpConf opConf = this.conf;
            ColorDetail colorDetail = this.colorData;
            return "GarbDetail(id=" + j + ", name=" + str + ", ver=" + j2 + ", pkgUrl=" + str2 + ", pkgMd5=" + str3 + ", conf=" + opConf + ", colorData=" + colorDetail + ", isOp=" + this.isOp + ")";
        }
    }

    /* compiled from: GarbData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020\u0005H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbData$OpConf;", "", "<init>", "()V", "alias", "", "getAlias", "()Ljava/lang/String;", "setAlias", "(Ljava/lang/String;)V", "attr", "", "getAttr", "()I", "setAttr", "(I)V", "start", "", "getStart", "()J", "setStart", "(J)V", "end", "getEnd", "setEnd", "hideDialog", "", "getHideDialog", "()Z", "setHideDialog", "(Z)V", "toString", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OpConf {
        @JSONField(name = "alias")
        private String alias;
        @JSONField(name = "attribute")
        private int attr;
        @JSONField(name = "etime")
        private long end;
        @JSONField(name = "hide_dialog")
        private boolean hideDialog;
        @JSONField(name = "stime")
        private long start;

        public final String getAlias() {
            return this.alias;
        }

        public final void setAlias(String str) {
            this.alias = str;
        }

        public final int getAttr() {
            return this.attr;
        }

        public final void setAttr(int i) {
            this.attr = i;
        }

        public final long getStart() {
            return this.start;
        }

        public final void setStart(long j) {
            this.start = j;
        }

        public final long getEnd() {
            return this.end;
        }

        public final void setEnd(long j) {
            this.end = j;
        }

        public final boolean getHideDialog() {
            return this.hideDialog;
        }

        public final void setHideDialog(boolean z) {
            this.hideDialog = z;
        }

        public String toString() {
            String str = this.alias;
            int i = this.attr;
            long j = this.start;
            return "OpConf(alias=" + str + ", attr=" + i + ", start=" + j + ", end=" + this.end + ")";
        }
    }

    /* compiled from: GarbData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010)\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001e\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0007\"\u0004\b%\u0010\tR\u001e\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\t¨\u0006+"}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbData$PureGarbDetail;", "", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", ChannelRoutes.CHANNEL_NAME, "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "colorName", "getColorName", "setColorName", "isFree", "", "()Z", "setFree", "(Z)V", "isBought", "setBought", "price", "", "getPrice", "()I", "setPrice", "(I)V", "status", "getStatus", "setStatus", "buyTime", "getBuyTime", "setBuyTime", "dueTime", "getDueTime", "setDueTime", "toString", "Companion", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class PureGarbDetail {
        public static final Companion Companion = new Companion(null);
        public static final int STATUS_BOUGHT = 1;
        public static final int STATUS_CANCELED = 4;
        public static final int STATUS_RENEW = 2;
        public static final int STATUS_RENEW_FAILED = 3;
        @JSONField(name = "buy_time")
        private long buyTime;
        @JSONField(name = "due_time")
        private long dueTime;
        @JSONField(name = "id")
        private long id;
        @JSONField(name = "is_bought")
        private boolean isBought;
        @JSONField(name = "is_free")
        private boolean isFree;
        @JSONField(name = "price")
        private int price;
        @JSONField(name = "status")
        private int status;
        @JSONField(name = ChannelRoutes.CHANNEL_NAME)
        private String name = "";
        @JSONField(name = "color_name")
        private String colorName = "";

        /* compiled from: GarbData.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbData$PureGarbDetail$Companion;", "", "<init>", "()V", "STATUS_BOUGHT", "", "STATUS_RENEW", "STATUS_RENEW_FAILED", "STATUS_CANCELED", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final long getId() {
            return this.id;
        }

        public final void setId(long j) {
            this.id = j;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final String getColorName() {
            return this.colorName;
        }

        public final void setColorName(String str) {
            this.colorName = str;
        }

        public final boolean isFree() {
            return this.isFree;
        }

        public final void setFree(boolean z) {
            this.isFree = z;
        }

        public final boolean isBought() {
            return this.isBought;
        }

        public final void setBought(boolean z) {
            this.isBought = z;
        }

        public final int getPrice() {
            return this.price;
        }

        public final void setPrice(int i) {
            this.price = i;
        }

        public final int getStatus() {
            return this.status;
        }

        public final void setStatus(int i) {
            this.status = i;
        }

        public final long getBuyTime() {
            return this.buyTime;
        }

        public final void setBuyTime(long j) {
            this.buyTime = j;
        }

        public final long getDueTime() {
            return this.dueTime;
        }

        public final void setDueTime(long j) {
            this.dueTime = j;
        }

        public String toString() {
            long j = this.id;
            String str = this.name;
            String str2 = this.colorName;
            boolean z = this.isFree;
            boolean z2 = this.isBought;
            int i = this.price;
            int i2 = this.status;
            long j2 = this.buyTime;
            return "PureGarbDetail(id=" + j + ", name=" + str + ", colorName=" + str2 + ", isFree=" + z + ", isBought=" + z2 + ", price=" + i + ", status=" + i2 + ", buyTime=" + j2 + ", dueTime=" + this.dueTime + ")";
        }
    }

    /* compiled from: GarbData.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b(\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010@\u001a\u00020\u001dJ\u0006\u0010A\u001a\u00020\u001dJ\u0006\u0010B\u001a\u00020\u001dJ\u0006\u0010C\u001a\u00020\u001dR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR \u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR \u0010(\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR \u0010+\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR \u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR \u00101\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR \u00104\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR \u00107\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR \u0010:\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR \u0010=\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\t¨\u0006E"}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbData$ColorDetail;", "", "<init>", "()V", LoginReporterV2.Click.SIGNUP_KEY_MODE, "", "getMode", "()Ljava/lang/String;", "setMode", "(Ljava/lang/String;)V", "primaryColor", "getPrimaryColor", "setPrimaryColor", "secondaryColor", "getSecondaryColor", "setSecondaryColor", "sideBgColor", "getSideBgColor", "setSideBgColor", "sideLineColor", "getSideLineColor", "setSideLineColor", "tailColor", "getTailColor", "setTailColor", "tailSelectedColor", "getTailSelectedColor", "setTailSelectedColor", "hasAnimate", "", "getHasAnimate", "()Z", "setHasAnimate", "(Z)V", "animateMode", "getAnimateMode", "setAnimateMode", "headMyselfPlayMode", "getHeadMyselfPlayMode", "setHeadMyselfPlayMode", "btnBgStartColor", "getBtnBgStartColor", "setBtnBgStartColor", "btnBgEndColor", "getBtnBgEndColor", "setBtnBgEndColor", "btnIconColor", "getBtnIconColor", "setBtnIconColor", "tailIconModel", "getTailIconModel", "setTailIconModel", "tailIconColor", "getTailIconColor", "setTailIconColor", "tailIconColorNight", "getTailIconColorNight", "setTailIconColorNight", "tailIconColorSelected", "getTailIconColorSelected", "setTailIconColorSelected", "tailIconColorSelectedNight", "getTailIconColorSelectedNight", "setTailIconColorSelectedNight", "isTailColorModel", "isDarkMode", "isAnimateLoop", "isMyselfAnimateLoop", "Companion", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ColorDetail {
        public static final String CYCLE_ANIMATE = "cycle";
        public static final Companion Companion = new Companion(null);
        public static final String DARK_THEME = "dark";
        public static final String LIGHT_THEME = "light";
        public static final String LOOP_ANIMATE = "loop";
        public static final String ONCE_ANIMATE = "once";
        @JSONField(name = "tail_icon_ani_mode")
        private String animateMode;
        @JSONField(name = "tail_icon_ani")
        private boolean hasAnimate;
        @JSONField(name = "head_myself_mp4_play")
        private String headMyselfPlayMode;
        @JSONField(name = "color_mode")
        private String mode;
        @JSONField(name = GarbJsBridgeCallHandlerKt.PURE_THEME)
        private String primaryColor;
        @JSONField(name = "color_second_page")
        private String secondaryColor;
        @JSONField(name = "side_bg_color")
        private String sideBgColor;
        @JSONField(name = "side_line_color")
        private String sideLineColor;
        @JSONField(name = "tail_color")
        private String tailColor;
        @JSONField(name = "tail_icon_color")
        private String tailIconColor;
        @JSONField(name = "tail_icon_color_dark")
        private String tailIconColorNight;
        @JSONField(name = "tail_icon_color_selected")
        private String tailIconColorSelected;
        @JSONField(name = "tail_icon_color_selected_dark")
        private String tailIconColorSelectedNight;
        @JSONField(name = "tail_icon_mode")
        private String tailIconModel;
        @JSONField(name = "tail_color_selected")
        private String tailSelectedColor;
        @JSONField(name = "pub_btn_shade_color_top")
        private String btnBgStartColor = "";
        @JSONField(name = "pub_btn_shade_color_bottom")
        private String btnBgEndColor = "";
        @JSONField(name = "pub_btn_plus_color")
        private String btnIconColor = "";

        /* compiled from: GarbData.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbData$ColorDetail$Companion;", "", "<init>", "()V", "LIGHT_THEME", "", "DARK_THEME", "ONCE_ANIMATE", "CYCLE_ANIMATE", "LOOP_ANIMATE", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public final String getMode() {
            return this.mode;
        }

        public final void setMode(String str) {
            this.mode = str;
        }

        public final String getPrimaryColor() {
            return this.primaryColor;
        }

        public final void setPrimaryColor(String str) {
            this.primaryColor = str;
        }

        public final String getSecondaryColor() {
            return this.secondaryColor;
        }

        public final void setSecondaryColor(String str) {
            this.secondaryColor = str;
        }

        public final String getSideBgColor() {
            return this.sideBgColor;
        }

        public final void setSideBgColor(String str) {
            this.sideBgColor = str;
        }

        public final String getSideLineColor() {
            return this.sideLineColor;
        }

        public final void setSideLineColor(String str) {
            this.sideLineColor = str;
        }

        public final String getTailColor() {
            return this.tailColor;
        }

        public final void setTailColor(String str) {
            this.tailColor = str;
        }

        public final String getTailSelectedColor() {
            return this.tailSelectedColor;
        }

        public final void setTailSelectedColor(String str) {
            this.tailSelectedColor = str;
        }

        public final boolean getHasAnimate() {
            return this.hasAnimate;
        }

        public final void setHasAnimate(boolean z) {
            this.hasAnimate = z;
        }

        public final String getAnimateMode() {
            return this.animateMode;
        }

        public final void setAnimateMode(String str) {
            this.animateMode = str;
        }

        public final String getHeadMyselfPlayMode() {
            return this.headMyselfPlayMode;
        }

        public final void setHeadMyselfPlayMode(String str) {
            this.headMyselfPlayMode = str;
        }

        public final String getBtnBgStartColor() {
            return this.btnBgStartColor;
        }

        public final void setBtnBgStartColor(String str) {
            this.btnBgStartColor = str;
        }

        public final String getBtnBgEndColor() {
            return this.btnBgEndColor;
        }

        public final void setBtnBgEndColor(String str) {
            this.btnBgEndColor = str;
        }

        public final String getBtnIconColor() {
            return this.btnIconColor;
        }

        public final void setBtnIconColor(String str) {
            this.btnIconColor = str;
        }

        public final String getTailIconModel() {
            return this.tailIconModel;
        }

        public final void setTailIconModel(String str) {
            this.tailIconModel = str;
        }

        public final String getTailIconColor() {
            return this.tailIconColor;
        }

        public final void setTailIconColor(String str) {
            this.tailIconColor = str;
        }

        public final String getTailIconColorNight() {
            return this.tailIconColorNight;
        }

        public final void setTailIconColorNight(String str) {
            this.tailIconColorNight = str;
        }

        public final String getTailIconColorSelected() {
            return this.tailIconColorSelected;
        }

        public final void setTailIconColorSelected(String str) {
            this.tailIconColorSelected = str;
        }

        public final String getTailIconColorSelectedNight() {
            return this.tailIconColorSelectedNight;
        }

        public final void setTailIconColorSelectedNight(String str) {
            this.tailIconColorSelectedNight = str;
        }

        public final boolean isTailColorModel() {
            return Intrinsics.areEqual(this.tailIconModel, GarbJsBridgeCallHandlerKt.PURE_THEME);
        }

        public final boolean isDarkMode() {
            return Intrinsics.areEqual(LIGHT_THEME, this.mode);
        }

        public final boolean isAnimateLoop() {
            return Intrinsics.areEqual("cycle", this.animateMode);
        }

        public final boolean isMyselfAnimateLoop() {
            return Intrinsics.areEqual(LOOP_ANIMATE, this.headMyselfPlayMode);
        }
    }

    /* compiled from: GarbData.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0013\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006 "}, d2 = {"Ltv/danmaku/bili/ui/garb/model/GarbData$LoadEquip;", "", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", ChannelRoutes.CHANNEL_NAME, "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "version", "getVersion", "setVersion", "url", "getUrl", "setUrl", "isNeedUpdate", "", "origin", "isIllegal", "getFileName", "equals", "other", "hashCode", "", "toString", "theme_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class LoadEquip {
        @JSONField(name = "id")
        private long id;
        @JSONField(name = ChannelRoutes.CHANNEL_NAME)
        private String name;
        @JSONField(name = "loading_url")
        private String url;
        @JSONField(name = InfoEyesOperatingDataPublicQueryString.KEY_VER)
        private long version;

        public final long getId() {
            return this.id;
        }

        public final void setId(long j) {
            this.id = j;
        }

        public final String getName() {
            return this.name;
        }

        public final void setName(String str) {
            this.name = str;
        }

        public final long getVersion() {
            return this.version;
        }

        public final void setVersion(long j) {
            this.version = j;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final boolean isNeedUpdate(LoadEquip origin) {
            return origin == null || this.version != origin.version;
        }

        public final boolean isIllegal() {
            return StringUtil.isBlank(this.url);
        }

        public final String getFileName() {
            if (StringUtil.isBlank(this.url)) {
                return "";
            }
            String str = this.url;
            Intrinsics.checkNotNull(str);
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            String encodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
            return encodeToString;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                Intrinsics.checkNotNull(other, "null cannot be cast to non-null type tv.danmaku.bili.ui.garb.model.GarbData.LoadEquip");
                LoadEquip loadEquip = (LoadEquip) other;
                return this.id == ((LoadEquip) other).id && Intrinsics.areEqual(this.name, ((LoadEquip) other).name) && this.version == ((LoadEquip) other).version && Intrinsics.areEqual(this.url, ((LoadEquip) other).url);
            }
            return false;
        }

        public int hashCode() {
            int result = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id);
            int i = result * 31;
            String str = this.name;
            int result2 = i + (str != null ? str.hashCode() : 0);
            int result3 = ((result2 * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version)) * 31;
            String str2 = this.url;
            return result3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            long j = this.id;
            String str = this.name;
            long j2 = this.version;
            return "LoadEquip(id=" + j + ", name=" + str + ", version=" + j2 + ", url=" + this.url + ")";
        }
    }

    public String toString() {
        GarbDetail garbDetail = this.opGarb;
        GarbDetail garbDetail2 = this.userGarb;
        List<PureGarbDetail> list = this.pureGarb;
        return "GarbData(opGarb=" + garbDetail + ", userGarb=" + garbDetail2 + ", pureGarb=" + list + ", loadEquip=" + this.loadEquip + ")";
    }
}