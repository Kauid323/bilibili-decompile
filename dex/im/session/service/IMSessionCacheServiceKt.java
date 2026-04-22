package im.session.service;

import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import im.session.model.IMQuickLinkLensKt;
import im.session.model.IMSessionFilterKt;
import im.session.model.IMSessionPageData;
import im.session.model.IMSessionPageDataLensKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionCacheService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002¨\u0006\u0004"}, d2 = {"isValidForSave", "", "Lim/session/model/IMSessionPageData;", "asCacheData", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionCacheServiceKt {
    public static final /* synthetic */ boolean access$isValidForSave(IMSessionPageData $receiver) {
        return isValidForSave($receiver);
    }

    public static final boolean isValidForSave(IMSessionPageData $this$isValidForSave) {
        boolean isEmpty = $this$isValidForSave.getQuickLinks() == null && $this$isValidForSave.getSessions().isEmpty();
        boolean isDefaultFilter = Intrinsics.areEqual(IMSessionFilterKt.currentFilterType($this$isValidForSave.getFilters()), KSessionFilterType.FILTER_DEFAULT.INSTANCE);
        return (!isDefaultFilter || isEmpty || $this$isValidForSave.isCache()) ? false : true;
    }

    public static final IMSessionPageData asCacheData(IMSessionPageData $this$asCacheData) {
        return (IMSessionPageData) CopyScopeKt.copy($this$asCacheData, new Function1() { // from class: im.session.service.IMSessionCacheServiceKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit asCacheData$lambda$0;
                asCacheData$lambda$0 = IMSessionCacheServiceKt.asCacheData$lambda$0((CopyScope) obj);
                return asCacheData$lambda$0;
            }
        });
    }

    public static final Unit asCacheData$lambda$0(CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(IMSessionPageDataLensKt.getPaginationParams(IMSessionPageData.Companion), (Object) null);
        $this$copy.set(IMSessionPageDataLensKt.getExtraInfo(IMSessionPageData.Companion), (Object) null);
        $this$copy.set(IMSessionPageDataLensKt.isCache(IMSessionPageData.Companion), true);
        $this$copy.set(IMQuickLinkLensKt.bubbleNullable(IMSessionPageDataLensKt.getQuickLinks(IMSessionPageData.Companion)), (Object) null);
        return Unit.INSTANCE;
    }
}