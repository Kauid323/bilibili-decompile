package im.session.model;

import com.bapis.bilibili.app.im.v1.KUpdateSessionParams;
import com.bapis.bilibili.app.im.v1.KUpdateSessionParams$;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: IMSessionPartialPage.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002&'B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u0017\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\nHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lim/session/model/IMSessionPartialPage;", "", "items", "", "Lim/session/model/IMSessionCard;", "updateSessionParams", "Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;", "<init>", "(Ljava/util/List;Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getItems$annotations", "()V", "getItems", "()Ljava/util/List;", "getUpdateSessionParams$annotations", "getUpdateSessionParams", "()Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$session_debug", "$serializer", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class IMSessionPartialPage {
    private final List<IMSessionCard> items;
    private final KUpdateSessionParams updateSessionParams;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: im.session.model.IMSessionPartialPage$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = IMSessionPartialPage._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMSessionPartialPage copy$default(IMSessionPartialPage iMSessionPartialPage, List list, KUpdateSessionParams kUpdateSessionParams, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = iMSessionPartialPage.items;
        }
        if ((i2 & 2) != 0) {
            kUpdateSessionParams = iMSessionPartialPage.updateSessionParams;
        }
        return iMSessionPartialPage.copy(list, kUpdateSessionParams);
    }

    @ProtoNumber(number = 1)
    @ProtoPacked
    public static /* synthetic */ void getItems$annotations() {
    }

    @ProtoNumber(number = 2)
    public static /* synthetic */ void getUpdateSessionParams$annotations() {
    }

    public final List<IMSessionCard> component1() {
        return this.items;
    }

    public final KUpdateSessionParams component2() {
        return this.updateSessionParams;
    }

    public final IMSessionPartialPage copy(List<IMSessionCard> list, KUpdateSessionParams kUpdateSessionParams) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new IMSessionPartialPage(list, kUpdateSessionParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSessionPartialPage) {
            IMSessionPartialPage iMSessionPartialPage = (IMSessionPartialPage) obj;
            return Intrinsics.areEqual(this.items, iMSessionPartialPage.items) && Intrinsics.areEqual(this.updateSessionParams, iMSessionPartialPage.updateSessionParams);
        }
        return false;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + (this.updateSessionParams == null ? 0 : this.updateSessionParams.hashCode());
    }

    public String toString() {
        List<IMSessionCard> list = this.items;
        return "IMSessionPartialPage(items=" + list + ", updateSessionParams=" + this.updateSessionParams + ")";
    }

    /* compiled from: IMSessionPartialPage.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lim/session/model/IMSessionPartialPage$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lim/session/model/IMSessionPartialPage;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IMSessionPartialPage> serializer() {
            return IMSessionPartialPage$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ IMSessionPartialPage(int seen0, List items, KUpdateSessionParams updateSessionParams, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, IMSessionPartialPage$$serializer.INSTANCE.getDescriptor());
        }
        this.items = items;
        if ((seen0 & 2) == 0) {
            this.updateSessionParams = null;
        } else {
            this.updateSessionParams = updateSessionParams;
        }
    }

    public IMSessionPartialPage(List<IMSessionCard> list, KUpdateSessionParams updateSessionParams) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        this.updateSessionParams = updateSessionParams;
    }

    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(IMSessionCard$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$session_debug(IMSessionPartialPage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) $childSerializers[0].getValue(), self.items);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.updateSessionParams != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, KUpdateSessionParams$.serializer.INSTANCE, self.updateSessionParams);
        }
    }

    public /* synthetic */ IMSessionPartialPage(List list, KUpdateSessionParams kUpdateSessionParams, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i2 & 2) != 0 ? null : kUpdateSessionParams);
    }

    public final List<IMSessionCard> getItems() {
        return this.items;
    }

    public final KUpdateSessionParams getUpdateSessionParams() {
        return this.updateSessionParams;
    }
}