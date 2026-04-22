package tv.danmaku.bili.ui.rank.model;

import com.bapis.bilibili.app.show.rank.v1.Item;
import com.bapis.bilibili.app.show.rank.v1.ItemOrBuilder;
import com.bapis.bilibili.app.show.rank.v1.OfficialVerify;
import com.bapis.bilibili.app.show.rank.v1.Relation;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankModel.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0012\u001a\u00020\rH\u0096\u0001J\u0019\u0010\u0013\u001a\n \u0014*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0015\u001a\u00020\rH\u0096\u0001J\t\u0010\u0016\u001a\u00020\rH\u0096\u0001J-\u0010\u0017\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00030\u0003 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00190\u0018H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\u0011\u0010\u001c\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010\u001e\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\u0011\u0010 \u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010!\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\t\u0010\"\u001a\u00020\rH\u0096\u0001J\u0011\u0010#\u001a\n \u0014*\u0004\u0018\u00010$0$H\u0096\u0001J\t\u0010%\u001a\u00020\u001bH\u0096\u0001J\u0011\u0010&\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010'\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\t\u0010(\u001a\u00020\rH\u0096\u0001J\t\u0010)\u001a\u00020\u001bH\u0096\u0001J\u0011\u0010*\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010+\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\t\u0010,\u001a\u00020\rH\u0096\u0001J\t\u0010-\u001a\u00020\u001bH\u0096\u0001J\u0011\u0010.\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010/\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\u0011\u00100\u001a\n \u0014*\u0004\u0018\u00010101H\u0096\u0001J\u0011\u00102\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u00103\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\t\u00104\u001a\u00020\rH\u0096\u0001J\t\u00105\u001a\u00020\rH\u0096\u0001J\u0011\u00106\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u00107\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\t\u00108\u001a\u00020\u001bH\u0096\u0001J\t\u00109\u001a\u00020\u001bH\u0096\u0001J\u0011\u0010:\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010;\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\u0011\u0010<\u001a\n \u0014*\u0004\u0018\u00010=0=H\u0096\u0001J\t\u0010>\u001a\u00020\rH\u0096\u0001J\t\u0010?\u001a\u00020\rH\u0096\u0001J\u0011\u0010@\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010A\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\u0011\u0010B\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010C\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\u0011\u0010D\u001a\n \u0014*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010E\u001a\n \u0014*\u0004\u0018\u00010\u001f0\u001fH\u0096\u0001J\t\u0010F\u001a\u00020\u0007H\u0096\u0001J\t\u0010G\u001a\u00020\u0007H\u0096\u0001J\t\u0010H\u001a\u00020\u0007H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006I"}, d2 = {"Ltv/danmaku/bili/ui/rank/model/RankModel;", "Lcom/bapis/bilibili/app/show/rank/v1/ItemOrBuilder;", "pbData", "Lcom/bapis/bilibili/app/show/rank/v1/Item;", "<init>", "(Lcom/bapis/bilibili/app/show/rank/v1/Item;)V", "showMore", "", "getShowMore", "()Z", "setShowMore", "(Z)V", "rankModelType", "", "getRankModelType", "()I", "setRankModelType", "(I)V", "getAttribute", "getChildren", "kotlin.jvm.PlatformType", "index", "getChildrenCount", "getChildrenList", "", "", "getCid", "", "getCooperation", "", "getCooperationBytes", "Lcom/google/protobuf/ByteString;", "getCover", "getCoverBytes", "getDanmaku", "getDefaultInstanceForType", "Lcom/google/protobuf/MessageLite;", "getDuration", "getFace", "getFaceBytes", "getFavourite", "getFollower", "getGoto", "getGotoBytes", "getLike", "getMid", "getName", "getNameBytes", "getOfficialVerify", "Lcom/bapis/bilibili/app/show/rank/v1/OfficialVerify;", "getParam", "getParamBytes", "getPlay", "getPlayIcon", "getPlayText", "getPlayTextBytes", "getPts", "getPubDate", "getRedirectUrl", "getRedirectUrlBytes", "getRelation", "Lcom/bapis/bilibili/app/show/rank/v1/Relation;", "getReply", "getRid", "getRname", "getRnameBytes", "getTitle", "getTitleBytes", "getUri", "getUriBytes", "hasOfficialVerify", "hasRelation", "isInitialized", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankModel implements ItemOrBuilder {
    public static final int $stable = 8;
    private final Item pbData;
    private int rankModelType;
    private boolean showMore;

    public int getAttribute() {
        return this.pbData.getAttribute();
    }

    public Item getChildren(int i) {
        return this.pbData.getChildren(i);
    }

    public int getChildrenCount() {
        return this.pbData.getChildrenCount();
    }

    public List<Item> getChildrenList() {
        return this.pbData.getChildrenList();
    }

    public long getCid() {
        return this.pbData.getCid();
    }

    public String getCooperation() {
        return this.pbData.getCooperation();
    }

    public ByteString getCooperationBytes() {
        return this.pbData.getCooperationBytes();
    }

    public String getCover() {
        return this.pbData.getCover();
    }

    public ByteString getCoverBytes() {
        return this.pbData.getCoverBytes();
    }

    public int getDanmaku() {
        return this.pbData.getDanmaku();
    }

    public MessageLite getDefaultInstanceForType() {
        return this.pbData.getDefaultInstanceForType();
    }

    public long getDuration() {
        return this.pbData.getDuration();
    }

    public String getFace() {
        return this.pbData.getFace();
    }

    public ByteString getFaceBytes() {
        return this.pbData.getFaceBytes();
    }

    public int getFavourite() {
        return this.pbData.getFavourite();
    }

    public long getFollower() {
        return this.pbData.getFollower();
    }

    public String getGoto() {
        return this.pbData.getGoto();
    }

    public ByteString getGotoBytes() {
        return this.pbData.getGotoBytes();
    }

    public int getLike() {
        return this.pbData.getLike();
    }

    public long getMid() {
        return this.pbData.getMid();
    }

    public String getName() {
        return this.pbData.getName();
    }

    public ByteString getNameBytes() {
        return this.pbData.getNameBytes();
    }

    public OfficialVerify getOfficialVerify() {
        return this.pbData.getOfficialVerify();
    }

    public String getParam() {
        return this.pbData.getParam();
    }

    public ByteString getParamBytes() {
        return this.pbData.getParamBytes();
    }

    public int getPlay() {
        return this.pbData.getPlay();
    }

    public int getPlayIcon() {
        return this.pbData.getPlayIcon();
    }

    public String getPlayText() {
        return this.pbData.getPlayText();
    }

    public ByteString getPlayTextBytes() {
        return this.pbData.getPlayTextBytes();
    }

    public long getPts() {
        return this.pbData.getPts();
    }

    public long getPubDate() {
        return this.pbData.getPubDate();
    }

    public String getRedirectUrl() {
        return this.pbData.getRedirectUrl();
    }

    public ByteString getRedirectUrlBytes() {
        return this.pbData.getRedirectUrlBytes();
    }

    public Relation getRelation() {
        return this.pbData.getRelation();
    }

    public int getReply() {
        return this.pbData.getReply();
    }

    public int getRid() {
        return this.pbData.getRid();
    }

    public String getRname() {
        return this.pbData.getRname();
    }

    public ByteString getRnameBytes() {
        return this.pbData.getRnameBytes();
    }

    public String getTitle() {
        return this.pbData.getTitle();
    }

    public ByteString getTitleBytes() {
        return this.pbData.getTitleBytes();
    }

    public String getUri() {
        return this.pbData.getUri();
    }

    public ByteString getUriBytes() {
        return this.pbData.getUriBytes();
    }

    public boolean hasOfficialVerify() {
        return this.pbData.hasOfficialVerify();
    }

    public boolean hasRelation() {
        return this.pbData.hasRelation();
    }

    public boolean isInitialized() {
        return this.pbData.isInitialized();
    }

    public RankModel(Item pbData) {
        Intrinsics.checkNotNullParameter(pbData, "pbData");
        this.pbData = pbData;
    }

    public final boolean getShowMore() {
        return this.showMore;
    }

    public final void setShowMore(boolean z) {
        this.showMore = z;
    }

    public final int getRankModelType() {
        return this.rankModelType;
    }

    public final void setRankModelType(int i) {
        this.rankModelType = i;
    }
}