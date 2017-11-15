package com.onemena.live.video;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuhuan on 2017/11/14.
 */

public class VideoBean implements Serializable {


    List<Map<String, String>> params = new ArrayList<Map<String, String>>();

    public VideoBean addValue(String name, String url) {
        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        data.put("url", url);
        params.add(data);
        return this;
    }

    public Collection<Map<String, String>> values() {
        return params;
    }
}
