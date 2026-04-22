package tv.danmaku.bili.ui.appeal;

public class ImageUploadException extends Exception {
    public int code;

    public ImageUploadException(int code, String message) {
        super(message);
        this.code = code;
    }
}