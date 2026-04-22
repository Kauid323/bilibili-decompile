package tv.danmaku.bili.ui.splash.brand.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.comm.realtime.RealTime;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.resmanager.ResResponse;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.bili.ui.splash.common.search.QueryItem;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BrandShowInfo.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u0000 d2\u00020\u0001:\u0001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020)H\u0016J\b\u0010[\u001a\u00020)H\u0016J\u0013\u0010\\\u001a\u0002022\b\u0010]\u001a\u0004\u0018\u00010^H\u0096\u0002J\b\u0010_\u001a\u00020)H\u0016J\u0006\u0010`\u001a\u000202J\u0006\u0010a\u001a\u000202J\u0006\u0010b\u001a\u000202J\u0006\u0010c\u001a\u000202R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u001a\u00108\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010+\"\u0004\b:\u0010-R\u001a\u0010;\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00103\"\u0004\b<\u00105R\u001a\u0010=\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u00103\"\u0004\b>\u00105R\u001c\u0010?\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\n\"\u0004\bA\u0010\fR\u001a\u0010B\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u00103\"\u0004\bD\u00105R\u001a\u0010E\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010+\"\u0004\bG\u0010-R\u001c\u0010H\u001a\u0004\u0018\u00010IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u0010N\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u00103\"\u0004\bP\u00105R \u0010Q\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006e"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "setId", "(J)V", "thumb", "getThumb", "setThumb", "thumbHash", "getThumbHash", "setThumbHash", "thumbName", "getThumbName", "setThumbName", "logoUrl", "getLogoUrl", "setLogoUrl", "logoHash", "getLogoHash", "setLogoHash", "beginTime", "getBeginTime", "setBeginTime", "endTime", "getEndTime", "setEndTime", "probability", "", "getProbability", "()I", "setProbability", "(I)V", "duration", "getDuration", "setDuration", "isSelected", "", "()Z", "setSelected", "(Z)V", "isDefault", "setDefault", "reportFlag", "getReportFlag", "setReportFlag", "isForce", "setForce", "isCustom", "setCustom", "mode", "getMode", "setMode", "showLogo", "getShowLogo", "setShowLogo", "forceShowTimes", "getForceShowTimes", "setForceShowTimes", "queryItem", "Ltv/danmaku/bili/ui/splash/common/search/QueryItem;", "getQueryItem", "()Ltv/danmaku/bili/ui/splash/common/search/QueryItem;", "setQueryItem", "(Ltv/danmaku/bili/ui/splash/common/search/QueryItem;)V", "locked", "getLocked", "setLocked", "localBitmap", "Landroid/graphics/Bitmap;", "getLocalBitmap", "()Landroid/graphics/Bitmap;", "setLocalBitmap", "(Landroid/graphics/Bitmap;)V", "writeToParcel", "", "dest", "flags", "describeContents", "equals", "other", "", "hashCode", "isVipSplash", "isValid", "isValidIgnoreRes", "isTimeValid", "CREATOR", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandShowInfo implements Parcelable {
    public static final int FLAG_CUSTOM = 2;
    public static final int FLAG_DEFAULT = 1;
    public static final int FLAG_FALLBACK = 3;
    public static final int FLAG_FORE = 4;
    public static final int FLAG_NONE = 5;
    private long beginTime;
    private long duration;
    private long endTime;
    private int forceShowTimes;
    private long id;
    private boolean isCustom;
    private boolean isDefault;
    private boolean isForce;
    private boolean isSelected;
    @JSONField(deserialize = false, serialize = false)
    private Bitmap localBitmap;
    private boolean locked;
    private String logoHash;
    private String logoUrl;
    private String mode;
    private int probability;
    private QueryItem queryItem;
    private int reportFlag;
    private boolean showLogo;
    private String source;
    private String thumb;
    private String thumbHash;
    private String thumbName;
    public static final CREATOR CREATOR = new CREATOR(null);
    public static final int $stable = 8;

    public BrandShowInfo() {
        this.source = BrandSplashSource.BRAND.getValue();
        this.thumb = "";
        this.thumbHash = "";
        this.thumbName = "";
        this.logoUrl = "";
        this.logoHash = "";
        this.reportFlag = 1;
        this.mode = "half";
        this.showLogo = true;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getThumb() {
        return this.thumb;
    }

    public final void setThumb(String str) {
        this.thumb = str;
    }

    public final String getThumbHash() {
        return this.thumbHash;
    }

    public final void setThumbHash(String str) {
        this.thumbHash = str;
    }

    public final String getThumbName() {
        return this.thumbName;
    }

    public final void setThumbName(String str) {
        this.thumbName = str;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public final String getLogoHash() {
        return this.logoHash;
    }

    public final void setLogoHash(String str) {
        this.logoHash = str;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final void setBeginTime(long j) {
        this.beginTime = j;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final int getProbability() {
        return this.probability;
    }

    public final void setProbability(int i) {
        this.probability = i;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final void setDefault(boolean z) {
        this.isDefault = z;
    }

    public final int getReportFlag() {
        return this.reportFlag;
    }

    public final void setReportFlag(int i) {
        this.reportFlag = i;
    }

    public final boolean isForce() {
        return this.isForce;
    }

    public final void setForce(boolean z) {
        this.isForce = z;
    }

    public final boolean isCustom() {
        return this.isCustom;
    }

    public final void setCustom(boolean z) {
        this.isCustom = z;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final boolean getShowLogo() {
        return this.showLogo;
    }

    public final void setShowLogo(boolean z) {
        this.showLogo = z;
    }

    public final int getForceShowTimes() {
        return this.forceShowTimes;
    }

    public final void setForceShowTimes(int i) {
        this.forceShowTimes = i;
    }

    public final QueryItem getQueryItem() {
        return this.queryItem;
    }

    public final void setQueryItem(QueryItem queryItem) {
        this.queryItem = queryItem;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    public final void setLocked(boolean z) {
        this.locked = z;
    }

    public final Bitmap getLocalBitmap() {
        return this.localBitmap;
    }

    public final void setLocalBitmap(Bitmap bitmap) {
        this.localBitmap = bitmap;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrandShowInfo(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.id = parcel.readLong();
        this.source = parcel.readString();
        this.thumb = parcel.readString();
        this.thumbHash = parcel.readString();
        this.thumbName = parcel.readString();
        this.logoUrl = parcel.readString();
        this.logoHash = parcel.readString();
        this.beginTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.probability = parcel.readInt();
        this.duration = parcel.readLong();
        this.isSelected = parcel.readByte() != 0;
        this.isDefault = parcel.readByte() != 0;
        this.reportFlag = parcel.readInt();
        this.isForce = parcel.readByte() != 0;
        this.mode = parcel.readString();
        this.showLogo = parcel.readByte() != 0;
        this.forceShowTimes = parcel.readInt();
        this.locked = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeLong(this.id);
        dest.writeString(this.source);
        dest.writeString(this.thumb);
        dest.writeString(this.thumbHash);
        dest.writeString(this.thumbName);
        dest.writeString(this.logoUrl);
        dest.writeString(this.logoHash);
        dest.writeLong(this.beginTime);
        dest.writeLong(this.endTime);
        dest.writeInt(this.probability);
        dest.writeLong(this.duration);
        dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isDefault ? (byte) 1 : (byte) 0);
        dest.writeInt(this.reportFlag);
        dest.writeByte(this.isForce ? (byte) 1 : (byte) 0);
        dest.writeString(this.mode);
        dest.writeByte(this.showLogo ? (byte) 1 : (byte) 0);
        dest.writeInt(this.forceShowTimes);
        dest.writeByte(this.locked ? (byte) 1 : (byte) 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* compiled from: BrandShowInfo.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u001d\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;", "<init>", "()V", "FLAG_DEFAULT", "", "FLAG_CUSTOM", "FLAG_FALLBACK", "FLAG_FORE", "FLAG_NONE", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Ltv/danmaku/bili/ui/splash/brand/model/BrandShowInfo;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CREATOR implements Parcelable.Creator<BrandShowInfo> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public BrandShowInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BrandShowInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public BrandShowInfo[] newArray(int size) {
            return new BrandShowInfo[size];
        }
    }

    public boolean equals(Object other) {
        return (other instanceof BrandShowInfo) && hashCode() == ((BrandShowInfo) other).hashCode();
    }

    public int hashCode() {
        return ObjectsCompat.hash(new Object[]{Long.valueOf(this.id), "source:" + this.source});
    }

    public final boolean isVipSplash() {
        return Intrinsics.areEqual(this.source, BrandSplashSource.VIP.getValue());
    }

    public final boolean isValid() {
        File file;
        if (this.isDefault) {
            return true;
        }
        if (TextUtils.isEmpty(this.thumb)) {
            return false;
        }
        ResResponse fetch = ResManager.fetch(new ResRequest((String) null, this.thumbHash));
        boolean isExists = (fetch == null || (file = fetch.getFile()) == null) ? false : file.exists();
        if (isExists) {
            return isTimeValid();
        }
        return false;
    }

    public final boolean isValidIgnoreRes() {
        if (this.isDefault) {
            return true;
        }
        if (TextUtils.isEmpty(this.thumb)) {
            return false;
        }
        return isTimeValid();
    }

    public final boolean isTimeValid() {
        if (this.isCustom) {
            return true;
        }
        long now = RealTime.unreliableNow();
        return now <= this.endTime && now >= this.beginTime;
    }
}