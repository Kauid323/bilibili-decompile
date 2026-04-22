package tv.danmaku.bili.ui.main2.mine.topleft;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.FragmentManager;
import com.bilibili.app.comm.restrict.utils.TeenagersModeKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopLeft.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/ui/main2/mine/topleft/TopLeftData;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.topleft.TopLeftKt$setTopLeft$3", f = "TopLeft.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TopLeftKt$setTopLeft$3 extends SuspendLambda implements Function2<TopLeftData, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentManager $fragmentManager;
    final /* synthetic */ Function0<Unit> $legacyAnswer;
    final /* synthetic */ ComposeView $topLeftCompose;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopLeftKt$setTopLeft$3(Function0<Unit> function0, ComposeView composeView, FragmentManager fragmentManager, Continuation<? super TopLeftKt$setTopLeft$3> continuation) {
        super(2, continuation);
        this.$legacyAnswer = function0;
        this.$topLeftCompose = composeView;
        this.$fragmentManager = fragmentManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> topLeftKt$setTopLeft$3 = new TopLeftKt$setTopLeft$3(this.$legacyAnswer, this.$topLeftCompose, this.$fragmentManager, continuation);
        topLeftKt$setTopLeft$3.L$0 = obj;
        return topLeftKt$setTopLeft$3;
    }

    public final Object invoke(TopLeftData topLeftData, Continuation<? super Unit> continuation) {
        return create(topLeftData, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                final TopLeftData it = (TopLeftData) this.L$0;
                this.$legacyAnswer.invoke();
                ComposeView composeView = (View) this.$topLeftCompose;
                boolean show$iv = it.getInTeensModeAndShowTeensAgeSetting() || it.getActivityAnswer() != null;
                ComposeView composeView2 = this.$topLeftCompose;
                final FragmentManager fragmentManager = this.$fragmentManager;
                if (composeView != null) {
                    composeView.setVisibility(show$iv ? 0 : 8);
                }
                if (show$iv && composeView != null) {
                    composeView2.setContent(ComposableLambdaKt.composableLambdaInstance(-964278943, true, new Function2() { // from class: tv.danmaku.bili.ui.main2.mine.topleft.TopLeftKt$setTopLeft$3$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit invokeSuspend$lambda$0$0;
                            invokeSuspend$lambda$0$0 = TopLeftKt$setTopLeft$3.invokeSuspend$lambda$0$0(TopLeftData.this, fragmentManager, (Composer) obj2, ((Integer) obj3).intValue());
                            return invokeSuspend$lambda$0$0;
                        }
                    }));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(final TopLeftData $it, final FragmentManager $fragmentManager, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C44@1750L1408,42@1683L1475:TopLeft.kt#2hz67j");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-964278943, $changed, -1, "tv.danmaku.bili.ui.main2.mine.topleft.setTopLeft.<anonymous>.<anonymous>.<anonymous> (TopLeft.kt:42)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, true, ComposableLambdaKt.rememberComposableLambda(-403101415, true, new Function2() { // from class: tv.danmaku.bili.ui.main2.mine.topleft.TopLeftKt$setTopLeft$3$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit invokeSuspend$lambda$0$0$0;
                    invokeSuspend$lambda$0$0$0 = TopLeftKt$setTopLeft$3.invokeSuspend$lambda$0$0$0(TopLeftData.this, $fragmentManager, (Composer) obj, ((Integer) obj2).intValue());
                    return invokeSuspend$lambda$0$0$0;
                }
            }, $composer, 54), $composer, (int) BR.pendentVisible, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0$0(TopLeftData $it, FragmentManager $fragmentManager, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:TopLeft.kt#2hz67j");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-403101415, $changed, -1, "tv.danmaku.bili.ui.main2.mine.topleft.setTopLeft.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TopLeft.kt:45)");
            }
            if ($it.getInTeensModeAndShowTeensAgeSetting()) {
                $composer.startReplaceGroup(-65597400);
                ComposerKt.sourceInformation($composer, "48@1986L214,54@2227L654,46@1840L1041");
                int teenagerAge = TeenagersModeKt.isOsTeenagersModeOn() ? -1 : TeenagersModeKt.getTeenagerAge();
                ComposerKt.sourceInformationMarkerStart($composer, -833395409, "CC(remember):TopLeft.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($fragmentManager);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = (Function1) new TopLeftKt$setTopLeft$3$1$1$1$1$1($fragmentManager, null);
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 function1 = (Function1) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -833387257, "CC(remember):TopLeft.kt#9igjgp");
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = (Function2) new TopLeftKt$setTopLeft$3$1$1$1$2$1(null);
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TeensAgeKt.TeesAgeButton(teenagerAge, false, function1, (Function2) it$iv2, $composer, 0, 2);
                $composer.endReplaceGroup();
            } else {
                if ($it.getActivityAnswer() != null) {
                    $composer.startReplaceGroup(-64507967);
                    ComposerKt.sourceInformation($composer, "69@2966L152");
                    ActivityAnswerKt.ActivityAnswer($it.getActivityAnswer(), $it.getGarbEnum(), null, $composer, 0, 4);
                } else {
                    $composer.startReplaceGroup(-67431639);
                }
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}