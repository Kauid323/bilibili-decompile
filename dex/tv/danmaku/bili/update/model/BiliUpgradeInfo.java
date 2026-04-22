package tv.danmaku.bili.update.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BiliUpgradeInfo.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0001\\B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0014H\u0016J\b\u0010T\u001a\u00020\u0014H\u0016J\u0006\u0010U\u001a\u00020VJ\u0006\u0010W\u001a\u00020\u0014J\b\u0010X\u001a\u0004\u0018\u00010\bJ\u0006\u0010Y\u001a\u00020VJ\u0006\u0010Z\u001a\u00020VJ\b\u0010[\u001a\u00020\bH\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR \u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R*\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020&0,8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010\u0003\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R$\u00105\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u0010\u0016\"\u0004\b8\u0010\u0018R$\u00109\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u0010\u0003\u001a\u0004\b;\u0010\u0016\"\u0004\b<\u0010\u0018R\u001e\u0010=\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001f\"\u0004\b?\u0010!R$\u0010@\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010\u0003\u001a\u0004\bB\u0010\u0016\"\u0004\bC\u0010\u0018R&\u0010D\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bE\u0010\u0003\u001a\u0004\bF\u0010\n\"\u0004\bG\u0010\fR\u001e\u0010H\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0016\"\u0004\bI\u0010\u0018R \u0010J\u001a\u0004\u0018\u00010K8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006]"}, d2 = {"Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "version", "getVersion", "setVersion", "version_code", "", "getVersion_code", "()I", "setVersion_code", "(I)V", "url", "getUrl", "setUrl", "size", "", "getSize", "()J", "setSize", "(J)V", "md5", "getMd5", "setMd5", "patch", "Ltv/danmaku/bili/update/model/Patch;", "getPatch", "()Ltv/danmaku/bili/update/model/Patch;", "setPatch", "(Ltv/danmaku/bili/update/model/Patch;)V", "patch_map", "", "getPatch_map", "()Ljava/util/Map;", "setPatch_map", "(Ljava/util/Map;)V", "silent", "getSilent$annotations", "getSilent", "setSilent", "upgrade_type", "getUpgrade_type$annotations", "getUpgrade_type", "setUpgrade_type", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_CYCLE, "getCycle$annotations", "getCycle", "setCycle", "ptime", "getPtime", "setPtime", "policy", "getPolicy$annotations", "getPolicy", "setPolicy", "policy_url", "getPolicy_url$annotations", "getPolicy_url", "setPolicy_url", "isGray", "setGray", "apkPath", "Ljava/io/File;", "getApkPath", "()Ljava/io/File;", "setApkPath", "(Ljava/io/File;)V", "writeToParcel", "", "dest", "flags", "describeContents", "forceUpgrade", "", "versionCode", "getPolicyUrl", "grayTest", "silentDownload", "toString", "CREATOR", "updateapi_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliUpgradeInfo implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    @JSONField(deserialize = false, serialize = false)
    private File apkPath;
    @JSONField(name = "content")
    private String content;
    @JSONField(name = BusinessSplashDefineKt.SPLASH_OPEN_EVENT_CYCLE)
    private int cycle;
    @JSONField(name = "is_gray")
    private int isGray;
    @JSONField(name = "md5")
    private String md5;
    @JSONField(name = "patch")
    private Patch patch;
    @JSONField(name = "patch_map")
    private Map<String, Patch> patch_map;
    @JSONField(name = "policy")
    private int policy;
    @JSONField(name = "policy_url")
    private String policy_url;
    @JSONField(name = "ptime")
    private long ptime;
    @JSONField(name = "silent")
    private int silent;
    @JSONField(name = "size")
    private long size;
    @JSONField(name = RankRouter.BundleKey.ACTION_PARAM_TITLE)
    private String title;
    @JSONField(name = "upgrade_type")
    private int upgrade_type;
    @JSONField(name = "url")
    private String url;
    @JSONField(name = "version")
    private String version;
    @JSONField(name = "version_code")
    private int version_code;

    public static /* synthetic */ void getCycle$annotations() {
    }

    public static /* synthetic */ void getPolicy$annotations() {
    }

    public static /* synthetic */ void getPolicy_url$annotations() {
    }

    public static /* synthetic */ void getSilent$annotations() {
    }

    public static /* synthetic */ void getUpgrade_type$annotations() {
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        this.content = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final int getVersion_code() {
        return this.version_code;
    }

    public final void setVersion_code(int i) {
        this.version_code = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final long getSize() {
        return this.size;
    }

    public final void setSize(long j) {
        this.size = j;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final Patch getPatch() {
        return this.patch;
    }

    public final void setPatch(Patch patch) {
        this.patch = patch;
    }

    public final Map<String, Patch> getPatch_map() {
        return this.patch_map;
    }

    public final void setPatch_map(Map<String, Patch> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.patch_map = map;
    }

    public final int getSilent() {
        return this.silent;
    }

    public final void setSilent(int i) {
        this.silent = i;
    }

    public final int getUpgrade_type() {
        return this.upgrade_type;
    }

    public final void setUpgrade_type(int i) {
        this.upgrade_type = i;
    }

    public final int getCycle() {
        return this.cycle;
    }

    public final void setCycle(int i) {
        this.cycle = i;
    }

    public final long getPtime() {
        return this.ptime;
    }

    public final void setPtime(long j) {
        this.ptime = j;
    }

    public final int getPolicy() {
        return this.policy;
    }

    public final void setPolicy(int i) {
        this.policy = i;
    }

    public final String getPolicy_url() {
        return this.policy_url;
    }

    public final void setPolicy_url(String str) {
        this.policy_url = str;
    }

    public final int isGray() {
        return this.isGray;
    }

    public final void setGray(int i) {
        this.isGray = i;
    }

    public final File getApkPath() {
        return this.apkPath;
    }

    public final void setApkPath(File file) {
        this.apkPath = file;
    }

    public BiliUpgradeInfo() {
        this.patch_map = new HashMap();
        this.isGray = -1;
    }

    public BiliUpgradeInfo(Parcel in) {
        Intrinsics.checkNotNullParameter(in, "in");
        this.patch_map = new HashMap();
        this.isGray = -1;
        this.title = in.readString();
        this.content = in.readString();
        this.version = in.readString();
        this.version_code = in.readInt();
        this.url = in.readString();
        this.size = in.readLong();
        this.md5 = in.readString();
        this.patch = (Patch) in.readParcelable(Patch.class.getClassLoader());
        try {
            HashMap out = new HashMap();
            in.readMap(out, Patch.class.getClassLoader());
            this.patch_map = out;
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.silent = in.readInt();
        this.upgrade_type = in.readInt();
        this.cycle = in.readInt();
        this.ptime = in.readLong();
        this.policy = in.readInt();
        this.policy_url = in.readString();
        this.isGray = in.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.title);
        dest.writeString(this.content);
        dest.writeString(this.version);
        dest.writeInt(this.version_code);
        dest.writeString(this.url);
        dest.writeLong(this.size);
        dest.writeString(this.md5);
        dest.writeParcelable(this.patch, flags);
        try {
            dest.writeMap(this.patch_map);
        } catch (Exception e) {
        }
        dest.writeInt(this.silent);
        dest.writeInt(this.upgrade_type);
        dest.writeInt(this.cycle);
        dest.writeLong(this.ptime);
        dest.writeInt(this.policy);
        dest.writeString(this.policy_url);
        dest.writeInt(this.isGray);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: BiliUpgradeInfo.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/update/model/BiliUpgradeInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/update/model/BiliUpgradeInfo;", "updateapi_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CREATOR implements Parcelable.Creator<BiliUpgradeInfo> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public BiliUpgradeInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BiliUpgradeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BiliUpgradeInfo[] newArray(int size) {
            return new BiliUpgradeInfo[size];
        }
    }

    public final boolean forceUpgrade() {
        return 2 == this.upgrade_type;
    }

    public final int versionCode() {
        return this.version_code;
    }

    public final String getPolicyUrl() {
        return this.policy_url;
    }

    public final boolean grayTest() {
        return this.isGray != 0;
    }

    public final boolean silentDownload() {
        return this.silent == 1;
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("{version=%s,silent=%b,force=%b}", Arrays.copyOf(new Object[]{this.version, Boolean.valueOf(silentDownload()), Boolean.valueOf(forceUpgrade())}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }
}