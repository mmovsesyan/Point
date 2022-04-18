package com.movsisyan.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public class Point implements Comparable<Point> {
    private double x;
    private double y;

    public Point(double x, double y) {
        if (x == 0 || y == 0) {
            throw new IllegalArgumentException("Coordinates can't be zer0");
        }
        this.x = x;
        this.y = y;
    }

    public double dist() {
        return Math.hypot(this.x, this.y);
    }

    public double dist(Point other) {
        return Math.hypot((this.x - other.x), (this.y - other.y));
    }

    public Point addition(Point other) {
        return new Point(this.x + other.x, this.y + other.y);
    }

    public Point additionToInt(double a) {
        return new Point(this.x * a, this.y * a);
    }

    public Point divisionToInt(int a) {
        return new Point(this.x / a, this.y / a);
    }

    public double perimeter(Point p1, Point p2) {
        double dist = this.dist(p1);
        double dist1 = this.dist(p2);
        double dist2 = p1.dist(p2);
        return dist + dist1 + dist2;
    }

    public double area(Point p1, Point p2) {
        double a = this.dist(p1);
        double b = p1.dist(p2);
        double c = this.dist(p2);

        double p = this.perimeter(p1, p2) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * A: Самая дальняя точка(maxDistPoint)
     */
    public static Point maxDistPoint(Point[] points) {
        double max = Double.MIN_VALUE;
        Point res = null;
        for (Point point : points) {
            double dist = point.dist();
            if (dist > max) {
                max = dist;
                res = point;
            }
        }
        return res;
    }

    /**
     * A1: Самые дальние точки(maxDistPoints)
     */
    public static Point[] maxDistPoints(Point[] points) {
        List<Point> points1 = new ArrayList<>();
        Point point = maxDistPoint(points);
        for (Point value : points) {
            if (value.dist() == point.dist()) {
                points1.add(value);
            }
        }
        return points1.toArray(new Point[0]);
    }

    /**
     * D: Сортировка(sort)
     */
    public static Point[] sort(Point[] points) {
        Arrays.sort(points);
        return points;
    }

    /**
     * B: Центр масс(centerMass)
     */
    public static Point centerMass(Point[] points) {
        double a = 0;
        double b = 0;
        double count = 0;
        for (Point point : points) {
            a += point.x;
            b += point.y;
            count++;
        }
        return new Point(a / count, b / count);
    }

    /**
     * C: Диаметр множества(setDiam)
     * Выведите диаметр данного множества – максимальное расстояние между двумя данными точками. Для решения
     * этой задачи реализуйте и используйте перегрузку метода dist, который принимает на вход вторую
     * точку и возвращает расстояние между двумя данными точками.
     */
    public static double setDiam(Point[] points) {
        double maxDistance = Double.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = points[i].dist(points[j]);
                if (dist > maxDistance) {
                    maxDistance = dist;
                }
            }
        }
        return maxDistance;
    }

    /**
     * E: Максимальный периметр(maxPerimetr)
     */
    public static double maxPerimetr(Point[] points) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double perimeter = points[i].perimeter(points[j], points[k]);
                    if (perimeter > max) {
                        max = perimeter;
                    }
                }
            }
        }
        return max;
    }

    public static double maxArea(Point[] points) {
        double maxArea = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double area = points[i].area(points[j], points[k]);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    @Override
    public int compareTo(Point o) {
        return Double.compare(this.dist(), o.dist());
    }


}
