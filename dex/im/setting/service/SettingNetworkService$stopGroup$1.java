package im.setting.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingNetworkService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.service.SettingNetworkService", f = "SettingNetworkService.kt", i = {2, 2}, l = {11, 12, 22}, m = "stopGroup-IoAF18A$logic_debug", n = {"$this$body$iv", "$i$f$body"}, s = {"L$0", "I$0"}, v = 1)
public final class SettingNetworkService$stopGroup$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingNetworkService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingNetworkService$stopGroup$1(SettingNetworkService settingNetworkService, Continuation<? super SettingNetworkService$stopGroup$1> continuation) {
        super(continuation);
        this.this$0 = settingNetworkService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object m3411stopGroupIoAF18A$logic_debug = this.this$0.m3411stopGroupIoAF18A$logic_debug((Continuation) this);
        return m3411stopGroupIoAF18A$logic_debug == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m3411stopGroupIoAF18A$logic_debug : Result.box-impl(m3411stopGroupIoAF18A$logic_debug);
    }
}