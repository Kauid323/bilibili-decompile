package cmbapi;

public interface CMBPayCallback {
    void onError(String str);

    void onSuccess(String str);
}