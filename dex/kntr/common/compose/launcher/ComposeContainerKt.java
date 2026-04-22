package kntr.common.compose.launcher;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.base.router.target.FunctionTarget;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;

/* compiled from: ComposeContainer.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001a(\u0010\u0003\u001a\u00020\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0006*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u0001H\u0005H\u0086\b¢\u0006\u0002\u0010\t\u001a*\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u000b\"\u0006\b\u0000\u0010\u0005\u0018\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086H¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"logInfo", "", "Lkntr/base/router/target/FunctionTarget;", "setPageResult", "", "R", "", "Lkntr/common/compose/launcher/PageResultRegistry;", "result", "(Lkntr/common/compose/launcher/PageResultRegistry;Ljava/lang/Object;)V", "launchKomponentForResult", "Lkotlin/Result;", "Lkntr/base/router/Router;", "uri", "Lcom/bilibili/lib/brouter/uri/Uri;", "(Lkntr/base/router/Router;Lcom/bilibili/lib/brouter/uri/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposeContainerKt {
    public static final String logInfo(FunctionTarget<?> functionTarget) {
        Intrinsics.checkNotNullParameter(functionTarget, "<this>");
        KClass kClass = functionTarget.getKClass();
        if (kClass != null) {
            String qualifiedName = kClass.getQualifiedName();
            return qualifiedName + "#" + functionTarget.getSimpleName();
        }
        String packageName = functionTarget.getPackageName();
        return packageName + "#" + functionTarget.getSimpleName();
    }

    public static final /* synthetic */ <R> void setPageResult(PageResultRegistry $this$setPageResult, R r) {
        Intrinsics.checkNotNullParameter($this$setPageResult, "<this>");
        Intrinsics.reifiedOperationMarker(6, "R");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        $this$setPageResult.setPageResult(r, SerializersKt.serializer((KType) null));
    }

    public static final /* synthetic */ <R> Object launchKomponentForResult(Router $this$launchKomponentForResult, Uri uri, Continuation<? super Result<? extends R>> continuation) {
        Intrinsics.reifiedOperationMarker(6, "R");
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        KSerializer serializer = SerializersKt.serializer((KType) null);
        InlineMarker.mark(0);
        Object launchKomponentForResult = ComposeContainer_androidKt.launchKomponentForResult($this$launchKomponentForResult, uri, serializer, continuation);
        InlineMarker.mark(1);
        InlineMarker.mark(8);
        Object m2645unboximpl = ((Result) launchKomponentForResult).m2645unboximpl();
        InlineMarker.mark(9);
        return m2645unboximpl;
    }
}