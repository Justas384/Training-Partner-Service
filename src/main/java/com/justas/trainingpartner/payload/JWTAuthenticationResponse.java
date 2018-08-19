package com.justas.trainingpartner.payload;

public class JWTAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer"; // TODO: consider making a global constant.

    public JWTAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}