package kntr.app.digital.preview.api;

import java.lang.annotation.Annotation;
import kntr.app.digital.preview.api.DescTag;
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
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: CardPreviewModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0003!\"#B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lkntr/app/digital/preview/api/DescTag;", RoomRecommendViewModel.EMPTY_CURSOR, "text", RoomRecommendViewModel.EMPTY_CURSOR, "style", "Lkntr/app/digital/preview/api/DescTag$Style;", "<init>", "(Ljava/lang/String;Lkntr/app/digital/preview/api/DescTag$Style;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/app/digital/preview/api/DescTag$Style;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getStyle", "()Lkntr/app/digital/preview/api/DescTag$Style;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$preview_debug", "Style", "$serializer", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class DescTag {
    public static final int $stable = 0;
    private final Style style;
    private final String text;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.DescTag$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DescTag._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public static /* synthetic */ DescTag copy$default(DescTag descTag, String str, Style style, int i, Object obj) {
        if ((i & 1) != 0) {
            str = descTag.text;
        }
        if ((i & 2) != 0) {
            style = descTag.style;
        }
        return descTag.copy(str, style);
    }

    public final String component1() {
        return this.text;
    }

    public final Style component2() {
        return this.style;
    }

    public final DescTag copy(String str, Style style) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        return new DescTag(str, style);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DescTag) {
            DescTag descTag = (DescTag) obj;
            return Intrinsics.areEqual(this.text, descTag.text) && this.style == descTag.style;
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.style.hashCode();
    }

    public String toString() {
        String str = this.text;
        return "DescTag(text=" + str + ", style=" + this.style + ")";
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/DescTag$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/DescTag;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DescTag> serializer() {
            return DescTag$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DescTag(int seen0, String text, Style style, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, DescTag$$serializer.INSTANCE.getDescriptor());
        }
        this.text = text;
        if ((seen0 & 2) == 0) {
            this.style = Style.Top;
        } else {
            this.style = style;
        }
    }

    public DescTag(String text, Style style) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        this.text = text;
        this.style = style;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return Style.Companion.serializer();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$preview_debug(DescTag self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.text);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.style != Style.Top) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.style);
        }
    }

    public /* synthetic */ DescTag(String str, Style style, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Style.Top : style);
    }

    public final String getText() {
        return this.text;
    }

    /* compiled from: CardPreviewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/DescTag$Style;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;I)V", "Top", "Bottom", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public enum Style {
        Top,
        Bottom;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.digital.preview.api.DescTag$Style$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = DescTag.Style._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public static EnumEntries<Style> getEntries() {
            return $ENTRIES;
        }

        /* compiled from: CardPreviewModel.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/digital/preview/api/DescTag$Style$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/digital/preview/api/DescTag$Style;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            return EnumsKt.createAnnotatedEnumSerializer("kntr.app.digital.preview.api.DescTag.Style", values(), new String[]{"top", "bottom"}, new Annotation[][]{null, null}, (Annotation[]) null);
        }
    }

    public final Style getStyle() {
        return this.style;
    }
}