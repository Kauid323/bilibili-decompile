package tv.danmaku.bili.ui.offline;

import android.util.LongSparseArray;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.videodownloader.model.season.Episode;
import com.google.gson.JsonArray;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.offline.OfflineHomeSection;
import tv.danmaku.bili.ui.offline.api.EpPlayableV2;
import tv.danmaku.bili.ui.offline.api.OfflineServiceManager;
import tv.danmaku.bili.ui.offline.api.OgvApiResponseV2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineHomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.OfflineHomeFragment$queryEpPlayableV2$2", f = "OfflineHomeFragment.kt", i = {}, l = {718}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineHomeFragment$queryEpPlayableV2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JsonArray $offlineList;
    int label;
    final /* synthetic */ OfflineHomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineHomeFragment$queryEpPlayableV2$2(JsonArray jsonArray, OfflineHomeFragment offlineHomeFragment, Continuation<? super OfflineHomeFragment$queryEpPlayableV2$2> continuation) {
        super(2, continuation);
        this.$offlineList = jsonArray;
        this.this$0 = offlineHomeFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineHomeFragment$queryEpPlayableV2$2(this.$offlineList, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        List emptyList;
        OfflineHomeAdapter mAdapter;
        List infoList;
        HybirdOfflineManager mOfflineManager;
        OfflineHomeAdapter mAdapter2;
        Object $result4;
        boolean z;
        LongSparseArray epPlayableMap;
        boolean z2;
        Object[] $this$forEach$iv;
        boolean checkPlayable;
        boolean checkPlayable2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object m1374queryEpPlayableV2CatchinggIAlus = OfflineServiceManager.INSTANCE.m1374queryEpPlayableV2CatchinggIAlus(this.$offlineList, (Continuation) this);
                if (m1374queryEpPlayableV2CatchinggIAlus == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result3 = m1374queryEpPlayableV2CatchinggIAlus;
                break;
            case 1:
                $result2 = $result;
                ResultKt.throwOnFailure($result2);
                $result3 = ((Result) $result2).unbox-impl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OfflineHomeFragment offlineHomeFragment = this.this$0;
        if (Result.isSuccess-impl($result3)) {
            OgvApiResponseV2 result = (OgvApiResponseV2) $result3;
            boolean z3 = false;
            if (result != null) {
                EpPlayableV2 data = result.getData();
                if (data == null || (emptyList = data.getEpPlayableParams()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                List params = emptyList;
                if (!params.isEmpty()) {
                    mAdapter = offlineHomeFragment.getMAdapter();
                    OfflineHomeSection.Downloaded downloadedSection = mAdapter.getDownloadedSection();
                    if (downloadedSection == null || (infoList = downloadedSection.mInfoList) == null) {
                        infoList = CollectionsKt.emptyList();
                    }
                    if (!infoList.isEmpty()) {
                        LongSparseArray epPlayableMap2 = OfflineServiceManager.INSTANCE.mapEpPlayableV2List(params);
                        LongSparseArray modifiedInfoMap = new LongSparseArray();
                        List $this$toTypedArray$iv = infoList;
                        int i = 0;
                        Object[] $this$forEach$iv2 = $this$toTypedArray$iv.toArray(new OfflineInfo[0]);
                        int length = $this$forEach$iv2.length;
                        while (i < length) {
                            Object element$iv = $this$forEach$iv2[i];
                            OfflineInfo offlineInfo = (OfflineInfo) element$iv;
                            List pages = offlineInfo.pages;
                            if (!pages.isEmpty()) {
                                $result4 = $result2;
                                boolean z4 = false;
                                for (Object element$iv2 : pages) {
                                    OfflineInfo page = (OfflineInfo) element$iv2;
                                    if (page != null) {
                                        Object episode = page.typeInfo;
                                        z = z4;
                                        if (!(episode instanceof Episode)) {
                                            epPlayableMap = epPlayableMap2;
                                            z2 = z3;
                                            $this$forEach$iv = $this$forEach$iv2;
                                        } else {
                                            z2 = z3;
                                            $this$forEach$iv = $this$forEach$iv2;
                                            Integer num = epPlayableMap2.get(((Episode) episode).id);
                                            if (num != null) {
                                                int playable = num.intValue();
                                                page.seasonCode = playable;
                                                checkPlayable = offlineHomeFragment.checkPlayable(playable);
                                                page.setVerificationPlayable(checkPlayable);
                                                epPlayableMap = epPlayableMap2;
                                                modifiedInfoMap.put(((Episode) episode).id, page);
                                            } else {
                                                epPlayableMap = epPlayableMap2;
                                            }
                                        }
                                    } else {
                                        z = z4;
                                        epPlayableMap = epPlayableMap2;
                                        z2 = z3;
                                        $this$forEach$iv = $this$forEach$iv2;
                                    }
                                    z4 = z;
                                    z3 = z2;
                                    $this$forEach$iv2 = $this$forEach$iv;
                                    epPlayableMap2 = epPlayableMap;
                                }
                            } else {
                                Object episode2 = offlineInfo.typeInfo;
                                if (!(episode2 instanceof Episode)) {
                                    $result4 = $result2;
                                } else {
                                    Integer num2 = epPlayableMap2.get(((Episode) episode2).id);
                                    if (num2 != null) {
                                        int playable2 = num2.intValue();
                                        offlineInfo.seasonCode = playable2;
                                        checkPlayable2 = offlineHomeFragment.checkPlayable(playable2);
                                        offlineInfo.setVerificationPlayable(checkPlayable2);
                                        $result4 = $result2;
                                        modifiedInfoMap.put(((Episode) episode2).id, offlineInfo);
                                    } else {
                                        $result4 = $result2;
                                    }
                                }
                            }
                            i++;
                            $result2 = $result4;
                            z3 = z3;
                            $this$forEach$iv2 = $this$forEach$iv2;
                            epPlayableMap2 = epPlayableMap2;
                        }
                        mOfflineManager = offlineHomeFragment.getMOfflineManager();
                        mOfflineManager.updateVideoPlayable(modifiedInfoMap);
                        mAdapter2 = offlineHomeFragment.getMAdapter();
                        mAdapter2.notifyDataSetChanged();
                    }
                }
            }
        }
        Throwable t = Result.exceptionOrNull-impl($result3);
        if (t != null) {
            BLog.w("offline-home", t);
        }
        return Unit.INSTANCE;
    }
}