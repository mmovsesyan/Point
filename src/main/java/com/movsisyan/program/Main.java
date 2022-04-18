package com.movsisyan.program;

import com.movsisyan.model.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Point[] points = {new Point(5.4, 6.22), new Point(3.0, 3.1), new Point(4.2, 4.5), new Point(1.2, 9.0)};
        Point point = new Point(5.4, 6.22);
        Point point1 = new Point(3.0, 3.1);
//        System.out.println(Point.maxDistPoint(points));
//        System.out.println(Arrays.toString(Point.maxDistPoints(points)));
//        System.out.println(Point.centerMass(points));
//        System.out.println(Point.setDiam(points));
//        System.out.println(Point.maxPerimetr(points));
        System.out.println(new Point(3.0, 6.0).area(point, point1));
    }
}
