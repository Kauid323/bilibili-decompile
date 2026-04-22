package video.biz.offline.base.facade.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.facade.OfflineFacadeImpl_androidKt;
import video.biz.offline.base.facade.model.PanelStateModel;
import video.biz.offline.base.facade.model.PanelStateModelKt;
import video.biz.offline.base.facade.protocol.IDataStorage;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.model.ResolveParam;

/* compiled from: DownloadPanelViewModel.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\rH\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\r0\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lvideo/biz/offline/base/facade/viewmodel/DownloadPanelViewModel;", "", "groupId", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(JLkotlinx/coroutines/CoroutineScope;)V", "getScope$facade_debug$annotations", "()V", "getScope$facade_debug", "()Lkotlinx/coroutines/CoroutineScope;", "lastState", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "_dataState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lvideo/biz/offline/base/facade/model/PanelStateModel;", "dataState", "Lkotlinx/coroutines/flow/StateFlow;", "getDataState$annotations", "getDataState", "()Lkotlinx/coroutines/flow/StateFlow;", "downloadVideos", "", "params", "Lvideo/biz/offline/base/model/model/ResolveParam;", "facade_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DownloadPanelViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<List<PanelStateModel>> _dataState;
    private final StateFlow<List<PanelStateModel>> dataState;
    private List<OfflineVideoEntity> lastState;
    private final CoroutineScope scope;

    public static /* synthetic */ void getDataState$annotations() {
    }

    public static /* synthetic */ void getScope$facade_debug$annotations() {
    }

    public DownloadPanelViewModel(long groupId, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.lastState = CollectionsKt.emptyList();
        BuildersKt.launch$default(this.scope, CoroutineExJvmKt.getIoContext(), (CoroutineStart) null, new AnonymousClass1(groupId, this, null), 2, (Object) null);
        this._dataState = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.dataState = FlowKt.asStateFlow(this._dataState);
    }

    public final CoroutineScope getScope$facade_debug() {
        return this.scope;
    }

    /* compiled from: DownloadPanelViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "video.biz.offline.base.facade.viewmodel.DownloadPanelViewModel$1", f = "DownloadPanelViewModel.kt", i = {}, l = {DynModuleType.module_button_VALUE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: video.biz.offline.base.facade.viewmodel.DownloadPanelViewModel$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $groupId;
        int label;
        final /* synthetic */ DownloadPanelViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(long j, DownloadPanelViewModel downloadPanelViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$groupId = j;
            this.this$0 = downloadPanelViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$groupId, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow videosFlowByGroupId$default = IDataStorage.CC.getVideosFlowByGroupId$default(OfflineFacadeImpl_androidKt.getOfflineFacadeImpl(), this.$groupId, null, 2, null);
                    final DownloadPanelViewModel downloadPanelViewModel = this.this$0;
                    this.label = 1;
                    if (videosFlowByGroupId$default.collect(new FlowCollector() { // from class: video.biz.offline.base.facade.viewmodel.DownloadPanelViewModel.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((List) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(List<OfflineVideoEntity> list, Continuation<? super Unit> continuation) {
                            T t;
                            List<OfflineVideoEntity> $this$filter$iv = list;
                            DownloadPanelViewModel downloadPanelViewModel2 = DownloadPanelViewModel.this;
                            Collection destination$iv$iv = new ArrayList();
                            for (T t2 : $this$filter$iv) {
                                OfflineVideoEntity item = (OfflineVideoEntity) t2;
                                Iterator<T> it = downloadPanelViewModel2.lastState.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        t = null;
                                        break;
                                    }
                                    t = it.next();
                                    OfflineVideoEntity it2 = (OfflineVideoEntity) t;
                                    if (Intrinsics.areEqual(item, it2)) {
                                        break;
                                    }
                                }
                                OfflineVideoEntity video2 = (OfflineVideoEntity) t;
                                boolean z = true;
                                if (video2 != null && Intrinsics.areEqual(video2.getState(), item.getState())) {
                                    z = false;
                                }
                                if (z) {
                                    destination$iv$iv.add(t2);
                                }
                            }
                            List update = (List) destination$iv$iv;
                            Iterable $this$filter$iv2 = DownloadPanelViewModel.this.lastState;
                            Collection destination$iv$iv2 = new ArrayList();
                            for (T t3 : $this$filter$iv2) {
                                if (!list.contains((OfflineVideoEntity) t3)) {
                                    destination$iv$iv2.add(t3);
                                }
                            }
                            Iterable delete = (List) destination$iv$iv2;
                            Iterable $this$forEach$iv = delete;
                            for (Object element$iv : $this$forEach$iv) {
                                OfflineVideoEntity it3 = (OfflineVideoEntity) element$iv;
                                it3.setState(OfflineVideoEntity.State.IDLE.INSTANCE);
                            }
                            MutableStateFlow mutableStateFlow = DownloadPanelViewModel.this._dataState;
                            Iterable $this$map$iv = CollectionsKt.plus(update, delete);
                            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                OfflineVideoEntity it4 = (OfflineVideoEntity) item$iv$iv;
                                destination$iv$iv3.add(PanelStateModelKt.convert2PanelModel(it4));
                            }
                            mutableStateFlow.setValue((List) destination$iv$iv3);
                            DownloadPanelViewModel downloadPanelViewModel3 = DownloadPanelViewModel.this;
                            List<OfflineVideoEntity> $this$map$iv2 = list;
                            Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            for (Object item$iv$iv2 : $this$map$iv2) {
                                OfflineVideoEntity it5 = (OfflineVideoEntity) item$iv$iv2;
                                destination$iv$iv4.add(OfflineVideoEntity.m2770copyQZD5vYk$default(it5, 0L, null, 0L, 0L, 0L, 0L, null, null, 0, 0L, null, 0L, null, null, null, 0L, null, 0L, 0L, 0L, 0L, 0, 0, 0, null, null, null, null, null, 0, 0, 0L, 0L, null, 0L, 0L, 0L, 0L, null, null, 0, null, 0, null, null, null, null, -1, 32767, null));
                            }
                            downloadPanelViewModel3.lastState = (List) destination$iv$iv4;
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final StateFlow<List<PanelStateModel>> getDataState() {
        return this.dataState;
    }

    public final void downloadVideos(List<ResolveParam> list) {
        Intrinsics.checkNotNullParameter(list, "params");
        BuildersKt.launch$default(this.scope, CoroutineExJvmKt.getIoContext(), (CoroutineStart) null, new DownloadPanelViewModel$downloadVideos$1(list, null), 2, (Object) null);
    }
}