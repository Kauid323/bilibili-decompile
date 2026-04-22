package defpackage;

import CustomBottomSheetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;

/* compiled from: LazyDsl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* renamed from: CustomBottomSheetKt$CustomBottomSheet$lambda$2$0$0$0$$inlined$itemsIndexed$default$3  reason: default package */
public final class CustomBottomSheetKt$CustomBottomSheet$lambda$2$0$0$0$$inlined$itemsIndexed$default$3 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
    final /* synthetic */ List $items;
    final /* synthetic */ List $items$inlined;
    final /* synthetic */ Function0 $onDismissRequest$inlined;
    final /* synthetic */ boolean $showArrowCondition$inlined;

    public CustomBottomSheetKt$CustomBottomSheet$lambda$2$0$0$0$$inlined$itemsIndexed$default$3(List list, boolean z, Function0 function0, List list2) {
        this.$items = list;
        this.$showArrowCondition$inlined = z;
        this.$onDismissRequest$inlined = function0;
        this.$items$inlined = list2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
        invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
        Composer $composer2;
        ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$items) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(it) ? 32 : 16;
        }
        if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
        }
        int $changed2 = ($dirty & 14) | ($dirty & 112);
        BottomSheetItemData item = (BottomSheetItemData) this.$items.get(it);
        $composer.startReplaceGroup(-1144554274);
        ComposerKt.sourceInformation($composer, "CN(index,item)*97@3772L122,94@3605L312:CustomBottomSheet.kt");
        boolean z = this.$showArrowCondition$inlined && item.getShowArrowRight();
        ComposerKt.sourceInformationMarkerStart($composer, -1422389600, "CC(remember):CustomBottomSheet.kt#9igjgp");
        boolean invalid$iv = (((($changed2 & 896) ^ 384) > 256 && $composer.changed(item)) || ($changed2 & 384) == 256) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(it)) || ($changed2 & 48) == 32) | $composer.changed(this.$onDismissRequest$inlined);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = (Function0) new CustomBottomSheetKt.CustomBottomSheet.2.1.1.1.1.1.1(item, it, this.$onDismissRequest$inlined);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        CustomBottomSheetKt.access$BottomSheetItem(item, z, (Function0) it$iv, $composer, ($changed2 >> 6) & 14);
        if (it < CollectionsKt.getLastIndex(this.$items$inlined)) {
            $composer.startReplaceGroup(-1144182089);
            ComposerKt.sourceInformation($composer, "105@4130L6,103@3993L229");
            $composer2 = $composer;
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_light-0d7_KjU(), $composer2, 54, 0);
        } else {
            $composer2 = $composer;
            $composer2.startReplaceGroup(-1148151236);
        }
        $composer2.endReplaceGroup();
        $composer2.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}