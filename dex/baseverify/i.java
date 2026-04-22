package baseverify;

public interface i {
    void onError(String str, String str2);

    void onServerError(String str, String str2);

    void onSuccess(String str, String str2, String str3);
}