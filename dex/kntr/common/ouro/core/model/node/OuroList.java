package kntr.common.ouro.core.model.node;

import java.lang.annotation.Annotation;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: OuroList.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u00062\b\u0012\u0004\u0012\u00020\b0\u0007:\u0001\"J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0000H&J\u001a\u0010\u001b\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH&J\u001a\u0010\u001f\u001a\u00020\u0000*\u0006\u0012\u0002\b\u00030\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH&J\u0010\u0010 \u001a\u00020\n*\u0006\u0012\u0002\b\u00030!H&R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0000*\u0006\u0012\u0002\b\u00030\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0001\u0002#$¨\u0006%À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroList;", "Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn;", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroListItem;", "Lkntr/common/ouro/core/model/node/OuroDocumentChild;", "Lkntr/common/ouro/core/model/node/OuroListItemChild;", "Lkntr/common/ouro/core/model/node/OuroQuoteChild;", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "startIndex", "", "getStartIndex", "()I", "listItems", "", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "getListItems", "(Lkntr/common/ouro/core/model/OuroNodeStorage;)Ljava/util/List;", "parentItem", "getParentItem", "(Lkntr/common/ouro/core/model/OuroNodeStorage;)Lkntr/common/ouro/core/model/node/OuroListItem;", "parentList", "getParentList", "(Lkntr/common/ouro/core/model/OuroNodeStorage;)Lkntr/common/ouro/core/model/node/OuroList;", "tryDivide", "Lkotlin/Pair;", "copy", "toUnorderedList", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "recursive", "", "toOrderedList", "getPrefixStyleLevel", "Lkntr/common/ouro/core/model/NodeStorage;", "Companion", "Lkntr/common/ouro/core/model/node/OuroOrderedList;", "Lkntr/common/ouro/core/model/node/OuroUnorderedList;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public interface OuroList extends OuroNode.BuiltIn, OuroNode.Parent<OuroListItem>, OuroDocumentChild, OuroListItemChild, OuroQuoteChild, OuroNode.Markable<OuroParagraphMark> {
    public static final Companion Companion = Companion.$$INSTANCE;

    OuroList copy();

    List<OuroListItem> getListItems(OuroNodeStorage<?> ouroNodeStorage);

    OuroListItem getParentItem(OuroNodeStorage<?> ouroNodeStorage);

    OuroList getParentList(OuroNodeStorage<?> ouroNodeStorage);

    int getPrefixStyleLevel(NodeStorage<?> nodeStorage);

    int getStartIndex();

    OuroList toOrderedList(OuroNodeMutableStorage<?> ouroNodeMutableStorage, boolean z);

    OuroList toUnorderedList(OuroNodeMutableStorage<?> ouroNodeMutableStorage, boolean z);

    @Override // kntr.common.ouro.core.model.node.OuroNode.Parent
    Pair<OuroNode.Parent<OuroListItem>, OuroNode.Parent<OuroListItem>> tryDivide();

    /* compiled from: OuroList.kt */
    /* renamed from: kntr.common.ouro.core.model.node.OuroList$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = OuroList.Companion;
        }

        public static /* synthetic */ OuroListItem access$castChild$jd(OuroList $this, OuroNode other) {
            return (OuroListItem) OuroNode.Parent.CC.$default$castChild($this, other);
        }

        public static Pair $default$tryDivide(OuroList _this) {
            return TuplesKt.to(_this.copy(), _this.copy());
        }

        public static /* synthetic */ OuroList toUnorderedList$default(OuroList ouroList, OuroNodeMutableStorage ouroNodeMutableStorage, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                return ouroList.toUnorderedList(ouroNodeMutableStorage, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toUnorderedList");
        }

        public static /* synthetic */ OuroList toOrderedList$default(OuroList ouroList, OuroNodeMutableStorage ouroNodeMutableStorage, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                return ouroList.toOrderedList(ouroNodeMutableStorage, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toOrderedList");
        }
    }

    /* compiled from: OuroList.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroList$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroList;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<OuroList> serializer() {
            return new SealedClassSerializer<>("kntr.common.ouro.core.model.node.OuroList", Reflection.getOrCreateKotlinClass(OuroList.class), new KClass[]{Reflection.getOrCreateKotlinClass(OuroOrderedList.class), Reflection.getOrCreateKotlinClass(OuroUnorderedList.class)}, new KSerializer[]{OuroOrderedList$$serializer.INSTANCE, OuroUnorderedList$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    /* compiled from: OuroList.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static OuroListItem castChild(OuroList $this, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return CC.access$castChild$jd($this, other);
        }

        @Deprecated
        public static boolean isValidParentOf(OuroList $this, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return OuroNode.Parent.CC.$default$isValidParentOf($this, other);
        }

        @Deprecated
        public static Pair<OuroList, OuroList> tryDivide(OuroList $this) {
            return CC.$default$tryDivide($this);
        }
    }
}