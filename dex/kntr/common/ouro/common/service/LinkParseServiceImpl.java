package kntr.common.ouro.common.service;

import com.bapis.bilibili.app.dynamic.v2.KLinkNodeType;
import com.bapis.bilibili.app.dynamic.v2.KOpusMoss;
import com.bapis.bilibili.app.dynamic.v2.KSunflowerParseReq;
import com.bapis.bilibili.app.dynamic.v2.KSunflowerParseRsp;
import com.bapis.bilibili.app.dynamic.v2.KSunflowerParsedItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KCallOptions;
import kntr.common.ouro.core.model.node.EmoteParseResult;
import kntr.common.ouro.core.model.node.OpusParseResult;
import kntr.common.ouro.core.model.node.OuroLinkKt;
import kntr.common.ouro.core.model.node.RemoteParseResult;
import kntr.common.ouro.core.model.node.UnrecognizedUrlResult;
import kntr.common.ouro.core.model.node.VideoParseResult;
import kntr.common.ouro.core.model.node.WhitelistUrlParseResult;
import kntr.common.ouro.core.plugin.pasteboard.LinkParseService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;

/* compiled from: LinkParseServiceImpl.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0096@¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkntr/common/ouro/common/service/LinkParseServiceImpl;", "Lkntr/common/ouro/core/plugin/pasteboard/LinkParseService;", "<init>", "()V", "parse", "Lkotlin/Result;", "", "Lkntr/common/ouro/core/model/node/RemoteParseResult;", "urlList", "", "parse-gIAlu-s", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "service_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LinkParseServiceImpl implements LinkParseService {
    public static final Companion Companion = new Companion(null);
    private static final int MAX_BATCH_SIZE = 50;

    /* compiled from: LinkParseServiceImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/common/ouro/common/service/LinkParseServiceImpl$Companion;", "", "<init>", "()V", "MAX_BATCH_SIZE", "", "service_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:101|(1:102)|103|104|105|106|107|108|109|110|(1:112)(8:113|15|16|17|18|(0)(0)|94|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0142, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0143, code lost:
        r19 = r1;
        r5 = r16;
        r6 = r7;
        r7 = r9;
        r1 = r44;
        r3 = r4;
        r4 = r45;
        r8 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0156, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0157, code lost:
        r17 = r10;
        r19 = r1;
        r5 = r6;
        r6 = r7;
        r7 = r9;
        r1 = r44;
        r3 = r4;
        r4 = r45;
        r8 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x011a -> B:135:0x012b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0181 -> B:41:0x0193). Please submit an issue!!! */
    @Override // kntr.common.ouro.core.plugin.pasteboard.LinkParseService
    /* renamed from: parse-gIAlu-s  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1885parsegIAlus(List<String> list, Continuation<? super Result<? extends List<? extends RemoteParseResult>>> continuation) {
        LinkParseServiceImpl$parse$1 linkParseServiceImpl$parse$1;
        LinkParseServiceImpl linkParseServiceImpl;
        LinkParseServiceImpl$parse$1 linkParseServiceImpl$parse$12;
        Iterable $this$forEach$iv;
        Iterator it;
        List uniqueUrls;
        LinkParseServiceImpl linkParseServiceImpl2;
        int $i$f$forEach;
        List allResults;
        Object obj;
        Object $result;
        LinkParseServiceImpl$parse$1 linkParseServiceImpl$parse$13;
        Continuation $continuation;
        List urlList;
        List urlList2;
        LinkParseServiceImpl linkParseServiceImpl3;
        List allResults2;
        Iterator it2;
        Iterable $this$forEach$iv2;
        Throwable th;
        Object result;
        Iterator it3;
        LinkParseServiceImpl$parse$1 linkParseServiceImpl$parse$14;
        Continuation $continuation2;
        List urlList3;
        Iterable $this$forEach$iv3;
        Object $result2;
        List allResults3;
        List urlList4;
        Iterator it4;
        Continuation $completion;
        LinkParseServiceImpl$parse$1 linkParseServiceImpl$parse$15;
        Throwable it5;
        List urlList5;
        Iterator it6;
        Continuation $completion2;
        LinkParseServiceImpl$parse$1 linkParseServiceImpl$parse$16;
        EmoteParseResult emoteParseResult;
        Collection destination$iv$iv;
        List allResults4;
        Continuation $completion3 = continuation;
        if ($completion3 instanceof LinkParseServiceImpl$parse$1) {
            linkParseServiceImpl$parse$1 = (LinkParseServiceImpl$parse$1) $completion3;
            if ((linkParseServiceImpl$parse$1.label & Integer.MIN_VALUE) != 0) {
                linkParseServiceImpl$parse$1.label -= Integer.MIN_VALUE;
                linkParseServiceImpl = this;
                linkParseServiceImpl$parse$12 = linkParseServiceImpl$parse$1;
                Object $result3 = linkParseServiceImpl$parse$12.result;
                Object $result4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (linkParseServiceImpl$parse$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        List uniqueUrls2 = CollectionsKt.distinct(list);
                        List allResults5 = new ArrayList();
                        $this$forEach$iv = CollectionsKt.chunked(uniqueUrls2, 50);
                        it = $this$forEach$iv.iterator();
                        uniqueUrls = uniqueUrls2;
                        linkParseServiceImpl2 = linkParseServiceImpl;
                        $i$f$forEach = 0;
                        allResults = allResults5;
                        obj = $result4;
                        $result = $result3;
                        linkParseServiceImpl$parse$13 = linkParseServiceImpl$parse$12;
                        $continuation = $completion3;
                        urlList = list;
                        break;
                    case 1:
                        int i = linkParseServiceImpl$parse$12.I$3;
                        int i2 = linkParseServiceImpl$parse$12.I$2;
                        int i3 = linkParseServiceImpl$parse$12.I$1;
                        $i$f$forEach = linkParseServiceImpl$parse$12.I$0;
                        LinkParseServiceImpl$parse$1 linkParseServiceImpl$parse$17 = (LinkParseServiceImpl$parse$1) linkParseServiceImpl$parse$12.L$8;
                        KSunflowerParseReq kSunflowerParseReq = (KSunflowerParseReq) linkParseServiceImpl$parse$12.L$7;
                        List list2 = (List) linkParseServiceImpl$parse$12.L$6;
                        Object obj2 = linkParseServiceImpl$parse$12.L$5;
                        it2 = (Iterator) linkParseServiceImpl$parse$12.L$4;
                        Iterable iterable = (Iterable) linkParseServiceImpl$parse$12.L$3;
                        List list3 = (List) linkParseServiceImpl$parse$12.L$2;
                        uniqueUrls = (List) linkParseServiceImpl$parse$12.L$1;
                        urlList2 = (List) linkParseServiceImpl$parse$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result3);
                            linkParseServiceImpl3 = linkParseServiceImpl;
                            $result2 = $result3;
                            $this$forEach$iv3 = iterable;
                            allResults4 = list3;
                        } catch (Throwable th2) {
                            th = th2;
                            linkParseServiceImpl3 = linkParseServiceImpl;
                            $this$forEach$iv2 = iterable;
                            allResults2 = list3;
                            Result.Companion companion = Result.Companion;
                            result = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            it3 = it2;
                            $this$forEach$iv = $this$forEach$iv2;
                            obj = $result4;
                            $result = $result3;
                            linkParseServiceImpl$parse$14 = linkParseServiceImpl$parse$12;
                            $continuation2 = $completion3;
                            urlList3 = urlList2;
                            allResults3 = allResults2;
                            JobKt.ensureActive(linkParseServiceImpl$parse$14.getContext());
                            if (Result.m2643isSuccessimpl(result)) {
                            }
                            it5 = Result.m2639exceptionOrNullimpl(result);
                            if (it5 != null) {
                            }
                        }
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            $result3 = $result2;
                            $this$forEach$iv2 = $this$forEach$iv3;
                            allResults2 = allResults4;
                            Result.Companion companion2 = Result.Companion;
                            result = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            it3 = it2;
                            $this$forEach$iv = $this$forEach$iv2;
                            obj = $result4;
                            $result = $result3;
                            linkParseServiceImpl$parse$14 = linkParseServiceImpl$parse$12;
                            $continuation2 = $completion3;
                            urlList3 = urlList2;
                            allResults3 = allResults2;
                            JobKt.ensureActive(linkParseServiceImpl$parse$14.getContext());
                            if (Result.m2643isSuccessimpl(result)) {
                            }
                            it5 = Result.m2639exceptionOrNullimpl(result);
                            if (it5 != null) {
                            }
                        }
                        result = Result.m2636constructorimpl((KSunflowerParseRsp) $result3);
                        linkParseServiceImpl$parse$14 = linkParseServiceImpl$parse$12;
                        $continuation2 = $completion3;
                        urlList3 = urlList2;
                        Object obj3 = $result4;
                        $result = $result2;
                        it3 = it2;
                        $this$forEach$iv = $this$forEach$iv3;
                        obj = obj3;
                        allResults3 = allResults4;
                        JobKt.ensureActive(linkParseServiceImpl$parse$14.getContext());
                        if (Result.m2643isSuccessimpl(result)) {
                            KSunflowerParseRsp response = (KSunflowerParseRsp) result;
                            Map $this$mapNotNull$iv = response.getParsedItems();
                            Collection destination$iv$iv2 = new ArrayList();
                            Collection destination$iv$iv3 = destination$iv$iv2;
                            for (Map.Entry element$iv$iv$iv : $this$mapNotNull$iv.entrySet()) {
                                String raw = (String) element$iv$iv$iv.getKey();
                                KSunflowerParsedItem item = (KSunflowerParsedItem) element$iv$iv$iv.getValue();
                                if (item == null) {
                                    urlList5 = urlList3;
                                    it6 = it3;
                                    $completion2 = $continuation2;
                                    linkParseServiceImpl$parse$16 = linkParseServiceImpl$parse$14;
                                    emoteParseResult = null;
                                } else {
                                    urlList5 = urlList3;
                                    KSunflowerParsedItem.KParsedType type = item.getType();
                                    it6 = it3;
                                    KSunflowerParsedItem.KLink content = item.getContent();
                                    $completion2 = $continuation2;
                                    if (Intrinsics.areEqual(type, KSunflowerParsedItem.KParsedType.WHITELIST_URL.INSTANCE) && (content instanceof KSunflowerParsedItem.KLink)) {
                                        String title = content.getValue().getTitle();
                                        int value = KLinkNodeType.URL.INSTANCE.getValue();
                                        String it7 = item.getLinkIcon();
                                        if (!(it7.length() > 0)) {
                                            it7 = null;
                                        }
                                        emoteParseResult = new WhitelistUrlParseResult(raw, raw, title, value, it7 == null ? OuroLinkKt.UNIVERSAL_LINK_DEFAULT_ICON : it7);
                                        linkParseServiceImpl$parse$16 = linkParseServiceImpl$parse$14;
                                    } else if (Intrinsics.areEqual(type, KSunflowerParsedItem.KParsedType.VIDEO.INSTANCE) && (content instanceof KSunflowerParsedItem.KVideo)) {
                                        String title2 = ((KSunflowerParsedItem.KVideo) content).getValue().getTitle();
                                        int value2 = item.getLinkType().getValue();
                                        String bizId = item.getBizId();
                                        String it8 = item.getLinkIcon();
                                        if (!(it8.length() > 0)) {
                                            it8 = null;
                                        }
                                        emoteParseResult = new VideoParseResult(raw, raw, title2, value2, bizId, it8 == null ? OuroLinkKt.UNIVERSAL_LINK_DEFAULT_ICON : it8);
                                        linkParseServiceImpl$parse$16 = linkParseServiceImpl$parse$14;
                                    } else if (Intrinsics.areEqual(type, KSunflowerParsedItem.KParsedType.OPUS.INSTANCE) && (content instanceof KSunflowerParsedItem.KOpus)) {
                                        String linkShowText = ((KSunflowerParsedItem.KOpus) content).getValue().getLinkShowText();
                                        int value3 = item.getLinkType().getValue();
                                        String bizId2 = item.getBizId();
                                        String it9 = item.getLinkIcon();
                                        if (!(it9.length() > 0)) {
                                            it9 = null;
                                        }
                                        emoteParseResult = new OpusParseResult(raw, raw, linkShowText, value3, bizId2, it9 == null ? OuroLinkKt.UNIVERSAL_LINK_DEFAULT_ICON : it9);
                                        linkParseServiceImpl$parse$16 = linkParseServiceImpl$parse$14;
                                    } else if (Intrinsics.areEqual(type, KSunflowerParsedItem.KParsedType.EMOTE.INSTANCE) && (content instanceof KSunflowerParsedItem.KEmote)) {
                                        linkParseServiceImpl$parse$16 = linkParseServiceImpl$parse$14;
                                        emoteParseResult = new EmoteParseResult(raw, ((KSunflowerParsedItem.KEmote) content).getValue().getEmoteUrl(), ((KSunflowerParsedItem.KEmote) content).getValue().getEmoteSize());
                                    } else {
                                        linkParseServiceImpl$parse$16 = linkParseServiceImpl$parse$14;
                                        if (type instanceof KSunflowerParsedItem.KParsedType.UNRECOGNIZED) {
                                            int value4 = item.getLinkType().getValue();
                                            String bizId3 = item.getBizId();
                                            String it10 = item.getLinkIcon();
                                            if (!(it10.length() > 0)) {
                                                it10 = null;
                                            }
                                            emoteParseResult = new UnrecognizedUrlResult(raw, raw, raw, value4, bizId3, it10 == null ? OuroLinkKt.UNIVERSAL_LINK_DEFAULT_ICON : it10);
                                        } else {
                                            emoteParseResult = null;
                                        }
                                    }
                                }
                                if (emoteParseResult != null) {
                                    RemoteParseResult remoteParseResult = emoteParseResult;
                                    destination$iv$iv = destination$iv$iv3;
                                    destination$iv$iv.add(remoteParseResult);
                                } else {
                                    destination$iv$iv = destination$iv$iv3;
                                }
                                urlList3 = urlList5;
                                destination$iv$iv3 = destination$iv$iv;
                                it3 = it6;
                                $continuation2 = $completion2;
                                linkParseServiceImpl$parse$14 = linkParseServiceImpl$parse$16;
                            }
                            urlList4 = urlList3;
                            it4 = it3;
                            $completion = $continuation2;
                            linkParseServiceImpl$parse$15 = linkParseServiceImpl$parse$14;
                            List links = (List) destination$iv$iv3;
                            allResults3.addAll(links);
                        } else {
                            urlList4 = urlList3;
                            it4 = it3;
                            $completion = $continuation2;
                            linkParseServiceImpl$parse$15 = linkParseServiceImpl$parse$14;
                        }
                        it5 = Result.m2639exceptionOrNullimpl(result);
                        if (it5 != null) {
                            Result.Companion companion3 = Result.Companion;
                            return Result.m2636constructorimpl(ResultKt.createFailure(it5));
                        }
                        urlList = urlList4;
                        linkParseServiceImpl2 = linkParseServiceImpl3;
                        it = it4;
                        $continuation = $completion;
                        linkParseServiceImpl$parse$13 = linkParseServiceImpl$parse$15;
                        allResults = allResults3;
                        break;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it.hasNext()) {
                    Result.Companion companion4 = Result.Companion;
                    return Result.m2636constructorimpl(allResults);
                }
                Object element$iv = it.next();
                List batch = (List) element$iv;
                Continuation $completion4 = $continuation;
                KSunflowerParseReq req = new KSunflowerParseReq(batch, false, 2, (DefaultConstructorMarker) null);
                LinkParseServiceImpl$parse$1 linkParseServiceImpl$parse$18 = linkParseServiceImpl$parse$13;
                try {
                } catch (Throwable th4) {
                    th = th4;
                    Object obj4 = $result;
                    linkParseServiceImpl3 = linkParseServiceImpl2;
                    urlList2 = urlList;
                    $result4 = obj;
                    $this$forEach$iv2 = $this$forEach$iv;
                    it2 = it;
                    $completion3 = $completion4;
                    linkParseServiceImpl$parse$12 = linkParseServiceImpl$parse$13;
                    $result3 = obj4;
                    allResults2 = allResults;
                }
                Result.Companion companion5 = Result.Companion;
                Object $result5 = $result;
                Object obj5 = obj;
                linkParseServiceImpl3 = linkParseServiceImpl2;
                KOpusMoss kOpusMoss = new KOpusMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                linkParseServiceImpl$parse$13.L$0 = SpillingKt.nullOutSpilledVariable(urlList);
                linkParseServiceImpl$parse$13.L$1 = SpillingKt.nullOutSpilledVariable(uniqueUrls);
                linkParseServiceImpl$parse$13.L$2 = allResults;
                linkParseServiceImpl$parse$13.L$3 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
                linkParseServiceImpl$parse$13.L$4 = it;
                linkParseServiceImpl$parse$13.L$5 = SpillingKt.nullOutSpilledVariable(element$iv);
                linkParseServiceImpl$parse$13.L$6 = SpillingKt.nullOutSpilledVariable(batch);
                linkParseServiceImpl$parse$13.L$7 = SpillingKt.nullOutSpilledVariable(req);
                linkParseServiceImpl$parse$13.L$8 = SpillingKt.nullOutSpilledVariable(linkParseServiceImpl$parse$18);
                linkParseServiceImpl$parse$13.I$0 = $i$f$forEach;
                linkParseServiceImpl$parse$13.I$1 = 0;
                linkParseServiceImpl$parse$13.I$2 = 0;
                linkParseServiceImpl$parse$13.I$3 = 0;
                linkParseServiceImpl$parse$13.label = 1;
                Object sunflowerParse = kOpusMoss.sunflowerParse(req, linkParseServiceImpl$parse$13);
                if (sunflowerParse == obj5) {
                    return obj5;
                }
                urlList2 = urlList;
                $completion3 = $completion4;
                linkParseServiceImpl$parse$12 = linkParseServiceImpl$parse$13;
                $result3 = sunflowerParse;
                $result4 = obj5;
                $this$forEach$iv3 = $this$forEach$iv;
                it2 = it;
                $result2 = $result5;
                allResults4 = allResults;
                result = Result.m2636constructorimpl((KSunflowerParseRsp) $result3);
                linkParseServiceImpl$parse$14 = linkParseServiceImpl$parse$12;
                $continuation2 = $completion3;
                urlList3 = urlList2;
                Object obj32 = $result4;
                $result = $result2;
                it3 = it2;
                $this$forEach$iv = $this$forEach$iv3;
                obj = obj32;
                allResults3 = allResults4;
                JobKt.ensureActive(linkParseServiceImpl$parse$14.getContext());
                if (Result.m2643isSuccessimpl(result)) {
                }
                it5 = Result.m2639exceptionOrNullimpl(result);
                if (it5 != null) {
                }
            }
        }
        linkParseServiceImpl = this;
        linkParseServiceImpl$parse$1 = new LinkParseServiceImpl$parse$1(linkParseServiceImpl, $completion3);
        linkParseServiceImpl$parse$12 = linkParseServiceImpl$parse$1;
        Object $result32 = linkParseServiceImpl$parse$12.result;
        Object $result42 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (linkParseServiceImpl$parse$12.label) {
        }
        if (it.hasNext()) {
        }
    }
}