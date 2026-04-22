package tv.danmaku.bili.ui.offline.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EpPlayableV2.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0014H\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/offline/api/EpPlayableV2;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "isLogin", "", "()Z", "setLogin", "(Z)V", "epPlayableParams", "", "Ltv/danmaku/bili/ui/offline/api/EpPlayableV2$EpPlayableParams;", "getEpPlayableParams", "()Ljava/util/List;", "setEpPlayableParams", "(Ljava/util/List;)V", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "EpPlayableParams", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class EpPlayableV2 implements Parcelable {
    @JSONField(name = "ep_qn_check_list")
    private List<EpPlayableParams> epPlayableParams;
    @JSONField(name = "login")
    private boolean isLogin;
    public static final CREATOR CREATOR = new CREATOR(null);
    public static final int $stable = 8;

    public EpPlayableV2() {
    }

    public final boolean isLogin() {
        return this.isLogin;
    }

    public final void setLogin(boolean z) {
        this.isLogin = z;
    }

    public final List<EpPlayableParams> getEpPlayableParams() {
        return this.epPlayableParams;
    }

    public final void setEpPlayableParams(List<EpPlayableParams> list) {
        this.epPlayableParams = list;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EpPlayableV2(Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.isLogin = parcel.readInt() == 1;
        this.epPlayableParams = parcel.createTypedArrayList(EpPlayableParams.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.isLogin ? 1 : 0);
        dest.writeTypedList(this.epPlayableParams);
    }

    /* compiled from: EpPlayableV2.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/offline/api/EpPlayableV2$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/ui/offline/api/EpPlayableV2;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/ui/offline/api/EpPlayableV2;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class CREATOR implements Parcelable.Creator<EpPlayableV2> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public EpPlayableV2 createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new EpPlayableV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public EpPlayableV2[] newArray(int size) {
            return new EpPlayableV2[size];
        }
    }

    /* compiled from: EpPlayableV2.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/ui/offline/api/EpPlayableV2$EpPlayableParams;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "epId", "", "getEpId", "()I", "setEpId", "(I)V", "playableType", "getPlayableType", "setPlayableType", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "writeToParcel", "", "flags", "describeContents", "CREATOR", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class EpPlayableParams implements Parcelable {
        @JSONField(name = "ep_id")
        private int epId;
        @JSONField(name = "message")
        private String message;
        @JSONField(name = "code")
        private int playableType;
        public static final CREATOR CREATOR = new CREATOR(null);
        public static final int $stable = 8;

        public EpPlayableParams() {
            this.epId = -1;
            this.playableType = -1;
        }

        public final int getEpId() {
            return this.epId;
        }

        public final void setEpId(int i) {
            this.epId = i;
        }

        public final int getPlayableType() {
            return this.playableType;
        }

        public final void setPlayableType(int i) {
            this.playableType = i;
        }

        public final String getMessage() {
            return this.message;
        }

        public final void setMessage(String str) {
            this.message = str;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EpPlayableParams(Parcel parcel) {
            this();
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            this.epId = parcel.readInt();
            this.playableType = parcel.readInt();
            this.message = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.epId);
            parcel.writeInt(this.playableType);
            parcel.writeString(this.message);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* compiled from: EpPlayableV2.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/offline/api/EpPlayableV2$EpPlayableParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/ui/offline/api/EpPlayableV2$EpPlayableParams;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Ltv/danmaku/bili/ui/offline/api/EpPlayableV2$EpPlayableParams;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class CREATOR implements Parcelable.Creator<EpPlayableParams> {
            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private CREATOR() {
            }

            @Override // android.os.Parcelable.Creator
            public EpPlayableParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new EpPlayableParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public EpPlayableParams[] newArray(int size) {
                return new EpPlayableParams[size];
            }
        }
    }
}