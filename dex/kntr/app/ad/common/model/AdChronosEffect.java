package kntr.app.ad.common.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdChronosEffect.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lkntr/app/ad/common/model/AdChronosEffect;", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, "jumpDelay", RoomRecommendViewModel.EMPTY_CURSOR, "params", RoomRecommendViewModel.EMPTY_CURSOR, "resources", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/common/model/AdChronosResource;", "<init>", "(IJLjava/lang/String;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJLjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getType", "()I", "getJumpDelay", "()J", "getParams", "()Ljava/lang/String;", "getResources", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$dto_debug", "$serializer", "Companion", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdChronosEffect {
    private final long jumpDelay;
    private final String params;
    private final List<AdChronosResource> resources;
    private final int type;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.AdChronosEffect$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdChronosEffect._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public AdChronosEffect() {
        this(0, 0L, (String) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdChronosEffect copy$default(AdChronosEffect adChronosEffect, int i, long j2, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = adChronosEffect.type;
        }
        if ((i2 & 2) != 0) {
            j2 = adChronosEffect.jumpDelay;
        }
        long j3 = j2;
        if ((i2 & 4) != 0) {
            str = adChronosEffect.params;
        }
        String str2 = str;
        List<AdChronosResource> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = adChronosEffect.resources;
        }
        return adChronosEffect.copy(i, j3, str2, list2);
    }

    public final int component1() {
        return this.type;
    }

    public final long component2() {
        return this.jumpDelay;
    }

    public final String component3() {
        return this.params;
    }

    public final List<AdChronosResource> component4() {
        return this.resources;
    }

    public final AdChronosEffect copy(int i, long j2, String str, List<AdChronosResource> list) {
        return new AdChronosEffect(i, j2, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdChronosEffect) {
            AdChronosEffect adChronosEffect = (AdChronosEffect) obj;
            return this.type == adChronosEffect.type && this.jumpDelay == adChronosEffect.jumpDelay && Intrinsics.areEqual(this.params, adChronosEffect.params) && Intrinsics.areEqual(this.resources, adChronosEffect.resources);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.type * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.jumpDelay)) * 31) + (this.params == null ? 0 : this.params.hashCode())) * 31) + (this.resources != null ? this.resources.hashCode() : 0);
    }

    public String toString() {
        int i = this.type;
        long j2 = this.jumpDelay;
        String str = this.params;
        return "AdChronosEffect(type=" + i + ", jumpDelay=" + j2 + ", params=" + str + ", resources=" + this.resources + ")";
    }

    /* compiled from: AdChronosEffect.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/AdChronosEffect$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/AdChronosEffect;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdChronosEffect> serializer() {
            return AdChronosEffect$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdChronosEffect(int seen0, int type, long jumpDelay, String params, List resources, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.type = 0;
        } else {
            this.type = type;
        }
        if ((seen0 & 2) == 0) {
            this.jumpDelay = 0L;
        } else {
            this.jumpDelay = jumpDelay;
        }
        if ((seen0 & 4) == 0) {
            this.params = null;
        } else {
            this.params = params;
        }
        if ((seen0 & 8) == 0) {
            this.resources = null;
        } else {
            this.resources = resources;
        }
    }

    public AdChronosEffect(int type, long jumpDelay, String params, List<AdChronosResource> list) {
        this.type = type;
        this.jumpDelay = jumpDelay;
        this.params = params;
        this.resources = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(BuiltinSerializersKt.getNullable(AdChronosResource$$serializer.INSTANCE));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$dto_debug(AdChronosEffect self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != 0) {
            output.encodeIntElement(serialDesc, 0, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.jumpDelay != 0) {
            output.encodeLongElement(serialDesc, 1, self.jumpDelay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.params != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.params);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.resources != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.resources);
        }
    }

    public /* synthetic */ AdChronosEffect(int i, long j2, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : list);
    }

    public final int getType() {
        return this.type;
    }

    public final long getJumpDelay() {
        return this.jumpDelay;
    }

    public final String getParams() {
        return this.params;
    }

    public final List<AdChronosResource> getResources() {
        return this.resources;
    }
}