package kntr.app.im.chat.service.sender.image;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KUserPlaceholder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.im.chat.core.model.InputContent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageMessageSender.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/Deferred;", "Lkntr/app/im/chat/service/sender/image/ImageMessageSendTask;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSender$send$2", f = "ImageMessageSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ImageMessageSender$send$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Deferred<? extends ImageMessageSendTask>>>, Object> {
    final /* synthetic */ InputContent $content;
    final /* synthetic */ KEntityMsgType $msgType;
    final /* synthetic */ Function0<Long> $offsetProvider;
    final /* synthetic */ KUserPlaceholder $userPlaceholder;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImageMessageSender this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageMessageSender$send$2(InputContent inputContent, Function0<Long> function0, ImageMessageSender imageMessageSender, KEntityMsgType kEntityMsgType, KUserPlaceholder kUserPlaceholder, Continuation<? super ImageMessageSender$send$2> continuation) {
        super(2, continuation);
        this.$content = inputContent;
        this.$offsetProvider = function0;
        this.this$0 = imageMessageSender;
        this.$msgType = kEntityMsgType;
        this.$userPlaceholder = kUserPlaceholder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> imageMessageSender$send$2 = new ImageMessageSender$send$2(this.$content, this.$offsetProvider, this.this$0, this.$msgType, this.$userPlaceholder, continuation);
        imageMessageSender$send$2.L$0 = obj;
        return imageMessageSender$send$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Deferred<ImageMessageSendTask>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = this.$content.getSelectedAssets();
                Function0<Long> function0 = this.$offsetProvider;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Asset it = (Asset) item$iv$iv;
                    destination$iv$iv.add(TuplesKt.to(it, function0.invoke()));
                }
                Iterable $this$map$iv2 = (List) destination$iv$iv;
                ImageMessageSender imageMessageSender = this.this$0;
                InputContent inputContent = this.$content;
                KEntityMsgType kEntityMsgType = this.$msgType;
                KUserPlaceholder kUserPlaceholder = this.$userPlaceholder;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    Pair pair = (Pair) item$iv$iv2;
                    Asset asset = (Asset) pair.component1();
                    long offset = ((Number) pair.component2()).longValue();
                    Collection destination$iv$iv3 = destination$iv$iv2;
                    destination$iv$iv3.add(BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ImageMessageSender$send$2$2$1(imageMessageSender, asset, inputContent, kEntityMsgType, offset, kUserPlaceholder, null), 3, (Object) null));
                    inputContent = inputContent;
                    imageMessageSender = imageMessageSender;
                    kEntityMsgType = kEntityMsgType;
                    $this$map$iv2 = $this$map$iv2;
                    destination$iv$iv2 = destination$iv$iv3;
                    kUserPlaceholder = kUserPlaceholder;
                }
                return (List) destination$iv$iv2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}