package kntr.app.im.chat.db.clean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.io.files.FileMetadata;
import kotlinx.io.files.FileSystemJvmKt;
import kotlinx.io.files.Path;

/* compiled from: ChatDatabaseCleaner.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.clean.ChatDatabaseCleaner$getTotalSizeByte$2", f = "ChatDatabaseCleaner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ChatDatabaseCleaner$getTotalSizeByte$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    int label;
    final /* synthetic */ ChatDatabaseCleaner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDatabaseCleaner$getTotalSizeByte$2(ChatDatabaseCleaner chatDatabaseCleaner, Continuation<? super ChatDatabaseCleaner$getTotalSizeByte$2> continuation) {
        super(2, continuation);
        this.this$0 = chatDatabaseCleaner;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChatDatabaseCleaner$getTotalSizeByte$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long j2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$map$iv = this.this$0.listDBFiles();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(FileSystemJvmKt.SystemFileSystem.metadataOrNull((Path) item$iv$iv));
                }
                Iterable $this$filter$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList();
                Iterator it = $this$filter$iv.iterator();
                while (true) {
                    boolean z = true;
                    if (!it.hasNext()) {
                        long j3 = 0;
                        for (FileMetadata it2 : (List) destination$iv$iv2) {
                            if (it2 != null) {
                                Long boxLong = Boxing.boxLong(it2.getSize());
                                long size = boxLong.longValue();
                                if (!(size >= 0)) {
                                    boxLong = null;
                                }
                                if (boxLong != null) {
                                    j2 = boxLong.longValue();
                                    j3 += j2;
                                }
                            }
                            j2 = 0;
                            j3 += j2;
                        }
                        return Boxing.boxLong(j3);
                    }
                    Object element$iv$iv = it.next();
                    FileMetadata it3 = (FileMetadata) element$iv$iv;
                    if ((it3 == null || !it3.isRegularFile()) ? false : false) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}