package im.session.model;

import BottomSheetItemData$;
import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import com.bapis.bilibili.app.im.v1.KSessionFilterTypeSerializer;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: IMSessionFilter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\t\b\u0016¢\u0006\u0004\b\b\u0010\nB/\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\b\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J'\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\fHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\n\u001a\u0004\b\u0006\u0010\u0017¨\u0006*"}, d2 = {"Lim/session/model/IMSessionFilter;", "", "type", "Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", ContentDisposition.Parameters.Name, "", "isSelected", "", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;Ljava/lang/String;Z)V", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bapis/bilibili/app/im/v1/KSessionFilterType;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType$annotations", "getType", "()Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "getName$annotations", "getName", "()Ljava/lang/String;", "isSelected$annotations", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "$serializer", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class IMSessionFilter {
    public static final Companion Companion = new Companion(null);
    private final boolean isSelected;
    private final String name;
    private final KSessionFilterType type;

    public static /* synthetic */ IMSessionFilter copy$default(IMSessionFilter iMSessionFilter, KSessionFilterType kSessionFilterType, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kSessionFilterType = iMSessionFilter.type;
        }
        if ((i2 & 2) != 0) {
            str = iMSessionFilter.name;
        }
        if ((i2 & 4) != 0) {
            z = iMSessionFilter.isSelected;
        }
        return iMSessionFilter.copy(kSessionFilterType, str, z);
    }

    @ProtoNumber(number = 2)
    public static /* synthetic */ void getName$annotations() {
    }

    @ProtoNumber(number = 1)
    public static /* synthetic */ void getType$annotations() {
    }

    @Transient
    public static /* synthetic */ void isSelected$annotations() {
    }

    public final KSessionFilterType component1() {
        return this.type;
    }

    public final String component2() {
        return this.name;
    }

    public final boolean component3() {
        return this.isSelected;
    }

    public final IMSessionFilter copy(KSessionFilterType kSessionFilterType, String str, boolean z) {
        Intrinsics.checkNotNullParameter(kSessionFilterType, "type");
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        return new IMSessionFilter(kSessionFilterType, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSessionFilter) {
            IMSessionFilter iMSessionFilter = (IMSessionFilter) obj;
            return Intrinsics.areEqual(this.type, iMSessionFilter.type) && Intrinsics.areEqual(this.name, iMSessionFilter.name) && this.isSelected == iMSessionFilter.isSelected;
        }
        return false;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.name.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSelected);
    }

    public String toString() {
        KSessionFilterType kSessionFilterType = this.type;
        String str = this.name;
        return "IMSessionFilter(type=" + kSessionFilterType + ", name=" + str + ", isSelected=" + this.isSelected + ")";
    }

    /* compiled from: IMSessionFilter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/session/model/IMSessionFilter$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/session/model/IMSessionFilter;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IMSessionFilter> serializer() {
            return IMSessionFilter$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ IMSessionFilter(int seen0, KSessionFilterType type, String name, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (seen0 & 2)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 2, IMSessionFilter$$serializer.INSTANCE.getDescriptor());
        }
        if ((seen0 & 1) == 0) {
            this.type = KSessionFilterType.FILTER_DEFAULT.INSTANCE;
        } else {
            this.type = type;
        }
        this.name = name;
        this.isSelected = false;
    }

    public IMSessionFilter(KSessionFilterType type, String name, boolean isSelected) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        this.type = type;
        this.name = name;
        this.isSelected = isSelected;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$session_debug(IMSessionFilter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.type, KSessionFilterType.FILTER_DEFAULT.INSTANCE)) {
            output.encodeSerializableElement(serialDesc, 0, KSessionFilterTypeSerializer.INSTANCE, self.type);
        }
        output.encodeStringElement(serialDesc, 1, self.name);
    }

    public /* synthetic */ IMSessionFilter(KSessionFilterType kSessionFilterType, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? (KSessionFilterType) KSessionFilterType.FILTER_DEFAULT.INSTANCE : kSessionFilterType, str, (i2 & 4) != 0 ? false : z);
    }

    public final KSessionFilterType getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public IMSessionFilter() {
        this(KSessionFilterType.FILTER_DEFAULT.INSTANCE, "", true);
    }
}