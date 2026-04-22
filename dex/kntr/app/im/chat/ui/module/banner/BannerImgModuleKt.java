package kntr.app.im.chat.ui.module.banner;

import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import kntr.app.im.chat.module.BannerImageMsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BannerImgModule.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"BannerImageModule", RoomRecommendViewModel.EMPTY_CURSOR, "module", "Lkntr/app/im/chat/module/BannerImageMsgModule;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/module/BannerImageMsgModule;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BannerImgModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BannerImageModule$lambda$0(BannerImageMsgModule bannerImageMsgModule, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BannerImageModule(bannerImageMsgModule, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void BannerImageModule(final BannerImageMsgModule module, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(module, "module");
        Composer $composer3 = $composer.startRestartGroup(545741795);
        ComposerKt.sourceInformation($composer3, "C(BannerImageModule)N(module,modifier)44@1480L114:BannerImgModule.kt#iv6lxi");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(module) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(545741795, $dirty2, -1, "kntr.app.im.chat.ui.module.banner.BannerImageModule (BannerImgModule.kt:42)");
            }
            String $this$asRequest_u24default$iv = module.getValue().getImageUrl();
            Modifier modifier4 = modifier3;
            $composer2 = $composer3;
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), AspectRatioKt.aspectRatio$default(modifier3, 2.0f, false, 2, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.banner.BannerImgModuleKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit BannerImageModule$lambda$0;
                    BannerImageModule$lambda$0 = BannerImgModuleKt.BannerImageModule$lambda$0(BannerImageMsgModule.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BannerImageModule$lambda$0;
                }
            });
        }
    }
}