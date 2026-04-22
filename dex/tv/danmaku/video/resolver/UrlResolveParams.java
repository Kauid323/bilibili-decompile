package tv.danmaku.video.resolver;

import android.os.Parcel;
import android.os.Parcelable;
import com.bilibili.lib.media.resolver2.BiliCodec;
import com.bilibili.lib.media.resolver2.IResolveParams;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: UrlResolveParams.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020 H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR\u0014\u0010\u0016\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u001c\u0010\u0018\u001a\u00020\u0019X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR$\u0010$\u001a\u00020 2\u0006\u0010#\u001a\u00020 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001d¨\u0006,"}, d2 = {"Ltv/danmaku/video/resolver/UrlResolveParams;", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "backupUrls", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getBackupUrls", "()Ljava/util/ArrayList;", "setBackupUrls", "(Ljava/util/ArrayList;)V", "from", "getFrom", "id", "getId", "codecType", "Lcom/bilibili/lib/media/resolver2/BiliCodec;", "getCodecType-eY-7Wcs", "()I", "setCodecType-N6j8eWo", "(I)V", "I", IjkMediaMeta.IJKM_KEY_FORMAT, "", "getFormat", "setFormat", "value", "domainParams", "getDomainParams", "setDomainParams", "writeToParcel", "", "flags", "describeContents", "CREATOR", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UrlResolveParams implements IResolveParams {
    public static final CREATOR CREATOR = new CREATOR(null);
    private ArrayList<String> backupUrls;
    private int codecType;
    private int format;
    private String url;

    public UrlResolveParams() {
        this.backupUrls = new ArrayList<>();
        this.codecType = BiliCodec.Companion.getDEFAULT-eY-7Wcs();
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final ArrayList<String> getBackupUrls() {
        return this.backupUrls;
    }

    public final void setBackupUrls(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.backupUrls = arrayList;
    }

    public String getFrom() {
        return "direct_url";
    }

    public String getId() {
        String str = this.url;
        return str == null ? "" : str;
    }

    /* renamed from: getCodecType-eY-7Wcs  reason: not valid java name */
    public int m2700getCodecTypeeY7Wcs() {
        return this.codecType;
    }

    /* renamed from: setCodecType-N6j8eWo  reason: not valid java name */
    public void m2701setCodecTypeN6j8eWo(int i) {
        this.codecType = i;
    }

    public int getFormat() {
        return this.format;
    }

    public void setFormat(int i) {
        this.format = i;
    }

    public int getDomainParams() {
        return 0;
    }

    public void setDomainParams(int value) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UrlResolveParams(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.url = parcel.readString();
        parcel.readList(this.backupUrls, String.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeList(this.backupUrls);
    }

    public int describeContents() {
        return 0;
    }

    /* compiled from: UrlResolveParams.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/video/resolver/UrlResolveParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/video/resolver/UrlResolveParams;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/video/resolver/UrlResolveParams;", "ugcresolver_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CREATOR implements Parcelable.Creator<UrlResolveParams> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public UrlResolveParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UrlResolveParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public UrlResolveParams[] newArray(int size) {
            return new UrlResolveParams[size];
        }
    }
}