package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksSerializer;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroQuoteBlock.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0002\u001f B\u0017\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\t\u0010\nB+\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0016H\u0016J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroQuoteBlock;", "Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn;", "Lkntr/common/ouro/core/model/node/OuroDocumentChild;", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroQuoteChild;", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/ouro/core/model/mark/OuroMarks;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "castChildOrNull", "other", "Lkntr/common/ouro/core/model/node/OuroNode;", "tryDivide", "Lkotlin/Pair;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroQuoteBlock implements OuroNode.BuiltIn, OuroDocumentChild, OuroNode.Parent<OuroQuoteChild>, OuroNode.Markable<OuroParagraphMark> {
    public static final Companion Companion = new Companion(null);
    private final OuroMarks<OuroParagraphMark> marks;

    public OuroQuoteBlock() {
        this((OuroMarks) null, 1, (DefaultConstructorMarker) null);
    }

    /* compiled from: OuroQuoteBlock.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroQuoteBlock$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroQuoteBlock;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroQuoteBlock> serializer() {
            return OuroQuoteBlock$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroQuoteBlock(int seen0, OuroMarks marks, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.marks = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        } else {
            this.marks = marks;
        }
    }

    public OuroQuoteBlock(OuroMarks<OuroParagraphMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        this.marks = ouroMarks;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroQuoteBlock self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = true;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && Intrinsics.areEqual(self.getMarks(), OuroMarks.Empty.INSTANCE.getParagraphMarks())) {
            z = false;
        }
        if (z) {
            output.encodeSerializableElement(serialDesc, 0, OuroMarksSerializer.INSTANCE, self.getMarks());
        }
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ OuroQuoteChild castChild(OuroNode other) {
        return (OuroQuoteChild) OuroNode.Parent.CC.$default$castChild(this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ boolean isValidParentOf(OuroNode other) {
        return OuroNode.Parent.CC.$default$isValidParentOf(this, other);
    }

    public /* synthetic */ OuroQuoteBlock(OuroMarks<OuroParagraphMark> ouroMarks, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? OuroMarks.Empty.INSTANCE.getParagraphMarks() : ouroMarks);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Markable
    public OuroMarks<OuroParagraphMark> getMarks() {
        return this.marks;
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public OuroQuoteChild castChildOrNull(OuroNode other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof OuroQuoteChild) {
            return (OuroQuoteChild) other;
        }
        return null;
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public Pair<OuroNode.Parent<OuroQuoteChild>, OuroNode.Parent<OuroQuoteChild>> tryDivide() {
        return TuplesKt.to(new OuroQuoteBlock(getMarks()), new OuroQuoteBlock(getMarks()));
    }
}