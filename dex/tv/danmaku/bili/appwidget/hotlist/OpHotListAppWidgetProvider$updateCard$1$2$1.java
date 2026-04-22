package tv.danmaku.bili.appwidget.hotlist;

import android.content.Context;
import android.net.Uri;
import com.oplus.cardwidget.domain.action.CardWidgetAction;
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
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetItemModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;
import tv.danmaku.bili.appwidget.hotlist.utils.ImageUtilKt;

/* compiled from: OpHotListAppWidgetProvider.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotlist.OpHotListAppWidgetProvider$updateCard$1$2$1", f = "OpHotListAppWidgetProvider.kt", i = {}, l = {BR.currentTabItemType}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OpHotListAppWidgetProvider$updateCard$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HotListWidgetModel $cardData;
    final /* synthetic */ Context $context;
    final /* synthetic */ HotListWidgetItemModel $hotListWidgetItemModel;
    final /* synthetic */ int $index;
    int label;
    final /* synthetic */ OpHotListAppWidgetProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpHotListAppWidgetProvider$updateCard$1$2$1(Context context, HotListWidgetItemModel hotListWidgetItemModel, int i, OpHotListAppWidgetProvider opHotListAppWidgetProvider, HotListWidgetModel hotListWidgetModel, Continuation<? super OpHotListAppWidgetProvider$updateCard$1$2$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$hotListWidgetItemModel = hotListWidgetItemModel;
        this.$index = i;
        this.this$0 = opHotListAppWidgetProvider;
        this.$cardData = hotListWidgetModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OpHotListAppWidgetProvider$updateCard$1$2$1(this.$context, this.$hotListWidgetItemModel, this.$index, this.this$0, this.$cardData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Iterable iterable;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object downloadHotListCover = ImageUtilKt.downloadHotListCover(this.$context, this.$hotListWidgetItemModel, this.$index, (Continuation) this);
                if (downloadHotListCover != coroutine_suspended) {
                    $result = downloadHotListCover;
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
        Uri uri = ImageUtilKt.saveFileToProvider(this.$context, coverFile, this.$hotListWidgetItemModel.getCover());
        if (uri == null) {
            return Unit.INSTANCE;
        }
        this.$hotListWidgetItemModel.setCoverFileUri(uri);
        iterable = this.this$0.grantedPermissions;
        Iterable $this$forEach$iv = iterable;
        Context context = this.$context;
        for (Object element$iv : $this$forEach$iv) {
            String toPackage = (String) element$iv;
            context.grantUriPermission(toPackage, uri, 1);
        }
        Iterable $this$forEach$iv2 = this.this$0.getShowedCardList();
        Context context2 = this.$context;
        HotListWidgetModel hotListWidgetModel = this.$cardData;
        for (Object element$iv2 : $this$forEach$iv2) {
            String widgetCode = (String) element$iv2;
            CardWidgetAction.INSTANCE.postUpdateCommand(context2, new HotListDataPacker(hotListWidgetModel), widgetCode);
        }
        return Unit.INSTANCE;
    }
}