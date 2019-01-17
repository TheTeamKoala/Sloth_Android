package com.koala.sloth.TabOrder;

import android.graphics.drawable.Drawable;

public class ListView_Item {
    private final Drawable picture;
    private final String name;



    public ListView_Item(Drawable picture, String name) {
        this.picture = picture;
        this.name = name;
    }

    public Drawable getPicture() {
        return picture;
    }
    public String getName() {
        return name;
    }

}
