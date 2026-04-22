package kntr.common.ouro.core.model.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksSerializer;
import kntr.common.ouro.core.model.mark.OuroTextMark;
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

/* compiled from: OuroList.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 22\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00020\u00050\u0004:\u000212B'\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\t\u0010\nB;\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ&\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007J\u0012\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010%\u001a\u00020&H\u0016J\u0014\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000(H\u0016J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R!\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014*\u0006\u0012\u0002\b\u00030\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u0006\u0012\u0002\b\u00030\u00168F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001a*\u0006\u0012\u0002\b\u00030\u00168F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u001b\u0010\u001f\u001a\u0004\u0018\u00010 *\u0006\u0012\u0002\b\u00030\u00168F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u001b\u0010\"\u001a\u0004\u0018\u00010 *\u0006\u0012\u0002\b\u00030\u00168F¢\u0006\u0006\u001a\u0004\b\"\u0010!¨\u00063"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroListItem;", "Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn;", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroListItemChild;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "prefixMarks", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroMarks;Lkntr/common/ouro/core/model/mark/OuroMarks;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/ouro/core/model/mark/OuroMarks;Lkntr/common/ouro/core/model/mark/OuroMarks;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "getPrefixMarks", "leadingParagraphs", "", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "getLeadingParagraphs", "(Lkntr/common/ouro/core/model/OuroNodeStorage;)Ljava/util/List;", "parentList", "Lkntr/common/ouro/core/model/node/OuroList;", "getParentList", "(Lkntr/common/ouro/core/model/OuroNodeStorage;)Lkntr/common/ouro/core/model/node/OuroList;", "childList", "getChildList", "isFirst", "", "(Lkntr/common/ouro/core/model/OuroNodeStorage;)Ljava/lang/Boolean;", "isLast", "copy", "castChildOrNull", "other", "Lkntr/common/ouro/core/model/node/OuroNode;", "tryDivide", "Lkotlin/Pair;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroListItem implements OuroNode.BuiltIn, OuroNode.Markable<OuroTextMark>, OuroNode.Parent<OuroListItemChild> {
    public static final Companion Companion = new Companion(null);
    private final OuroMarks<OuroTextMark> marks;
    private final OuroMarks<OuroTextMark> prefixMarks;

    public OuroListItem() {
        this((OuroMarks) null, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
    }

    /* compiled from: OuroList.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroListItem$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroListItem;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroListItem> serializer() {
            return OuroListItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroListItem(int seen0, OuroMarks marks, OuroMarks prefixMarks, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.marks = OuroMarks.Empty.INSTANCE.getTextMarks();
        } else {
            this.marks = marks;
        }
        if ((seen0 & 2) == 0) {
            this.prefixMarks = OuroMarks.Empty.INSTANCE.getTextMarks();
        } else {
            this.prefixMarks = prefixMarks;
        }
    }

    public OuroListItem(OuroMarks<OuroTextMark> ouroMarks, OuroMarks<OuroTextMark> ouroMarks2) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(ouroMarks2, "prefixMarks");
        this.marks = ouroMarks;
        this.prefixMarks = ouroMarks2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroListItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.getMarks(), OuroMarks.Empty.INSTANCE.getTextMarks())) {
            output.encodeSerializableElement(serialDesc, 0, OuroMarksSerializer.INSTANCE, self.getMarks());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.prefixMarks, OuroMarks.Empty.INSTANCE.getTextMarks())) {
            output.encodeSerializableElement(serialDesc, 1, OuroMarksSerializer.INSTANCE, self.prefixMarks);
        }
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ OuroListItemChild castChild(OuroNode other) {
        return (OuroListItemChild) OuroNode.Parent.CC.$default$castChild(this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ boolean isValidParentOf(OuroNode other) {
        return OuroNode.Parent.CC.$default$isValidParentOf(this, other);
    }

    public /* synthetic */ OuroListItem(OuroMarks<OuroTextMark> ouroMarks, OuroMarks<OuroTextMark> ouroMarks2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? OuroMarks.Empty.INSTANCE.getTextMarks() : ouroMarks, (i & 2) != 0 ? OuroMarks.Empty.INSTANCE.getTextMarks() : ouroMarks2);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Markable
    public OuroMarks<OuroTextMark> getMarks() {
        return this.marks;
    }

    public final OuroMarks<OuroTextMark> getPrefixMarks() {
        return this.prefixMarks;
    }

    public final List<OuroParagraph> getLeadingParagraphs(OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Iterable children = ouroNodeStorage.getChildren(this);
        if (children != null) {
            Iterable $this$takeWhile$iv = children;
            ArrayList list$iv = new ArrayList();
            for (Object item$iv : $this$takeWhile$iv) {
                OuroNode it = (OuroNode) item$iv;
                if (!(it instanceof OuroParagraph)) {
                    break;
                }
                list$iv.add(item$iv);
            }
            ArrayList $this$takeWhile$iv2 = list$iv;
            ArrayList $this$filterIsInstance$iv = $this$takeWhile$iv2;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                if (element$iv$iv instanceof OuroParagraph) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            return (List) destination$iv$iv;
        }
        return null;
    }

    public final OuroList getParentList(OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        OuroNode.Parent<?> parent = ouroNodeStorage.getParent(this);
        if (parent instanceof OuroList) {
            return (OuroList) parent;
        }
        return null;
    }

    public final OuroList getChildList(OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Iterable children = ouroNodeStorage.getChildren(this);
        Object obj = null;
        if (children != null) {
            Iterable $this$firstOrNull$iv = children;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                OuroNode it2 = (OuroNode) element$iv;
                if (it2 instanceof OuroList) {
                    obj = element$iv;
                    break;
                }
            }
            obj = (OuroNode) obj;
        }
        return (OuroList) obj;
    }

    public final Boolean isFirst(OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        List<OuroNode> siblings = ouroNodeStorage.getSiblings(this);
        if (siblings == null || siblings.isEmpty()) {
            return null;
        }
        return Boolean.valueOf(ouroNodeStorage.getSiblingPrev(this) == null);
    }

    public final Boolean isLast(OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        List<OuroNode> siblings = ouroNodeStorage.getSiblings(this);
        if (siblings == null || siblings.isEmpty()) {
            return null;
        }
        return Boolean.valueOf(ouroNodeStorage.getSiblingNext(this) == null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroListItem copy$default(OuroListItem ouroListItem, OuroMarks ouroMarks, OuroMarks ouroMarks2, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroMarks = ouroListItem.getMarks();
        }
        if ((i & 2) != 0) {
            ouroMarks2 = ouroListItem.prefixMarks;
        }
        return ouroListItem.copy(ouroMarks, ouroMarks2);
    }

    public final OuroListItem copy(OuroMarks<OuroTextMark> ouroMarks, OuroMarks<OuroTextMark> ouroMarks2) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(ouroMarks2, "prefixMarks");
        return new OuroListItem(ouroMarks, ouroMarks2);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public OuroListItemChild castChildOrNull(OuroNode other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof OuroListItemChild) {
            return (OuroListItemChild) other;
        }
        return null;
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public Pair<OuroNode.Parent<OuroListItemChild>, OuroNode.Parent<OuroListItemChild>> tryDivide() {
        return TuplesKt.to(copy$default(this, null, null, 3, null), copy$default(this, null, null, 3, null));
    }
}