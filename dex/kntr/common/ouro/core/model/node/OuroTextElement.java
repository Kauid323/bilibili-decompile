package kntr.common.ouro.core.model.node;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksSerializer;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroUnmergableMark;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroTextElement.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 !2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u00052\u00020\u00072\u00020\b:\u0003\u001f !B\t\b\u0004¢\u0006\u0004\b\t\u0010\nB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0016\u0010\u0017\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H&J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007R\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0002\"#¨\u0006$"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroTextElement;", "Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn;", "Lkntr/common/ouro/core/model/node/OuroNode$Element;", "", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "Lkntr/common/ouro/core/model/node/OuroParagraphChild;", "Lkntr/common/ouro/core/model/node/OuroNode$Copyable;", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "copyText", "getCopyText", "()Ljava/lang/String;", "copyWithMarks", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Plain", "HardBreak", "Companion", "Lkntr/common/ouro/core/model/node/OuroTextElement$HardBreak;", "Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public abstract class OuroTextElement implements OuroNode.BuiltIn, OuroNode.Element<String>, OuroNode.Selectable, OuroNode.Markable<OuroTextMark>, OuroParagraphChild, OuroNode.Copyable {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.node.OuroTextElement$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _init_$_anonymous_;
            _init_$_anonymous_ = OuroTextElement._init_$_anonymous_();
            return _init_$_anonymous_;
        }
    });

    public /* synthetic */ OuroTextElement(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(OuroTextElement ouroTextElement, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }

    public abstract OuroTextElement copyWithMarks(OuroMarks<OuroTextMark> ouroMarks);

    @Override // kntr.common.ouro.core.model.node.OuroNode.Markable
    public abstract OuroMarks<OuroTextMark> getMarks();

    /* compiled from: OuroTextElement.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroTextElement$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroTextElement;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) OuroTextElement.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<OuroTextElement> serializer() {
            return get$cachedSerializer();
        }
    }

    private OuroTextElement() {
    }

    public /* synthetic */ OuroTextElement(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("kntr.common.ouro.core.model.node.OuroTextElement", Reflection.getOrCreateKotlinClass(OuroTextElement.class), new KClass[]{Reflection.getOrCreateKotlinClass(HardBreak.class), Reflection.getOrCreateKotlinClass(Plain.class)}, new KSerializer[]{OuroTextElement$HardBreak$$serializer.INSTANCE, OuroTextElement$Plain$$serializer.INSTANCE}, new Annotation[0]);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Copyable
    public String getCopyText() {
        return getMeta();
    }

    /* compiled from: OuroTextElement.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002)*B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bB5\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0016\u0010\u0019\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u001e2\n\u0010\u001f\u001a\u00020 \"\u00020\rH\u0016J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;", "Lkntr/common/ouro/core/model/node/OuroTextElement;", "Lkntr/common/ouro/core/model/node/OuroNode$Separable;", "Lkntr/common/ouro/core/model/node/OuroNode$Mergeable;", "Lkntr/common/ouro/core/model/node/OuroLinkChild;", "meta", "", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "<init>", "(Ljava/lang/String;Lkntr/common/ouro/core/model/mark/OuroMarks;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/common/ouro/core/model/mark/OuroMarks;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMeta", "()Ljava/lang/String;", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "tryMergeWith", "Lkntr/common/ouro/core/model/node/OuroNode;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "other", "copyWithMarks", "length", "getLength", "()I", "separate", "", "offsets", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Plain extends OuroTextElement implements OuroNode.Separable, OuroNode.Mergeable, OuroLinkChild {
        public static final Companion Companion = new Companion(null);
        private final OuroMarks<OuroTextMark> marks;
        private final String meta;

        /* compiled from: OuroTextElement.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroTextElement$Plain$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Plain> serializer() {
                return OuroTextElement$Plain$$serializer.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Plain(int seen0, String meta, OuroMarks marks, SerializationConstructorMarker serializationConstructorMarker) {
            super(seen0, serializationConstructorMarker);
            if (1 != (seen0 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 1, OuroTextElement$Plain$$serializer.INSTANCE.getDescriptor());
            }
            this.meta = meta;
            if ((seen0 & 2) == 0) {
                this.marks = OuroMarks.Empty.INSTANCE.getTextMarks();
            } else {
                this.marks = marks;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Plain(String meta, OuroMarks<OuroTextMark> ouroMarks) {
            super(null);
            Intrinsics.checkNotNullParameter(meta, "meta");
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
            this.meta = meta;
            this.marks = ouroMarks;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$core_debug(Plain self, CompositeEncoder output, SerialDescriptor serialDesc) {
            OuroTextElement.write$Self(self, output, serialDesc);
            output.encodeStringElement(serialDesc, 0, self.getMeta());
            if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.getMarks(), OuroMarks.Empty.INSTANCE.getTextMarks())) {
                output.encodeSerializableElement(serialDesc, 1, OuroMarksSerializer.INSTANCE, self.getMarks());
            }
        }

        @Override // kntr.common.ouro.core.model.node.OuroTextElement
        public /* bridge */ /* synthetic */ OuroTextElement copyWithMarks(OuroMarks marks) {
            return copyWithMarks((OuroMarks<OuroTextMark>) marks);
        }

        public /* synthetic */ Plain(String str, OuroMarks<OuroTextMark> ouroMarks, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? OuroMarks.Empty.INSTANCE.getTextMarks() : ouroMarks);
        }

        @Override // kntr.common.ouro.core.model.node.OuroNode.Element
        public String getMeta() {
            return this.meta;
        }

        @Override // kntr.common.ouro.core.model.node.OuroTextElement, kntr.common.ouro.core.model.node.OuroNode.Markable
        public OuroMarks<OuroTextMark> getMarks() {
            return this.marks;
        }

        @Override // kntr.common.ouro.core.model.node.OuroNode.Mergeable
        public OuroNode tryMergeWith(OuroNodeStorage<?> ouroNodeStorage, OuroNode other) {
            Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
            Intrinsics.checkNotNullParameter(other, "other");
            if (getMarks().contains((OuroMark.Key<?>) OuroUnmergableMark.Key.INSTANCE) || !(other instanceof Plain) || !Intrinsics.areEqual(getMarks(), ((Plain) other).getMarks())) {
                return null;
            }
            String mergedText = getMeta() + ((Plain) other).getMeta();
            return new Plain(mergedText, getMarks());
        }

        @Override // kntr.common.ouro.core.model.node.OuroTextElement
        public Plain copyWithMarks(OuroMarks<OuroTextMark> ouroMarks) {
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
            return new Plain(getMeta(), ouroMarks);
        }

        @Override // kntr.common.ouro.core.model.node.OuroNode.Separable
        public int getLength() {
            return getMeta().length();
        }

        @Override // kntr.common.ouro.core.model.node.OuroNode.Separable
        public List<Plain> separate(int... offsets) {
            Intrinsics.checkNotNullParameter(offsets, "offsets");
            if (offsets.length == 0) {
                return CollectionsKt.listOf(new Plain(getMeta(), getMarks()));
            }
            List<Number> sortedOffsets = CollectionsKt.distinct(ArraysKt.sorted(offsets));
            List result = new ArrayList();
            int start = 0;
            for (Number number : sortedOffsets) {
                int end = number.intValue();
                if (end < start || end > getLength()) {
                    return CollectionsKt.toList(result);
                }
                String substring = getMeta().substring(start, end);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                result.add(new Plain(substring, getMarks()));
                start = end;
            }
            if (start < getLength()) {
                String substring2 = getMeta().substring(start);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                result.add(new Plain(substring2, getMarks()));
            }
            return CollectionsKt.toList(result);
        }
    }

    /* compiled from: OuroTextElement.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B5\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0005\u0010\rJ\u0016\u0010\u0012\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroTextElement$HardBreak;", "Lkntr/common/ouro/core/model/node/OuroTextElement;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;)V", "seen0", "", "meta", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/ouro/core/model/mark/OuroMarks;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "getMeta", "()Ljava/lang/String;", "copyWithMarks", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class HardBreak extends OuroTextElement {
        public static final Companion Companion = new Companion(null);
        private final OuroMarks<OuroTextMark> marks;
        private final String meta;

        public HardBreak() {
            this(null, 1, null);
        }

        /* compiled from: OuroTextElement.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroTextElement$HardBreak$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroTextElement$HardBreak;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<HardBreak> serializer() {
                return OuroTextElement$HardBreak$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ HardBreak(int seen0, OuroMarks marks, String meta, SerializationConstructorMarker serializationConstructorMarker) {
            super(seen0, serializationConstructorMarker);
            if ((seen0 & 1) == 0) {
                this.marks = OuroMarks.Empty.INSTANCE.getTextMarks();
            } else {
                this.marks = marks;
            }
            if ((seen0 & 2) == 0) {
                this.meta = "\n";
            } else {
                this.meta = meta;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HardBreak(OuroMarks<OuroTextMark> ouroMarks) {
            super(null);
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
            this.marks = ouroMarks;
            this.meta = "\n";
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$core_debug(HardBreak self, CompositeEncoder output, SerialDescriptor serialDesc) {
            OuroTextElement.write$Self(self, output, serialDesc);
            if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.getMarks(), OuroMarks.Empty.INSTANCE.getTextMarks())) {
                output.encodeSerializableElement(serialDesc, 0, OuroMarksSerializer.INSTANCE, self.getMarks());
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.getMeta(), "\n")) {
                output.encodeStringElement(serialDesc, 1, self.getMeta());
            }
        }

        @Override // kntr.common.ouro.core.model.node.OuroTextElement
        public /* bridge */ /* synthetic */ OuroTextElement copyWithMarks(OuroMarks marks) {
            return copyWithMarks((OuroMarks<OuroTextMark>) marks);
        }

        public /* synthetic */ HardBreak(OuroMarks<OuroTextMark> ouroMarks, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? OuroMarks.Empty.INSTANCE.getTextMarks() : ouroMarks);
        }

        @Override // kntr.common.ouro.core.model.node.OuroTextElement, kntr.common.ouro.core.model.node.OuroNode.Markable
        public OuroMarks<OuroTextMark> getMarks() {
            return this.marks;
        }

        @Override // kntr.common.ouro.core.model.node.OuroNode.Element
        public String getMeta() {
            return this.meta;
        }

        @Override // kntr.common.ouro.core.model.node.OuroTextElement
        public HardBreak copyWithMarks(OuroMarks<OuroTextMark> ouroMarks) {
            Intrinsics.checkNotNullParameter(ouroMarks, "marks");
            return new HardBreak(ouroMarks);
        }
    }
}