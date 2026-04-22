package tv.danmaku.bili.appwidget.hotlist.utils;

import android.content.Context;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.droid.ScreenUtil;
import java.io.File;
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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetItemModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageUtil.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotlist.utils.ImageUtilKt$downloadHotListCover$2", f = "ImageUtil.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImageUtilKt$downloadHotListCover$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $index;
    final /* synthetic */ HotListWidgetItemModel $item;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageUtilKt$downloadHotListCover$2(Context context, HotListWidgetItemModel hotListWidgetItemModel, int i, Continuation<? super ImageUtilKt$downloadHotListCover$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$item = hotListWidgetItemModel;
        this.$index = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ImageUtilKt$downloadHotListCover$2(this.$context, this.$item, this.$index, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int screenWidth = (ScreenUtil.getScreenWidth(this.$context) - ListExtentionsKt.toPx(48)) / 3;
                Context context = this.$context;
                HotListWidgetItemModel hotListWidgetItemModel = this.$item;
                String cover = hotListWidgetItemModel != null ? hotListWidgetItemModel.getCover() : null;
                this.label = 1;
                Object downloadHotListCoverFile = ImageUtilKt.downloadHotListCoverFile(context, cover, screenWidth, (Continuation) this);
                if (downloadHotListCoverFile != coroutine_suspended) {
                    $result = downloadHotListCoverFile;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        File coverFile = (File) $result;
        BLog.i("HotListImageUtil", "pic downloaded " + this.$index);
        return coverFile;
    }
}