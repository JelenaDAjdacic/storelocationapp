package com.ajdacicjelena.storelocationapp.network;


public interface WebRequestCallbackInterface<T> {
    void webRequestSuccess(boolean success, T t);

    void webRequestError(String error);
}
