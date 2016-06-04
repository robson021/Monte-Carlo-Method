package robert.model;

import java.awt.*;
import java.util.Random;

/**
 * Created by robert on 03.06.16.
 */
public class Conditions {
    private static Conditions self = null;
    private static final int RANGE = 25;
    private Random r = new Random();
    private Color[] colors;

    private Conditions() {
        colors = new Color[RANGE];
        for (int i = 0; i < RANGE; i++) {
            colors[i] = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
        }
    }

    public Color getRandomColor() {
        return colors[r.nextInt(RANGE)];
    }

    public static Conditions getConditions() {
        if (self == null) {
            self = new Conditions();
            System.out.println("Singleton init");
        }
        return self;
    }
}
