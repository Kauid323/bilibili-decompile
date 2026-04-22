package kntr.app.ad.domain.inspector.model;

import java.lang.annotation.Annotation;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdData.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;BC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bBi\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\n\u0010\u0011J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003JT\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R.\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u0004\u0018\u00010\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\"\u0010\u0013¨\u0006<"}, d2 = {"Lkntr/app/ad/domain/inspector/model/AdData;", RoomRecommendViewModel.EMPTY_CURSOR, "adcb", RoomRecommendViewModel.EMPTY_CURSOR, "title", "salesType", "cardStyle", RoomRecommendViewModel.EMPTY_CURSOR, "creativeId", "trackId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "rawAction", "Lkotlin/Function0;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAdcb", "()Ljava/lang/String;", "getTitle", "getSalesType", "getCardStyle", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCreativeId", "getTrackId", "getRawAction$annotations", "()V", "getRawAction", "()Lkotlin/jvm/functions/Function0;", "setRawAction", "(Lkotlin/jvm/functions/Function0;)V", "raw", "getRaw", "raw$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lkntr/app/ad/domain/inspector/model/AdData;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$inspector_debug", "$serializer", "Companion", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AdData {
    private final String adcb;
    private final Integer cardStyle;
    private final String creativeId;
    private final Lazy raw$delegate;
    private Function0<String> rawAction;
    private final String salesType;
    private final String title;
    private final String trackId;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.domain.inspector.model.AdData$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = AdData._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public static /* synthetic */ AdData copy$default(AdData adData, String str, String str2, String str3, Integer num, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adData.adcb;
        }
        if ((i & 2) != 0) {
            str2 = adData.title;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = adData.salesType;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            num = adData.cardStyle;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            str4 = adData.creativeId;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = adData.trackId;
        }
        return adData.copy(str, str6, str7, num2, str8, str5);
    }

    public static /* synthetic */ void getRawAction$annotations() {
    }

    public final String component1() {
        return this.adcb;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.salesType;
    }

    public final Integer component4() {
        return this.cardStyle;
    }

    public final String component5() {
        return this.creativeId;
    }

    public final String component6() {
        return this.trackId;
    }

    public final AdData copy(String str, String str2, String str3, Integer num, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "adcb");
        return new AdData(str, str2, str3, num, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdData) {
            AdData adData = (AdData) obj;
            return Intrinsics.areEqual(this.adcb, adData.adcb) && Intrinsics.areEqual(this.title, adData.title) && Intrinsics.areEqual(this.salesType, adData.salesType) && Intrinsics.areEqual(this.cardStyle, adData.cardStyle) && Intrinsics.areEqual(this.creativeId, adData.creativeId) && Intrinsics.areEqual(this.trackId, adData.trackId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.adcb.hashCode() * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.salesType == null ? 0 : this.salesType.hashCode())) * 31) + (this.cardStyle == null ? 0 : this.cardStyle.hashCode())) * 31) + (this.creativeId == null ? 0 : this.creativeId.hashCode())) * 31) + (this.trackId != null ? this.trackId.hashCode() : 0);
    }

    public String toString() {
        String str = this.adcb;
        String str2 = this.title;
        String str3 = this.salesType;
        Integer num = this.cardStyle;
        String str4 = this.creativeId;
        return "AdData(adcb=" + str + ", title=" + str2 + ", salesType=" + str3 + ", cardStyle=" + num + ", creativeId=" + str4 + ", trackId=" + this.trackId + ")";
    }

    /* compiled from: AdData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/domain/inspector/model/AdData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/domain/inspector/model/AdData;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdData> serializer() {
            return AdData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AdData(int seen0, String adcb, String title, String salesType, Integer cardStyle, String creativeId, String trackId, Function0 rawAction, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (seen0 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 63, AdData$$serializer.INSTANCE.getDescriptor());
        }
        this.adcb = adcb;
        this.title = title;
        this.salesType = salesType;
        this.cardStyle = cardStyle;
        this.creativeId = creativeId;
        this.trackId = trackId;
        if ((seen0 & 64) == 0) {
            this.rawAction = null;
        } else {
            this.rawAction = rawAction;
        }
        this.raw$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.inspector.model.AdData$$ExternalSyntheticLambda1
            public final Object invoke() {
                String _init_$lambda$0;
                _init_$lambda$0 = AdData._init_$lambda$0(AdData.this);
                return _init_$lambda$0;
            }
        });
    }

    public AdData(String adcb, String title, String salesType, Integer cardStyle, String creativeId, String trackId) {
        Intrinsics.checkNotNullParameter(adcb, "adcb");
        this.adcb = adcb;
        this.title = title;
        this.salesType = salesType;
        this.cardStyle = cardStyle;
        this.creativeId = creativeId;
        this.trackId = trackId;
        this.raw$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.inspector.model.AdData$$ExternalSyntheticLambda2
            public final Object invoke() {
                String raw_delegate$lambda$0;
                raw_delegate$lambda$0 = AdData.raw_delegate$lambda$0(AdData.this);
                return raw_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(Function0.class), new Annotation[0]);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$inspector_debug(AdData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.adcb);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.salesType);
        output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.cardStyle);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.creativeId);
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.trackId);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.rawAction != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, (SerializationStrategy) lazyArr[6].getValue(), self.rawAction);
        }
    }

    public final String getAdcb() {
        return this.adcb;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSalesType() {
        return this.salesType;
    }

    public final Integer getCardStyle() {
        return this.cardStyle;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final Function0<String> getRawAction() {
        return this.rawAction;
    }

    public final void setRawAction(Function0<String> function0) {
        this.rawAction = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String _init_$lambda$0(AdData this$0) {
        Function0<String> function0 = this$0.rawAction;
        if (function0 != null) {
            return (String) function0.invoke();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String raw_delegate$lambda$0(AdData this$0) {
        Function0<String> function0 = this$0.rawAction;
        if (function0 != null) {
            return (String) function0.invoke();
        }
        return null;
    }

    public final String getRaw() {
        return (String) this.raw$delegate.getValue();
    }
}