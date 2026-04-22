package kntr.app.im.chat.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMAssistantChatPage.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"ConfigWindow", RoomRecommendViewModel.EMPTY_CURSOR, "block", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMAssistantChatPage_androidKt {
    public static final void ConfigWindow(Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(function2, "block");
        ComposerKt.sourceInformationMarkerStart($composer, 726984459, "CC(ConfigWindow)N(block)16@580L7:IMAssistantChatPage.android.kt#f7dpja");
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Activity activity = ContextUtilKt.findActivityOrNull((Context) consume);
        if (Build.VERSION.SDK_INT < 30 && activity != null) {
            $composer.startReplaceGroup(-1925875950);
            ComposerKt.sourceInformation($composer, "18@704L13,19@773L184,19@749L208");
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, -1447595165, "CC(remember):IMAssistantChatPage.android.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(activity);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new IMAssistantChatPage_androidKt$ConfigWindow$1$1(activity, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-1925587712);
            ComposerKt.sourceInformation($composer, "24@979L7");
            function2.invoke($composer, Integer.valueOf($changed & 14));
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }
}