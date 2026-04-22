package kntr.app.im.chat.service.sender.image;

import java.util.Set;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.utils.CoroutineExJvmKt;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.finder.AssetFinder;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.JobKt;
import kotlinx.io.files.Path;
import kotlinx.io.files.PathsJvmKt;

/* compiled from: LocalImageAsset.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lkntr/app/im/chat/service/sender/image/LocalImageAssetFinder;", "Lkntr/common/photonic/finder/AssetFinder;", "Lkntr/app/im/chat/service/sender/image/LocalImageAsset;", "<init>", "()V", "acceptType", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/reflect/KClass;", "getAcceptType", "()Ljava/util/Set;", "findAssetByIdentifier", "Lkotlin/Result;", "identifier", RoomRecommendViewModel.EMPTY_CURSOR, "findAssetByIdentifier-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LocalImageAssetFinder implements AssetFinder<LocalImageAsset> {
    public static final int $stable = 0;

    public Set<KClass<? extends LocalImageAsset>> getAcceptType() {
        return SetsKt.setOf(Reflection.getOrCreateKotlinClass(LocalImageAsset.class));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* renamed from: findAssetByIdentifier-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m1605findAssetByIdentifiergIAlus(String identifier, Continuation<? super Result<LocalImageAsset>> continuation) {
        LocalImageAssetFinder$findAssetByIdentifier$1 localImageAssetFinder$findAssetByIdentifier$1;
        LocalImageAssetFinder$findAssetByIdentifier$1 localImageAssetFinder$findAssetByIdentifier$12;
        Path path;
        Object withContext;
        Path path2;
        Object obj;
        if (continuation instanceof LocalImageAssetFinder$findAssetByIdentifier$1) {
            localImageAssetFinder$findAssetByIdentifier$1 = (LocalImageAssetFinder$findAssetByIdentifier$1) continuation;
            if ((localImageAssetFinder$findAssetByIdentifier$1.label & Integer.MIN_VALUE) != 0) {
                localImageAssetFinder$findAssetByIdentifier$1.label -= Integer.MIN_VALUE;
                localImageAssetFinder$findAssetByIdentifier$12 = localImageAssetFinder$findAssetByIdentifier$1;
                Object $result = localImageAssetFinder$findAssetByIdentifier$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (localImageAssetFinder$findAssetByIdentifier$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        try {
                            Result.Companion companion = Result.Companion;
                            path = PathsJvmKt.Path(identifier);
                            localImageAssetFinder$findAssetByIdentifier$12.L$0 = SpillingKt.nullOutSpilledVariable(identifier);
                            localImageAssetFinder$findAssetByIdentifier$12.L$1 = path;
                            localImageAssetFinder$findAssetByIdentifier$12.I$0 = 0;
                            localImageAssetFinder$findAssetByIdentifier$12.I$1 = 0;
                            localImageAssetFinder$findAssetByIdentifier$12.label = 1;
                            withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new LocalImageAssetFinder$findAssetByIdentifier$2$contentSize$1(path, null), localImageAssetFinder$findAssetByIdentifier$12);
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(localImageAssetFinder$findAssetByIdentifier$12.getContext());
                            return obj;
                        }
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        path2 = path;
                        double contentSize = ((ContentSize) withContext).unbox-impl();
                        String extName = StringsKt.substringAfter$default(path2.getName(), ".", (String) null, 2, (Object) null);
                        obj = Result.constructor-impl(new LocalImageAsset(path2, contentSize, MimeType.Companion.fromString("image/" + extName), null, null, 24, null));
                        JobKt.ensureActive(localImageAssetFinder$findAssetByIdentifier$12.getContext());
                        return obj;
                    case 1:
                        int i = localImageAssetFinder$findAssetByIdentifier$12.I$1;
                        int i2 = localImageAssetFinder$findAssetByIdentifier$12.I$0;
                        path2 = (Path) localImageAssetFinder$findAssetByIdentifier$12.L$1;
                        String str = (String) localImageAssetFinder$findAssetByIdentifier$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            withContext = $result;
                            double contentSize2 = ((ContentSize) withContext).unbox-impl();
                            String extName2 = StringsKt.substringAfter$default(path2.getName(), ".", (String) null, 2, (Object) null);
                            obj = Result.constructor-impl(new LocalImageAsset(path2, contentSize2, MimeType.Companion.fromString("image/" + extName2), null, null, 24, null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion22 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                            JobKt.ensureActive(localImageAssetFinder$findAssetByIdentifier$12.getContext());
                            return obj;
                        }
                        JobKt.ensureActive(localImageAssetFinder$findAssetByIdentifier$12.getContext());
                        return obj;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        localImageAssetFinder$findAssetByIdentifier$1 = new LocalImageAssetFinder$findAssetByIdentifier$1(this, continuation);
        localImageAssetFinder$findAssetByIdentifier$12 = localImageAssetFinder$findAssetByIdentifier$1;
        Object $result2 = localImageAssetFinder$findAssetByIdentifier$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (localImageAssetFinder$findAssetByIdentifier$12.label) {
        }
    }
}