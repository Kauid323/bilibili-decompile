package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoShot.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR*\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u001aj\b\u0012\u0004\u0012\u00020\u0005`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/VideoShot;", "", "<init>", "()V", "pvData", "", "getPvData", "()Ljava/lang/String;", "setPvData", "(Ljava/lang/String;)V", "imgXLen", "", "getImgXLen", "()I", "setImgXLen", "(I)V", "imgYLen", "getImgYLen", "setImgYLen", "imgXSize", "getImgXSize", "setImgXSize", "imgYSize", "getImgYSize", "setImgYSize", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoShot {
    private ArrayList<String> imageList = new ArrayList<>();
    private int imgXLen;
    private int imgXSize;
    private int imgYLen;
    private int imgYSize;
    private String pvData;

    public final String getPvData() {
        return this.pvData;
    }

    public final void setPvData(String str) {
        this.pvData = str;
    }

    public final int getImgXLen() {
        return this.imgXLen;
    }

    public final void setImgXLen(int i) {
        this.imgXLen = i;
    }

    public final int getImgYLen() {
        return this.imgYLen;
    }

    public final void setImgYLen(int i) {
        this.imgYLen = i;
    }

    public final int getImgXSize() {
        return this.imgXSize;
    }

    public final void setImgXSize(int i) {
        this.imgXSize = i;
    }

    public final int getImgYSize() {
        return this.imgYSize;
    }

    public final void setImgYSize(int i) {
        this.imgYSize = i;
    }

    public final ArrayList<String> getImageList() {
        return this.imageList;
    }

    public final void setImageList(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.imageList = arrayList;
    }
}