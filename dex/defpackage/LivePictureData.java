package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LivePictureData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"LLivePictureData;", "LILivePictureData;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "url", "", "desc", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "picturebrowser_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: LivePictureData  reason: default package */
public final class LivePictureData implements ILivePictureData {
    public static final CREATOR CREATOR = new CREATOR(null);
    @JSONField(name = "pic_desc")
    public String desc;
    @JSONField(name = "pic_url")
    public String url;

    public LivePictureData() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePictureData(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.url = parcel.readString();
        this.desc = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.url);
        parcel.writeString(this.desc);
    }

    public String url() {
        return this.url;
    }

    public String desc() {
        return this.desc;
    }

    public int describeContents() {
        return 0;
    }

    /* compiled from: LivePictureData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"LLivePictureData$CREATOR;", "Landroid/os/Parcelable$Creator;", "LLivePictureData;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[LLivePictureData;", "picturebrowser_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: LivePictureData$CREATOR */
    /* loaded from: /data/np/file-convert/2026022807222197de6f91-6104-46cc-91cf-b90bdc19816e/2026022807222197de6f91-6104-46cc-91cf-b90bdc19816e.dex */
    public static final class CREATOR implements Parcelable.Creator<LivePictureData> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LivePictureData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LivePictureData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LivePictureData[] newArray(int size) {
            return new LivePictureData[size];
        }
    }
}