package kntr.app.upper.entrance.bubble2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.ab.AbParamsProvider;
import kntr.app.upper.entrance.ab.AppLaunchAB;
import kntr.app.upper.entrance.ab.AppLaunchABConfig;
import kntr.app.upper.entrance.ab.AppLaunchABManager;
import kntr.app.upper.entrance.bubble.UperCenterPlusBubbleManager;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.primer.BlockScene;
import kntr.base.primer.GPrimerBizParamsList;
import kntr.base.primer.HitType;
import kntr.base.primer.PrimerBizParams;
import kntr.base.primer.PrimerPath;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColdStartBubble.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\"\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"provideColdStartBubbleInfoParams", "Lkntr/base/primer/GPrimerBizParamsList;", "account", "Lkntr/base/account/KAccountStore;", "abExtra", "Lkntr/app/upper/entrance/ab/AbParamsProvider;", "currentMid", "", "getCurrentMid", "(Lkntr/base/account/KAccountStore;)Ljava/lang/String;", "entrance_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ColdStartBubbleKt {
    public static final GPrimerBizParamsList provideColdStartBubbleInfoParams(final KAccountStore account, final AbParamsProvider abExtra) {
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(abExtra, "abExtra");
        return new GPrimerBizParamsList() { // from class: kntr.app.upper.entrance.bubble2.ColdStartBubbleKt$provideColdStartBubbleInfoParams$1
            @Override // kntr.base.primer.GPrimerBizParamsList
            public List<PrimerBizParams> params() {
                String mid;
                PrimerBizParams primerBizParams;
                PrimerBizParams bubble;
                PrimerBizParams blackList;
                Map extraParams = AbParamsProvider.this.provideParams();
                mid = ColdStartBubbleKt.getCurrentMid(account);
                if (mid.length() == 0) {
                    return CollectionsKt.listOf(new PrimerBizParams[]{new PrimerBizParams(PrimerPath.UperAbtest, MapsKt.emptyMap(), null, null, null, null, CollectionsKt.listOf(BlockScene.Block.INSTANCE), 60, null), new PrimerBizParams(PrimerPath.UperBubble, MapsKt.emptyMap(), null, null, null, null, CollectionsKt.listOf(BlockScene.Block.INSTANCE), 60, null), new PrimerBizParams(PrimerPath.UperBlackList, MapsKt.emptyMap(), null, null, null, null, CollectionsKt.listOf(BlockScene.Block.INSTANCE), 60, null)});
                }
                Pair showFetch = UperCenterPlusBubbleManager.INSTANCE.shouldFetchInColdStart(mid);
                if (showFetch.getFirst().booleanValue()) {
                    Map params = new LinkedHashMap();
                    Iterable abList = AppLaunchABConfig.INSTANCE.getAPP_LAUNCH_AB$entrance_debug();
                    Iterable $this$map$iv = abList;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        AppLaunchAB it = (AppLaunchAB) item$iv$iv;
                        destination$iv$iv.add(AppLaunchABManager.INSTANCE.getDynamicKey$entrance_debug(it));
                    }
                    List requestAbKeys = CollectionsKt.plus((List) destination$iv$iv, AppLaunchABManager.INSTANCE.getEmptyAbKey$entrance_debug());
                    params.put("mid", mid);
                    params.put("ab_variables", CollectionsKt.joinToString$default(CollectionsKt.distinct(requestAbKeys), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                    params.putAll(extraParams);
                    primerBizParams = new PrimerBizParams(PrimerPath.UperAbtest, params, null, null, null, HitType.Once.INSTANCE, null, 92, null);
                } else {
                    primerBizParams = new PrimerBizParams(PrimerPath.UperAbtest, MapsKt.emptyMap(), null, null, null, null, CollectionsKt.listOf(BlockScene.Block.INSTANCE), 60, null);
                }
                PrimerBizParams ab = primerBizParams;
                if (showFetch.getSecond().booleanValue()) {
                    bubble = new PrimerBizParams(PrimerPath.UperBubble, MapsKt.emptyMap(), null, null, null, HitType.Once.INSTANCE, null, 92, null);
                } else {
                    bubble = new PrimerBizParams(PrimerPath.UperBubble, MapsKt.emptyMap(), null, null, null, null, CollectionsKt.listOf(BlockScene.Block.INSTANCE), 60, null);
                }
                if (showFetch.getSecond().booleanValue()) {
                    blackList = new PrimerBizParams(PrimerPath.UperBlackList, MapsKt.emptyMap(), null, null, null, HitType.Once.INSTANCE, null, 92, null);
                } else {
                    blackList = new PrimerBizParams(PrimerPath.UperBlackList, MapsKt.emptyMap(), null, null, null, null, CollectionsKt.listOf(BlockScene.Block.INSTANCE), 60, null);
                }
                return CollectionsKt.listOf(new PrimerBizParams[]{ab, bubble, blackList});
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getCurrentMid(KAccountStore $this$currentMid) {
        AccountState state = (AccountState) $this$currentMid.getState().getValue();
        return state instanceof AccountState.Logged ? String.valueOf(((AccountState.Logged) state).getUserInfo().getMid()) : "";
    }
}