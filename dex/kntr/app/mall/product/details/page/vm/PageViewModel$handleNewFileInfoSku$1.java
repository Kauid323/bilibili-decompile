package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.ItemsFileApiService;
import kntr.app.mall.product.details.page.api.model.FileInfoFloor;
import kntr.app.mall.product.details.page.api.model.SkuInfoFloor;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$handleNewFileInfoSku$1", f = "PageViewModel.kt", i = {}, l = {1659}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PageViewModel$handleNewFileInfoSku$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem $sku;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$handleNewFileInfoSku$1(PageViewModel pageViewModel, SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem, Continuation<? super PageViewModel$handleNewFileInfoSku$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
        this.$sku = itemsSkuListItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$handleNewFileInfoSku$1(this.this$0, this.$sku, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object itemFiles$product_details_page_debug;
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        MutableStateFlow $this$update$iv2;
        Object prevValue$iv2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ItemsFileApiService itemsFileApiService = ItemsFileApiService.INSTANCE;
                String itemsId$product_details_page_debug = this.this$0.getItemsId$product_details_page_debug();
                if (itemsId$product_details_page_debug == null) {
                    itemsId$product_details_page_debug = "";
                }
                Long id = this.$sku.getId();
                long longValue = id != null ? id.longValue() : 0L;
                this.label = 1;
                itemFiles$product_details_page_debug = itemsFileApiService.getItemFiles$product_details_page_debug(itemsId$product_details_page_debug, longValue, (Continuation) this);
                if (itemFiles$product_details_page_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                itemFiles$product_details_page_debug = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ItemsFileApiService.ItemsFileResponse response = (ItemsFileApiService.ItemsFileResponse) itemFiles$product_details_page_debug;
        Long code = response.getCode();
        if (code != null && code.longValue() == 0 && response.getData() != null) {
            FileInfoFloor.FileInfo newFileInfo = response.getData();
            $this$update$iv = this.this$0._fileInfo;
            do {
                prevValue$iv = $this$update$iv.getValue();
                FileInfoFloor.FileInfo fileInfo = (FileInfoFloor.FileInfo) prevValue$iv;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, newFileInfo));
            $this$update$iv2 = this.this$0._fileInfoSelectedSku;
            Object nextValue$iv = this.$sku;
            do {
                prevValue$iv2 = $this$update$iv2.getValue();
                SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem itemsSkuListItem = (SkuInfoFloor.ItemsSkuListVO.ItemsSkuListItem) prevValue$iv2;
            } while (!$this$update$iv2.compareAndSet(prevValue$iv2, nextValue$iv));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}