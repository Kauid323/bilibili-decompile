package kntr.app.im.chat.ui.module.shareType;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.module.ShareTypeMsgModule;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareTypeModule.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$ShareTypeModuleKt {
    public static final ComposableSingletons$ShareTypeModuleKt INSTANCE = new ComposableSingletons$ShareTypeModuleKt();

    /* renamed from: lambda$-586614002  reason: not valid java name */
    private static Function6<ChatMsgFrameScope, ShareTypeMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> f46lambda$586614002 = ComposableLambdaKt.composableLambdaInstance(-586614002, false, new Function6() { // from class: kntr.app.im.chat.ui.module.shareType.ComposableSingletons$ShareTypeModuleKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            Unit lambda__586614002$lambda$0;
            lambda__586614002$lambda$0 = ComposableSingletons$ShareTypeModuleKt.lambda__586614002$lambda$0((ChatMsgFrameScope) obj, (ShareTypeMsgModule) obj2, (EntityMessage) obj3, (Modifier) obj4, (Composer) obj5, ((Integer) obj6).intValue());
            return lambda__586614002$lambda$0;
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$700885096 = ComposableLambdaKt.composableLambdaInstance(700885096, false, new Function2() { // from class: kntr.app.im.chat.ui.module.shareType.ComposableSingletons$ShareTypeModuleKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda_700885096$lambda$0;
            lambda_700885096$lambda$0 = ComposableSingletons$ShareTypeModuleKt.lambda_700885096$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda_700885096$lambda$0;
        }
    });
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> lambda$233199538 = ComposableLambdaKt.composableLambdaInstance(233199538, false, new Function4() { // from class: kntr.app.im.chat.ui.module.shareType.ComposableSingletons$ShareTypeModuleKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda_233199538$lambda$0;
            lambda_233199538$lambda$0 = ComposableSingletons$ShareTypeModuleKt.lambda_233199538$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda_233199538$lambda$0;
        }
    });

    /* renamed from: getLambda$-586614002$ui_debug  reason: not valid java name */
    public final Function6<ChatMsgFrameScope, ShareTypeMsgModule, EntityMessage, Modifier, Composer, Integer, Unit> m1869getLambda$586614002$ui_debug() {
        return f46lambda$586614002;
    }

    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> getLambda$233199538$ui_debug() {
        return lambda$233199538;
    }

    public final Function2<Composer, Integer, Unit> getLambda$700885096$ui_debug() {
        return lambda$700885096;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__586614002$lambda$0(ChatMsgFrameScope chatMsgFrameScope, ShareTypeMsgModule msgModule, EntityMessage message, Modifier modifier, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(chatMsgFrameScope, "$unused$var$");
        Intrinsics.checkNotNullParameter(msgModule, "msgModule");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(msgModule,message,modifier)42@1884L115:ShareTypeModule.kt#q5tktn");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(chatMsgFrameScope) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(msgModule) ? 32 : 16;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer.changed(modifier) ? 2048 : 1024;
        }
        if (!$composer.shouldExecute(($dirty & 9235) != 9234, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-586614002, $dirty, -1, "kntr.app.im.chat.ui.module.shareType.ComposableSingletons$ShareTypeModuleKt.lambda$-586614002.<anonymous> (ShareTypeModule.kt:42)");
            }
            ShareTypeModuleKt.ShareTypeModule(chatMsgFrameScope, msgModule, modifier, $composer, ($dirty & 14) | ($dirty & 112) | (($dirty >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_700885096$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C107@4127L6,103@3901L293:ShareTypeModule.kt#q5tktn");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(700885096, $changed, -1, "kntr.app.im.chat.ui.module.shareType.ComposableSingletons$ShareTypeModuleKt.lambda$700885096.<anonymous> (ShareTypeModule.kt:103)");
            }
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_233199538$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)112@4371L14,114@4503L6,118@4738L6,111@4306L546:ShareTypeModule.kt#q5tktn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(233199538, $changed, -1, "kntr.app.im.chat.ui.module.shareType.ComposableSingletons$ShareTypeModuleKt.lambda$233199538.<anonymous> (ShareTypeModule.kt:111)");
        }
        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getImage_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(32)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 48, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}