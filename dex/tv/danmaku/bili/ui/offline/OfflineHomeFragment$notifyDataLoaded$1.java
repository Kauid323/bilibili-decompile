package tv.danmaku.bili.ui.offline;

import android.util.LongSparseArray;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.offline.OfflineType;
import com.bilibili.ugc.offline.drama.DramaVideo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.offline.OfflineHomeSection;
import tv.danmaku.bili.ui.offline.api.OfflineServiceManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineHomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.OfflineHomeFragment$notifyDataLoaded$1", f = "OfflineHomeFragment.kt", i = {0, 0}, l = {517}, m = "invokeSuspend", n = {"downloadedList", "downloadingList"}, s = {"L$0", "L$1"}, v = 1)
public final class OfflineHomeFragment$notifyDataLoaded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OfflineHomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineHomeFragment$notifyDataLoaded$1(OfflineHomeFragment offlineHomeFragment, Continuation<? super OfflineHomeFragment$notifyDataLoaded$1> continuation) {
        super(2, continuation);
        this.this$0 = offlineHomeFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineHomeFragment$notifyDataLoaded$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        OfflineHomeAdapter mAdapter;
        List downloadedList;
        OfflineHomeAdapter mAdapter2;
        List downloadingList;
        Object $result2;
        Iterable downloadingList2;
        Object obj;
        HybirdOfflineManager mOfflineManager;
        OfflineHomeAdapter mAdapter3;
        Object obj2;
        boolean z;
        Object obj3;
        boolean z2;
        Object $result3;
        boolean z3;
        Object obj4;
        boolean z4;
        boolean z5;
        boolean z6;
        Iterator it;
        Object obj5;
        boolean z7;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mAdapter = this.this$0.getMAdapter();
                OfflineHomeSection.Downloaded downloadedSection = mAdapter.getDownloadedSection();
                if (downloadedSection == null || (downloadedList = downloadedSection.mInfoList) == null) {
                    downloadedList = CollectionsKt.emptyList();
                }
                mAdapter2 = this.this$0.getMAdapter();
                OfflineHomeSection downloadingSection = mAdapter2.getDownloadingSection();
                if (downloadingSection == null || (downloadingList = downloadingSection.mInfoList) == null) {
                    downloadingList = CollectionsKt.emptyList();
                }
                if (downloadedList.isEmpty() && downloadingList.isEmpty()) {
                    return Unit.INSTANCE;
                }
                List avList = new ArrayList();
                Iterable $this$forEach$iv = downloadedList;
                for (Object element$iv : $this$forEach$iv) {
                    OfflineInfo info = (OfflineInfo) element$iv;
                    OfflineType offlineType = info.offlineType;
                    Integer boxInt = offlineType != null ? Boxing.boxInt(offlineType.type) : null;
                    int i = OfflineType.TYPE_VIDEO;
                    if (boxInt != null && boxInt.intValue() == i) {
                        avList.add(Boxing.boxLong(info.id));
                    } else {
                        int i2 = OfflineType.TYPE_DRAMA;
                        if (boxInt != null && boxInt.intValue() == i2) {
                            Iterable $this$forEach$iv2 = info.pages;
                            for (Object element$iv2 : $this$forEach$iv2) {
                                OfflineInfo page = (OfflineInfo) element$iv2;
                                Object obj6 = page != null ? page.typeInfo : null;
                                DramaVideo dramaVideo = obj6 instanceof DramaVideo ? (DramaVideo) obj6 : null;
                                if (dramaVideo != null) {
                                    long it2 = dramaVideo.avid;
                                    avList.add(Boxing.boxLong(it2));
                                }
                            }
                        }
                    }
                }
                Iterable $this$forEach$iv3 = downloadingList;
                for (Object element$iv3 : $this$forEach$iv3) {
                    OfflineInfo info2 = (OfflineInfo) element$iv3;
                    OfflineType offlineType2 = info2.offlineType;
                    Integer boxInt2 = offlineType2 != null ? Boxing.boxInt(offlineType2.type) : null;
                    int i3 = OfflineType.TYPE_VIDEO;
                    if (boxInt2 != null && boxInt2.intValue() == i3) {
                        avList.add(Boxing.boxLong(info2.id));
                    } else {
                        int i4 = OfflineType.TYPE_DRAMA;
                        if (boxInt2 != null && boxInt2.intValue() == i4) {
                            Object obj7 = info2 != null ? info2.typeInfo : null;
                            DramaVideo dramaVideo2 = obj7 instanceof DramaVideo ? (DramaVideo) obj7 : null;
                            if (dramaVideo2 != null) {
                                long it3 = dramaVideo2.avid;
                                avList.add(Boxing.boxLong(it3));
                            }
                        }
                    }
                }
                if (!avList.isEmpty()) {
                    this.L$0 = downloadedList;
                    this.L$1 = downloadingList;
                    this.label = 1;
                    Object m1375videoVerifyReqCatching0E7RQCE = OfflineServiceManager.INSTANCE.m1375videoVerifyReqCatching0E7RQCE(avList, 30, (Continuation) this);
                    if (m1375videoVerifyReqCatching0E7RQCE != coroutine_suspended) {
                        $result2 = $result;
                        downloadingList2 = downloadingList;
                        obj = m1375videoVerifyReqCatching0E7RQCE;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                } else {
                    return Unit.INSTANCE;
                }
                break;
            case 1:
                $result2 = $result;
                downloadingList2 = (List) this.L$1;
                downloadedList = (List) this.L$0;
                ResultKt.throwOnFailure($result2);
                obj = ((Result) $result2).unbox-impl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        OfflineHomeFragment offlineHomeFragment = this.this$0;
        if (Result.isSuccess-impl(obj)) {
            List list = (List) obj;
            boolean z8 = false;
            if (!list.isEmpty()) {
                LongSparseArray modifiedInfoMap = new LongSparseArray();
                List $this$forEach$iv4 = downloadedList;
                for (Object element$iv4 : $this$forEach$iv4) {
                    OfflineInfo offlineInfo = (OfflineInfo) element$iv4;
                    Iterable pages = offlineInfo.pages;
                    if (((Collection) pages).isEmpty()) {
                        $result3 = $result2;
                        z3 = z8;
                    } else {
                        OfflineType offlineType3 = offlineInfo.offlineType;
                        Integer boxInt3 = offlineType3 != null ? Boxing.boxInt(offlineType3.type) : null;
                        int i5 = OfflineType.TYPE_VIDEO;
                        if (boxInt3 == null) {
                            $result3 = $result2;
                            z3 = z8;
                        } else if (boxInt3.intValue() == i5) {
                            Iterator it4 = list.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    obj4 = it4.next();
                                    OfflineServiceManager.VideoVerifyResult it5 = (OfflineServiceManager.VideoVerifyResult) obj4;
                                    $result3 = $result2;
                                    if (!(it5.getAvid() == offlineInfo.id)) {
                                        $result2 = $result3;
                                    }
                                } else {
                                    $result3 = $result2;
                                    obj4 = null;
                                }
                            }
                            OfflineServiceManager.VideoVerifyResult playable = (OfflineServiceManager.VideoVerifyResult) obj4;
                            if (playable != null) {
                                boolean z9 = false;
                                Iterable $this$forEach$iv5 = pages;
                                for (Object element$iv5 : $this$forEach$iv5) {
                                    OfflineInfo info3 = (OfflineInfo) element$iv5;
                                    if (info3 != null) {
                                        z4 = z9;
                                        info3.setVerificationCode(playable.getCode());
                                        z5 = z8;
                                        info3.setVerificationPlayable(OfflineServiceManager.INSTANCE.toPlayable(playable.getCode()));
                                    } else {
                                        z4 = z9;
                                        z5 = z8;
                                    }
                                    z9 = z4;
                                    z8 = z5;
                                }
                                z3 = z8;
                                modifiedInfoMap.put(offlineInfo.id, offlineInfo);
                            } else {
                                z3 = z8;
                            }
                        } else {
                            $result3 = $result2;
                            z3 = z8;
                        }
                        int i6 = OfflineType.TYPE_DRAMA;
                        if (boxInt3 != null && boxInt3.intValue() == i6) {
                            Iterable $this$forEach$iv6 = pages;
                            boolean z10 = false;
                            Iterator it6 = $this$forEach$iv6.iterator();
                            while (it6.hasNext()) {
                                Object element$iv6 = it6.next();
                                OfflineInfo page2 = (OfflineInfo) element$iv6;
                                if (page2 != null) {
                                    Object obj8 = page2.typeInfo;
                                    DramaVideo dramaVideo3 = obj8 instanceof DramaVideo ? (DramaVideo) obj8 : null;
                                    if (dramaVideo3 != null) {
                                        long avid = dramaVideo3.avid;
                                        Iterator it7 = list.iterator();
                                        while (true) {
                                            if (it7.hasNext()) {
                                                obj5 = it7.next();
                                                OfflineServiceManager.VideoVerifyResult it8 = (OfflineServiceManager.VideoVerifyResult) obj5;
                                                if (it8.getAvid() == avid) {
                                                    z7 = true;
                                                    continue;
                                                } else {
                                                    z7 = false;
                                                    continue;
                                                }
                                                if (z7) {
                                                }
                                            } else {
                                                obj5 = null;
                                            }
                                        }
                                        OfflineServiceManager.VideoVerifyResult playable2 = (OfflineServiceManager.VideoVerifyResult) obj5;
                                        if (playable2 != null) {
                                            z6 = z10;
                                            page2.setVerificationCode(playable2.getCode());
                                            it = it6;
                                            page2.setVerificationPlayable(OfflineServiceManager.INSTANCE.toPlayable(playable2.getCode()));
                                            modifiedInfoMap.put(avid, page2);
                                        } else {
                                            z6 = z10;
                                            it = it6;
                                        }
                                    } else {
                                        z6 = z10;
                                        it = it6;
                                    }
                                } else {
                                    z6 = z10;
                                    it = it6;
                                }
                                z10 = z6;
                                it6 = it;
                            }
                        }
                    }
                    z8 = z3;
                    $result2 = $result3;
                }
                Iterable $this$forEach$iv7 = downloadingList2;
                for (Object element$iv7 : $this$forEach$iv7) {
                    OfflineInfo offlineInfo2 = (OfflineInfo) element$iv7;
                    OfflineType offlineType4 = offlineInfo2.offlineType;
                    Integer boxInt4 = offlineType4 != null ? Boxing.boxInt(offlineType4.type) : null;
                    int i7 = OfflineType.TYPE_VIDEO;
                    if (boxInt4 != null && boxInt4.intValue() == i7) {
                        Iterator it9 = list.iterator();
                        while (true) {
                            if (it9.hasNext()) {
                                obj3 = it9.next();
                                OfflineServiceManager.VideoVerifyResult it10 = (OfflineServiceManager.VideoVerifyResult) obj3;
                                if (it10.getAvid() == offlineInfo2.id) {
                                    z2 = true;
                                    continue;
                                } else {
                                    z2 = false;
                                    continue;
                                }
                                if (z2) {
                                }
                            } else {
                                obj3 = null;
                            }
                        }
                        OfflineServiceManager.VideoVerifyResult playable3 = (OfflineServiceManager.VideoVerifyResult) obj3;
                        if (playable3 != null) {
                            offlineInfo2.setVerificationCode(playable3.getCode());
                            offlineInfo2.setVerificationPlayable(OfflineServiceManager.INSTANCE.toPlayable(playable3.getCode()));
                            modifiedInfoMap.put(offlineInfo2.id, offlineInfo2);
                        }
                    } else {
                        int i8 = OfflineType.TYPE_DRAMA;
                        if (boxInt4 != null && boxInt4.intValue() == i8) {
                            Object obj9 = offlineInfo2.typeInfo;
                            DramaVideo dramaVideo4 = obj9 instanceof DramaVideo ? (DramaVideo) obj9 : null;
                            if (dramaVideo4 != null) {
                                long avid2 = dramaVideo4.avid;
                                Iterator it11 = list.iterator();
                                while (true) {
                                    if (it11.hasNext()) {
                                        obj2 = it11.next();
                                        OfflineServiceManager.VideoVerifyResult it12 = (OfflineServiceManager.VideoVerifyResult) obj2;
                                        if (it12.getAvid() == avid2) {
                                            z = true;
                                            continue;
                                        } else {
                                            z = false;
                                            continue;
                                        }
                                        if (z) {
                                        }
                                    } else {
                                        obj2 = null;
                                    }
                                }
                                OfflineServiceManager.VideoVerifyResult playable4 = (OfflineServiceManager.VideoVerifyResult) obj2;
                                if (playable4 != null) {
                                    offlineInfo2.setVerificationCode(playable4.getCode());
                                    offlineInfo2.setVerificationPlayable(OfflineServiceManager.INSTANCE.toPlayable(playable4.getCode()));
                                    modifiedInfoMap.put(avid2, offlineInfo2);
                                }
                            }
                        }
                    }
                }
                mOfflineManager = offlineHomeFragment.getMOfflineManager();
                mOfflineManager.updateVideoPlayable(modifiedInfoMap);
                mAdapter3 = offlineHomeFragment.getMAdapter();
                mAdapter3.notifyDataSetChanged();
            }
        }
        Throwable t = Result.exceptionOrNull-impl(obj);
        if (t != null) {
            BLog.e("offline-home", t);
        }
        return Unit.INSTANCE;
    }
}