package kntr.common.photonic.gallery.internal;

import android.content.ContentResolver;
import android.content.Context;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.gallery.Pagination;
import kntr.common.photonic.gallery.entity.AndroidVideo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidVideoGallery.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lkntr/common/photonic/gallery/entity/AndroidVideo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.internal.AndroidVideoGallery$load$2", f = "AndroidVideoGallery.kt", i = {0}, l = {ConstantsKt.PLAYING_ICON_UNIT_COUNT}, m = "invokeSuspend", n = {"cr"}, s = {"L$0"}, v = 1)
public final class AndroidVideoGallery$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends AndroidVideo>>, Object> {
    final /* synthetic */ Pagination $pagination;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidVideoGallery$load$2(Pagination pagination, Continuation<? super AndroidVideoGallery$load$2> continuation) {
        super(2, continuation);
        this.$pagination = pagination;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidVideoGallery$load$2(this.$pagination, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<AndroidVideo>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Context context;
        Object loadVideos;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                context = AndroidVideoGallery.INSTANCE.getContext();
                ContentResolver cr = context.getContentResolver();
                this.L$0 = SpillingKt.nullOutSpilledVariable(cr);
                this.label = 1;
                loadVideos = AndroidVideoGallery.INSTANCE.loadVideos(cr, this.$pagination, (Continuation) this);
                return loadVideos == coroutine_suspended ? coroutine_suspended : loadVideos;
            case 1:
                ContentResolver contentResolver = (ContentResolver) this.L$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}