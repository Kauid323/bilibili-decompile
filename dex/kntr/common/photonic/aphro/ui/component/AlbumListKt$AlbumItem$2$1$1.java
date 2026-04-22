package kntr.common.photonic.aphro.ui.component;

import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlbumList.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.aphro.ui.component.AlbumListKt$AlbumItem$2$1$1", f = "AlbumList.kt", i = {}, l = {88, 89}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AlbumListKt$AlbumItem$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AlbumInfo $album;
    final /* synthetic */ MutableLongState $count$delegate;
    final /* synthetic */ MutableState<Asset> $thumbnail$delegate;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumListKt$AlbumItem$2$1$1(AlbumInfo albumInfo, MutableState<Asset> mutableState, MutableLongState mutableLongState, Continuation<? super AlbumListKt$AlbumItem$2$1$1> continuation) {
        super(2, continuation);
        this.$album = albumInfo;
        this.$thumbnail$delegate = mutableState;
        this.$count$delegate = mutableLongState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumListKt$AlbumItem$2$1$1(this.$album, this.$thumbnail$delegate, this.$count$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableState<Asset> mutableState;
        Object thumbnail;
        Object resourceCount;
        MutableLongState mutableLongState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableState = this.$thumbnail$delegate;
                this.L$0 = mutableState;
                this.label = 1;
                thumbnail = this.$album.reader().thumbnail((Continuation) this);
                if (thumbnail == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableState.setValue((Asset) thumbnail);
                MutableLongState mutableLongState2 = this.$count$delegate;
                this.L$0 = mutableLongState2;
                this.label = 2;
                resourceCount = this.$album.resourceCount((Continuation) this);
                if (resourceCount != coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableLongState = mutableLongState2;
                mutableLongState.setLongValue(((Number) resourceCount).longValue());
                return Unit.INSTANCE;
            case 1:
                mutableState = (MutableState) this.L$0;
                ResultKt.throwOnFailure($result);
                thumbnail = $result;
                mutableState.setValue((Asset) thumbnail);
                MutableLongState mutableLongState22 = this.$count$delegate;
                this.L$0 = mutableLongState22;
                this.label = 2;
                resourceCount = this.$album.resourceCount((Continuation) this);
                if (resourceCount != coroutine_suspended) {
                }
                break;
            case 2:
                mutableLongState = (MutableLongState) this.L$0;
                ResultKt.throwOnFailure($result);
                resourceCount = $result;
                mutableLongState.setLongValue(((Number) resourceCount).longValue());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}