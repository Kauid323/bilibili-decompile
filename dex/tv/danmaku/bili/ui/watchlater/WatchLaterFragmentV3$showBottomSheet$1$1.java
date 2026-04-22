package tv.danmaku.bili.ui.watchlater;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.ui.watchlater.data.DialogType;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterFragmentV3.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.WatchLaterFragmentV3$showBottomSheet$1$1", f = "WatchLaterFragmentV3.kt", i = {}, l = {216, 229}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterFragmentV3$showBottomSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pos;
    int label;
    final /* synthetic */ WatchLaterFragmentV3 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterFragmentV3$showBottomSheet$1$1(int i, WatchLaterFragmentV3 watchLaterFragmentV3, Continuation<? super WatchLaterFragmentV3$showBottomSheet$1$1> continuation) {
        super(2, continuation);
        this.$pos = i;
        this.this$0 = watchLaterFragmentV3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterFragmentV3$showBottomSheet$1$1(this.$pos, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Boolean $result2;
        Object showBiliCommonDialog;
        Object $result3;
        Object showBiliCommonDialog2;
        Object $result4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                $result2 = null;
                switch (this.$pos) {
                    case 0:
                        Context context = this.this$0.getContext();
                        if (context != null) {
                            this.label = 1;
                            showBiliCommonDialog = this.this$0.showBiliCommonDialog(context, DialogType.DeleteWatched.INSTANCE, (Continuation) this);
                            if (showBiliCommonDialog == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result3 = $result;
                            $result = showBiliCommonDialog;
                            $result2 = (Boolean) $result;
                        }
                        if (Intrinsics.areEqual($result2, Boxing.boxBoolean(true))) {
                            this.this$0.getViewModel().onDialogConfirm(DialogType.DeleteWatched.INSTANCE);
                            WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_MANAGE_OPTION_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_OPTION, "2")));
                            break;
                        }
                        break;
                    case 1:
                        Context context2 = this.this$0.getContext();
                        if (context2 != null) {
                            this.label = 2;
                            showBiliCommonDialog2 = this.this$0.showBiliCommonDialog(context2, DialogType.DeleteInvalid.INSTANCE, (Continuation) this);
                            if (showBiliCommonDialog2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result4 = $result;
                            $result = showBiliCommonDialog2;
                            $result2 = (Boolean) $result;
                        }
                        if (Intrinsics.areEqual($result2, Boxing.boxBoolean(true))) {
                            this.this$0.getViewModel().onDialogConfirm(DialogType.DeleteInvalid.INSTANCE);
                            WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_MANAGE_OPTION_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_OPTION, "3")));
                            break;
                        }
                        break;
                    case 2:
                        this.this$0.getViewModel().changeCheckState();
                        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_MANAGE_OPTION_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to(WatchLaterReporterKt.KEY_OPTION, "1"), TuplesKt.to(WatchLaterReporterKt.KEY_CLICK_TYPE, "0")}));
                        break;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result3 = $result;
                $result2 = (Boolean) $result;
                if (Intrinsics.areEqual($result2, Boxing.boxBoolean(true))) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                $result4 = $result;
                $result2 = (Boolean) $result;
                if (Intrinsics.areEqual($result2, Boxing.boxBoolean(true))) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}