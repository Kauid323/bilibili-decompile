package tv.danmaku.bili.appwidget.guide.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: AppWidgetManagerUtil.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.guide.utils.AppWidgetManagerUtil$isWidgetDetailPageSupported$2", f = "AppWidgetManagerUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AppWidgetManagerUtil$isWidgetDetailPageSupported$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetManagerUtil$isWidgetDetailPageSupported$2(Context context, Continuation<? super AppWidgetManagerUtil$isWidgetDetailPageSupported$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppWidgetManagerUtil$isWidgetDetailPageSupported$2(this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Uri uri = Uri.parse("content://com.miui.personalassistant.widget.external");
                boolean z = false;
                try {
                    Bundle bundle = this.$context.getContentResolver().call(uri, "isMiuiWidgetDetailPageSupported", (String) null, (Bundle) null);
                    if (bundle != null) {
                        z = bundle.getBoolean("isMiuiWidgetDetailPageSupported", false);
                    }
                } catch (Exception e) {
                    BLog.e("AppWidgetManagerUtils", "isWidgetDetailPageSupported error = " + e);
                }
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}