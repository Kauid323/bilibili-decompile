package kntr.app.deepsearch.service;

import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataItemIdentifier;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.TextLayout;
import kntr.app.deepsearch.di.DeepSearchScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicInt;

/* compiled from: DeepSearchDataProcessServiceImp.kt */
@DeepSearchScope
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J \u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkntr/app/deepsearch/service/DeepSearchDataProcessServiceImp;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "<init>", "()V", "layoutMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/biz/TextLayout;", "paragraphMap", "Lcom/bapis/bilibili/app/dynamic/v2/KModuleParagraph;", "atomicInt", "Lkotlinx/atomicfu/AtomicInt;", "currentReqQueryId", "abnormalQueryIdList", RoomRecommendViewModel.EMPTY_CURSOR, "endQueryIdList", "getCacheLayout", "idModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItemIdentifier;", "getAtomicIndex", RoomRecommendViewModel.EMPTY_CURSOR, "cacheCurrentReqQueryId", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "isCurrentReqQueryId", RoomRecommendViewModel.EMPTY_CURSOR, "cacheEndQuery", "isContainEndQueryId", "saveLayout", "paragraph", "textLayout", "updateLayout", "isSameParagraph", "cleanLayoutCache", "cacheAbnormalQuery", "removeAbnormalQuery", "isContainAbnormalQueryId", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchDataProcessServiceImp implements DeepSearchDataProcessService {
    public static final int $stable = 8;
    private final Map<String, TextLayout> layoutMap = new LinkedHashMap();
    private final Map<String, KModuleParagraph> paragraphMap = new LinkedHashMap();
    private final AtomicInt atomicInt = AtomicFU.atomic(0);
    private String currentReqQueryId = RoomRecommendViewModel.EMPTY_CURSOR;
    private final List<String> abnormalQueryIdList = new ArrayList();
    private final List<String> endQueryIdList = new ArrayList();

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public TextLayout getCacheLayout(DeepSearchDataItemIdentifier idModel) {
        Intrinsics.checkNotNullParameter(idModel, "idModel");
        String key = String.valueOf(idModel.hashCode());
        return this.layoutMap.get(key);
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public int getAtomicIndex() {
        return this.atomicInt.incrementAndGet();
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public void cacheCurrentReqQueryId(String queryId) {
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        this.currentReqQueryId = queryId;
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public boolean isCurrentReqQueryId(String queryId) {
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        return Intrinsics.areEqual(this.currentReqQueryId, queryId);
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public void cacheEndQuery(String queryId) {
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        this.endQueryIdList.add(queryId);
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public boolean isContainEndQueryId(String queryId) {
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        return this.endQueryIdList.contains(queryId);
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public void saveLayout(DeepSearchDataItemIdentifier idModel, KModuleParagraph paragraph, TextLayout textLayout) {
        Intrinsics.checkNotNullParameter(idModel, "idModel");
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        Intrinsics.checkNotNullParameter(textLayout, "textLayout");
        String key = String.valueOf(idModel.hashCode());
        this.paragraphMap.put(key, paragraph);
        this.layoutMap.put(key, textLayout);
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public void updateLayout(DeepSearchDataItemIdentifier idModel, TextLayout textLayout) {
        Intrinsics.checkNotNullParameter(idModel, "idModel");
        Intrinsics.checkNotNullParameter(textLayout, "textLayout");
        String key = String.valueOf(idModel.hashCode());
        this.layoutMap.put(key, textLayout);
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public boolean isSameParagraph(DeepSearchDataItemIdentifier idModel, KModuleParagraph paragraph) {
        Intrinsics.checkNotNullParameter(idModel, "idModel");
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        String key = String.valueOf(idModel.hashCode());
        KModuleParagraph cacheContent = this.paragraphMap.get(key);
        return cacheContent != null && cacheContent.hashCode() == paragraph.hashCode();
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public void cleanLayoutCache() {
        this.paragraphMap.clear();
        this.layoutMap.clear();
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public void cacheAbnormalQuery(String queryId) {
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        if (!isContainAbnormalQueryId(queryId)) {
            this.abnormalQueryIdList.add(queryId);
        }
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public void removeAbnormalQuery(String queryId) {
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        if (isContainAbnormalQueryId(queryId)) {
            this.abnormalQueryIdList.remove(queryId);
        }
    }

    @Override // kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService
    public boolean isContainAbnormalQueryId(String queryId) {
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        return this.abnormalQueryIdList.contains(queryId);
    }
}