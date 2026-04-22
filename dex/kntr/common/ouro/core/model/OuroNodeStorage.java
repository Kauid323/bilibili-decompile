package kntr.common.ouro.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroNode.Parent;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: OuroNodeStorage.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H&J$\u0010/\u001a\n\u0012\u0004\u0012\u0002H0\u0018\u00010\r\"\b\b\u0001\u00100*\u00020\u0005*\b\u0012\u0004\u0012\u0002H00\u0002H\u0016J4\u00101\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00020\u00052\u001a\u00102\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020$03H&J\u0015\u00104\u001a\u00020$*\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0096\u0004J/\u00106\u001a\n\u0012\u0004\u0012\u0002H7\u0018\u00010\u0000\"\u0010\b\u0001\u00107*\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\u0006\u00108\u001a\u0002H7H&¢\u0006\u0002\u00109R\u0012\u0010\u0006\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r*\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0012\u0010#\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u0004\u0018\u00010\u0005*\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u0004\u0018\u00010\u0005*\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0018\u0010,\u001a\u00020$*\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0018\u0010.\u001a\u00020$*\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010-\u0082\u0001\u0002:;¨\u0006<À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/OuroNodeStorage;", "R", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroParent;", "", "Lkntr/common/ouro/core/model/node/OuroNode;", "root", "getRoot", "()Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "parent", "getParent", "(Lkntr/common/ouro/core/model/node/OuroNode;)Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "children", "", "getChildren", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;)Ljava/util/List;", "siblings", "getSiblings", "(Lkntr/common/ouro/core/model/node/OuroNode;)Ljava/util/List;", "indexInSiblings", "", "getIndexInSiblings", "(Lkntr/common/ouro/core/model/node/OuroNode;)Ljava/lang/Integer;", "allSelectables", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "getAllSelectables", "()Ljava/util/List;", "textCount", "getTextCount", "()I", "pictureCount", "getPictureCount", "unuploadedPictureCount", "localImageState", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "hasContent", "", "getHasContent", "()Z", "siblingNext", "getSiblingNext", "(Lkntr/common/ouro/core/model/node/OuroNode;)Lkntr/common/ouro/core/model/node/OuroNode;", "siblingPrev", "getSiblingPrev", "isSiblingLast", "(Lkntr/common/ouro/core/model/node/OuroNode;)Z", "isSiblingFirst", "getChildrenOrNull", "C", "firstAncestorOrNull", "predicate", "Lkotlin/Function1;", "isSiblingOf", "other", "subStorage", "T", "node", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;)Lkntr/common/ouro/core/model/OuroNodeStorage;", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "Lkntr/common/ouro/core/model/OuroNodeStorageBaseImpl;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroNodeStorage<R extends OuroNode.Parent<?>> extends Iterable<OuroNode>, KMappedMarker {
    OuroNode.Parent<?> firstAncestorOrNull(OuroNode ouroNode, Function1<? super OuroNode.Parent<?>, Boolean> function1);

    List<OuroNode.Selectable> getAllSelectables();

    List<OuroNode> getChildren(OuroNode.Parent<?> parent);

    <C extends OuroNode> List<C> getChildrenOrNull(OuroNode.Parent<C> parent);

    boolean getHasContent();

    Integer getIndexInSiblings(OuroNode ouroNode);

    OuroNode.Parent<?> getParent(OuroNode ouroNode);

    int getPictureCount();

    R getRoot();

    OuroNode getSiblingNext(OuroNode ouroNode);

    OuroNode getSiblingPrev(OuroNode ouroNode);

    List<OuroNode> getSiblings(OuroNode ouroNode);

    int getTextCount();

    boolean isSiblingFirst(OuroNode ouroNode);

    boolean isSiblingLast(OuroNode ouroNode);

    boolean isSiblingOf(OuroNode ouroNode, OuroNode ouroNode2);

    <T extends OuroNode.Parent<?>> OuroNodeStorage<T> subStorage(T t);

    int unuploadedPictureCount(OuroLocalImageState ouroLocalImageState);

    /* compiled from: OuroNodeStorage.kt */
    /* renamed from: kntr.common.ouro.core.model.OuroNodeStorage$-CC */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static OuroNode $default$getSiblingNext(OuroNodeStorage _this, OuroNode $this$siblingNext) {
            Intrinsics.checkNotNullParameter($this$siblingNext, "<this>");
            Integer indexInSiblings = _this.getIndexInSiblings($this$siblingNext);
            if (indexInSiblings != null) {
                int it = indexInSiblings.intValue();
                List<OuroNode> siblings = _this.getSiblings($this$siblingNext);
                if (siblings != null) {
                    return (OuroNode) CollectionsKt.getOrNull(siblings, it + 1);
                }
                return null;
            }
            return null;
        }

        public static OuroNode $default$getSiblingPrev(OuroNodeStorage _this, OuroNode $this$siblingPrev) {
            Intrinsics.checkNotNullParameter($this$siblingPrev, "<this>");
            Integer indexInSiblings = _this.getIndexInSiblings($this$siblingPrev);
            if (indexInSiblings != null) {
                int it = indexInSiblings.intValue();
                List<OuroNode> siblings = _this.getSiblings($this$siblingPrev);
                if (siblings != null) {
                    return (OuroNode) CollectionsKt.getOrNull(siblings, it - 1);
                }
                return null;
            }
            return null;
        }

        public static boolean $default$isSiblingLast(OuroNodeStorage _this, OuroNode $this$isSiblingLast) {
            Intrinsics.checkNotNullParameter($this$isSiblingLast, "<this>");
            return _this.getSiblingNext($this$isSiblingLast) == null;
        }

        public static boolean $default$isSiblingFirst(OuroNodeStorage _this, OuroNode $this$isSiblingFirst) {
            Intrinsics.checkNotNullParameter($this$isSiblingFirst, "<this>");
            return _this.getSiblingPrev($this$isSiblingFirst) == null;
        }

        public static List $default$getChildrenOrNull(OuroNodeStorage _this, OuroNode.Parent $this$getChildrenOrNull) {
            Intrinsics.checkNotNullParameter($this$getChildrenOrNull, "<this>");
            Iterable children = _this.getChildren($this$getChildrenOrNull);
            if (children == null) {
                return null;
            }
            Iterable $this$map$iv = children;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OuroNode it = (OuroNode) item$iv$iv;
                destination$iv$iv.add($this$getChildrenOrNull.castChild(it));
            }
            return (List) destination$iv$iv;
        }

        public static boolean $default$isSiblingOf(OuroNodeStorage _this, OuroNode $this$isSiblingOf, OuroNode other) {
            Intrinsics.checkNotNullParameter($this$isSiblingOf, "<this>");
            Intrinsics.checkNotNullParameter(other, "other");
            OuroNode.Parent it = _this.getParent($this$isSiblingOf);
            if (it != null) {
                return Intrinsics.areEqual(it, _this.getParent(other));
            }
            return false;
        }
    }

    /* compiled from: OuroNodeStorage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <R extends OuroNode.Parent<?>> OuroNode getSiblingNext(OuroNodeStorage<R> ouroNodeStorage, OuroNode $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return CC.$default$getSiblingNext(ouroNodeStorage, $receiver);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> OuroNode getSiblingPrev(OuroNodeStorage<R> ouroNodeStorage, OuroNode $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return CC.$default$getSiblingPrev(ouroNodeStorage, $receiver);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> boolean isSiblingLast(OuroNodeStorage<R> ouroNodeStorage, OuroNode $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return CC.$default$isSiblingLast(ouroNodeStorage, $receiver);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> boolean isSiblingFirst(OuroNodeStorage<R> ouroNodeStorage, OuroNode $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return CC.$default$isSiblingFirst(ouroNodeStorage, $receiver);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> List<C> getChildrenOrNull(OuroNodeStorage<R> ouroNodeStorage, OuroNode.Parent<C> parent) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            return CC.$default$getChildrenOrNull(ouroNodeStorage, parent);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> boolean isSiblingOf(OuroNodeStorage<R> ouroNodeStorage, OuroNode $receiver, OuroNode other) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            Intrinsics.checkNotNullParameter(other, "other");
            return CC.$default$isSiblingOf(ouroNodeStorage, $receiver, other);
        }
    }
}