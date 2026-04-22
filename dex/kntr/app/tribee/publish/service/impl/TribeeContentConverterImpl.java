package kntr.app.tribee.publish.service.impl;

import bili.resource.following.FollowingRes;
import bili.resource.following.String0_commonMainKt;
import com.bapis.bilibili.dynamic.common.KArticle;
import com.bapis.bilibili.dynamic.common.KBgStyle;
import com.bapis.bilibili.dynamic.common.KCardParagraph;
import com.bapis.bilibili.dynamic.common.KCodeParagraph;
import com.bapis.bilibili.dynamic.common.KEmoteNode;
import com.bapis.bilibili.dynamic.common.KFormulaNode;
import com.bapis.bilibili.dynamic.common.KLineParagraph;
import com.bapis.bilibili.dynamic.common.KLinkNode;
import com.bapis.bilibili.dynamic.common.KOpus;
import com.bapis.bilibili.dynamic.common.KOpusAttachments;
import com.bapis.bilibili.dynamic.common.KOpusContent;
import com.bapis.bilibili.dynamic.common.KOpusSource;
import com.bapis.bilibili.dynamic.common.KParagraph;
import com.bapis.bilibili.dynamic.common.KPic;
import com.bapis.bilibili.dynamic.common.KPicParagraph;
import com.bapis.bilibili.dynamic.common.KPubInfo;
import com.bapis.bilibili.dynamic.common.KTextNode;
import com.bapis.bilibili.dynamic.common.KTextParagraph;
import com.bapis.bilibili.dynamic.common.KTranslateResult;
import com.bapis.bilibili.dynamic.common.KTribee;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.common.KUpPermission;
import com.bapis.bilibili.dynamic.common.KUpPermissionItem;
import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import com.bapis.bilibili.dynamic.common.KVersion;
import com.bapis.bilibili.dynamic.common.KWordNode;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.inject.Singleton;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeePublishContent;
import kntr.app.tribee.publish.TribeePublishSettingItem;
import kntr.app.tribee.publish.service.TribeeContentConverter;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.paragraph.assetuploader.ImageUploadResult;
import kntr.common.paragraph.assetuploader.base.AssetUploadState;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kntr.common.paragraph.assetuploader.base.UrlAssetUploadState;
import kntr.common.paragraph.input.RichTextContent;
import kntr.common.paragraph.input.content.AssetContent;
import kntr.common.paragraph.input.content.ParagraphContent;
import kntr.common.paragraph.input.content.TextContent;
import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.ContentSizeKt;
import kntr.common.photonic.gallery.Gallery;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: TribeeContentConverterImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJd\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00122\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096@¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u0004\u0018\u00010!*\u00020\"H\u0082@¢\u0006\u0002\u0010#J\u0016\u0010 \u001a\u0004\u0018\u00010\"*\u00020!2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010$\u001a\u0004\u0018\u00010\"*\u00020%2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010$\u001a\u0004\u0018\u00010\"*\u00020&2\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006("}, d2 = {"Lkntr/app/tribee/publish/service/impl/TribeeContentConverterImpl;", "Lkntr/app/tribee/publish/service/TribeeContentConverter;", "<init>", "()V", "convert", "Lcom/bapis/bilibili/dynamic/common/KOpus;", "content", "Lkntr/app/tribee/publish/TribeePublishContent;", "toDraft", "", "(Lkntr/app/tribee/publish/TribeePublishContent;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "opus", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "limitInfo", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "sendToFollowing", "categories", "", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "selectedCategory", "settingItems", "Lkntr/app/tribee/publish/TribeePublishSettingItem;", "fromDraft", "fromEdit", "(Lcom/bapis/bilibili/dynamic/common/KOpus;Lkntr/app/tribee/publish/TribeeInfo;Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;ZLjava/util/List;Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSettingItems", "permission", "Lcom/bapis/bilibili/dynamic/common/KUpPermission;", "attachments", "Lcom/bapis/bilibili/dynamic/common/KOpusAttachments;", "(Lcom/bapis/bilibili/dynamic/common/KUpPermission;Lcom/bapis/bilibili/dynamic/common/KOpusAttachments;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toContent", "Lkntr/common/paragraph/input/content/ParagraphContent;", "Lcom/bapis/bilibili/dynamic/common/KParagraph;", "(Lcom/bapis/bilibili/dynamic/common/KParagraph;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toPublishContent", "Lkntr/common/paragraph/input/content/AssetContent;", "Lkntr/common/paragraph/input/content/TextContent;", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeContentConverterImpl implements TribeeContentConverter {
    public static final Companion Companion = new Companion(null);
    public static final String DRAFT_ORIGIN_PREFIX = "draft-origin-";
    public static final String DRAFT_PREFIX = "draft-";

    /* compiled from: TribeeContentConverterImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkntr/app/tribee/publish/service/impl/TribeeContentConverterImpl$Companion;", "", "<init>", "()V", "DRAFT_PREFIX", "", "DRAFT_ORIGIN_PREFIX", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kntr.app.tribee.publish.service.TribeeContentConverter
    public Object convert(TribeePublishContent content, boolean toDraft, Continuation<? super KOpus> continuation) {
        Iterable emptyList;
        ArrayList arrayList;
        ParagraphContent it;
        KOpusAttachments kOpusAttachments = new KOpusAttachments(new KTribee(content.getTribeeInfo().getTribeeId(), false, 2, (DefaultConstructorMarker) null), toDraft ? content.getAigc() : 0);
        String title = content.getTitle();
        KOpusSource kOpusSource = KOpusSource.MIXED_CONTENT.INSTANCE;
        if (toDraft) {
            Iterable $this$mapNotNull$iv = content.getContent().getContentList();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                KParagraph content2 = toContent((ParagraphContent) element$iv$iv$iv, toDraft);
                if (content2 != null) {
                    destination$iv$iv.add(content2);
                }
            }
            arrayList = (List) destination$iv$iv;
        } else {
            List $this$dropLastWhile$iv = content.getContent().splitToPublish();
            if (!$this$dropLastWhile$iv.isEmpty()) {
                ListIterator iterator$iv = $this$dropLastWhile$iv.listIterator($this$dropLastWhile$iv.size());
                while (iterator$iv.hasPrevious()) {
                    ParagraphContent it2 = iterator$iv.previous();
                    if ((it2 instanceof TextContent) && Intrinsics.areEqual(((TextContent) it2).getContent(), "\n")) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it == null) {
                        emptyList = CollectionsKt.take($this$dropLastWhile$iv, iterator$iv.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList = CollectionsKt.emptyList();
            Iterable $this$mapNotNull$iv2 = emptyList;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                KParagraph content3 = toContent((ParagraphContent) element$iv$iv$iv2, toDraft);
                if (content3 != null) {
                    destination$iv$iv2.add(content3);
                }
            }
            arrayList = (List) destination$iv$iv2;
        }
        return new KOpus(0L, kOpusSource, title, 0L, (String) null, new KOpusContent(arrayList), (List) null, (KPubInfo) null, (KArticle) null, (KVersion) null, 0L, kOpusAttachments, (KTranslateResult) null, (String) null, 14297, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0194 -> B:24:0x01bb). Please submit an issue!!! */
    @Override // kntr.app.tribee.publish.service.TribeeContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object convert(KOpus opus, TribeeInfo tribeeInfo, KTribeePublishConfig limitInfo, boolean sendToFollowing, List<KTribeeCategory> list, KTribeeCategory selectedCategory, List<? extends TribeePublishSettingItem> list2, boolean fromDraft, boolean fromEdit, Continuation<? super TribeePublishContent> continuation) {
        Continuation $continuation;
        TribeeContentConverterImpl tribeeContentConverterImpl;
        TribeeContentConverterImpl tribeeContentConverterImpl2;
        TribeeInfo tribeeInfo2;
        boolean sendToFollowing2;
        List list3;
        KTribeeCategory selectedCategory2;
        List list4;
        boolean fromDraft2;
        String str;
        Object $result;
        KTribeePublishConfig limitInfo2;
        boolean fromEdit2;
        Iterable paragraphs;
        Iterator it;
        TribeeContentConverterImpl tribeeContentConverterImpl3;
        Object element$iv$iv$iv;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv;
        Iterable $this$mapNotNullTo$iv$iv;
        int $i$f$mapNotNullTo;
        int $i$f$forEach;
        boolean fromEdit3;
        String str2;
        Object $this$forEach$iv$iv$iv;
        KOpus opus2;
        Continuation<? super TribeePublishContent> continuation2;
        Continuation $continuation2;
        TribeeInfo tribeeInfo3;
        String str3;
        List list5;
        boolean fromEdit4;
        TribeeInfo tribeeInfo4;
        TribeeInfo tribeeInfo5;
        TribeeContentConverterImpl tribeeContentConverterImpl4;
        int $i$f$forEach2;
        int $i$f$mapNotNullTo2;
        int $i$f$mapNotNull2;
        Object obj;
        Iterable $this$mapNotNull$iv2;
        Collection destination$iv$iv2;
        Iterable $this$mapNotNull$iv3;
        Object $result2;
        Continuation $continuation3;
        Object element$iv$iv;
        Iterator it2;
        boolean fromEdit5;
        boolean sendToFollowing3;
        List settingItems;
        boolean fromDraft3;
        KTribeePublishConfig limitInfo3;
        KTribeeCategory selectedCategory3;
        List categories;
        KOpus opus3;
        ParagraphContent paragraphContent;
        if (continuation instanceof TribeeContentConverterImpl$convert$5) {
            $continuation = (TribeeContentConverterImpl$convert$5) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                tribeeContentConverterImpl = this;
                Object $result3 = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result3);
                        String title = opus.getTitle();
                        KOpusContent content = opus.getContent();
                        if (content != null && (paragraphs = content.getParagraphs()) != null) {
                            Iterable $this$mapNotNull$iv4 = paragraphs;
                            Collection destination$iv$iv3 = new ArrayList();
                            it = $this$mapNotNull$iv4.iterator();
                            tribeeContentConverterImpl3 = tribeeContentConverterImpl;
                            $result = $result3;
                            element$iv$iv$iv = coroutine_suspended;
                            $this$mapNotNull$iv = $this$mapNotNull$iv4;
                            $i$f$mapNotNull = 0;
                            destination$iv$iv = destination$iv$iv3;
                            $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv4;
                            $i$f$mapNotNullTo = 0;
                            $i$f$forEach = 0;
                            limitInfo2 = limitInfo;
                            sendToFollowing2 = sendToFollowing;
                            list3 = list;
                            selectedCategory2 = selectedCategory;
                            list4 = list2;
                            fromDraft2 = fromDraft;
                            fromEdit3 = fromEdit;
                            str2 = title;
                            $this$forEach$iv$iv$iv = $this$mapNotNull$iv4;
                            opus2 = opus;
                            continuation2 = continuation;
                            $continuation2 = $continuation;
                            tribeeInfo3 = tribeeInfo;
                            break;
                        } else {
                            tribeeContentConverterImpl2 = this;
                            tribeeInfo2 = tribeeInfo;
                            sendToFollowing2 = sendToFollowing;
                            list3 = list;
                            selectedCategory2 = selectedCategory;
                            list4 = list2;
                            fromDraft2 = fromDraft;
                            str = title;
                            $result = $result3;
                            limitInfo2 = limitInfo;
                            fromEdit2 = fromEdit;
                            list5 = CollectionsKt.emptyList();
                            str3 = str;
                            fromEdit4 = fromEdit2;
                            tribeeInfo4 = tribeeInfo2;
                            return new TribeePublishContent(str3, new RichTextContent(list5, 0, false, null, 14, null).mergeContinuousTextContent(), tribeeInfo4, limitInfo2, list3, selectedCategory2, false, list4, sendToFollowing2, fromDraft2, fromEdit4, false, null, 6208, null);
                        }
                    case 1:
                        int i = $continuation.I$4;
                        int i2 = $continuation.I$3;
                        int $i$f$forEach3 = $continuation.I$2;
                        int $i$f$mapNotNullTo3 = $continuation.I$1;
                        int $i$f$mapNotNull3 = $continuation.I$0;
                        fromEdit5 = $continuation.Z$2;
                        fromDraft3 = $continuation.Z$1;
                        sendToFollowing3 = $continuation.Z$0;
                        KParagraph kParagraph = (KParagraph) $continuation.L$14;
                        Object obj2 = $continuation.L$13;
                        Object obj3 = $continuation.L$12;
                        Iterator it3 = (Iterator) $continuation.L$11;
                        Object $this$forEach$iv$iv$iv2 = (Iterable) $continuation.L$10;
                        Collection destination$iv$iv4 = (Collection) $continuation.L$9;
                        Iterable $this$mapNotNullTo$iv$iv2 = (Iterable) $continuation.L$8;
                        Iterable $this$mapNotNull$iv5 = (Iterable) $continuation.L$7;
                        String str4 = (String) $continuation.L$6;
                        List settingItems2 = (List) $continuation.L$5;
                        KTribeeCategory selectedCategory4 = (KTribeeCategory) $continuation.L$4;
                        List categories2 = (List) $continuation.L$3;
                        KTribeePublishConfig limitInfo4 = (KTribeePublishConfig) $continuation.L$2;
                        TribeeInfo tribeeInfo6 = (TribeeInfo) $continuation.L$1;
                        ResultKt.throwOnFailure($result3);
                        tribeeInfo5 = tribeeInfo6;
                        continuation2 = continuation;
                        tribeeContentConverterImpl4 = tribeeContentConverterImpl;
                        $result2 = $result3;
                        obj = coroutine_suspended;
                        $i$f$forEach2 = $i$f$forEach3;
                        $i$f$mapNotNullTo2 = $i$f$mapNotNullTo3;
                        $i$f$mapNotNull2 = $i$f$mapNotNull3;
                        $this$mapNotNull$iv3 = $this$mapNotNull$iv5;
                        str2 = str4;
                        limitInfo3 = limitInfo4;
                        it2 = it3;
                        selectedCategory3 = selectedCategory4;
                        settingItems = settingItems2;
                        $this$mapNotNull$iv2 = $this$mapNotNullTo$iv$iv2;
                        categories = categories2;
                        element$iv$iv = $this$forEach$iv$iv$iv2;
                        $continuation3 = $continuation;
                        opus3 = (KOpus) $continuation.L$0;
                        destination$iv$iv2 = destination$iv$iv4;
                        paragraphContent = (ParagraphContent) $result3;
                        if (paragraphContent != null) {
                            destination$iv$iv2.add(paragraphContent);
                        }
                        limitInfo2 = limitInfo3;
                        list3 = categories;
                        selectedCategory2 = selectedCategory3;
                        list4 = settingItems;
                        fromEdit3 = fromEdit5;
                        fromDraft2 = fromDraft3;
                        sendToFollowing2 = sendToFollowing3;
                        $continuation2 = $continuation3;
                        $this$forEach$iv$iv$iv = element$iv$iv;
                        it = it2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
                        $this$mapNotNull$iv = $this$mapNotNull$iv3;
                        $result = $result2;
                        element$iv$iv$iv = obj;
                        $i$f$forEach = $i$f$forEach2;
                        $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        destination$iv$iv = destination$iv$iv2;
                        opus2 = opus3;
                        tribeeInfo3 = tribeeInfo5;
                        tribeeContentConverterImpl3 = tribeeContentConverterImpl4;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (it.hasNext()) {
                    Object element$iv$iv$iv2 = it.next();
                    boolean fromEdit6 = fromEdit3;
                    KParagraph it4 = (KParagraph) element$iv$iv$iv2;
                    boolean fromDraft4 = fromDraft2;
                    $continuation2.L$0 = SpillingKt.nullOutSpilledVariable(opus2);
                    $continuation2.L$1 = tribeeInfo3;
                    $continuation2.L$2 = limitInfo2;
                    $continuation2.L$3 = list3;
                    $continuation2.L$4 = selectedCategory2;
                    $continuation2.L$5 = list4;
                    $continuation2.L$6 = str2;
                    $continuation2.L$7 = SpillingKt.nullOutSpilledVariable($this$mapNotNull$iv);
                    $continuation2.L$8 = SpillingKt.nullOutSpilledVariable($this$mapNotNullTo$iv$iv);
                    $continuation2.L$9 = destination$iv$iv;
                    $continuation2.L$10 = SpillingKt.nullOutSpilledVariable($this$forEach$iv$iv$iv);
                    $continuation2.L$11 = it;
                    $continuation2.L$12 = SpillingKt.nullOutSpilledVariable(element$iv$iv$iv2);
                    $continuation2.L$13 = SpillingKt.nullOutSpilledVariable(element$iv$iv$iv2);
                    $continuation2.L$14 = SpillingKt.nullOutSpilledVariable(it4);
                    $continuation2.Z$0 = sendToFollowing2;
                    $continuation2.Z$1 = fromDraft4;
                    KOpus opus4 = opus2;
                    $continuation2.Z$2 = fromEdit6;
                    $continuation2.I$0 = $i$f$mapNotNull;
                    int $i$f$mapNotNull4 = $i$f$mapNotNullTo;
                    $continuation2.I$1 = $i$f$mapNotNull4;
                    int $i$f$mapNotNullTo4 = $i$f$forEach;
                    $continuation2.I$2 = $i$f$mapNotNullTo4;
                    $continuation2.I$3 = 0;
                    $continuation2.I$4 = 0;
                    $continuation2.label = 1;
                    TribeeContentConverterImpl tribeeContentConverterImpl5 = tribeeContentConverterImpl3;
                    tribeeInfo5 = tribeeInfo3;
                    Object content2 = tribeeContentConverterImpl5.toContent(it4, $continuation2);
                    Object obj4 = element$iv$iv$iv;
                    if (content2 == obj4) {
                        return obj4;
                    }
                    tribeeContentConverterImpl4 = tribeeContentConverterImpl5;
                    $i$f$forEach2 = $i$f$forEach;
                    $i$f$mapNotNullTo2 = $i$f$mapNotNullTo;
                    $i$f$mapNotNull2 = $i$f$mapNotNull;
                    obj = obj4;
                    $this$mapNotNull$iv2 = $this$mapNotNullTo$iv$iv;
                    destination$iv$iv2 = destination$iv$iv;
                    $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                    $result2 = $result;
                    $continuation3 = $continuation2;
                    element$iv$iv = $this$forEach$iv$iv$iv;
                    it2 = it;
                    fromEdit5 = fromEdit6;
                    sendToFollowing3 = sendToFollowing2;
                    settingItems = list4;
                    fromDraft3 = fromDraft4;
                    limitInfo3 = limitInfo2;
                    selectedCategory3 = selectedCategory2;
                    $result3 = content2;
                    categories = list3;
                    opus3 = opus4;
                    paragraphContent = (ParagraphContent) $result3;
                    if (paragraphContent != null) {
                    }
                    limitInfo2 = limitInfo3;
                    list3 = categories;
                    selectedCategory2 = selectedCategory3;
                    list4 = settingItems;
                    fromEdit3 = fromEdit5;
                    fromDraft2 = fromDraft3;
                    sendToFollowing2 = sendToFollowing3;
                    $continuation2 = $continuation3;
                    $this$forEach$iv$iv$iv = element$iv$iv;
                    it = it2;
                    $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv3;
                    $result = $result2;
                    element$iv$iv$iv = obj;
                    $i$f$forEach = $i$f$forEach2;
                    $i$f$mapNotNullTo = $i$f$mapNotNullTo2;
                    $i$f$mapNotNull = $i$f$mapNotNull2;
                    destination$iv$iv = destination$iv$iv2;
                    opus2 = opus3;
                    tribeeInfo3 = tribeeInfo5;
                    tribeeContentConverterImpl3 = tribeeContentConverterImpl4;
                    if (it.hasNext()) {
                        boolean fromEdit7 = fromEdit3;
                        TribeeContentConverterImpl tribeeContentConverterImpl6 = tribeeContentConverterImpl3;
                        tribeeInfo2 = tribeeInfo3;
                        ArrayList arrayList = (List) destination$iv$iv;
                        if (arrayList != null) {
                            fromEdit4 = fromEdit7;
                            list5 = arrayList;
                            str3 = str2;
                            tribeeInfo4 = tribeeInfo2;
                            return new TribeePublishContent(str3, new RichTextContent(list5, 0, false, null, 14, null).mergeContinuousTextContent(), tribeeInfo4, limitInfo2, list3, selectedCategory2, false, list4, sendToFollowing2, fromDraft2, fromEdit4, false, null, 6208, null);
                        }
                        fromEdit2 = fromEdit7;
                        tribeeContentConverterImpl2 = tribeeContentConverterImpl6;
                        str = str2;
                        list5 = CollectionsKt.emptyList();
                        str3 = str;
                        fromEdit4 = fromEdit2;
                        tribeeInfo4 = tribeeInfo2;
                        return new TribeePublishContent(str3, new RichTextContent(list5, 0, false, null, 14, null).mergeContinuousTextContent(), tribeeInfo4, limitInfo2, list3, selectedCategory2, false, list4, sendToFollowing2, fromDraft2, fromEdit4, false, null, 6208, null);
                    }
                }
            }
        }
        tribeeContentConverterImpl = this;
        $continuation = new TribeeContentConverterImpl$convert$5(tribeeContentConverterImpl, continuation);
        Object $result32 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
        if (it.hasNext()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0341  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0134 -> B:55:0x0330). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0261 -> B:40:0x0275). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x028e -> B:42:0x02ab). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x02fb -> B:54:0x031e). Please submit an issue!!! */
    @Override // kntr.app.tribee.publish.service.TribeeContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getSettingItems(KUpPermission permission, KOpusAttachments attachments, Continuation<? super List<? extends TribeePublishSettingItem>> continuation) {
        TribeeContentConverterImpl$getSettingItems$1 tribeeContentConverterImpl$getSettingItems$1;
        TribeeContentConverterImpl tribeeContentConverterImpl;
        KOpusAttachments attachments2;
        Continuation $completion;
        Iterable items;
        Iterable $this$mapNotNullTo$iv$iv;
        int $i$f$mapNotNullTo;
        TribeeContentConverterImpl tribeeContentConverterImpl2;
        Collection destination$iv$iv;
        Object element$iv$iv;
        Iterator it;
        Object $result;
        int $i$f$mapNotNullTo2;
        int $i$f$mapNotNullTo3;
        Continuation $result2;
        TribeeContentConverterImpl$getSettingItems$1 tribeeContentConverterImpl$getSettingItems$12;
        Object obj;
        KOpusAttachments attachments3;
        Iterable $this$mapNotNull$iv;
        KUpPermission permission2;
        int $i$f$mapNotNullTo4;
        int $i$f$mapNotNullTo5;
        Iterable $this$mapNotNullTo$iv$iv2;
        Iterable $this$mapNotNullTo$iv$iv3;
        KUpPermission permission3;
        Object $this$forEach$iv$iv$iv;
        Collection destination$iv$iv2;
        Continuation $completion2;
        Object element$iv$iv$iv;
        Iterator it2;
        TribeeContentConverterImpl tribeeContentConverterImpl3;
        Object $result3;
        Object element$iv$iv2;
        KUpPermissionItem item;
        int $i$f$forEach;
        int i;
        Object element$iv$iv$iv2;
        Object element$iv$iv$iv3;
        KUpPermissionItem item2;
        TribeeContentConverterImpl element$iv$iv3;
        int $i$f$forEach2;
        int $i$f$mapNotNullTo6;
        String str;
        int i2;
        Iterator it3;
        Object $result4;
        int i3;
        String subtitle;
        KUpPermissionItem item3;
        Object element$iv$iv4;
        KUpPermission permission4;
        Object element$iv$iv$iv4;
        String str2;
        Iterator it4;
        String str3;
        Object $result5;
        Object obj2;
        Continuation $completion3;
        int $i$f$mapNotNullTo7;
        int $i$f$mapNotNullTo8;
        int $i$f$mapNotNull;
        Object element$iv$iv5;
        Object element$iv$iv$iv5;
        TribeeContentConverterImpl element$iv$iv6;
        int $i$f$mapNotNull2;
        KUpPermissionItem item4;
        String str4;
        int $i$f$forEach3;
        int i4;
        Object $result6;
        Iterator it5;
        Continuation $completion4;
        Object obj3;
        KOpusAttachments attachments4;
        TribeePublishSettingItem.Switch r12;
        Object $this$forEach$iv$iv$iv2;
        TribeeContentConverterImpl tribeeContentConverterImpl4;
        Object obj4;
        Object element$iv$iv$iv6;
        Collection destination$iv$iv3;
        Iterator it6;
        int $i$f$mapNotNull3;
        int $i$f$mapNotNull4;
        int $i$f$forEach4;
        KUpPermission permission5;
        KOpusAttachments attachments5;
        boolean z;
        if (continuation instanceof TribeeContentConverterImpl$getSettingItems$1) {
            tribeeContentConverterImpl$getSettingItems$1 = (TribeeContentConverterImpl$getSettingItems$1) continuation;
            if ((tribeeContentConverterImpl$getSettingItems$1.label & Integer.MIN_VALUE) != 0) {
                tribeeContentConverterImpl$getSettingItems$1.label -= Integer.MIN_VALUE;
                tribeeContentConverterImpl = this;
                Object $result7 = tribeeContentConverterImpl$getSettingItems$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeContentConverterImpl$getSettingItems$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result7);
                        if (permission == null || (items = permission.getItems()) == null) {
                            attachments2 = attachments;
                            $completion = continuation;
                            return CollectionsKt.emptyList();
                        }
                        Iterable $this$mapNotNull$iv2 = items;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv2;
                        $i$f$mapNotNullTo = 0;
                        tribeeContentConverterImpl2 = tribeeContentConverterImpl;
                        destination$iv$iv = new ArrayList();
                        element$iv$iv = $this$mapNotNullTo$iv$iv;
                        it = $this$mapNotNullTo$iv$iv.iterator();
                        $result = $result7;
                        $i$f$mapNotNullTo2 = 0;
                        $i$f$mapNotNullTo3 = 0;
                        $result2 = continuation;
                        tribeeContentConverterImpl$getSettingItems$12 = tribeeContentConverterImpl$getSettingItems$1;
                        obj = coroutine_suspended;
                        attachments3 = attachments;
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        permission2 = permission;
                        if (it.hasNext()) {
                            Object element$iv$iv$iv7 = it.next();
                            i3 = 0;
                            Continuation $completion5 = $result2;
                            KUpPermissionItem item5 = (KUpPermissionItem) element$iv$iv$iv7;
                            Object $result8 = $result;
                            i = 0;
                            TribeeContentConverterImpl tribeeContentConverterImpl5 = tribeeContentConverterImpl2;
                            obj3 = obj;
                            if (item5.getPermission() != 1) {
                                $result2 = $completion5;
                                $result = $result8;
                                attachments4 = attachments3;
                                $this$forEach$iv$iv$iv2 = element$iv$iv;
                                r12 = null;
                                tribeeContentConverterImpl4 = tribeeContentConverterImpl5;
                                if (r12 != null) {
                                }
                                attachments3 = attachments4;
                                tribeeContentConverterImpl2 = tribeeContentConverterImpl4;
                                element$iv$iv = $this$forEach$iv$iv$iv2;
                                obj = obj3;
                                if (it.hasNext()) {
                                }
                            } else if (Intrinsics.areEqual(item5.getType(), KUpPermissionType.UP_PERMISSION_TYPE_AIGC_MARK.INSTANCE)) {
                                str = item5.getTitle();
                                if (StringsKt.isBlank(str)) {
                                    StringResource following_global_string_1112 = String0_commonMainKt.getFollowing_global_string_1112(FollowingRes.INSTANCE.getString());
                                    tribeeContentConverterImpl$getSettingItems$12.L$0 = SpillingKt.nullOutSpilledVariable(permission2);
                                    tribeeContentConverterImpl$getSettingItems$12.L$1 = attachments3;
                                    tribeeContentConverterImpl$getSettingItems$12.L$2 = SpillingKt.nullOutSpilledVariable($this$mapNotNull$iv);
                                    tribeeContentConverterImpl$getSettingItems$12.L$3 = SpillingKt.nullOutSpilledVariable($this$mapNotNullTo$iv$iv);
                                    tribeeContentConverterImpl$getSettingItems$12.L$4 = destination$iv$iv;
                                    tribeeContentConverterImpl$getSettingItems$12.L$5 = SpillingKt.nullOutSpilledVariable(element$iv$iv);
                                    tribeeContentConverterImpl$getSettingItems$12.L$6 = it;
                                    tribeeContentConverterImpl$getSettingItems$12.L$7 = SpillingKt.nullOutSpilledVariable(element$iv$iv$iv7);
                                    tribeeContentConverterImpl$getSettingItems$12.L$8 = SpillingKt.nullOutSpilledVariable(element$iv$iv$iv7);
                                    tribeeContentConverterImpl$getSettingItems$12.L$9 = item5;
                                    tribeeContentConverterImpl$getSettingItems$12.L$10 = null;
                                    tribeeContentConverterImpl$getSettingItems$12.I$0 = $i$f$mapNotNullTo2;
                                    tribeeContentConverterImpl$getSettingItems$12.I$1 = $i$f$mapNotNullTo3;
                                    tribeeContentConverterImpl$getSettingItems$12.I$2 = $i$f$mapNotNullTo;
                                    tribeeContentConverterImpl$getSettingItems$12.I$3 = 0;
                                    tribeeContentConverterImpl$getSettingItems$12.I$4 = 0;
                                    tribeeContentConverterImpl$getSettingItems$12.I$5 = 0;
                                    tribeeContentConverterImpl$getSettingItems$12.label = 1;
                                    Object string = StringResourcesKt.getString(following_global_string_1112, tribeeContentConverterImpl$getSettingItems$12);
                                    permission3 = permission2;
                                    if (string == obj3) {
                                        return obj3;
                                    }
                                    $this$mapNotNullTo$iv$iv3 = $this$mapNotNull$iv;
                                    $this$forEach$iv$iv$iv = element$iv$iv;
                                    destination$iv$iv2 = destination$iv$iv;
                                    element$iv$iv$iv = element$iv$iv$iv7;
                                    coroutine_suspended = obj3;
                                    $i$f$mapNotNullTo4 = $i$f$mapNotNullTo3;
                                    $i$f$mapNotNullTo5 = $i$f$mapNotNullTo2;
                                    it2 = it;
                                    $completion2 = $completion5;
                                    tribeeContentConverterImpl3 = tribeeContentConverterImpl5;
                                    item = item5;
                                    $result7 = string;
                                    element$iv$iv2 = element$iv$iv$iv7;
                                    $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                                    $i$f$forEach = 0;
                                    $result3 = $result8;
                                    element$iv$iv$iv3 = element$iv$iv2;
                                    element$iv$iv3 = tribeeContentConverterImpl3;
                                    item2 = item;
                                    $i$f$mapNotNullTo2 = $i$f$mapNotNullTo5;
                                    $i$f$mapNotNullTo6 = $i$f$mapNotNullTo;
                                    $i$f$forEach2 = $i$f$mapNotNullTo4;
                                    str = (String) $result7;
                                    $result4 = $result3;
                                    i3 = $i$f$forEach;
                                    i2 = i;
                                    it3 = it2;
                                    destination$iv$iv = destination$iv$iv2;
                                    Object obj5 = $this$forEach$iv$iv$iv;
                                    element$iv$iv$iv2 = element$iv$iv$iv;
                                    element$iv$iv = obj5;
                                    String str5 = str;
                                    subtitle = item2.getSubtitle();
                                    if (StringsKt.isBlank(subtitle)) {
                                        Continuation $completion6 = $completion2;
                                        Object $result9 = $result4;
                                        StringResource following_global_string_1113 = String0_commonMainKt.getFollowing_global_string_1113(FollowingRes.INSTANCE.getString());
                                        TribeeContentConverterImpl tribeeContentConverterImpl6 = element$iv$iv3;
                                        tribeeContentConverterImpl$getSettingItems$12.L$0 = SpillingKt.nullOutSpilledVariable(permission3);
                                        tribeeContentConverterImpl$getSettingItems$12.L$1 = attachments3;
                                        tribeeContentConverterImpl$getSettingItems$12.L$2 = SpillingKt.nullOutSpilledVariable($this$mapNotNullTo$iv$iv3);
                                        tribeeContentConverterImpl$getSettingItems$12.L$3 = SpillingKt.nullOutSpilledVariable($this$mapNotNullTo$iv$iv2);
                                        tribeeContentConverterImpl$getSettingItems$12.L$4 = destination$iv$iv;
                                        tribeeContentConverterImpl$getSettingItems$12.L$5 = SpillingKt.nullOutSpilledVariable(element$iv$iv);
                                        tribeeContentConverterImpl$getSettingItems$12.L$6 = it3;
                                        tribeeContentConverterImpl$getSettingItems$12.L$7 = SpillingKt.nullOutSpilledVariable(element$iv$iv$iv2);
                                        tribeeContentConverterImpl$getSettingItems$12.L$8 = SpillingKt.nullOutSpilledVariable(element$iv$iv$iv3);
                                        tribeeContentConverterImpl$getSettingItems$12.L$9 = item2;
                                        tribeeContentConverterImpl$getSettingItems$12.L$10 = str5;
                                        tribeeContentConverterImpl$getSettingItems$12.I$0 = $i$f$mapNotNullTo2;
                                        tribeeContentConverterImpl$getSettingItems$12.I$1 = $i$f$forEach2;
                                        tribeeContentConverterImpl$getSettingItems$12.I$2 = $i$f$mapNotNullTo6;
                                        tribeeContentConverterImpl$getSettingItems$12.I$3 = i3;
                                        tribeeContentConverterImpl$getSettingItems$12.I$4 = i2;
                                        tribeeContentConverterImpl$getSettingItems$12.I$5 = 0;
                                        tribeeContentConverterImpl$getSettingItems$12.label = 2;
                                        $result7 = StringResourcesKt.getString(following_global_string_1113, tribeeContentConverterImpl$getSettingItems$12);
                                        if ($result7 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        $i$f$mapNotNull = $i$f$mapNotNullTo2;
                                        element$iv$iv5 = element$iv$iv$iv3;
                                        element$iv$iv$iv5 = element$iv$iv$iv2;
                                        element$iv$iv6 = tribeeContentConverterImpl6;
                                        $i$f$mapNotNull2 = $i$f$forEach2;
                                        item4 = item2;
                                        str4 = str5;
                                        $i$f$mapNotNullTo7 = $i$f$mapNotNullTo6;
                                        $i$f$forEach3 = i3;
                                        i4 = i2;
                                        $result6 = $result9;
                                        it5 = it3;
                                        $completion4 = $completion6;
                                        element$iv$iv4 = element$iv$iv5;
                                        obj2 = coroutine_suspended;
                                        str3 = str4;
                                        $completion3 = $completion4;
                                        it4 = it5;
                                        permission4 = permission3;
                                        $result5 = $result6;
                                        str2 = (String) $result7;
                                        $i$f$mapNotNullTo8 = $i$f$mapNotNull2;
                                        $i$f$mapNotNullTo2 = $i$f$mapNotNull;
                                        element$iv$iv3 = element$iv$iv6;
                                        item3 = item4;
                                        element$iv$iv$iv4 = element$iv$iv$iv5;
                                        String str6 = str2;
                                        KUpPermissionType type = item3.getType();
                                        if (attachments3 != null) {
                                            KOpusAttachments it7 = attachments3;
                                            permission5 = permission4;
                                            attachments5 = attachments3;
                                            if (it7.isAigc() == 1) {
                                                z = true;
                                                $this$forEach$iv$iv$iv2 = element$iv$iv;
                                                element$iv$iv$iv6 = element$iv$iv$iv4;
                                                tribeeContentConverterImpl4 = element$iv$iv3;
                                                destination$iv$iv3 = destination$iv$iv;
                                                r12 = new TribeePublishSettingItem.Switch(type, str3, str6, z, false, false, 48, null);
                                                it6 = it4;
                                                permission2 = permission5;
                                                $i$f$mapNotNull3 = $i$f$mapNotNullTo2;
                                                $i$f$mapNotNull4 = $i$f$mapNotNullTo7;
                                                $i$f$forEach4 = $i$f$mapNotNullTo8;
                                                obj4 = obj2;
                                                attachments4 = attachments5;
                                                $result2 = $completion3;
                                                $result = $result5;
                                                $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                                                $this$mapNotNull$iv = $this$mapNotNullTo$iv$iv3;
                                                obj3 = obj4;
                                                $i$f$mapNotNullTo3 = $i$f$forEach4;
                                                $i$f$mapNotNullTo = $i$f$mapNotNull4;
                                                $i$f$mapNotNullTo2 = $i$f$mapNotNull3;
                                                it = it6;
                                                destination$iv$iv = destination$iv$iv3;
                                                if (r12 != null) {
                                                    destination$iv$iv.add(r12);
                                                }
                                                attachments3 = attachments4;
                                                tribeeContentConverterImpl2 = tribeeContentConverterImpl4;
                                                element$iv$iv = $this$forEach$iv$iv$iv2;
                                                obj = obj3;
                                                if (it.hasNext()) {
                                                    attachments2 = attachments3;
                                                    Continuation $completion7 = $result2;
                                                    Object $result10 = $result;
                                                    List items2 = (List) destination$iv$iv;
                                                    if (items2 == null) {
                                                        $completion = $completion7;
                                                        $result7 = $result10;
                                                        tribeeContentConverterImpl$getSettingItems$1 = tribeeContentConverterImpl$getSettingItems$12;
                                                        return CollectionsKt.emptyList();
                                                    }
                                                    return items2;
                                                }
                                            }
                                        } else {
                                            permission5 = permission4;
                                            attachments5 = attachments3;
                                        }
                                        z = false;
                                        $this$forEach$iv$iv$iv2 = element$iv$iv;
                                        element$iv$iv$iv6 = element$iv$iv$iv4;
                                        tribeeContentConverterImpl4 = element$iv$iv3;
                                        destination$iv$iv3 = destination$iv$iv;
                                        r12 = new TribeePublishSettingItem.Switch(type, str3, str6, z, false, false, 48, null);
                                        it6 = it4;
                                        permission2 = permission5;
                                        $i$f$mapNotNull3 = $i$f$mapNotNullTo2;
                                        $i$f$mapNotNull4 = $i$f$mapNotNullTo7;
                                        $i$f$forEach4 = $i$f$mapNotNullTo8;
                                        obj4 = obj2;
                                        attachments4 = attachments5;
                                        $result2 = $completion3;
                                        $result = $result5;
                                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                                        $this$mapNotNull$iv = $this$mapNotNullTo$iv$iv3;
                                        obj3 = obj4;
                                        $i$f$mapNotNullTo3 = $i$f$forEach4;
                                        $i$f$mapNotNullTo = $i$f$mapNotNull4;
                                        $i$f$mapNotNullTo2 = $i$f$mapNotNull3;
                                        it = it6;
                                        destination$iv$iv = destination$iv$iv3;
                                        if (r12 != null) {
                                        }
                                        attachments3 = attachments4;
                                        tribeeContentConverterImpl2 = tribeeContentConverterImpl4;
                                        element$iv$iv = $this$forEach$iv$iv$iv2;
                                        obj = obj3;
                                        if (it.hasNext()) {
                                        }
                                    } else {
                                        Continuation $completion8 = $completion2;
                                        Object $result11 = $result4;
                                        item3 = item2;
                                        element$iv$iv4 = element$iv$iv$iv3;
                                        permission4 = permission3;
                                        element$iv$iv$iv4 = element$iv$iv$iv2;
                                        str2 = subtitle;
                                        it4 = it3;
                                        str3 = str5;
                                        $result5 = $result11;
                                        obj2 = coroutine_suspended;
                                        $completion3 = $completion8;
                                        int i5 = $i$f$forEach2;
                                        $i$f$mapNotNullTo7 = $i$f$mapNotNullTo6;
                                        $i$f$mapNotNullTo8 = i5;
                                        String str62 = str2;
                                        KUpPermissionType type2 = item3.getType();
                                        if (attachments3 != null) {
                                        }
                                        z = false;
                                        $this$forEach$iv$iv$iv2 = element$iv$iv;
                                        element$iv$iv$iv6 = element$iv$iv$iv4;
                                        tribeeContentConverterImpl4 = element$iv$iv3;
                                        destination$iv$iv3 = destination$iv$iv;
                                        r12 = new TribeePublishSettingItem.Switch(type2, str3, str62, z, false, false, 48, null);
                                        it6 = it4;
                                        permission2 = permission5;
                                        $i$f$mapNotNull3 = $i$f$mapNotNullTo2;
                                        $i$f$mapNotNull4 = $i$f$mapNotNullTo7;
                                        $i$f$forEach4 = $i$f$mapNotNullTo8;
                                        obj4 = obj2;
                                        attachments4 = attachments5;
                                        $result2 = $completion3;
                                        $result = $result5;
                                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                                        $this$mapNotNull$iv = $this$mapNotNullTo$iv$iv3;
                                        obj3 = obj4;
                                        $i$f$mapNotNullTo3 = $i$f$forEach4;
                                        $i$f$mapNotNullTo = $i$f$mapNotNull4;
                                        $i$f$mapNotNullTo2 = $i$f$mapNotNull3;
                                        it = it6;
                                        destination$iv$iv = destination$iv$iv3;
                                        if (r12 != null) {
                                        }
                                        attachments3 = attachments4;
                                        tribeeContentConverterImpl2 = tribeeContentConverterImpl4;
                                        element$iv$iv = $this$forEach$iv$iv$iv2;
                                        obj = obj3;
                                        if (it.hasNext()) {
                                        }
                                    }
                                } else {
                                    permission3 = permission2;
                                    element$iv$iv3 = tribeeContentConverterImpl5;
                                    $this$mapNotNullTo$iv$iv3 = $this$mapNotNull$iv;
                                    element$iv$iv$iv2 = element$iv$iv$iv7;
                                    element$iv$iv$iv3 = element$iv$iv$iv7;
                                    coroutine_suspended = obj3;
                                    $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                                    $completion2 = $completion5;
                                    i2 = 0;
                                    it3 = it;
                                    item2 = item5;
                                    $result4 = $result8;
                                    int i6 = $i$f$mapNotNullTo;
                                    $i$f$forEach2 = $i$f$mapNotNullTo3;
                                    $i$f$mapNotNullTo6 = i6;
                                    String str52 = str;
                                    subtitle = item2.getSubtitle();
                                    if (StringsKt.isBlank(subtitle)) {
                                    }
                                }
                            } else {
                                attachments4 = attachments3;
                                r12 = null;
                                $this$mapNotNullTo$iv$iv3 = $this$mapNotNull$iv;
                                $this$forEach$iv$iv$iv2 = element$iv$iv;
                                element$iv$iv4 = element$iv$iv$iv7;
                                $completion3 = $completion5;
                                tribeeContentConverterImpl4 = tribeeContentConverterImpl5;
                                $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv;
                                $result5 = $result8;
                                int i7 = $i$f$mapNotNullTo3;
                                obj4 = obj3;
                                permission2 = permission2;
                                element$iv$iv$iv6 = element$iv$iv$iv7;
                                destination$iv$iv3 = destination$iv$iv;
                                it6 = it;
                                $i$f$mapNotNull3 = $i$f$mapNotNullTo2;
                                $i$f$mapNotNull4 = $i$f$mapNotNullTo;
                                $i$f$forEach4 = i7;
                                $result2 = $completion3;
                                $result = $result5;
                                $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                                $this$mapNotNull$iv = $this$mapNotNullTo$iv$iv3;
                                obj3 = obj4;
                                $i$f$mapNotNullTo3 = $i$f$forEach4;
                                $i$f$mapNotNullTo = $i$f$mapNotNull4;
                                $i$f$mapNotNullTo2 = $i$f$mapNotNull3;
                                it = it6;
                                destination$iv$iv = destination$iv$iv3;
                                if (r12 != null) {
                                }
                                attachments3 = attachments4;
                                tribeeContentConverterImpl2 = tribeeContentConverterImpl4;
                                element$iv$iv = $this$forEach$iv$iv$iv2;
                                obj = obj3;
                                if (it.hasNext()) {
                                }
                            }
                        }
                        break;
                    case 1:
                        int i8 = tribeeContentConverterImpl$getSettingItems$1.I$5;
                        int i9 = tribeeContentConverterImpl$getSettingItems$1.I$4;
                        int i10 = tribeeContentConverterImpl$getSettingItems$1.I$3;
                        int $i$f$forEach5 = tribeeContentConverterImpl$getSettingItems$1.I$2;
                        $i$f$mapNotNullTo4 = tribeeContentConverterImpl$getSettingItems$1.I$1;
                        $i$f$mapNotNullTo5 = tribeeContentConverterImpl$getSettingItems$1.I$0;
                        KUpPermissionItem item6 = (KUpPermissionItem) tribeeContentConverterImpl$getSettingItems$1.L$9;
                        Object element$iv$iv7 = tribeeContentConverterImpl$getSettingItems$1.L$8;
                        Object element$iv$iv$iv8 = tribeeContentConverterImpl$getSettingItems$1.L$7;
                        Object $this$forEach$iv$iv$iv3 = (Iterable) tribeeContentConverterImpl$getSettingItems$1.L$5;
                        Collection destination$iv$iv4 = (Collection) tribeeContentConverterImpl$getSettingItems$1.L$4;
                        $this$mapNotNullTo$iv$iv2 = (Iterable) tribeeContentConverterImpl$getSettingItems$1.L$3;
                        $this$mapNotNullTo$iv$iv3 = (Iterable) tribeeContentConverterImpl$getSettingItems$1.L$2;
                        KOpusAttachments attachments6 = (KOpusAttachments) tribeeContentConverterImpl$getSettingItems$1.L$1;
                        ResultKt.throwOnFailure($result7);
                        permission3 = (KUpPermission) tribeeContentConverterImpl$getSettingItems$1.L$0;
                        $this$forEach$iv$iv$iv = $this$forEach$iv$iv$iv3;
                        destination$iv$iv2 = destination$iv$iv4;
                        $completion2 = continuation;
                        element$iv$iv$iv = element$iv$iv$iv8;
                        it2 = (Iterator) tribeeContentConverterImpl$getSettingItems$1.L$6;
                        tribeeContentConverterImpl3 = tribeeContentConverterImpl;
                        $result3 = $result7;
                        element$iv$iv2 = element$iv$iv7;
                        item = item6;
                        $i$f$mapNotNullTo = $i$f$forEach5;
                        $i$f$forEach = i10;
                        i = i9;
                        tribeeContentConverterImpl$getSettingItems$12 = tribeeContentConverterImpl$getSettingItems$1;
                        attachments3 = attachments6;
                        element$iv$iv$iv3 = element$iv$iv2;
                        element$iv$iv3 = tribeeContentConverterImpl3;
                        item2 = item;
                        $i$f$mapNotNullTo2 = $i$f$mapNotNullTo5;
                        $i$f$mapNotNullTo6 = $i$f$mapNotNullTo;
                        $i$f$forEach2 = $i$f$mapNotNullTo4;
                        str = (String) $result7;
                        $result4 = $result3;
                        i3 = $i$f$forEach;
                        i2 = i;
                        it3 = it2;
                        destination$iv$iv = destination$iv$iv2;
                        Object obj52 = $this$forEach$iv$iv$iv;
                        element$iv$iv$iv2 = element$iv$iv$iv;
                        element$iv$iv = obj52;
                        String str522 = str;
                        subtitle = item2.getSubtitle();
                        if (StringsKt.isBlank(subtitle)) {
                        }
                        break;
                    case 2:
                        int i11 = tribeeContentConverterImpl$getSettingItems$1.I$5;
                        int i12 = tribeeContentConverterImpl$getSettingItems$1.I$4;
                        int i13 = tribeeContentConverterImpl$getSettingItems$1.I$3;
                        int $i$f$forEach6 = tribeeContentConverterImpl$getSettingItems$1.I$2;
                        int $i$f$mapNotNullTo9 = tribeeContentConverterImpl$getSettingItems$1.I$1;
                        int $i$f$mapNotNull5 = tribeeContentConverterImpl$getSettingItems$1.I$0;
                        KUpPermissionItem item7 = (KUpPermissionItem) tribeeContentConverterImpl$getSettingItems$1.L$9;
                        Object element$iv$iv8 = tribeeContentConverterImpl$getSettingItems$1.L$8;
                        Object element$iv$iv$iv9 = tribeeContentConverterImpl$getSettingItems$1.L$7;
                        Object $this$forEach$iv$iv$iv4 = (Iterable) tribeeContentConverterImpl$getSettingItems$1.L$5;
                        Collection destination$iv$iv5 = (Collection) tribeeContentConverterImpl$getSettingItems$1.L$4;
                        Iterable $this$mapNotNullTo$iv$iv4 = (Iterable) tribeeContentConverterImpl$getSettingItems$1.L$3;
                        Iterable $this$mapNotNull$iv3 = (Iterable) tribeeContentConverterImpl$getSettingItems$1.L$2;
                        KOpusAttachments attachments7 = (KOpusAttachments) tribeeContentConverterImpl$getSettingItems$1.L$1;
                        ResultKt.throwOnFailure($result7);
                        item4 = item7;
                        element$iv$iv5 = element$iv$iv8;
                        element$iv$iv$iv5 = element$iv$iv$iv9;
                        element$iv$iv = $this$forEach$iv$iv$iv4;
                        destination$iv$iv = destination$iv$iv5;
                        $this$mapNotNullTo$iv$iv2 = $this$mapNotNullTo$iv$iv4;
                        $this$mapNotNullTo$iv$iv3 = $this$mapNotNull$iv3;
                        permission3 = (KUpPermission) tribeeContentConverterImpl$getSettingItems$1.L$0;
                        element$iv$iv6 = tribeeContentConverterImpl;
                        $result6 = $result7;
                        str4 = (String) tribeeContentConverterImpl$getSettingItems$1.L$10;
                        $completion4 = continuation;
                        $i$f$mapNotNull = $i$f$mapNotNull5;
                        $i$f$mapNotNull2 = $i$f$mapNotNullTo9;
                        $i$f$mapNotNullTo7 = $i$f$forEach6;
                        $i$f$forEach3 = i13;
                        i4 = i12;
                        it5 = (Iterator) tribeeContentConverterImpl$getSettingItems$1.L$6;
                        tribeeContentConverterImpl$getSettingItems$12 = tribeeContentConverterImpl$getSettingItems$1;
                        attachments3 = attachments7;
                        element$iv$iv4 = element$iv$iv5;
                        obj2 = coroutine_suspended;
                        str3 = str4;
                        $completion3 = $completion4;
                        it4 = it5;
                        permission4 = permission3;
                        $result5 = $result6;
                        str2 = (String) $result7;
                        $i$f$mapNotNullTo8 = $i$f$mapNotNull2;
                        $i$f$mapNotNullTo2 = $i$f$mapNotNull;
                        element$iv$iv3 = element$iv$iv6;
                        item3 = item4;
                        element$iv$iv$iv4 = element$iv$iv$iv5;
                        String str622 = str2;
                        KUpPermissionType type22 = item3.getType();
                        if (attachments3 != null) {
                        }
                        z = false;
                        $this$forEach$iv$iv$iv2 = element$iv$iv;
                        element$iv$iv$iv6 = element$iv$iv$iv4;
                        tribeeContentConverterImpl4 = element$iv$iv3;
                        destination$iv$iv3 = destination$iv$iv;
                        r12 = new TribeePublishSettingItem.Switch(type22, str3, str622, z, false, false, 48, null);
                        it6 = it4;
                        permission2 = permission5;
                        $i$f$mapNotNull3 = $i$f$mapNotNullTo2;
                        $i$f$mapNotNull4 = $i$f$mapNotNullTo7;
                        $i$f$forEach4 = $i$f$mapNotNullTo8;
                        obj4 = obj2;
                        attachments4 = attachments5;
                        $result2 = $completion3;
                        $result = $result5;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv2;
                        $this$mapNotNull$iv = $this$mapNotNullTo$iv$iv3;
                        obj3 = obj4;
                        $i$f$mapNotNullTo3 = $i$f$forEach4;
                        $i$f$mapNotNullTo = $i$f$mapNotNull4;
                        $i$f$mapNotNullTo2 = $i$f$mapNotNull3;
                        it = it6;
                        destination$iv$iv = destination$iv$iv3;
                        if (r12 != null) {
                        }
                        attachments3 = attachments4;
                        tribeeContentConverterImpl2 = tribeeContentConverterImpl4;
                        element$iv$iv = $this$forEach$iv$iv$iv2;
                        obj = obj3;
                        if (it.hasNext()) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        tribeeContentConverterImpl = this;
        tribeeContentConverterImpl$getSettingItems$1 = new TribeeContentConverterImpl$getSettingItems$1(tribeeContentConverterImpl, continuation);
        Object $result72 = tribeeContentConverterImpl$getSettingItems$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeContentConverterImpl$getSettingItems$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object toContent(KParagraph $this$toContent, Continuation<? super ParagraphContent> continuation) {
        TribeeContentConverterImpl$toContent$1 tribeeContentConverterImpl$toContent$1;
        UrlAssetUploadState urlAssetUploadState;
        Object loadAsset;
        boolean isOrigin;
        List pics;
        List nodes;
        String joinToString$default;
        if (continuation instanceof TribeeContentConverterImpl$toContent$1) {
            tribeeContentConverterImpl$toContent$1 = (TribeeContentConverterImpl$toContent$1) continuation;
            if ((tribeeContentConverterImpl$toContent$1.label & Integer.MIN_VALUE) != 0) {
                tribeeContentConverterImpl$toContent$1.label -= Integer.MIN_VALUE;
                Object $result = tribeeContentConverterImpl$toContent$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (tribeeContentConverterImpl$toContent$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KParagraph.KParagraphType paraType = $this$toContent.getParaType();
                        if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.TEXT.INSTANCE)) {
                            KTextParagraph text = $this$toContent.getText();
                            return new TextContent((text == null || (nodes = text.getNodes()) == null || (joinToString$default = CollectionsKt.joinToString$default(nodes, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.app.tribee.publish.service.impl.TribeeContentConverterImpl$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj) {
                                    CharSequence content$lambda$0;
                                    content$lambda$0 = TribeeContentConverterImpl.toContent$lambda$0((KTextNode) obj);
                                    return content$lambda$0;
                                }
                            }, 31, (Object) null)) == null) ? "" : joinToString$default, null, null, 6, null);
                        } else if (Intrinsics.areEqual(paraType, KParagraph.KParagraphType.PICTURES.INSTANCE)) {
                            KPicParagraph pic = $this$toContent.getPic();
                            KPic pic2 = (pic == null || (pics = pic.getPics()) == null) ? null : (KPic) CollectionsKt.firstOrNull(pics);
                            if (pic2 == null) {
                                urlAssetUploadState = null;
                                break;
                            } else if (StringsKt.startsWith$default(pic2.getUrl(), "draft-", false, 2, (Object) null)) {
                                boolean isOrigin2 = StringsKt.startsWith$default(pic2.getUrl(), "draft-origin-", false, 2, (Object) null);
                                String pureIdentifier = StringsKt.removePrefix(StringsKt.removePrefix(pic2.getUrl(), "draft-origin-"), "draft-");
                                Gallery gallery = Gallery.INSTANCE;
                                tribeeContentConverterImpl$toContent$1.L$0 = SpillingKt.nullOutSpilledVariable($this$toContent);
                                tribeeContentConverterImpl$toContent$1.L$1 = SpillingKt.nullOutSpilledVariable(pic2);
                                tribeeContentConverterImpl$toContent$1.L$2 = SpillingKt.nullOutSpilledVariable(pureIdentifier);
                                tribeeContentConverterImpl$toContent$1.Z$0 = isOrigin2;
                                tribeeContentConverterImpl$toContent$1.label = 1;
                                loadAsset = gallery.loadAsset(pureIdentifier, tribeeContentConverterImpl$toContent$1);
                                if (loadAsset == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                isOrigin = isOrigin2;
                                Asset it = (Asset) loadAsset;
                                urlAssetUploadState = it == null ? new OriginAssetUploadState(it, isOrigin) : null;
                                break;
                            } else {
                                urlAssetUploadState = new UrlAssetUploadState(null, new ImageUploadResult(pic2.getUrl(), (long) pic2.getWidth(), (long) pic2.getHeight(), ContentSizeKt.bytes(pic2.getSize()), pic2.getAiGenPic(), null));
                                break;
                            }
                        } else {
                            return null;
                        }
                        break;
                    case 1:
                        isOrigin = tribeeContentConverterImpl$toContent$1.Z$0;
                        String str = (String) tribeeContentConverterImpl$toContent$1.L$2;
                        KPic kPic = (KPic) tribeeContentConverterImpl$toContent$1.L$1;
                        KParagraph kParagraph = (KParagraph) tribeeContentConverterImpl$toContent$1.L$0;
                        ResultKt.throwOnFailure($result);
                        loadAsset = $result;
                        Asset it2 = (Asset) loadAsset;
                        urlAssetUploadState = it2 == null ? new OriginAssetUploadState(it2, isOrigin) : null;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AssetUploadState uploadState = urlAssetUploadState;
                return uploadState != null ? new AssetContent(uploadState) : null;
            }
        }
        tribeeContentConverterImpl$toContent$1 = new TribeeContentConverterImpl$toContent$1(this, continuation);
        Object $result2 = tribeeContentConverterImpl$toContent$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (tribeeContentConverterImpl$toContent$1.label) {
        }
        AssetUploadState uploadState2 = urlAssetUploadState;
        return uploadState2 != null ? new AssetContent(uploadState2) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toContent$lambda$0(KTextNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KWordNode word = it.getWord();
        return (word == null || (r0 = word.getWords()) == null) ? "" : "";
    }

    private final KParagraph toContent(ParagraphContent $this$toContent, boolean toDraft) {
        if ($this$toContent instanceof TextContent) {
            return toPublishContent((TextContent) $this$toContent, toDraft);
        }
        if ($this$toContent instanceof AssetContent) {
            return toPublishContent((AssetContent) $this$toContent, toDraft);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final KParagraph toPublishContent(AssetContent $this$toPublishContent, boolean toDraft) {
        Asset asset;
        String it;
        String prefix;
        AssetUploadState state = $this$toPublishContent.getUploadState();
        if (state instanceof UrlAssetUploadState) {
            return new KParagraph(KParagraph.KParagraphType.PICTURES.INSTANCE, new KParagraph.KParagraphFormat(KParagraph.KParagraphAlign.MIDDLE.INSTANCE, (KParagraph.KListFormat) null, (KParagraph.KIndentFormat) null, (String) null, (KParagraph.KHeadingType) null, 30, (DefaultConstructorMarker) null), (KTextParagraph) null, new KPicParagraph(CollectionsKt.listOf(new KPic(((UrlAssetUploadState) state).getResult().getImageUrl(), ((UrlAssetUploadState) state).getResult().getImageWidth(), ((UrlAssetUploadState) state).getResult().getImageHeight(), ContentSize.m2187getBytesimpl(((UrlAssetUploadState) state).getResult().m2148getImageSizeQJZHGII()), (String) null, false, 0.0d, 0.0d, (String) null, (String) null, ((UrlAssetUploadState) state).getResult().getAiGenPic(), 976, (DefaultConstructorMarker) null)), (KPicParagraph.KPicParagraphStyle) null, 2, (DefaultConstructorMarker) null), (KLineParagraph) null, (KCardParagraph) null, (KCodeParagraph) null, 116, (DefaultConstructorMarker) null);
        } else if (!toDraft || (asset = $this$toPublishContent.getAsset()) == null || (it = asset.getIdentifier()) == null) {
            return null;
        } else {
            if (state.getUseOrigin()) {
                prefix = "draft-origin-";
            } else {
                prefix = "draft-";
            }
            return new KParagraph(KParagraph.KParagraphType.PICTURES.INSTANCE, new KParagraph.KParagraphFormat(KParagraph.KParagraphAlign.MIDDLE.INSTANCE, (KParagraph.KListFormat) null, (KParagraph.KIndentFormat) null, (String) null, (KParagraph.KHeadingType) null, 30, (DefaultConstructorMarker) null), (KTextParagraph) null, new KPicParagraph(CollectionsKt.listOf(new KPic(prefix + it, 0.0d, 0.0d, 0.0d, (String) null, false, 0.0d, 0.0d, (String) null, (String) null, 0, 2000, (DefaultConstructorMarker) null)), (KPicParagraph.KPicParagraphStyle) null, 2, (DefaultConstructorMarker) null), (KLineParagraph) null, (KCardParagraph) null, (KCodeParagraph) null, 116, (DefaultConstructorMarker) null);
        }
    }

    private final KParagraph toPublishContent(TextContent $this$toPublishContent, boolean toDraft) {
        String it = $this$toPublishContent.getContent();
        String it2 = it.length() > 0 ? it : null;
        if (it2 != null) {
            return new KParagraph(KParagraph.KParagraphType.TEXT.INSTANCE, new KParagraph.KParagraphFormat(KParagraph.KParagraphAlign.LEFT.INSTANCE, (KParagraph.KListFormat) null, (KParagraph.KIndentFormat) null, (String) null, (KParagraph.KHeadingType) null, 30, (DefaultConstructorMarker) null), new KTextParagraph(CollectionsKt.listOf(new KTextNode(KTextNode.KTextNodeType.WORDS.INSTANCE, new KWordNode(it2, 0.0d, (String) null, (String) null, (KWordNode.KWordNodeStyle) null, "regular", (String) null, (KBgStyle) null, (String) null, 478, (DefaultConstructorMarker) null), (KEmoteNode) null, (KLinkNode) null, (KFormulaNode) null, 28, (DefaultConstructorMarker) null))), (KPicParagraph) null, (KLineParagraph) null, (KCardParagraph) null, (KCodeParagraph) null, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (DefaultConstructorMarker) null);
        }
        return null;
    }
}