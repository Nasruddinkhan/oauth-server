package com.mypractice.oauth.server.oauthserver.exception;

public class UniqueConstraintException extends RuntimeException{
    public UniqueConstraintException(final String msg){
        super(msg);
    }
}
