package kntr.common.ouro.core.model.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksSerializer;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroList.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 42\u00020\u0001:\u000234B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\b\u0010\u0011\u001a\u00020\u0000H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\"*\u0006\u0012\u0002\b\u00030#2\u0006\u0010$\u001a\u00020%H\u0016J\u0018\u0010&\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030(H\u0016J\u0014\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000*H\u0016J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013*\u0006\u0012\u0002\b\u00030\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0014*\u0006\u0012\u0002\b\u00030\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroUnorderedList;", "Lkntr/common/ouro/core/model/node/OuroList;", "startIndex", "", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "<init>", "(ILkntr/common/ouro/core/model/mark/OuroMarks;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILkntr/common/ouro/core/model/mark/OuroMarks;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStartIndex", "()I", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "copy", "listItems", "", "Lkntr/common/ouro/core/model/node/OuroListItem;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "getListItems", "(Lkntr/common/ouro/core/model/OuroNodeStorage;)Ljava/util/List;", "parentItem", "getParentItem", "(Lkntr/common/ouro/core/model/OuroNodeStorage;)Lkntr/common/ouro/core/model/node/OuroListItem;", "parentList", "getParentList", "(Lkntr/common/ouro/core/model/OuroNodeStorage;)Lkntr/common/ouro/core/model/node/OuroList;", "castChildOrNull", "other", "Lkntr/common/ouro/core/model/node/OuroNode;", "toOrderedList", "Lkntr/common/ouro/core/model/node/OuroOrderedList;", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "recursive", "", "toUnorderedList", "getPrefixStyleLevel", "Lkntr/common/ouro/core/model/NodeStorage;", "tryDivide", "Lkotlin/Pair;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroUnorderedList implements OuroList {
    public static final Companion Companion = new Companion(null);
    private final OuroMarks<OuroParagraphMark> marks;
    private final int startIndex;

    public OuroUnorderedList() {
        this(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
    }

    /* compiled from: OuroList.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroUnorderedList$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroUnorderedList;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroUnorderedList> serializer() {
            return OuroUnorderedList$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroUnorderedList(int seen0, int startIndex, OuroMarks marks, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.startIndex = 0;
        } else {
            this.startIndex = startIndex;
        }
        if ((seen0 & 2) == 0) {
            this.marks = new OuroMarks<>(null, 1, null);
        } else {
            this.marks = marks;
        }
    }

    public OuroUnorderedList(int startIndex, OuroMarks<OuroParagraphMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        this.startIndex = startIndex;
        this.marks = ouroMarks;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroUnorderedList self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.getStartIndex() != 0) {
            output.encodeIntElement(serialDesc, 0, self.getStartIndex());
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.getMarks(), new OuroMarks(null, 1, null))) {
            output.encodeSerializableElement(serialDesc, 1, OuroMarksSerializer.INSTANCE, self.getMarks());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ OuroListItem castChild(OuroNode other) {
        return (OuroListItem) OuroNode.Parent.CC.$default$castChild(this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public /* bridge */ boolean isValidParentOf(OuroNode other) {
        return OuroNode.Parent.CC.$default$isValidParentOf(this, other);
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public /* bridge */ /* synthetic */ OuroList toOrderedList(OuroNodeMutableStorage $this$toOrderedList, boolean recursive) {
        return toOrderedList((OuroNodeMutableStorage<?>) $this$toOrderedList, recursive);
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public /* bridge */ /* synthetic */ OuroList toUnorderedList(OuroNodeMutableStorage $this$toUnorderedList, boolean recursive) {
        return toUnorderedList((OuroNodeMutableStorage<?>) $this$toUnorderedList, recursive);
    }

    public /* synthetic */ OuroUnorderedList(int i, OuroMarks ouroMarks, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new OuroMarks(null, 1, null) : ouroMarks);
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Markable
    public OuroMarks<OuroParagraphMark> getMarks() {
        return this.marks;
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public OuroUnorderedList copy() {
        return new OuroUnorderedList(getStartIndex(), getMarks());
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public List<OuroListItem> getListItems(OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Iterable children = ouroNodeStorage.getChildren(this);
        if (children == null) {
            return null;
        }
        Iterable $this$filterIsInstance$iv = children;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof OuroListItem) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public OuroListItem getParentItem(OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        OuroNode.Parent<?> parent = ouroNodeStorage.getParent(this);
        if (parent instanceof OuroListItem) {
            return (OuroListItem) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_parentList_$lambda$0(OuroNode.Parent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it instanceof OuroList;
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public OuroList getParentList(OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        OuroNode.Parent<?> firstAncestorOrNull = ouroNodeStorage.firstAncestorOrNull(this, new Function1() { // from class: kntr.common.ouro.core.model.node.OuroUnorderedList$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean _get_parentList_$lambda$0;
                _get_parentList_$lambda$0 = OuroUnorderedList._get_parentList_$lambda$0((OuroNode.Parent) obj);
                return Boolean.valueOf(_get_parentList_$lambda$0);
            }
        });
        if (firstAncestorOrNull instanceof OuroList) {
            return (OuroList) firstAncestorOrNull;
        }
        return null;
    }

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    public OuroListItem castChildOrNull(OuroNode other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof OuroListItem) {
            return (OuroListItem) other;
        }
        return null;
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public OuroOrderedList toOrderedList(OuroNodeMutableStorage<?> ouroNodeMutableStorage, boolean recursive) {
        Iterable listItems;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        OuroOrderedList orderedList = new OuroOrderedList(getStartIndex(), getMarks());
        if (recursive && (listItems = getListItems(ouroNodeMutableStorage)) != null) {
            Iterable $this$forEach$iv = listItems;
            for (Object element$iv : $this$forEach$iv) {
                OuroListItem item = (OuroListItem) element$iv;
                OuroList it = item.getChildList(ouroNodeMutableStorage);
                if (it != null) {
                    it.toOrderedList(ouroNodeMutableStorage, true);
                }
            }
        }
        List it2 = ouroNodeMutableStorage.removeAllChildren(this);
        if (it2 != null) {
            ouroNodeMutableStorage.add(orderedList, it2);
        }
        ouroNodeMutableStorage.replace(this, (OuroUnorderedList) orderedList);
        return orderedList;
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public OuroUnorderedList toUnorderedList(OuroNodeMutableStorage<?> ouroNodeMutableStorage, boolean recursive) {
        Iterable listItems;
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "<this>");
        if (recursive && (listItems = getListItems(ouroNodeMutableStorage)) != null) {
            Iterable $this$forEach$iv = listItems;
            for (Object element$iv : $this$forEach$iv) {
                OuroListItem item = (OuroListItem) element$iv;
                OuroList it = item.getChildList(ouroNodeMutableStorage);
                if (it != null) {
                    it.toUnorderedList(ouroNodeMutableStorage, true);
                }
            }
        }
        return this;
    }

    @Override // kntr.common.ouro.core.model.node.OuroList
    public int getPrefixStyleLevel(NodeStorage<?> nodeStorage) {
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        int realPrefixIndex = 1;
        OuroUnorderedList $this$getPrefixStyleLevel_u24lambda_u240 = this;
        OuroList curr = $this$getPrefixStyleLevel_u24lambda_u240.getParentList(nodeStorage);
        while (curr instanceof OuroUnorderedList) {
            realPrefixIndex++;
            OuroUnorderedList $this$getPrefixStyleLevel_u24lambda_u240_u240 = (OuroUnorderedList) curr;
            curr = $this$getPrefixStyleLevel_u24lambda_u240_u240.getParentList(nodeStorage);
        }
        return realPrefixIndex % 3;
    }

    @Override // kntr.common.ouro.core.model.node.OuroList, kntr.common.ouro.core.model.node.OuroNode.Parent
    public Pair<OuroNode.Parent<OuroListItem>, OuroNode.Parent<OuroListItem>> tryDivide() {
        return TuplesKt.to(new OuroUnorderedList(getStartIndex(), getMarks()), new OuroUnorderedList(getStartIndex(), getMarks()));
    }
}