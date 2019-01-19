package com.koala.sloth.TabOrder;

import android.graphics.drawable.Drawable;

public class Category_ListView_Item {
    private final Drawable picture;
    private final String name;



    public Category_ListView_Item(Drawable pictureP, String nameP) {
        picture = pictureP;
        name = nameP;
    }

    public Drawable getPicture() {
        return picture;
    }
    public String getName() {
        return name;
    }

}
