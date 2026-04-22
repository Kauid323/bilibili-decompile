package tv.danmaku.ijk.media.player.utils;

public class IjkMp4FrameInfo {
    public final int frameNumber;
    public final int height;
    public final int width;
    public final int xOffset = 0;
    public final int yOffset = 0;
    public final BlendOperation blendOperation = BlendOperation.NO_BLEND;
    public final DisposalMethod disposalMethod = DisposalMethod.DISPOSE_DO_NOT;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum BlendOperation {
        BLEND_WITH_PREVIOUS,
        NO_BLEND
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public IjkMp4FrameInfo(int frameNumber, int width, int height) {
        this.frameNumber = frameNumber;
        this.width = width;
        this.height = height;
    }
}