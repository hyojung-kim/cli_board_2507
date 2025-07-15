package com.ll;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Container.init();
        new app().run();
        Container.close();
//        app App = new app(sc);
//        App.run();


    }
}
