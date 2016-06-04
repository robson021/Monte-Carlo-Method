package robert.model;

import java.awt.*;
import java.util.Random;

/**
 * Created by robert on 03.06.16.
 */
public class Conditions {
    private static Conditions self = null;
    public static final int RANGE = 11; // type of colors and IDs
    private Random r = new Random();
    private Color[] colors;

    private Conditions() {
        colors = new Color[RANGE];
        initNewColors();
    }

    public void initNewColors() {
        for (int i = 0; i < RANGE; i++) {
            colors[i] = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
        }
    }

    public Color getColorById(int id) {
        return colors[id];
    }

    public static Conditions getConditions() {
        if (self == null) {
            self = new Conditions();
            System.out.println("Singleton init");
        }
        return self;
    }

    public int getRandomId() {
        return r.nextInt(RANGE);
    }
}
