package tv.danmaku.bili;

import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import com.bilibili.lib.crashreport.CrashReporter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShortcutHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ShortcutHelper$publishAllDynamic$1", f = "ShortcutHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ShortcutHelper$publishAllDynamic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<ShortcutInfo> $shortcutInfos;
    final /* synthetic */ ShortcutManager $shortcutManager;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortcutHelper$publishAllDynamic$1(ShortcutManager shortcutManager, ArrayList<ShortcutInfo> arrayList, Continuation<? super ShortcutHelper$publishAllDynamic$1> continuation) {
        super(2, continuation);
        this.$shortcutManager = shortcutManager;
        this.$shortcutInfos = arrayList;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShortcutHelper$publishAllDynamic$1(this.$shortcutManager, this.$shortcutInfos, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    this.$shortcutManager.setDynamicShortcuts(this.$shortcutInfos);
                } catch (Exception e) {
                    BLog.d("ShortcutHelper", e.getMessage());
                    CrashReporter.INSTANCE.postCaughtException(e);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}