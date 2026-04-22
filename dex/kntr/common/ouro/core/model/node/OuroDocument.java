package kntr.common.ouro.core.model.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksSerializer;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroDocument.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 &2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0002%&B\u0017\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\b\u0010\tB+\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\u0010R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0018\u0010\u0010¨\u0006'"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroDocument;", "Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn;", "Lkntr/common/ouro/core/model/node/OuroNode$Root;", "Lkntr/common/ouro/core/model/node/OuroDocumentChild;", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/ouro/core/model/mark/OuroMarks;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "textMarks", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "getTextMarks", "textMarks$delegate", "Lkotlin/Lazy;", "paragraphMarks", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "getParagraphMarks", "paragraphMarks$delegate", "castChildOrNull", "other", "Lkntr/common/ouro/core/model/node/OuroNode;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroDocument implements OuroNode.BuiltIn, OuroNode.Root<OuroDocumentChild>, OuroNode.Markable<OuroMark> {
    public static final Companion Companion = new Companion(null);
    private final OuroMarks<OuroMark> marks;
    private final Lazy paragraphMarks$delegate;
    private final Lazy textMarks$delegate;

    public OuroDocument() {
        this((OuroMarks) null, 1, (DefaultConstructorMarker) null);
    }

    /* compiled from: OuroDocument.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroDocument$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroDocument> serializer() {
            return OuroDocument$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroDocument(int seen0, OuroMarks marks, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.marks = OuroMarks.Empty.INSTANCE.getMarks();
        } else {
            this.marks = marks;
        }
        this.textMarks$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.node.OuroDocument$$ExternalSyntheticLambda2
            public final Object invoke() {
                OuroMarks _init_$lambda$0;
                _init_$lambda$0 = OuroDocument._init_$lambda$0(OuroDocument.this);
                return _init_$lambda$0;
            }
        });
        this.paragraphMarks$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.node.OuroDocument$$ExternalSyntheticLambda3
            public final Object invoke() {
                OuroMarks _init_$lambda$1;
                _init_$lambda$1 = OuroDocument._init_$lambda$1(OuroDocument.this);
                return _init_$lambda$1;
            }
        });
    }

    public OuroDocument(OuroMarks<OuroMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        this.marks = ouroMarks;
        this.textMarks$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.node.OuroDocument$$ExternalSyntheticLambda0
            public final Object invoke() {
                OuroMarks textMarks_delegate$lambda$0;
                textMarks_delegate$lambda$0 = OuroDocument.textMarks_delegate$lambda$0(OuroDocument.this);
                return textMarks_delegate$lambda$0;
            }
        });
        this.paragraphMarks$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.node.OuroDocument$$ExternalSyntheticLambda1
            public final Object invoke() {
                OuroMarks paragraphMarks_delegate$lambda$0;
                paragraphMarks_delegate$lambda$0 = OuroDocument.paragraphMarks_delegate$lambda$0(OuroDocument.this);
                return paragraphMarks_delegate$lambda$0;
            }
        });
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroDocument self, CompositeEncoder output, SerialDescriptor serialDesc) {
        boolean z = true;
        if (!output.shouldEncodeElementDefault(serialDesc, 0) && Intrinsics.areEqual(self.getMarks(), OuroMarks.Empty.INSTANCE.getMarks())) {
            z = false;
        }
        if (z) {
            output.encodeSerializableElement(serialDesc, 0, OuroMarksSerializer.INSTANCE, self.getMarks());
        }
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ OuroDocumentChild castChild(OuroNode other) {
        return (OuroDocumentChild) OuroNode.Parent.CC.$default$castChild(this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ boolean isValidParentOf(OuroNode other) {
        return OuroNode.Parent.CC.$default$isValidParentOf(this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ Pair<OuroNode.Parent<OuroDocumentChild>, OuroNode.Parent<OuroDocumentChild>> tryDivide() {
        return OuroNode.Parent.CC.$default$tryDivide(this);
    }

    public /* synthetic */ OuroDocument(OuroMarks<OuroMark> ouroMarks, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? OuroMarks.Empty.INSTANCE.getMarks() : ouroMarks);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Markable
    public OuroMarks<OuroMark> getMarks() {
        return this.marks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroMarks _init_$lambda$0(OuroDocument this$0) {
        Iterable $this$filterInstanceOf$iv = this$0.getMarks();
        Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
        Collection destination$iv$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
            if (element$iv$iv$iv instanceof OuroTextMark) {
                destination$iv$iv$iv.add(element$iv$iv$iv);
            }
        }
        return new OuroMarks((List) destination$iv$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroMarks textMarks_delegate$lambda$0(OuroDocument this$0) {
        Iterable $this$filterInstanceOf$iv = this$0.getMarks();
        Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
        Collection destination$iv$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
            if (element$iv$iv$iv instanceof OuroTextMark) {
                destination$iv$iv$iv.add(element$iv$iv$iv);
            }
        }
        return new OuroMarks((List) destination$iv$iv$iv);
    }

    public final OuroMarks<OuroTextMark> getTextMarks() {
        return (OuroMarks) this.textMarks$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroMarks _init_$lambda$1(OuroDocument this$0) {
        Iterable $this$filterInstanceOf$iv = this$0.getMarks();
        Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
        Collection destination$iv$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
            if (element$iv$iv$iv instanceof OuroParagraphMark) {
                destination$iv$iv$iv.add(element$iv$iv$iv);
            }
        }
        return new OuroMarks((List) destination$iv$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroMarks paragraphMarks_delegate$lambda$0(OuroDocument this$0) {
        Iterable $this$filterInstanceOf$iv = this$0.getMarks();
        Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
        Collection destination$iv$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
            if (element$iv$iv$iv instanceof OuroParagraphMark) {
                destination$iv$iv$iv.add(element$iv$iv$iv);
            }
        }
        return new OuroMarks((List) destination$iv$iv$iv);
    }

    public final OuroMarks<OuroParagraphMark> getParagraphMarks() {
        return (OuroMarks) this.paragraphMarks$delegate.getValue();
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public OuroDocumentChild castChildOrNull(OuroNode other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof OuroDocumentChild) {
            return (OuroDocumentChild) other;
        }
        return null;
    }
}