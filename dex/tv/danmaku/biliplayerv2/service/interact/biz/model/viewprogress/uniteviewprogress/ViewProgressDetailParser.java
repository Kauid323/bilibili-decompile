package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import com.bapis.bilibili.app.view.v1.Attention;
import com.bapis.bilibili.app.viewunite.v1.FragmentRes;
import com.bapis.bilibili.app.viewunite.v1.ViewProgressReply;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ViewProgressParser.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002J\n\u0010\u000b\u001a\u00020\u000e*\u00020\u000fJ\n\u0010\u000b\u001a\u00020\u0010*\u00020\u0011¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetailParser;", "", "<init>", "()V", "generateUniteViewProgressDetail", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ViewProgressDetail;", "uniteViewProgressReply", "Lcom/bapis/bilibili/app/viewunite/v1/ViewProgressReply;", "generateViewProgressDetail", "viewProgressReply", "Lcom/bapis/bilibili/app/view/v1/ViewProgressReply;", "transform", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/Material;", "Lcom/bapis/bilibili/app/viewunite/v1/Material;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoFragmentRes;", "Lcom/bapis/bilibili/app/viewunite/v1/FragmentRes;", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoShot;", "Lcom/bapis/bilibili/app/viewunite/v1/VideoShot;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ViewProgressDetailParser {
    public static final ViewProgressDetailParser INSTANCE = new ViewProgressDetailParser();

    /* compiled from: ViewProgressParser.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            int[] iArr = new int[com.bapis.bilibili.app.viewunite.v1.MaterialSource.values().length];
            try {
                iArr[com.bapis.bilibili.app.viewunite.v1.MaterialSource.BIJIAN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[com.bapis.bilibili.app.view.v1.MaterialSource.values().length];
            try {
                iArr2[com.bapis.bilibili.app.view.v1.MaterialSource.BiJian.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.values().length];
            try {
                iArr3[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr3[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr3[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.BGM.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr3[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.EFFECT.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr3[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.SHOOT_SAME.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr3[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.SHOOT_TOGETHER.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr3[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.ACTIVITY_ICON.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr3[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.NEW_BGM.ordinal()] = 8;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr3[com.bapis.bilibili.app.viewunite.v1.MaterialBizType.GENERAL_TYPE.ordinal()] = 9;
            } catch (NoSuchFieldError e11) {
            }
            $EnumSwitchMapping$2 = iArr3;
            int[] iArr4 = new int[com.bapis.bilibili.app.viewunite.v1.PageType.values().length];
            try {
                iArr4[com.bapis.bilibili.app.viewunite.v1.PageType.H5.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr4[com.bapis.bilibili.app.viewunite.v1.PageType.NA.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            $EnumSwitchMapping$3 = iArr4;
        }
    }

    private ViewProgressDetailParser() {
    }

    public final ViewProgressDetail generateUniteViewProgressDetail(ViewProgressReply uniteViewProgressReply) {
        Intrinsics.checkNotNullParameter(uniteViewProgressReply, "uniteViewProgressReply");
        ViewProgressDetail detail = new ViewProgressDetail();
        detail.setOriginData(uniteViewProgressReply);
        if (uniteViewProgressReply.hasVideoGuide()) {
            VideoGuide videoGuide = new VideoGuide();
            Iterable materialList = uniteViewProgressReply.getVideoGuide().getMaterialList();
            Intrinsics.checkNotNullExpressionValue(materialList, "getMaterialList(...)");
            Iterable $this$forEach$iv = materialList;
            for (Object element$iv : $this$forEach$iv) {
                com.bapis.bilibili.app.viewunite.v1.Material it = (com.bapis.bilibili.app.viewunite.v1.Material) element$iv;
                ArrayList<Material> materialList2 = videoGuide.getMaterialList();
                ViewProgressDetailParser viewProgressDetailParser = INSTANCE;
                Intrinsics.checkNotNull(it);
                materialList2.add(viewProgressDetailParser.transform(it));
            }
            if (uniteViewProgressReply.getVideoGuide().hasVideoPoint()) {
                VideoViewPoint videoViewPoint = new VideoViewPoint();
                Iterable pointsList = uniteViewProgressReply.getVideoGuide().getVideoPoint().getPointsList();
                Intrinsics.checkNotNullExpressionValue(pointsList, "getPointsList(...)");
                Iterable $this$forEach$iv2 = pointsList;
                for (Object element$iv2 : $this$forEach$iv2) {
                    com.bapis.bilibili.app.viewunite.v1.VideoPoint it2 = (com.bapis.bilibili.app.viewunite.v1.VideoPoint) element$iv2;
                    VideoPoint videoPoint = new VideoPoint();
                    videoPoint.setType(it2.getType());
                    videoPoint.setFrom(it2.getFrom());
                    videoPoint.setTo(it2.getTo());
                    videoPoint.setContent(it2.getContent());
                    videoPoint.setCover(it2.getCover());
                    videoPoint.setLogoUrl(it2.getLogoUrl());
                    videoPoint.setTeamType(it2.getTeamType());
                    videoPoint.setTeamName(it2.getTeamName());
                    videoViewPoint.getVideoPointList().add(videoPoint);
                }
                if (uniteViewProgressReply.getVideoGuide().getVideoPoint().hasPointMaterial()) {
                    PointMaterial pointMaterial = new PointMaterial();
                    pointMaterial.setUrl(uniteViewProgressReply.getVideoGuide().getVideoPoint().getPointMaterial().getUrl());
                    com.bapis.bilibili.app.viewunite.v1.MaterialSource materialSource = uniteViewProgressReply.getVideoGuide().getVideoPoint().getPointMaterial().getMaterialSource();
                    pointMaterial.setMaterialSource((materialSource == null ? -1 : WhenMappings.$EnumSwitchMapping$0[materialSource.ordinal()]) == 1 ? MaterialSource.BIJIAN : MaterialSource.DEFAULT);
                    videoViewPoint.setPointMaterial(pointMaterial);
                }
                videoViewPoint.setPointPermanent(uniteViewProgressReply.getVideoGuide().getVideoPoint().getPointPermanent());
                videoGuide.setVideoPoint(videoViewPoint);
            }
            if (uniteViewProgressReply.getVideoGuide().hasContractCard()) {
                ContractCard contractCard = new ContractCard();
                contractCard.setDisplayProgress(uniteViewProgressReply.getVideoGuide().getContractCard().getDisplayProgress());
                contractCard.setDisplayAccuracy(uniteViewProgressReply.getVideoGuide().getContractCard().getDisplayAccuracy());
                contractCard.setDisplayDuration(uniteViewProgressReply.getVideoGuide().getContractCard().getDisplayDuration());
                contractCard.setShowMode(uniteViewProgressReply.getVideoGuide().getContractCard().getShowMode());
                contractCard.setPageType(uniteViewProgressReply.getVideoGuide().getContractCard().getPageType());
                contractCard.setFollowDisplay(uniteViewProgressReply.getVideoGuide().getContractCard().getIsFollowDisplay());
                if (uniteViewProgressReply.getVideoGuide().getContractCard().hasText()) {
                    ContractText contractText = new ContractText();
                    contractText.setTitle(uniteViewProgressReply.getVideoGuide().getContractCard().getText().getTitle());
                    contractText.setSubtitle(uniteViewProgressReply.getVideoGuide().getContractCard().getText().getSubtitle());
                    contractText.setInlineTitle(uniteViewProgressReply.getVideoGuide().getContractCard().getText().getInlineTitle());
                    contractCard.setText(contractText);
                }
                contractCard.setFollowDisplayEndDuration(uniteViewProgressReply.getVideoGuide().getContractCard().getFollowDisplayEndDuration());
                contractCard.setPlayDisplay(uniteViewProgressReply.getVideoGuide().getContractCard().getIsPlayDisplay());
                contractCard.setInteractDisplay(uniteViewProgressReply.getVideoGuide().getContractCard().getIsInteractDisplay());
                contractCard.setPlayDisplaySwitch(uniteViewProgressReply.getVideoGuide().getContractCard().getPlayDisplaySwitch());
            }
            if (uniteViewProgressReply.getVideoGuide().hasRightMaterial()) {
                com.bapis.bilibili.app.viewunite.v1.Material rightMaterial = uniteViewProgressReply.getVideoGuide().getRightMaterial();
                Intrinsics.checkNotNullExpressionValue(rightMaterial, "getRightMaterial(...)");
                videoGuide.setRightMaterial(transform(rightMaterial));
            }
            detail.setVideoGuide(videoGuide);
        }
        if (uniteViewProgressReply.hasChronos()) {
            Chronos chronos = new Chronos();
            chronos.setMd5(uniteViewProgressReply.getChronos().getMd5());
            chronos.setFile(uniteViewProgressReply.getChronos().getFile());
            chronos.setSign(uniteViewProgressReply.getChronos().getSign());
            detail.setChronos(chronos);
        }
        if (uniteViewProgressReply.hasArcShot()) {
            VideoShot videoShot = new VideoShot();
            videoShot.setPvData(uniteViewProgressReply.getArcShot().getPvData());
            videoShot.setImgXLen(uniteViewProgressReply.getArcShot().getImgXLen());
            videoShot.setImgYLen(uniteViewProgressReply.getArcShot().getImgYLen());
            videoShot.setImgXSize(uniteViewProgressReply.getArcShot().getImgXSize());
            videoShot.setImgYSize(uniteViewProgressReply.getArcShot().getImgYSize());
            Iterable imageList = uniteViewProgressReply.getArcShot().getImageList();
            Intrinsics.checkNotNullExpressionValue(imageList, "getImageList(...)");
            Iterable $this$forEach$iv3 = imageList;
            for (Object element$iv3 : $this$forEach$iv3) {
                videoShot.getImageList().add((String) element$iv3);
            }
            detail.setVideoShot(videoShot);
        }
        if (uniteViewProgressReply.hasFragmentRes()) {
            FragmentRes fragmentRes = uniteViewProgressReply.getFragmentRes();
            Intrinsics.checkNotNullExpressionValue(fragmentRes, "getFragmentRes(...)");
            detail.setFragmentRes(transform(fragmentRes));
        }
        if (uniteViewProgressReply.hasDm()) {
            DmResource dmResource = new DmResource();
            if (uniteViewProgressReply.getDm().hasAttention()) {
                AttentionCard attentionCard = new AttentionCard();
                Iterable showTimeList = uniteViewProgressReply.getDm().getAttention().getShowTimeList();
                Intrinsics.checkNotNullExpressionValue(showTimeList, "getShowTimeList(...)");
                Iterable $this$forEach$iv4 = showTimeList;
                for (Object element$iv4 : $this$forEach$iv4) {
                    com.bapis.bilibili.app.viewunite.v1.ShowTime it3 = (com.bapis.bilibili.app.viewunite.v1.ShowTime) element$iv4;
                    ShowTime showTime = new ShowTime();
                    showTime.setStartTime(it3.getStartTime());
                    showTime.setEndTime(it3.getEndTime());
                    showTime.setPosX(it3.getPosX());
                    showTime.setPosY(it3.getPosY());
                    attentionCard.getShowTimeList().add(showTime);
                }
                dmResource.setAttentionCard(attentionCard);
            }
            detail.setDmResource(dmResource);
        }
        return detail;
    }

    public final ViewProgressDetail generateViewProgressDetail(com.bapis.bilibili.app.view.v1.ViewProgressReply viewProgressReply) {
        Intrinsics.checkNotNullParameter(viewProgressReply, "viewProgressReply");
        ViewProgressDetail detail = new ViewProgressDetail();
        detail.setOriginData(viewProgressReply);
        if (viewProgressReply.hasVideoGuide()) {
            VideoGuide videoGuide = new VideoGuide();
            VideoViewPoint videoViewPoint = new VideoViewPoint();
            Iterable pointsList = viewProgressReply.getPointsList();
            Intrinsics.checkNotNullExpressionValue(pointsList, "getPointsList(...)");
            Iterable $this$forEach$iv = pointsList;
            for (Object element$iv : $this$forEach$iv) {
                com.bapis.bilibili.app.view.v1.VideoPoint it = (com.bapis.bilibili.app.view.v1.VideoPoint) element$iv;
                VideoPoint videoPoint = new VideoPoint();
                videoPoint.setType(it.getType());
                videoPoint.setFrom(it.getFrom());
                videoPoint.setTo(it.getTo());
                videoPoint.setContent(it.getContent());
                videoPoint.setCover(it.getCover());
                videoPoint.setLogoUrl(it.getLogoUrl());
                videoViewPoint.getVideoPointList().add(videoPoint);
            }
            if (viewProgressReply.hasPointMaterial()) {
                PointMaterial pointMaterial = new PointMaterial();
                pointMaterial.setUrl(viewProgressReply.getPointMaterial().getUrl());
                com.bapis.bilibili.app.view.v1.MaterialSource materialSource = viewProgressReply.getPointMaterial().getMaterialSource();
                pointMaterial.setMaterialSource((materialSource == null ? -1 : WhenMappings.$EnumSwitchMapping$1[materialSource.ordinal()]) == 1 ? MaterialSource.BIJIAN : MaterialSource.DEFAULT);
                videoViewPoint.setPointMaterial(pointMaterial);
            }
            videoViewPoint.setPointPermanent(viewProgressReply.getPointPermanent());
            videoGuide.setVideoPoint(videoViewPoint);
            if (viewProgressReply.getVideoGuide().hasContractCard()) {
                com.bapis.bilibili.app.view.v1.ContractCard remoteContractCard = viewProgressReply.getVideoGuide().getContractCard();
                ContractCard $this$generateViewProgressDetail_u24lambda_u241 = new ContractCard();
                $this$generateViewProgressDetail_u24lambda_u241.setDisplayProgress(remoteContractCard.getDisplayProgress());
                $this$generateViewProgressDetail_u24lambda_u241.setDisplayAccuracy(remoteContractCard.getDisplayAccuracy());
                $this$generateViewProgressDetail_u24lambda_u241.setDisplayDuration(remoteContractCard.getDisplayDuration());
                $this$generateViewProgressDetail_u24lambda_u241.setShowMode(remoteContractCard.getShowMode());
                $this$generateViewProgressDetail_u24lambda_u241.setPageType(remoteContractCard.getPageType());
                $this$generateViewProgressDetail_u24lambda_u241.setFollowDisplay(remoteContractCard.getIsFollowDisplay());
                if (remoteContractCard.hasText()) {
                    com.bapis.bilibili.app.view.v1.ContractText remoteText = remoteContractCard.getText();
                    ContractText $this$generateViewProgressDetail_u24lambda_u241_u240 = new ContractText();
                    $this$generateViewProgressDetail_u24lambda_u241_u240.setTitle(remoteText.getTitle());
                    $this$generateViewProgressDetail_u24lambda_u241_u240.setSubtitle(remoteText.getSubtitle());
                    $this$generateViewProgressDetail_u24lambda_u241_u240.setInlineTitle(remoteText.getInlineTitle());
                    $this$generateViewProgressDetail_u24lambda_u241.setText($this$generateViewProgressDetail_u24lambda_u241_u240);
                }
                $this$generateViewProgressDetail_u24lambda_u241.setFollowDisplayEndDuration(remoteContractCard.getFollowDisplayEndDuration());
                $this$generateViewProgressDetail_u24lambda_u241.setPlayDisplay(remoteContractCard.getIsPlayDisplay());
                $this$generateViewProgressDetail_u24lambda_u241.setInteractDisplay(remoteContractCard.getIsInteractDisplay());
                $this$generateViewProgressDetail_u24lambda_u241.setPlayDisplaySwitch(remoteContractCard.getPlayDisplaySwitch());
            }
            detail.setVideoGuide(videoGuide);
            DmResource dmResource = new DmResource();
            AttentionCard attentionCard = new AttentionCard();
            Iterable attentionList = viewProgressReply.getVideoGuide().getAttentionList();
            Intrinsics.checkNotNullExpressionValue(attentionList, "getAttentionList(...)");
            Iterable $this$forEach$iv2 = attentionList;
            for (Object element$iv2 : $this$forEach$iv2) {
                Attention it2 = (Attention) element$iv2;
                ShowTime showTime = new ShowTime();
                showTime.setStartTime(it2.getStartTime());
                showTime.setEndTime(it2.getEndTime());
                showTime.setPosX(it2.getPosX());
                showTime.setPosY(it2.getPosY());
                attentionCard.getShowTimeList().add(showTime);
            }
            dmResource.setAttentionCard(attentionCard);
            detail.setDmResource(dmResource);
        }
        if (viewProgressReply.hasChronos()) {
            Chronos chronos = new Chronos();
            chronos.setMd5(viewProgressReply.getChronos().getMd5());
            chronos.setFile(viewProgressReply.getChronos().getFile());
            chronos.setSign(viewProgressReply.getChronos().getSign());
            detail.setChronos(chronos);
        }
        if (viewProgressReply.hasArcShot()) {
            VideoShot videoShot = new VideoShot();
            videoShot.setPvData(viewProgressReply.getArcShot().getPvData());
            videoShot.setImgXLen(viewProgressReply.getArcShot().getImgXLen());
            videoShot.setImgYLen(viewProgressReply.getArcShot().getImgYLen());
            videoShot.setImgXSize(viewProgressReply.getArcShot().getImgXSize());
            videoShot.setImgYSize(viewProgressReply.getArcShot().getImgYSize());
            Iterable imageList = viewProgressReply.getArcShot().getImageList();
            Intrinsics.checkNotNullExpressionValue(imageList, "getImageList(...)");
            Iterable $this$forEach$iv3 = imageList;
            for (Object element$iv3 : $this$forEach$iv3) {
                videoShot.getImageList().add((String) element$iv3);
            }
            detail.setVideoShot(videoShot);
        }
        return detail;
    }

    private final Material transform(com.bapis.bilibili.app.viewunite.v1.Material $this$transform) {
        MaterialBizType materialBizType;
        PageType pageType;
        Material $this$transform_u24lambda_u240 = new Material();
        $this$transform_u24lambda_u240.setIcon($this$transform.getIcon());
        $this$transform_u24lambda_u240.setText($this$transform.getText());
        $this$transform_u24lambda_u240.setUrl($this$transform.getUrl());
        com.bapis.bilibili.app.viewunite.v1.MaterialBizType type = $this$transform.getType();
        switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$2[type.ordinal()]) {
            case 1:
                materialBizType = MaterialBizType.NONE;
                break;
            case 2:
                materialBizType = MaterialBizType.ACTIVITY;
                break;
            case 3:
                materialBizType = MaterialBizType.BGM;
                break;
            case 4:
                materialBizType = MaterialBizType.EFFECT;
                break;
            case 5:
                materialBizType = MaterialBizType.SHOOT_SAME;
                break;
            case 6:
                materialBizType = MaterialBizType.SHOOT_TOGETHER;
                break;
            case 7:
                materialBizType = MaterialBizType.ACTIVITY_ICON;
                break;
            case 8:
                materialBizType = MaterialBizType.NEW_BGM;
                break;
            case 9:
                materialBizType = MaterialBizType.GENERAL_TYPE;
                break;
            default:
                materialBizType = MaterialBizType.NONE;
                break;
        }
        $this$transform_u24lambda_u240.setType(materialBizType);
        $this$transform_u24lambda_u240.setParam($this$transform.getParam());
        $this$transform_u24lambda_u240.setStaticIcon($this$transform.getStaticIcon());
        $this$transform_u24lambda_u240.setBgColor($this$transform.getBgColor());
        $this$transform_u24lambda_u240.setBgPic($this$transform.getBgPic());
        $this$transform_u24lambda_u240.setJumpType($this$transform.getJumpType());
        com.bapis.bilibili.app.viewunite.v1.PageType pageType2 = $this$transform.getPageType();
        switch (pageType2 != null ? WhenMappings.$EnumSwitchMapping$3[pageType2.ordinal()] : -1) {
            case 1:
                pageType = PageType.H5;
                break;
            case 2:
                pageType = PageType.NA;
                break;
            default:
                pageType = PageType.H5;
                break;
        }
        $this$transform_u24lambda_u240.setPageType(pageType);
        $this$transform_u24lambda_u240.setNeedLogin($this$transform.getNeedLogin());
        $this$transform_u24lambda_u240.setReport($this$transform.getReport());
        return $this$transform_u24lambda_u240;
    }

    public final VideoFragmentRes transform(FragmentRes $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        VideoFragmentRes $this$transform_u24lambda_u241 = new VideoFragmentRes();
        Map $this$forEach$iv = $this$transform.getVideoShotMap();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "getVideoShotMap(...)");
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            Object key = element$iv.getKey();
            ViewProgressDetailParser viewProgressDetailParser = INSTANCE;
            Object value = element$iv.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
            $this$transform_u24lambda_u241.getVideoShotMap().put(key, viewProgressDetailParser.transform((com.bapis.bilibili.app.viewunite.v1.VideoShot) value));
        }
        return $this$transform_u24lambda_u241;
    }

    public final VideoShot transform(com.bapis.bilibili.app.viewunite.v1.VideoShot $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        VideoShot $this$transform_u24lambda_u242 = new VideoShot();
        $this$transform_u24lambda_u242.setPvData($this$transform.getPvData());
        $this$transform_u24lambda_u242.setImgXLen($this$transform.getImgXLen());
        $this$transform_u24lambda_u242.setImgYLen($this$transform.getImgYLen());
        $this$transform_u24lambda_u242.setImgXSize($this$transform.getImgXSize());
        $this$transform_u24lambda_u242.setImgYSize($this$transform.getImgYSize());
        $this$transform_u24lambda_u242.getImageList().addAll($this$transform.getImageList());
        return $this$transform_u24lambda_u242;
    }
}