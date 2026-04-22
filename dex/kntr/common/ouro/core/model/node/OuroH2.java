package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroFontSizeMark;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksSerializer;
import kntr.common.ouro.core.model.mark.OuroMediumMark;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroParagraph.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B;\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0005\u0010\rJ\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0001¢\u0006\u0002\b\u001bR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001e"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroH2;", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "paragraphMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;)V", "seen0", "", "marks", "Lkntr/common/ouro/core/model/mark/OuroMark;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/ouro/core/model/mark/OuroMarks;Lkntr/common/ouro/core/model/mark/OuroMarks;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getParagraphMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "tryDivide", "Lkotlin/Pair;", "copyWithMarks", "getMarks", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Companion", "$serializer", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroH2 extends OuroParagraph {
    public static final Companion Companion = new Companion(null);
    private static final OuroMarks<? extends OuroMark> DefaultTextMarks = new OuroMarks<>(new OuroFontSizeMark(18.0f), OuroMediumMark.INSTANCE);
    private final OuroMarks<OuroMark> marks;
    private final OuroMarks<OuroParagraphMark> paragraphMarks;

    public OuroH2() {
        this(null, 1, null);
    }

    public /* synthetic */ OuroH2(int seen0, OuroMarks paragraphMarks, OuroMarks marks, SerializationConstructorMarker serializationConstructorMarker) {
        super(seen0, serializationConstructorMarker);
        if ((seen0 & 1) == 0) {
            this.paragraphMarks = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        } else {
            this.paragraphMarks = paragraphMarks;
        }
        if ((seen0 & 2) == 0) {
            this.marks = new OuroMarks<>(CollectionsKt.plus(getParagraphMarks(), DefaultTextMarks));
        } else {
            this.marks = marks;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OuroH2(OuroMarks<OuroParagraphMark> ouroMarks) {
        super(null);
        Intrinsics.checkNotNullParameter(ouroMarks, "paragraphMarks");
        this.paragraphMarks = ouroMarks;
        this.marks = new OuroMarks<>(CollectionsKt.plus(getParagraphMarks(), DefaultTextMarks));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroH2 self, CompositeEncoder output, SerialDescriptor serialDesc) {
        OuroParagraph.write$Self(self, output, serialDesc);
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.getParagraphMarks(), OuroMarks.Empty.INSTANCE.getParagraphMarks())) {
            output.encodeSerializableElement(serialDesc, 0, OuroMarksSerializer.INSTANCE, self.getParagraphMarks());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.getMarks(), new OuroMarks(CollectionsKt.plus(self.getParagraphMarks(), DefaultTextMarks)))) {
            output.encodeSerializableElement(serialDesc, 1, OuroMarksSerializer.INSTANCE, self.getMarks());
        }
    }

    @Override // kntr.common.ouro.core.model.node.OuroParagraph
    public /* bridge */ /* synthetic */ OuroParagraph copyWithMarks(OuroMarks paragraphMarks) {
        return copyWithMarks((OuroMarks<OuroParagraphMark>) paragraphMarks);
    }

    public /* synthetic */ OuroH2(OuroMarks<OuroParagraphMark> ouroMarks, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? OuroMarks.Empty.INSTANCE.getParagraphMarks() : ouroMarks);
    }

    @Override // kntr.common.ouro.core.model.node.OuroParagraph
    public OuroMarks<OuroParagraphMark> getParagraphMarks() {
        return this.paragraphMarks;
    }

    /* compiled from: OuroParagraph.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0016\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroH2$Companion;", "", "<init>", "()V", "DefaultTextMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroH2;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroH2> serializer() {
            return OuroH2$$serializer.INSTANCE;
        }
    }

    @Override // kntr.common.ouro.core.model.node.OuroParagraph, kntr.common.ouro.core.model.node.OuroNode.Parent
    public Pair<OuroH2, OuroH2> tryDivide() {
        return TuplesKt.to(new OuroH2(getParagraphMarks()), new OuroH2(getParagraphMarks()));
    }

    @Override // kntr.common.ouro.core.model.node.OuroParagraph
    public OuroH2 copyWithMarks(OuroMarks<OuroParagraphMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroMarks, "paragraphMarks");
        return new OuroH2(ouroMarks);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Markable
    public OuroMarks<OuroMark> getMarks() {
        return this.marks;
    }
}