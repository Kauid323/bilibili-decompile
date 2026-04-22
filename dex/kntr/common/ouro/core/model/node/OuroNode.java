package kntr.common.ouro.core.model.node;

import java.lang.annotation.Annotation;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: OuroNode.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\bf\u0018\u00002\u00020\u0001:\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode;", "", "BuiltIn", "Parent", "Root", "Mergeable", "Absorbable", "Selectable", "Separable", "Markable", "Element", "DeleteConfirm", "Copyable", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroNode {

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0001H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$Absorbable;", "Lkntr/common/ouro/core/model/node/OuroNode;", "tryAbsorb", "", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "other", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Absorbable extends OuroNode {
        boolean tryAbsorb(OuroNodeStorage<?> ouroNodeStorage, OuroNode ouroNode);
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$Copyable;", "Lkntr/common/ouro/core/model/node/OuroNode;", "copyText", "", "getCopyText", "()Ljava/lang/String;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Copyable extends OuroNode {
        String getCopyText();
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$DeleteConfirm;", "Lkntr/common/ouro/core/model/node/OuroNode;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface DeleteConfirm extends OuroNode {
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002R\u0012\u0010\u0003\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$Element;", "T", "Lkntr/common/ouro/core/model/node/OuroNode;", "meta", "getMeta", "()Ljava/lang/Object;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Element<T> extends OuroNode {
        T getMeta();
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "T", "Lkntr/common/ouro/core/model/mark/OuroMark;", "Lkntr/common/ouro/core/model/node/OuroNode;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "getMarks", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Markable<T extends OuroMark> extends OuroNode {
        OuroMarks<T> getMarks();
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0001H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$Mergeable;", "Lkntr/common/ouro/core/model/node/OuroNode;", "tryMergeWith", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "other", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Mergeable extends OuroNode {
        OuroNode tryMergeWith(OuroNodeStorage<?> ouroNodeStorage, OuroNode ouroNode);
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "Lkntr/common/ouro/core/model/node/OuroNode;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Selectable extends OuroNode {
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u00072\n\u0010\b\u001a\u00020\t\"\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$Separable;", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "length", "", "getLength", "()I", "separate", "", "offsets", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Separable extends Selectable {
        int getLength();

        List<Separable> separate(int... iArr);
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0007\u0003\u0004\u0005\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn;", "Lkntr/common/ouro/core/model/node/OuroNode;", "Companion", "Lkntr/common/ouro/core/model/node/OuroDocument;", "Lkntr/common/ouro/core/model/node/OuroLink;", "Lkntr/common/ouro/core/model/node/OuroList;", "Lkntr/common/ouro/core/model/node/OuroListItem;", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "Lkntr/common/ouro/core/model/node/OuroQuoteBlock;", "Lkntr/common/ouro/core/model/node/OuroTextElement;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface BuiltIn extends OuroNode {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* compiled from: OuroNode.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<BuiltIn> serializer() {
                return new SealedClassSerializer<>("kntr.common.ouro.core.model.node.OuroNode.BuiltIn", Reflection.getOrCreateKotlinClass(BuiltIn.class), new KClass[]{Reflection.getOrCreateKotlinClass(OuroDocument.class), Reflection.getOrCreateKotlinClass(OuroLink.class), Reflection.getOrCreateKotlinClass(OuroOrderedList.class), Reflection.getOrCreateKotlinClass(OuroUnorderedList.class), Reflection.getOrCreateKotlinClass(OuroListItem.class), Reflection.getOrCreateKotlinClass(OuroH1.class), Reflection.getOrCreateKotlinClass(OuroH2.class), Reflection.getOrCreateKotlinClass(OuroH3.class), Reflection.getOrCreateKotlinClass(OuroText.class), Reflection.getOrCreateKotlinClass(OuroQuoteBlock.class), Reflection.getOrCreateKotlinClass(OuroTextElement.HardBreak.class), Reflection.getOrCreateKotlinClass(OuroTextElement.Plain.class)}, new KSerializer[]{OuroDocument$$serializer.INSTANCE, new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(OuroLink.class), new Annotation[0]), OuroOrderedList$$serializer.INSTANCE, OuroUnorderedList$$serializer.INSTANCE, OuroListItem$$serializer.INSTANCE, OuroH1$$serializer.INSTANCE, OuroH2$$serializer.INSTANCE, OuroH3$$serializer.INSTANCE, OuroText$$serializer.INSTANCE, OuroQuoteBlock$$serializer.INSTANCE, OuroTextElement$HardBreak$$serializer.INSTANCE, OuroTextElement$Plain$$serializer.INSTANCE}, new Annotation[0]);
            }
        }
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\t\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\nH\u0016¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "C", "Lkntr/common/ouro/core/model/node/OuroNode;", "castChildOrNull", "other", "(Lkntr/common/ouro/core/model/node/OuroNode;)Lkntr/common/ouro/core/model/node/OuroNode;", "castChild", "isValidParentOf", "", "tryDivide", "Lkotlin/Pair;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Parent<C extends OuroNode> extends OuroNode {
        C castChild(OuroNode ouroNode);

        C castChildOrNull(OuroNode ouroNode);

        boolean isValidParentOf(OuroNode ouroNode);

        Pair<Parent<C>, Parent<C>> tryDivide();

        /* compiled from: OuroNode.kt */
        /* renamed from: kntr.common.ouro.core.model.node.OuroNode$Parent$-CC */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            public static OuroNode $default$castChild(Parent _this, OuroNode other) {
                Intrinsics.checkNotNullParameter(other, "other");
                OuroNode castChildOrNull = _this.castChildOrNull(other);
                if (castChildOrNull == null) {
                    throw new IllegalArgumentException((other + " is not a valid child for " + _this).toString());
                }
                return castChildOrNull;
            }

            public static boolean $default$isValidParentOf(Parent _this, OuroNode other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return _this.castChildOrNull(other) != null;
            }

            public static Pair $default$tryDivide(Parent _this) {
                return null;
            }
        }

        /* compiled from: OuroNode.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static <C extends OuroNode> C castChild(Parent<C> parent, OuroNode other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return (C) CC.$default$castChild(parent, other);
            }

            @Deprecated
            public static <C extends OuroNode> boolean isValidParentOf(Parent<C> parent, OuroNode other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return CC.$default$isValidParentOf(parent, other);
            }

            @Deprecated
            public static <C extends OuroNode> Pair<Parent<C>, Parent<C>> tryDivide(Parent<C> parent) {
                return CC.$default$tryDivide(parent);
            }
        }
    }

    /* compiled from: OuroNode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0082\u0001\u0001\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroNode$Root;", "C", "Lkntr/common/ouro/core/model/node/OuroNode;", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Root<C extends OuroNode> extends Parent<C> {

        /* compiled from: OuroNode.kt */
        /* renamed from: kntr.common.ouro.core.model.node.OuroNode$Root$-CC */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
        }

        /* compiled from: OuroNode.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static <C extends OuroNode> C castChild(Root<C> root, OuroNode other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return (C) Parent.CC.$default$castChild(root, other);
            }

            @Deprecated
            public static <C extends OuroNode> boolean isValidParentOf(Root<C> root, OuroNode other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return Parent.CC.$default$isValidParentOf(root, other);
            }

            @Deprecated
            public static <C extends OuroNode> Pair<Parent<C>, Parent<C>> tryDivide(Root<C> root) {
                return Parent.CC.$default$tryDivide(root);
            }
        }
    }
}