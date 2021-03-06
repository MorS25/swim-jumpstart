/*
 * Copyright (c) 2020 L3Harris Technologies
 */
package com.l3harris.swim.outputs;

import com.typesafe.config.Config;
import org.json.JSONObject;
import org.json.XML;

public abstract class Output {
    private Config config;

    public Output(Config config) {
        this.config = config;
    }

    public abstract void output(String message);

    protected String convert(String message) {
        if (this.config.getBoolean("json")) {
            JSONObject xmlJSONObj = XML.toJSONObject(message);
            return xmlJSONObj.toString();
        } else {
            return message;
        }
    }
}
