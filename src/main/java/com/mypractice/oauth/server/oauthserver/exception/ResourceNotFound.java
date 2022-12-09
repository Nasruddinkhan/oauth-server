package com.mypractice.oauth.server.oauthserver.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(final String msg){
        super(msg);
    }
}
