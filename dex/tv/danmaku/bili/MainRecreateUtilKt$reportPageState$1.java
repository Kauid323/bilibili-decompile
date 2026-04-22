package tv.danmaku.bili;

import android.content.SharedPreferences;
import com.bilibili.gripper.api.apm.GKoom;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.TypedProducersJvm;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainRecreateUtil.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.MainRecreateUtilKt$reportPageState$1", f = "MainRecreateUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MainRecreateUtilKt$reportPageState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $params;
    final /* synthetic */ boolean $rebuild;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainRecreateUtilKt$reportPageState$1(Map<String, String> map, boolean z, Continuation<? super MainRecreateUtilKt$reportPageState$1> continuation) {
        super(2, continuation);
        this.$params = map;
        this.$rebuild = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainRecreateUtilKt$reportPageState$1(this.$params, this.$rebuild, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        GKoom it;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Neurons.trackT(false, MainRecreateUtilKt.MAIN_PAGE_STATE, this.$params, 1, new Function0() { // from class: tv.danmaku.bili.MainRecreateUtilKt$reportPageState$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = MainRecreateUtilKt$reportPageState$1.invokeSuspend$lambda$0();
                        return Boolean.valueOf(invokeSuspend$lambda$0);
                    }
                });
                Object obj2 = ConfigManager.Companion.ab2().get("dd_main_recreate_dump_mem", Boxing.boxBoolean(false));
                Intrinsics.checkNotNull(obj2);
                if (((Boolean) obj2).booleanValue()) {
                    SharedPreferences sp = BLKV.getBLSharedPreferences(FoundationAlias.getFapp(), "main_recreate_dump", false, 0);
                    long interval = 86400000;
                    try {
                        Object obj3 = ConfigManager.Companion.config().get("dd_main_recreate_dump_interval", String.valueOf(86400000L));
                        Intrinsics.checkNotNull(obj3);
                        interval = Long.parseLong((String) obj3);
                    } catch (NumberFormatException e) {
                    }
                    if (sp.getLong("last_dump_time", 0L) + interval > System.currentTimeMillis()) {
                        return Unit.INSTANCE;
                    }
                    sp.edit().putLong("last_dump_time", System.currentTimeMillis()).apply();
                    SuspendProducer gKoom = TypedProducersJvm.DefaultImpls.get$default(GripperKt.getGripper(FoundationAlias.getFapp()).getContainer().typeOf(GKoom.class), (String) null, 1, (Object) null);
                    if (gKoom != null && (it = (GKoom) gKoom.getOrNull()) != null) {
                        boolean z = this.$rebuild;
                        it.manualTrigger();
                        Map exParams = MapsKt.mapOf(TuplesKt.to("rebuild", String.valueOf(z)));
                        it.addBizExt("main_recreate", exParams);
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0() {
        return true;
    }
}