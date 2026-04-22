package video.biz.offline.list.logic.model;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineAuthResult.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006/"}, d2 = {"Lvideo/biz/offline/list/logic/model/EpAuthItem;", "", "epId", "", "code", "", "message", "", "<init>", "(JILjava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEpId$annotations", "()V", "getEpId", "()J", "getCode$annotations", "getCode", "()I", "setCode", "(I)V", "getMessage$annotations", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$logic_debug", "$serializer", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class EpAuthItem {
    private int code;
    private final long epId;
    private String message;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public EpAuthItem() {
        this(0L, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ EpAuthItem copy$default(EpAuthItem epAuthItem, long j, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = epAuthItem.epId;
        }
        if ((i2 & 2) != 0) {
            i = epAuthItem.code;
        }
        if ((i2 & 4) != 0) {
            str = epAuthItem.message;
        }
        return epAuthItem.copy(j, i, str);
    }

    @SerialName("code")
    public static /* synthetic */ void getCode$annotations() {
    }

    @SerialName("ep_id")
    public static /* synthetic */ void getEpId$annotations() {
    }

    @SerialName("message")
    public static /* synthetic */ void getMessage$annotations() {
    }

    public final long component1() {
        return this.epId;
    }

    public final int component2() {
        return this.code;
    }

    public final String component3() {
        return this.message;
    }

    public final EpAuthItem copy(long j, int i, String str) {
        return new EpAuthItem(j, i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EpAuthItem) {
            EpAuthItem epAuthItem = (EpAuthItem) obj;
            return this.epId == epAuthItem.epId && this.code == epAuthItem.code && Intrinsics.areEqual(this.message, epAuthItem.message);
        }
        return false;
    }

    public int hashCode() {
        return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.epId) * 31) + this.code) * 31) + (this.message == null ? 0 : this.message.hashCode());
    }

    public String toString() {
        long j = this.epId;
        int i = this.code;
        return "EpAuthItem(epId=" + j + ", code=" + i + ", message=" + this.message + ")";
    }

    /* compiled from: OfflineAuthResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/list/logic/model/EpAuthItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/list/logic/model/EpAuthItem;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<EpAuthItem> serializer() {
            return EpAuthItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EpAuthItem(int seen0, long epId, int code, String message, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.epId = -1L;
        } else {
            this.epId = epId;
        }
        if ((seen0 & 2) == 0) {
            this.code = -1;
        } else {
            this.code = code;
        }
        if ((seen0 & 4) == 0) {
            this.message = null;
        } else {
            this.message = message;
        }
    }

    public EpAuthItem(long epId, int code, String message) {
        this.epId = epId;
        this.code = code;
        this.message = message;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$logic_debug(EpAuthItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.epId != -1) {
            output.encodeLongElement(serialDesc, 0, self.epId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.code != -1) {
            output.encodeIntElement(serialDesc, 1, self.code);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.message != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.message);
        }
    }

    public /* synthetic */ EpAuthItem(long j, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1L : j, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? null : str);
    }

    public final long getEpId() {
        return this.epId;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}