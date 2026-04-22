package kntr.app.tribee.consume.page.mine;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntry;
import com.bapis.bilibili.app.dynamic.v2.KNavigationType;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ItemSectionPosition.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0007J\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\fJ?\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\""}, d2 = {"Lkntr/app/tribee/consume/page/mine/MineMenuGroupUtil;", "", "<init>", "()V", "groups", "", "", "Lcom/bapis/bilibili/app/dynamic/v2/KNavigationType;", "[Ljava/util/Set;", "findGroup", "navigation", "getSectionPosition", "Lkntr/app/tribee/consume/page/mine/ItemSectionPosition;", "last", "Lcom/bapis/bilibili/app/dynamic/v2/KNavigationEntry;", "current", "next", "checkItemSectionPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "itemSectionPosition", "checkItemSectionBackgroundShape", "Landroidx/compose/ui/graphics/Shape;", "checkItemSectionDivider", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "color", "Landroidx/compose/ui/graphics/Color;", "startOffset", "Landroidx/compose/ui/geometry/Offset;", "endOffset", "strokeWidth", "", "checkItemSectionDivider-WBdyNhk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JLkntr/app/tribee/consume/page/mine/ItemSectionPosition;JJF)V", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MineMenuGroupUtil {
    public static final MineMenuGroupUtil INSTANCE = new MineMenuGroupUtil();
    private static final Set<KNavigationType>[] groups = {SetsKt.setOf(new KNavigationType[]{KNavigationType.SHARE.INSTANCE, KNavigationType.INVITE_CODE.INSTANCE, KNavigationType.DISPLAY_APP_MINE.INSTANCE}), SetsKt.setOf(new KNavigationType[]{KNavigationType.MY_POST.INSTANCE, KNavigationType.GAME_STATS.INSTANCE})};
    public static final int $stable = 8;

    /* compiled from: ItemSectionPosition.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemSectionPosition.values().length];
            try {
                iArr[ItemSectionPosition.Independently.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ItemSectionPosition.InMiddle.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ItemSectionPosition.InTop.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ItemSectionPosition.InBottom.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private MineMenuGroupUtil() {
    }

    public final Set<KNavigationType> findGroup(KNavigationType navigation) {
        Set[] setArr;
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        for (Set it : groups) {
            if (it.contains(navigation)) {
                return it;
            }
        }
        return null;
    }

    public final ItemSectionPosition getSectionPosition(KNavigationEntry last, KNavigationEntry current, KNavigationEntry next) {
        Intrinsics.checkNotNullParameter(current, "current");
        Set group = findGroup(current.getNavigationType());
        if (group == null || group.size() <= 1) {
            return ItemSectionPosition.Independently;
        }
        boolean lastInGroup = CollectionsKt.contains(group, last != null ? last.getNavigationType() : null);
        boolean nextInGroup = CollectionsKt.contains(group, next != null ? next.getNavigationType() : null);
        return (lastInGroup && nextInGroup) ? ItemSectionPosition.InMiddle : lastInGroup ? ItemSectionPosition.InBottom : nextInGroup ? ItemSectionPosition.InTop : ItemSectionPosition.Independently;
    }

    public final PaddingValues checkItemSectionPadding(ItemSectionPosition itemSectionPosition) {
        Intrinsics.checkNotNullParameter(itemSectionPosition, "itemSectionPosition");
        switch (WhenMappings.$EnumSwitchMapping$0[itemSectionPosition.ordinal()]) {
            case 1:
                return PaddingKt.PaddingValues-YgX7TsA$default(0.0f, Dp.constructor-impl(4), 1, (Object) null);
            case 2:
                return PaddingKt.PaddingValues-YgX7TsA$default(0.0f, Dp.constructor-impl(0), 1, (Object) null);
            case 3:
                return PaddingKt.PaddingValues-a9UjIt4$default(0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null);
            case 4:
                return PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.constructor-impl(4), 7, (Object) null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final Shape checkItemSectionBackgroundShape(ItemSectionPosition itemSectionPosition) {
        Intrinsics.checkNotNullParameter(itemSectionPosition, "itemSectionPosition");
        switch (WhenMappings.$EnumSwitchMapping$0[itemSectionPosition.ordinal()]) {
            case 1:
                return RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
            case 2:
                return RectangleShapeKt.getRectangleShape();
            case 3:
                return RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null);
            case 4:
                return RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(12), 3, (Object) null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: checkItemSectionDivider-WBdyNhk$default  reason: not valid java name */
    public static /* synthetic */ void m743checkItemSectionDividerWBdyNhk$default(MineMenuGroupUtil mineMenuGroupUtil, DrawScope drawScope, long j, ItemSectionPosition itemSectionPosition, long j2, long j3, float f, int i, Object obj) {
        long j4;
        long j5;
        if ((i & 4) != 0) {
            float x$iv = drawScope.toPx-0680j_4(Dp.constructor-impl(12));
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(0.0f);
            j4 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        } else {
            j4 = j2;
        }
        if ((i & 8) != 0) {
            int bits$iv$iv$iv = (int) (drawScope.getSize-NH-jbRc() >> 32);
            float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv);
            long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
            long v2$iv$iv2 = Float.floatToRawIntBits(0.0f);
            j5 = Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2));
        } else {
            j5 = j3;
        }
        mineMenuGroupUtil.m744checkItemSectionDividerWBdyNhk(drawScope, j, itemSectionPosition, j4, j5, (i & 16) != 0 ? drawScope.toPx-0680j_4(Dp.constructor-impl((float) 0.5d)) : f);
    }

    /* renamed from: checkItemSectionDivider-WBdyNhk  reason: not valid java name */
    public final void m744checkItemSectionDividerWBdyNhk(DrawScope $this$checkItemSectionDivider_u2dWBdyNhk, long j, ItemSectionPosition itemSectionPosition, long j2, long j3, float strokeWidth) {
        Intrinsics.checkNotNullParameter($this$checkItemSectionDivider_u2dWBdyNhk, "$this$checkItemSectionDivider");
        Intrinsics.checkNotNullParameter(itemSectionPosition, "itemSectionPosition");
        if (itemSectionPosition == ItemSectionPosition.InMiddle || itemSectionPosition == ItemSectionPosition.InBottom) {
            DrawScope.-CC.drawLine-NGM6Ib0$default($this$checkItemSectionDivider_u2dWBdyNhk, j, j2, j3, strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
        }
    }
}