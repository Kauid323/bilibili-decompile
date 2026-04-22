package kntr.common.ouro.core.plugin.localImage;

import java.util.Iterator;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageAction;
import kntr.common.photonic.Asset;
import kntr.common.photonic.MimeType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroLocalImagePlugin.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageAction$InsertBlockImage;", "state", "Lkntr/common/ouro/core/OuroState;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin$spec$1$1$2", f = "OuroLocalImagePlugin.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {39}, m = "invokeSuspend", n = {"action", "state", "$this$forEach$iv", "element$iv", "asset", "state", "$i$f$forEach", "$i$a$-forEach-OuroLocalImagePlugin$spec$1$1$2$1", "useOriginalImage"}, s = {"L$0", "L$1", "L$2", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2"}, v = 1)
public final class OuroLocalImagePlugin$spec$1$1$2 extends SuspendLambda implements Function3<OuroLocalImageAction.InsertBlockImage, OuroState, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<OuroAction, Continuation<? super Unit>, Object> $dispatch;
    int I$0;
    int I$1;
    int I$2;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ OuroLocalImagePlugin this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OuroLocalImagePlugin$spec$1$1$2(OuroLocalImagePlugin ouroLocalImagePlugin, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super OuroLocalImagePlugin$spec$1$1$2> continuation) {
        super(3, continuation);
        this.this$0 = ouroLocalImagePlugin;
        this.$dispatch = function2;
    }

    public final Object invoke(OuroLocalImageAction.InsertBlockImage insertBlockImage, OuroState ouroState, Continuation<? super Unit> continuation) {
        OuroLocalImagePlugin$spec$1$1$2 ouroLocalImagePlugin$spec$1$1$2 = new OuroLocalImagePlugin$spec$1$1$2(this.this$0, this.$dispatch, continuation);
        ouroLocalImagePlugin$spec$1$1$2.L$0 = insertBlockImage;
        ouroLocalImagePlugin$spec$1$1$2.L$1 = ouroState;
        return ouroLocalImagePlugin$spec$1$1$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ff  */
    /* JADX WARN: Type inference failed for: r14v3, types: [int] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00ab -> B:32:0x00fa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00f0 -> B:31:0x00f4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Iterable $this$forEach$iv;
        OuroLocalImagePlugin ouroLocalImagePlugin;
        Function2<OuroAction, Continuation<? super Unit>, Object> function2;
        int $i$f$forEach;
        Iterator it;
        OuroLocalImagePlugin$spec$1$1$2 ouroLocalImagePlugin$spec$1$1$2;
        Object obj;
        OuroState state;
        OuroLocalImageAction.InsertBlockImage action;
        Object $result2;
        OuroLocalImageState currentState;
        Object $result3;
        boolean z;
        int i;
        OuroLocalImageAction.InsertBlockImage action2 = (OuroLocalImageAction.InsertBlockImage) this.L$0;
        OuroState state2 = (OuroState) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (action2.getShouldUploadImmediately()) {
                    Iterable $this$forEach$iv2 = action2.getAssets();
                    $this$forEach$iv = $this$forEach$iv2;
                    ouroLocalImagePlugin = this.this$0;
                    function2 = this.$dispatch;
                    $i$f$forEach = 0;
                    it = $this$forEach$iv2.iterator();
                    ouroLocalImagePlugin$spec$1$1$2 = this;
                    obj = coroutine_suspended;
                    state = state2;
                    action = action2;
                    $result2 = $result;
                    if (it.hasNext()) {
                        Object element$iv = it.next();
                        Asset asset = (Asset) element$iv;
                        ?? useOriginalImage = Intrinsics.areEqual(asset.getMimeType(), MimeType.Companion.getGIF()) ? 1 : action.getUseOriginalImage();
                        currentState = ouroLocalImagePlugin.currentState(state);
                        UploadTaskState state3 = currentState != null ? currentState.getTaskState().get(asset.getIdentifier()) : null;
                        if (state3 == null || state3.isFailed()) {
                            if (useOriginalImage != 0) {
                                $result3 = $result2;
                                z = true;
                            } else {
                                $result3 = $result2;
                                z = false;
                            }
                            OuroLocalImageAction.StartUploadImage startUploadImage = new OuroLocalImageAction.StartUploadImage(asset, z);
                            ouroLocalImagePlugin$spec$1$1$2.L$0 = action;
                            ouroLocalImagePlugin$spec$1$1$2.L$1 = state;
                            ouroLocalImagePlugin$spec$1$1$2.L$2 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                            ouroLocalImagePlugin$spec$1$1$2.L$3 = ouroLocalImagePlugin;
                            ouroLocalImagePlugin$spec$1$1$2.L$4 = function2;
                            ouroLocalImagePlugin$spec$1$1$2.L$5 = it;
                            ouroLocalImagePlugin$spec$1$1$2.L$6 = SpillingKt.nullOutSpilledVariable(element$iv);
                            ouroLocalImagePlugin$spec$1$1$2.L$7 = SpillingKt.nullOutSpilledVariable(asset);
                            ouroLocalImagePlugin$spec$1$1$2.L$8 = SpillingKt.nullOutSpilledVariable(state3);
                            ouroLocalImagePlugin$spec$1$1$2.I$0 = $i$f$forEach;
                            ouroLocalImagePlugin$spec$1$1$2.I$1 = 0;
                            ouroLocalImagePlugin$spec$1$1$2.I$2 = useOriginalImage;
                            ouroLocalImagePlugin$spec$1$1$2.label = 1;
                            if (function2.invoke(startUploadImage, ouroLocalImagePlugin$spec$1$1$2) == obj) {
                                return obj;
                            }
                            action2 = action;
                            state2 = state;
                            coroutine_suspended = obj;
                            i = useOriginalImage;
                            obj = coroutine_suspended;
                            state = state2;
                            action = action2;
                            $result2 = $result3;
                        }
                        if (it.hasNext()) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    return Unit.INSTANCE;
                }
                break;
            case 1:
                i = this.I$2;
                int i2 = this.I$1;
                $i$f$forEach = this.I$0;
                UploadTaskState uploadTaskState = (UploadTaskState) this.L$8;
                Asset asset2 = (Asset) this.L$7;
                Object obj2 = this.L$6;
                it = (Iterator) this.L$5;
                function2 = (Function2) this.L$4;
                ouroLocalImagePlugin = (OuroLocalImagePlugin) this.L$3;
                $this$forEach$iv = (Iterable) this.L$2;
                ResultKt.throwOnFailure($result);
                $result3 = $result;
                ouroLocalImagePlugin$spec$1$1$2 = this;
                obj = coroutine_suspended;
                state = state2;
                action = action2;
                $result2 = $result3;
                if (it.hasNext()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}