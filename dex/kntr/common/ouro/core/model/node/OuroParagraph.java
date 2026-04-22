package kntr.common.ouro.core.model.node;

import java.lang.annotation.Annotation;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroParagraph.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 $2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00060\u00052\u00020\u00072\u00020\b2\u00020\t:\u0001$B\t\b\u0004¢\u0006\u0004\b\n\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u0012*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u001c\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0007R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0001\u0004%&'(¨\u0006)"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroParagraph;", "Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn;", "Lkntr/common/ouro/core/model/node/OuroNode$Absorbable;", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroParagraphChild;", "Lkntr/common/ouro/core/model/node/OuroDocumentChild;", "Lkntr/common/ouro/core/model/node/OuroQuoteChild;", "Lkntr/common/ouro/core/model/node/OuroListItemChild;", "<init>", "()V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "tryAbsorb", "", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "other", "Lkntr/common/ouro/core/model/node/OuroNode;", "castChildOrNull", "paragraphMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "getParagraphMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "copyWithMarks", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "Lkntr/common/ouro/core/model/node/OuroH1;", "Lkntr/common/ouro/core/model/node/OuroH2;", "Lkntr/common/ouro/core/model/node/OuroH3;", "Lkntr/common/ouro/core/model/node/OuroText;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public abstract class OuroParagraph implements OuroNode.BuiltIn, OuroNode.Absorbable, OuroNode.Markable<OuroMark>, OuroNode.Parent<OuroParagraphChild>, OuroDocumentChild, OuroQuoteChild, OuroListItemChild {
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.node.OuroParagraph$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _init_$_anonymous_;
            _init_$_anonymous_ = OuroParagraph._init_$_anonymous_();
            return _init_$_anonymous_;
        }
    });

    public /* synthetic */ OuroParagraph(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self(OuroParagraph ouroParagraph, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
    }

    public abstract OuroParagraph copyWithMarks(OuroMarks<OuroParagraphMark> ouroMarks);

    public abstract OuroMarks<OuroParagraphMark> getParagraphMarks();

    /* compiled from: OuroParagraph.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroParagraph$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) OuroParagraph.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<OuroParagraph> serializer() {
            return get$cachedSerializer();
        }
    }

    private OuroParagraph() {
    }

    public /* synthetic */ OuroParagraph(int seen0, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new SealedClassSerializer("kntr.common.ouro.core.model.node.OuroParagraph", Reflection.getOrCreateKotlinClass(OuroParagraph.class), new KClass[]{Reflection.getOrCreateKotlinClass(OuroH1.class), Reflection.getOrCreateKotlinClass(OuroH2.class), Reflection.getOrCreateKotlinClass(OuroH3.class), Reflection.getOrCreateKotlinClass(OuroText.class)}, new KSerializer[]{OuroH1$$serializer.INSTANCE, OuroH2$$serializer.INSTANCE, OuroH3$$serializer.INSTANCE, OuroText$$serializer.INSTANCE}, new Annotation[0]);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ OuroParagraphChild castChild(OuroNode other) {
        return (OuroParagraphChild) OuroNode.Parent.CC.$default$castChild(this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ boolean isValidParentOf(OuroNode other) {
        return OuroNode.Parent.CC.$default$isValidParentOf(this, other);
    }

    public /* bridge */ Pair<OuroNode.Parent<OuroParagraphChild>, OuroNode.Parent<OuroParagraphChild>> tryDivide() {
        return OuroNode.Parent.CC.$default$tryDivide(this);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Absorbable
    public boolean tryAbsorb(OuroNodeStorage<?> ouroNodeStorage, OuroNode other) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof OuroParagraph) {
            List<OuroNode> children = ouroNodeStorage.getChildren(this);
            if (!((children != null ? (OuroNode) CollectionsKt.lastOrNull(children) : null) instanceof OuroTextElement.HardBreak)) {
                return true;
            }
        }
        return false;
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public OuroParagraphChild castChildOrNull(OuroNode other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof OuroParagraphChild) {
            return (OuroParagraphChild) other;
        }
        return null;
    }
}