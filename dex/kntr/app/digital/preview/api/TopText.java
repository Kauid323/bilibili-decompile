package kntr.app.digital.preview.api;

import java.lang.annotation.Annotation;
import kntr.app.digital.preview.CardNumberGradientColor;
import kntr.app.digital.preview.CardNumberGradientColor$$serializer;
import kntr.app.digital.preview.api.TopText;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: CardPreviewModel.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 *2\u00020\u0001:\u0003()*B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lkntr/app/digital/preview/api/TopText;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "colorFormat", "Lkntr/app/digital/preview/CardNumberGradientColor;", "style", "Lkntr/app/digital/preview/api/TopText$Style;", "<init>", "(Ljava/lang/String;Lkntr/app/digital/preview/CardNumberGradientColor;Lkntr/app/digital/preview/api/TopText$Style;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/digital/preview/CardNumberGradientColor;Lkntr/app/digital/preview/api/TopText$Style;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getColorFormat$annotations", "()V", "getColorFormat", "()Lkntr/app/digital/preview/CardNumberGradientColor;", "getStyle", "()Lkntr/app/digital/preview/api/TopText$Style;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "Style", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class TopText {
    private final CardNumberGradientColor colorFormat;
    private final Style style;
    private final String text;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.TopText$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = TopText._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public static /* synthetic */ TopText copy$default(TopText topText, String str, CardNumberGradientColor cardNumberGradientColor, Style style, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topText.text;
        }
        if ((i & 2) != 0) {
            cardNumberGradientColor = topText.colorFormat;
        }
        if ((i & 4) != 0) {
            style = topText.style;
        }
        return topText.copy(str, cardNumberGradientColor, style);
    }

    @SerialName("color_format")
    public static /* synthetic */ void getColorFormat$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final CardNumberGradientColor component2() {
        return this.colorFormat;
    }

    public final Style component3() {
        return this.style;
    }

    public final TopText copy(String str, CardNumberGradientColor cardNumberGradientColor, Style style) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        return new TopText(str, cardNumberGradientColor, style);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopText) {
            TopText topText = (TopText) obj;
            return Intrinsics.areEqual(this.text, topText.text) && Intrinsics.areEqual(this.colorFormat, topText.colorFormat) && this.style == topText.style;
        }
        return false;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + (this.colorFormat == null ? 0 : this.colorFormat.hashCode())) * 31) + this.style.hashCode();
    }

    public String toString() {
        String str = this.text;
        CardNumberGradientColor cardNumberGradientColor = this.colorFormat;
        return "TopText(text=" + str + ", colorFormat=" + cardNumberGradientColor + ", style=" + this.style + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/TopText$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/TopText;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TopText> serializer() {
            return TopText$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ TopText(int seen0, String text, CardNumberGradientColor colorFormat, Style style, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, TopText$$serializer.INSTANCE.getDescriptor());
        }
        this.text = text;
        if ((seen0 & 2) == 0) {
            this.colorFormat = null;
        } else {
            this.colorFormat = colorFormat;
        }
        if ((seen0 & 4) == 0) {
            this.style = Style.Normal;
        } else {
            this.style = style;
        }
    }

    public TopText(String text, CardNumberGradientColor colorFormat, Style style) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        this.text = text;
        this.colorFormat = colorFormat;
        this.style = style;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return Style.Companion.serializer();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(TopText self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.text);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.colorFormat != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, CardNumberGradientColor$$serializer.INSTANCE, self.colorFormat);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.style != Style.Normal) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.style);
        }
    }

    public /* synthetic */ TopText(String str, CardNumberGradientColor cardNumberGradientColor, Style style, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : cardNumberGradientColor, (i & 4) != 0 ? Style.Normal : style);
    }

    public final String getText() {
        return this.text;
    }

    public final CardNumberGradientColor getColorFormat() {
        return this.colorFormat;
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/TopText$Style;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;I)V", "Card", "Normal", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public enum Style {
        Card,
        Normal;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.TopText$Style$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = TopText.Style._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public static EnumEntries<Style> getEntries() {
            return $ENTRIES;
        }

        /* compiled from: CardPreviewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/TopText$Style$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/TopText$Style;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) Style.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<Style> serializer() {
                return get$cachedSerializer();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.createAnnotatedEnumSerializer("kntr.app.digital.preview.api.TopText.Style", values(), new String[]{"card", "normal"}, new Annotation[][]{null, null}, (Annotation[]) null);
        }
    }

    public final Style getStyle() {
        return this.style;
    }
}