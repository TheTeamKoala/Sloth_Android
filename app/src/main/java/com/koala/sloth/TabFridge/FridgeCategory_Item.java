package com.koala.sloth.TabFridge;

import android.graphics.drawable.Drawable;

public class FridgeCategory_Item {

        private final Drawable picture;
        private final String name;
        private int number;



        public FridgeCategory_Item(Drawable pictureP, String nameP) {
            picture = pictureP;
            name = nameP;
            number = 0;
        }

        Drawable getPicture() {
            return picture;
        }
        public String getName() {
            return name;
        }
        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

}



