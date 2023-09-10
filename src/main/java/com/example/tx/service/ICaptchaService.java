package com.example.tx.service;

import com.example.tx.configuration.CaptchaProperties;

public interface ICaptchaService {

    public void processResponse(String response, String action);
}
